package businessFramework.module.pharmacy.modals.TrustDocument;

/**
 * @author ydolgih
 * @since 20.11.2015
 */

public class TrustDocModal extends TrustDocModalHelper {

    public TrustDocModal() {
        super();
    }
    public void fillFields(String docType, String docNumber, String issueDate, String endDate, String store, String employee) {
        if (docType != null)   getType().setValue(docType);
        if (docNumber != null) getNumber().setValue(docNumber);
        if (issueDate != null) getIssueDate().setValue(issueDate);
        if (endDate != null)   getEndDate().setValue(endDate);
        if (store != null)     getStore().setValue(store);
        if (employee != null)  getEmployee().setValue(employee);
    }

    public void checkFields(String docType, String docNumber, String issueDate, String endDate, String store, String employee) {
        if (docType != null)   getType().assertValue_equals(docType);
        if (docNumber != null) getNumber().assertValue(docNumber);
        if (issueDate != null) getIssueDate().assertValue_equals(issueDate);
        if (endDate != null)   getEndDate().assertValue_equals(endDate);
        if (store != null)     getStore().assertValue_equals(store);
        if (employee != null)  getEmployee().assertValue_equals(employee);
    }

    /**
     * Сохранить довренность
     * */
     public void clickSaveTrustDocumentButton() {
        getSaveButton().click();
    }
}