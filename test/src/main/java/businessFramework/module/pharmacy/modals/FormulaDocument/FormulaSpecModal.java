package businessFramework.module.pharmacy.modals.FormulaDocument;


import businessFramework.entities.pharmacy.FormulaDocumentData;
import net.framework.autotesting.ApplicationManager;

/**
 * @author ydolgih
 * @since 31.10.2015
 */
public class FormulaSpecModal extends FormulaSpecHelper{

    public FormulaSpecModal(ApplicationManager app) {
        super(app);
    }

    /*Нажатие кнопок*/
    public void clickSaveButton() {
        getFormulaSpecModal().getButton(N2O_CONFIRM_BUTTON).click();
    }

    /**Заполнение полей формы*/
    public void fillFields(FormulaDocumentData docData) {
        getModif().setValue(docData.getSpecModifName());
        getMneiQuantity().setValue(docData.getSpecMneiQuantity());
    }

    public void checkFields(FormulaDocumentData docData) {
        getModif().assertValue_equals(docData.getSpecModifName());
        getMneiQuantity().assertValue(docData.getSpecMneiQuantity());
    }
}