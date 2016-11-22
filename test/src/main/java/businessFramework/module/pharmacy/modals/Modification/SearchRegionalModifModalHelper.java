package businessFramework.module.pharmacy.modals.Modification;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import net.framework.autotesting.meta.Filter;

/**
 * Created by ydolgih on 15.12.2015.
 */
public class SearchRegionalModifModalHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public SearchRegionalModifModalHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return модальное окно "Поиск модификации в региональном справочнике"
     */
    public Modal getSearchModifModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    public Container getSearchModifContainer()
    {
        return getSearchModifModal().getContainer("regionalModifList");
    }
    /**
     * Получение таблицы в контейнере pats
     * @return таблицу в контейнере pats
     */
    public Table getModifSearchTable()
    {
        return  getSearchModifContainer().getTable();
    }

    public Filter getFilter()
    {
      return getSearchModifContainer().getFilter();
    }


    /**
     * Получение кнопки "Выбрать"
     * @return кнопку "Выбрать"
     */
    public Button getChooseButton()
    {
        return  getSearchModifModal().getButton(CONFIRM_BUTTON);
    }
}
