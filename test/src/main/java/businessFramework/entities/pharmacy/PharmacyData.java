package businessFramework.entities.pharmacy;

public class PharmacyData implements Cloneable
{

    /** Данные для выбора контекста */
    private String departmentForContext;

    /**Данные для установки значений в поля в модальном окне "Возвратный документ" */
    private String returnDocNumber;
    private String returnDocDate;
    private String storeName;
    private String storeOperation;
    private String contractorName;
    private String funding;
    private String returnReason;
    private String annotation;

    /** Данные для установки значений в поля в модальном окне "Контракт" */
    private String name;
    private String sum;
    private String financing;
    private String provider;
    private String documentType;
    private String validEndDate;

    /** Данные для редактирования записи контракта*/
    private String nameForEdit;
    private String sumForEdit;

    /** Данные для установки значений в поля в модальном окне "Контракт №%s от %s. Добавление спецификации." */
    private String nameLS_IMN;
    private String series;
    private String productionDate;
    private String producer;
    private String country;
    private String expiringDate;
    private String certificate;
    private String quantity;
    private String amount;
    private String mneiQuantity;
    private String price;
    private String formattedAmount;
    private String formattedPrice;

    /** Данные для установки значений в модальном окне "Спецификация" в шаге "Редактирование спецификации"*/
    private String countryForEditSpecification;
    private String expiringDateForEditSpecification;
    private String quantityForEditSpecification;
    private String mneiQuantityForEditSpecification; //Если изменить значение "Кол-во", изменится и значение поля "Кол-во в МНЕИ"
    private String priceForEditSpecification;        //Если изменить значение "Кол-во", изменится и значение поля "Цена (руб.)"

    /** Данные для измененных значений "Цена" (100.00) и "Сумма" (1 000.00) */
    private String formattedPriceForEditSpecification;
    private String formattedAmountForEditSpecification;

    /** Значение столбца "Статус" в таблице "Контракты" после изменения статуса контракта на "Подтвержден" */
    private String confirmed;

    /** Данные для установки значений в модальном окне окне "Требование" */
    private String requestDocumentType;
    private String requestNumber;
    private String requestDate;
    private String requestSendStore;
    private String requestStore;
    private String requestFundingSource;
    private String requestCommodityGroup;
    private String requestTrustDocumentNumberAndDate;
    private String requestChangedNumber;
    private String requestChangedStore;
    private String requestNumberColumnName;

    /** Данные для выбора спецификации требования*/
    private String requestSpecificationMedicineName;

    /** Данные для установки и проверки значений в модальном окне Спецификаций*/
    private String requestSpecificationMedicamentQuantity;
    private String requestSpecificationMneiQuantity;
    private String requestChangedSpecificationMedicamentQuantity;
    private String requestChangedSpecificationMneiQuantity;

    /** Данные для заголовков модальных окон*/
    private String requestModalHeader;
    private String updateAndViewSpecificationModalHeader;
    private String addSpecificationModalHeader;

    /** Данные для алертов(уведомлений об успешном сохранении и тд) */
    private String successSaveAlertMessage;

    /** Данные для таблицы "Требования" */
    private String statusApproved;

    private String requestTrustDocumentNumber;

    public String getConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(String confirmed)
    {
        this.confirmed = confirmed;
    }

    public String getPriceForEditSpecification()
    {
        return priceForEditSpecification;
    }

    public void setPriceForEditSpecification(String priceForEditSpecification)
    {
        this.priceForEditSpecification = priceForEditSpecification;
    }

    public String getMneiQuantityForEditSpecification()
    {
        return mneiQuantityForEditSpecification;
    }

    public void setMneiQuantityForEditSpecification(String mneiQuantityForEditSpecification)
    {
        this.mneiQuantityForEditSpecification = mneiQuantityForEditSpecification;
    }

    public String getFormattedPriceForEditSpecification()
    {
        return formattedPriceForEditSpecification;
    }

    public void setFormattedPriceForEditSpecification(String formattedPriceForEditSpecification)
    {
        this.formattedPriceForEditSpecification = formattedPriceForEditSpecification;
    }

    public String getFormattedAmountForEditSpecification()
    {
        return formattedAmountForEditSpecification;
    }

    public void setFormattedAmountForEditSpecification(String formattedAmountForEditSpecification)
    {
        this.formattedAmountForEditSpecification = formattedAmountForEditSpecification;
    }

    public String getCountryForEditSpecification()
    {
        return countryForEditSpecification;
    }

