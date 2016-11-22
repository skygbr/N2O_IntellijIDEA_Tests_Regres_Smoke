package businessFramework.module.examination.pages.qualityExam.containerHeplers;


import businessFramework.module.values.CommonValues.ButtonsValues;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

public class CardsForCaseHelper extends Page {



    public CardsForCaseHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainer() {
        return getRegion("tab2").getContainer("examinationCardListForCase");
    }

    public Table getGrid() {
        return getContainer().getTable();
    }

    /* -------------------- Получение кнопок -------------------- */

    /**
     * @return кнопку "Изменить"
     */
    public Button getUpdateBtn() {
       return getContainer().getButton(ButtonsValues.UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteBtn() {
        return getContainer().getButton(ButtonsValues.DELETE_BUTTON);
    }
}