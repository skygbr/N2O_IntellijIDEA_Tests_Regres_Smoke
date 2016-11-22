package businessFramework.module.hospital.pages.admisDepart;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import businessFramework.module.hospital.modals.movingDepartment.MovingDepartmentModal;
import businessFramework.module.hospital.modals.refusal.RefusalModal;
import businessFramework.module.hospital.pages.HospitalCase.HospitalCasePage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;


public class AdmisDepartPage extends AdmissDepartHelper implements Values
{
    public AdmisDepartPage(ApplicationManager app)
    {
        super(app);
    }

    public AdmisDepartFilter getFilter()
    {
        return new AdmisDepartFilter(app);
    }

    public HospitalCasePage getHospitalCasePage()
    {
        return new HospitalCasePage();
    }

    public MovingDepartmentModal getSendToDepartmentModal()
    {
        return new MovingDepartmentModal();
    }

    public RefusalModal getRefusalModal()
    {
        return new RefusalModal();
    }

    public void clickCreateHospitalCaseButton()
    {
        Button create = getCreateHospitalButton();
        create.assertIsEnabled();
        create.click();
        assertBreadcrumbContainsValue("Случай госпитализации");
    }

    public void clickEditHospitalButton()
    {
        Button update = getEditHospitalButton();
        update.assertIsEnabled();
        update.click();
        assertBreadcrumbContainsValue("Случай госпитализации");
    }

    public void clickCreateServiceButton()
    {
        Button create = getCreateServiceButton();
        create.assertIsEnabled();
        create.clickButtonOnDropDown();
    }

    public void clickCancelRenderedButton()
    {
        getCancelRenderedButton().assertIsEnabled();
        getCancelRenderedButton().click();
        getDialog().clickYes();
    }

    public void clickCopyServiceButton()
    {
        Button copy = getCopyServiceButton();
        copy.assertIsEnabled();
        copy.clickButtonOnDropDown();
    }

    public void clickEditRenderedButton()
    {
        Button edit = getEditRenderedButton();
        edit.assertIsEnabled();
        edit.click();
    }

    public void clickCreateRenderedButton()
    {
        Button edit = getCreateRenderedButton();
        edit.assertIsEnabled();
        edit.click();
    }

    public void clickDeleteHospitalButton()
    {
        Button delete = getDeleteHospitalButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    //Проверка даты в фильтре
    public void assertFilterDate(String dateBegin, String dateEnd)
    {
        this.getContainerHospitalCases().showFilter();
        getFilter().getAdmissionDate().assertThatPeriodContainsValues(dateBegin, dateEnd);
        this.getContainerHospitalCases().showFilter();
    }

    //Удаление случаев госпитализации
    public void deleteHospitalCase(HospitalData hospitalData) {
        this.getContainerHospitalCases().showFilter();
        getFilter().getAdmissionDate().setPeriod("", "");
        getFilter().getPatient().setValue(hospitalData.getPatient());
        this.getContainerHospitalCases().getFilter().clickFindButton();

        Table table = this.getContainerHospitalCases().getTable();

        while (table.getCountRowsInTable(true) > 0) {
            int size = table.getCountRowsInTable(true);
            table.chooseRowInTable(0);
            this.clickDeleteHospitalButton();
            table = this.getContainerHospitalCases().getTable();
            assertThat("Rows doesn't delete from table", size,
                    not(table.getCountRowsInTable(true)));
        }
    }

    public void deleteHospitalCaseByFilter(HospitalData hospitalData) {
        this.getContainerHospitalCases().showFilter();
        getFilter().getAdmissionDate().setPeriod("", "");
        getFilter().getUid().setValue(hospitalData.getUid());
        getFilter().getPatient().setValue(hospitalData.getPatient());
        getFilter().getFinancialType().setValue(hospitalData.getFinancialType());

        this.getContainerHospitalCases().getFilter().clickFindButton();
        Table table = this.getContainerHospitalCases().getTable();
        int result = table.getCountRowsInTable(true);
        assertThat("Get case by filter", result, is(1));
        table.chooseRowInTable(0);

        this.clickDeleteHospitalButton();
    }

    public void filterByPatient(HospitalData hospitalData)
    {
        getContainerHospitalCases().showFilter();
        getFilter().getPatient().setValue(hospitalData.getPatient());
        getContainerHospitalCases().getFilter().clickFindButton();
    }

    public void refusalHospitalization(HospitalData hospitalData)
    {
        getHospitalCasePage().clickRefusalButton();
        getRefusalModal().assertPatientDataForm(hospitalData);
        getRefusalModal().fillForm(hospitalData);
        getRefusalModal().clickConfirmButton();
    }
}
