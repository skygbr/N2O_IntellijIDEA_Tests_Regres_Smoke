package businessFramework.module.phthisiatry.pages.findVrachContainer;

import businessFramework.module.Values;
import businessFramework.module.migrants.pages.AddPatientCardPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Created by bulat.garipov on 01.11.2016.
 */
/**
 * Получение элементов со страницы "Поиска врача"
 */
public class VrachSearchContainerHelper extends Page implements Values
{
    public VrachSearchContainerHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера, в котором находится компонент выбора врача
     * @return контейнер, в котором находится компонент выбора врача
     */
    public Container getMainContainer()
    {
        return getContainer("main");
    }

    /**
     * Получение компонента выбора врача
     * @return компонент выбора врача
     */
    public Classifier getVrachSearchComponent()
    {
        return getMainContainer().getFilter().getClassifier("res");
    }

    /**
     * Таблица со списком результатов найденных данных о враче (после нажатия кнопки "Найти" в компоненте выбора врача )
     * @return Таблицу со списком результатов найденных данных о враче
     */
    public Table getFoundVrachTable()
    {
        return getMainContainer().getTable();
    }

    /**
     * Получение кнопки "Найти" в контейнере "Поиск врача"
     * @return кнопку "Найти"
     */
    public Button getFindButton()
    {
        return getMainContainer().getButton(SUBMIT);
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
