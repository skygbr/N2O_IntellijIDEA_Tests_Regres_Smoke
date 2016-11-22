package businessFramework.module.pharmacy.pages.productionDoc;

import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.ProductionDocument.ProdDocModal;
import businessFramework.module.pharmacy.modals.ProductionDocument.ProdSpecModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * @author ydolgih
 * @since 13.11.2015
 */
public class ProductionDocListHelper extends Page implements Values {

    /** Страница "Документы на изготовление" */
    public ProductionDocListHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * @return контейнер "Документы"
     */
    public Container getProdDocListContainer()
    {
        return getContainer("prodDocList");
    }

    /**
     * @return контейнер "Спецификации"
     */
    public Container getProdSpecListContainer()
    {
        return getContainer("prodSpecList");
    }

    /**
     * @return таблицу в контейнере "Докмуенты"
     */
    public Table getProdDocListTable()
    {
        return getProdDocListContainer().getTable();
    }

    /**
     * @return таблицу в контейнере "Спецификации"
     */
    public Table getProdSpecListTable()
    {
        return getProdSpecListContainer().getTable();
    }


    /** ---------------------------- Кнопки в контейнере "Заявки" ---------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getAddDocButton()
    {
        return getProdDocListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getUpdateDocButton() {
        return getProdDocListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Провести"
     */
    public Button getExecuteDocButton() {
        return getProdDocListContainer().getButton(EXECUTE);
    }

    /**
     * @return кнопку "Отменить проводку"
     */
    public Button getCancelDocButton() {
        return getProdDocListContainer().getButton(CANCEL);
    }


    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteDocButton() {
        return getProdDocListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * Получаем модальное окно "Создание документа"
     */
    public ProdDocModal getProdDocModal() {
        return new ProdDocModal(app);
    }

    /**
     * Получаем модальное окно добавления спецификации
     */
    public ProdSpecModal getProdSpecModal()
    {
        return new ProdSpecModal(app);
    }

    /** ---------------------------- Кнопки в контейнере "Спецификации" ---------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getAddSpecButton()
    {
        return getProdSpecListContainer().getButton(CREATE_BUTTON);
    }
    /**
     * @return кнопку "Удалить
     */
    public Button getDeleteSpecButton() {
        return getProdSpecListContainer().getButton(DELETE_BUTTON);
    }
}
