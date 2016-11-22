package businessFramework.module.dAccount.pages;

import businessFramework.module.Values;
import businessFramework.module.dAccount.modals.dAccount.DAccountDGroupModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountHospitalModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountRemissionModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;

public class DAccountHistoryPage extends DAccountHistoryHelper implements Values {
    public DAccountHistoryPage(ApplicationManager app) {
        super(app);
    }

    public int row = 0;

    /**
     * Выбирает таб "Д-группа"
     */
    public void clickDGroupTab() {
        getDGroupContainer().clickContainer();
    }

    /**
     * Выбирает таб "Динамика состояния"
     */
    public void clickRemissionTab() {
        getStateContainer().clickContainer();
    }

    /**
     * Выбирает таб "Сведения о госпитализациях"
     */
    public void clickHospitalTab() {
        getHospContainer().clickContainer();
    }

    /**
     * Нажимает кнопку "Добавить" над таблицей "Д-группа"
     */
    public void clickCreateDGroupButton() {
        getCreateDGroupButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Д-группа"
     */
    public void clickEditDGroupButton() {
        getEditDGroupButton().click();
    }

    /**
     * Нажимает кнопку "Добавить" над таблицей "Сведения о госпитализациях"
     */
    public void clickCreateHospitalButton() {
        getCreateHospitalButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Сведения о госпитализациях"
     */
    public void clickEditHospitalButton() {
        getEditHospitalButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" над таблицей "Сведения о госпитализациях"
     */
    public void clickDeleteHospitalButton() {
        Button delete = getDeleteHospitalButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Нажимает кнопку "Добавить" над таблицей "Динамика состояния"
     */
    public void clickCreateRemissionButton() {
        getCreateRemissionButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Динамика состояния"
     */
    public void clickEditRemissionButton() {
        getEditRemissionButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" над таблицей "Динамика состояния"
     */
    public void clickDeleteRemissionButton() {
        Button delete = getDeleteRemissionButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Получение модального окна создания и редактирования "Д-группа"
     */
    public DAccountDGroupModal getDAccountDGroupModal() {
        return new DAccountDGroupModal();
    }

    /**
     * Получение модального окна создания и редактирования "Динамика состояния"
     */
    public DAccountRemissionModal getDAccountRemissionModal() {
        return new DAccountRemissionModal(app);
    }

    /**
     * Получение модального окна создания и редактирования "Сведения о госпитализациях"
     */
    public DAccountHospitalModal getDAccountHospitalModal() {
        return new DAccountHospitalModal();
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Д-группа"
     */
    public void checkDGroupSuccessMessage() {
        getDGroupListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Динамика состояния"
     */
    public void checkRemissionSuccessMessage() {
        getRemissionListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Сведения о госпитализациях"
     */
    public void checkHospitalSuccessMessage() {
        getHospitalListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет, что в таблице "Д-группа" отобразилась запись с необходимыми значениями
     *
     * @param group  значение в столбце "Группа"
     * @param fromDt значение в столбце "Дата начала лечения"
     * @param amb значение в стоблце "Вид амбулаторной помощи"
     * @param reason      значение в стоблце "Причина прекращения наблюдения"
     */
    public int checkRecordInDGroupTable(String group, String fromDt, String amb, String reason) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (group != null) {
            columnsAndValues.put("Группа", group);
        }
        if (fromDt != null) {
            columnsAndValues.put("Дата начала лечения", fromDt);
        }
        if (amb != null) {
            columnsAndValues.put("Вид амбулаторной помощи", amb);
        }
        if (reason != null) {
            columnsAndValues.put("Причина прекращения наблюдения", reason);
        }

        row = getDGroupListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Проверяет, что в таблице "Динамика состояния" отобразилась запись с необходимыми значениями
     *
     * @param beginDt  значение в столбце "Дата начала ремиссии"
     * @param endDt значение в столбце "Дата окончания ремиссии"
     * @param info значение в стоблце "Информация"
     */
    public int checkRecordInRemissionTable(String beginDt, String endDt, String info) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (beginDt != null) {
            columnsAndValues.put("Дата начала ремиссии", beginDt);
        }
        if (endDt != null) {
            columnsAndValues.put("Дата окончания ремиссии", endDt);
        }
        if (info != null) {
            columnsAndValues.put("Информация", info);
        }

        row = getRemissionListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Проверяет, что в таблице "Сведения о госпитализациях" отобразилась запись с необходимыми значениями
     *
     * @param admissionDt  значение в столбце "Дата поступления"
     * @param outcomeDt значение в столбце "Дата выбытия"
     * @param diagName значение в стоблце "Информация"
     * @param goalName значение в стоблце "Информация"
     */
    public int checkRecordInHospitalTable(String admissionDt, String outcomeDt, String diagName, String goalName) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (admissionDt != null) {
            columnsAndValues.put("Дата поступления", admissionDt);
        }
        if (outcomeDt != null) {
            columnsAndValues.put("Дата выбытия", outcomeDt);
        }
        if (diagName != null) {
            columnsAndValues.put("Основной диагноз", diagName);
        }
        if (goalName != null) {
            columnsAndValues.put("Цель госпитализации", goalName);
        }

        row = getHospitalListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }
}
