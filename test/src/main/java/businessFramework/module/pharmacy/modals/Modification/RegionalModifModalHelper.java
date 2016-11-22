package businessFramework.module.pharmacy.modals.Modification;

import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by ydolgih on 08.12.2015.
 */
public class RegionalModifModalHelper extends ModifModalHelper {

    private String container;
    private Page page = Page.getInstance();

    public RegionalModifModalHelper(String container) {
        this.container = container;
    }

    /**
     * @return поле Максимальная суточная доза
     */
    public InputText getMaxDailyDoseVal() {
        return getModal().getForm().getInputText("maxDailyDoseVal");
    }

    /**
     * @return поле Максимальная курсовая доза
     */
    public InputText getMaxSingleDoseVal() {
        return getModal().getForm().getInputText("maxSingleDoseVal");
    }

    /**
     * @return поле Код ОКДП
     */
    public InputText getCodeOkdpVal() {
        return getModal().getForm().getInputText("codeOkdp");
    }

}
