package businessFramework.entities.smoke;

import test.smoke.ContainerButtonType;
import test.smoke.ContainerIdentifier;
import test.smoke.PageDescription;
import test.smoke.TestExclusionInfo;

import java.io.*;
import java.util.*;

/**
 * Генерация страницы HTML о том, какие страницы покрыты смоук-тестом
 */
public class SmokeData
{

    public Map<String, PageDescription> pageDescriptions = new HashMap<>();
    public Map<ContainerIdentifier, TestCoverageItem> coveredItems;
    public List<String> coveredPages;
    public List<TestExclusionInfo> exclusions;
    public List<String> pageNames;

    public SmokeData()
    {
        exclusions   = new ArrayList<TestExclusionInfo>();
        pageNames    = new ArrayList<String>();
        coveredPages = new ArrayList<String>();
        coveredItems = new HashMap<ContainerIdentifier, TestCoverageItem>();
    }


    /**
     * Генерирует разметку HTML для страницы в WIKI
     */
    public void generateHtml(boolean isDebug, List<String> actions) throws IOException
    {
        if (isDebug)
        {
            System.out.println("generateHtml()");
        }

        StringBuilder s     = new StringBuilder();
        StringBuilder sb    = new StringBuilder();

        sortExclusions();
        sortCoveredPages();

        s.append("<table style = 'border:1px solid black;'>");

            s.append("<th style = 'border:1px solid black;'>№</th>");
            s.append("<th style = 'border:1px solid black;'>Модуль</th>");
            s.append("<th style = 'border:1px solid black;'>Страницы</th>");
            s.append("<th style = 'border:1px solid black;'>Контейнеры</th>");
            s.append("<th style = 'border:1px solid black;'>Действия</th>");
            s.append("<th style = 'border:1px solid black;'>Покрыт или нет</th>");
            s.append("<th style = 'border:1px solid black;'>Причина</th>");

        generateHTMLForNonExceptionsContainers(s, isDebug);
        generateHTMLForExceptionsContainers(isDebug, s);

        s.append("</table>");


        sb.append("<table style = 'border:1px solid black;'>");

            sb.append("<th style = 'border:1px solid black;'>№</th>");
            sb.append("<th style = 'border:1px solid black;'>Модуль</th>");
            sb.append("<th style = 'border:1px solid black;'>Страницы</th>");
            sb.append("<th style = 'border:1px solid black;'>Покрыт или нет</th>");

//        generateHTMLForNonExceptionsPages(sb, isDebug);
        generateHTMLForExceptionsPages(sb, isDebug);

        sb.append("</table>");
        writeLayoutToFile(s, sb);

    }

