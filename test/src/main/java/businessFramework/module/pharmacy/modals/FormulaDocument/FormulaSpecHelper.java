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
public class FormulaSpecHelper extends Page implements Values {

    public FormulaSpecHelper(ApplicationManager app) {
        super(app);
    }

    private Page page = Page.getInstance();

    public Modal getFormulaSpecModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Поля формы
     */
    public Classifier getModif() {
        return getModal().getForm().getClassifier("modif");
    }

    public InputText getMneiQuantity() {
        return getModal().getForm().getInputText("mneiQuantity");
    }
}