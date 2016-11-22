package businessFramework.module.hospital.modals.inventoriesComplex;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Form;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;

public class InventoriesComplexHelper extends Page implements Values {
    private Page page = Page.getInstance();

    public InventoriesComplexHelper(ApplicationManager app) {
        super(app);
    }

    public Container getMainContainer() {
        return page.getModal().getContainer("main");
    }

    public Form getMainForm() {
        return getMainContainer().getForm();
    }

    public OutputText getHoldingField(int index) {
        return getMainForm().getOutputText("holdings." + index + ".holding_full_name");
    }

    public Classifier getCommodityStockField(int index) {
        return getMainForm().getClassifier("holdings." + index + ".commodityStock");
    }

    public InputCheckBox getIsPatientMedicament(int index) {
        return getMainForm().getInputCheckBox("holdings." + index + ".is_patient");
    }

    public InputCheckBox getIsPatientMedicamentForSchedule(int index) {
        return getMainForm().getInputCheckBox("holdings." + index + ".is_patient_for_schedule");
    }

    public int getCountOfVisibleHoldingRows() {
        return getMainContainer().findElements(By.cssSelector(".holdingRow:not(.n2o-hidden)")).size();
    }

    public Button getButtonConfirm() {
        return page.getModal().getButton(N2O_CONFIRM_BUTTON);
    }

}
