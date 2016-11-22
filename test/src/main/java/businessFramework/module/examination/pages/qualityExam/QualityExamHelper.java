package businessFramework.module.examination.pages.qualityExam;


import businessFramework.module.examination.pages.qualityExam.containerHeplers.CardsForCaseHelper;
import businessFramework.module.examination.pages.qualityExam.containerHeplers.CardsHelper;
import businessFramework.module.examination.pages.qualityExam.containerHeplers.CasesHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

public class QualityExamHelper extends Page {

    private CardsHelper cardsHelper                 = new CardsHelper(app);
    private CasesHelper casesHelper                 = new CasesHelper(app);
    private CardsForCaseHelper cardsForCaseHelper   = new CardsForCaseHelper(app);

    protected QualityExamHelper(ApplicationManager app) {
        super(app);
    }

    // Журнал проведенных экспертиз

    public CardsHelper getCardsHelper() {
        return cardsHelper;
    }


    // Журнал проведенных экспертиз

    /**
     * список случаев
     * @return список случаев
     */
    public CasesHelper getCasesHelper() {
        return casesHelper;
    }

    /**
     * список карт
     * @return список карт
     */
    public CardsForCaseHelper getCardsForCaseHelper() {
        return cardsForCaseHelper;
    }
}