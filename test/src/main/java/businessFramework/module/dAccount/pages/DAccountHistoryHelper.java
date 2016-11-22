package businessFramework.module.dAccount.pages;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

public class DAccountHistoryHelper extends Page implements Values
{

    public DAccountHistoryHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получает контейнер "Сведения по д-учёту"
     * @return контейнер "Сведения по д-учёту"
     */
    public Container getDAccountInfoContainer()
    {
        return getContainer("dAccountInfo");
    }

    /**
     * Получает контейнер "Д-группа"
     * @return контейнер "Д-группа"
     */
    public Container getDGroupContainer()
    {
        return getContainer("dGroup");
    }

    /**
     * Получает контейнер "Динамика состояния"
     * @return контейнер "Динамика состояния"
     */
    public Container getStateContainer()
    {
        return getContainer("state");
    }

    /**
     * Получает контейнер "Сведения о госпитализациях"
     * @return контейнер "Сведения о госпитализациях"
     */
    public Container getHospContainer()
    {
        return getContainer("hosp");
    }

    /**
     * Получает контейнер "Отметки о временной нетрудоспособности (для работающих)"
     * @return контейнер "Отметки о временной нетрудоспособности (для работающих)"
     */
    public Container getMarkContainer()
    {
        return getContainer("mark");
    }



    /* -----------------------------  Таблица "Д-группа" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateDGroupButton()
    {
        return getDGroupContainer().getButton("addDgroup");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditDGroupButton()
    {
        return getDGroupContainer().getButton("updateDgroup");
    }

    /**
     * @return таблицу в контейнере "Д-группа"
     */
    public Table getDGroupListTable()
    {
        return getDGroupContainer().getTable();
    }

    /* -----------------------------  Таблица "Динамика состояния" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateRemissionButton()
    {
        return getStateContainer().getButton("addRemission");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditRemissionButton()
    {
        return getStateContainer().getButton("updateRemission");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteRemissionButton()
    {
        return getStateContainer().getButton("deleteRemission");
    }

    /**
     * @return таблицу в контейнере "Динамика состояния"
     */
    public Table getRemissionListTable()
    {
        return getStateContainer().getTable();
    }

    /* -----------------------------  Таблица "Сведения о госпитализациях" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateHospitalButton()
    {
        return getHospContainer().getButton("addHosp");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditHospitalButton()
    {
        return getHospContainer().getButton("updateHosp");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteHospitalButton()
    {
        return getHospContainer().getButton("deleteHosp");
    }

    /**
     * @return таблицу в контейнере "Сведения о госпитализациях"
     */
    public Table getHospitalListTable()
    {
        return getHospContainer().getTable();
    }
}
