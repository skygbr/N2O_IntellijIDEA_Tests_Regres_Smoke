package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

public class ServiceExecutionPage extends ServiceExecutionHelper implements Values {
    public ServiceExecutionPage(ApplicationManager app) {
        super(app);
    }

    /**
     * Проверка значений полей модального окна "Выполнение услуги"
     * @param organisation Значение поля "Организация"
     */
    public void assertFieldsValues(String organisation)
    {
        getOwnerOrganisation().assertValue(organisation);
        getExecutionDate().assertThatDateContainsValue(getCurrentDate());
    }

    /**
     * Выполение услуги и проверка сообщения об успешном сохранении
     */
    public void executeService()
    {
        getMainDiagnosis().setValue(0);
        getDisease().setValue(0);
        getConfirmButton().click();
        getContainerService().getForm().getAlerts().assertSuccessAlertIsPresent();
        closePage();
    }
}