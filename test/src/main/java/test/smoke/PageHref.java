package test.smoke;

public class PageHref
{
    private String moduleId;
    private String pageId;

    public PageHref(String moduleId, String pageId)
    {
        this.moduleId = moduleId;
        this.pageId = pageId;
    }

    public PageHref(String pageHref)
    {
        // #module.page
        // => moduleId = "module", pageId = "page"
        if (!pageHref.startsWith("#"))
        {
            throw new RuntimeException(String.format("Page href '%s' is invalid", pageHref));
        }
        int dotIndex = pageHref.indexOf('.');
        if (dotIndex == -1)
        {
            throw new RuntimeException(String.format("Page href '%s' is invalid", pageHref));
        }
        else
        {
            this.moduleId = pageHref.substring(1, dotIndex);
            this.pageId = pageHref.substring(dotIndex + 1);
        }
    }

    public String getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(String moduleId)
    {
        this.moduleId = moduleId;
    }

    public String getPageId()
    {
        return pageId;
    }

    public void setPageId(String pageId)
    {
        this.pageId = pageId;
    }

}
