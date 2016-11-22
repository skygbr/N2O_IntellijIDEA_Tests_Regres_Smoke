package businessFramework.module.hospital.pages.operation.journal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * @author agabdrakhmanova
 * @since 16.11.2015
 */
public class OperationJournalHelper extends Page implements Values {

    public OperationJournalHelper(ApplicationManager app) {
        super(app);
    }

    public Container getOperationJournalContainer() {
        return getRegion(TOP).getContainer("operationJournal");
    }

    public Container getSurgicalTeamContainer() {
        return getRegion(LEFT).getContainer("surgicalTeam");
    }

    public Container getPrescriptionListContainer() {
        return getRegion(RIGHT).getContainer("prescriptionList");
    }


    public Button getRenderButton() {
        return getOperationJournalContainer().getButton("render");
    }

    public Button getCancelRenderButton() {
        return getOperationJournalContainer().getButton("cancelRender");
    }

    public Button getCreateRenderOperationButton() {
        return getOperationJournalContainer().getButton("createRenderOperation");
    }

    public Button getAddEmployeeToSurgicalTeamButton() {
        return getSurgicalTeamContainer().getButton("create");
    }

    public Button getUpdateEmployeeInSurgicalTeamButton() {
        return getSurgicalTeamContainer().getButton("update");
    }

    public Button getDeleteEmployeeFromSurgicalTeamButton() {
        return getSurgicalTeamContainer().getButton("delete");
    }

    public Button getAddPrescriptionButton() {
        return getPrescriptionListContainer().getButton("create");
    }

    public Button getDeletePrescriptionButton() {
        return getPrescriptionListContainer().getButton("delete");
    }

}
