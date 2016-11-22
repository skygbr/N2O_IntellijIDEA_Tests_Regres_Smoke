package test.smoke;

import net.framework.autotesting.meta.components.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Класс содержит методы, которые выводят сообщения отладочной информации в консоль или в логи
 */
public class DebugLogs
{

    static Log log = LogFactory.getLog(DebugLogs.class);

    public Boolean isDebug;

    /**
     * Конструктор. Устанавливается значение isDebug
     *
     * @param isDebug Включен ли режим отладки.
     */
    public DebugLogs(Boolean isDebug)
    {
        this.isDebug = isDebug;
    }


    /** -------------------------------  Общая информация о странице, модуле, подстранице, контейнере -------------------------------------**/

    /**
     * Вывод информации о контейнере и модуле
     *
     * @param pageHref      информация о странице
     * @param containerId   id контейнера
     * @param url           URL страницы
     */
    public void containersInfoLog(String pageHref, String containerId, String url)
    {
        if (isDebug)
        {
            log.debug(String.format("\n--\n"));
            log.debug(String.format("moduleName = %s\n",    pageHref));
            log.debug(String.format("containerId = %s\n",   containerId));
            log.debug(String.format("URL = %s\n",           url));
            log.debug(String.format("--\n\n"));
        }
    }

    /**
     * Вывод информации о странице. pageHref - это очередной элемент, переданный от dataProvider к findAllContainers.
     * @param pageHref
     */
    public void printPageHref(String pageHref)
    {
        if (isDebug)
        {
            log.debug(String.format("-- %s\n", pageHref));
        }
    }

    /**
     * Вывод информации о названиях модуля, страницы и подстраницы
     *
     * @param moduleName    название модуля
     * @param pageName      название страницы
     * @param subPageName   название подстраницы
     */
    public void modulePageSubPageInfo(String moduleName, String pageName, String subPageName)
    {
        if(isDebug)
        {
            log.debug(String.format("Модуль %s, страница %s, подстраница %s\n", moduleName, pageName, subPageName));
        }
    }

    /**
     * Сообщение, что кнопка "Сохранить" была нажата
     */
    public void clickedConfirmButton()
    {
        if (isDebug)
        {
            log.debug(String.format("Button 'n2o-confirm' was clicked.\n"));
        }
    }


    /** ------------------------------- Метод проверки статуса HTTP. -------------------------------------**/

    /**
     * Проверка статуса HTTP началась
     */
    public void chechHTTPStatusStarted()
    {
        if (isDebug)
        {
            log.debug("checkHTTPStatus started (debug)");
        }
    }

    /**
     * Проверка статуса HTTP завершилась
     */
    public void chechHTTPStatusEnded()
    {
         if (isDebug)
        {
            log.debug("checkHTTPStatus ended");
        }
    }

    /**
     * Вывод статус-кода для страницы
     *
     * @param url           URL страницы
     * @param statusCode    статус-код
     */
    public void forUrlStatusCode(String url, int statusCode)
    {
        if (isDebug)
        {
            log.debug(String.format("for url %s status code: %s \n", url, statusCode));
        }
    }

    /**
     * Вывод ошибки, если была найдена в процессе проверки статуса страницы.
     *
     * @param e Объект Exception
     */
    public void checkHTTPStatusException(Exception e)
    {
        if (isDebug)
        {
            log.debug(String.format("checkHTTPStatus exception found! \n %s", e.getCause()));
        }
    }

    /**
     * Выводит сообщение, что начата проверка статуса страницы
     */
    public void checkPageStatusStarted()
    {
        if (isDebug)
        {
            log.debug(String.format("checkPageStatus started\n"));
        }
    }

    /**
     * Выводит сообщение, что закончена проверка статуса страницы
     */
    public void checkPageStatusEnded()
    {
        if (isDebug)
        {
            log.debug(String.format("checkPageStatus ended\n"));
        }
    }

    /**
     * Выводит сообщение при ошибке при проверке статуса страницы
     * @param statusCode код ошибки
     */
    public void errorCheckPageStatus(int statusCode)
    {
        if (isDebug)
        {
            log.debug(String.format("checkPageStatus isError \n, statusCode is %s\n", statusCode));
        }
    }

    /**
     * Выводит сообщение при ошибке после assert в методе checkHttpStatus
     * @param message сообщение
     */
    public void errorAfterAssertPageStatus(StringBuilder message)
    {
        if (isDebug)
        {
            log.debug(String.format("checkPageStatus after assert.fail - throw new exception \n%s", message.toString()));
        }
    }



    /** ------------------------------- Вывод значений компонентов -------------------------------------**/

    /**
     * Выводит значения мультиклассифаера
     *
     * @param multiClassifier
     */
    public void printMultiClassifierValues(MultiClassifier multiClassifier)
    {
        if (isDebug)
        {
            StringBuilder sb = new StringBuilder();

            for (String value: multiClassifier.getMultiValues())
            {
                if (sb.length() > 0)
                {
                    sb.append(", ");
                }
                sb.append(value);
            }

            log.debug(String.format("fillComponent(): Classifier %s значение %s\n", multiClassifier.getDataFieldId(), sb));
        }
    }

