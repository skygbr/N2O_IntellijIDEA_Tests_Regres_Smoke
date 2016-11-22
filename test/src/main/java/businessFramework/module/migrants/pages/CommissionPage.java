package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

import java.util.HashMap;
import java.util.Map;

public class CommissionPage extends CommissionHelper implements Values {

    public CommissionPage(ApplicationManager app) {
        super(app);
    }

    /**
     * Выбрать мероприятие "ОИГИЛГ"
     */
    public void chooseEvent(String eventName)
    {
        Tree tree = getEventsListMigrantsCommissionTree();
        tree.chooseElementByText(eventName);
    }

    /**
     * Проверка значений в найденной записи в таблице "Освидетельствование ИГ и ЛГ" в контейнере migrantList
     *
     * @param fio       значение "ФИО"
     * @param birthDate значение "Дата рождения"
     *
     * @return номер строки, если найдена такая запись
     */
    public int checkPatientsTableValues(String fio, String birthDate, String status, String reason)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (fio != null)        { columnsAndValues.put(PATIENT_FIO, fio); }
        if (birthDate != null)  { columnsAndValues.put(PATIENT_BIRTHDATE, birthDate); }
        if (status != null)     { columnsAndValues.put(PATIENT_STATUS, status); }
        if (reason != null)     { columnsAndValues.put("Причина закрытия", reason); }

        return getMigrantsCommissionTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Нажатие кнопки "Карточка"
     */
    public void clickCardButton()
    {
        Button button = getCardButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Нажатие кнопки "Удалить пациента"
     */
    public void clickDeletePatientButton()
    {
        Button button = getDeletePatientButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
    }

}