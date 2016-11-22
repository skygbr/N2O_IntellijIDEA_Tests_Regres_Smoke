package businessFramework.module.hospital.pages.PrescriptionPeriodicity;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class PrescriptionPeriodicityHelper extends Page implements Values {
    protected PrescriptionPeriodicityHelper(ApplicationManager app) {
        super(app);
    }

    protected Container getContainerPeriodicity() {
        return getRegion(TOP).getContainer("prescriptionPeriodicity");
    }

    protected Container getContainerTime() {
        return getRegion(BOTTOM).getContainer("prescriptionPeriodicityTime");
    }

    protected Table getTablePeriodicity() {
        return getContainerPeriodicity().getTable();
    }

    protected Table getTableTime() {
        return getContainerTime().getTable();
    }

    protected InputText getNameField() {
        return getModal().getForm().getInputText("name");
    }

    protected InputText getCountField() {
        return getModal().getForm().getInputText("count");
    }

    protected InputText getIntervalField() {
        return getModal().getForm().getInputText("interval");
    }

    protected InputText getTimeField() {
        return getModal().getForm().getInputText("receiptTime");
    }
}