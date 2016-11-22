package test.smoke;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.base.DevToolsClient.Protocol.NetworkEvent.NetworkEventActor;
import net.framework.autotesting.base.DevToolsClient.Protocol.NetworkEvent.ResponseContent;
import net.framework.autotesting.base.RandomDataGenerator;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Form;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.TextArea;
import net.framework.autotesting.test.DateUtil;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FillComponents
{
    ErrorsSearchers errorsSearchers;
    CheckStatus checkStatus;
    ApplicationManager app;
    Page page;

    /**
     * Конструктор. Устанавливает значение необходимых переменных.
     *
     */
    public FillComponents()
    {
        this.app        = ApplicationManager.getInstance();
        this.page       = Page.getInstance();
        errorsSearchers = new ErrorsSearchers();
        checkStatus     = new CheckStatus();
    }

    /**
     * Получение компонента через элемент
     *
     * @param form          форма
     * @param fieldElement  элемент
     * @return              компонент
     */
    public ComponentBase getComponentFromElement(Form form, WebElement fieldElement, boolean isFilter, Filter filter)
    {
        List<String> cssClasses = new ArrayList<String>();

        for (String cssClass: fieldElement.getAttribute("class").split(" "))
        {
            String trimmedClass = cssClass.trim();
            if (trimmedClass.length() > 0)
            {
                cssClasses.add(trimmedClass);
            }
        }


//        if (cssClasses.contains("rmis-mass-operations"))
//        {
//            String id                   = fieldElement.findElement(By.xpath("./ancestor::div[contains(@class, 'n2o-component')][@data-field-id]")).getAttribute("data-field-id");
//            String modalContainerId     = page.getModal().findElement(By.className("n2o-container")).getAttribute("id").replace("n2o:", "");
//            CheckboxGrid checkboxGrid   = page.getModal().getContainer(modalContainerId).getTable().getCheckboxGrid(id);
//
//            return checkboxGrid;
//
//        }

        if(cssClasses.contains("n2o-dateinterval"))
        {
            String id = fieldElement.findElement(By.xpath("./ancestor::div[contains(@class, 'n2o-component')][@data-field-id]")).getAttribute("data-field-id");
            InputDate dateinterval;

            if (!isFilter)
            {
                dateinterval = form.getInputDate(id);
            }
            else
            {
                dateinterval = filter.getInputDate(id);
            }

            return dateinterval;
        }

        else if (cssClasses.contains("n2o-multi-classifier"))
        {
            String id = fieldElement.findElement(By.xpath("./ancestor::div[contains(@class, 'n2o-component')][@data-field-id]")).getAttribute("data-field-id");
            MultiClassifier multiClassifier;

            if (!isFilter)
            {
                multiClassifier = form.getMultiClassifier(id);
            }
            else
            {
                multiClassifier = filter.getMultiClassifier(id);
            }
            return multiClassifier;
        }

        else if (cssClasses.contains("n2o-classifier"))
        {
            String id = fieldElement.findElement(By.cssSelector(".n2o-typeahead-main")).getAttribute("data-id");
            Classifier classifier;

            if(!isFilter)
            {
                classifier = form.getClassifier(id);
            }
            else
            {
                classifier = filter.getClassifier(id);
            }

            return classifier;
        }

        else if (cssClasses.contains("n2o-datepicker"))
        {
            String id = fieldElement.findElement(By.cssSelector("input[type='text']")).getAttribute("name");
            InputDate datePicker;

            if(!isFilter)
            {
                datePicker = form.getInputDate(id);
            }
            else
            {
                datePicker = filter.getInputDate(id);
            }
            return datePicker;
        }

        else if (cssClasses.contains("n2o-checkbox"))
        {
            String id = fieldElement.findElement(By.cssSelector("input[type='checkbox']:not(.n2o-create-more)")).getAttribute("name");
            InputCheckBox checkbox;

            if(!isFilter)
            {
                checkbox = form.getInputCheckBox(id);
            }
            else
            {
                checkbox = filter.getInputCheckBox(id);
            }
            return checkbox;
        }

        else if (cssClasses.contains("n2o-textarea"))
        {
            String id = fieldElement.findElement(By.cssSelector("textarea")).getAttribute("name");
            TextArea textArea;

            if(!isFilter)
            {
                textArea = form.getTextArea(id);
            }
            else
            {
                Assert.fail("В фильтре не реализован компонент TextArea");
                textArea = null;
            }
            return textArea;
        }
        else if (cssClasses.contains("n2o-select-tree"))
        {
            String id = fieldElement.findElement(By.xpath("./ancestor::div[contains(@class, 'n2o-component')][@data-field-id]")).getAttribute("data-field-id");
            SelectTree selectTree;

            if (!isFilter)
            {
                selectTree = form.getSelectTree(id);
            }
            else
            {
                selectTree = filter.getSelectTree(id);
            }

            return selectTree;
        }
        else if (cssClasses.contains("n2o-select"))
        {
            String id = fieldElement.findElement(By.xpath("./ancestor::div[contains(@class, 'n2o-component')][@data-field-id]")).getAttribute("data-field-id");
            Select select;

            if(!isFilter)
            {
                select = form.getSelect(id);
            }
            else
            {
                select = filter.getSelect(id);
            }
            return select;
        }

        else if (cssClasses.contains("n2o-radio-group"))
        {
            String id = fieldElement.findElement(By.cssSelector("input[type='radio']")).getAttribute("name");
            Radio radio;

            if(!isFilter)
            {
                radio = form.getRadio(id);
            }
            else
            {
                radio = filter.getRadio(id);
            }
            return radio;
        }

        else if (cssClasses.contains("n2o-text"))
        {
            String id;
            if (fieldElement.findElements(By.cssSelector("input[type='text']")).isEmpty()) {
                id = fieldElement.findElement(By.cssSelector("input[type='number']")).getAttribute("name");
            }
            else {
                id = fieldElement.findElement(By.cssSelector("input[type='text']")).getAttribute("name");
            }

            InputText inputText;

            if(!isFilter)
            {
                inputText = form.getInputText(id);
            }
            else
            {
                inputText = filter.getInputText(id);
            }
            return inputText;
        }
        else if (cssClasses.contains("n2o-text-masked"))
        {
            String id = fieldElement.findElement(By.cssSelector("input[type='text']")).getAttribute("name");

            MaskedInput maskedInput;
            if (isFilter)
            {
                maskedInput = filter.getMaskedInput(id);
            }
            else
            {
                maskedInput = form.getMaskedInput(id);
            }

            return maskedInput;
        }
        else
        {
            return null;
        }
    }
    /**
     * Заполнение компонента Textarea
     * @param textArea
     */
    public boolean fillTextarea(TextArea textArea, DebugLogs debugLogs)
    {
        if (textArea.isDisabled())
        {
            return false;
        }

        // Если в текстареа нет символов:
        if (textArea.getValue().equals(""))
        {
            textArea.setValue(RandomDataGenerator.randomChar(5));
            debugLogs.printTextareaValue(textArea);
            return true; // заполнить удалось
        }
        else
        {
            debugLogs.printTextareaValue(textArea);
            return false; // заполнить не удалось
        }

    }

    /**
     * Заполнение компонента MultiClassifier
     * @param multiClassifier MultiClassifier
     */
    public boolean fillMultiClassifier(MultiClassifier multiClassifier, DebugLogs debugLogs)
    {

        if (multiClassifier.isDisabled())
        {
            return false;
        }

        multiClassifier.openCombobox();

        int valuesCount = multiClassifier.getValues().size();

        multiClassifier.closeCombobox();

        if (valuesCount > 0)
        {
            multiClassifier.setValue(0);

            debugLogs.printMultiClassifierValues(multiClassifier);
            return true;
        }
        else
        {
            debugLogs.printMultiClassifierValues(multiClassifier);
            return false;
        }
    }

    /**
     * Заполнение компонента Classifier
     *
     * @param classifier Classifier
     */
    public boolean fillClassifier(Classifier classifier, DebugLogs debugLogs, ContainerButtonType action)
    {
        if (classifier.isDisabled())
        {
            return false;
        }

        if (classifier.findModalButton() != null)
        {
            return fillModalSearchClassifier(classifier, debugLogs, action);
        }
        else if (action != null)
        {
            return fillRegularClassifier(classifier, debugLogs, action);
        }
        else
        {
            return fillRegularClassifier(classifier, debugLogs, null);
        }
    }

    /**
     * Заполнение classifier с выбором из модального окна
     * @param classifier заполняемый classifier
     * @param debugLogs для отладки
     * @param action create (при создании записи) или edit (при редактировании записи)
     * @return Удалось ли заполнить
     */
    private boolean fillModalSearchClassifier(Classifier classifier, DebugLogs debugLogs, ContainerButtonType action)
    {
        if (action == ContainerButtonType.Create)
        {
            classifier.findModalButtonClick(); // нажать на кнопку с лупой

            // Два случая: либо это компонент выбора пациента - тогда ищем пациента
            // Либо это компонент дерево в модальном окне

            if(page.getModal().findElements(By.cssSelector(".fuelux .n2o-tree-body.tree")).size() == 1)
            {
                System.out.println("tree found!!");

                if (page.getModal().getTree().chooseFirstElement())
                {
                    if (page.getModal().findElements(By.cssSelector(".n2o-modal-dictionary .confirm")).size() == 1)
                    {
                        Button confirmButton;

                        confirmButton = page.getModal().getButton("confirm"); // Если сообщений об ошибке в модальном окне нет - то нажмем кнопку "Сохранить"

                        // todo использовать метод isDisabled ( false)
                        confirmButton.assertDisabledAttribute();    // Ожидается, что кнопка "Сохранить" должна быть активна.

                        app.getActor().resetNetworkEventActors(); // Обнулить список NetworkEventActors
                        confirmButton.click();                      // Если кнопка активна - то ее нажать.
                        return true;
                    }
                    else
                    {
                        Assert.fail("Нет кнопки confirm");
                        return false;
                    }

                }
                else
                {
                    return false;
                }
            }
            else
            {
                fillPatientSearchField();
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Заполнение classifier с выбором из выпадающего списка
     * @param classifier заполняемый classifier
     * @param debugLogs для отладки
     * @param action create (при создании записи) или edit (при редактировании записи)
     * @return Удалось ли заполнить
     */
    private boolean fillRegularClassifier(Classifier classifier, DebugLogs debugLogs, ContainerButtonType action)
    {
        String currentValue = classifier.getValue();

        if (currentValue.equals("") || action == null) // Если пустое значение или если это фильтр
        {
            classifier.openCombobox();
            if (!classifier.isNoRecords())
            {
                List<String> values     = classifier.getValues();
                Integer notEmptyIndex = findNotEmptyElement(values);

                if (notEmptyIndex != null)
                {
                    classifier.setValue(notEmptyIndex);
                    debugLogs.printClassifierValue(classifier);
                    return true;
                }
                else
                {
                    classifier.closeCombobox();
                    return false;
                }
            }
            else
            {
                classifier.closeCombobox();
                return false;
            }
        }
        else if (action == ContainerButtonType.Edit)
        {
            classifier.openCombobox();
            List<String> values = classifier.getValues();

            Integer notEqualIndex = findNotEqualElement(values, currentValue);
            if (notEqualIndex != null)
            {
                classifier.setValue(notEqualIndex);
                debugLogs.printClassifierValue(classifier);
                return true;
            }
            else
            {
                classifier.closeCombobox();
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    /**
     * Поиск непустого значения комбобокса
     *
     * @param values список значений комбобокса
     * @return индекс непустого элемента или null
     */
    private Integer findNotEmptyElement(List<String> values)
    {
        for (int i = 0; i < values.size(); i++)
        {
            if (values.get(i) != null && !"".equals(values.get(i).trim()))
            {
                return i;
            }
        }
        return null;
    }


    /**
     * Найти индекс элемента списка values, _не_ совпадающего с currentValue. Если нет такого элемента, вернуть null.
     * @param values Список значений
     * @param currentValue Значение для сравнения
     * @return Индекс несовпадающего элемента или null
     */
    private Integer findNotEqualElement(List<String> values, String currentValue)
    {
        for (int i = 0; i < values.size(); i++)
        {
            if (values.get(i) != null && !"".equals(values.get(i).trim()) && !currentValue.equals(values.get(i)))
            {
                return i;
            }
        }
        return null;
    }

    /**
     * Заполнение компонента InputDate
     *
     * @param datePicker InputDate
     * @param action Create или Delete
     */
    public boolean fillInputDate(InputDate datePicker, ContainerButtonType action, DebugLogs debugLogs)
    {
        if (action == ContainerButtonType.Create || (action == null))
        {
            // Если поле - интервал дат:
            if((datePicker.takeContainer().findElements(By.xpath(".//input[contains(@class, 'begin')]")).size() > 0) && (datePicker.takeContainer().findElements(By.xpath(".//input[contains(@class, 'end')]")).size() > 0))
            {
                // Проверка, что оба поля доступны для редактирования
                if (datePicker.isBeginEndFieldsDisabled())
                {
                    return false;
                }

                if (datePicker.getBeginValue().equals("") || datePicker.getBeginValue().equals("__.__.____"))
                {
                    datePicker.setBeginDateValue(page.getCurrentDate());
                    debugLogs.printBeginDateValue(datePicker);
                }

                if (datePicker.getEndValue().equals("") || datePicker.getEndValue().equals("__.__.____"))
                {
                    datePicker.setEndDateValue(page.getCurrentDate());
                    debugLogs.printEndDateValue(datePicker);
                }
                return true;
            }
            else // Иначе - если компонент просто поле даты
            {
                // Проверка, что поле доступно для редактирования
                if (datePicker.isDisabled())
                {
                    return false;
                }

                if ((datePicker.getValue().equals("")) || (datePicker.getValue().equals("__.__.____")))
                {
                    datePicker.setValue(page.getCurrentDate());
                    debugLogs.printDateValue(datePicker);
                }
                return true;

            }
        }
        else // Если редактирование - то надо к дате прибавить 1 день, чтоб значение изменить в поле
        {

            if((datePicker.takeContainer().findElements(By.xpath(".//input[contains(@class, 'begin')]")).size() > 0) && (datePicker.takeContainer().findElements(By.xpath(".//input[contains(@class, 'end')]")).size() > 0))
            {
                datePicker.setEndDateValue(DateUtil.getDateBeforeAfterCurrent(1));
                debugLogs.printEndDateValue(datePicker);
            }
            else // Иначе - если компонент просто поле даты
            {
                if (datePicker.getValue().equals(page.getCurrentDate()))
                {
                    datePicker.setValue(DateUtil.getDateBeforeAfterCurrent(2));
                }
                else
                {
                    datePicker.setValue(page.getCurrentDate());
                }
                debugLogs.printDateValue(datePicker);
            }
            return true;

        }
    }

    /**
     * Заполнение компонента Select
     *
     * @param select Select
     */
    public boolean fillSelect(Select select, DebugLogs debugLogs, ContainerButtonType action)
    {
        if (select.isDisabled())
        {
            return false;
        }
        String currentValue = select.getValue();

        if (currentValue.equals("") || (action == null))
        {
            List<String> values = select.getAllSelectOptionsAsStringTexts();
            Integer idx = findNotEmptyElement(values);
            if (idx == null)
            {
                return false;
            }
            else
            {
                select.selectOption(idx);
                debugLogs.printSelectValue(select);
                return true;
            }
        }
        else if (action == ContainerButtonType.Edit)
        {
            List<String> values = select.getAllSelectOptionsAsStringTexts();
            Integer idx = findNotEqualElement(values, currentValue);
            if (idx == null)
            {
                return false;
            }
            else
            {
                select.selectOption(idx);
                debugLogs.printSelectValue(select);
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Заполняет компонент радио. Отмечает первый не равный выбранному компонент.
     * Если нет ни одного отмеченного компонента в группе - то отмечает первый.
     *
     * @param radio     компонент radio
     * @param debugLogs логи
     * @param action    действие ( создание, редактирование или удаление )
     *
     * @return заполнил (true) или нет (false)
     */
    public boolean fillRadio(Radio radio, DebugLogs debugLogs, ContainerButtonType action)
    {
        if (radio.isDisabled())
        {
            return false;
        }

        List<String> allRadioLabels = new ArrayList<String>();      // Список всех текстов элементов

        if (radio.isCheckedLabel())
        {
            String selectedLabel = radio.getCheckedRadioLabel(); // Выбранный на данный момент элемент
            allRadioLabels       = radio.getAllRadioLabels(); // Заполним список всех текстов элементов

            for (String radioLabel : allRadioLabels)    // Для каждого элемента смотрим, если текст не совпадает с выбранным ( первый такой найдем) - то его отметим
            {
                if (!radioLabel.equals(selectedLabel))
                {
                    radio.radioButtonPress(radioLabel);
                    return true;
                }
            }
        }
        else
        {
            radio.radioButtonPress(0);
            return true;
        }

        return false;
    }


    /**
     * Заполнение компонента InputText
     * @param inputText InputText
     */
    public boolean fillInputText(InputText inputText, DebugLogs debugLogs, ContainerButtonType action, boolean isFilter)
    {
        if (!inputText.isDisabled())
        {
            WebElement inputElement     = inputText.takeField();
            String inputMask            = inputElement.getAttribute("data-text-mask");
            boolean isTimeInput         = "99:99".equals(inputMask);
            boolean isAutoNumberInput   = "Б999ББ".equals(inputMask);
            JavascriptExecutor js       = (JavascriptExecutor)ApplicationManager.getCurrentInstance().getWebDriver();

            String newValue;

            if (isAutoNumberInput)
            {
                newValue = "А111АА";
            }
            else if (isTimeInput)
            {
                newValue = page.getCurrentTime();
            }
            else
            {
                // Установка значения с очисткой поля.
//                inputText.setValueWithoutClear(RandomDataGenerator.selectRandomNumbers(5));

                // Вернуть, когда поправят https://jira.i-novus.ru/browse/HOTTESTLSD-6318
                // Установка значения без очистки поля.
//                Date d              = new Date();
//                SimpleDateFormat f  = new SimpleDateFormat("ddMMyy");
//                newValue            = f.format(d);
                newValue = RandomDataGenerator.randomInt(4);
            }

            if (inputText.getValue().equals("") && !isTimeInput)
            {
                if (isFilter)
                {
                    inputText.setValueWithoutClear_Tab("2147483647"); // 2 в 31 степени
                }
                else
                {
                      // Вернуть, когда поправят https://jira.i-novus.ru/browse/HOTTESTLSD-6318
//                    Date d              = new Date();
//                    SimpleDateFormat f  = new SimpleDateFormat("HHmmss");
//                    inputText.setValueWithoutClear_Tab(newValue + f.format(d));
//
                    inputText.setValueWithoutClear_Tab(newValue + "1234");
                }
            }
            else if (isTimeInput)
            {
                inputText.setValue_Tab(newValue);
            }
            else
            {
                if (isFilter)
                {
                    inputText.setValueWithoutClear_Tab("2147483647"); // 2 в 31 степени
                }
                else
                {
//                    Date d              = new Date();
//                    SimpleDateFormat f  = new SimpleDateFormat("HHmmss");
//                    inputText.setValue_Tab(newValue + f.format(d));
                      // Вернуть, когда поправят https://jira.i-novus.ru/browse/HOTTESTLSD-6318
                    inputText.setValue_Tab(newValue + "1234");
                }
            }

            js.executeScript("arguments[0].blur()", inputElement);
            ApplicationManager.getCurrentInstance().getBaseHelperWithWebDriver().waitForNetworkAndJsIdle();

            debugLogs.printInputTextValue(inputText);
            return true;
        }
        else
        {
            return false;
        }
    }

 /**
     * Заполнение компонента InputText
     * @param maskedInput maskedInput
     */
    public boolean fillMaskedInput(MaskedInput maskedInput, DebugLogs debugLogs, ContainerButtonType action, boolean isFilter)
    {
        if (!maskedInput.isDisabled())
        {
            WebElement inputElement     = maskedInput.takeMaskedInputField();
            String inputMask            = inputElement.getAttribute("data-text-mask");
            boolean isTimeInput         = "99:99".equals(inputMask);
            boolean isAutoNumberInput   = "Б999ББ".equals(inputMask);
            boolean is999Mask           = "9?99999999".equals(inputMask);
            boolean isHHmmSSmask        = "99:99:99".equals(inputMask);

            JavascriptExecutor js       = (JavascriptExecutor)ApplicationManager.getCurrentInstance().getWebDriver();

            String newValue;

            if (isAutoNumberInput)
            {
                newValue = "а111аа";
                app.getBaseHelperWithWebDriver().click(inputElement);
                maskedInput.setValue(newValue);
                app.getBaseHelperWithWebDriver().useKeys(Keys.TAB);
            }
            else if (isTimeInput)
            {
                newValue = page.getCurrentTime();
                maskedInput.setValue(newValue);
                app.getBaseHelperWithWebDriver().useKeys(Keys.TAB);
            }
            else if (is999Mask)
            {
                newValue = RandomDataGenerator.randomInt(4);
                maskedInput.setValue(newValue + "1234");
                app.getBaseHelperWithWebDriver().useKeys(Keys.TAB);
            }
            else if (isHHmmSSmask)
            {
                newValue = "11.11.11";
                maskedInput.setFocus();
                maskedInput.setValue(newValue);
                app.getBaseHelperWithWebDriver().useKeys(Keys.TAB);
            }
            else
            {
                newValue = RandomDataGenerator.randomInt(4);
                maskedInput.setValue(newValue + "1234");
                app.getBaseHelperWithWebDriver().useKeys(Keys.TAB);
            }

            js.executeScript("arguments[0].blur()", inputElement);
            ApplicationManager.getCurrentInstance().getBaseHelperWithWebDriver().waitForNetworkAndJsIdle();

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Заполняет компонент выбора пациента
     */
    private void fillPatientSearchField()
    {
        if (page.getCountOfModals() > 0) // открылось модальное окно.
        {
            if (page.getModal().getTable().getCountRowsInTable(true) == 0 ) // Если записей на странице в таблице нет - то это не компонент выбора пациента - а другой компонент. Где уже есть список записей
            {

                List<String> alphabet = Arrays.asList("а","б","в","г","д","е","ж","з","и","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","э","ю","я");
                boolean found = false;

                for (int i = 0; i < alphabet.size(); i++)
                {
                    page.getModal().getFilter().getInputText("surname").setValue(alphabet.get(i));
                    page.getModal().getFilter().clickFindButton();


                    // Проверка, что после поиска пациента в модальном окне нет сообщения об ошибке.
                    if (!errorsSearchers.isErrorPresentsInModalWindow().equals(""))
                    {
                        Assert.fail(String.format("После поиска пациента появилось сообщение об ошибке: %s", errorsSearchers.isErrorPresentsInModalWindow()));
                    }

                    if (page.getModal().getTable().getCountRowsInTable(true) > 0)
                    {
                        page.getModal().getTable().chooseRowInTable(0);
                        found = true;
                        break;
                    }
                }

                if (found == false)
                {
                    Assert.fail("Count of rows in table after patient searching is 0!");
                }

//                assertThat("Count of rows in table after patient searching is 0!", page.getModal().getTable().getCountRowsInTable(true), greaterThan(0));

            }

            if(app.getWebDriver().findElements(By.cssSelector("#modal-container .n2o-filter")).size() > 0) // Иначе - это компонент выбора пациента либо компонент выбора койки
            {
                assertThat("Count of rows in table after patient searching is 0!", page.getModal().getTable().getCountRowsInTable(true), greaterThan(0));
                page.getModal().getTable().chooseRowInTable(0);
            }
            else
            {
                try //если нет фильтра - может быть это компонент выбора койки.
                {
                    app.getBaseHelperWithWebDriver().click(page.getModal().findElement(By.cssSelector(".n2o-tree .tree-folder-content .tree-item.n2o-tree-el")));
                }
                catch (Exception e)
                {
                    Assert.fail("fillPatientSearchField(): No tree for click(if bedChoose), no filter for enter value(if patient search)");
                }
            }

            try
            {
                page.getModal().getButton("confirm").click();
            }
            catch (Exception ex3)
            {
                Assert.fail("no confirm button?");
            }
        }
        else
        {
            Assert.fail("expected patient choose modal window, but is not appears");
        }
    }


    /**
     * Заполняет все поля в фильтре.
     */
    public void fillAllFieldsFilter(List<ComponentBase> allFilterComponents, WebElement filter, DebugLogs debugLogs)
    {
        if (allFilterComponents.size() > 0) // Если есть что заполнять
        {
            for (ComponentBase component: allFilterComponents) // Для каждого компонента
            {
                if (isEmptyValue(component)) // Заполнять, только если компонент пустой
                {
                    fillComponent(component, null, debugLogs, filter, true); // Заполним, учитывая что buttonType тут нет, передаем null.
                }
            }
        }
    }

    /**
     * Заполняет все обязательные поля при создании.
     * Проверяет, доступна ли форма для изменения значения. (Readonly) Если недоступна - то тест падает.
     *
     * Заполняет все обязательные поля.
     * Если обязательных полей нет - то заполняет первое необязательное поле.
     */
    public void fillAllRequiredFieldsCreate(List<ComponentBase> requiredComponents, List<ComponentBase> nonRequiredComponents, String containerName, DebugLogs debugLogs, WebElement fieldsContainer)
    {
        if (app.getWebDriver().findElements(By.cssSelector(String.format("%s .n2o-form-widget.n2o-readonly", containerName))).size() > 0)
        {
            Assert.fail("form is readonly");
        }
        else
        {
            if (requiredComponents.size() > 0)
            {
                for (ComponentBase component: requiredComponents)
                {
                    fillComponent(component, ContainerButtonType.Create, debugLogs, fieldsContainer, false);
                }
            }
            else
            {
                for (ComponentBase component: nonRequiredComponents)
                {
                    // Если смогли заполнить один компонент, то следующие не трогать
                    if (fillComponent(component, ContainerButtonType.Create, debugLogs, fieldsContainer, false))
                    {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Заполняет все обязательные поля при редактировании.
     *
     * Проверяет, доступна ли форма для изменения значения. (Readonly) Если недоступна - то тест падает.
     *
     *
     * Берет первый необязательный контрол и меняет в нем значение.
     * Если нет необязательных контролов - то меняет значение в первом обязательном.
     *
     * ( На случай - чтобы не изменить нужное значение, тк значения обязательных полей могут использоваться в других тестах )
     */
    public void fillAllRequiredFieldsEdit(List<ComponentBase> requiredComponents, List<ComponentBase> nonRequiredComponents, String containerName, DebugLogs debugLogs, WebElement fieldsContainer)
    {
        if (app.getWebDriver().findElements(By.cssSelector(String.format("[data-container-id='%s'] .n2o-form-widget.n2o-readonly", containerName))).size() > 0)
        {
            // todo check selector
            Assert.fail("form is readonly");
        }
        else
        {
            List<ComponentBase> allComponents = new ArrayList<ComponentBase>(nonRequiredComponents);
            allComponents.addAll(requiredComponents);

            boolean isFilled = false;

            for (ComponentBase component : allComponents)
            {
                if (!isFilled || (requiredComponents.contains(component) && !isEmptyValue(component)))
                {
                    isFilled = isFilled || fillComponent(component, ContainerButtonType.Edit, debugLogs, fieldsContainer, false);
                }
                if (isFilled)
                {
                    break;
                }
            }

            // Падает, когда на форме все обязательные заполненные. Надо перезаполнить в таком случае. todo fix
            // todo если обязательный компонент задизейблен.
            // https://ci.i-novus.ru/job/n2o-app-tatar-smoke-at/91/allure/#/home/f19ce8589a7b1388/1b5b37b1c89b03cb/e7eb298ac241b7ee
            assertThat("Не удалось заполнить ни один компонент на форме", isFilled, is(true));
        }
    }

    /**
     * Возвращает true, если component не заполнен (имеет пустое значение)
     * @param component
     * @return
     */
    private boolean isEmptyValue(ComponentBase component)
    {
        if (component instanceof MultiClassifier)
        {
            MultiClassifier multiClassifier = (MultiClassifier)component;
            List<String> values             = multiClassifier.getMultiValues();
            return values.isEmpty();
        }
        else if (component instanceof Classifier)
        {
            Classifier classifier   = (Classifier)component;
            String value            = classifier.getValue();
            return value.equals("");
        }
        else if (component instanceof InputDate)
        {

            InputDate inputDate = (InputDate)component;

            if ((inputDate.takeContainer().findElements(By.xpath(".//input[contains(@class, 'begin')]")).size() > 0)
            && (inputDate.takeContainer().findElements(By.xpath(".//input[contains(@class, 'end')]")).size() > 0))
            {
                String beginValue   = inputDate.getBeginValue();
                String endValue     = inputDate.getEndValue();

                if ((beginValue.equals("") || beginValue.equals("__.__.____")) && (endValue.equals("") || endValue.equals("__.__.____")))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                String value = inputDate.getValue();
                return value.equals("");
            }
        }
        else if (component instanceof InputCheckBox)
        {
            InputCheckBox checkbox = (InputCheckBox)component;

            // Возвращаем true в любом случае. Даже если чекбокс не отмечен.
            // Потому что значение надо поменять в любом случае, неважно какое оно на данный момент, отмечено или нет.
            return true;
        }
        else if (component instanceof TextArea)
        {
            TextArea textArea   = (TextArea)component;
            String value        = textArea.getValue();
            return value.equals("");
        }
        else if (component instanceof InputText)
        {
            InputText inputText = (InputText)component;
            String value        = inputText.getValue();
            return value.equals("");
        }
        else if (component instanceof Select)
        {
            Select select   = (Select)component;
            String value    = select.getValue();
            return value.trim().equals("");
        }
        else if (component instanceof Radio)
        {
            Radio radio     = (Radio)component;
            return !radio.isCheckedLabel();
        }
        else if (component instanceof MaskedInput)
        {
            MaskedInput maskedInput = (MaskedInput)component;
            String value            = maskedInput.getValue();

            return value.contains("_") || value.trim().equals("");
        }
        else if (component instanceof  SelectTree)
        {
            SelectTree selectTree   = (SelectTree)component;
            String value            = selectTree.getValue();

            return value.trim().equals("");
        }
        else
        {
            throw new RuntimeException(String.format("isEmptyValue() is not implemented for %s", component.getClass().getName()));
        }
    }

    /**
     * Заполнение полей.
     * В зависимости от того, какого типа компонент - приводит его к этому типу и заполняет определенным для каждого компонента образом.
     *
     * @param component компонент
     */
    public boolean fillComponent(ComponentBase component, ContainerButtonType action, DebugLogs debugLogs, WebElement parentContainer, boolean isFilter)
    {
        if (component instanceof MultiClassifier)
        {
            return fillMultiClassifier((MultiClassifier) component, debugLogs);
        }
        else if (component instanceof Classifier)
        {
            return fillClassifier((Classifier) component, debugLogs, action);
        }
        else if (component instanceof InputDate)
        {
            return fillInputDate((InputDate) component, action, debugLogs);
        }
        else if (component instanceof InputCheckBox)
        {
            return fillCheckbox((InputCheckBox) component, debugLogs);
            //throw new RuntimeException(String.format("fillComponent() is not implemented for %s", component.getClass().getName()));
        }
        else if (component instanceof TextArea)
        {
            return fillTextarea((TextArea) component, debugLogs);
        }
        else if (component instanceof InputText)
        {
            return fillInputText((InputText) component, debugLogs, action, isFilter);
        }
        else if (component instanceof Select)
        {
            return fillSelect((Select) component, debugLogs, action);
        }
        else if (component instanceof Radio)
        {
            return fillRadio((Radio) component, debugLogs, action);
        }
        else if (component instanceof SelectTree)
        {
            return fillSelectTree((SelectTree) component, parentContainer, debugLogs);
        }
        else if (component instanceof MaskedInput)
        {
            return fillMaskedInput((MaskedInput) component, debugLogs, action, isFilter);
        }
//        else if (component instanceof CheckboxGrid)
//        {
//            return fillCheckboxGrid((CheckboxGrid) component);
//        }
        else
        {
            throw new RuntimeException(String.format("fillComponent() is not implemented for %s", component.getClass().getName()));
        }
    }

    /**
     * Заполнение компонента CheckboxGrid
     * Если в таблице есть хоть одна строка - выберем первую строку
     *
     * @param component компонент CheckboxGrid
     * @return true если заполнен, false - иначе.
     */
//    private boolean fillCheckboxGrid(CheckboxGrid component)
//    {
//
//        if (component.getRows().size() > 0) // Если есть хоть одна строчка в таблице
//        {
//            component.chooseRowInTable(0, true);
//            return true;
//        }
//
//        return false;
//    }

    /**
     * Заполнение чекбокса.
     * Получим значение чекбокса. (Начальное)
     * Нажмем чекбокс. (Либо поставится, либо снимется отметка)
     * Получим значение чекбокса. (Текущее)
     * Сравним начальное и текущее значение. Если они не равны - значит значение было изменено и смена значения произошла. Вернуть true.
     * Если они равны - то смена значения не произошла. Вернем false.
     *
     * @param checkBox
     * @param debugLogs
     * @return
     */
    private boolean fillCheckbox(InputCheckBox checkBox, DebugLogs debugLogs)
    {
        boolean beginValue = checkBox.getCheckedStatus();

        debugLogs.printCheckboxValue("begin", beginValue);
        checkBox.check();

        boolean currentValue = checkBox.getCheckedStatus();
        debugLogs.printCheckboxValue("current", currentValue);

        if(beginValue != currentValue)
        {
            debugLogs.printCompareStatus(beginValue, currentValue);
            return true;
        }
        else
        {
            debugLogs.printCompareStatus(beginValue, currentValue);
            return false;
        }
    }

    /**
     * Заполнение компонента SelectTree
     *
     * @param selectTree компонент
     *
     * @return заполнил (true) или нет (false)
     */
    private boolean fillSelectTree(SelectTree selectTree, WebElement parentContainer, DebugLogs debugLogs)
    {
        System.out.printf("selectTree found\n");
        selectTree.open();

        if (selectTree.chooseFirstNode(parentContainer) != null)
        {
            debugLogs.printSelectTreeValue(selectTree);
            return true;
        }

        return false;
    }

    // Заполнение полей фильтра.
    public void fillFilterFields(List<ComponentBase> filterComponents, String containerId, WebElement filter, DebugLogs debugLogs)
    {
        System.out.printf("fill filter fields\n");
        fillAllFieldsFilter(filterComponents, filter, debugLogs);
        System.out.printf("end of filling fields\n");

    }

    /**
     * Заполнение полей формы.
     * В зависимости от типа кнопки (buttonType) заполняем поля по разному алгоритму.
     *
     * @param requiredComponents    список обязательных компонентов
     * @param nonRequiredComponents список не обязательных компонентов
     * @param containerId           идентификатор контейнера
     * @param fieldsContainer       контейнер
     * @param isModalForm           модальное ли окно или форма открылась
     * @param buttonType            тип кнопки
     *
     * @return Идентификатор созданной записи (если buttonType = Create)
     * @throws Exception Exception бросается в методе checkPageStatus.
     */
    public Long fillFields(List<ComponentBase> requiredComponents, List<ComponentBase> nonRequiredComponents, String containerId,
                           WebElement fieldsContainer, Boolean isModalForm, ContainerButtonType buttonType, DebugLogs debugLogs) throws Exception
    {

        if (buttonType == ContainerButtonType.Create)
        {
            fillAllRequiredFieldsCreate(requiredComponents, nonRequiredComponents, containerId, debugLogs, fieldsContainer); // Если поля есть: заполняем все обязательные поля, либо если их нет - то заполнить первое необязательное поле.
        }
        else if (buttonType == ContainerButtonType.Edit)
        {
            fillAllRequiredFieldsEdit(requiredComponents, nonRequiredComponents, containerId, debugLogs, fieldsContainer); // Если поля есть: изменяем значение в первом необязательном поле, если необязательных полей нет - то изменить первое обязательное поле.
        }
        else
        {
            throw new RuntimeException("Тип кнопки должен быть либо Create либо Edit");
        }

        assertThat("Modal window have error message! ", errorsSearchers.isErrorPresentsByContainerElement(fieldsContainer), equalTo("")); // Проверка, что в модальном окне нет сообщений об ошибке.


        app.getActor().resetNetworkEventActors(); // Обнулить список NetworkEventActors

        app.getBaseHelperWithWebDriver().waitForNetworkAndJsIdle();
        if (isModalForm) //Если открыто модальное окно - то надо найти в нем кнопку с классом n2o-confirm и нажать.
        {

            String modalHeader = page.getModal().getModalHeader(); // Получим заголовок модального окна (на случай если в модальном окне есть сообщение об ошибке - выведем этот заголовок для более детальной информации.
            assertThat(String.format("Modal window %s have error message: %s", modalHeader, errorsSearchers.isErrorPresentsInModalWindow()), errorsSearchers.isErrorPresentsInModalWindow(), equalTo("")); // Проверим, что в модальном окне нет сообщений об ошибке.

            Button confirmButton;

            if (app.getBaseHelperWithWebDriver().findElements(By.xpath(".//div[contains(@class, 'btn-group')and not(contains(@class, 'n2o-hidden'))]//button[contains(@class, 'n2o-confirm') and not (contains(@disabled, 'disabled')) and contains(text(), 'Подтвердить') or contains (text(), 'Сохранить') or contains (text(), 'Изменить') or contains (text(), 'Добавить') or contains (text(), 'Назначить роль')]"), page.getModal().takeModal()).size() == 1)
            {
                confirmButton = page.getModal().getButton("n2o-confirm"); // Если сообщений об ошибке в модальном окне нет - то нажмем кнопку "Сохранить"
                // todo  использовать метод isDisabled(false)
                confirmButton.assertDisabledAttribute();    // Ожидается, что кнопка "Сохранить" должна быть активна.

                app.getActor().resetNetworkEventActors(); // Обнулить список NetworkEventActors
                confirmButton.click();                      // Если кнопка активна - то ее нажать.
            }

            //app.getActor().setSaveRequestAndResponseBodies(false);
            //app.getGlobalActor().setSaveRequestAndResponseBodies(false);

            if (page.getCountOfModals() > 0) // После нажатия кнопки "Сохранить", модальное окно должно закрыться. Если оно не закрылось - то может быть на нем есть сообщения валидации. Проверим.
            {
                isHelpBlockInPage();
                checkValidationMessage(requiredComponents, nonRequiredComponents, containerId, true);
            }

            // Если сообщений валидации нет и модальное окно закрылось - то если включен режим отладки - выведем сообщение, что кнопка была нажата
            debugLogs.clickedConfirmButton();
        }
        else
        {
            page.getButton("n2o-confirm").click(); // Если это не модальное окно - а страница, то нажать кнопку "n2o-confirm"

            isHelpBlockInPage();
            checkValidationMessage(requiredComponents, nonRequiredComponents, containerId, false); // Проверить, что на странице нет сообщений валидации

            // Если сообщений валидации нет - то, если включен режим отладки - выведем сообщение, что кнопка была нажата
            debugLogs.clickedConfirmButton();

        }

        // Если модальное окно настранце присутствует - то может быть, это подтверждающее модальное окно.
        if (page.getCountOfModals() > 0)
        {

            String modalHeader = page.getModal().getModalHeader(); // Получим заголовок модального окна.

            assertThat(String.format("Modal window %s have error message: %s", modalHeader, errorsSearchers.isErrorPresentsInModalWindow()), errorsSearchers.isErrorPresentsInModalWindow(), equalTo("")); // Проверим, что в модальном окне нет сообщений об ошибке

            checkStatus.checkPageStatus(debugLogs); // Проверим статус страницы.

            if (page.getDialog().isDialogPresents()) // Если на странице присутствует подтверждающее модальное окно - нажать в нем "Да"
            {
                page.getDialog().clickYes();
            }
        }

        page.acceptAlertIfPresent(); // то согласиться в подтверждающем alert
        if (page.getCountOfModals().equals(1) && !page.getModal().getButton("n2o-confirm").isDisplayed()) // Если на странице все еще (после соглашения в подтверждающем модальном окне) есть модальное окно,
        {
            page.getModal().closeModal(); // и закрыть модальное окно.
        }
        else if (page.getCountOfModals().equals(1) && !page.getModal().getButton("n2o-confirm").isDisplayed())
        {
            System.out.println("Осталось модальное окно с кнопкой подтверждения");
        }

        if (app.getWebDriver().findElements(By.cssSelector("button.back")).size() > 0) // Если была открыта страница вместо модалки - то надо нажать кнопку Назад, чтоб перейти к первоначальной странице
        {
            app.getWebDriver().findElement(By.cssSelector("button.back")).click();
        }
        try
        {
            app.getWebDriver().switchTo().alert().accept();
        }
        catch (NoAlertPresentException e)
        {
            // Если нет alert - то ничего не делать.
        }

        assertThat("page have error message", errorsSearchers.isErrorPresentsByContainerElement(page.getContainer(containerId).takeContainer()), equalTo("")); // Проверить, что на странице нет сообщений об ошибке.

        Long createdId = null;
        if (buttonType == ContainerButtonType.Create)
        {
            createdId = getCreatedId();
            app.getLogger().info(String.format("createdId = %d", createdId));
        }

        checkStatus.checkPageStatus(debugLogs); // Проверить статус страницы.
        return createdId;
    }


    /**
     * Проверяет, есть ли сообщение об ошибке(клиентская валидация) после нажатия кнопки "Сохранить"
     */
    private void isHelpBlockInPage()
    {
        List<WebElement> helpBlock = app.getBaseHelperWithWebDriver().findElements(By.xpath(".//span[contains(@class, 'help-block') and (string() != '')]"));

        if (helpBlock.size() > 0 && (!helpBlock.get(0).getText().equals("")))
        {
            Assert.fail(String.format("На странице есть сообщение об ошибке:\n %s\n", helpBlock.get(0).getText()));
        }
    }

    /**
     * Проверяет, есть ли у компонента сообщение о валидации
     *
     * @param requiredComponents    список обязательных компонентов
     * @param nonRequiredComponents список не обязательных компонентов
     * @param secondSubstring       id контейнера
     */
    private void checkValidationMessage(List<ComponentBase> requiredComponents, List<ComponentBase> nonRequiredComponents, String secondSubstring, Boolean isModal)
    {
        if (requiredComponents.size() > 0)
        {
            for (ComponentBase component: requiredComponents)
            {
                if (component instanceof InputDate)
                {
                    InputDate iDate = (InputDate) component;
                    if (((InputDate) component).takeContainer().getAttribute("class").contains("error"))
                    {
                        iDate.setValue(page.getCurrentDate());

                        if(isModal)
                        {
                            page.getModal().getButton("n2o-confirm").click();
                        }
                        else
                        {
                            page.getButton("n2o-confirm").click();
                        }

                        if (((InputDate) component).takeContainer().getAttribute("class").contains("error"))
                        {
                            String validationMessage = ((InputDate) component).takeContainer().findElement(By.cssSelector(".help-block")).getText();
                            Assert.fail(String.format("Component %s contains validation message: %s", iDate.getName(), validationMessage));
                        }
                    }
                }
            }
        }
        else
        {
            for (ComponentBase component: nonRequiredComponents)
            {
                if (component instanceof InputDate)
                {
                    InputDate iDate = (InputDate) component;
                    if (((InputDate) component).takeContainer().getAttribute("class").contains("error"))
                    {
                        iDate.setValue(page.getCurrentDate());

                        if(isModal)
                        {
                            page.getModal().getButton("n2o-confirm").click();
                        }
                        else
                        {
                            page.getButton("n2o-confirm").click();
                        }

                        if (((InputDate) component).takeContainer().getAttribute("class").contains("error"))
                        {
                            String validationMessage = ((InputDate) component).takeContainer().findElement(By.cssSelector(".help-block")).getText();
                            Assert.fail(String.format("Component %s contains validation message: %s", iDate.getName(), validationMessage));
                        }
                    }
                }
            }
        }
    }

    /**
     * Получает созданный id
     * @return
     * @throws Exception
     */
    public long getCreatedId() throws Exception {
        //https://rmis-prod.i-novus.ru/frontend/data?actionId=create&pageId=amb.call_place.left.create&containerId=single
        NetworkEventActor createResponseActor = null;
        for (NetworkEventActor actor: app.getActor().getNetworkEventActorsCopy())
        {
            String url = actor.initialInfo.url;
            if (actor.initialInfo.method.equals("POST") && url.contains("/data"))
//                    && url.contains("actionId=create"))
            {
                createResponseActor = actor;
//                break;
            }
        }
        if (createResponseActor == null)
        {
            Assert.fail("Не найден POST-запрос /data?actionId=create");
        }
        createResponseActor.waitForCompletion(new Date(new Date().getTime() + 60 * 1000));
        assertThat("POST-запрос на создание вернул код не 200", createResponseActor.getResponseStatusCode(), equalTo(200));
        ResponseContent response = createResponseActor.getResponseContent();
        assertThat("POST-запрос на создание вернул не JSON", response.mimeType, startsWith("application/json"));
        //{
        //   "data": {
        //     ...
        //     "id":47
        //   },
        //   "message": [
        //     { "severity": "success", "text": "Данные сохранены" }
        //   ]
        // }
        JsonObject responseJson = new Gson().fromJson(response.text, JsonObject.class);
        assertThat("JSON не содержит поле data", responseJson.get("data"), notNullValue());
        assertThat("В JSON поле data не является объектом", responseJson.get("data"), instanceOf(JsonObject.class));
        JsonObject responseData;
        if (responseJson.getAsJsonObject("data").get("id").isJsonPrimitive()) {
            responseData = responseJson.getAsJsonObject("data");
        }
        else {
            responseData = responseJson.getAsJsonObject("data").getAsJsonObject("id");
        }
            assertThat("JSON не содержит поле data.id", responseData.get("id"), notNullValue());
            assertThat("JSON в поле data.id содержит не число", responseData.get("id"), instanceOf(JsonPrimitive.class));
            assertThat("JSON в поле data.id содержит не число", responseData.getAsJsonPrimitive("id").isNumber(), is(true));


        long id = responseData.get("id").getAsLong();

        return id;
    }
}
