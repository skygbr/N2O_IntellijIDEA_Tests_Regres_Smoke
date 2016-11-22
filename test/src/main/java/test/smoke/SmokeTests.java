package test.smoke;

import businessFramework.entities.smoke.SmokeData;
import businessFramework.entities.smoke.TestCoverageItem;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.Tree;
import net.framework.autotesting.meta.components.ComponentBase;
import net.framework.autotesting.test.TestBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class SmokeTests extends TestBase
{

    FillComponents fillComponents = new FillComponents();
    public static final String[] ComponentCssClasses = new String[]
    {
        // Создадим список, где будут css-классы всех компонентов, которые поддерживаются программой.
        ".n2o-multi-classifier",
        ".n2o-classifier",
        ".n2o-datepicker",
        ".n2o-checkbox",
        ".n2o-textarea",
        ".n2o-input.n2o-text-masked",
        ".n2o-select",
        ".n2o-radio-group",
        ".n2o-text",
        ".n2o-dateinterval",
        ".n2o-select-tree"
    };

    static Log log = LogFactory.getLog(SmokeTests.class);

    List<ContainerIdentifier> containersWithNoErrors = new ArrayList<ContainerIdentifier>(); // Список id тех контейнеров, в которых не найден error-alert (Имя страницы - название контейнера)
    List<ContainerIdentifier> containersWithErrors   = new ArrayList<ContainerIdentifier>(); // Список id тех контейнеров, в которых найден error-alert (Имя страницы - название контейнера)
    boolean isDebug                                  = false;
    boolean generateHTML                             = false;
    SmokeData allData                                = new SmokeData();
    ErrorsSearchers errorsSearchers;
    ButtonsActions buttonsActions;
    TestExclusions exclusions;
    TestInclusions inclusions;
    CheckStatus checkStatus;

    DebugLogs debugLogs;

    // Тут создаем список containersInformation. Для определения, в каком контейнере какие кнопки. Вся информация содержится в классе ContainerInfo.
    // ContainerIdentifier нужен для того, чтоб по pageHerf можно было уникально определить название контейнера, тк на разных страницах могут быть одинаковые названия контейнеров.
    Map<ContainerIdentifier, ContainerInfo> containersInformation = new HashMap<ContainerIdentifier, ContainerInfo>();
    // Объекты для блокировки; чтобы параллельные вызовы testCreateRecord не работали в одном контейнере.
    Map<ContainerIdentifier, Object> containerLocks;

    /**
     * page href для предыдущего успешного теста step5 в текущем потоке
     */
    ThreadLocal<String> step5_currentPageHref = new ThreadLocal<String>();

    ReadWriteLock seleniumRWLock = new ReentrantReadWriteLock();

    /**
     * В конструкторе получаем значения переменных окружения, в которых хранятся значения параметров исключений страниц и контейнеров.
     */
    public SmokeTests()
    {
        buttonsActions  = new ButtonsActions();
        errorsSearchers = new ErrorsSearchers();
        checkStatus     = new CheckStatus();

        // Получим значения исключений - контейнеров и исключений - страниц.
        String exclusionsStringEnvironmentVariable = System.getenv("N2O_AUTOMATION_EXCLUSIONS");
        String inclusionsStringEnvironmentVariable = System.getenv("N2O_AUTOMATION_INCLUSIONS");

        // Получим значения переменных, отвечающих за режим отладки и генерацию HTML-разметки.
        generateHTML    = "true".equalsIgnoreCase(System.getenv("SMOKE_GENERATE_HTML"));
        isDebug         = "true".equalsIgnoreCase(System.getenv("SMOKE_DEBUG"));

        if (exclusionsStringEnvironmentVariable == null)
        {
            exclusions = new TestExclusions("");
        }
        else
        {
            exclusions = new TestExclusions(exclusionsStringEnvironmentVariable);
        }

        if (inclusionsStringEnvironmentVariable != null && !inclusionsStringEnvironmentVariable.isEmpty())
        {
            inclusions = new TestInclusions(inclusionsStringEnvironmentVariable);
        }
        else
        {
            inclusions = null;
        }

        debugLogs = new DebugLogs(isDebug);

        String envVarAllowInvalidTlsCertificate = System.getenv("N2O_SMOKE_TEST_TLS_CERT_ALLOW_INVALID");
        if (envVarAllowInvalidTlsCertificate != null && envVarAllowInvalidTlsCertificate.toLowerCase().equals("true"))
        {
            System.out.println("N2O_SMOKE_TEST_TLS_CERT_ALLOW_INVALID = true, disabling TLS certificate validation");

            try
            {
                TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        @Override
                        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
                        {
                        }
                        @Override
                        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                        }
                    }
                };

                SSLContext ctx = null;
                ctx = SSLContext.getInstance("TLS");
                ctx.init(new KeyManager[0], trustAllCerts, new SecureRandom());
                ctx.setDefault(ctx);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    @BeforeMethod
    public void assert_504()
    {
        seleniumRWLock.readLock().lock();
    }

    /**
     * Очистка NetworkEventActors
     */
    @AfterMethod
    public void afterTestMethod(ITestResult testResult)
    {
        seleniumRWLock.readLock().unlock();
        if (testResult.getMethod().getMethodName() == "testTableSort" && testResult.getStatus() != ITestResult.SUCCESS)
        {
            step5_currentPageHref.remove();
        }
        app.getActor().resetNetworkEventActors();
    }

    /**
     * Генерирует разметку HTML после выполнения всех тестов.
     */
    @AfterSuite
    public void afterSuite() throws IOException
    {
        if (generateHTML)
        {
            createFormattedExceptionsString();
            allData.generateHtml(isDebug, null);
        }
    }

    Object[][] findPagesData = null;

    @Test
    public void findPages()
    {
//        checkStatus.checkHTTPStatus(debugLogs); // Проверка - доступен ли сервер
        app.getNavigationHelper().openMainPage(); // Открываем главную страницу, чтоб с разметки получить список всех страниц

        //Выбор первого контекста
        page.getHeader().takeContext().click();
        app.getBaseHelperWithWebDriver().findElement(By.xpath("//a[contains(@class, 'n2o-header-contextNode')]"), page.getHeader().takeHeader()).click();


        // Получаю список всех страниц
        // Будет Json-формат, в котором будут значения - pageHref, название модуля, название страницы и название подстраницы.
        app.getBaseHelperWithWebDriver().waitForNetworkAndJsIdle();// Ожидание загрузки страницы
        List<String> pagesJsons = (List<String>)app.getBaseHelperWithWebDriver().executeJavaScript(
                "var a = []; " +
                "var list = $('.module-spaces li a[data-page-id]'); " +
                "for (var i = 0; i < list.length; ++i) " +
                "{ var el = list[i]; " +
                    "if($(list[i]).attr(\"href\") != '#') " +
                        "a.push(JSON.stringify({ " +
                        "pageHref: $(el).attr('href'), " +
                        "moduleName: $(el).closest('ul.nav[data-module-name]').attr('data-module-name').trim(), " +
                        "pageName: $(el).closest('ul').attr('data-module-id') ?  $(el).text().trim() : $(el).closest('li.dropdown').children('a.dropdown-toggle').text().trim(), " +
                        "subPageName: $(el).text().trim() " +
                        "})) " +
                "} " +
                "return a;");

        if (pagesJsons.size() == 0)
        {
            throw new RuntimeException("Main page contains no module spaces.");
        }

        List<String> pageHrefs = new ArrayList<String>();

        // Обработаем получившийся json.
        for (String pageJsonString: pagesJsons)
        {
            JsonObject pageJson = new Gson().fromJson(pageJsonString, JsonObject.class);

            // Получим значения.
            String pageHref     = pageJson.get("pageHref").getAsString();
            String moduleName   = pageJson.get("moduleName").getAsString();
            String pageName     = pageJson.get("pageName").getAsString();
            String subPageName  = pageJson.get("subPageName").getAsString();

            // Запомним их в переменной типа PageDescription
            PageDescription p   = new PageDescription();

            p.moduleName        = moduleName;
            p.pageName          = pageName;
            p.subPageName       = subPageName;

            // Запишем их в список pageDescriptions для отчета
            allData.pageDescriptions.put(pageHref, p);

            // Если очередной элемент в списке полученных выше элементов отсутствует в списке исключений страниц, добавим его к pageHrefs.
            if ((inclusions == null || inclusions.isPageIncluded(pageHref)) && !exclusions.isPageExcluded(pageHref))
            {
                pageHrefs.add(pageHref);
            }
        }


        // Переведем pageHrefs в object.
        Object[] pages      = pageHrefs.toArray();
        Object[][] objects  = new Object[pages.length][1];

        for (int i = 0; i < pages.length; i++)
        {
            objects[i] = new Object[]{pages[i]};
        }

        findPagesData = objects;
    }

    @DataProvider(name = "a_getPages", parallel = true)
    public Object[][] a_getPages()
    {
        stopBrowsers();
        return findPagesData;
    }

    private void stopBrowsers()
    {
        seleniumRWLock.writeLock().lock();
        try
        {
            app.stopAll();
        }
        finally
        {
            seleniumRWLock.writeLock().unlock();
        }
    }

    /**
     * Метод получает список контейнеров без ошибок из теста findAllContainers и переводит его в объект, чтоб передать его тесту testCreateRecord
     * @return objects
     */
    @DataProvider(name = "b_getContainers", parallel = true)
    public Object[][] b_getContainers()
    {

        //Object[] modules = containersWithNoErrors.toArray();
        // Будет список массивов объектов, тк не знаем длину заранее, тк количество кнопок разное у всех контейнеров.
        List<Object[]> objects = new ArrayList<Object[]>();

        containerLocks = new HashMap<ContainerIdentifier, Object>();

        for (int i = 0; i < containersWithNoErrors.size(); i++)
        {
            ContainerIdentifier c = containersWithNoErrors.get(i);
            containerLocks.put(c, new Object());

            ContainerInfo containerInfo = containersInformation.get(c);

            // Получим список кнопок для каждого контейнера.
            if (containerInfo.buttons.contains(ContainerButtonType.Create))
            {
                log.debug(String.format("Container %s.%s has create button", c.pageHref, c.containerId));
                objects.add(new Object[]{ c.pageHref, c.containerId });
            }
            else
            {
                log.debug(String.format("Container %s.%s does not have create button", c.pageHref, c.containerId));
            }
        }

        stopBrowsers();

        return objects.toArray(new Object[0][3]);
    }

    /**
     * Метод получает список контейнеров, на которых есть фильтр, и передает его шагу testFilter
     * @return objects
     */
    @DataProvider(name = "getContainersWithFilters", parallel = true)
    public Object[][] getContainersWithFilters()
    {

        // Будет список массивов объектов, тк не знаем длину заранее, тк количество кнопок разное у всех контейнеров.
        List<Object[]> objects = new ArrayList<Object[]>();


        for (int i = 0; i < containersWithNoErrors.size(); i++)
        {
            ContainerIdentifier c = containersWithNoErrors.get(i);
            ContainerInfo containerInfo = containersInformation.get(c);

            // Получим список кнопок для каждого контейнера.
            if (containerInfo.hasFilter)
            {
                log.debug(String.format("Container %s.%s has filter", c.pageHref, c.containerId));
                objects.add(new Object[]{ c.pageHref, c.containerId });
            }
            else
            {
                log.debug(String.format("Container %s.%s does not have filter", c.pageHref, c.containerId));
            }
        }

        stopBrowsers();

        return objects.toArray(new Object[0][3]);
    }

    /**
     * Метод получает список контейнеров, на которых есть таблица, и передает его шагу testTableSort
     * @return objects
     */
    @DataProvider(name = "getContainersWithTables", parallel = true)
    public Object[][] getContainersWithTables()
    {

        // Будет список массивов объектов, тк не знаем длину заранее, тк количество кнопок разное у всех контейнеров.
        List<Object[]> objects = new ArrayList<Object[]>();


        for (int i = 0; i < containersWithNoErrors.size(); i++)
        {
            ContainerIdentifier c = containersWithNoErrors.get(i);
            ContainerInfo containerInfo = containersInformation.get(c);

            // Получим список кнопок для каждого контейнера.
            if (containerInfo.hasTable)
            {
                log.debug(String.format("Container %s.%s has table with %d columns", c.pageHref, c.containerId, containerInfo.tableColumns.size()));
                for (String tableColumn: containerInfo.tableColumns)
                {
                    objects.add(new Object[]{ c.pageHref, c.containerId, tableColumn });
                }
            }
            else
            {
                log.debug(String.format("Container %s.%s does not have table", c.pageHref, c.containerId));
            }
        }

        stopBrowsers();

        return objects.toArray(new Object[0][3]);
    }
    /**
     * Метод получает список контейнеров, в которых есть кнопка "Изменить" и в которых была создана запись
     * @return objects
     */
    @DataProvider(name = "getContainersForEdit", parallel = true)
    public Object[][] getContainersForEdit()
    {
        List<Object[]> objects = new ArrayList<Object[]>();

        for (Map.Entry<ContainerIdentifier, ContainerInfo> entry: containersInformation.entrySet())
        {
            ContainerIdentifier containerIdentifier = entry.getKey();
            ContainerInfo containerInfo             = entry.getValue();

            if (containerInfo.createdId != null)
            {
                if (containerInfo.buttons.contains(ContainerButtonType.Edit))
                {
                    objects.add(new Object[] { containerIdentifier.pageHref, containerIdentifier.containerId });
                }
            }
        }

        stopBrowsers();

        return objects.toArray(new Object[0][2]);
    }

    /**
     * Метод получает список контейнеров, в которых есть кнопка "Удалить" и в которых была создана запись
     * @return objects
     */
    @DataProvider(name = "getContainersForDelete", parallel = true)
    public Object[][] getContainersForDelete()
    {
        List<Object[]> objects = new ArrayList<Object[]>();

        for (Map.Entry<ContainerIdentifier, ContainerInfo> entry: containersInformation.entrySet())
        {
            ContainerIdentifier containerIdentifier = entry.getKey();
            ContainerInfo containerInfo             = entry.getValue();

            if (containerInfo.createdId != null)
            {
                if (containerInfo.buttons.contains(ContainerButtonType.Delete))
                {
                    objects.add(new Object[] { containerIdentifier.pageHref, containerIdentifier.containerId });
                }
            }
        }

        stopBrowsers();

        return objects.toArray(new Object[0][2]);
    }

    // Переменная отвечает за определение, был ли пользователь залогинен или нет
    ThreadLocal<Boolean> isLoggedIn = new ThreadLocal<>();

    @Test (dataProvider = "a_getPages", dependsOnMethods = {"findPages"})
    public void findAllContainers(String pageHref)
    {
        try
        {
            debugLogs.printPageHref(pageHref);
            PageDescription pageDescription = allData.pageDescriptions.get(pageHref);// Здесь будут данные о странице.

            //checkStatus.checkHTTPStatus(debugLogs);
            app.getNavigationHelper().openUrl("about:blank"); // Откроем новую чистую страницу.

            if (isLoggedIn.get() == null) // Если не были залогинены - то надо открыть главную страницу и залогиниться.
            {
                app.getNavigationHelper().openMainPage();
            }

            String url = getPageUrl(pageHref); // Сформируем URL страницы, чтобы открыть его. Получим его таким образом: URL приложения + pageHref (pageHref содержит часть URL страницы - название модуля и название страницы)
            //checkStatus.checkHTTPStatus(debugLogs);
            app.getNavigationHelper().openUrl(url); // Откроем получившийся URL

            synchronized (allData) // Для синхронизации между потоками на запись в переменную класса используется synchronized
            {
                // Будем запоминать в переменную класса allData значения, необходимые для генерации отчета HTML
                allData.coveredPages.add(pageHref); // Добавим в список страниц, где не найдены ошибки.
            }

            debugLogs.modulePageSubPageInfo(pageDescription.moduleName, pageDescription.pageName, pageDescription.subPageName); // Если включен режим отладки , то выведем следующие данные: название модуля, название страницы и название подстраницы.
            //checkStatus.checkHTTPStatus(debugLogs);

            List<WebElement> allContainersList  = page.getVisibleContainers(); // Получим список всех контейнеров с очередной открытой по pageHref страницы
            StringBuilder errorMessage          = new StringBuilder(); // Будем в эту переменную записывать сообщение об ошибке.

            for (WebElement container : allContainersList) // Для каждого элемента списка контейнеров с открытой страницы сделать следующее:
            {
                //checkStatus.checkHTTPStatus(debugLogs); // Проверить, доступна ли страница (чтобы можно было производить с ней дальнейшие действия)
                String currentContainerID = getContainerId(container.getAttribute("id")); // Получим значение текущего контейнера (убрав от строки подстроку до (включая) символ ":"

                ContainerIdentifier containerIdentifier = new ContainerIdentifier(); //Запишем данные о контейнере и pageHref в переменную типа ContainerIdentifier.
                containerIdentifier.pageHref            = pageHref;
                containerIdentifier.containerId         = currentContainerID;

                String containerError;

                containerError = errorsSearchers.isErrorPresentsByContainerId(currentContainerID);
                if (!containerError.equals(""))
                {
                    errorMessage.append(String.format(
                            "Container %s in module %s (%s) contains error message: %s" +
                                    "\n See stacktrace addition in allure report. " +
                                    "\n User is %s " +
                                    "\n Url is %s\n", currentContainerID, pageDescription.moduleName, pageHref, containerError, app.getProperty("login"), url));
                    Assert.fail(errorMessage.toString());
                }

                // contains использует метод equals в ContainerIdentifier
                if ((inclusions != null && !inclusions.isContainerIncluded(containerIdentifier)) || exclusions.isContainerExcluded(containerIdentifier))
                {
                    continue;
                }

                // Если в текущем проверяемом контейнере ( текущий элемент списка всех контейнеров со страницы ) есть ошибки, то:
                // будем добавлять в список контейнеров с ошибками запись о текущем контейнере в определенном формате,
                // зависящем от того, генерировать отчет HTML или нет.
                containerError = errorsSearchers.isErrorPresentsByContainerId(currentContainerID);
                if (!containerError.equals(""))
                {
                    log.debug(String.format("Container '%s'.'%s' has error message: '%s'", pageHref, currentContainerID, containerError));
                    synchronized (containersWithErrors) // Для синхронизации между потоками на запись в переменную класса используется synchronized
                    {
                        containersWithErrors.add(containerIdentifier);
                    }

                    // Создадим формат сообщения об ошибке. Выведем значения:
                    // - имя пользователя
                    // - текст ошибки
                    // - url, на котором произошла ошибка.
                    errorMessage.append(String.format(
                            "Container %s in module %s (%s) contains error message: %s" +
                                    "\n See stacktrace addition in allure report. " +
                                    "\n User is %s " +
                                    "\n Url is %s\n", currentContainerID, pageDescription.moduleName, pageHref, containerError, app.getProperty("login"), url));
                }
                else
                {
                    // Если ошибок в контейнере нет: Получим все кнопки "Создать" или "Добавить" в текущем контейнере. Получим все кнопки, которые не задизейблены.

                    log.debug(String.format("Container '%s'.'%s' does not have error", pageHref, currentContainerID));
                    ContainerInfo containerInfo = new ContainerInfo();

                    findContainerButtons(container, containerIdentifier, containerInfo);

                    findFilter(container, containerInfo);

                    findTable(container, containerInfo); // Проверить, что в контейнере только таблица, а не форма.
                    synchronized (containersInformation)
                    {
                        containersInformation.put(containerIdentifier, containerInfo);
                    }

                    synchronized (containersWithNoErrors) // Для синхронизации между потоками на запись в переменную класса используется synchronized
                    {
                        containersWithNoErrors.add(containerIdentifier); // Добавим контейнер в список контейнеров без ошибок. Учитывается - что в контейнере по одной кнопке Добавить Изменить и Удалить
                    }
                }
            }

            if (errorMessage.length() != 0) // Если была ошибка в текущем контейнере - то тест падает и выводит эту ошибку в формате, которй был создан выше.
            {
                Assert.fail(errorMessage.toString());
            }

            isLoggedIn.set(true); // Указать, что пользователь был залогинен.

        }
        catch (Exception e)
        {
            throw new RuntimeException(String.format("Failure at findAllContainers(%s)", pageHref), e);
        }
    }



    /**
     * Метод получает поочередно все записи (данные о контейнерах без ошибок) из списка containersWithNoErrors
     * Производит создание записи.
     * После создания записи получает все кнопки в контейнере.
     *
     * @param pageHref pageHref ( название модуля и название страницы )
     * @param containerId идентификатор контейнера
     */
    @Test(dataProvider = "b_getContainers", dependsOnMethods = {"findAllContainers"}, alwaysRun = true)
    public void testCreateRecord(String pageHref, String containerId) throws Exception
    {
        ContainerIdentifier c   = new ContainerIdentifier(); // Запомним данные о контейнере в переменной типа ContainerIdentifier

        c.pageHref              = pageHref;
        c.containerId           = containerId;

        System.out.printf(pageHref);
        String url = getPageUrl(pageHref); // полный url

        synchronized (allData) // Для синхронизации между потоками на запись в переменную класса используется synchronized
        {
            TestCoverageItem testCoverageItem = allData.coveredItems.get(c);

            if (testCoverageItem == null)
            {
                testCoverageItem = new TestCoverageItem();
                testCoverageItem.container = c;
                allData.coveredItems.put(c, testCoverageItem);
            }

            testCoverageItem.buttons.add(ContainerButtonType.Create);
            // Добавим данные о контейнере в список контейнеров без ошибок для отчета HTML
        }

        debugLogs.containersInfoLog(pageHref, containerId, url);

        if (isLoggedIn.get() == null) // Если пользователь не был залогинен - открыть главную страницу и залогиниться.
        {
            app.getNavigationHelper().openMainPage();
        }

        app.getNavigationHelper().openUrl("about:blank");   // Открыть чистую страницу
        app.getActor().resetNetworkEventActors();           // Обнулить список NetworkEventActors
        app.getNavigationHelper().openUrl(url);             // Открыть URL необходимой страницы

        checkStatus.checkPageStatus(debugLogs);

        assertThat(String.format("Page has error message: %s", errorsSearchers.isErrorPresentsByContainerId(containerId)), errorsSearchers.isErrorPresentsByContainerId(containerId), equalTo("")); // Проверить, что сообщений об ошибке на странице нет. Если сообщение об ошибке на странице есть, то тест упадет и вывести следующее сообщение об ошибке.

        if (!page.getContainer(containerId).takeContainer().getAttribute("class").contains("unavailable")) // Если контейнер не unavailable, то:
        {
            ContainerIdentifier id  = new ContainerIdentifier();
            id.pageHref             = pageHref;
            id.containerId          = containerId;

            if (containersInformation.containsKey(id))
            {
                long createdId              = buttonsActions.doCreate(pageHref, containerId, url, debugLogs);
                ContainerInfo containerInfo = containersInformation.get(id);
                WebElement containerElement = page.getContainer(containerId).takeContainer();

                synchronized (containerInfo)
                {
                    containerInfo.createdId = createdId;
                    findContainerButtons(containerElement, id, containerInfo);
                }
            }
        }

        isLoggedIn.set(true); // Установить, что пользователь был залогинен.
    }


    /**
     * Метод получает поочередно все записи(данные о контейнерах без ошибок) из списка containersWithNoErrors
     *
     * @param pageHref pageHref ( название модуля и название страницы )
     * @param containerId идентификатор контейнера
     */
    @Test(dataProvider = "getContainersForEdit", dependsOnMethods = {"testCreateRecord"}, alwaysRun = true)
    public void testEditRecord(String pageHref, String containerId) throws Exception
    {
        ContainerIdentifier c   = new ContainerIdentifier(); // Запомним данные о контейнере в переменной типа ContainerIdentifier

        c.pageHref              = pageHref;
        c.containerId           = containerId;

        ContainerInfo containerInfo = containersInformation.get(c);

        assertThat("ContainerInfo.CreatedId не заполнен", containerInfo.createdId, notNullValue());

        //https://rmis-test.i-novus.ru/frontend/#phthisiatry.phthisiatryReception?mcase:filter:id=40
        String url = String.format("%s?%s:filter:id=%d", getPageUrl(pageHref), c.containerId, containerInfo.createdId); // полный url

        synchronized (allData) // Для синхронизации между потоками на запись в переменную класса используется synchronized
        {
            TestCoverageItem testCoverageItem = allData.coveredItems.get(c);

            if (testCoverageItem == null)
            {
                testCoverageItem = new TestCoverageItem();
                testCoverageItem.container = c;
                allData.coveredItems.put(c, testCoverageItem);
            }


            // Добавим данные о контейнере в список контейнеров без ошибок для отчета HTML
            testCoverageItem.buttons.add(ContainerButtonType.Edit);
        }

        synchronized (containerLocks.get(c))
        {
            debugLogs.containersInfoLog(pageHref, containerId, url);

            if (isLoggedIn.get() == null) // Если пользователь не был залогинен - открыть главную страницу и залогиниться.
            {
                app.getNavigationHelper().openMainPage();
            }

            app.getNavigationHelper().openUrl("about:blank");   // Открыть чистую страницу
            app.getActor().resetNetworkEventActors();           // Обнулить список NetworkEventActors
            app.getNavigationHelper().openUrl(url);             // Открыть URL необходимой страницы

            checkStatus.checkPageStatus(debugLogs);

            assertThat(String.format("Page have error message: %s", errorsSearchers.isErrorPresentsByContainerId(containerId)), errorsSearchers.isErrorPresentsByContainerId(containerId), equalTo("")); // Проверить, что сообщений об ошибке на странице нет. Если сообщение об ошибке на странице есть, то тест упадет и вывести следующее сообщение об ошибке.

            if (!page.getContainer(containerId).takeContainer().getAttribute("class").contains("unavailable")) // Если контейнер не unavailable, то:
            {
                ContainerIdentifier id  = new ContainerIdentifier();
                id.pageHref             = pageHref;
                id.containerId          = containerId;

                if (containersInformation.containsKey(id))
                {
                    /* Проверка, что есть элементы в виджетах. */
                    if (page.getContainer(containerId).getTree().isTreeContainerFound())
                    {
                        Tree tree = page.getContainer(containerId).getTree();

                        if (tree.getNodesCount(tree.takeTreeContainer()) == 0)
                        {
                            Assert.fail("В дереве нет ни одного элемента");
                        }
                    }
                    else if (page.getContainer(containerId).getTable().isTableFound())
                    {
                        Table table = page.getContainer(containerId).getTable();

                        if(table.getCountRowsInTable(true) == 0)
                        {
                            Assert.fail("Запись не найдена.");
                        }
                    }
                    else
                    {
                        Assert.fail("На странице нет ни дерева ни таблицы.");
                    }

                    /* doEdit */

                    buttonsActions.doEdit(pageHref, containerId, url, debugLogs);

                }
            }
        }

        isLoggedIn.set(true); // Установить, что пользователь был залогинен.
    }

        /**
     * Метод получает поочередно все записи(данные о контейнерах без ошибок) из списка containersWithNoErrors
     *
     * @param pageHref pageHref ( название модуля и название страницы )
     * @param containerId идентификатор контейнера
     */
    @Test(dataProvider = "getContainersForDelete", dependsOnMethods = {"testEditRecord"}, alwaysRun = true)
    public void testDeleteRecord(String pageHref, String containerId) throws Exception
    {
        ContainerIdentifier c   = new ContainerIdentifier(); // Запомним данные о контейнере в переменной типа ContainerIdentifier

        c.pageHref              = pageHref;
        c.containerId           = containerId;

        ContainerInfo containerInfo = containersInformation.get(c);

        assertThat("ContainerInfo.CreatedId не заполнен", containerInfo.createdId, notNullValue());

        //https://rmis-test.i-novus.ru/frontend/#phthisiatry.phthisiatryReception?mcase:filter:id=40
        String url = String.format("%s?%s:filter:id=%d", getPageUrl(pageHref), c.containerId, containerInfo.createdId); // полный url

        synchronized (allData) // Для синхронизации между потоками на запись в переменную класса используется synchronized
        {
            TestCoverageItem testCoverageItem = allData.coveredItems.get(c);

            if (testCoverageItem == null)
            {
                testCoverageItem = new TestCoverageItem();
                testCoverageItem.container = c;
                allData.coveredItems.put(c, testCoverageItem);
            }


            // Добавим данные о контейнере в список контейнеров без ошибок для отчета HTML
            testCoverageItem.buttons.add(ContainerButtonType.Delete);
        }

        synchronized (containerLocks.get(c))
        {
            debugLogs.containersInfoLog(pageHref, containerId, url);

            if (isLoggedIn.get() == null) // Если пользователь не был залогинен - открыть главную страницу и залогиниться.
            {
                app.getNavigationHelper().openMainPage();
            }

            app.getNavigationHelper().openUrl("about:blank");   // Открыть чистую страницу
            app.getActor().resetNetworkEventActors();           // Обнулить список NetworkEventActors
            app.getNavigationHelper().openUrl(url);             // Открыть URL необходимой страницы

            checkStatus.checkPageStatus(debugLogs);

            assertThat(String.format("Page have error message: %s", errorsSearchers.isErrorPresentsByContainerId(containerId)), errorsSearchers.isErrorPresentsByContainerId(containerId), equalTo("")); // Проверить, что сообщений об ошибке на странице нет. Если сообщение об ошибке на странице есть, то тест упадет и вывести следующее сообщение об ошибке.

            if (!page.getContainer(containerId).takeContainer().getAttribute("class").contains("unavailable")) // Если контейнер не unavailable, то:
            {
                ContainerIdentifier id  = new ContainerIdentifier();
                id.pageHref             = pageHref;
                id.containerId          = containerId;

                if (containersInformation.containsKey(id))
                {
                    /* Проверка, что есть элементы в виджетах. */
                    if (page.getContainer(containerId).getTree().isTreeContainerFound())
                    {
                        Tree tree = page.getContainer(containerId).getTree();

                        if ((tree.getNodesCount(tree.takeTreeContainer()) == 0) || (tree.getNodesCount(tree.takeTreeContainer()) > 0 && tree.isAllElementsInvisible(tree.takeTreeContainer())))
                        {
                             Assert.fail("В дереве нет ни одного элемента");
                        }
                    }
                    else if (page.getContainer(containerId).getTable().isTableFound())
                    {
                        Table table = page.getContainer(containerId).getTable();

                        if(table.getCountRowsInTable(true) == 0)
                        {
                            Assert.fail("Запись не найдена.");
                        }
                    }
                    else
                    {
                        Assert.fail("На странице нет ни дерева ни таблицы.");
                    }

                    /* doDelete */

                    buttonsActions.doDelete(pageHref,  containerId, url, debugLogs);

                }
            }
        }

        isLoggedIn.set(true); // Установить, что пользователь был залогинен.
    }

    @Test(dataProvider = "getContainersWithFilters", dependsOnMethods = "findAllContainers", alwaysRun = true)
    public void testFilter(String pageHref, String containerId) throws Exception
    {

        try
        {
            ContainerIdentifier containerIdentifier = new ContainerIdentifier();
            containerIdentifier.pageHref            = pageHref;
            containerIdentifier.containerId         = containerId;

            ContainerInfo containerInfo             = containersInformation.get(containerIdentifier);

    //        System.out.printf("containerId = %s, hasFilter = %s", containerId, containerInfo.hasFilter);

            openUrl(pageHref); // Открыть страницу

            Container currentContainer = page.getContainer(containerId);
            WebElement filter = currentContainer.takeContainer().findElement(By.xpath(".//div[contains(@class, 'n2o-filter-block')]"));

            boolean isFilterOpened = filter.getAttribute("class").contains("active"); //  Если фильтр открыт - у него в атрибуте class значение active присутствует.

            // 1. Если фильтр скрытый - его раскрыть
            if (!isFilterOpened)
            {
                openFilter(currentContainer, filter);

            }
            else
            {
                System.out.printf("filter is already open!");
            }
            {
                // Иначе - производим дальнейшие действия.
                // ------- 2. Найти все поля фильтра -------
                List<String> cssSelectorParts = new ArrayList<String>(); // будем записывать селекторы для каждого элемента.

                for (String cssClass: ComponentCssClasses)
                {
                    String cssSelectorPart;

                    if (cssClass.equals(".n2o-checkbox"))
                    {
                        cssSelectorPart = String.format(".control-label + .controls > .n2o-component%s", cssClass);
                    }
                    else
                    {
                        cssSelectorPart = String.format(".control-label + .controls > div > .n2o-component%s", cssClass);
                    }

                    cssSelectorParts.add(cssSelectorPart);
                }

                StringBuilder cssSelector = new StringBuilder();

                for (String value: cssSelectorParts)
                {
                    if (cssSelector.length() > 0)
                    {
                        cssSelector.append(", ");
                    }
                    cssSelector.append(value); // Получим строку, содержащую все селекторы.
                }

                List<WebElement> filterElements         = filter.findElements(By.cssSelector(cssSelector.toString())); // Найдем все элементы по строке-селектору.
                List<ComponentBase> allFilterComponents = new ArrayList<ComponentBase>();
                Filter filterForm                       = page.getContainer(containerId).getFilter();// Получим форму.


                for (WebElement fieldElement: filterElements) // Будем брать каждый компонент в списке найденных
                {
                    if (fieldElement.isDisplayed()) // Только если этот компонент видимый.
                    {
                        ComponentBase component = fillComponents.getComponentFromElement(null, fieldElement, true, filterForm);
                        if (component != null)
                        {
                            allFilterComponents.add(component);
                        }
                    }
                }

                // Если нет ни одного обязательного и ни одного необязательно поля - то значит в фильтре нет полей. (либо есть поля, которые не учтены в программе)
                if (filterElements.size() == 0)
                {
                    Assert.fail("In filter no fields!"); // Тест падает. Вывести сообщение, что в фильтре нет полей.
                }
                else
                {

                    // 3. ------- Заполнить поля, как при создании. -------
                    fillComponents.fillFilterFields(allFilterComponents, containerId, filter, debugLogs);

                    // 4. Нажать кнопку "Найти"
                    app.getBaseHelperWithWebDriver().click(filter.findElement(By.cssSelector(".submit")));

                    // 5. Проверить, что нет ошибок. Если есть - падать.
                    assertThat(errorsSearchers.isErrorPresentsByContainerId(containerId), isEmptyString());


                    // 6. Если фильтр скрылся - открыть
                    filter          = currentContainer.takeContainer().findElement(By.xpath(".//div[contains(@class, 'n2o-filter-block')]"));
                    isFilterOpened  = filter.getAttribute("class").contains("active"); //  Если фильтр открыт - у него в атрибуте class значение active присутствует.

                    if (!isFilterOpened)
                    {
                        openFilter(currentContainer, filter);
                    }

                    // 7. Нажать кнопку "Очистить"
                    app.getBaseHelperWithWebDriver().click(filter.findElement(By.cssSelector(".reset")));

                    // 8. Проверить, что нет ошибок. Если есть - падать.
                    assertThat(errorsSearchers.isErrorPresentsByContainerId(containerId), isEmptyString());

                }
            }
        }
        finally
        {
              // Сбрасывает пользовательские настройки. Например, сортировку столбца и значеня фильтра.
            JavascriptExecutor js = (JavascriptExecutor) ApplicationManager.getCurrentInstance().getWebDriver();
            js.executeScript("localStorage.removeItem('$n2oUserStorage')");
        }
    }

    @Test(dataProvider = "getContainersWithTables", dependsOnMethods = "testFilter", alwaysRun = true)
    public void testTableSort(String pageHref, String containerId, String columnName) throws Exception
    {
        try
        {

            ContainerIdentifier containerIdentifier = new ContainerIdentifier();
            containerIdentifier.pageHref            = pageHref;
            containerIdentifier.containerId         = containerId;

            ContainerInfo containerInfo             = containersInformation.get(containerIdentifier);

            if (!pageHref.equals(step5_currentPageHref.get()))
            {
                openUrl(pageHref);
                step5_currentPageHref.set(pageHref);
            }

            //  1. Получить список всех столбцов таблицы
            String xpath = String.format(
                    ".//div[contains(@class,'n2o-table-container_table')]" +
                    "//span[contains(@class, 'n2o-sorter')]" +
                    "/a[normalize-space(string())='%s']",
                    columnName);

            //  2. Для каждого столбца нажать три раза
            for (int j = 0; j <= 2; j++ )
            {
                Container currentContainer  = page.getContainer(containerId);
                WebElement tdLink           = currentContainer.takeContainer().findElement(By.xpath(xpath));

                String sortingType;
                String tdText = tdLink.getText(); // Текст столбца. Надо получить до нажатия, иначе при обновлении страницы( при сотрировке ) перерисуется html.

                debugLogs.printTdText(tdText);

                // Определим, какой тип сортировки был до нажатия на столбец( т.к. если при нажатии тест упадет - новая стрелочка не нарисуется. )
                sortingType = getSortingType(tdLink).toString();

                debugLogs.printSortingType("До нажатия ", sortingType);

                app.getBaseHelperWithWebDriver().click(tdLink); // нажмем на каждую ссылку 3 раза

                debugLogs.printTdTextWithIterationNumber(tdText, j);

                //  3. Каждый раз проверить, что нет ошибок. Если есть - падать.
                if (!errorsSearchers.isErrorPresentsByContainerId(containerId).equals(""))
                {
                    // Выводим для информации тип сортировки, который был до нажатия.
                    Assert.fail(String.format("При сортировке столбца %s произошла ошибка: %s \n До нажатия был тип сортировки: %s",
                                tdText, errorsSearchers.isErrorPresentsByContainerId(containerId), sortingType));
                }
            }

            debugLogs.printHasTable(containerId, containerInfo.hasTable);
        }
       finally
        {
            // Сбрасывает пользовательские настройки. Например, сортировку столбца и значеня фильтра.
            JavascriptExecutor js = (JavascriptExecutor) ApplicationManager.getCurrentInstance().getWebDriver();
            js.executeScript("localStorage.removeItem('$n2oUserStorage')");
        }
    }

    /* ------------------------------------------------------------------ Helper methods --------------------------------------------------------------------*/

    /**
     * Проверяет, открыт ли фильтр.
     *
     * @param currentContainer
     * @param filter
     */
    private void openFilter(Container currentContainer, WebElement filter)
    {
        WebElement filterButton = currentContainer.takeContainer().findElement(By.cssSelector(".action-filter"));
        app.getBaseHelperWithWebDriver().click(filterButton);


        // Если после нажатия на кнопку открытия фильтра у фильтра не появился класс active, то фильтр не открылся. Сообщим в сообщении.
        if (!filter.getAttribute("class").contains("active"))
        {
            System.out.printf("ERROR! Filter is not open!!!");
        }
    }

    /**
     * Получение типа сортировки столбца.
     *
     * @param tdLink столбец как WebElement
     * @return Строка - тип сортировки
     */
    private SortingType getSortingType(WebElement tdLink)
    {
        SortingType sortingType;

        if (tdLink.findElements(By.cssSelector("ins.icon-arrow-up")).size() == 1)
        {
            sortingType = SortingType.Up;
        }
        else if (tdLink.findElements(By.cssSelector("ins.icon-arrow-down")).size() == 1)
        {
            sortingType = SortingType.Down;
        }
        else
        {
            sortingType = SortingType.None;
        }
        return sortingType;
    }

    /**
     * Возвращает часть значения атрибута id веб-элемента n2o-container
     *
     * @param containerId полное значение атрибута id веб-элемента n2o-container
     * @return отформатированное значение
     */
    public String getContainerId(String containerId)
    {
        return containerId.substring(containerId.indexOf(':') + 1);
    }

    /**
     * Получает все данные для дальнейшей генерации разметки HTML для контейнеров - исключений
     *
     */
    public void createFormattedExceptionsString()
    {
        // Для синхронизации между потоками на запись в переменную класса используется synchronized
        synchronized (allData)
        {
            for (TestExclusionInfo testExclusionInfo : exclusions.getParsedExclusions())
            {
                allData.exclusions.add(testExclusionInfo);
            }
        }
    }


    /**
     * Открывает URL и проверяет статус страницы
     *
     * @param pageHref
     * @throws Exception
     */
    private void openUrl(String pageHref) throws Exception
    {
        if (isLoggedIn.get() == null) // Если пользователь не был залогинен - открыть главную страницу и залогиниться.
        {
            app.getNavigationHelper().openMainPage();
        }

        String url = getPageUrl(pageHref);

        app.getNavigationHelper().openUrl("about:blank");   // Открыть чистую страницу
        app.getActor().resetNetworkEventActors();           // Обнулить список NetworkEventActors
        app.getNavigationHelper().openUrl(url);             // Открыть URL необходимой страницы

        checkStatus.checkPageStatus(debugLogs);             // Проверка статуса страницы
    }

      /**
     * Находит все нужные кнопки в контейнере
     *
     * @param container             Контейнер
     * @param containerIdentifier   Объект ContainerIdentifier
     * @param containerInfo         Объект containerInfo
     */
    private void findContainerButtons(WebElement container, ContainerIdentifier containerIdentifier, ContainerInfo containerInfo)
    {
        String buttonXPath  = ".//button[not(contains(@class, 'disabled')) and not(contains(@style, 'display: none;')) and not(contains(@class, 'n2o-hidden'))]";

        List<WebElement> buttonsOfCurrentContainer = app.getBaseHelperWithWebDriver().findElements(By.xpath(buttonXPath), container);
        synchronized (containerInfo)
        {
            containerInfo.buttons.clear();
            for (WebElement button: buttonsOfCurrentContainer)
            {
                ContainerButtonUtils.addButtonToContainer(button, containerIdentifier, containerInfo, exclusions, inclusions); // А также заполним список containersInformation для определения, какие кнопки есть в контейнере.
            }
        }
    }

    /**
     * Ищет, есть ли фильтр в контейнере. Результат записывает в поле hasFilter для конкретного containerId
     *
     * @param container             Контейнер
     * @param containerInfo         Объект containerInfo
     */
    private void findFilter(WebElement container, ContainerInfo containerInfo)
    {
        boolean hasFilter = false;
        if (!container.getAttribute("class").contains("unavailable"))
        {
            List<WebElement> filter = container.findElements(By.xpath(".//div[contains(@class, 'n2o-filter-block')]"));

            if (filter.size() == 1)
            {
                hasFilter = true;
            }
            else
            {
                hasFilter = false;
            }

            if (hasFilter)
            {
                if (filter.get(0).findElements(By.xpath(".//button[contains(@class, 'submit') and contains(text(), 'Найти')]")).size() == 1)
                {
                    synchronized (containerInfo)
                    {
                        containerInfo.hasFilter = true;
                    }
                }
            }
        }

    }

    /**
     * Ищет, есть ли таблица в текущем контейнере. Если таблица есть - получим все ее столбцы, в которых возможно сортировка. (класс n2o-sorter)
     *
     * @param container         Контейнер
     * @param containerInfo     Объект containerInfo
     */
    private void findTable(WebElement container, ContainerInfo containerInfo)
    {
        boolean isUnavailable = container.getAttribute("class").contains("unavailable");
        // Надо, чтоб у контейнера не было класса unavailable, этот класс говорит о том, что контейнер недоступен для действий (Надпись "Недоступно")

        if (!isUnavailable) // дальнейшие действия делать надо, только если контейнер доступен
        {
            // Найти таблицу в контейнере
            List<WebElement> tableElements = container.findElements(By.xpath(".//div[contains(@class,'n2o-table-container_table')]"));

            if (tableElements.size() == 1)
            {
                WebElement tableElement = tableElements.get(0);
                synchronized (containerInfo)
                {
                    containerInfo.hasTable      = true;
                    List<WebElement> tdLinks    = tableElement.findElements(By.xpath(".//span[contains(@class, 'n2o-sorter')]/a[text() != '']"));


                    for (WebElement linkElement: tdLinks)
                    {
                        String columnText = linkElement.getText().trim();
                        containerInfo.tableColumns.add(columnText);
                    }
                }
            }
        }

    }

    /**
     * Получение URL страницы
     *
     * @param pageHref
     * @return URL страницы
     */
    private String getPageUrl(String pageHref)
    {
        String baseUrl = app.getProperty("baseUrl");
        if (!baseUrl.endsWith("/"))
        {
            baseUrl = baseUrl + "/";
        }
        return baseUrl + pageHref;
    }
}