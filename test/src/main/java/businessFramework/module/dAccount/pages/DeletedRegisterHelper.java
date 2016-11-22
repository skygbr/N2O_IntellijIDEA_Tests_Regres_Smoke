package businessFramework.module.dAccount.pages;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

public class DeletedRegisterHelper extends Page implements Values
{

    public DeletedRegisterHelper(ApplicationManager app) {
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
    }


    /**
     * @return  Классифаер "Регистр"
     */
    public Classifier getRegisterFilter()
    {
        return getRegisterFilterContainer().getForm().getClassifier("register");
    }


    /* -----------------------------  Таблица с удаленными записями и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Восстановить запись"
     */
    public Button getRestoreAccountButton()
    {
        return getRegistrContainer().getButton("restore");
    }

    /**
     * @return таблицу с удаленными записями
     */
    public Table getRestoreAccountListTable()
    {
        return getRegistrContainer().getTable();
    }
}
