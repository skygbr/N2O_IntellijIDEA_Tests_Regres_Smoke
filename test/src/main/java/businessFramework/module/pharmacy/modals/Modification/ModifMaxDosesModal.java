package businessFramework.module.pharmacy.modals.Modification;

import businessFramework.entities.pharmacy.ModifData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author ydolgih
 * @since 02.11.2015
 */
public class ModifMaxDosesModal implements Values {

    private String container;
    private Page page = Page.getInstance();

    public ModifMaxDosesModal() {
        this.container = "main";
    }

    public Modal getModal() {
        return page.getModal();
    }

    private InputText getDailyDoseVal() {
        return getModal().getForm().getInputText("maxDailyDoseVal");
    }

    private InputText getSingleDoseVal() {
        return getModal().getForm().getInputText("maxSingleDoseVal");
    }

    private Classifier getDailyDoseUnit() {
        return getModal().getForm().getClassifier("maxDailyDoseUnit");
    }

    private Classifier getSingleDoseUnit() {
        return getModal().getForm().getClassifier("maxSingleDoseUnit");
    }

    private Button getSaveButton() {
        return getModal().getButton(N2O_CONFIRM_BUTTON);
    }


    public void clickSaveMaxDoses() {
        Button button = getSaveButton();
        button.assertIsEnabled();
        button.click();
    }

    public void fillModifMaxDoses(ModifData modifData) {
        if (modifData.getMaxSingleDoseVal() != null) getSingleDoseVal().setValue(modifData.getMaxSingleDoseVal());
        if (modifData.getMaxDailyDoseVal() != null) getDailyDoseVal().setValue(modifData.getMaxDailyDoseVal());

        getDailyDoseUnit().assertThatComboboxIsDisabled();
        getDailyDoseUnit().assertValue_equals(modifData.getDosageUnit());

        getSingleDoseUnit().assertThatComboboxIsDisabled();
        getSingleDoseUnit().assertValue_equals(modifData.getDosageUnit());
    }
}
