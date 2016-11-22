package businessFramework.module.pharmacy.modals.refbook.writeOffReason;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author ydolgih
 * @since 25.09.2015
 */
public class WriteOffReasonModal extends Page implements Values {

    public WriteOffReasonModal(ApplicationManager app) {
        super(app);
    }

    private Page page = Page.getInstance();

    public void fillFields(String orgName, String shortName, String fullName) {
        if (orgName != null) getOrgName().setValue(orgName);
        if (shortName != null) getShortName().setValue(shortName);
        if (fullName != null) getFullName().setValue(fullName);
    }

    public Classifier getOrgName() {
        return getModal().getForm().getClassifier("org");
    }

    public InputText getShortName() {
        return getModal().getForm().getInputText("shortName");
    }

    public InputText getFullName() {
        return getModal().getForm().getInputText("fullName");
    }

    public Modal getWriteOffReasonModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveWriteOffReasonButton()
    {
        getWriteOffReasonModal().getButton(N2O_CONFIRM_BUTTON).click();
    }
}