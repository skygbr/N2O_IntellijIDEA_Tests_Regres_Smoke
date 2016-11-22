package businessFramework.module.ambulance;

import businessFramework.module.ambulance.pages.Brigads.BrigadeViewTemplatePage;
import businessFramework.module.ambulance.pages.Brigads.BrigadsPage;
import businessFramework.module.ambulance.pages.Brigads.TransportPage;
import businessFramework.module.ambulance.pages.administration.AdministrationChangePage;
import businessFramework.module.ambulance.pages.journal.*;
import businessFramework.module.ambulance.pages.settings.*;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;


public class AmbulanceManager {

    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();


    /*-------------------- Открытие модуля----------------------*/

    /**
     * Открытие модуля "Скорая помощь"
     */
    public void openAmbulanceModule() {
        app.getNavigationHelper().openPageWithModule("modules.amb");
    }

    /*-------------------- Получение страниц ----------------------*/

    /**
     * Получение страницы "Журнал диспетчера"
     */
    public DispetcherJournalPage getDispetcherJournalPage() {
        return new DispetcherJournalPage(app);
    }

    /**
     * Получение страницы "Журнал диспетчера направления"
     */
    public DirectionDispetcherJournalPage getDirectionDispetcherJournalPage() {
        return new DirectionDispetcherJournalPage(app);
    }

    /**
     * Получение страницы "Наряд- Журнал нарядов"
     */
    public TeamJobsJournalPage getTeamJobsJournalPage() {
        return new TeamJobsJournalPage(app);
    }

    /**
     * Получение страницы "Наряд - журнал нарядов сотрудников"
     */
    public TeamEmployeesJournalPage getTeamEmployeesJournalPage() {
        return new TeamEmployeesJournalPage(app);
    }

    /**
     * Получение страницы "Наряд - Журнал нарядов транспорта"
     */
    public TeamTransportJournalPage getTeamTransportJournalPage() {
        return new TeamTransportJournalPage(app);
    }

    /**
     * Получение страницы "Журнал БУМ"
     */
    public PaperJournalPage getPaperJournalPage() {
        return new PaperJournalPage(app);
    }

    /**
     * Получение страницы "Журнал"
     */
    public JournalPage getJournalPage() {
        return new JournalPage(app);
    }

    /**
     * Получение страницы "Администрирование - Смены"
     */
    public AdministrationChangePage getAdministrationChangePage() {
        return new AdministrationChangePage(app);
    }

    /**
     * Получение страницы "Настройки - Настройка нумератора"
     */
    public SettingsNumeratorPage getSettingsNumeratorPage() {
        return new SettingsNumeratorPage(app);
    }

    /**
     * Получение страницы "Настройки - Настройка смены"
     */
    public SettingsChangePage getSettingsChangePage() {
        return new SettingsChangePage(app);
    }

    /**
     * Получение страницы "Настройки - Настройки периодов"
     */
    public SettingsPeriodsPage getSettingsPeriodsPage() {
        return new SettingsPeriodsPage(app);
    }

    /**
     * Получение страницы "Настройки - Настройка контрольного времени"
     */
    public SettingsControlTimePage getSettingsControlTimePage() {
        return new SettingsControlTimePage(app);
    }

    /**
     * Получение страницы "Настройки - Настройка направлений"
     */
    public SettingsDirectionsPage getSettingsDirectionsPage() {
        return new SettingsDirectionsPage(app);
    }

    /**
     * Получение страницы "Настройки - Настройки распределения вызовов по диспетчерам"
     */
    public SettingsCallsByDispetchersPage getSettingsCallsByDispetchersPage() {
        return new SettingsCallsByDispetchersPage(app);
    }

    /**
     * Получение страницы "Настройки - Особо опасные объекты"
     */
    public SettingsDangerObjectsPage getSettingsDangerObjectsPage() {
        return new SettingsDangerObjectsPage(app);
    }

    /**
     * Получение страницы "Настройки - Настройки подразделения для отчетности"
     */
    public SettingsDepartmentForReportPage getSettingsDepartmentForReportPage() {
        return new SettingsDepartmentForReportPage(app);
    }

    /**
     * Получение страницы "Настройки - Настройки МО для отчетности"
     */
    public SettingsMOForReportPage getSettingsMOForReportPage() {
        return new SettingsMOForReportPage(app);
    }

