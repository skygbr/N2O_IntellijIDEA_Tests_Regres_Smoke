package test.smoke;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит список всех исключений. Каждое - TestInclusionInfo
 */
public class TestInclusions
{
    static Logger log = Logger.getLogger(TestInclusions.class);

    List<TestInclusionInfo> parsedInclusions;

    public List<TestInclusionInfo> getParsedInclusions()
    {
        return parsedInclusions;
    }

    public TestInclusions(String inclusions)
    {
       // Поделим получившуюся строку по запятым.
        String[] exceptions = inclusions.split(",");
        parsedInclusions    = new ArrayList<TestInclusionInfo>();

        // Для каждого элемента из получившегося массива:
        for (String exception: exceptions)
        {
            // Уберем лишние пробелы.
            String trimmedException = exception.trim();

            // Получим подстроки - pageHref и containerId
            int idx             = trimmedException.indexOf("?");

            if (idx == -1)
            {
                parsedInclusions.add(new TestInclusionInfo(trimmedException));
            }
            else
            {
                String pageHref     = trimmedException.substring(0, idx);
                String containerId  = trimmedException.substring(idx + 1);
                idx = containerId.indexOf("?"); // Есть ли после идентификатора контейнера список кнопок.

                if (idx == -1) // Если знака вопроса нет - то кнопок нет, и вызовем конструктор только для pageHref и containerId
                {
                    parsedInclusions.add(new TestInclusionInfo(pageHref, containerId));
                }
                else
                { // Иначе - есть кнопки. Получим идентификатор контейнера
                    String realContainerId  = containerId.substring(0, idx); // Знак вопроса - конец идентификатора контейнера
                    String buttonChars      = containerId.substring(idx + 1); // до конца строки от знака вопроса

                    List<ContainerButtonType> buttons = new ArrayList<ContainerButtonType>();
                    for (int i = 0; i < buttonChars.length(); i++)
                    {
                        char c = buttonChars.charAt(i);
                        switch (c)
                        {
                            case 'c' :
                                buttons.add(ContainerButtonType.Create);
                                break;

                            case 'e' :
                                buttons.add(ContainerButtonType.Edit);
                                break;

                            case 'd' :
                                buttons.add(ContainerButtonType.Delete);
                                break;
                        }
                    }
                    parsedInclusions.add(new TestInclusionInfo(pageHref, realContainerId, buttons));
                }
            }
        }
    }

    /**
     * Является ли страница целиком исключенной.
     *
     * @param pageHref
     * @return
     */
    public boolean isPageIncluded(String pageHref)
    {
        for (TestInclusionInfo testInclusionInfo : parsedInclusions)
        {
            // Случай, когда исключение страница целиком.
            if (pageHref.equals(testInclusionInfo.getPagehref()))
            {
                return true;
            }
        }
        log.debug(String.format("Page '%s' is not included", pageHref));
        return false;
    }

    /**
     * Является ли контейнер исключенным.
     *
     * @param containerIdentifier
     * @return
     */
    public boolean isContainerIncluded(ContainerIdentifier containerIdentifier)
    {
        for (TestInclusionInfo testInclusionInfo : parsedInclusions)
        {
            if (containerIdentifier.pageHref.equals(testInclusionInfo.getPagehref())
                && (testInclusionInfo.getContainerId() == null
                    || containerIdentifier.containerId.equals(testInclusionInfo.getContainerId())))
            {
                return true;
            }
        }
        log.debug(String.format("Container '%s'.'%s' is not included", containerIdentifier.pageHref, containerIdentifier.containerId));
        return false;
    }

    /**
     * Является ли данная кнопка исключенной
     *
     * @param button
     * @param containerIdentifier
     * @return
     */
    public boolean isButtonIncluded(ContainerIdentifier containerIdentifier, ContainerButtonType button)
    {
        for (TestInclusionInfo testInclusionInfo : parsedInclusions)
        {
            if (containerIdentifier.pageHref.equals(testInclusionInfo.getPagehref())
                && (testInclusionInfo.getContainerId() == null
                    || (containerIdentifier.containerId.equals(testInclusionInfo.getContainerId())
                        && (testInclusionInfo.getButtons() == null
                            || testInclusionInfo.getButtons().contains(button)))))
            {
                return true;
            }
        }
        log.debug(String.format("Button '%s'.'%s'.'%s' is not included", containerIdentifier.pageHref, containerIdentifier.containerId, button));
        return false;
    }
}
