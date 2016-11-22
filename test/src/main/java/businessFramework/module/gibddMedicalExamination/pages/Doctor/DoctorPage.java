package businessFramework.module.gibddMedicalExamination.pages.Doctor;


import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import net.framework.autotesting.ApplicationManager;

public class DoctorPage extends DoctorHelper
{

    public DoctorPage(ApplicationManager app)
    {
        super(app);
    }

    public DoctorFilter getFilter()
    {
        return new DoctorFilter(app);
    }

    //Выбор мероприятия
    public void selectEvent(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        getTree().chooseElementByText(gibddMedicalExaminationData.getEventNameDoctor());
    }

    //Фильтрация услуг пациента
    public void filterServices(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        getContainerServicesList().showFilter();
        getFilter().getPatient().setValue(gibddMedicalExaminationData.getFioDriverCard());
        getContainerServicesList().getFilter().clickFindButton();
    }

    //Заполнение выполнения услуги
    public void fillServiceForm(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        int selectedServiceNumber = getServicesListTable().getChosenRowNumber();
        String selectedService = getServicesListTable().getRowColumnIntersectionValue(selectedServiceNumber,"Услуга", true);
        getServiceUpdateButton().click();
        getServiceResource().setValue(gibddMedicalExaminationData.getServicesAndResourcesDoctor().get(selectedService));
        getServiceMainDiagnosis().setValue(gibddMedicalExaminationData.getMainDiagnosisDoctor());
        getServiceDisease().setValue(gibddMedicalExaminationData.getDiseaseDoctor());
        getServiceDate().assertThatDateContainsValue(getCurrentDate());
        getIsValid().radioButtonPress("Годен");
        getServiceConfirmButton().click();
    }

    public void fillAllServices(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        while (getServicesListTable().getCountNextPages()>0) {
            int serviceCount = getServicesListTable().getCountRowsInTable(true);
            for (int i = 0; i < serviceCount; i++) {
                getServicesListTable().chooseRowInTable(0);
                fillServiceForm(gibddMedicalExaminationData);
            }
            getServicesListTable().chooseNextPage();
        }

        int serviceCount = getServicesListTable().getCountRowsInTable(true);
        for (int i = 0; i < serviceCount; i++) {
            getServicesListTable().chooseRowInTable(0);
            fillServiceForm(gibddMedicalExaminationData);
        }
    }
}
