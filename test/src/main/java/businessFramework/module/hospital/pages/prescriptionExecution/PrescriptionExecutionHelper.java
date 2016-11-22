package businessFramework.module.hospital.pages.prescriptionExecution;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

public class PrescriptionExecutionHelper extends Page implements Values {
    public PrescriptionExecutionHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerPrescriptionScheduleList() {
        return getRegion("holding-execution-top").getContainer("prescriptionScheduleList");
    }

    public Table getTablePrescriptionScheduleList() {
        return getContainerPrescriptionScheduleList().getTable();
    }

    public void clickQuickExecuteButton() {
        getContainerPrescriptionScheduleList().clickDropdown("Выполнить", "Выполнить", "quickExecute");
    }

    public void clickExecuteWithPatientMedicamentButton() {
        getContainerPrescriptionScheduleList().clickDropdown("Выполнить", "Выполнить препарат пациента", "quickExecuteWithPatientMedicament");
    }

    public Button getExecuteAndWriteOffButton() {
        return getContainerPrescriptionScheduleList().getButton("executeAndWriteOff1");
    }

    public Button getExecuteAndWriteOffComplexButton() {
        return getContainerPrescriptionScheduleList().getButton("executeAndWriteOff2");
    }

    public Button getCancelExecuteButton() {
        return getContainerPrescriptionScheduleList().getButton("cancelExecute");
    }

    public Button getCancelPrescriptionButton() {
        return getContainerPrescriptionScheduleList().getButton("cancel");
    }

    public Button getChangeExecuteDateButton() {
        return getContainerPrescriptionScheduleList().getButton("changeExecuteDate");
    }

    public Container getContainerHoldingList() {
        return getRegion("holding-execution-bottom").getContainer("holdingsList");
    }

    public Table getTableHoldingList() {
        return getContainerHoldingList().getTable();
    }
}