    /**
     * Получение страницы "Бригады: справочники - Бригады"
     */
    public BrigadsPage getBrigadsPage() {
        return new BrigadsPage(app);
    }

    /**
     * Получение страницы "Бригады: справочники - Шаблон вида бригады"
     */
    public BrigadeViewTemplatePage getBrigadeViewTemplatePage() {
        return new BrigadeViewTemplatePage(app);
    }

    /**
     * Получение страницы "Бригады: справочники - Транспортное средство"
     */
    public TransportPage getTransportPage() {
        return new TransportPage(app);
    }


    /*-------------------------------- Открытие страниц --------------------------------*/

    /**
     * Окрытие страницы "Журнал диспетчера"
     */
    public void openDispetcherJournalPage() {
        page.getHeader().openPage("amb.dispjournal");
    }

    /**
     * Окрытие страницы "Журнал диспетчера направления"
     */
    public void openDirectionDispetcherJournalPage() {
        page.getHeader().openSpaceAndPage("Наряд", "amb.queue");
    }

    /**
     * Окрытие страницы "Наряд- Журнал нарядов"
     */
    public void openTeamJournalPage() {
        page.getHeader().openSpaceAndPage("Наряд", "amb.team_job_journal");
    }

    /**
     * Окрытие страницы "Наряд - журнал нарядов сотрудников"
     */
    public void openTeamEmployeesJournalPage() {
        page.getHeader().openSpaceAndPage("Наряд", "amb.team_job_resource_emp");
    }

    /**
     * Окрытие страницы "Наряд - Журнал нарядов транспорта"
     */
    public void openTeamTransportJournalPage() {
        page.getHeader().openSpaceAndPage("Наряд", "amb.team_job_resource_transp");
    }

    /**
     * Окрытие страницы "Журнал БУМ"
     */
    public void openPaperJournalPage() {
        page.getHeader().openPage("amb.cardpaperjournal");
    }

    /**
     * Окрытие страницы "Журнал"
     */
    public void openJournalPage() {
        page.getHeader().openPage("amb.paperjournal");
    }

    /**
     * Окрытие страницы "Администрирование - Смены"
     */
    public void openAdministrationChangesPage() {
        page.getHeader().openSpaceAndPage("Администрирование", "amb.change");
    }

    /**
     * Окрытие страницы "Настройки - Настройка нумератора"
     */
    public void openSettingsNumeratorPage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.num_setting");
    }

    /**
     * Окрытие страницы "Настройки - Настройка смены"
     */
    public void openSettingsChangePage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.change_setting");
    }

    /**
     * Окрытие страницы "Настройки - Настройки периодов"
     */
    public void openSettingsPeriodsPage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.notes_setting");
    }

    /**
     * Окрытие страницы "Настройки - Настройка контрольного времени"
     */
    public void openSettingsControlTimePage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.time_control");
    }

    /**
     * Окрытие страницы "Настройки - Настройка направлений"
     */
    public void openSettingsDirectionsPage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.route");
    }

    /**
     * Окрытие страницы "Настройки - Настройки распределения вызовов по диспетчерам"
     */
    public void openCallsByDispetchersPage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.redirect_settings");
    }


    /**
     * Окрытие страницы "Настройки - Особо опасные объекты"
     */
    public void openDangerObjectsPage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.pim_org_dangerous_area");
    }

    /**
     * Окрытие страницы "Настройки - Настройки подразделения для отчетности"
     */
    public void openDepartmentForReportPage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.department_report_settings");
    }

    /**
     * Окрытие страницы "Настройки - Настройки МО для отчетности"
     */
    public void openMOForReportPage() {
        page.getHeader().openSpaceAndPage("Настройки", "amb.clinic_report_settings");
    }

    /**
     * Окрытие страницы "Бригады: справочники - Бригады"
     */
    public void openBrigadsPage() {
        page.getHeader().openSpaceAndPage("Бригады: справочники", "amb.res_team");
    }

    /**
     * Окрытие страницы "Бригады: справочники - Шаблон вида бригады"
     */
    public void openBrigadeViewTemplatePage() {
        page.getHeader().openSpaceAndPage("Бригады: справочники", "amb.team_template_setting");
    }

    /**
     * Окрытие страницы "Бригады: справочники - Транспортное средство"
     */
    public void openTransportPage() {
        page.getHeader().openSpaceAndPage("Бригады: справочники", "amb.pimtransport");
    }

}
