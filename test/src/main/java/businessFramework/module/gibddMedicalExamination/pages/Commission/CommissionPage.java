package businessFramework.module.gibddMedicalExamination.pages.Commission;


import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.module.gibddMedicalExamination.modals.CloseCard.CloseCardModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;


import java.util.HashMap;
import java.util.Map;

public class CommissionPage extends CommissionHelper
{

    public CommissionPage(ApplicationManager app)
    {
        super(app);
    }

    public CloseCardModal closeCardModal()
    {
        return new CloseCardModal();
    }

    public void clickDriverCardButton()
    {
        Button button = getDriverCardButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickCloseCardButton()
    {
        Button closeCard = getCloseCardButton();
        closeCard.assertIsEnabled();
        closeCard.click();
    }

    public void clickRemovePatientButton()
    {
        Button removePatient = getRemovePatientButton();
        removePatient.assertIsEnabled();
        removePatient.click();
    }

    //Выбор мероприятия
    public void selectEvent(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        getTree().chooseElementByText(gibddMedicalExaminationData.getEventNameDoctor());
    }

    public void selectAndOpenPatientCard(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        getTable().chooseRowInTableByColumnValue("ФИО", gibddMedicalExaminationData.getFioDriverCard());
        clickDriverCardButton();
    }

    public void closeCard()
    {
        clickCloseCardButton();
        closeCardModal().assertAndAccept();
        getContainerPatientsComission().getTable().getAlerts().assertSuccessAlertMessage("Данные сохранены");
        Map<String, String> map = new HashMap<>();
        map.put("Статус", "Закрыта");
        map.put("Причина закрытия", "Выдана, годен:A");
        getPatientsListComissionTable().assertThatRowColumnsIntersectionValueContains(0,map);
    }

    public void removePatient(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        getTable().chooseRowInTableByColumnValue("ФИО", gibddMedicalExaminationData.getFioDriverCard());
        clickRemovePatientButton();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }
}
