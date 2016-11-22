package businessFramework.module.dAccount.pages;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

public class RegisterHelper extends Page implements Values
{

    public RegisterHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получает контейнер "Регистр"
     * @return контейнер "Регистр"
     */
    public Container getRegistrContainer()
    {
        return getContainer("registr");
    }

    /**
     * Получает контейнер "Фильтр Регистр"
     * @return контейнер "Фильтр Регистр"
     */
    public Container getRegisterFilterContainer()
    {
        return getContainer("registerFilter");
    }

    /**
     * Получает фильтр в контейнере "Регистр"
     * @return фильтр в контейнере "Регистр"
     */
    public Filter getFilterForRegister()
    {
        return getRegistrContainer().getFilter();
    }

    /**
     * @return Поле "Пациент" в фильтре
     */
    public Classifier getFilterPatient()
    {
        return getFilterForRegister().getClassifier("patient");
    }

    /**
     * Задает значение в поле "Пациент" в фильтре
     */
    public void setFilterPatient(String value)
    {
        getFilterForRegister().getClassifier("patient").setValue(value);
        getFilterForRegister().clickFindButton();
    }


    /**
     * @return  Классифаер "Регистр"
     */
    public Classifier getRegisterFilter()
    {
        return getRegisterFilterContainer().getForm().getClassifier("register");
    }


    /* -----------------------------  Таблица "Регистр" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateAccountButton()
    {
        return getRegistrContainer().getButton("addPatient");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditAccountButton()
    {
        return getRegistrContainer().getButton("updateAccount");
    }

    /**
     * @return кнопку "История заболевания"
     */
    public Button getAccountHistoryButton()
    {
        return getRegistrContainer().getButton("dAccountShow");
    }

    /**
     * @return кнопку "Снять с учета"
     */
    public Button getTakeOffPatientButton()
    {
        return getRegistrContainer().getButton("takeOffPatient");
    }

    /**
     * @return кнопку "Изменить информацию о снятии"
     */
    public Button getUpdateTakeOffPatientButton()
    {
        return getRegistrContainer().getButton("updateTakeOffPatient");
    }


    /**
     * @return кнопку "Удалить запись"
     */
    public Button getDeleteAccountButton()
    {
        return getRegistrContainer().getButton("remove");
    }

    /**
     * @return таблицу в контейнере "Регистр"
     */
    public Table getAccountListTable()
    {
        return getRegistrContainer().getTable();
    }
}