    public void setCountryForEditSpecification(String countryForEditSpecification)
    {
        this.countryForEditSpecification = countryForEditSpecification;
    }

    public String getExpiringDateForEditSpecification()
    {
        return expiringDateForEditSpecification;
    }

    public void setExpiringDateForEditSpecification(String expiringDateForEditSpecification)
    {
        this.expiringDateForEditSpecification = expiringDateForEditSpecification;
    }

    public String getQuantityForEditSpecification()
    {
        return quantityForEditSpecification;
    }

    public void setQuantityForEditSpecification(String quantityForEditSpecification)
    {
        this.quantityForEditSpecification = quantityForEditSpecification;
    }

    public String getFormattedPrice()
    {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice)
    {
        this.formattedPrice = formattedPrice;
    }

    public String getFormattedAmount()
    {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount)
    {
        this.formattedAmount = formattedAmount;
    }

    public void setMneiQuantity(String mneiQuantity)
    {
        this.mneiQuantity = mneiQuantity;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getPrice()
    {
        return price;
    }

    public String getMneiQuantity()
    {
        return mneiQuantity;
    }

    public String getNameLS_IMN()
    {
        return nameLS_IMN;
    }

    public void setNameLS_IMN(String nameLS_IMN)
    {
        this.nameLS_IMN = nameLS_IMN;
    }

    public String getSeries()
    {
        return series;
    }

    public void setSeries(String series)
    {
        this.series = series;
    }

    public String getProductionDate()
    {
        return productionDate;
    }

    public void setProductionDate(String productionDate)
    {
        this.productionDate = productionDate;
    }

    public String getProducer()
    {
        return producer;
    }

    public void setProducer(String producer)
    {
        this.producer = producer;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getExpiringDate()
    {
        return expiringDate;
    }

    public void setExpiringDate(String expiringDate)
    {
        this.expiringDate = expiringDate;
    }

    public String getCertificate()
    {
        return certificate;
    }

    public void setCertificate(String certificate)
    {
        this.certificate = certificate;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getNameForEdit()
    {
        return nameForEdit;
    }

    public void setNameForEdit(String nameForEdit)
    {
        this.nameForEdit = nameForEdit;
    }

    public String getSumForEdit()
    {
        return sumForEdit;
    }

    public void setSumForEdit(String sumForEdit)
    {
        this.sumForEdit = sumForEdit;
    }

    public String getDocumentType()
    {
        return documentType;
    }

    public void setDocumentType(String documentType)
    {
        this.documentType = documentType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSum()
    {
        return sum;
    }

    public void setSum(String sum)
    {
        this.sum = sum;
    }

    public String getFinancing()
    {
        return financing;
    }

    public void setFinancing(String financing)
    {
        this.financing = financing;
    }

    public String getProvider()
    {
        return provider;
    }

    public void setProvider(String provider)
    {
        this.provider = provider;
    }

    public String getDepartmentForContext()
    {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext)
    {
        this.departmentForContext = departmentForContext;
    }

    public String getRequestDocumentType()
    {
        return requestDocumentType;
    }

    public void setRequestDocumentType(String requestDocumentType)
    {
        this.requestDocumentType = requestDocumentType;
    }

    public String getRequestNumber()
    {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber)
    {
        this.requestNumber = requestNumber;
    }

    public String getRequestDate()
    {
        return requestDate;
    }

    public void setRequestDate(String requestDate)
    {
        this.requestDate = requestDate;
    }

    public String getRequestStore()
    {
        return requestStore;
    }

    public void setRequestStore(String requestStore)
    {
        this.requestStore = requestStore;
    }

    public String getRequestSendStore() {
        return requestSendStore;
    }

    public void setRequestSendStore(String requestSendStore) {
        this.requestSendStore = requestSendStore;
    }

    public String getRequestFundingSource()
    {
        return requestFundingSource;
    }

    public void setRequestFundingSource(String requestFundingSource)
    {
        this.requestFundingSource = requestFundingSource;
    }

    public String getRequestCommodityGroup()
    {
        return requestCommodityGroup;
    }

    public void setRequestCommodityGroup(String requestCommodityGroup)
    {
        this.requestCommodityGroup = requestCommodityGroup;
    }

    public String getRequestTrustDocumentNumberAndDate()
    {
        return requestTrustDocumentNumberAndDate;
    }

    public void setRequestTrustDocumentNumberAndDate(String requestTrustDocumentNumberAndDate)
    {
        this.requestTrustDocumentNumberAndDate = requestTrustDocumentNumberAndDate;
    }

    public String getRequestTrustDocumentNumber()
    {
        return requestTrustDocumentNumber;
    }

    public void setRequestTrustDocumentNumber(String requestTrustDocumentNumber)
    {
        this.requestTrustDocumentNumber = requestTrustDocumentNumber;
    }

    public String getRequestChangedNumber()
    {
        return requestChangedNumber;
    }

    public void setRequestChangedNumber(String requestChangedNumber)
    {
        this.requestChangedNumber = requestChangedNumber;
    }

    public String getRequestChangedStore()
    {
        return requestChangedStore;
    }

    public void setRequestChangedStore(String requestChangedStore)
    {
        this.requestChangedStore = requestChangedStore;
    }

    public String getRequestSpecificationMedicineName()
    {
        return requestSpecificationMedicineName;
    }

    public void setRequestSpecificationMedicineName(String requestSpecificationMedicineName)
    {
        this.requestSpecificationMedicineName = requestSpecificationMedicineName;
    }

    public String getRequestSpecificationMedicamentQuantity()
    {
        return requestSpecificationMedicamentQuantity;
    }

    public void setRequestSpecificationMedicamentQuantity(String requestSpecificationMedicamentQuantity)
    {
        this.requestSpecificationMedicamentQuantity = requestSpecificationMedicamentQuantity;
    }

    public String getRequestChangedSpecificationMedicamentQuantity()
    {
        return requestChangedSpecificationMedicamentQuantity;
    }

    public void setRequestChangedSpecificationMedicamentQuantity(String requestChangedSpecificationMedicamentQuantity)
    {
        this.requestChangedSpecificationMedicamentQuantity = requestChangedSpecificationMedicamentQuantity;
    }

    public String getRequestSpecificationMneiQuantity()
    {
        return requestSpecificationMneiQuantity;
    }

    public void setRequestSpecificationMneiQuantity(String requestSpecificationMneiQuantity)
    {
        this.requestSpecificationMneiQuantity = requestSpecificationMneiQuantity;
    }

    public String getRequestChangedSpecificationMneiQuantity()
    {
        return requestChangedSpecificationMneiQuantity;
    }

    public void setRequestChangedSpecificationMneiQuantity(String requestChangedSpecificationMneiQuantity)
    {
        this.requestChangedSpecificationMneiQuantity = requestChangedSpecificationMneiQuantity;
    }

    public String getRequestModalHeader()
    {
        return requestModalHeader;
    }

    public void setRequestModalHeader(String requestModalHeader)
    {
        this.requestModalHeader = requestModalHeader;
    }


    public String getUpdateAndViewSpecificationModalHeader()
    {
        return updateAndViewSpecificationModalHeader;
    }

    public void setUpdateAndViewSpecificationModalHeader(String updateAndViewSpecificationModalHeader)
    {
        this.updateAndViewSpecificationModalHeader = updateAndViewSpecificationModalHeader;
    }

    public String getAddSpecificationModalHeader()
    {
        return addSpecificationModalHeader;
    }

    public void setAddSpecificationModalHeader(String addSpecificationModalHeader)
    {
        this.addSpecificationModalHeader = addSpecificationModalHeader;
    }

    public String getSuccessSaveAlertMessage()
    {
        return successSaveAlertMessage;
    }

    public void setSuccessSaveAlertMessage(String successSaveAlertMessage)
    {
        this.successSaveAlertMessage = successSaveAlertMessage;
    }

    public String getStatusApproved()
    {
        return statusApproved;
    }

    public void setStatusApproved(String statusApproved)
    {
        this.statusApproved = statusApproved;
    }

    public String getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(String validEndDate) {
        this.validEndDate = validEndDate;
    }

    public String getRequestNumberColumnName() {
        return requestNumberColumnName;
    }

    public void setRequestNumberColumnName(String requestNumberColumnName) {
        this.requestNumberColumnName = requestNumberColumnName;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getStoreOperation() {
        return storeOperation;
    }

    public void setStoreOperation(String storeOperation) {
        this.storeOperation = storeOperation;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getReturnDocDate() {
        return returnDocDate;
    }

    public void setReturnDocDate(String returnDocDate) {
        this.returnDocDate = returnDocDate;
    }

    public String getReturnDocNumber() {
        return returnDocNumber;
    }

    public void setReturnDocNumber(String returnDocNumber) {
        this.returnDocNumber = returnDocNumber;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
