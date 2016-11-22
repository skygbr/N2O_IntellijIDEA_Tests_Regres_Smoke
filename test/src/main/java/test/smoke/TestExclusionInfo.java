package test.smoke;

import java.util.List;

public class TestExclusionInfo
{
    String moduleId;
    String pageId;
    String containerId;
    List<ContainerButtonType> buttons;

    // pageHref всегда не null.
    // Если исключение - страница - то containerId = null, buttons = null.
    // Если исключение - контейнер, то containerId != null. Если buttons = null, то исключается весь контейнер, иначчеисключаются только кнопки,
    // которые перечислены в buttons.

    // Конструкторы.

    public TestExclusionInfo(String pageHref)
    {
        if (pageHref == null)
        {
            throw new IllegalArgumentException("pageHref must be not null");
        }
        setPageHref(pageHref);
    }

    private void setPageHref(String pageHref)
    {
        if (!pageHref.startsWith("#"))
        {
            throw new RuntimeException(String.format("Invalid page href: '%s'", pageHref));
        }

        int dotIndex = pageHref.indexOf('.');

        if (dotIndex == -1)
        {
            this.moduleId = pageHref.substring(1);
            this.pageId = null;
        }
        else
        {
            this.moduleId = pageHref.substring(1, dotIndex);
            this.pageId = pageHref.substring(dotIndex + 1);
        }
    }

    public TestExclusionInfo(String pageHref, String containerId)
    {
        if (pageHref == null)
        {
            throw new IllegalArgumentException("pageHref must be not null");
        }
        if (containerId == null)
        {
            throw new IllegalArgumentException("containerId must be not null");
        }
        setPageHref(pageHref);
        this.containerId    = containerId;
    }

    public TestExclusionInfo(String pageHref, String containerId, List<ContainerButtonType> buttons)
    {
        if (pageHref == null)
        {
            throw new IllegalArgumentException("pageHref must be not null");
        }
        if (containerId == null)
        {
            throw new IllegalArgumentException("containerId must be not null");
        }
        if (buttons == null)
        {
            throw new IllegalArgumentException("buttons must be not null");
        }
        setPageHref(pageHref);
        this.containerId    = containerId;
        this.buttons        = buttons;
    }

    public String getModuleId()
    {
        return moduleId;
    }

    public String getPageId()
    {
        return pageId;
    }

    public String getContainerId()
    {
        return containerId;
    }

    public ContainerIdentifier getContainerIdentifier()
    {
        if (containerId == null)
        {
            throw new RuntimeException("containerId == null");
        }

        ContainerIdentifier result  = new ContainerIdentifier();
        result.pageHref             = getPageHref(); // TODO
        result.containerId          = containerId;

        return result;
    }

    public String getPageHref()
    {
        return String.format("#%s.%s", this.moduleId, this.pageId == null ? "*" : this.pageId);
    }

    public List<ContainerButtonType> getButtons()
    {
        return buttons;
    }

    public boolean isModuleExclusion()
    {
        return pageId == null;
    }

    public boolean isPageExclusion()
    {
        return pageId != null && containerId == null;
    }

    public boolean isContainerExclusion()
    {
        return pageId != null && containerId != null && buttons == null;
    }

    public boolean isButtonsExclusion()
    {
        return pageId != null && containerId != null && buttons != null;
    }

}
