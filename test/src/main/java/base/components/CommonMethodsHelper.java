package base.components;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.base.RandomDataGenerator;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import net.framework.autotesting.test.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CommonMethodsHelper extends Page
{
    public CommonMethodsHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Проверка неактивной кнопки через атрибут "disabled"
     */
    public void assertDisabledAttribute(Button button) {
        assertThat("Button is disabled", button.takeButton().getAttribute("disabled") == null);
    }

    /**
     * Если в комбобоксе нет записей, а в выпадающем списке есть строка "Ничего не найдено",
     * то возвращает true, иначе - false.
     */
    public Boolean isNoRecords(Classifier classifier) {
        List<WebElement> infoMessage = app.getBaseHelperWithWebDriver().findElements(By.className("info-message"), classifier.takeContainer());

        if (infoMessage.size() == 1 && infoMessage.get(0).getText().equals("Ничего не найдено")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Сравнивает, что хоть одно значение из списка ожидаемых выбранных значений совпадает с выбранным в списке
     *
     * @param values список значений, которые могут быть в классифаере
     */
    public void assertValue_oneOf(Classifier classifier, List<String> values) {

        Boolean found = false;
        if (values.size() == 0) {
            return;
        }

        for (String value : values) {
            if (classifier.getValue().equals(value)) {
                found = true;
            }
        }
        String fail_message = String.format("Chosen value %s in classifier is not equal to %s, %s", classifier.getValue(), values.get(0), values.get(1));
        assertThat(fail_message, found, is(true));
    }

    /**
     * Установка значения через sendKeys
     *
     * @param inputDate компонент, в который устанавливается значение
     * @param value значение, которое надо установить.
     */
    public void setValueBySendKeys(InputDate inputDate, String value) {
        inputDate.takeInputDateField().sendKeys(value);
        waitForNetworkAndJsIdle();
    }

    /**
     *  Проверяет что периоды даты недоступны для редактирования - должен быть атрибут disabled. (т.е. disabled != null)
     * @param isDisabled ожидаемый результат
     */
    public void assertThatBeginEndFieldsDisabled(InputDate inputDate, Boolean isDisabled) {
        Boolean beginResult = inputDate.takeBeginDatePeriod().getAttribute("disabled") != null;
        Boolean endResult   = inputDate.takeEndDatePeriod().getAttribute("disabled") != null;

        assertThat(String.format("Field '%s' was expected to be %s", inputDate.getLabelOrName() ,isDisabled ? "disabled" : "enabled"), beginResult, equalTo(isDisabled));
        assertThat(String.format("Field '%s' was expected to be %s", inputDate.getLabelOrName() ,isDisabled ? "disabled" : "enabled"), endResult, equalTo(isDisabled));
    }

        /**
     *  Проверяет что периоды даты недоступны для редактирования - должен быть атрибут disabled. (т.е. disabled != null)
     *  Возвращает true, если оба поля недоступны для редактирования, и false - иначе.
     */
    public boolean isBeginEndFieldsDisabled(InputDate inputDate)
    {
        Boolean beginResult = inputDate.takeBeginDatePeriod().getAttribute("disabled") != null;
        Boolean endResult   = inputDate.takeEndDatePeriod().getAttribute("disabled") != null;

        if (beginResult.equals(true) && endResult.equals(true)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Устанавливает значение value для поля и нажимает клавишу TAB для потери фокуса
     *
     * @param value значение, которое надо установить
     */
    public void setValue_Tab(InputText inputText, String value) {
        if (value == null || inputText.getValue().equals(value)) {
            return;
        }

        inputText.isPresent(true);
        type(inputText.takeField(), value);

        useKeys(Keys.TAB);
    }


    /**
     * Устанавливает значение value для поля без очистки значения в поле ( например, для полей с маской )
     *
     * @param value значение, которое надо установить
     */
    public void setValueWithoutClear(InputText inputText, String value) {
        if (value == null || inputText.getValue().equals(value)) {
            return;
        }

        inputText.isPresent(true);
        typeWithoutClear(inputText.takeField(), value);
    }

    /**
     * Устанавливает значение value для поля без очистки значения в поле ( например, для полей с маской ) и нажимает клавишу TAB для потери фокуса
     *
     * @param value значение, которое надо установить
     */
    public void setValueWithoutClear_Tab(InputText inputText, String value) {
        if (value == null || inputText.getValue().equals(value)) {
            return;
        }

        inputText.isPresent(true);
        typeWithoutClear(inputText.takeField(), value);

        useKeys(Keys.TAB);
    }

    /**
     * Выбор (нажатие) на радио кнопку зная ее порядковый номер
     */
    public void radioButtonPress(Radio radio, int number) {

        List<WebElement> radioButtons = radio.getRadioButtonList();
        radioButtons.get(number).click();
    }


    /**
     * Получить selected радио лэйбл из группы radio по name
     */
    public String getCheckedRadioLabel(Radio radioComponent) {
        List<String> selectedRadios = new ArrayList<>();
        List<WebElement> radioList  = radioComponent.getRadioButtonList();

        for (WebElement radio : radioList) {
            if (radio.isSelected()) {
                selectedRadios.add(getText(getParent(radio)));
            }
        }
        assertThat("Count of selected radio is 0", selectedRadios.size(), is(greaterThan(0)));
        assertThat("Count of selected radio greater than 1", selectedRadios.size(), is(lessThan(2)));
        return (selectedRadios.size() > 0) ? selectedRadios.get(0).trim() : "";
    }

   /**
    * Вернет, есть ли отмеченный элемент в группе радиокнопок.
    * @return true если есть, false - если нет
    */
    public boolean isCheckedLabel(Radio radioComponent) {
        List<String> selectedRadios = new ArrayList<>();
        List<WebElement> radioList  = radioComponent.getRadioButtonList();

        for (WebElement radio : radioList) {
            if (radio.isSelected()) {
                selectedRadios.add(getText(getParent(radio)));
            }
        }

        return selectedRadios.size() == 1;
    }

    /**
     * Выбирает первый возможный элемент
     */
    public String chooseFirstNode(SelectTree selectTree) {

        while (selectTree.getValue().equals("")) {
            dblClick(selectTree.getNodes(selectTree.takeContainer()).get(0).findElement(By.cssSelector("a")));
            WebElement parent2 = selectTree.getNodes(selectTree.takeContainer()).get(0);


            if (!selectTree.getValue().equals("")) {
                if (parent2.findElements(By.cssSelector(".n2o-std-tree-save")).size() == 1) {
                    clickDoneTreeButton(parent2);
                    return selectTree.getValue();
                }
                else {
                    return selectTree.getValue();
                }
            }
        }

        return null;
    }

     /**
     * Нажимает на кнопку "Закрыть" в дереве
     * @param nodes элементы
     * @return текст выбранного элемента.
     */
    public String clickCloseTreeButton(List<WebElement> nodes, WebElement parent) {
        String nodeText = nodes.get(0).getText();

        List<WebElement> closeButtons = parent.findElements(By.cssSelector(".n2o-st-tree-close"));

        if (closeButtons.size() > 0) {
            click(closeButtons.get(0));
        }
        return nodeText;
    }

    /**
     * Нажимает кнопку "Готово" в компоненте выбора диагноза
     * @param parent родительский элемент
     */
    public void clickDoneTreeButton(WebElement parent) {

        List<WebElement> closeButtons = parent.findElements(By.cssSelector(".n2o-std-tree-save"));

        if (closeButtons.size() > 0) {
            click(closeButtons.get(0));
        }

    }

    /**
     * Получает текст нода.
     *
     * @param node нод
     * @return текст нода
     */
    public String getNodeName(WebElement node) {
        System.out.printf("Текст нода: %s", getText(findElement(By.cssSelector("a"), node)));
        return getText(findElement(By.cssSelector("a"), node));
    }

    /**
     * Проверяет, что выбранное(установленное в качестве значения) значение равно ожидаемому
     * @param expectedValue ожидаемое значение
     */
    public void assertSelectedValueIs(SelectTree selectTree, String expectedValue) {
        assertThat(String.format("Value is not equals to %s", expectedValue), getSelectedValue(selectTree), equalTo(expectedValue));
    }

    public String getSelectedValue(SelectTree selectTree) {
        return findElement(By.cssSelector(".n2o-typeahead-header"), selectTree.takeContainer()).getAttribute("title").trim();
    }

    /**
     * Проверяет, что поле недоступно для редактирования - должен быть атрибут disabled. (т.е. disabled != null)
     * @param isDisabled ожидаемый результат
     */
    public void assertThatTextareaFieldIsDisabled(TextArea textArea, Boolean isDisabled) {
        Boolean result = textArea.takeTextArea().getAttribute("disabled") != null;
        assertThat(String.format("Field %s disabled", isDisabled ? "must" : "mustn't"), result, equalTo(isDisabled));
    }

    /**
     * Нажимает dropdown-toggle
     * Затем нажимает кнопку из его подменю.
     *
     * @param buttonText
     */
    public void clickDropdownToggle(Container container, String buttonText) {
        WebElement dropdown = container.getDropdownToggle();
        click(dropdown);
        click(findElement(By.xpath(String.format("//ul[@class='dropdown-menu']/li/a[contains(text(), '%s')]", buttonText))));
    }


    /**
     * Скрыть фильтр
     */
    public void hideFilter(Container container) {
        container.showFilter();
    }

    /**
     * Открытие страницы
     * @param pageId значение атрибута data-page-id нужной страницы
     */
    public void openPage(String pageId) {
        click(findElement(By.cssSelector(String.format("[data-page-id='%s']", pageId))));
    }

       /**
     * Выбираем контекст по тексту заголовка и тексту item'а
     */
    public void chooseContextByHeadingAndText(Header header, String item_heading, String item_text) {
        header.clickNavbar();
        click(header.takeContext());
        List<WebElement> elements = findElements(By.cssSelector(".n2o-header-contextNode"), header.takeHeader());

        for (WebElement element : elements) {
            // Если контекст новый:
            if (element.findElements(By.cssSelector("h4.list-group-item-heading")).size() > 0
                && element.findElements(By.cssSelector("p.list-group-item-text")).size() > 0)
            {
                 if ((element.findElement(By.cssSelector("h4.list-group-item-heading")).getText().equals(item_heading))
                 && element.findElement(By.cssSelector("p.list-group-item-text")).getText().contains(item_text))
                 {
                    click(element);
                    acceptAlertIfPresent();
                    waitForNetworkAndJsIdle();
                    break;
                 }
            }
            // Если контекст старый:
            else {
                if (element.getText().trim().equals(item_text.trim())) {
                    click(element);
                    acceptAlertIfPresent();
                    waitForNetworkAndJsIdle();
                    break;
                }
            }
        }
        waitForNetworkAndJsIdle();
    }

    /**
     *
     *
     * Выбираем контекст по тексту заголовка и тексту item'а
     */
    public void chooseContextAllVariants(Header header, String item_heading, String item_text) {

        header.clickNavbar();
        click(header.takeContext());
        List<WebElement> elements = findElements(By.cssSelector(".n2o-header-contextNode"), header.takeHeader());

        for (WebElement element : elements) {
            // Если контекст новый:
            if (element.findElements(By.cssSelector("h4.list-group-item-heading")).size() > 0
                && element.findElements(By.cssSelector("p.list-group-item-text")).size() > 0)
            {
                 if ((element.findElement(By.cssSelector("h4.list-group-item-heading")).getText().equals(item_heading))
                 && element.findElement(By.cssSelector("p.list-group-item-text")).getText().contains(item_text))
                 {
                    click(element);
                    acceptAlertIfPresent();
                    waitForNetworkAndJsIdle();
                    break;
                 }
            }
            // Если контекст старый:
            else {
                if (element.getText().trim().equals(item_text.trim())) {
                    click(element);
                    acceptAlertIfPresent();
                    waitForNetworkAndJsIdle();
                    break;
                }
            }
        }
        waitForNetworkAndJsIdle();
    }

    /**
     * @return заголовок модального окна
     */
    public String getModalHeader(Modal modal) {
        return findElement(By.cssSelector(".modal-header h3"), modal.takeModal()).getText().trim().toLowerCase();
    }

        /**
     * Получает все видимые контейнеры на странице
     * @return список видимых контейнеров
     */
    public List<WebElement> getVisibleContainers()
    {
        List<WebElement> visibleContainers  = new ArrayList<WebElement>();
        List<WebElement> containers         = findElements(By.cssSelector(".n2o-container.n2o-visible"));

        for (WebElement container : containers) {
            if (container.isDisplayed()) {
                visibleContainers.add(container);
            }
        }
        return visibleContainers;
    }

        public List<Integer> chooseGroupRowsByColumnValues(Table table, String columnName, List<String> valueList) {
        List<Integer> rows = new ArrayList<Integer>();

        List<Integer> rowNumbers = new ArrayList<>();
        for (String value : valueList) {
            Map<String, String> map = new HashMap<>();
            map.put(columnName, value);
            rowNumbers.add(table.getRowNumberBySeveralColumnValues(map, true));
        }

        keyDown(Keys.CONTROL);
        int countOfChosenRows = valueList.size();

        for (int i = 0; i < countOfChosenRows; i++) {
            rows.add(rowNumbers.get(i));

            if (!table.rowIsChosen(rowNumbers.get(i))) {
                table.chooseRowInTable(rowNumbers.get(i));
            }
        }
        keyUp(Keys.CONTROL);
        return rows;
    }


    /**
     * Проверяет в строке row в колонке columnName содержится ли icon
     */
    public void assertIconInRowOnColumn(Table table, int row, String columnName, String icon) {
        List<WebElement> list = table.getRowsInColumn(columnName, true);
        assertThat(String.format("Column %s in row %s not contains %s", columnName, row, icon), list.get(row).findElement(By.cssSelector("i")).getAttribute("class").trim(), is(icon));
    }

    public void assertThatTableContainsOnlyXRows(Table table, Integer x) {
        assertThat(String.format("In table count row doesn't equal %s", x), table.getCountRowsInTable(true), equalTo(x));
    }

    public String getRowValueInTable(Table table, int i, Boolean flag) {
        return table.getRowsInTable(flag).get(i).getText();
    }

        /**
     * Выбирает первый возможный элемент дерева
     */
    public boolean chooseFirstElement(Tree tree) {

        List<WebElement> nodes = tree.getNotHiddenNodes(); // список всех нодов

        if (nodes.size() > 0) {
            while (isNodeSelected(nodes.get(0))) {
                tree.chooseNode(nodes.get(0));

                if (isNodeSelected(nodes.get(0))) {
                    return true;
                }
                else {
                    tree.openNodeByMouse(getNodeName(nodes.get(0)));
                    nodes = tree.getNodes(nodes.get(0));

                    tree.chooseNode(nodes.get(0));

                    if (isNodeSelected(nodes.get(0))) {
                        return true;
                    }

                }

            }
        }
        return false;

    }
    /**
     * Возвращает, выбран элемент (true) или нет (false)
     *
     * @param node Элемент
     * @return выбран элемент (true) или нет (false)
     */
    public Boolean isNodeSelected(WebElement node) {
        WebElement element = findElement(By.cssSelector(".n2o-tree-el"), node);

        if (element.getAttribute("class").contains("selected")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Выбор первого элемента в дереве по тексту
     */
    public void chooseElementByText(Tree tree, String text) {
        click(tree.getTreeItemByText(text));
    }

    public List<WebElement> getTreeItemContainValue(Tree tree, String value) {
        List<WebElement> list = new ArrayList<>();
        for (WebElement element : getAllTreeFolderContent(tree)) {
            if (element.findElement(By.cssSelector(".tree-item-name")).getText().trim().contains(value)) {
                list.add(element);
            }
        }
        return list;
    }

    public List<WebElement> getAllTreeFolderContent(Tree tree) {
        return findElements(By.cssSelector(".tree-folder-content .tree-item"), tree.getTreeContainer());
    }

    public int randomIntInt(int from, int to)
    {
        return RandomDataGenerator.randomIntInt(from, to);
    }

    public String randomChar(int maxSize)
    {
        return RandomDataGenerator.randomChar(maxSize);
    }

    public String randomInt(int from, int to, int minLength)
    {
        return RandomDataGenerator.randomInt(from, to, minLength);
    }

    /**
     * Генерирует случайную строку из цифр
     * @param maximum максимальное количество символов в строке
     * @return случайную строку из цифр
     */
    public String selectRandomNumbers(int maximum)
    {
        String numbers  = "1234567890";
        int n           = numbers.length();
        Random r        = new Random();
        String str      = "";

        for (int i = 0; i < maximum; i++) {
            str = str + numbers.charAt(r.nextInt(n));
        }

        return str;
    }

    /**
     * Возвращает текущую дату
     */
    public String getCurrentDate(){
        return app.getBaseHelper().getCurrentDate();
    }

    /**
     * Возвращает текущую дату и время
     */
    public String getCurrentDateTime(){
        return app.getBaseHelper().getCurrentDateTime();
    }

    /**
     * Возвращает дату, добавив n дней к текущей дате (n отрицательное - вычитает)
     * @param n - кол-во дней
     */
    public String getDateBeforeAfterCurrent(int n) {
        return DateUtil.getDateBeforeAfterCurrent(n);
    }


    /**
     * @return текущее время в формате HH:mm
     */
    public String getCurrentTime() {
        return DateUtil.getCurrentTime();
    }

    /**
     * @param columnNumber - - номер столбца, в котором чекбокс.
     * @return все значения столбца
     */
    public List<WebElement> getRowsInColumn(Table table, int columnNumber, boolean withActiveRow) {
        List<WebElement> list = new ArrayList<>();

        for (WebElement element : table.getRowsInTable(withActiveRow)) {
            list.add(findElements(By.cssSelector(" td:not([class*='n2o-table_multi-select-column'])"), element).get(columnNumber));
        }
        return list;
    }

    public WebElement getCheckboxInRow(Table table, int row, int columnNumber, Boolean isActive) {
        return getRowsInColumn(table, columnNumber, isActive).get(row).findElement(By.cssSelector("input[type='checkbox']"));
    }

    /**
     * Нажатие на чекбокс в указанном ряду и строке
     *
     * @param row               - порядковый номер строки.
     * @param columnNumber      - номер столбца, в котором чекбокс.
     * @param isActive          - учитывать или нет активную строку таблицы.
     */
    public void chooseCheckboxInRow(Table table, int row, int columnNumber, Boolean isActive) {
        List<WebElement> list = new ArrayList<>();

        for (WebElement element : table.getRowsInTable(isActive)) {
            list.add(findElements(By.cssSelector("td:not([class*='n2o-table_multi-select-column'])"), element).get(columnNumber));
        }

        click(list.get(row).findElement(By.cssSelector("input[type='checkbox']")));
    }

    /**
     * Получение состояния чекбокса в строке row в столбце номер columnNumber
     *
     * @param row           - порядковый номер строки
     * @param columnNumber  - номер - номер столбца, в котором чекбокс.
     * @param isActive      - учитывать ли активную строку
     *
     * @return true, если чекбокс отмечен, false - иначе.
     */
    public boolean isCheckboxInRowChecked(Table table, int row, int columnNumber, boolean isActive) {

        if (getCheckboxInRow(table, row, columnNumber, isActive).getAttribute("checked") == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Нажимает на кнопку в выпадающем меню около таблицы
     * @param className     css-класс элемента списка
     * @param containerId   идентификатор контейнера
     */
    public void clickPointerMenu(String className, String containerId) {
        click(findElement(By.cssSelector(String.format("div[id*=%s] .%s", containerId, className))));
    }

}
