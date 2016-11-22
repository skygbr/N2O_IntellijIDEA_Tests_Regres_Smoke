package businessFramework.module.hospital.pages.HospitalCase;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import businessFramework.module.hospital.modals.attendantIndivi.AttendantIndivModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;

public class HospitalCasePage implements Values
{
    private HospitalCaseHelper hospitalHelper;
    private HospitalRecordHelper hospRecordHelper;
    private HospitalRefusalHelper hospitalRefusalHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public HospitalCasePage()
    {
        this.hospitalHelper = new HospitalCaseHelper();
        this.hospRecordHelper = new HospitalRecordHelper();
        this.hospitalRefusalHelper = new HospitalRefusalHelper();
    }

    public void assertAdmissionDate(String value)
    {
        String currentValue = hospitalHelper.getAdmissionDate().getValue();
        List<String> values = Arrays.asList(page.addMinutes(value, -1), value, page.addMinutes(value, 1)); //List из текущего времени и текущее время +- 1 минута
        assertThat("Admission date and time not equal to current date and time", currentValue, isIn(values));
    }

    public void clickEditButton()
    {
        Button edit = hospitalHelper.getEditButton();
        edit.assertIsEnabled();
        edit.click();
    }

    public void clickCreateFirstHospitalRecordButton()
    {
        hospitalHelper.getCreateFirstHospitalRecordButton().click();
        page.assertModalPresentOnPage(true);
        page.getModal().assertModalHeader_contains("Направление в отделение");
    }

    public void clickConfirmButton()
    {
        Button button = hospitalHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getForm().getAlerts().assertSuccessAlertIsPresent();
    }

    public void clickBackButton()
    {
        Button button = hospitalHelper.getBackButton();
        button.assertIsEnabled();
        button.click();
        page.assertBreadcrumbEqualsValue("Журнал госпитализации");
    }

    public void clickRefusalButton()
    {
        Button button = hospitalHelper.getRefusalButton();
        button.assertIsEnabled();
        button.click();
        page.assertModalPresentOnPage(true);
        page.getModal().assertModalHeader_contains("Отказ от госпитализации");
    }

    /**
     * Заполнение формы случая госпитализации
     */
    public void fillHospitalForm(HospitalData hospitalData)
    {
        hospitalHelper.getPatient().setValue(hospitalData.getPatient());
        hospitalHelper.getFinancialType().setValue(hospitalData.getFinancialType());
        hospitalHelper.getCareProvidingForm().setValue(hospitalData.getCareProvidingForm());
        hospitalHelper.getInitGoal().setValue(hospitalData.getInitGoal());

        if (hospitalData.getCareProvidingForm() != null &&
                "экстренная".equals(hospitalData.getCareProvidingForm().toLowerCase().trim())) {
            hospitalHelper.getNotesToWork().assertIsHidden(false);
            hospitalHelper.getNotesToWork().setValue(hospitalData.getNotesToWork());

            hospitalHelper.getDrunkennessType().assertIsHidden(false);
            hospitalHelper.getDrunkennessType().setValue(hospitalData.getDrunkennessType());

            if(hospitalData.getDrunkennessType() != null &&
                    "наркотическое".equals(hospitalData.getDrunkennessType().toLowerCase().trim())){
                hospitalHelper.getNarcoticSubstance().assertIsHidden(false);
                hospitalHelper.getNarcoticSubstance().setValue(hospitalData.getNarcoticSubstance());

                hospitalHelper.getWhereFromDelivered().assertIsHidden(false);
                hospitalHelper.getWhereFromDelivered().setValue(hospitalData.getWhereFromDelivered());
            } else  {
                hospitalHelper.getNarcoticSubstance().assertIsHidden(true);
                hospitalHelper.getWhereFromDelivered().assertIsHidden(true);
            }
        } else {
            hospitalHelper.getDrunkennessType().assertIsHidden(true);
            hospitalHelper.getNarcoticSubstance().assertIsHidden(true);
            hospitalHelper.getWhereFromDelivered().assertIsHidden(true);
        }

        hospitalHelper.getSeverityLevel().setValue(hospitalData.getSeverityLevel());
        hospitalHelper.getTransportingType().setValue(hospitalData.getTransportingType());
        hospitalHelper.getRepeatCount().setValue(hospitalData.getRepeatCount());
        hospitalHelper.getAdmissionDiagnosis().setValue(hospitalData.getDiagnosis());
        if (page.getHeader().getContext().size() > 2 && page.getHeader().getContext().get(2) != null) {
            hospitalHelper.getAdmissionDepartment().assertValue_equals(page.getHeader().getContext().get(2));
        } else {
            hospitalHelper.getAdmissionDepartment().setValue(hospitalData.getAdmissionDepartment());
        }
        hospitalHelper.getDoctor().setValue(hospitalData.getDoctor());
        hospitalHelper.getMarkInput().check(hospitalData.getMark());
        hospitalHelper.getRelativesInput().check(hospitalData.getRelatives());
        hospitalHelper.getInstitutionInput().check(hospitalData.getInstitution());
    }

