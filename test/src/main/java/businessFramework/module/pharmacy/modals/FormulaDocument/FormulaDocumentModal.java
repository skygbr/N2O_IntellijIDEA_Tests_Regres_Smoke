package businessFramework.module.pharmacy.modals.FormulaDocument;

import businessFramework.entities.pharmacy.FormulaDocumentData;
import net.framework.autotesting.ApplicationManager;

/**
 * @author ydolgih
 * @since 31.10.2015
 */
public class FormulaDocumentModal extends FormulaDocumentModalHelper {

    public FormulaDocumentModal(ApplicationManager app) {
        super(app);
    }

    /*Нажатие кнопок*/
    public void clickSaveButton() {
        getFormulaDocumentModal().getButton(N2O_CONFIRM_BUTTON).click();
    }

    /**Заполнение полей формы*/
    public void fillFields(FormulaDocumentData docData) {
        getName().setValue(docData.getName());
        getModif().setValue(docData.getModifName());
        getMneiQuantity().setValue(docData.getMneiQuantity());
        getNote().setValue(docData.getNote());
    }

    public void checkFields(FormulaDocumentData docData) {
        getName().assertValue(docData.getName());
        getModif().assertValue_equals(docData.getModifName());
        getMneiQuantity().assertValue(docData.getMneiQuantity());
        getNote().assertValue(docData.getNote());
    }
}