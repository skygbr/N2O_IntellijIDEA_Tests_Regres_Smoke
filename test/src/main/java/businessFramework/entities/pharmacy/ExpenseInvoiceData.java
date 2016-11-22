package businessFramework.entities.pharmacy;


public class ExpenseInvoiceData
{
    /** Данные для выбора контекста */
    private String departmentForContext;

    /** Данные для указания заголовка модального окна "Расходная накладная" */
    private String expenseInvoiceModalHeader;
    private String expInvBasedOnArrInvModalHeader;

    /** Данные для заполнения полей на форме в модальном окне "Расходная накладная" */
    private String numberEI;       // Номер
    private String senderEI;       // Отправитель
    private String recipientEI;    // Получатель
    private String financingTypeEI;// Источник финансирования
    private String productGroupEI; // Товарная группа
    private String recipientMOLEI; // МОЛ получателя
    private String commentEI;      // Примечание

    /** Данные для проверки данных в полях на форме в модальном окне "Расходная накладная" */
    private String docTypeEI;           // Тип документа
    private String dateEI;              // Дата
    private String chargeOperationEI;   // Операция расхода
    private String arrOperationEI;      // Операция прихода
    private String senderMOLEI;         // МОЛ отправителя
    private String requireEI;           // Требование
    private String trustEI;             // Доверенность


   /** Данные для добавления довренности с формы расходной накладной */

    private String trustDocType;
    private String trustDocNumber;
    private String trustDocIssueDate;
    private String trustDocEndDate;
    private String trustDocStore;
    private String trustDocEmpPos;

    /** При редактировании расходной накладной в модальном окне тип документа не "Накладная" а "Расх.накл"*/
    private String docTypeForEdit;


    /** Данные для редактирования расходной накладной. Заполняются при редактировании полей и проверяются при проверке данных в полях */
    private String docTypeEIEdit;
    private String senderEIEdit;
    private String recipientEIEdit;
    private String financingTypeEIEdit;
    private String productGroupEIEdit;
    private String recipientMOLEIEdit;
    private String commentEIEdit;

    /** Данные для редактирования расходной накладной ( проверяются при проверке данных в полях, не заполняются при редактировании.*/
    private String numberEIEdit;
    private String dateEIEdit;
    private String requireEIEdit;
    private String trustEIEdit;
    private String senderMOLEIEdit;
    private String arrOperationEIEdit;
    private String chargeOperationEIEdit;

    /** Данные для полей в фильтре. Заполнение */
    private String nameLS_IMN_F;

    /** Данные для полей в фильтре. Проверка*/
    private String store_F;
    private String productGroup_F;
    private String finSource_F;


    /** Данные для полей в модальном окне "Добавление спецификации" */
    private String nameLS_IMN_spec;
    private String creator_spec;
    private String financingSource_spec;
    private String count_spec;
    private String mneiCount_spec;
    private String mneiCount_specAssert;

    /** Данные для проверки значений в столбцах после добавления спецификации */
    private String sold_spec;
    private String commonSold_spec;
    private String unit_spec;
    private String priceFormatted_spec;
    private String sumFormatted_spec;
    private String commonSumFormatted_spec;
    private String price_spec;
    private String sum_spec;
    private String countEdited_spec;
    private String mneiCountEdited_spec;
    private String mneiCountEdited_specAssert;
    private String sumEdited_spec;
    private String sumEdited_spec_formatted;

    public String getSumEdited_spec()
    {
        return sumEdited_spec;
    }

    public void setSumEdited_spec(String sumEdited_spec)
    {
        this.sumEdited_spec = sumEdited_spec;
    }

    public String getMneiCountEdited_spec()
    {
        return mneiCountEdited_spec;
    }

    public void setMneiCountEdited_spec(String mneiCountEdited_spec)
    {
        this.mneiCountEdited_spec = mneiCountEdited_spec;
    }

    public String getCountEdited_spec()
    {
        return countEdited_spec;
    }

    public void setCountEdited_spec(String countEdited_spec)
    {
        this.countEdited_spec = countEdited_spec;
    }

    public String getPrice_spec()
    {
        return price_spec;
    }

    public void setPrice_spec(String price_spec)
    {
        this.price_spec = price_spec;
    }

    public String getSum_spec()
    {
        return sum_spec;
    }

    public void setSum_spec(String sum_spec)
    {
        this.sum_spec = sum_spec;
    }

    public String getSold_spec()
    {
        return sold_spec;
    }

    public void setSold_spec(String sold_spec)
    {
        this.sold_spec = sold_spec;
    }


    public String getCommonSold_spec() {
        return commonSold_spec;
    }

    public void setCommonSold_spec(String commonSold_spec) {
        this.commonSold_spec = commonSold_spec;
    }

    public String getUnit_spec()
    {
        return unit_spec;
    }

    public void setUnit_spec(String unit_spec)
    {
        this.unit_spec = unit_spec;
    }

    public String getPriceFormatted_spec()
    {
        return priceFormatted_spec;
    }

    public void setPriceFormatted_spec(String priceFormatted_spec)
    {
        this.priceFormatted_spec = priceFormatted_spec;
    }

