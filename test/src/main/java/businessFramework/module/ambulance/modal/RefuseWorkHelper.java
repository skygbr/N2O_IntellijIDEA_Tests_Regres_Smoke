package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.Button;

public class RefuseWorkHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public RefuseWorkHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение контейнера
     * @return контейнер модального окна
     */
    public Container getTeamJobContainer()
    {
        return getModal().getContainer("team_job");
    }

    /**
     * Получение поля "Отклонение"
     * @return поле "Отклонение"
     */
    public Classifier getDeviationField()
    {
        return getTeamJobContainer().getForm().getClassifier("job_deviation");
    }

    /**
     * Получение поля "Замена"
     * @return поле "Замена"
     */
    public Classifier getReplacementField()
    {
        return getTeamJobContainer().getForm().getClassifier("replacement");
    }

    public Button getConfirmButton()
    {
        return getTeamJobContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}