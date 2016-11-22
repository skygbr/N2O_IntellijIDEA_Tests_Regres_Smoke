package businessFramework.module.gibddMedicalExamination;

import businessFramework.module.gibddMedicalExamination.pages.Commission.CommissionPage;
import businessFramework.module.gibddMedicalExamination.pages.Doctor.DoctorPage;
import businessFramework.module.gibddMedicalExamination.pages.DriverCard.DriverCardPage;
import businessFramework.module.gibddMedicalExamination.pages.Event.EventCardPage;
import businessFramework.module.gibddMedicalExamination.pages.Registrator.RegistratorPage;
import businessFramework.module.gibddMedicalExamination.pages.Settings.SettingsPage;
import businessFramework.module.gibddMedicalExamination.pages.Settings.ModelPatients.ModelPatientsPage;
import businessFramework.module.gibddMedicalExamination.pages.Settings.Population.PopulationPage;
import businessFramework.module.gibddMedicalExamination.pages.Settings.Refbooks.RefbooksPage;
import businessFramework.module.gibddMedicalExamination.pages.Settings.ServiceByDoc.ServiceByDocPage;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.base.NavigationHelper;
import net.framework.autotesting.meta.Page;

public class GibddMedicalExaminationManager {
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();
    private NavigationHelper navigationHelper = new NavigationHelper(app);

    /**
     * Получение страницы "Регистратор"
     *
     * @return страницу "Регистратор"
     */
    public RegistratorPage getRegistratorPage() {
        return new RegistratorPage(app);
    }

    /**
     * Получение страницы "Врач"
     *
     * @return страницу "Врач"
     */
    public DoctorPage getDoctorPage() {
        return new DoctorPage(app);
    }

    /**
     * Получение страницы "Комиссия"
     *
     * @return страницу "Комиссия"
     */
    public CommissionPage getCommissionPage() {
        return new CommissionPage(app);
    }

    /**
     * Получение страницы "Настройки"
     *
     * @return страницу "Настройки"
     */
    public SettingsPage getSettingsPage() {
        return new SettingsPage(app);
    }

    /**
     * Получение страницы "Настройки - Модель пациента"
     *
     * @return страницу "Настройки - Модель пациента"
     */
    public ModelPatientsPage getModelPatientsPage() {
        return new ModelPatientsPage(app);
    }

    /**
     * Получение страницы "Настройки - Численность населения"
     *
     * @return страницу "Настройки - Численность населения"
     */
    public PopulationPage getPopulationPage() {
        return new PopulationPage(app);
    }

    /**
     * Получение страницы "Настройки - Численность населения"
     *
     * @return страницу "Настройки - Численность населения"
     */
    public RefbooksPage getRefbooksPage() {
        return new RefbooksPage(app);
    }

    /**
     * Получение страницы "Настройки - Услуги по нормативному документу"
     *
     * @return страницу "Настройки - Услуги по нормативному документу"
     */
    public ServiceByDocPage getServiceByDocPage() {
        return new ServiceByDocPage(app);
    }

    /**
     * Получение страницы "Карточка мероприятия"
     *
     * @return страницу "Карточка мероприятия"
     */
    public EventCardPage getEventCardPage() {
        return new EventCardPage(app);
    }

    /**
     * Получение страницы "Карточка"
     *
     * @return страницу "Карточка"
     */
    public DriverCardPage getDriverCardPage() {
        return new DriverCardPage(app);
    }

    /**
     * Открытие модуля "Освидетельствование для справки в ГИБДД"
     */
    public void openDispGibddModule() {
        app.getNavigationHelper().openPageWithModule("modules.dispGibdd");
    }

    /**
     * Открытие страницы Регистратор
     */
    public void openRegistrator() {
        this.openDispGibddModule();
        page.getHeader().openPage("dispGibdd.EventsListGibddRegistrator");
    }

    /**
     * Открытие страницы Врач
     */
    public void openDoctor() {
        this.openDispGibddModule();
        page.getHeader().openPage("dispGibdd.EventsListGibddDoctor");
    }

    /**
     * Открытие страницы Комиссия
     */
    public void openComission() {
        this.openDispGibddModule();
        page.getHeader().openPage("dispGibdd.EventsListGibddCommission");
    }

    /**
     * Открытие страницы Настройки - Модель пациента
     */
    public void openModelPatients() {
        this.openDispGibddModule();
        page.getHeader().openSpaceAndPage("Настройки", "dispGibdd.ModelPatients");
    }

    /**
     * Открытие страницы Настройки - Услуги по нормативному документу
     */
    public void openServiceByDoc() {
        this.openDispGibddModule();
        page.getHeader().openSpaceAndPage("Настройки", "dispGibdd.ServiceByDoc");
    }

    /**
     * Открытие страницы Настройки - Назначения стандарта
     */
    public void openExtendedStandardPrescription() {
        this.openDispGibddModule();
        page.getHeader().openSpaceAndPage("Настройки", "dispGibdd.ExtendedStandardPrescription");
    }

    /**
     * Открытие страницы Настройки - Справочники
     */
    public void openRefbooks() {
        this.openDispGibddModule();
        page.getHeader().openSpaceAndPage("Настройки", "dispGibdd.refbooks");
    }

    /**
     * Открытие страницы Настройки - Численность населения
     */
    public void openPopulation() {
        this.openDispGibddModule();
        page.getHeader().openSpaceAndPage("Настройки", "dispGibdd.population");
    }

    /**
     * Открытие страницы Настройки - Назначение формы на услугу
     */
    public void openAssignmentFormService() {
        this.openDispGibddModule();
        page.getHeader().openSpaceAndPage("Настройки", "dispGibdd.assignmentFormService");
    }

}
