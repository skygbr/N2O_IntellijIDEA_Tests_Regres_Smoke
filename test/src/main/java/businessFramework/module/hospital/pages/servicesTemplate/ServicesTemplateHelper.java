package businessFramework.module.hospital.pages.servicesTemplate;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 29.06.2015
 */
public class ServicesTemplateHelper extends Page implements Values {
    public ServicesTemplateHelper(ApplicationManager app) {
        super(app);
    }

    //Шаблон
    public Container getServicesTemplateContainer() {
        return getRegion(TOP).getContainer("servicesTemplate");
    }

    public Button getServicesTemplateCreateButton() {
        return getServicesTemplateContainer().getButton(CREATE_BUTTON);
    }

    public Button getServicesTemplateUpdateButton() {
        return getServicesTemplateContainer().getButton(UPDATE_BUTTON);
    }

    public Button getServicesTemplateDeleteButton() {
        return getServicesTemplateContainer().getButton(DELETE_BUTTON);
    }

    public Table getServicesTemplateTable() {
        return getServicesTemplateContainer().getTable();
    }


    //Услуги шаблона
    public Container getServicesTemplateServiceContainer() {
        return getRegion(BOTTOM).getContainer("servicesTemplateService");
    }

    public Button getServicesTemplateServiceCreateButton() {
        return getServicesTemplateServiceContainer().getButton(CREATE_BUTTON);
    }

    public Button getServicesTemplateServiceShortFormCreateButton() {
        return getServicesTemplateServiceContainer().getButton("createShortForm");
    }

    public Button getServicesTemplateServiceUpdateButton() {
        return getServicesTemplateServiceContainer().getButton(UPDATE_BUTTON);
    }

    public Button getServicesTemplateServiceDeleteButton() {
        return getServicesTemplateServiceContainer().getButton(DELETE_BUTTON);
    }

    public Table getServicesTemplateServiceTable() {
        return getServicesTemplateServiceContainer().getTable();
    }

//    Диагнозы

    public Container getServicesTemplateDiagnosisContainer() {
        return getRegion(BOTTOM).getContainer("diagnosisList");
    }

    public Button getServicesTemplateDiagnosisCreateButton() {
        return getServicesTemplateDiagnosisContainer().getButton("create");
    }
    public Button getServicesTemplateDiagnosisDeleteButton() {
        return getServicesTemplateDiagnosisContainer().getButton("delete");
    }

//    Препараты

    public Container getServicesTemplateHoldingContainer() {
        return getRegion(BOTTOM).getContainer("holdingList");
    }

    public Table getServicesTemplateHoldingTable() {
        return getServicesTemplateHoldingContainer().getTable();
    }

    public Button getServicesTemplateHoldingCreateButton() {
        return getServicesTemplateHoldingContainer().getButton(CREATE_BUTTON);
    }

    public Button getServicesTemplateHoldingUpdateButton() {
        return getServicesTemplateHoldingContainer().getButton(UPDATE_BUTTON);
    }

    public Button getServicesTemplateHoldingDeleteButton() {
        return getServicesTemplateHoldingContainer().getButton(DELETE_BUTTON);
    }

    public Button getServicesTemplateHoldingCopyButton() {
        return getServicesTemplateHoldingContainer().getButton(COPY_BUTTON);
    }
}
