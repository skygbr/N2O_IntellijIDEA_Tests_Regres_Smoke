package businessFramework.module.vaccination.pages.vaccineJournal;


import businessFramework.module.Values;
import businessFramework.module.vaccination.modals.individPlan.VaccineModal;
import net.framework.autotesting.ApplicationManager;
import businessFramework.entities.vaccination.IndividPlanData;

public class VacineJournalPage extends VacineJournalHelper implements Values {

    public VacineJournalPage(ApplicationManager app)
    {
        super(app);
    }

    public VacineJournalFilter getFilter()
    {
        return new VacineJournalFilter(app);
    }

    public void filterByPatient(IndividPlanData individPlanData)
    {
        getFilter().getPatient().setValue(individPlanData.getPatient());
        getFilter().getOrg().removeValue();
        getContainerVacineJournal().getFilter().clickFindButton();
    }

    public void filterByPatientDate(IndividPlanData individPlanData)
    {
        getFilter().getPatient().setValue(individPlanData.getPatient());
        getFilter().getInputDate().setBeginDateValue(individPlanData.getBirthDate());
        getFilter().getInputDate().setEndDateValue(individPlanData.getBirthDate());
//        getFilter().getOrg().removeValue();
        getContainerVacineJournal().getFilter().clickFindButton();
    }

    public void assertTableData1(IndividPlanData individPlanData)
    {
        getTable().assertColumnValuesIs("Статус", "Назначено");
        getTable().assertColumnValuesIs("Пациент", individPlanData.getPatient());
    }

    public void assertTableData2(IndividPlanData individPlanData)
    {
        getTable().assertColumnValuesIs("Дата рождения", individPlanData.getBirthDate());
        getTable().assertColumnValuesIs("Дата", individPlanData.getBirthDate());
    }

    public void assertTableData3(IndividPlanData individPlanData)
    {
        getTable().assertColumnValuesIs("Статус", "Выполнено");
      //  getTable().assertColumnValuesIs("Дата", getCurrentDate());
    }

    public VaccineModal getVaccineModal()
    {
        return new VaccineModal();
    }
}