    public String getSumFormatted_spec()
    {
        return sumFormatted_spec;
    }

    public void setSumFormatted_spec(String sumFormatted_spec)
    {
        this.sumFormatted_spec = sumFormatted_spec;
    }

    public String getCommonSumFormatted_spec() {
        return commonSumFormatted_spec;
    }

    public void setCommonSumFormatted_spec(String commonSumFormatted_spec) {
        this.commonSumFormatted_spec = commonSumFormatted_spec;
    }

    public String getMneiCount_spec()
    {
        return mneiCount_spec;
    }

    public void setMneiCount_spec(String mneiCount_spec)
    {
        this.mneiCount_spec = mneiCount_spec;
    }

    public String getCount_spec()
    {
        return count_spec;
    }

    public void setCount_spec(String count_spec)
    {
        this.count_spec = count_spec;
    }

    public String getNameLS_IMN_spec()
    {
        return nameLS_IMN_spec;
    }

    public void setNameLS_IMN_spec(String nameLS_IMN_spec)
    {
        this.nameLS_IMN_spec = nameLS_IMN_spec;
    }

    public String getCreator_spec()
    {
        return creator_spec;
    }

    public void setCreator_spec(String creator_spec)
    {
        this.creator_spec = creator_spec;
    }

    public String getFinancingSource_spec()
    {
        return financingSource_spec;
    }

    public void setFinancingSource_spec(String financingSource_spec)
    {
        this.financingSource_spec = financingSource_spec;
    }

    public String getNameLS_IMN_F()
    {
        return nameLS_IMN_F;
    }

    public void setNameLS_IMN_F(String nameLS_IMN_F)
    {
        this.nameLS_IMN_F = nameLS_IMN_F;
    }

    public String getStore_F()
    {
        return store_F;
    }

    public void setStore_F(String store_F)
    {
        this.store_F = store_F;
    }

    public String getProductGroup_F()
    {
        return productGroup_F;
    }

    public void setProductGroup_F(String productGroup_F)
    {
        this.productGroup_F = productGroup_F;
    }

    public String getFinSource_F()
    {
        return finSource_F;
    }

    public void setFinSource_F(String finSource_F)
    {
        this.finSource_F = finSource_F;
    }

    public String getDocTypeEIEdit()
    {
        return docTypeEIEdit;
    }

    public void setDocTypeEIEdit(String docTypeEIEdit)
    {
        this.docTypeEIEdit = docTypeEIEdit;
    }

    public String getSenderEIEdit()
    {
        return senderEIEdit;
    }

    public void setSenderEIEdit(String senderEIEdit)
    {
        this.senderEIEdit = senderEIEdit;
    }

    public String getRecipientEIEdit()
    {
        return recipientEIEdit;
    }

    public void setRecipientEIEdit(String recipientEIEdit)
    {
        this.recipientEIEdit = recipientEIEdit;
    }

    public String getFinancingTypeEIEdit()
    {
        return financingTypeEIEdit;
    }

    public void setFinancingTypeEIEdit(String financingTypeEIEdit)
    {
        this.financingTypeEIEdit = financingTypeEIEdit;
    }

    public String getProductGroupEIEdit()
    {
        return productGroupEIEdit;
    }

    public void setProductGroupEIEdit(String productGroupEIEdit)
    {
        this.productGroupEIEdit = productGroupEIEdit;
    }

    public String getRecipientMOLEIEdit()
    {
        return recipientMOLEIEdit;
    }

    public void setRecipientMOLEIEdit(String recipientMOLEIEdit)
    {
        this.recipientMOLEIEdit = recipientMOLEIEdit;
    }

    public String getCommentEIEdit()
    {
        return commentEIEdit;
    }

    public void setCommentEIEdit(String commentEIEdit)
    {
        this.commentEIEdit = commentEIEdit;
    }

    public String getNumberEIEdit()
    {
        return numberEIEdit;
    }

    public void setNumberEIEdit(String numberEIEdit)
    {
        this.numberEIEdit = numberEIEdit;
    }

    public String getDateEIEdit()
    {
        return dateEIEdit;
    }

    public void setDateEIEdit(String dateEIEdit)
    {
        this.dateEIEdit = dateEIEdit;
    }

    public String getRequireEIEdit()
    {
        return requireEIEdit;
    }

    public void setRequireEIEdit(String requireEIEdit)
    {
        this.requireEIEdit = requireEIEdit;
    }

    public String getTrustEIEdit()
    {
        return trustEIEdit;
    }

    public void setTrustEIEdit(String trustEIEdit)
    {
        this.trustEIEdit = trustEIEdit;
    }

    public String getSenderMOLEIEdit()
    {
        return senderMOLEIEdit;
    }

    public void setSenderMOLEIEdit(String senderMOLEIEdit)
    {
        this.senderMOLEIEdit = senderMOLEIEdit;
    }

    public String getArrOperationEIEdit()
    {
        return arrOperationEIEdit;
    }

    public void setArrOperationEIEdit(String arrOperationEIEdit)
    {
        this.arrOperationEIEdit = arrOperationEIEdit;
    }

