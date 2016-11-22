package businessFramework.module.pharmacy.modals.FormulaDocument;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author ydolgih
 * @since 31.10.2015
 */
public class FormulaDocumentModalHelper extends Page  implements Values {

    public FormulaDocumentModalHelper(ApplicationManager app) {
        super(app);
    }

    private Page page = Page.getInstance();

    public Modal getFormulaDocumentModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Поля формы
     */
    public Classifier getModif() {
        return getModal().getForm().getClassifier("modif");
    }

    public InputText getName() {
        return getModal().getForm().getInputText("name");
    }

    public InputText getMneiQuantity() {
        return getModal().getForm().getInputText("mneiQuantity");
    }

    public InputText getNote() {
        return getModal().getForm().getInputText("note");
    }

}