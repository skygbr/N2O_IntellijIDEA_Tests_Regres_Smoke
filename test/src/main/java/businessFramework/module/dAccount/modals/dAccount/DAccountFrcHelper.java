package businessFramework.module.dAccount.modals.dAccount;


import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

public class DAccountFrcHelper extends Page implements Values
{

    public DAccountFrcHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getFrcContainer()
    {
        return getModal().getContainer("frc");
    }

    public Container getFrcInvolExamContainer()
    {
        return getModal().getContainer("involExam");
    }


 /* -----------------------------  Таблица "Информация о принудительном лечении" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateFrcButton()
    {
        return getFrcContainer().getButton("addFRC");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditFrcButton()
    {
        return getFrcContainer().getButton("updateFRC");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteFrcButton()
    {
        return getFrcContainer().getButton("deleteFRC");
    }

    /**
     * @return таблицу в контейнере "Информация о принудительном лечении"
     */
    public Table getFrcListTable()
    {
        return getFrcContainer().getTable();
    }

    /* -----------------------------  Таблица "Недобровольное освидетельствование" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateFrcInvolExamButton()
    {
        return getFrcInvolExamContainer().getButton("addInvolExam");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditFrcInvolExamButton()
    {
        return getFrcInvolExamContainer().getButton("updateInvolExam");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteFrcInvolExamButton()
    {
        return getFrcInvolExamContainer().getButton("deleteInvolExam");
    }

    /**
     * @return таблицу в контейнере "Недобровольное освидетельствование"
     */
    public Table getFrcInvolExamListTable()
    {
        return getFrcInvolExamContainer().getTable();
    }
}