    public String getChargeOperationEIEdit()
    {
        return chargeOperationEIEdit;
    }

    public void setChargeOperationEIEdit(String chargeOperationEIEdit)
    {
        this.chargeOperationEIEdit = chargeOperationEIEdit;
    }

    public String getDocTypeForEdit()
    {
        return docTypeForEdit;
    }

    public void setDocTypeForEdit(String docTypeForEdit)
    {
        this.docTypeForEdit = docTypeForEdit;
    }

    public String getRequireEI()
    {
        return requireEI;
    }

    public void setRequireEI(String requireEI)
    {
        this.requireEI = requireEI;
    }

    public String getTrustEI()
    {
        return trustEI;
    }

    public void setTrustEI(String trustEI)
    {
        this.trustEI = trustEI;
    }

    public String getCommentEI()
    {
        return commentEI;
    }

    public void setCommentEI(String commentEI)
    {
        this.commentEI = commentEI;
    }

    public String getDocTypeEI()
    {
        return docTypeEI;
    }

    public void setDocTypeEI(String docTypeEI)
    {
        this.docTypeEI = docTypeEI;
    }

    public String getDateEI()
    {
        return dateEI;
    }

    public void setDateEI(String dateEI)
    {
        this.dateEI = dateEI;
    }

    public String getChargeOperationEI()
    {
        return chargeOperationEI;
    }

    public void setChargeOperationEI(String chargeOperationEI)
    {
        this.chargeOperationEI = chargeOperationEI;
    }

    public String getArrOperationEI()
    {
        return arrOperationEI;
    }

    public void setArrOperationEI(String arrOperationEI)
    {
        this.arrOperationEI = arrOperationEI;
    }

    public String getNumberEI()
    {
        return numberEI;
    }

    public void setNumberEI(String numberEI)
    {
        this.numberEI = numberEI;
    }

    public String getSenderEI()
    {
        return senderEI;
    }

    public void setSenderEI(String senderEI)
    {
        this.senderEI = senderEI;
    }

    public String getRecipientEI()
    {
        return recipientEI;
    }

    public void setRecipientEI(String recipientEI)
    {
        this.recipientEI = recipientEI;
    }

    public String getFinancingTypeEI()
    {
        return financingTypeEI;
    }

    public void setFinancingTypeEI(String financingTypeEI)
    {
        this.financingTypeEI = financingTypeEI;
    }

    public String getProductGroupEI()
    {
        return productGroupEI;
    }

    public void setProductGroupEI(String productGroupEI)
    {
        this.productGroupEI = productGroupEI;
    }

    public String getSenderMOLEI()
    {
        return senderMOLEI;
    }

    public void setSenderMOLEI(String senderMOLEI)
    {
        this.senderMOLEI = senderMOLEI;
    }

    public String getRecipientMOLEI()
    {
        return recipientMOLEI;
    }

    public void setRecipientMOLEI(String recipientMOLEI)
    {
        this.recipientMOLEI = recipientMOLEI;
    }

    public String getExpenseInvoiceModalHeader()
    {
        return expenseInvoiceModalHeader;
    }

    public void setExpenseInvoiceModalHeader(String expenseInvoiceModalHeader)
    {
        this.expenseInvoiceModalHeader = expenseInvoiceModalHeader;
    }

    public String getDepartmentForContext()
    {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext)
    {
        this.departmentForContext = departmentForContext;
    }

    public String getExpInvBasedOnArrInvModalHeader() {
        return expInvBasedOnArrInvModalHeader;
    }

    public void setExpInvBasedOnArrInvModalHeader(String expInvBasedOnArrInvModalHeader) {
        this.expInvBasedOnArrInvModalHeader = expInvBasedOnArrInvModalHeader;
    }

    public String getSumEdited_spec_formatted() {
        return sumEdited_spec_formatted;
    }

    public void setSumEdited_spec_formatted(String sumEdited_spec_formatted) {
        this.sumEdited_spec_formatted = sumEdited_spec_formatted;
    }

    public String getTrustDocType() {
        return trustDocType;
    }

    public void setTrustDocType(String trustDocType) {
        this.trustDocType = trustDocType;
    }

    public String getTrustDocNumber() {
        return trustDocNumber;
    }

    public void setTrustDocNumber(String trustDocNumber) {
        this.trustDocNumber = trustDocNumber;
    }

    public String getTrustDocIssueDate() {
        return trustDocIssueDate;
    }

    public void setTrustDocIssueDate(String trustDocIssueDate) {
        this.trustDocIssueDate = trustDocIssueDate;
    }

    public String getTrustDocEndDate() {
        return trustDocEndDate;
    }

    public void setTrustDocEndDate(String trustDocEndDate) {
        this.trustDocEndDate = trustDocEndDate;
    }

    public String getTrustDocStore() {
        return trustDocStore;
    }

    public void setTrustDocStore(String trustDocStore) {
        this.trustDocStore = trustDocStore;
    }

    public String getTrustDocEmpPos() {
        return trustDocEmpPos;
    }

    public void setTrustDocEmpPos(String trustDocEmpPos) {
        this.trustDocEmpPos = trustDocEmpPos;
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
