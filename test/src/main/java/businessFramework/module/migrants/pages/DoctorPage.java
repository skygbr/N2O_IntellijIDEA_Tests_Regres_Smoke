package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class DoctorPage extends DoctorHelper implements Values {
    public DoctorPage(ApplicationManager app) {
        super(app);
    }

    /**
     * Выбрать мероприятие "ОИГИЛГ"
     */
    public void chooseEvent(String eventName)
    {
        Tree tree = getEventsListMigrantsRegistratorTree();
        tree.chooseElementByText(eventName);
    }

    /**
     * Выполение услуги и проверка сообщения об успешном сохранении
     */
    public void executeService()
    {
        getUpdateButton().click();
        getResultRadio().radioButtonPress("Отрицательный");
        getResource().setValue(0);
        getConfirmButton().click();
        getContainerService().getForm().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Нажатие на кнопку "Очистить", прием диалогового окна и проверка сообщения об успешном сохранении
     */
    public void clearService()
    {
        Button button = getClearServiceButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
        getContainerService().getForm().getAlerts().assertSuccessAlertIsPresent();
    }
}