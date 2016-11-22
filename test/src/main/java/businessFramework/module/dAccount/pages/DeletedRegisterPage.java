package businessFramework.module.dAccount.pages;

import businessFramework.module.Values;
import businessFramework.module.dAccount.modals.dAccount.DAccountEditModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountModal;
import businessFramework.module.dAccount.modals.dAccount.RemoveDAccountModal;
import businessFramework.module.dAccount.modals.dAccount.TakeOffPatientModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DeletedRegisterPage extends DeletedRegisterHelper implements Values {
    public DeletedRegisterPage(ApplicationManager app) {
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
     * Нажимает кнопку "Восстановить запись"
     */
    public void clickRestoreAccountButton() {
        Button restore = getRestoreAccountButton();
        restore.assertIsEnabled();
        restore.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Открывает фильтр в контейнере "Регистр"
     */
    public void openFilterForAccount() {
        getRegistrContainer().showFilter();
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере с удаленными записями
     */
    public void checkSuccessMessage() {
        getRestoreAccountListTable().getAlerts().assertSuccessAlertIsPresent();
    }

}
