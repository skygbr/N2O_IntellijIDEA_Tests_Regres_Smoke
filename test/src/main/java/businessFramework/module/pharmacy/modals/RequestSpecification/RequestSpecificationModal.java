package businessFramework.module.pharmacy.modals.RequestSpecification;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class RequestSpecificationModal extends RequestSpecificationHelper implements Values {
    public RequestSpecificationModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Заполнение полей модального окна "Спецификация"
     *
     * @param quantity Кол-во
     */
    public void fillSelectedSpecificationModal(String quantity)
    {
        getQuantityField().setValue(quantity);
    }

    /**
     * Проверка значений полей модального окна "Спецификация"
     *
     * @param modification      Наименование ЛС и ИМН
     * @param fundingSource     Финансирование
     * @param quantity          Кол-во
     * @param quantityInMnei    Кол-во в МНЕИ:
     */
    public void assertSelectedSpecificationModalFields (String modification, String fundingSource, String quantity, String quantityInMnei)
    {
        getModificationField().assertValue_equals(modification);
        getModificationField().assertThatComboboxIsDisabled();
        getFundingSourceField().assertValue_equals(fundingSource);
        getFundingSourceField().assertThatComboboxIsDisabled();
        getQuantityField().assertValue(quantity);
        getQuantityInMneiField().assertValue(quantityInMnei);
        getQuantityInMneiField().assertIsDisabled(true);
    }

    /**
     * Проверка задизебленности полей модального окна "Спецификация"
     */
    public void assertSelectedSpecificationModalDisability()
    {
        getModificationField().assertThatComboboxIsDisabled();
        getFundingSourceField().assertThatComboboxIsDisabled();
        getQuantityField().assertIsDisabled(true);
        getQuantityInMneiField().assertIsDisabled(true);
    }

    /**
     * Нажатие кнопки сохранения требования
     */
    public void clickSaveSelectedSpecificationButton()
    {
        Button saveSpecification = getSaveButton();
        saveSpecification.assertIsEnabled();
        saveSpecification.click();
    }
}