package businessFramework.module.vaccination;

import businessFramework.module.vaccination.modals.individPlan.VaccineModal;
import businessFramework.module.vaccination.pages.individPlan.IndividPlanPage;
import businessFramework.module.vaccination.pages.vaccineJournal.VacineJournalPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

public class IndividPlanManager
{
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * Открытие модуля "Вакцинопрофилактики"
     */
    public void openVaccinationModule() {
        app.getNavigationHelper().openPageWithModule("modules.vaccine");
    }

    /**
     * Открытие страницы "Индивидуального планирования"
     */
    public void openIndividPlan() {
        this.openVaccinationModule();
        page.getHeader().openPage("vaccine.indiv_plan_grid");
    }

    /**
     * Получение страницы "Индивидуального планирования"
     */
    public IndividPlanPage getIndividPlanPage() {
        return new IndividPlanPage(app);
    }

    /**
     * Открытие страницы "Журнал прививок"
     */
    public void openVacineJournal() {
        this.openVaccinationModule();
        page.getHeader().openPage("vaccine.vac_inoculation");
    }

    /**
     * Получение страницы "Журнал прививок"
     *
     * @return страницу "Журнал прививок"
     */
    public VacineJournalPage getVacineJournalPage() {
        return new VacineJournalPage(app);
    }






}
