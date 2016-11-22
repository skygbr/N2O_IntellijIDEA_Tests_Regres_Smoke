package test.smoke;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит список всех исключений. Каждое - TestExclusionInfo
 */
public class TestExclusions
{
    static Logger log = Logger.getLogger(TestExclusions.class);

    List<TestExclusionInfo> parsedExclusions;

    public List<TestExclusionInfo> getParsedExclusions()
    {
        return parsedExclusions;
    }

    public TestExclusions(String exclusions)
    {
       // Поделим получившуюся строку по запятым.
        String[] exceptions = exclusions.split(",");
        parsedExclusions    = new ArrayList<TestExclusionInfo>();

        if (exclusions.trim().isEmpty())
        {
            return;
        }

        // Для каждого элемента из получившегося массива:
        for (String exception: exceptions)
        {
            // Уберем лишние пробелы.
            String trimmedException = exception.trim();

            // Получим подстроки - pageHref и containerId
            int idx = trimmedException.indexOf("?");

            if (idx == -1)
            {
                parsedExclusions.add(new TestExclusionInfo(trimmedException));
            }
            else
            {
                String pageHref     = trimmedException.substring(0, idx);
                String containerId  = trimmedException.substring(idx + 1);
                idx = containerId.indexOf("?"); // Есть ли после идентификатора контейнера список кнопок.

                if (idx == -1) // Если знака вопроса нет - то кнопок нет, и вызовем конструктор только для pageHref и containerId
                {
                    parsedExclusions.add(new TestExclusionInfo(pageHref, containerId));
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
                    parsedExclusions.add(new TestExclusionInfo(pageHref, realContainerId, buttons));
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
    public boolean isPageExcluded(String pageHref)
    {
        PageHref pageHrefParsed = new PageHref(pageHref);
        for (TestExclusionInfo testExclusionInfo : parsedExclusions)
        {
            // Случай, когда исключен модуль целиком
            if (testExclusionInfo.isModuleExclusion()
                    && testExclusionInfo.getModuleId().equals(pageHrefParsed.getModuleId()))
            {
                log.debug(String.format("Module '%s' is excluded", pageHrefParsed.getModuleId()));
                return true;
            }
            // Случай, когда исключение страница целиком.
            if (testExclusionInfo.isPageExclusion()
                    && pageHrefParsed.getModuleId().equals(testExclusionInfo.getModuleId())
                    && pageHrefParsed.getPageId().equals(testExclusionInfo.getPageId()))
            {
                log.debug(String.format("Page '%s' is excluded", pageHref));
                return true;
            }
        }
        return false;
    }

    /**
     * Является ли контейнер исключенным.
     *
     * @param containerIdentifier
     * @return
     */
    public boolean isContainerExcluded(ContainerIdentifier containerIdentifier)
    {
        PageHref pageHrefParsed = new PageHref(containerIdentifier.pageHref);
        for (TestExclusionInfo testExclusionInfo : parsedExclusions)
        {
            if (       testExclusionInfo.isContainerExclusion()
                    && pageHrefParsed.getModuleId().equals(testExclusionInfo.getModuleId())
                    && pageHrefParsed.getPageId().equals(testExclusionInfo.getPageId())
                    && containerIdentifier.containerId.equals(testExclusionInfo.getContainerId()))
            {
                log.debug(String.format("Container '%s'.'%s' is excluded", containerIdentifier.pageHref, containerIdentifier.containerId));
                return true;
            }
        }
        return false;
    }

    /**
     * Является ли данная кнопка исключенной
     *
     * @param button
     * @param containerIdentifier
     * @return
     */
    public boolean isButtonExcluded(ContainerIdentifier containerIdentifier, ContainerButtonType button)
    {
        PageHref pageHrefParsed = new PageHref(containerIdentifier.pageHref);
        for (TestExclusionInfo testExclusionInfo : parsedExclusions)
        {
            if (       testExclusionInfo.isButtonsExclusion()
                    && pageHrefParsed.getModuleId().equals(testExclusionInfo.getModuleId())
                    && pageHrefParsed.getPageId().equals(testExclusionInfo.getPageId())
                    && containerIdentifier.containerId.equals(testExclusionInfo.getContainerId())
                    && testExclusionInfo.getButtons().contains(button))
            {
                log.debug(String.format("Button '%s'.'%s'.'%s' is excluded", containerIdentifier.pageHref, containerIdentifier.containerId, button));
                return true;
            }
        }
        return false;
    }
}
