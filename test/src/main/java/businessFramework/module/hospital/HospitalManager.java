package businessFramework.module.hospital;

import businessFramework.module.hospital.pages.PrescriptionPeriodicity.PrescriptionPeriodicityPage;
import businessFramework.module.hospital.pages.employeeSetting.EmployeeSettingPage;
import businessFramework.module.hospital.pages.hospitalReferral.HospitalReferralPage;
import businessFramework.module.hospital.pages.informationDesk.InformationDeskPage;
import businessFramework.module.hospital.pages.operation.journal.OperationJournalPage;
import businessFramework.module.hospital.pages.operation.planning.OperationPlanningPage;
import businessFramework.module.hospital.pages.prescriptionExecution.PrescriptionExecutionPage;
import businessFramework.module.hospital.pages.prescriptionExecution.PrescriptionServiceExecutionPage;
import businessFramework.module.hospital.pages.reservation.ReservationPage;
import businessFramework.module.hospital.pages.service.ServicePage;
import businessFramework.module.hospital.pages.admisDepart.AdmisDepartPage;
import businessFramework.module.hospital.pages.branchManager.BranchManagerPage;
import businessFramework.module.hospital.pages.doctorDepart.DoctorDepartPage;
import businessFramework.module.hospital.pages.nurseDepart.NurseDepartPage;
import businessFramework.module.hospital.pages.service.operation.AddResultToOperationPage;
import businessFramework.module.hospital.pages.servicesTemplate.ServicesTemplatePage;
import businessFramework.module.hospital.pages.statistics.StatisticsPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import test.businessTests.hospital.OperationJournalTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HospitalManager {
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    //Получение страницы Приемное отделение
    public AdmisDepartPage getAdmisDepartPage() {
        return new AdmisDepartPage(app);
    }

    //Получение страницы Стол справок
    public InformationDeskPage getInformationDeskPage(){
        return new InformationDeskPage(app);
    }

    //Получение страницы Заведующий отделением
    public BranchManagerPage getBranchManagerPage() {
        return new BranchManagerPage(app);
    }

    //Получение страницы Врач отделения
    public DoctorDepartPage getDoctorDepartPage() {
        return new DoctorDepartPage(app);
    }

    //Получение страницы Медсестра отделения
    public NurseDepartPage getNurseDepartPage() {
        return new NurseDepartPage(app);
    }

    //Получение страницы Статистики
    public StatisticsPage getStatisticsPage()
    {
        return new StatisticsPage(app);
    }

    //Получение страницы Процедурная медсестра
    public PrescriptionExecutionPage getPrescriptionExecutionPage()
    {
        return  new PrescriptionExecutionPage(app);
    }

    public PrescriptionServiceExecutionPage getPrescriptionServiceExecutionPage()
    {
        return new PrescriptionServiceExecutionPage(app);
    }

    //Получение страницы Создания услуги
    public ServicePage getServicePage()
    {
        return new ServicePage(app);
    }

    public AddResultToOperationPage getAddResultToOperationPage() {
        return new AddResultToOperationPage(app);
    }
    //Получение страницы ПЕриодичность назначения
    public PrescriptionPeriodicityPage getPrescriptionPeriodicityPage() {
        return new PrescriptionPeriodicityPage(app);
    }

    //Получение страницы шаблоны услуг
    public ServicesTemplatePage getServicesTemplatePage() {
        return new ServicesTemplatePage(app);
    }

    public OperationPlanningPage getOperationPlanningPage() {
        return new OperationPlanningPage(app);
    }

    public OperationJournalPage getOperationJournalPage() {
        return new OperationJournalPage(app);
    }

    //Получение страницы "Роли сотрудника"
    public EmployeeSettingPage getEmployeeSettingPage() {
        return new EmployeeSettingPage(app);
    }

    //Получение страницы "Журнал направлений"
    public HospitalReferralPage getReferralListPage() {
        return new HospitalReferralPage(app);
    }

    //Получение страницы "Журнал очереди на госпитализацию"
    public ReservationPage getReservationListPage() {
        return new ReservationPage(app);
    }

    //Открытие модуля Стационар
    public void openHospitalModule() {
        app.getNavigationHelper().openPageWithModule("modules.hospital");
    }

    //todo найдено альтернативное решение запуска в полноэкранном режиме
    public void sendKeyF11() throws AWTException {
    Robot robotf11 = new Robot();
    robotf11.keyPress(KeyEvent.VK_F11);
    robotf11.keyRelease(KeyEvent.VK_F11);
    }
    public void sendKeyCtrl() throws AWTException {
        Robot robotctrl = new Robot();
        robotctrl.keyPress(KeyEvent.VK_CONTROL);
        robotctrl.keyPress(KeyEvent.VK_MINUS);
        robotctrl.keyRelease(KeyEvent.VK_CONTROL);
        robotctrl.keyRelease(KeyEvent.VK_MINUS);
    }

    //Открытие страницы Журнал госпитализации
    public void openAdmisDepart() {
        page.getHeader().openSpaceAndPage("Приемное отделение", "hospital.hospitalCaseList");
    }

    //Открытие страницы Стол справок
    public void openInformationDesk() {
        page.getHeader().openSpaceAndPage("Приемное отделение", "hospital.informationDesk");
    }


    /**
     * Открытие страницы Заведующий отделением
     */
    public void openBranchManager()
    {
        page.getHeader().openSpaceAndPage("Лечебное отделение", "hospital.list");
    }

    /**
     * Открытие страницы Заведующий отделением
     */
    public void openPageHospitalList()
    {
        page.getHeader().openSpaceAndPage("Лечебное отделение", "hospital.list");
    }

    //Открытие страницы Врач отделения
    public void openDoctorDepartment() {
        page.getHeader().openSpaceAndPage("Лечебное отделение", "hospital.medicalHistoryList");
    }

    //Открытие страницы Медсестра отделения
    public void openNurseDepartment() {
        page.getHeader().openSpaceAndPage("Лечебное отделение", "hospital.patientList");
    }

    //Открытие страницы Статистика
    public void openStatistic()
    {
        page.getHeader().openPage("hospital.statisticalMapList");
    }

    //Открытие страницы Процедурная медсестра
    public void openPrescriptionExecutionPage()
    {
        page.getHeader().openSpaceAndPage("Лечебное отделение", "hospital.hosp_prescription_execution_list");
    }

    //Открытие страницы Периодичность назначения
    public void openPrescriptionPeriodicityPage() {
        page.getHeader().openSpaceAndPage("Настройки", "hospital.hosp_prescription_periodicity_list");
    }

    //Открытие страницы Шаблоны услуг
    public void openServicesTemplatePage() {
        page.getHeader().openSpaceAndPage("Настройки", "hospital.servicesTemplate");
    }

    //Открытие страницы Роли сотрудников
    public void openEmployeeSettingPage() {
        page.getHeader().openSpaceAndPage("Настройки", "hospital.employeeSetting");
    }

    //Открытие страницы Журнал направлений
    public void openReferralListPage() {
        page.getHeader().openSpaceAndPage("Планирование госпитализации", "hospital.hospReferralList");
    }

    //Открытие страницы Журнал очереди на госпитализацию
    public void openReservationListPage() {
        page.getHeader().openSpaceAndPage("Планирование госпитализации", "hospital.reservationList");
    }

    public void openOperationPlanning() {
        page.getHeader().openSpaceAndPage("Операционное отделение", "hospital.operationPlanning");
    }

    public void openOperationJournal() {
        page.getHeader().openSpaceAndPage("Операционное отделение", "hospital.operationJournal");
    }
}
