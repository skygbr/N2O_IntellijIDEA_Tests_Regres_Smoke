package businessFramework.module.dAccount.pages;

import businessFramework.module.Values;
import businessFramework.module.dAccount.modals.dAccount.DAccountEditModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountFrcModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountModal;
import businessFramework.module.dAccount.modals.dAccount.RemoveDAccountModal;
import businessFramework.module.dAccount.modals.dAccount.TakeOffPatientModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class RegisterPage extends RegisterHelper implements Values {
    public RegisterPage(ApplicationManager app) {
        super(app);
    }

    public int row = 0;

    /**
     * Задает значение в фильтре "Регистр"
     */
    public void setRegisterFilter(String registerFilter) {
        getRegisterFilter().setValue(registerFilter);
    }

    /**
     * Нажимает кнопку "Поставить на учет" над таблицей "Регистр"
     */
    public void clickCreateAccountButton() {
        getCreateAccountButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Регистр"
     */
    public void clickEditAccountButton() {
        getEditAccountButton().click();
    }

    /**
     * Нажимает кнопку "История заболевания" над таблицей "Регистр"
     */
    public void clickAccountHistoryButton() {
        getAccountHistoryButton().click();
    }

    /**
     * Нажимает кнопку "Принудительное лечение" над таблицей "Регистр"
     */
    public void clickFrcButton() {
        getRegistrContainer().clickDropdown("Информация по учету", "Принудительное лечение", "frc");
    }

    /**
     * Нажимает кнопку "Снять с учета" над таблицей "Регистр"
     */
    public void clickTakeOffPatientButton() {
        getTakeOffPatientButton().click();
    }

    /**
     * Нажимает кнопку "Изменить информацию а снятии" над таблицей "Регистр"
     */
    public void clickUpdateTakeOffPatientButton() {
        getUpdateTakeOffPatientButton().click();
    }

    /**
     * Нажимает кнопку "Удалить запись" над таблицей "Регистр"
     */
    public void clickDeleteAccountButton() {
        getDeleteAccountButton().click();
    }

    /**
     * Открывает фильтр в контейнере "Регистр"
     */
    public void openFilterForAccount() {
        getRegistrContainer().showFilter();
    }

    /**
     * Получение модального окна "Постановка на учёт"
     */
    public DAccountModal getDAccountCreateModal() {
        return new DAccountModal(app);
    }

    /**
     * Получение модального окна редактирования карты д-учёта
     */
    public DAccountEditModal getDAccountEditModal() {
        return new DAccountEditModal();
    }

    /**
     * Получение модального окна Информация о принудительном лечении
     */
    public DAccountFrcModal getDAccountFrcModal() {
        return new DAccountFrcModal(app);
    }

    /**
     * Получение модального окна снятия с учёта
     */
    public TakeOffPatientModal getTakeOffPatientModal() {
        return new TakeOffPatientModal();
    }

    /**
     * Получение модального окна удаление карты д-учёта
     */
    public RemoveDAccountModal getRemoveDAccountModal() {
        return new RemoveDAccountModal(app);
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Регистр"
     */
    public void checkSuccessMessage() {
        getAccountListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет, что в таблице "Регистр" отобразилась запись с необходимыми значениями
     *
     * @param patientValue    значение в столбце "ФИО"
     * @param createDateValue значение в столбце "Дата постановки на учет"
     * @param diagnosisValue  значение в стоблце "Основной диагноз"
     * @param groupValue      значение в стоблце "Группа Д-учета"
     */
    public int checkRecordInAccountTable(String patientValue, String createDateValue, String diagnosisValue,
                                         String groupValue) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (patientValue != null) {
            columnsAndValues.put("ФИО", patientValue);
        }
        if (createDateValue != null) {
            columnsAndValues.put("Дата постановки на учет", createDateValue);
        }
        if (diagnosisValue != null) {
            columnsAndValues.put("Основной диагноз", diagnosisValue);
        }
        if (groupValue != null) {
            columnsAndValues.put("Группа Д-учета", groupValue);
        }

        row = getAccountListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Проверяет, что в таблице "Регистр" отобразилась запись с необходимыми значениями
     *
     * @param patientValue    значение в столбце "ФИО"
     * @param takeOffDate      значение в стоблце "Дата снятия с учета"
     * @param takeOffReason      значение в стоблце "Причина снятия с учёта"
     */
    public int checkUnregInfoInAccountTable(String patientValue, String takeOffDate, String takeOffReason) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (patientValue != null) {
            columnsAndValues.put("ФИО", patientValue);
        }
        if (takeOffDate != null) {
            columnsAndValues.put("Дата снятия с учета", takeOffDate);
        }
        if (takeOffReason != null) {
            columnsAndValues.put("Причина снятия с учёта", takeOffReason);
        }
        row = getAccountListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }
}
