package businessFramework.entities.pharmacy;

/**
 * Created by bulat.garipov on 25.02.2016.
 */
public class TransferActData {
    /** Данные для выбора контекста */
    private String departmentForContext;

    /** Данные для указания заголовка модального окна "Акт переброски" */
    private String expenseInvoiceModalHeader;
    private String expInvBasedOnArrInvModalHeader;

    /** Данные для заполнения полей на форме в модальном окне "Акт переброски" */
    private String numberTA;            // Номер
    private String senderTA;            // Отправитель
    private String recipientTA;         // Получатель
    private String fundingTypeTA;     // Источник финансирования
    private String newFundingTypeTA;  // Новый источник финансирования
    private String productGroupTA;      // Товарная группа
    private String recipientMOLTA;      // МОЛ получателя
    private String commentTA;           // Примечание

    /** Данные для проверки данных в полях на форме в модальном окне "Акт переброски" */
    private String docTypeTA;           // Тип документа
    private String dateTA;              // Дата
    private String chargeOperationTA;   // Операция расхода

    private String arrOperationTA;      // Операция прихода
    private String senderMOLTA;         // МОЛ отправителя

    /** При редактировании акта переброски в модальном окне тип документа не "Накладная" а "Расх.накл"*/
    private String docTypeForEdit;


    /** Данные для редактирования акта переброски. Заполняются при редактировании полей и проверяются при проверке данных в полях */
    private String docTypeTAEdit;
    private String senderTAEdit;
    private String recipientTAEdit;
    private String fundingTypeTAEdit;
    private String newFundingTypeTAEdit;
    private String productGroupTAEdit;
    private String recipientMOLTAEdit;
    private String commentTAEdit;

    /** Данные для редактирования акта переброски ( проверяются при проверке данных в полях, не заполняются при редактировании.*/
    private String numberTAEdit;
    private String dateTAEdit;
    private String senderMOLTAEdit;
    private String arrOperationTAEdit;
    private String chargeOperationTAEdit;

    /** Данные для полей в фильтре. Заполнение */
    private String nameLS_IMN_F;

    /** Данные для полей в фильтре. Проверка*/
    private String store_F;
    private String productGroup_F;
    private String finSource_F;


    /** Данные для полей в модальном окне "Добавление спецификации" */
    private String nameLS_IMN_spec;
    private String creator_spec;
    private String fundingSource_spec;
    private String count_spec;
    private String mneiCount_spec;
    private String mneiCount_specAssert;

    /** Данные для проверки значений в столбцах после добавления спецификации */
    private String sold_spec;
    private String unit_spec;
    private String priceFormatted_spec;
    private String sumFormatted_spec;
    private String price_spec;
    private String sum_spec;
    private String countEdited_spec;
    private String mneiCountEdited_spec;
    private String mneiCountEdited_specAssert;
    private String sumEdited_spec;
    private String sumEdited_spec_formatted;

    public String getDepartmentForContext() {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext) {
        this.departmentForContext = departmentForContext;
    }

    public String getTransferActModalHeader() {
        return expenseInvoiceModalHeader;
    }

    public void setTransferActModalHeader(String expenseInvoiceModalHeader) {
        this.expenseInvoiceModalHeader = expenseInvoiceModalHeader;
    }

    public String getNumberTA() {
        return numberTA;
    }

    public void setNumberTA(String numberTA) {
        this.numberTA = numberTA;
    }

    public String getSenderTA() {
        return senderTA;
    }

    public void setSenderTA(String senderTA) {
        this.senderTA = senderTA;
    }

    public String getRecipientTA() {
        return recipientTA;
    }

    public void setRecipientTA(String recipientTA) {
        this.recipientTA = recipientTA;
    }

    public String getFundingTypeTA() {
        return fundingTypeTA;
    }

    public void setFundingTypeTA(String fundingTypeTA) {
        this.fundingTypeTA = fundingTypeTA;
    }

    public String getProductGroupTA() {
        return productGroupTA;
    }

    public void setProductGroupTA(String productGroupTA) {
        this.productGroupTA = productGroupTA;
    }

    public String getRecipientMOLTA() {
        return recipientMOLTA;
    }

    public void setRecipientMOLTA(String recipientMOLTA) {
        this.recipientMOLTA = recipientMOLTA;
    }