    /**
     * Запись разметки в файл
     */
    private void writeLayoutToFile(StringBuilder s, StringBuilder sb)
    {

        FileWriter writeContainers  = null;
        FileWriter writePages       = null;
        try
        {
            File layoutContainers   = new File("layoutContainers.txt");
            File layoutPages        = new File("layoutPages.txt");

            writeContainers         = new FileWriter(layoutContainers);
            writePages              = new FileWriter(layoutPages);

            writeContainers.write(s.toString());
            writePages.write(sb.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(writeContainers != null)
            {
                try{
                    writeContainers.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
             if(writePages != null)
            {
                try{
                    writePages.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Сортировка для вывода в HTML ( покрытые страницы)
     */
    private void sortCoveredPages()
    {
        coveredPages.sort(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                // < 0 - o1 < o2
                // = 0 - o1 = o2
                // > 0 - o1 > o2
                PageDescription pageDescription1 = pageDescriptions.get(o1);
                PageDescription pageDescription2 = pageDescriptions.get(o2);

                if (pageDescription1 == null)
                {
                    System.out.printf("Exception container %s: page not found\n", o1);
                    return 0;
                }
                if (pageDescription2 == null)
                {
                    System.out.printf("Exception container %s: page not found\n", o2);
                    return 0;
                }

                String pageName1 = pageDescription1.moduleName + " - " + pageDescription1.pageName + " - " + pageDescription1.subPageName;
                String pageName2 = pageDescription2.moduleName + " - " + pageDescription2.pageName + " - " + pageDescription2.subPageName;
                int r = pageName1.compareTo(pageName2);
                return r;
            }
        });
    }

    /**
     * Сортировка исключений для вывода в HTML
     */
    private void sortExclusions()
    {
        exclusions.sort(new Comparator<TestExclusionInfo>()
        {
            @Override
            public int compare(TestExclusionInfo o1, TestExclusionInfo o2)
            {
                // < 0 - o1 < o2
                // = 0 - o1 = o2
                // > 0 - o1 > o2
                PageDescription pageDescription1 = pageDescriptions.get(o1.getPageHref());
                PageDescription pageDescription2 = pageDescriptions.get(o2.getPageHref());

                if (pageDescription1 == null)
                {
                    System.out.printf("Exception container %s: page not found\n", o1.getPageHref());
                    return 0;
                }
                if (pageDescription2 == null)
                {
                    System.out.printf("Exception container %s: page not found\n", o2.getPageHref());
                    return 0;
                }

                int r = pageDescription1.moduleName.compareTo(pageDescription2.moduleName);

                if (r != 0)
                {
                    // если имена модулей не совпадают
                    return r;
                }
                else
                {
                    // если имена модулей совпадают
                    // используем имена страниц
                    String pageName1 = pageDescription1.pageName + " - " + pageDescription1.subPageName;
                    String pageName2 = pageDescription2.pageName + " - " + pageDescription2.subPageName;
                    r = pageName1.compareTo(pageName2);

                    if (r != 0)
                    {
                        // если имена страниц не совпадают
                        return r;
                    }
                    else
                    {
                        // если совпадают - сравниваем контейнеры
                        if (o1.getContainerId() == null && o2.getContainerId() == null)
                        {
                            // если оба исключения - страницы, то порядок не важен
                            return 0;
                        }
                        if (o1.getContainerId() == null)
                        {
                            return -1; // исключение страницы выше исключения контейнера
                        }
                        else if (o2.getContainerId() == null)
                        {
                            return 1; // исключение страницы выше исключения контейнера
                        }
                        else
                        {
                            // если исключения - контейнеры, то сравнить контейнеры
                            r = o1.getContainerId().compareTo(o2.getContainerId());
                            return r;
                        }
                    }
                }
            }
        });
    }

    /**
     * Генерирует строки HTML для страниц, которые в исключениях
     *
     * @param s строка типа StringBuilder
     * @param isDebug включен или нет режим отладки
     */
    private void generateHTMLForExceptionsPages(StringBuilder s, boolean isDebug)
    {
        int j = 0;
        for (TestExclusionInfo testExclusionInfo: exclusions)
        {
            if (!testExclusionInfo.isModuleExclusion() && !testExclusionInfo.isPageExclusion())
            {
                continue;
            }

            j = j + 1;

            if (isDebug)
            {
                System.out.println(testExclusionInfo.getPageHref());
            }

            PageDescription p = pageDescriptions.get(testExclusionInfo.getPageHref());

            if (p == null && testExclusionInfo.isModuleExclusion())
            {
                p = new PageDescription();
                p.moduleName = testExclusionInfo.getModuleId();
                p.pageName = "*";
                p.subPageName = "";
            }

            if (p == null)
            {
                System.out.printf("Exception page %s: not found\n", testExclusionInfo.getPageHref());
                continue;
            }

            if (isDebug)
            {
                System.out.printf("generateHTML() - moduleName: %s",    p.moduleName);
                System.out.printf("generateHTML() - pageName: %s",      p.pageName);
                System.out.printf("generateHTML() - subPageName: %s",   p.subPageName);
            }

            s.append("<tr style = 'border:1px solid black;'>");
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", j));
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", p.moduleName));
                s.append(String.format("<td style = 'border:1px solid black;'>%s - %s</td>", p.pageName, p.subPageName));
                s.append(String.format("<td style = 'border:1px solid black;'>Нет</td>"));
            s.append("</tr>");
        }
    }

    /**
     * Генерирует строки HTML для страниц, которые не в исключениях
     *
     * @param s строка типа StringBuilder
     * @param isDebug включен или нет режим отладки
     */
    private void generateHTMLForNonExceptionsPages(StringBuilder s, boolean isDebug)
    {
        for(int i = 0; i < coveredPages.size(); i++)
        {

            if (isDebug)
            {
                System.out.println(coveredPages.get(i));
            }

            PageDescription p = pageDescriptions.get(coveredPages.get(i));

            if (isDebug)
            {
                System.out.printf("generateHTML() - moduleName: %s",    p.moduleName);
                System.out.printf("generateHTML() - pageName: %s",      p.pageName);
                System.out.printf("generateHTML() - subPageName: %s",   p.subPageName);
            }

            s.append("<tr style = 'border:1px solid black;'>");
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", i + 1));
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", p.moduleName));
                s.append(String.format("<td style = 'border:1px solid black;'>%s - %s</td>", p.pageName, p.subPageName));
                s.append(String.format("<td style = 'border:1px solid black;'>Да</td>"));
            s.append("</tr>");
        }
    }

    /**
     * Генерирует строки таблицы HTML для контейнеров, которые не в исключениях
     *
     * @param s         строка типа StringBuilder
     * @param isDebug   включен или нет режим отладки
     */
    public void generateHTMLForNonExceptionsContainers(StringBuilder s, boolean isDebug)
    {
        List<TestCoverageItem> testCoverageItems = getSortedCoveredItems();

        for(int i = 0; i < testCoverageItems.size(); i++)
        {
            TestCoverageItem testCoverageItem = testCoverageItems.get(i);
            if (isDebug)
            {
                System.out.println(testCoverageItem.container.pageHref + " - " + testCoverageItem.container.containerId + " - " + testCoverageItem.buttons);
            }

            PageDescription pageDescription = pageDescriptions.get(testCoverageItem.container.pageHref);

            String moduleName   = pageDescription.moduleName;
            String pageName1    = pageDescription.pageName;
            String pageName2    = pageDescription.subPageName;
            String pageName     = pageName1 + " - " + pageName2;
            String containerId  = testCoverageItem.container.containerId;

            if (isDebug)
            {
                System.out.printf("generateHTML() - moduleName: %s",    moduleName);
                System.out.printf("generateHTML() - pageName: %s",      pageName);
                System.out.printf("generateHTML() - containerId: %s",   containerId);
            }

            s.append("<tr style = 'border:1px solid black;'>");
            s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", i + 1));
            s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", moduleName));
            s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", pageName));
            s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", containerId));


            List<ContainerButtonType> buttons  = testCoverageItem.buttons;
            StringBuilder buttonsStringBuilder = new StringBuilder();

            for (int j = 0; j < buttons.size(); j++)
            {
                buttonsStringBuilder.append(buttons.get(j));
            }

            s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", buttonsStringBuilder));
            s.append(String.format("<td style = 'border:1px solid black;'>Да</td>"));
            s.append(String.format("<td style = 'border:1px solid black;'></td>"));
            s.append("</tr>");
        }
    }

    /**
     * Получение отсортированных покрытых элементов
     * @return
     */
    private List<TestCoverageItem> getSortedCoveredItems()
    {
        List<TestCoverageItem> testCoverageItems = new ArrayList<TestCoverageItem>(coveredItems.values());
        testCoverageItems.sort(new Comparator<TestCoverageItem>()
        {
            @Override
            public int compare(TestCoverageItem o1, TestCoverageItem o2)
            {
                // < 0 - o1 < o2
                // = 0 - o1 = o2
                // > 0 - o1 > o2
                PageDescription pageDescription1 = pageDescriptions.get(o1.container.pageHref);
                PageDescription pageDescription2 = pageDescriptions.get(o2.container.pageHref);

                if (pageDescription1 == null)
                {
                    System.out.printf("Exception container %s-%s: page not found\n", o1.container.pageHref, o1.container.containerId);
                    return 0;
                }
                if (pageDescription2 == null)
                {
                    System.out.printf("Exception container %s-%s: page not found\n", o2.container.pageHref, o2.container.containerId);
                    return 0;
                }

                int r = pageDescription1.moduleName.compareTo(pageDescription2.moduleName);
                if (r != 0)
                {
                    // если имена модулей не совпадают
                    return r;
                }
                else
                {
                    // если имена модулей совпадают
                    // используем имена страниц
                    String pageName1 = pageDescription1.pageName + " - " + pageDescription1.subPageName;
                    String pageName2 = pageDescription2.pageName + " - " + pageDescription2.subPageName;
                    r = pageName1.compareTo(pageName2);

                    if (r != 0)
                    {
                        // если имена страниц не совпадают
                        return r;
                    }
                    else
                    {
                        // если совпадают - сравниваем контейнеры
                        r = o1.container.containerId.compareTo(o2.container.containerId);
                        return r;
                    }
                }
            }
        });
        return testCoverageItems;
    }

    /**
     * Генерирует строки таблицы HTML для контейнеров, которые в исключениях
     *
     * @param isDebug   включен или нет режим отладки
     * @param s         строка типа StringBuilder
     */
    private void generateHTMLForExceptionsContainers(boolean isDebug, StringBuilder s)
    {
        int j = 0;
        for (TestExclusionInfo testExclusionInfo: exclusions)
        {
            if (testExclusionInfo.isModuleExclusion() || testExclusionInfo.isPageExclusion())
            {
                continue;
            }

            j = j + 1;

            ContainerIdentifier exceptionContainer = testExclusionInfo.getContainerIdentifier();

            if (isDebug)
            {
                System.out.println(exceptionContainer.pageHref + " - " + exceptionContainer.containerId);
            }

            PageDescription pageDescription = pageDescriptions.get(exceptionContainer.pageHref);

            if (pageDescription == null)
            {
                System.out.printf("Exception container %s-%s: page not found\n", exceptionContainer.pageHref, exceptionContainer.containerId);
                continue;
            }

            String moduleName    = pageDescription.moduleName;
            String pageName1     = pageDescription.pageName;
            String pageName2     = pageDescription.subPageName;
            String pageName      = pageName1 + " - " + pageName2;
            String containerId   = exceptionContainer.containerId;
            StringBuilder buttonsStringBuilder = new StringBuilder();

            List<ContainerButtonType> buttons  = testExclusionInfo.getButtons();

            if (buttons != null)
            {
                for (int i = 0; i < buttons.size(); i++)
                {
                    buttonsStringBuilder.append(buttons.get(i));
                }
            }

            if (isDebug)
            {
                System.out.printf("generateHTML() - moduleName: %s",     moduleName);
                System.out.printf("generateHTML() - pageName: %s",       pageName);
                System.out.printf("generateHTML() - containerId: %s",    containerId);
            }

            s.append("<tr style = 'border:1px solid black;'>");

            {
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", j));
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", moduleName));
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", pageName));
                s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", containerId));

                if (buttons != null)
                {
                    s.append(String.format("<td style = 'border:1px solid black;'>%s</td>", buttonsStringBuilder));
                }
                else
                {
                    s.append(String.format("<td style = 'border:1px solid black;'>Весь контейнер исключен</td>"));
                }

                s.append(String.format("<td style = 'border:1px solid black;'>Нет</td>"));
                s.append(String.format("<td style = 'border:1px solid black;'></td>"));
            }

            s.append("</tr>");
        }
    }
}

