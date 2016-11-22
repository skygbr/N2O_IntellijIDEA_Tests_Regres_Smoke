package businessFramework.module.ambulance.pages.Brigads;

import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает страницу "Бригады: справочники - Бригады"
 */

public class BrigadsPage extends BrigadsHelper
{
    public BrigadsPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие кнопки "Создать"
     */
    public void clickAddBrigadeButton()
    {
        getAddBrigadeButton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickUpdateBrigadeButton()
    {
        getUpdateBrigadeButton().click();
    }

    /**
     * Проверка есть ли в таблице созданная запись
     *
     * @param brigadeName   Значение поля "Бригада"
     * @param brigadeKind   Значение поля "Вид бригады"
     * @param brigadeType   Значение поля "Тип бригады"
     * @param radioCode     Значение поля "Код рации"
     */
    public int checkTableValues(String brigadeName, String brigadeKind, String brigadeType, String radioCode)
    {
         Map<String, String> columnsAndValues = new HashMap<>();

        if ( brigadeName != null)       { columnsAndValues.put(BRIGADE_NAME, brigadeName); }
        if ( brigadeKind != null)       { columnsAndValues.put(BRIGADE_KIND, brigadeKind); }
        if ( brigadeType != null)       { columnsAndValues.put(BRIGADE_TYPE, brigadeType); }
        if ( radioCode != null)         { columnsAndValues.put(RADIO_CODE, radioCode); }

        return getBrigadeTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Удаление всех бригад
     */
    public void deleteAllBrigades()
    {
        int brigadesCount = getBrigadeTable().getCountRowsInTable(true);

        for(int i = 0; i < brigadesCount; i++)
        {
            getBrigadeTable().chooseRowInTable(0);
            clickUpdateBrigadeButton();
            getAddBrigadeModal().deleteBrigade();
            getBrigadeTable().getAlerts().assertSuccessAlertIsPresent();
            getBrigadeTable().assertThatCountOfRowsIs(brigadesCount - i - 1);
        }
    }
}