    public String getCommentTA() {
        return commentTA;
    }

    public void setCommentTA(String commentTA) {
        this.commentTA = commentTA;
    }

    public String getDocTypeTA() {
        return docTypeTA;
    }

    public void setDocTypeTA(String docTypeTA) {
        this.docTypeTA = docTypeTA;
    }

    public String getDateTA() {
        return dateTA;
    }

    public void setDateTA(String dateTA) {
        this.dateTA = dateTA;
    }

    public String getChargeOperationTA() {
        return chargeOperationTA;
    }

    public void setChargeOperationTA(String chargeOperationTA) {
        this.chargeOperationTA = chargeOperationTA;
    }

    public String getArrOperationTA() {
        return arrOperationTA;
    }

    public void setArrOperationTA(String arrOperationTA) {
        this.arrOperationTA = arrOperationTA;
    }

    public String getSenderMOLTA() {
        return senderMOLTA;
    }

    public void setSenderMOLTA(String senderMOLTA) {
        this.senderMOLTA = senderMOLTA;
    }

    public String getDocTypeForEdit() {
        return docTypeForEdit;
    }

    public void setDocTypeForEdit(String docTypeForEdit) {
        this.docTypeForEdit = docTypeForEdit;
    }

    public String getDocTypeTAEdit() {
        return docTypeTAEdit;
    }

    public void setDocTypeTAEdit(String docTypeTAEdit) {
        this.docTypeTAEdit = docTypeTAEdit;
    }

    public String getSenderTAEdit() {
        return senderTAEdit;
    }

    public void setSenderTAEdit(String senderTAEdit) {
        this.senderTAEdit = senderTAEdit;
    }

    public String getRecipientTAEdit() {
        return recipientTAEdit;
    }

    public void setRecipientTAEdit(String recipientTAEdit) {
        this.recipientTAEdit = recipientTAEdit;
    }

    public String getFundingTypeTAEdit() {
        return fundingTypeTAEdit;
    }

    public void setFundingTypeTAEdit(String fundingTypeTAEdit) {
        this.fundingTypeTAEdit = fundingTypeTAEdit;
    }

    public String getProductGroupTAEdit() {
        return productGroupTAEdit;
    }

    public void setProductGroupTAEdit(String productGroupTAEdit) {
        this.productGroupTAEdit = productGroupTAEdit;
    }

    public String getRecipientMOLTAEdit() {
        return recipientMOLTAEdit;
    }

    public void setRecipientMOLTAEdit(String recipientMOLTAEdit) {
        this.recipientMOLTAEdit = recipientMOLTAEdit;
    }

    public String getCommentTAEdit() {
        return commentTAEdit;
    }

    public void setCommentTAEdit(String commentTAEdit) {
        this.commentTAEdit = commentTAEdit;
    }

    public String getNumberTAEdit() {
        return numberTAEdit;
    }

    public void setNumberTAEdit(String numberTAEdit) {
        this.numberTAEdit = numberTAEdit;
    }

    public String getDateTAEdit() {
        return dateTAEdit;
    }

    public void setDateTAEdit(String dateTAEdit) {
        this.dateTAEdit = dateTAEdit;
    }

    public String getSenderMOLTAEdit() {
        return senderMOLTAEdit;
    }

    public void setSenderMOLTAEdit(String senderMOLTAEdit) {
        this.senderMOLTAEdit = senderMOLTAEdit;
    }

    public String getArrOperationTAEdit() {
        return arrOperationTAEdit;
    }

    public void setArrOperationTAEdit(String arrOperationTAEdit) {
        this.arrOperationTAEdit = arrOperationTAEdit;
    }

    public String getChargeOperationTAEdit() {
        return chargeOperationTAEdit;
    }

    public void setChargeOperationTAEdit(String chargeOperationTAEdit) {
        this.chargeOperationTAEdit = chargeOperationTAEdit;
    }

    public String getNameLS_IMN_F() {
        return nameLS_IMN_F;
    }

    public void setNameLS_IMN_F(String nameLS_IMN_F) {
        this.nameLS_IMN_F = nameLS_IMN_F;
    }

    public String getStore_F() {
        return store_F;
    }

    public void setStore_F(String store_F) {
        this.store_F = store_F;
    }