    /**
     * Вывод значения классифаера
     *
     * @param classifier
     */
    public void printClassifierValue(Classifier classifier)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): Classifier %s значение %s\n", classifier.getDataFieldId(), classifier.getValue()));
        }
    }

    /**
     * Вывод начального значения компонента inputDate
     * @param datePicker
     */
    public void printBeginDateValue(InputDate datePicker)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): InputDate %s значение BeginValue %s\n", datePicker.getName(), datePicker.getBeginValue()));
            log.debug(String.format("Установлено значение %s\n", datePicker.getBeginValue()));
        }
    }

    /**
     * Вывод конечного значения компонента inputDate
     *
     * @param datePicker
     */
    public void printEndDateValue(InputDate datePicker)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): InputDate %s значение EndValue %s\n", datePicker.getName(), datePicker.getEndValue()));
            log.debug(String.format("Установлено значение %s\n", datePicker.getEndValue()));
        }
    }

    /**
     * Вывод значения inputDate(не интервального)
     * @param datePicker
     */
    public void printDateValue(InputDate datePicker)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): InputDate %s значение %s\n", datePicker.getName(), datePicker.getValue()));
            log.debug(String.format("Установлено значение %s\n", datePicker.getValue()));
        }
    }

    /**
     * Вывод значения компонента Textarea
     * @param textArea
     */
    public void printTextareaValue(TextArea textArea)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): TextArea %s значение %s\n", textArea.getName(), textArea.getValue()));
        }
    }

    /**
     * Вывод значения компонента inputText
     * @param inputText
     */
    public void printInputTextValue(InputText inputText)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): InputText %s значение %s\n", inputText.getName(), inputText.getValue()));
        }
    }

    /**
     * Вывод значения компонента inputText
     * @param inputMask
     */
    public void printInputMaskValue(MaskedInput inputMask)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): InputText %s значение %s\n", inputMask.getName(), inputMask.getValue()));
        }
    }

    /**
     * Выводит значение чекбокса
     * @param status Строка. "Начальное" или "Текущее" ("begin" или "current")
     */
    public void printCheckboxValue(String status, boolean value)
    {
        if (isDebug)
        {
            log.debug(String.format("Checkbox's %s value is %s\n", status, value));
        }
    }

    /**
     * Выводит результат сравнения начального и текущего значений чекбокса
     */
    public void printCompareStatus(boolean beginValue, boolean currentValue)
    {
        log.debug(String.format("Compare result: begin value: %s, current value: %s", beginValue, currentValue));
    }

    /** ------------------------------- Методы doCreate, doEdit и doDelete -------------------------------------**/

    /**
     * Вывод значения компонента select
     * @param select
     */
    public void printSelectValue(Select select)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): Select %s значение %s\n", select.getDataFieldId(), select.getValue()));
        }
    }

    public void printSelectTreeValue(SelectTree selectTree)
    {
        if (isDebug)
        {
            log.debug(String.format("fillComponent(): selectTree значение %s\n", selectTree.getValue()));
        }
    }

    /**
     * Вывод информации метода doCreate
     */
    public void printDoCreateInfo()
    {
        if (isDebug)
        {
            log.debug(String.format("Create\n"));
        }
    }

    /**
     * Вывод информации метода doEdit
     */
    public void printDoEditInfo()
    {
        if (isDebug)
        {
            log.debug(String.format("doEdit\n"));
        }
    }

    /**
     * Вывод информации метода doDelete
     */
    public void printDoDeleteInfo()
    {
        if (isDebug)
        {
            log.debug(String.format("doDelete\n"));
        }
    }

    /** ------------------------------- Сортировка. -------------------------------------**/

    /**
     * Выводит тип сортировки и параметр - до или после удаления
     *
     * @param beforeOrAfter
     * @param sortingType
     */
    public void printSortingType(String beforeOrAfter, String sortingType)
    {
        if(isDebug)
        {
            log.debug(String.format("%s тип сортировки: %s\n", beforeOrAfter, sortingType));
        }
    }

    /**
     * Выводит, есть или нет таблица в контейнере
     *
     * @param containerId
     * @param hasTable
     */
    public void printHasTable(String containerId, boolean hasTable)
    {
        if (isDebug)
        {
            log.debug(String.format("containerId = %s, hasTable = %s", containerId, hasTable));
        }
    }

    /**
     *
     * @param text
     */
    public void printTdText(String text)
    {
        System.out.println("Text of td is: " + text);
    }

    public void printTdTextWithIterationNumber(String text, int iteration)
    {
        System.out.printf("td's name = %s, iteration: %d\n", text, iteration);
    }


    /** ------------------------------- Фильтрация. -------------------------------------**/

}

