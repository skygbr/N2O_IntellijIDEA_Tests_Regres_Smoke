package businessFramework.module.ambulance.pages.Brigads;

import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает страницу "Бригады: справочники - Транспортное средство"
 */

public class TransportPage extends TransportHelper
{
    public TransportPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие кнопки "Добавить"
     */
    public void clickCreateTransportButton()
    {
        getCreateTransportButtton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickEditCreatedTransportButton()
    {
        getEditCreatedTransportButton().click();
    }


    /**
     * Проверка, есть ли в таблице необходимая запись.
     *
     * @param tsNumber      Значение столбца "Гос. рег. знак"
     * @param tsCategory    Значение столбца "Категория ТС"
     * @param tsType        Значение столбца "Тип ТС"
     * @param equipmentKind Значение столбца "Вид оснащения"
     *
     * @return номер строки с найденной записью
     */
    public int checkTransportTableValues(String tsNumber, String tsCategory, String tsType, String equipmentKind)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( tsNumber != null)        { columnsAndValues.put(TS_NUMBER, tsNumber); }
        if ( tsCategory != null)      { columnsAndValues.put(TS_CATEGORY, tsCategory);}
        if ( tsType != null)          { columnsAndValues.put(TS_TYPE, tsType);}
        if ( equipmentKind != null)   { columnsAndValues.put(EQUIPMENT_KIND, equipmentKind);}

        return getTransportTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Фильтрация и удаление всех действующих транспортных средств
     * @param active значения поля фильтра "Действующий"
     */
    public void deleteAllTransports(String active)
    {
        getTransportContainer().showFilter();
        getTransportContainer().getFilter().clickClearButton();
        getTransportContainer().showFilter();
        getFilterActive().selectOption(active);
        getTransportContainer().getFilter().clickFindButton();

        int transportsCount = getTransportTable().getCountRowsInTable(true);

        for(int i = 0; i < transportsCount; i++)
        {
            getTransportTable().chooseRowInTable(0);
            getDeleteTransportButton().click();
            getDialog().clickYes();
            getTransportTable().getAlerts().assertSuccessAlertIsPresent();
            getTable().assertThatCountOfRowsIs(transportsCount - i - 1);
        }
    }

}