    public String getProductGroup_F() {
        return productGroup_F;
    }

    public void setProductGroup_F(String productGroup_F) {
        this.productGroup_F = productGroup_F;
    }

    public String getFinSource_F() {
        return finSource_F;
    }

    public void setFinSource_F(String finSource_F) {
        this.finSource_F = finSource_F;
    }

    public String getNameLS_IMN_spec() {
        return nameLS_IMN_spec;
    }

    public void setNameLS_IMN_spec(String nameLS_IMN_spec) {
        this.nameLS_IMN_spec = nameLS_IMN_spec;
    }

    public String getCreator_spec() {
        return creator_spec;
    }

    public void setCreator_spec(String creator_spec) {
        this.creator_spec = creator_spec;
    }

    public String getFundingSource_spec() {
        return fundingSource_spec;
    }

    public void setFundingSource_spec(String fundingSource_spec) {
        this.fundingSource_spec = fundingSource_spec;
    }

    public String getCount_spec() {
        return count_spec;
    }

    public void setCount_spec(String count_spec) {
        this.count_spec = count_spec;
    }

    public String getMneiCount_spec() {
        return mneiCount_spec;
    }

    public void setMneiCount_spec(String mneiCount_spec) {
        this.mneiCount_spec = mneiCount_spec;
    }

    public String getSold_spec() {
        return sold_spec;
    }

    public void setSold_spec(String sold_spec) {
        this.sold_spec = sold_spec;
    }

    public String getUnit_spec() {
        return unit_spec;
    }

    public void setUnit_spec(String unit_spec) {
        this.unit_spec = unit_spec;
    }

    public String getPriceFormatted_spec() {
        return priceFormatted_spec;
    }

    public void setPriceFormatted_spec(String priceFormatted_spec) {
        this.priceFormatted_spec = priceFormatted_spec;
    }

    public String getSumFormatted_spec() {
        return sumFormatted_spec;
    }

    public void setSumFormatted_spec(String sumFormatted_spec) {
        this.sumFormatted_spec = sumFormatted_spec;
    }

    public String getPrice_spec() {
        return price_spec;
    }

    public void setPrice_spec(String price_spec) {
        this.price_spec = price_spec;
    }

    public String getSum_spec() {
        return sum_spec;
    }

    public void setSum_spec(String sum_spec) {
        this.sum_spec = sum_spec;
    }

    public String getCountEdited_spec() {
        return countEdited_spec;
    }

    public void setCountEdited_spec(String countEdited_spec) {
        this.countEdited_spec = countEdited_spec;
    }

    public String getMneiCountEdited_spec() {
        return mneiCountEdited_spec;
    }

    public void setMneiCountEdited_spec(String mneiCountEdited_spec) {
        this.mneiCountEdited_spec = mneiCountEdited_spec;
    }

    public String getSumEdited_spec() {
        return sumEdited_spec;
    }

    public void setSumEdited_spec(String sumEdited_spec) {
        this.sumEdited_spec = sumEdited_spec;
    }

    public String getSumEdited_spec_formatted() {
        return sumEdited_spec_formatted;
    }

    public void setSumEdited_spec_formatted(String sumEdited_spec_formatted) {
        this.sumEdited_spec_formatted = sumEdited_spec_formatted;
    }

    public String getNewFundingTypeTA() {
        return newFundingTypeTA;
    }

    public void setNewFundingTypeTA(String newFundingTypeTA) {
        this.newFundingTypeTA = newFundingTypeTA;
    }

    public String getNewFundingTypeTAEdit() {
        return newFundingTypeTAEdit;
    }

    public void setNewFundingTypeTAEdit(String newFundingTypeTAEdit) {
        this.newFundingTypeTAEdit = newFundingTypeTAEdit;
    }

    public String getMneiCount_specAssert() {
        return mneiCount_specAssert;
    }

    public void setMneiCount_specAssert(String mneiCount_specAssert) {
        this.mneiCount_specAssert = mneiCount_specAssert;
    }

    public String getMneiCountEdited_specAssert() {
        return mneiCountEdited_specAssert;
    }

    public void setMneiCountEdited_specAssert(String mneiCountEdited_specAssert) {
        this.mneiCountEdited_specAssert = mneiCountEdited_specAssert;
    }
}
