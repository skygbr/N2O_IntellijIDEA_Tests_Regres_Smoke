package test.smoke;

import java.util.List;

public class TestInclusionInfo
{
    String pagehref;
    String containerId;
    List<ContainerButtonType> buttons;

    // pageHref всегда не null.
    // Если исключение - страница - то containerId = null, buttons = null.
    // Если исключение - контейнер, то containerId != null. Если buttons = null, то исключается весь контейнер, иначчеисключаются только кнопки,
    // которые перечислены в buttons.

    // Конструкторы.

    public TestInclusionInfo(String pageHref)
    {
        if (pageHref == null)
        {
            throw new IllegalArgumentException("pageHref must be not null");
        }
        this.pagehref = pageHref;
    }

    public TestInclusionInfo(String pageHref, String containerId)
    {
        if (pageHref == null)
        {
            throw new IllegalArgumentException("pageHref must be not null");
        }
        if (containerId == null)
        {
            throw new IllegalArgumentException("containerId must be not null");
        }
        this.pagehref       = pageHref;
        this.containerId    = containerId;
    }

    public TestInclusionInfo(String pagehref, String containerId, List<ContainerButtonType> buttons)
    {
        if (pagehref == null)
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
        this.pagehref       = pagehref;
        this.containerId    = containerId;
        this.buttons        = buttons;
    }

    public String getPagehref()
    {
        return pagehref;
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
        result.pageHref             = pagehref;
        result.containerId          = containerId;

        return result;
    }

    public List<ContainerButtonType> getButtons()
    {
        return buttons;
    }

    public boolean isPageInclusion()
    {
        return containerId == null;
    }

    public boolean isContainerInclusion()
    {
        return containerId != null && buttons == null;
    }

    public boolean isButtonsInclusion()
    {
        return containerId != null && buttons != null;
    }

}
