package businessFramework.module.gibddMedicalExamination.pages.Commission;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class CommissionHelper extends Page implements Values
{

    public CommissionHelper(ApplicationManager app)
    {
        super(app);
    }

    // Получение контейнера с деревом слева на странице
    public Container getContainerEventsList()
    {
        return getRegion(LEFT).getContainer("EventsList");
    }

    // Получение контейнера Пациенты с таблицей пациентов справа на странице
    public Container getContainerPatients()
    {
        return getRegion(RIGHT).getContainer("gibddReference");
    }

    // Получение контейнера Пациенты с таблицей пациентов справа на странице
    public Container getContainerPatientsComission()
    {
        return getRegion(RIGHT).getContainer("gibddRefence");
    }

    // Получение дерева из контейнера EventsList
    public Tree getEventsListTree()
    {
        return getContainerEventsList().getTree();
    }

    // Получение таблицы со списком пациентов в контейнере gibddReference
    public Table getPatientsListTable()
    {
        return getContainerPatients().getTable();
    }

    // Получение таблицы со списком пациентов в контейнере gibddRefence
    public Table getPatientsListComissionTable()
    {
        return getContainerPatientsComission().getTable();
    }

    //Получение кнопки "Карточка"
    public Button getDriverCardButton()
    {
        return getContainerPatientsComission().getButton("driverCard");
    }

    //Получение кнопки "Закрыть карту"
    public Button getCloseCardButton()
    {
        return getContainerPatientsComission().getButton("closeCard");
    }

    //Получение кнопки "Удалить пациента"
    public Button getRemovePatientButton()
    {
        return getContainerPatients().getButton("removePatient");
    }
}