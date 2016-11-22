package businessFramework.module.hospital.pages.statisticCard;


import businessFramework.entities.hospital.DiagnosisData;
import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.modals.diagnosis.DiagnosisModal;
import businessFramework.module.hospital.modals.movingDepartment.MovingDepartmentModal;
import businessFramework.module.hospital.modals.service.ServiceModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class StatisticCardPage extends StatisticCardHelper
{
    public StatisticCardPage(ApplicationManager app)
    {
        super(app);
    }

    public MovingDepartmentModal getMovingToDepartmentModal()
    {
        return new MovingDepartmentModal();
    }

    public ServiceModal getServiceModal()
    {
        return new ServiceModal("serviceRenderedForm");
    }

    public DiagnosisModal getDiagnosisModal()
    {
        return new DiagnosisModal();
    }

    /**
     * Нажатие на кнопку Сохранить на страницы Статистической карты
     */
    public void clickSaveHospitalButton()
    {
        Button button = getSaveStatisticButton();
        button.assertIsEnabled();
        button.click();
        getContainerMain().getForm().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Нажатие на кнопку Создать запись о движению по отделениям
     */
    public void clickCreateSendToDepartmentButton()
    {
        Button button = getCreateSendToDepartmentButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Движение по отделениям");
    }

    /**
     * Нажатие на кнопку Изменить запись о двтжении по отделению
     */
    public void clickUpdateSendToDepartmentButton()
    {
        Button button = getEditSendToDepartmentButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Движение по отделениям");
    }

    /**
     * Нажатие на кнопку создания услуги
     */
    public void clickCreateServiceButton()
    {
        Button button = getCreateServiceButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Услуги");
    }

    /**
     * Нажатие на кнопку редактирования услуги
     */
    public void clickUpdateServiceButton()
    {
        Button button = getEditServiceButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Услуги");
    }

    public void clickCreateDiagnosisButton()
    {
        Button button = getCreateDiagnosisButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Диагнозы");
    }

    public void clickUpdateDiagnosisButton()
    {
        Button button = getEditDiagnosisButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Диагнозы");
    }

    /**
     * Заполнение формы Статистической карты
     */
    public void fillForm(HospitalData hospitalData)
    {
        getPatient().setValue(hospitalData.getPatient());
        getUid().setValue(hospitalData.getUid());
        getCareProvidingForm().setValue(hospitalData.getCareProvidingForm());
        getFinancialType().setValue(hospitalData.getFinancialType());
        getInitGoal().setValue(hospitalData.getInitGoal());
        getCareLevel().setValue(hospitalData.getCareLevel());
        getTransportingType().setValue(hospitalData.getTransportingType());
        getAdmissionDepartment().setValue(hospitalData.getAdmissionDepartment());
    }

    /**
     * Проверка формы Статистической карты
     */
    public void assertForm(HospitalData hospitalData)
    {
        getPatient().assertValue_contains(hospitalData.getPatient());
        getUid().assertValue(hospitalData.getUid());
        getCareProvidingForm().assertValue_contains(hospitalData.getCareProvidingForm());
        getFinancialType().assertValue_contains(hospitalData.getFinancialType());
        getInitGoal().assertValue_contains(hospitalData.getInitGoal());
        getCareLevel().assertValue_contains(hospitalData.getCareLevel());
        getTransportingType().assertValue_contains(hospitalData.getTransportingType());
        getAdmissionDepartment().assertValue_contains(hospitalData.getAdmissionDepartment());
    }

    /**
     * Создание записи движения по отделениям
     */
    public void createSendToDepartment(HospitalData hospitalData)
    {
        this.clickCreateSendToDepartmentButton();
        getMovingToDepartmentModal().fillOutcomeDate(hospitalData);
        getMovingToDepartmentModal().fillStatisticSendToDepartment(hospitalData);
        getMovingToDepartmentModal().clickConfirmButton();
    }

    /**
     * Редактирование записи движения по отделениям
     */
    public void editSendToDepartment(HospitalData hospitalData)
    {
        this.clickUpdateSendToDepartmentButton();
        getMovingToDepartmentModal().fillStatisticSendToDepartment(hospitalData);
        getMovingToDepartmentModal().clickConfirmButton();
    }

    /**
     * Создание услуги
     */
    public void createService(HospitalData hospitalData)
    {
        this.clickCreateServiceButton();
        getServiceModal().fillOperationService(hospitalData);
        getServiceModal().clickConfirmButton();
    }

    /**
     * Создание услуги
     */
    public void editService(HospitalData hospitalData)
    {
        this.clickUpdateServiceButton();
        getServiceModal().fillOperationService(hospitalData);
        getServiceModal().clickConfirmButton();
    }

    /**
     * Создание диагноза
     */
    public void createDiagnosis(DiagnosisData diagnosisData)
    {
        this.clickCreateDiagnosisButton();
        getDiagnosisModal().fillDiagnosisForm(diagnosisData);
        getDiagnosisModal().clickSaveDiagnosis();
    }

    /**
     * Редактирование диагноза
     */
    public void editDiagnosis(DiagnosisData diagnosisData)
    {
        this.clickUpdateDiagnosisButton();
        getDiagnosisModal().fillDiagnosisForm(diagnosisData);
        getDiagnosisModal().clickSaveDiagnosis();
    }
}
