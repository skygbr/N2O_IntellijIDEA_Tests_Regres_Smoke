package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов со страницы "Поиск пациента"
 */
public class PatientSearchHelper extends Page implements Values
{
    public PatientSearchHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера, в котором находится компонент выбора пациента
     * @return контейнер, в котором находится компонент выбора пациента
     */
    public Container getMainContainer()
    {
        return getContainer("main");
    }

    /**
     * Получение компонента выбора пациента
     * @return компонент выбора пациента
     */
    public Classifier getPatientSearchComponent()
    {
        return getMainContainer().getFilter().getClassifier("patient");
    }

    /**
     * Таблица со списком результатов найденных данных о пациенте ( после нажатия кнопки "Найти" в компоненте выбора пациента )
     * @return Таблицу со списком результатов найденных данных о пациенте
     */
    public Table getFoundPatientsTable()
    {
        return getMainContainer().getTable();
    }

    /**
     * Получение кнопки "Найти" в контейнере "Поиск пациента"
     * @return кнопку "Найти"
     */
    public Button getFindButton()
    {
        return getMainContainer().getButton(SUBMIT);
    }

    /**
     * Получение кнопки "Создать новую"
     * @return кнопку "Создать новую"
     */
    public Button getCreateNewCardButton()
    {
        return getMainContainer().getButton(CREATE_NEW_CARD);
    }

    /**
     * Получение ссылки на страницу "Добавить пациента" с этой страницы, потому что с этой страницы происходит на нее переход, посредством нажатия кнопки "Создать новую"
     * @return ссылку на страницу "Добавить пациента"
     */
    public AddPatientCardPage getAddPatientCardPage()
    {
        return new AddPatientCardPage(app);
    }

    /**
     * Получение кнопки "Назад"
     * @return кнопку "Назад"
     */
    public Button getBackButton()
    {
        return getButton(BACK);
    }
}
