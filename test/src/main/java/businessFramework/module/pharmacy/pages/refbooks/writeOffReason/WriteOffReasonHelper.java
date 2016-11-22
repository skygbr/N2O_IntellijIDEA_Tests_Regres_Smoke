package businessFramework.module.pharmacy.pages.refbooks.writeOffReason;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * @author ydolgih
 * @since 23.09.2015
 */
public class WriteOffReasonHelper extends Page implements Values {

    public WriteOffReasonHelper(ApplicationManager app) {
        super(app);
    }

    public Container getWriteOffReasonListContainer()
    {
        return getContainer("main");
    }

    /**
     * @return кнопку "Добавить" на странице "Причины списания"
     */
    public Button getCreateWriteOffReasonButton()
    {
        return getWriteOffReasonListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить" на странице "Причины списания"
     */
    public Button getEditWriteOffReasonButton()
    {
        return getWriteOffReasonListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Удалить" на странице "Причины списания"
     */
    public Button getDeleteWriteOffReasonButton()
    {
        return getWriteOffReasonListContainer().getButton(DELETE_BUTTON);
    }
}