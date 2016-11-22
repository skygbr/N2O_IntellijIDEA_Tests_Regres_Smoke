package businessFramework.module.pharmacy.pages.returnDoc;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ReturnDocsHelper extends Page implements Values{

    private Page page = Page.getInstance();

    public ReturnDocsHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получает контейнер "Возвратные документы"
     * @return контейнер "Возвратные документы"
     */
    public Container getReturnDocsListContainer(){
        return getContainer("returnDocList");
    }

    /*------------------- Таблица "Возвратные документы" и кнопки на странице "Возвратные документы" -------------*/

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateReturnDocButton()
    {
        return getReturnDocsListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditReturnDocButton()
    {
        return getReturnDocsListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteReturnDocButton()
    {
        return getReturnDocsListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return таблицу в контейнере "Возвратные документы"
     */
    public Table getReturnDocListTable(){
        return getReturnDocsListContainer().getTable();
    }

    /**
     * @return окно с надписью "Предупреждение" после нажатия на кнопку "удалить" на странице "Возвратные документы"
     */
    public Dialog getConfirmModal(){
        return page.getDialog();
    }
}
