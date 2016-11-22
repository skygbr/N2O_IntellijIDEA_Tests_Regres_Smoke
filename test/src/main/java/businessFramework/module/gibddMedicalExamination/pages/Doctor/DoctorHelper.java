package businessFramework.module.gibddMedicalExamination.pages.Doctor;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class DoctorHelper extends Page implements Values
{

    public DoctorHelper(ApplicationManager app)
    {
        super(app);
    }

    // Получение контейнера с деревом слева на странице
    public Container getContainerEventsList()
    {
        return getRegion(LEFT).getContainer("EventsList");
    }

    // Получение контейнера с таблицей Осмотры и услуги посередине страницы
    public Container getContainerServicesList()
    {
        return getRegion("center").getContainer("Services");
    }

    // Получение контейнера Оказание услуги справа на странице
    public Container getContainerService()
    {
        return getRegion(RIGHT).getContainer("Service");
    }

    // Получение контейнера Протокол справа на странице
    public Container getContainerProtocol()
    {
        return getRegion(RIGHT).getContainer("protocol");
    }

    // Получение дерева из контейнера EventsList
    public Tree getEventsListTree()
    {
        return getContainerEventsList().getTree();
    }

    // Получение таблицы со списком пациентов в контейнере Services
    public Table getServicesListTable()
    {
        return getContainerServicesList().getTable();
    }

    //Получение кнопки Редактирования оказания услуги
    public Button getServiceUpdateButton()
    {
        return getContainerService().getButton("update");
    }

    //Получение кнопки Очистки оказания услуги
    public Button getClearServiceButton()
    {
        return getContainerService().getButton("clearService");
    }

    //Получение кнопки Подтверждения оказания услуги
    public Button getServiceConfirmButton()
    {
        return getContainerService().getButton(N2O_CONFIRM_BUTTON);
    }

    //Получение комбобокса "Ресурс"
    public Classifier getServiceResource()
    {
        return getContainerService().getForm().getClassifier("resource");
    }

    //Получение комбобокса "Оновной диагноз"
    public Classifier getServiceMainDiagnosis()
    {
        return getContainerService().getForm().getClassifier("main_diagnosis");
    }

    //Получение комбобокса "Характер заболевания"
    public Classifier getServiceDisease()
    {
        return getContainerService().getForm().getClassifier("disease");
    }

    //Получение даты оказания услуги
    public InputDate getServiceDate()
    {
        return getContainerService().getForm().getInputDate("date");
    }

    //Получение радиобаттона "Категория"
    public Radio getIsValid()
    {
        return getContainerService().getForm().getRadio("is_validA");
    }

}
