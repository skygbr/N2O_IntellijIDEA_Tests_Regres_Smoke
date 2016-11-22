package businessFramework.module.pharmacy.modals.ProductionDocument;

import businessFramework.entities.pharmacy.ProdDocData;
import net.framework.autotesting.ApplicationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ydolgih
 * @since 12.11.2015
 */
public class ProdDocModal extends ProdDocModalHelper {

    public ProdDocModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveButton()
    {
        getSaveButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getProdDocModal().closeModal();
    }


    public void checkFields(ProdDocData prodDocData)
    {
        if ( prodDocData.getDocType() != null )         getDocTypeField().assertValue_equals(prodDocData.getDocType());
        if ( prodDocData.getDocDate() != null )         getDocDateField().assertValue_equals(prodDocData.getDocDate());
        if ( prodDocData.getDocNumber() != null )       getDocNumberField().assertValue(prodDocData.getDocNumber());
        if ( prodDocData.getBaseDocDate() != null )     getBaseDateField().assertValue_equals(prodDocData.getBaseDocDate());
        if ( prodDocData.getBaseDocType() != null )     getBaseDocTypeField().assertValue_equals(prodDocData.getBaseDocType());
        if ( prodDocData.getBaseDocNumber() != null )   getBaseDocNumberField().assertValue(prodDocData.getBaseDocNumber());
        if ( prodDocData.getStore() != null )           getStoreField().assertValue_equals(prodDocData.getStore());
        if ( prodDocData.getFundSource()!=null )        getFundSourceField().assertValueIs(prodDocData.getFundSource());
        if ( prodDocData.getArrivalOperation()!=null)   getArrivalOperationField().assertValue_equals(prodDocData.getArrivalOperation());
        if ( prodDocData.getExpOperation()!=null)       getExpOperationField().assertValue_equals(prodDocData.getExpOperation());
        if ( prodDocData.getFormulaDoc() != null )      getFormulaDocField().assertValue_equals(prodDocData.getFormulaDoc());
        if ( prodDocData.getModif() != null)            getModifField().assertValue_equals(prodDocData.getModif());
        if ( prodDocData.getMneiQuantity() != null)     getMneiQuantity().assertValue(prodDocData.getMneiQuantity());
        if ( prodDocData.getQuantity() != null)         getQuantity().assertValue(prodDocData.getQuantity());
        if ( prodDocData.getPrice() != null)            getPriceField().assertValue(prodDocData.getPrice());
        if ( prodDocData.getAmount() != null)           getAmountField().assertValue(prodDocData.getAmount());
        if ( prodDocData.getSeries() != null)           getSeriesField().assertValue(prodDocData.getSeries());
        if ( prodDocData.getExpireDate()!=null)         getExpireDateField().assertValue_equals(prodDocData.getExpireDate());
        if ( prodDocData.getCertificate()!=null)        getCertificatefield().assertValue(prodDocData.getCertificate());
        if ( prodDocData.getProductionDate()!=null)     getProdDateField().assertValue_equals(prodDocData.getProductionDate());
        if ( prodDocData.getNote()!=null)               getNoteField().assertValue(prodDocData.getNote());
    }

    public void fillFields(ProdDocData prodDocData)
    {
        if ( prodDocData.getDocDate() != null )         getDocDateField().setValue(prodDocData.getDocDate());
        if ( prodDocData.getDocNumber() != null )       getDocNumberField().setValue(prodDocData.getDocNumber());
        if ( prodDocData.getBaseDocDate() != null )     getBaseDateField().setValue(prodDocData.getBaseDocDate());
        if ( prodDocData.getBaseDocType() != null )     getBaseDocTypeField().setValue(prodDocData.getBaseDocType());
        if ( prodDocData.getBaseDocNumber() != null )   getBaseDocNumberField().setValue(prodDocData.getBaseDocNumber());
        if ( prodDocData.getStore() != null )           getStoreField().setValue(prodDocData.getStore());
        if (prodDocData.getFundSource() != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(prodDocData.getFundSource());
            getFundSourceField().chooseNodeWithOpenClose(fundingList, true);
        }
        if ( prodDocData.getFormulaDoc() != null )      getFormulaDocField().setValue(prodDocData.getFormulaDoc());
        if ( prodDocData.getMneiQuantity() != null)     getMneiQuantity().setValue(prodDocData.getMneiQuantity());
        if ( prodDocData.getSeries() != null)           getSeriesField().setValue(prodDocData.getSeries());
        if ( prodDocData.getExpireDate()!=null)         getExpireDateField().setValue(prodDocData.getExpireDate());
        if ( prodDocData.getCertificate()!=null)        getCertificatefield().setValue(prodDocData.getCertificate());
        if ( prodDocData.getProductionDate()!=null)     getProdDateField().setValue(prodDocData.getProductionDate());
        if ( prodDocData.getNote()!=null)               getNoteField().setValue(prodDocData.getNote());
    }

    public void checkFilledFields(ProdDocData prodDocData) {
        if (prodDocData.getDocType() != null) getDocTypeField().assertValue_equals(prodDocData.getDocType());
        if (prodDocData.getArrivalOperation() != null)
            getArrivalOperationField().assertValue_equals(prodDocData.getArrivalOperation());
        if (prodDocData.getExpOperation() != null)
            getExpOperationField().assertValue_equals(prodDocData.getExpOperation());
        if (prodDocData.getDocDate() != null) getDocDateField().assertValue_equals(getCurrentDate());
    }

}
