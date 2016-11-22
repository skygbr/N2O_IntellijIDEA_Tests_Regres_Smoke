package test.smoke;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Form;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.Tree;
import net.framework.autotesting.meta.components.ComponentBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class ButtonsActions
{
    ApplicationManager app;
    Page page;
    FillComponents fillComponents;
    CheckStatus checkStatus;
    ErrorsSearchers errorsSearchers;

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
        ".n2o-select-tree",
        ".n2o-text-masked",
        ".n2o-select-tree-diagnosis"
//            , ".rmis-mass-operations"
    };

    /**
     * Конструктор. Устанавливает значение необходимых переменных.
     */
    public ButtonsActions()
    {
        this.app        = ApplicationManager.getInstance();
        this.page       = Page.getInstance();
        fillComponents  = new FillComponents();
        checkStatus     = new CheckStatus();
        errorsSearchers = new ErrorsSearchers();
    }

    /**
     * Метод реализует создание. Нажимает кнопку "Создать" или "Добавить", заполняет поля, нажимает кнопку "Сохранить"
     *
     * @param pageHref      данные о странице
     * @param containerId   id контейнера
     * @param url
     *
     * @return Идентификатор созданной записи
     * @throws Exception
     */
    public long doCreate(String pageHref, String containerId, String url, DebugLogs debugLogs) throws Exception
    {
        debugLogs.printDoCreateInfo();

        int createButtonNumber = 0; // номер кнопки Создать или Добавить

        while (true)
        {

            List<WebElement> allCreateButtons = app.getBaseHelperWithWebDriver().findElements(
                    By.xpath(".//button[(normalize-space(string())='Создать' or normalize-space(string())='Добавить'  or normalize-space(string()) = 'Создать(Ins)'  or normalize-space(string()) = 'Создать (Ins)' or normalize-space(string()) = 'Добавить(Ins)' or normalize-space(string()) = 'Добавить (Ins)') and not(contains(@class, 'n2o-hidden')) ]"),
                    page.getContainer(containerId).takeContainer()
            ); // Найдем все кнопки Создать или Добавить, и запишем их в список.


            if (createButtonNumber >= allCreateButtons.size()) // Если список пуст, то завершить работу с этим контейнером.
            {
                break;
            }

            WebElement createButton = allCreateButtons.get(createButtonNumber); // Получим первую кнопку из списка
            createButtonNumber      = createButtonNumber + 1; // Увеличим номер кнопки на 1

            if (!createButton.isDisplayed()) // Если кнопка не отображена:
            {
                Assert.fail(String.format("Button is not displayed; pageHref = %s, containerId = %s", pageHref, containerId)); // Тест падает. Вывести сообщение, что кнопка не отображена.
            }

            if (!(createButton.getAttribute("class").contains("disabled"))) // Если кнопка не задизейблена
            {
                app.getActor().resetNetworkEventActors(); // Обнулить список NetworkEventActors
                app.getBaseHelperWithWebDriver().click(createButton); // Нажать полученную кнопку

                checkStatus.checkPageStatus(debugLogs);

                boolean isModalForm = page.getCountOfModals() > 0; // Получим значение isModalForm - модальное окно или страница открылась.
                WebElement fieldsContainer;
                Form fieldsForm;


                if (isModalForm) // Если открылось модальное окно, то:
                {
                    fieldsContainer         = app.getWebDriver().findElement(By.xpath("//*[contains(@class, 'n2o-modal-container')]")); // Получим контейнер
                    String formErrorMessage = errorsSearchers.isErrorPresentsByContainerElement(fieldsContainer);

                    assertThat("Form has error message", formErrorMessage, equalTo(""));

                    fieldsForm              = page.getModal().getForm();// Получим форму. Учесть что форма может быть не найдена
                }
                else
                {
                    try // Должна открыться страница. Если открылась страница - то на ней должна быть кнопка "Сохранить". Попробуем ее найти.
                    {
                        app.getWebDriver().findElement(By.xpath("//div[contains(@class, 'n2o-container')][.//button[contains(@class, 'n2o-confirm') and normalize-space(text())='Сохранить' or normalize-space(text())='Подтвердить' or normalize-space(text())='Добавить' and not(contains(@class, 'dropdown-toggle'))]]"));
                    }
                    catch(Exception e)
                    {
                        Assert.fail("Нет кнопки 'Сохранить'"); // Если кнопки "Сохранить" нет - то значит на странице нет формы для заполнения полей для создания. Тест падает. Выводим соответствующее сообщение.
                    }

                    fieldsContainer = app.getWebDriver().findElement(By.xpath("//div[contains(@class, 'n2o-container')][.//button[contains(@class, 'n2o-confirm') and normalize-space(text())='Сохранить' or normalize-space(text())='Подтвердить' or normalize-space(text())='Добавить']]")); // Если тест не упал до этого момента - значит на странице есть кнопка "Сохранить". Найдем контейнер с этой кнопкой.
                    fieldsForm      = page.getForm(); // Найдем форму.

                    assertThat("Page have error message", errorsSearchers.isErrorPresentsByContainerElement(fieldsContainer), equalTo("")); // Проверим, что на странице нет сообщений об ошибке.
                }

                if (fieldsContainer.findElements(By.cssSelector(".n2o-form-widget.n2o-readonly")).size() == 0) // Если форма не readonly, то:
                {
                    List<String> cssSelectorParts = new ArrayList<String>(); // будем записывать селекторы для каждого элемента.

                    for (String cssClass: ComponentCssClasses)
                    {
                        String cssSelectorPart = String.format(".control-label + .controls > div > .n2o-component%s", cssClass);
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

                    List<WebElement> fieldElements              = fieldsContainer.findElements(By.cssSelector(cssSelector.toString())); // Найдем все элементы по строке-селектору.

                    List<ComponentBase> requiredComponents      = new ArrayList<ComponentBase>(); // Создадим список для обязательных компонентов(содержат звездочку)
                    List<ComponentBase> nonRequiredComponents   = new ArrayList<ComponentBase>(); // Создадим список для необязательных(которые не содержат звездочку) компонентов

                    for (WebElement fieldElement: fieldElements) // Будем брать каждый компонент в списке найденных и смотреть, есть ли у него звездочка(класс n2o-required-star)( обязательный или нет)
                    {
                        if (fieldElement.isDisplayed()) // Только если этот компонент видимый.
                        {
                            WebElement controlLabelElement  = fieldElement.findElement(By.xpath("../../preceding-sibling::*[contains(@class, 'control-label')]"));
                            boolean isRequired              = controlLabelElement.getAttribute("class").contains("n2o-required-star");
                            ComponentBase component         = fillComponents.getComponentFromElement(fieldsForm, fieldElement, false, null);

                            if (component != null)
                            {
                                if (isRequired) // Если есть класс n2o-required-star - добавить в список обязательных компонентов, если нет - то добавить в список необязательных компонентов.
                                {
                                    requiredComponents.add(component);
                                }
                                else
                                {
                                    nonRequiredComponents.add(component);
                                }
                            }
                        }
                    }

                    if (requiredComponents.size() == 0 && nonRequiredComponents.size() == 0) // Если нет ни одного обязательного и ни одного необязательно поля - то значит на форме нет полей. (либо есть поля, которые не учтены в программе)
                    {
                        debugLogs.containersInfoLog(pageHref, containerId, url);
                        Assert.fail("In modal window form no fields!"); // Тест падает. Вывести сообщение, что на форме нет полей.
                    }
                    else
                    {
                        long createdId = fillComponents.fillFields(requiredComponents, nonRequiredComponents, containerId, fieldsContainer, isModalForm, ContainerButtonType.Create, debugLogs);
                        return createdId;
                    }
                }
            }
        }
        Assert.fail("Не удалось выполнить создание");
        throw new RuntimeException("Этот код не должен быть выполнен");
    }


    /**
     * Редактирование записи. Берет запись, которая была создана в testCreateRecord
     *
     * @param pageHref
     * @param containerId
     * @param url
     * @throws Exception
     */
    public void doEdit(String pageHref, String containerId, String url, DebugLogs debugLogs) throws Exception
    {
        debugLogs.printDoEditInfo();

        int updateButtonNumber = 0; // Номер кнопки Редактировать или Изменить

        while (true)
        {
            // Найдем все кнопки Редактировать или Изменить, и запишем их в список.
            List<WebElement> allUpdateButtons =  app.getBaseHelperWithWebDriver().findElements(By.xpath(".//button[contains(@class, 'n2o-action') and not (contains(@class, 'hidden')) and normalize-space(string())='Изменить' or normalize-space(string())='Редактировать' or normalize-space(string()) = 'Изменить (Enter)' or normalize-space(string()) = 'Изменить(Enter)']"), page.getContainer(containerId).takeContainer());

            if (updateButtonNumber >= allUpdateButtons.size()) // Если список пуст, то завершить работу с этим контейнером.
            {
                break;
            }

            WebElement updateButton = allUpdateButtons.get(updateButtonNumber); // Получим первую кнопку из списка
            updateButtonNumber      = updateButtonNumber + 1; // Увеличим номер кнопки на 1

            if (!updateButton.isDisplayed()) // Если кнопка не отображена:
            {
                Assert.fail(String.format("Button 'Изменить' is not displayed; pageHref = %s, containerId = %s", pageHref, containerId)); // Тест падает. Вывести сообщение, что кнопка не отображена.
            }

            if (!(updateButton.getAttribute("class").contains("disabled"))) // Если кнопка не задизейблена
            {

                app.getActor().resetNetworkEventActors(); // Обнулить список NetworkEventActors

                if (page.getContainer(containerId).getTree().isTreeContainerFound())
                {
                    Tree tree = page.getContainer(containerId).getTree();

                    assertThat("Нет элементов в дереве. Удаление невозможно.", tree.getNodesCount(tree.takeTreeContainer()), greaterThan(0));
                    tree.chooseFirstElement();
                }
                else if (page.getContainer(containerId).getTable().isTableFound())
                {
                    Table table = page.getContainer(containerId).getTable();
                    table.chooseRowInTable(0);
                }

                app.getBaseHelperWithWebDriver().click(updateButton); // Нажать полученную кнопку. Будет для первой записи.

                checkStatus.checkPageStatus(debugLogs);

                boolean isModalForm = page.getCountOfModals() > 0; // Получим значение isModalForm - модальное окно или страница открылась.
                WebElement fieldsContainer;
                Form fieldsForm;

                if (isModalForm) // Если открылось модальное окно, то:
                {
                    fieldsContainer = app.getWebDriver().findElement(By.xpath("//*[contains(@class, 'n2o-modal-container')]"));// Получим контейнер
                    fieldsForm      = page.getModal().getForm();// Получим форму
                }
                else
                {
                    try
                    {
                        // todo  убрать сравнение текста
                        app.getWebDriver().findElement(By.xpath("//div[contains(@class, 'n2o-container')][.//button[contains(@class, 'n2o-confirm') and normalize-space(text())='Сохранить']]")); // Должна открыться страница. Если открылась страница - то на ней должна быть кнопка "Сохранить". Попробуем ее найти.
                    }
                    catch(Exception e)
                    {
                        Assert.fail("Нет кнопки 'Сохранить'"); // Если кнопки "Сохранить" нет - то значит на странице нет формы для заполнения полей для создания. Тест падает. Выводим соответствующее сообщение.
                    }

                    fieldsContainer = app.getWebDriver().findElement(By.xpath("//div[contains(@class, 'n2o-container')][.//button[contains(@class, 'n2o-confirm') and normalize-space(text())='Сохранить']]")); // Если тест не упал до этого момента - значит на странице есть кнопка "Сохранить". Найдем контейнер с этой кнопкой.
                    fieldsForm      = page.getForm(); // Найдем форму.

                    assertThat("Page have error message", errorsSearchers.isErrorPresentsByContainerElement(fieldsContainer), equalTo("")); // Проверим, что на странице нет сообщений об ошибке.
                }

                if (fieldsContainer.findElements(By.cssSelector(".n2o-form-widget.n2o-readonly")).size() == 0) // Если форма не readonly, то:
                {
                    String[] componentCssClasses = { // Создадим список, где будут css-классы всех компонентов, которые поддерживаются программой.
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
                        ".n2o-select-tree",
                        ".n2o-text-masked",
                        ".n2o-select-tree-diagnosis"
                    };

                    List<String> cssSelectorParts = new ArrayList<String>(); // будем записывать селекторы для каждого элемента.

                    for (String cssClass: componentCssClasses)
                    {
                        String cssSelectorPart = "";

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

                    List<WebElement> fieldElements              = fieldsContainer.findElements(By.cssSelector(cssSelector.toString())); // Найдем все элементы по строке-селектору.
                    List<ComponentBase> requiredComponents      = new ArrayList<ComponentBase>(); // Создадим список для обязательных компонентов(содержат звездочку)
                    List<ComponentBase> nonRequiredComponents   = new ArrayList<ComponentBase>(); // Создадим список для необязательных(которые не содержат звездочку) компонентов

                    for (WebElement fieldElement: fieldElements) // Будем брать каждый компонент в списке найденных и смотреть, есть ли у него звездочка(класс n2o-required-star)( обязательный или нет)
                    {
                        if (fieldElement.isDisplayed()) // Только если этот компонент видимый.
                        {

                            //WebElement controlLabelElement  = fieldElement.findElement(By.xpath("../../preceding-sibling::*[contains(@class, 'control-label')]"));
//                            WebElement controlLabelElement  = fieldElement.findElement(By.xpath("( ../ | ../../ )preceding-sibling::*[contains(@class, 'control-label')]"));
                            WebElement controlLabelElement  = fieldElement.findElement(By.xpath("( .. | ../.. )/preceding-sibling::*[contains(@class, 'control-label')]"));

                            boolean isRequired              = controlLabelElement.getAttribute("class").contains("n2o-required-star");
                            ComponentBase component         = fillComponents.getComponentFromElement(fieldsForm, fieldElement, false, null);

                            if (component != null)
                            {
                                if (isRequired)
                                {
                                    requiredComponents.add(component);    // Если есть класс n2o-required-star - добавить в список обязательных компонентов,
                                }
                                else
                                {
                                    nonRequiredComponents.add(component); //  если нет - то добавить в список необязательных компонентов.
                                }
                            }
                        }
                    }

                    // Если нет ни одного обязательного и ни одного необязательно поля - то значит на форме нет полей. (либо есть поля, которые не учтены в программе)
                    if (requiredComponents.size() == 0 && nonRequiredComponents.size() == 0)
                    {
                        debugLogs.containersInfoLog(pageHref, containerId, url);

                        Assert.fail("In modal window form no fields!"); // Тест падает. Вывести сообщение, что на форме нет полей.
                    }
                    else
                    {
                        fillComponents.fillFields(requiredComponents, nonRequiredComponents, containerId, fieldsContainer, isModalForm, ContainerButtonType.Edit, debugLogs);
                        break;
                    }
                }
            }

        }
    }

    /**
     * Удаление записи
     * Выделяет первую запись в таблице в нужном контейнере (containerId) и нажимает кнопку "Удалить".
     *
     * @param pageHref
     * @param containerId
     * @param url
     * @throws Exception
     */
    public void doDelete(String pageHref, String containerId, String url, DebugLogs debugLogs) throws Exception
    {
        debugLogs.printDoDeleteInfo();
        int deleteButtonNumber = 0; // Номер кнопки Редактировать или Изменить

        while (true)
        {
            List<WebElement> allDeleteButtons = app.getBaseHelperWithWebDriver().findElements(
                    By.xpath(".//button[normalize-space(string())='Удалить' or normalize-space(string()) = 'Удалить(Enter)' or normalize-space(string()) = 'Удалить (Enter)' or normalize-space(string()) = 'Удалить(Del)' or normalize-space(string()) = 'Удалить (Del)']"),
                    page.getContainer(containerId).takeContainer()); // Найдем все кнопки Удалить, и запишем их в список.

            if (deleteButtonNumber >= allDeleteButtons.size()) // Если список пуст, то завершить работу с этим контейнером.
            {
                break;
            }

            if (page.getContainer(containerId).getTree().isTreeContainerFound())
            {
                Tree tree = page.getContainer(containerId).getTree();

                assertThat("Нет элементов в дереве. Удаление невозможно.", tree.getNodesCount(tree.takeTreeContainer()), greaterThan(0));
                tree.chooseFirstElement();
            }
            else if (page.getContainer(containerId).getTable().isTableFound())
            {
                Table table = page.getContainer(containerId).getTable();

                assertThat("Нет записей в таблице. Удаление невозможно.", table.getCountRowsInTable(true), greaterThan(0));
                table.chooseRowInTable(0);

            }
            WebElement deleteButton = allDeleteButtons.get(deleteButtonNumber); // Получим первую кнопку из списка
            deleteButtonNumber      = deleteButtonNumber + 1; // Увеличим номер кнопки на 1

            if (!deleteButton.isDisplayed()) // Если кнопка не отображена:
            {
                Assert.fail(String.format("Button is not displayed; pageHref = %s, containerId = %s", pageHref, containerId)); // Тест падает. Вывести сообщение, что кнопка не отображена.
            }

            if (!(deleteButton.getAttribute("class").contains("disabled"))) // Если кнопка не задизейблена
            {
                app.getActor().resetNetworkEventActors(); // Обнулить список NetworkEventActors
                app.getBaseHelperWithWebDriver().click(deleteButton); // Нажать полученную кнопку. Будет для первой записи.

                checkStatus.checkPageStatus(debugLogs);

                // Если появилось подтверждающее окно - нажать в нем "Да"
                if (page.getCountOfModals() > 0)
                {
                    page.getModal().getButton("confirm").click();
                }
                if (page.getDialog().isDialogPresents()) // Если на странице присутствует подтверждающее модальное окно - нажать в нем "Да"
                {
                    page.getDialog().clickYes();
                }

                if (page.getCountOfModals() > 0)
                {
                    Assert.fail("На странице осталось модальное окно");
                }

                assertThat(String.format("Page have error message: %s", errorsSearchers.isErrorPresentsByContainerId(containerId)), errorsSearchers.isErrorPresentsByContainerId(containerId), equalTo("")); // Проверим, что на странице нет сообщений об ошибке

            }

            break;
        }
    }
}
