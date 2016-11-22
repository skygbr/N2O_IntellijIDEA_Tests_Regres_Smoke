package businessFramework.module.dispensary.modal.editAppointments;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputCheckBox;


public class EditAppointmentsHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public EditAppointmentsHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return модальное окно "Изменить назначение"
     */
    public Modal getEditAppointmentsModal()
    {
        return page.getModal();
    }

    public InputCheckBox getExaminations()
    {
        return getEditAppointmentsModal().getForm().getInputCheckBox("check_pres_group");
    }

    /**
     * Получение кнопки "Изменить"
     *
     * @return кнопку "Изменить"
     */
    public Button getUpdateButton()
    {
        return getEditAppointmentsModal().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Сохранить"
     *
     * @return кнопку "Сохранить"
     */
    public Button getSaveButton()
    {
        return getEditAppointmentsModal().getButton(N2O_CONFIRM_BUTTON);
    }
}