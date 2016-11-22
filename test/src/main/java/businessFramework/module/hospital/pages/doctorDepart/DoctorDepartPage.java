package businessFramework.module.hospital.pages.doctorDepart;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class DoctorDepartPage extends DoctorDepartHelper implements Values
{
    public DoctorDepartPage(ApplicationManager app)
    {
        super(app);
    }

    public DoctorDepartFilter getFilter()
    {
        return new DoctorDepartFilter(app);
    }

    //Нажатие на кнопку Удалить и принятие диалогового окна
    public void clickDeletePrescriptionButtonAndAcceptDialog() {
        Button button = getDeletePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
    }

    //Фильтрация по ФИО пациента
    public void filterByPatient(HospitalData hospitalData, Boolean isCaseClosed)
    {
        getContainerMedicalHistoryList().showFilter();
        getFilter().getPatient().setValue(hospitalData.getPatient());
        if (isCaseClosed) {
            getFilter().getShowClosedCasesCheckbox().check(true);
        }
        getContainerMedicalHistoryList().getFilter().clickFindButton();
    }
    //Удаление всех лекарственных назначений
    public void deleteAllPredictions(HospitalData hospitalData) {
        filterByPatient(hospitalData, true);
        Table patients = getContainerMedicalHistoryList().getTable();
        for (int i = 0; i < patients.getCountRowsInTable(true); i++) {
            patients.chooseRowInTable(i);
            Table prescriptions = getContainerPrescriptionsList().getTable();
            while (prescriptions.getCountRowsInTable(true) > 0) {
                int size = prescriptions.getCountRowsInTable(true);
                prescriptions.chooseRowInTable(0);
                clickDeletePrescriptionButtonAndAcceptDialog();
                prescriptions = getContainerPrescriptionsList().getTable();
                assertThat("Rows doesn't delete from table", size,
                        not(prescriptions.getCountRowsInTable(true)));
            }
        }
    }
}
