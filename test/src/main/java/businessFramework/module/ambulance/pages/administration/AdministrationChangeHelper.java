package businessFramework.module.ambulance.pages.administration;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов на странице "Администрирование - Смены"
 */
public class AdministrationChangeHelper extends Page implements Values
{
    public AdministrationChangeHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера "Смены"
     * @return контейнер "Смены"
     */
    public Container getChangesContainer()
    {
        return getContainer("change");
    }

    /**
     * Получение таблицы в контейнере "Смены"
     * @return таблицу в контейнере "Смены"
     */
    public Table getChangesTable()
    {
        return getChangesContainer().getTable();
    }

    /**
     * Получение кнопки "Принудительное начало"
     * @return кнопка "принудительное начало"
     */
    public Button getForcedOpenButton()
    {
        return getChangesContainer().getButton("forced_open");
    }


}