    /**
     * Проверка заполненности формы случая госпитализации
     */
    public void assertHospitalForm(HospitalData hospitalData)
    {
        hospitalHelper.getPatient().assertValue_contains(hospitalData.getPatient());
        hospitalHelper.getFinancialType().assertValue_equals(hospitalData.getFinancialType());
        hospitalHelper.getCareProvidingForm().assertValue_equals(hospitalData.getCareProvidingForm());
        hospitalHelper.getInitGoal().assertValue_equals(hospitalData.getInitGoal());
        if (hospitalData.getCareProvidingForm() != null &&
                "экстренная".equals(hospitalData.getCareProvidingForm().toLowerCase().trim())) {
            hospitalHelper.getNotesToWork().assertIsHidden(false);
            hospitalHelper.getNotesToWork().assertValue(hospitalData.getNotesToWork());

            hospitalHelper.getDrunkennessType().assertIsHidden(false);
            hospitalHelper.getDrunkennessType().assertValue_equals(hospitalData.getDrunkennessType());

            if (hospitalData.getDrunkennessType() != null &&
                    "наркотическое".equals(hospitalData.getDrunkennessType().toLowerCase().trim())) {
                hospitalHelper.getNarcoticSubstance().assertIsHidden(false);
                hospitalHelper.getNarcoticSubstance().assertValue(hospitalData.getNarcoticSubstance());

                hospitalHelper.getWhereFromDelivered().assertIsHidden(false);
                hospitalHelper.getWhereFromDelivered().assertValue(hospitalData.getWhereFromDelivered());
            }
        } else {
            hospitalHelper.getDrunkennessType().assertIsHidden(true);
            hospitalHelper.getNarcoticSubstance().assertIsHidden(true);
            hospitalHelper.getWhereFromDelivered().assertIsHidden(true);
        }
        hospitalHelper.getTransportingType().assertValue_equals(hospitalData.getTransportingType());
        hospitalHelper.getSeverityLevel().assertValue_equals(hospitalData.getSeverityLevel());   // mike todo

        hospitalHelper.getAdmissionDepartment().assertValue_equals(hospitalData.getAdmissionDepartment());
        hospitalHelper.getRepeatCount().assertValue_equals(hospitalData.getRepeatCount());
        hospitalHelper.getDoctor().assertValue_contains(hospitalData.getRecorder());
        hospitalHelper.getMarkInput().assertThatCheckboxIsChecked(hospitalData.getMark());
        hospitalHelper.getRelativesInput().assertThatCheckboxIsChecked(hospitalData.getRelatives());
        hospitalHelper.getInstitutionInput().assertThatCheckboxIsChecked(hospitalData.getInstitution());
    }

    public void assertHospitalForm_AttendantIndiv(HospitalData hospitalData) {
        hospitalHelper.getAttendantIndiv().assertValue_contains(hospitalData.getAttendantIndivFullFShortIO());
    }

    public void openSendToHospital()
    {
        hospRecordHelper.getContainer().clickContainer();
    }

    public void assertCreatePatientLink()
    {
        Button create = hospitalHelper.getPatient().getButton("Создать в N2O");
        Button edit = hospitalHelper.getPatient().getButton("Редактировать в N2O");

        create.assertIsEnabled();
        edit.assertIsDisabled();
        //Todo Переход для создания пациента, в карточку пациента LSD более не производится, все действия c пациентом в N2O
        /**
        String mainWindow = app.getWebDriverHelper().getDriver().getWindowHandle();
        create.click();
        app.getBaseHelperWithWebDriver().switchToWindow(app.getBaseHelperWithWebDriver().getNewWindow());
        String newWindowUrl = page.getCurrentUrl();
        app.getWebDriver().close();
        app.getBaseHelperWithWebDriver().switchToWindow(mainWindow);
        assertThat(String.format("Link %s doesn't open create patient page", CREATE_LINK), newWindowUrl,
        containsString(app.getProperty("baseUrl").replace("/frontend", "") + "/pats/patients/new"));
        */
    }

