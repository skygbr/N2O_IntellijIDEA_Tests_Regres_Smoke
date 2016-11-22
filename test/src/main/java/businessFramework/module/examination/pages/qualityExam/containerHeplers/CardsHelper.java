package businessFramework.module.examination.pages.qualityExam.containerHeplers;


import businessFramework.module.values.CommonValues.ButtonsValues;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class CardsHelper extends Page {



    public CardsHelper(ApplicationManager app) {
        super(app);
    }

    protected Container getContainer() {
        return getRegion("tab1").getContainer("examinationCardList");
    }

    protected Table getGrid() {
        return getContainer().getTable();
    }

    /* -------------------- Получение фильтра и полей в фильтре -------------------- */

    protected Filter getGridFilter() {
        return getContainer().getFilter();
    }

    protected InputDate getFilterDtField() {
        return getGridFilter().getInputDate("createDate");
    }

    protected Classifier getFilterExpertField() {
        return getGridFilter().getClassifier("expert");
    }

    protected Classifier getFilterDepartmentField() {
        return getGridFilter().getClassifier("department");
    }

    protected Classifier getFilterDoctorField() {
        return getGridFilter().getClassifier("doctor");
    }

    protected Classifier getFilterLevelField() {
        return getGridFilter().getClassifier("controlLevel");
    }


    /* -------------------- Получение кнопок -------------------- */

    /**
     * @return кнопку "Изменить"
     */
    protected Button getUpdateBtn() {
        return getContainer().getButton(ButtonsValues.UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Удалить"
     */
    protected Button getDeleteBtn() {
        return getContainer().getButton(ButtonsValues.DELETE_BUTTON);
    }
}