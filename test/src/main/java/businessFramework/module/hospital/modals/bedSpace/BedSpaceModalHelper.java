package businessFramework.module.hospital.modals.bedSpace;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class BedSpaceModalHelper implements Values {
    private Page page = Page.getInstance();
    private String container;

    protected BedSpaceModalHelper() {
        this.container = "bedSpace";
    }

    protected Modal getModal() {
        return page.getModal();
    }

    protected Container getGridContainer() {
        return getModal().getContainer(container);
    }

    protected Table getGridTable() {
        return getGridContainer().getTable();
    }

    // Список: фильтр

    protected Filter getGridTableFilter() {
        return getGridContainer().getFilter();
    }

    protected InputDate getFilterDtField() {
        return getGridTableFilter().getInputDate("periodDates");
    }

    protected Classifier getFilterRegimenField() {
        return getGridTableFilter().getClassifier("regimen");
    }

    protected Classifier getFilterDepartmentField() {
        return getGridTableFilter().getClassifier("department");
    }

    protected Classifier getFilterProfileField() {
        return getGridTableFilter().getClassifier("profile");
    }

    protected Classifier getFilterBedProfileField() {
        return getGridTableFilter().getClassifier("bedProfile");
    }

    //  кнопки

    public Button getConfirmButton() {
        return getModal().getButton(CONFIRM_BUTTON);
    }

    public Button getCancelButton() {
        return getModal().getButton(CANCEL);
    }

}