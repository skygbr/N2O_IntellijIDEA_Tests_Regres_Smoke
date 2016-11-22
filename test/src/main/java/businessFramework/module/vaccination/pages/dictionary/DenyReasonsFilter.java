package businessFramework.module.vaccination.pages.dictionary;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author tpushkareva
 * @since 24.09.2015
 * Фильтры на странице "Причины медицинского отвода"
 */
public class DenyReasonsFilter extends DenyReasonsHelper{

    public DenyReasonsFilter(ApplicationManager app) {
        super(app);
    }

    // Фильтр по полю "Код"
    public InputText getCode() {
        return this.getDenyReasonContainer().getFilter().getInputText("code");
    }

    // Фильтр по полю "Причина"
    public InputText getLabel() {
        return this.getDenyReasonContainer().getFilter().getInputText("label");
    }
}