    public void assertEditPatientLink()
    {
        Button create = hospitalHelper.getPatient().getButton("Создать в N2O");
        Button edit = hospitalHelper.getPatient().getButton("Редактировать в N2O");

        create.assertIsEnabled();
        edit.assertIsEnabled();
        //Todo Переход для редактирования пациента, в карточку пациента LSD более не производится, все действия c пациентом в N2O
        /**
        String mainWindow = app.getWebDriverHelper().getDriver().getWindowHandle();
        edit.click();
        app.getBaseHelperWithWebDriver().switchToWindow(app.getBaseHelperWithWebDriver().getNewWindow());
        String newWindowUrl = page.getCurrentUrl();
        app.getWebDriver().close();
        app.getBaseHelperWithWebDriver().switchToWindow(mainWindow);
        assertThat(String.format("Link %s doesn't open edit patient page", EDIT_LINK), newWindowUrl.matches(app.getProperty("baseUrl").replaceAll("/frontend.*", "") + "/pats/patients/\\d+/edit.+"), is(true));
        */
    }

    public void assertSendToDepartment(HospitalData hospitalData)
    {
        page.assertBreadcrumbContainsValue("Случай госпитализации");
        openSendToHospital();
        assertSendToDepartmentForm(hospitalData);
    }

    /**
     * Проверяем форму направления в отделение
     */
    private void assertSendToDepartmentForm(HospitalData hospitalData)
    {
        hospRecordHelper.getPatientOutputText().assertFieldText(hospitalData.getPatient());
        hospRecordHelper.getFinancialTypeOutputText().assertFieldText(hospitalData.getFinancialType());
        hospRecordHelper.getDepartment().assertValue_contains(hospitalData.getDepartment());
        hospRecordHelper.getUid().assertValue(hospitalData.getUid());
        hospRecordHelper.getProfile().assertValue_contains(hospitalData.getProfile());
        hospRecordHelper.getCareRegimen().assertValue_contains(hospitalData.getCareRegimen());

        hospRecordHelper.getSickListIssueDate().assertIsHidden(false);
        hospRecordHelper.getSickListNumber().assertIsHidden(false);

        hospRecordHelper.getNeedSickList().assertThatCheckboxIsChecked(hospitalData.getNeedSickList());
        hospRecordHelper.getHasSickList().assertThatCheckboxIsChecked(hospitalData.getHasSickList());

        hospRecordHelper.getSickListIssueDate().assertValue_contains(hospitalData.getSickListIssueDate());
        hospRecordHelper.getSickListNumber().assertValue(hospitalData.getSickListNumber());
    }

    public void assertRefusalHospitalization(HospitalData hospitalData)
    {
        page.assertBreadcrumbContainsValue("Случай госпитализации");
        hospitalRefusalHelper.getRefusalContainer().clickContainer();
        assertPatientDataForm(hospitalData);
        assertForm(hospitalData);
    }

    public void assertPatientDataForm(HospitalData hospitalData)
    {
        hospitalRefusalHelper.getPatientName().assertFieldText(hospitalData.getPatient());
        hospitalRefusalHelper.getFinancialTypeName().assertFieldText(hospitalData.getFinancialType());
    }

    public void assertForm(HospitalData hospitalData)
    {
        hospitalRefusalHelper.getRefusalDate().assertThatDateContainsValue(hospitalData.getRefusalDate());
        hospitalRefusalHelper.getUid().assertValue(hospitalData.getUid());
        hospitalRefusalHelper.getRefusalEmployee().assertValue_contains(hospitalData.getRefusalEmployee());
        hospitalRefusalHelper.getStepResultReason().assertValue_contains(hospitalData.getStepResultReason());
        hospitalRefusalHelper.getStepResult().assertValue_contains(hospitalData.getStepResult());
        hospitalRefusalHelper.getRegimen().assertValue_contains(hospitalData.getCareRegimen());
        hospitalRefusalHelper.getProfile().assertValue_contains(hospitalData.getProfile());
    }

    /**
     * Нажатие на кнопку Добавить индивида (Поле Сопр.лицо)
     */
    public void clickAttendantIndivBtn()
    {
        Button addBtn = new Button(app, hospitalHelper.getAttendantIndiv().takeContainer(), "n2o-links-action_link.pointer" );
        addBtn.assertIsEnabled();
        addBtn.click();
        page.assertModalPresentOnPage(true);
        page.getModal().assertModalHeader_contains("Добавление родственника");
    }

    /**
     * Проверяем, что работает добавление родственника
     */
    public void addAttendantIndiv(HospitalData hospitalData)
    {
        this.clickAttendantIndivBtn();
        getAttendantIndivModal().fillForm(hospitalData);
    }

    public AttendantIndivModal getAttendantIndivModal()
    {
        return new AttendantIndivModal();
    }
}
