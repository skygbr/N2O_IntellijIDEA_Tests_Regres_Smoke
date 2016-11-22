package businessFramework.module.hospital.pages.informationDesk;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;


import java.util.Arrays;
import java.util.List;


public class InformationDeskPage extends InformationDeskHelper implements Values
{
    public InformationDeskPage(ApplicationManager app){
        super(app);
    }

    public InformationDeskFilter getInformationDeskFilter(){
    return new InformationDeskFilter(app);
    }

    public void assertPatients()
    {
        this.getContainerInformationDesk().getTable().assertThatTableRowGreaterThan(1);
    }

    public void filterByPatient(HospitalData hospitalData)
    {
        this.getContainerInformationDesk().showFilter();
        this.getInformationDeskFilter().getPatient().setValue(hospitalData.getPatient());
        this.getContainerInformationDesk().getFilter().clickFindButton();
        List<String> patient = Arrays.asList(hospitalData.getPatient());
        this.getContainerInformationDesk().getTable().assertThatValuePresentsInModalTableWindow(patient,"Пациент");
    }
}
