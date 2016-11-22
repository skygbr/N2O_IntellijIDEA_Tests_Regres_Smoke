package businessFramework.module.dAccount.modals.dAccount;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;

public class DAccountFrcModal extends DAccountFrcHelper implements Values
{
    public int row = 0;

    public DAccountFrcModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение модального окна Информация о принудительном лечении
     */
    public DAccountFrcRecordModal getDAccountFrcRecordModal() {
        return new DAccountFrcRecordModal();
    }

    /**
     * Нажимает кнопку "Добавить" над таблицей "Информация о принудительном лечении"
     */
    public void clickCreateFrcButton() {
        getCreateFrcButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Информация о принудительном лечении"
     */
    public void clickEditFrcButton() {
        getEditFrcButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" над таблицей "Информация о принудительном лечении"
     */
    public void clickDeleteFrcButton() {
        Button delete = getDeleteFrcButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Получение модального окна Недобровольное освидетельствование
     */
    public DAccountFrcInvolExamModal getDAccountFrcInvolExamModal() {
        return new DAccountFrcInvolExamModal();
    }

    /**
     * Нажимает кнопку "Добавить" над таблицей "Недобровольное освидетельствование"
     */
    public void clickCreateFrcInvolExamButton() {
        getCreateFrcInvolExamButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Недобровольное освидетельствование"
     */
    public void clickEditFrcInvolExamButton() {
        getEditFrcInvolExamButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" над таблицей "Недобровольное освидетельствование"
     */
    public void clickDeleteFrcInvolExamButton() {
        Button delete = getDeleteFrcInvolExamButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void close() {
        getModal().closeModal();
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Информация о принудительном лечении"
     */
    public void checkFrcSuccessMessage() {
        getFrcListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Информация о недобровольном освидетельствовании"
     */
    public void checkFrcInvolExamSuccessMessage() {
        getFrcInvolExamListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет, что в таблице "Информация о принудительном лечении" отобразилась запись с необходимыми значениями
     *
     * @param frcKind значение в столбце "Вид принудительного лечения"
     * @param orderNumber значение в столбце "Номер поставновления суда"
     * @param orderDt значение в стоблце "Дата постановления суда"
     * @param closeDt значение в стоблце "Дата окончания лечения"
     */
    public int checkRecordInFrcTable(String frcKind, String orderNumber, String orderDt, String closeDt) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (orderNumber != null) {
            columnsAndValues.put("Номер поставновления суда", orderNumber);
        }
        if (frcKind != null) {
            columnsAndValues.put("Вид принудительного лечения", frcKind);
        }
        if (orderDt != null) {
            columnsAndValues.put("Дата постановления суда", orderDt);
        }
        if (closeDt != null) {
            columnsAndValues.put("Дата окончания лечения", closeDt);
        }

        row = getFrcListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Проверяет, что в таблице "Информация о недобровольном освидетельствовании" отобразилась запись с необходимыми значениями
     *
     * @param examDt значение в столбце "Дата"
     * @param result значение в столбце "Результат"
     */
    public int checkRecordInFrcInvolExamTable(String examDt, String result) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (examDt != null) {
            columnsAndValues.put("Дата освидетельствования", examDt);
        }
        if (result != null) {
            columnsAndValues.put("Результат", result);
        }
        row = getFrcInvolExamListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }
}
