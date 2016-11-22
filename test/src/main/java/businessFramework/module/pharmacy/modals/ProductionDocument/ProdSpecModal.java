package businessFramework.module.pharmacy.modals.ProductionDocument;

import businessFramework.entities.pharmacy.ProdDocData;
import net.framework.autotesting.ApplicationManager;

/**
 * @author ydolgih
 * @since 13.11.2015
 */
public class ProdSpecModal extends ProdSpecHelper {

    public ProdSpecModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка значений в полях в модальном окне добавления спецификации
     */
    public void checkModalFieldsValues(ProdDocData prodDocData) {
        if (prodDocData.getSpecModif() != null)      getSpecModif().assertValue_equals(prodDocData.getSpecModif());
        if (prodDocData.getSpecProducer() != null)   getProducer().assertValue_equals(prodDocData.getSpecProducer());
        if (prodDocData.getSpecSeries() != null)     getSeries().assertValue(prodDocData.getSpecSeries());
        if (prodDocData.getSpecExpireDate() != null) getExpireDate().assertValue_equals(prodDocData.getSpecExpireDate());
        if (prodDocData.getSpecActBalance() != null) getActualBalanceArr().assertFieldText(prodDocData.getSpecActBalance());
        if (prodDocData.getSpecActBalanceMnei() != null)  getActualBalanceMnei().assertFieldText(prodDocData.getSpecActBalanceMnei());
        if (prodDocData.getSpecQuantity() != null)     getQuantity().assertValue(prodDocData.getSpecQuantity());
        if (prodDocData.getSpecMneiQuantity() != null) getMneiQuantity().assertValue(prodDocData.getSpecMneiQuantity());
        if (prodDocData.getSpecPrice() != null)        getPrice().assertValue(prodDocData.getSpecPrice());
        if (prodDocData.getSpecAmount() != null)       getAmount().assertValue(prodDocData.getSpecAmount());
        if (prodDocData.getSpecPriceUnit() != null)    getPriceUnit().assertValue(prodDocData.getSpecPriceUnit());
        if (prodDocData.getSpecFundSource() != null)   getFundSource().assertValue_equals(prodDocData.getSpecFundSource());
    }

    /**
     * Заполнение значений в полях в модальном окне добавления спецификации
     */
    public void fillModalFields(ProdDocData prodDocData) {
        if (prodDocData.getSpecMneiQuantity() != null) getQuantity().setValue(prodDocData.getSpecMneiQuantity());
    }


    /**
     * Нажимает кнопку "Сохранить" в модальном окне добавления спецификации
     */
    public void clickSaveButton()
    {
        getSaveButton_spec().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getProdSpecModal().closeModal();
    }
}
