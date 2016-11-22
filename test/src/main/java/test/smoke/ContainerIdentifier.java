package test.smoke;

/**
 * Содержит описание контейнера. Тут: pageHref-название модуля.название страницы, containerId - id контейнера.
 */
public class ContainerIdentifier
{
    public String pageHref;
    public String containerId;

    // Переопределим методы equals и hashCode.
    @Override
    public boolean equals(Object obj)
    {
        // Если объект null или не типа ContainerIdentifier то false.
        if (obj == null || !(obj instanceof ContainerIdentifier))
        {
            return false;
        }

        // В другом случае - привести его к типу ContainerIdentifier.
        ContainerIdentifier otherObj = (ContainerIdentifier)obj;

        // Объекты эквивалентны, если у них pageHref и containerId равны.
        return pageHref.equals(otherObj.pageHref) && containerId.equals(otherObj.containerId);
    }

    @Override
    public int hashCode()
    {
        return (pageHref + "." + containerId).hashCode();
    }

}
