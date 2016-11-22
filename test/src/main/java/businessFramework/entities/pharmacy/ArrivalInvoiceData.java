package businessFramework.entities.pharmacy;


public class ArrivalInvoiceData
{
    /** Данные для выбора контекста */
    private String departmentForContext;

    /** Данные для полей модального окна Приходная/Расходная накладная */
    private String invoiceExtDoсType;
    private String invoiceExtDocNumber;
    private String invoiceNoContractExtDocNumber;
    private String invoiceExtDocDate;
    private String invoiceIntDoсType;
    private String invoiceNoContractIntDocNumber;
    private String invoiceIntDocNumber;
    private String invoiceIntDocDate;
    private String invoiceContractor;
    private String invoiceNoContractor;
    private String invoiceShipper;
    private String invoiceRecipient;
    private String invoiceStoreOperation;
    private String invoiceFundSource;
    private String invoiceAmountPlanned;
    private String invoiceAmountFact;
    private String invoiceAmountFactEdited;
    private String invoiceContract;
    private String invoiceNote;
    private String invoiceChangedExtDocNumber;
    private String invoiceChangedIntDocNumber;
    private String invoiceNoContractChangedIntDocNumber;
    private String invoiceNoContractChangedExtDocNumber;
    private String invoiceChangedNote;
    private String invoiceChargeOperation;
    private String invoiceArrivalOperation;
    private String procurementMethod;
    private String numberEI;
    private String numberEIEdit;

    /** Данные для проверки записи в таблице Приходные накладные */
    private String invoiceTableExtInvoice;
    private String invoiceNoContractTableExtInvoice;
    private String invoiceTableAmountPlanned;
    private String invoiceTableChangedExtInvoice;
    private String invoiceNoContractTableChangedExtInvoice;
    private String invoiceTableStatusExecuted;

    /** Данные для полей страницы Спецификация */
    private String specificationNDS;
    private String specificationMargin;
    private String specificationContractModification;
    private String specificationModification;
    private String specificationProducer;
    private String specificationCountry;
    private String specificationSeries;
    private String specificationExpireDate;
    private String specificationProductionDate;
    private String specificationCertificate;
    private String specificationQuantity;
    private String specificationMneiQuantity;
    private String specificationAmountWithNDS;
    private String specificationAmount;
    private String specificationAmountWithMargin;
    private String specificationPriceWithNDS;
    private String specificationPrice;
    private String specificationPriceWithMargin;
    private String specificationChangedSeries;
    private String specificationChangedCertificate;
    /** Поля остатков по спецификации контракта*/
    private String contrSpecDeliveredQuantity;
    private String contrSpecRestQuantity;

    /** Данные для полей модального окна редактирования спецификации **/
    private String specificationEditQuantity;
    private String specificationEditMneiQuantity;
    private String specificationEditAmountWithNDS;
    private String specificationEditAmount;
    private String specificationEditAmountWithMargin;
    private String specificationEditPriceWithNDS;
    private String specificationEditPrice;
    private String specificationEditPriceWithMargin;

    /** Данные для полей страницы Спецификация: производитель */
    private HoldingProducerData holdingProducerData;

    /** Данные для проверки записи в таблице Спецификации */
    private String specificationTableMeasure;
    private String specificationTablePrice;
    private String specificationTableContractPrice;
    private String specificationTableAmount;

    /** Данные для проверки заголовка модального окна "Спецификация" */
    private String specificationsModalHeader;
    private String invoiceExecutionModalHeader;
    private String invoiceExecutionNoContractModalHeader;

    /** Данные для алертов(уведомлений об успешном сохранении и тд) */
    private String successSaveAlertMessage;
    private String successDeleteAlertMessage;
    private String successExecutionAlertMessage;
    private String successCancelExecutionAlertMessage;
    private String successArrivalInvoiceCreationAlertMessage;
    private String successChangedArrivalInvoiceCreationAlertMessage;
    private String successArrivalInvoiceNoContractCreationAlertMessage;
    private String successChangedArrivalInvoiceNoContractCreationAlertMessage;

    public String getSpecificationsModalHeader()
    {
        return specificationsModalHeader;
    }

    public void setSpecificationsModalHeader(String specificationsModalHeader)
    {
        this.specificationsModalHeader = specificationsModalHeader;
    }

    public String getDepartmentForContext()
    {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext)
    {
        this.departmentForContext = departmentForContext;
    }

    public String getInvoiceExtDoсType()
    {
        return invoiceExtDoсType;
    }

    public void setInvoiceExtDoсType(String invoiceExtDoсType)
    {
        this.invoiceExtDoсType = invoiceExtDoсType;
    }

    public String getInvoiceExtDocNumber()
    {
        return invoiceExtDocNumber;
    }

    public void setInvoiceExtDocNumber(String invoiceExtDocNumber)
    {
        this.invoiceExtDocNumber = invoiceExtDocNumber;
    }

    public String getInvoiceNoContractExtDocNumber()
    {
        return invoiceNoContractExtDocNumber;
    }

    public void setInvoiceNoContractExtDocNumber(String invoiceNoContractExtDocNumber)
    {
        this.invoiceNoContractExtDocNumber = invoiceNoContractExtDocNumber;
    }

    public String getInvoiceExtDocDate()
    {
        return invoiceExtDocDate;
    }

    public void setInvoiceExtDocDate(String invoiceExtDocDate)
    {
        this.invoiceExtDocDate = invoiceExtDocDate;
    }

    public String getInvoiceIntDoсType()
    {
        return invoiceIntDoсType;
    }

    public void setInvoiceIntDoсType(String invoiceIntDoсType)
    {
        this.invoiceIntDoсType = invoiceIntDoсType;
    }

    public String getInvoiceIntDocNumber()
    {
        return invoiceIntDocNumber;
    }

    public void setInvoiceIntDocNumber(String invoiceIntDocNumber)
    {
        this.invoiceIntDocNumber = invoiceIntDocNumber;
    }

    public String getInvoiceNoContractIntDocNumber()
    {
        return invoiceNoContractIntDocNumber;
    }

    public void setInvoiceNoContractIntDocNumber(String invoiceNoContractIntDocNumber)
    {
        this.invoiceNoContractIntDocNumber = invoiceNoContractIntDocNumber;
    }

    public String getInvoiceIntDocDate()
    {
        return invoiceIntDocDate;
    }

    public void setInvoiceIntDocDate(String invoiceIntDocDate)
    {
        this.invoiceIntDocDate = invoiceIntDocDate;
    }

    public String getInvoiceContractor()
    {
        return invoiceContractor;
    }

    public void setInvoiceContractor(String invoiceContractor)
    {
        this.invoiceContractor = invoiceContractor;
    }

    public String getInvoiceNoContractor()
    {
        return invoiceNoContractor;
    }

    public void setInvoiceNoContractor(String invoiceNoContractor)
    {
        this.invoiceNoContractor = invoiceNoContractor;
    }

    public String getInvoiceShipper()
    {
        return invoiceShipper;
    }

    public void setInvoiceShipper(String invoiceShipper)
    {
        this.invoiceShipper = invoiceShipper;
    }

    public String getInvoiceRecipient()
    {
        return invoiceRecipient;
    }

    public void setInvoiceRecipient(String invoiceRecipient)
    {
        this.invoiceRecipient = invoiceRecipient;
    }

    public String getInvoiceStoreOperation()
    {
        return invoiceStoreOperation;
    }

    public void setInvoiceStoreOperation(String invoiceStoreOperation)
    {
        this.invoiceStoreOperation = invoiceStoreOperation;
    }

    public String getInvoiceFundSource()
    {
        return invoiceFundSource;
    }

    public void setInvoiceFundSource(String invoiceFundSource)
    {
        this.invoiceFundSource = invoiceFundSource;
    }

    public String getInvoiceAmountPlanned()
    {
        return invoiceAmountPlanned;
    }

    public void setInvoiceAmountPlanned(String invoiceAmountPlanned)
    {
        this.invoiceAmountPlanned = invoiceAmountPlanned;
    }

    public String getInvoiceAmountFact()
    {
        return invoiceAmountFact;
    }

    public void setInvoiceAmountFact(String invoiceAmountFact)
    {
        this.invoiceAmountFact = invoiceAmountFact;
    }

    public String getInvoiceContract()
    {
        return invoiceContract;
    }

    public void setInvoiceContract(String invoiceContract)
    {
        this.invoiceContract = invoiceContract;
    }

    public String getInvoiceNote()
    {
        return invoiceNote;
    }

    public void setInvoiceNote(String invoiceNote)
    {
        this.invoiceNote = invoiceNote;
    }

    public String getInvoiceChangedExtDocNumber()
    {
        return invoiceChangedExtDocNumber;
    }

    public void setInvoiceChangedExtDocNumber(String invoiceChangedExtDocNumber)
    {
        this.invoiceChangedExtDocNumber = invoiceChangedExtDocNumber;
    }

    public String getInvoiceNoContractChangedExtDocNumber()
    {
        return invoiceNoContractChangedExtDocNumber;
    }

    public void setInvoiceNoContractChangedExtDocNumber(String invoiceNoContractChangedExtDocNumber)
    {
        this.invoiceNoContractChangedExtDocNumber = invoiceNoContractChangedExtDocNumber;
    }

    public String getInvoiceChangedIntDocNumber()
    {
        return invoiceChangedIntDocNumber;
    }

    public void setInvoiceChangedIntDocNumber(String invoiceChangedIntDocNumber)
    {
        this.invoiceChangedIntDocNumber = invoiceChangedIntDocNumber;
    }

    public String getInvoiceNoContractChangedIntDocNumber()
    {
        return invoiceNoContractChangedIntDocNumber;
    }

    public void setInvoiceNoContractChangedIntDocNumber(String invoiceNoContractChangedIntDocNumber)
    {
        this.invoiceNoContractChangedIntDocNumber = invoiceNoContractChangedIntDocNumber;
    }

    public String getInvoiceChangedNote()
    {
        return invoiceChangedNote;
    }

    public void setInvoiceChangedNote(String invoiceChangedNote)
    {
        this.invoiceChangedNote = invoiceChangedNote;
    }

    public String getSpecificationNDS()
    {
        return specificationNDS;
    }

    public void setSpecificationNDS(String specificationNDS)
    {
        this.specificationNDS = specificationNDS;
    }

    public String getSpecificationMargin()
    {
        return specificationMargin;
    }

    public void setSpecificationMargin(String specificationMargin)
    {
        this.specificationMargin = specificationMargin;
    }

    public String getSpecificationModification()
    {
        return specificationModification;
    }

    public void setSpecificationModification(String specificationModification)
    {
        this.specificationModification = specificationModification;
    }

    public String getSpecificationProducer()
    {
        return specificationProducer;
    }

    public void setSpecificationProducer(String specificationProducer)
    {
        this.specificationProducer = specificationProducer;
    }

    public String getSpecificationCountry()
    {
        return specificationCountry;
    }

    public void setSpecificationCountry(String specificationCountry)
    {
        this.specificationCountry = specificationCountry;
    }

    public String getSpecificationSeries()
    {
        return specificationSeries;
    }

    public void setSpecificationSeries(String specificationSeries)
    {
        this.specificationSeries = specificationSeries;
    }

    public String getSpecificationExpireDate()
    {
        return specificationExpireDate;
    }

    public void setSpecificationExpireDate(String specificationExpireDate)
    {
        this.specificationExpireDate = specificationExpireDate;
    }

    public String getSpecificationProductionDate()
    {
        return specificationProductionDate;
    }

    public void setSpecificationProductionDate(String specificationProductionDate)
    {
        this.specificationProductionDate = specificationProductionDate;
    }

    public String getSpecificationCertificate()
    {
        return specificationCertificate;
    }

    public void setSpecificationCertificate(String specificationCertificate)
    {
        this.specificationCertificate = specificationCertificate;
    }

    public String getSpecificationQuantity()
    {
        return specificationQuantity;
    }

    public void setSpecificationQuantity(String specificationQuantity)
    {
        this.specificationQuantity = specificationQuantity;
    }

    public String getSpecificationMneiQuantity()
    {
        return specificationMneiQuantity;
    }

    public void setSpecificationMneiQuantity(String specificationMneiQuantity)
    {
        this.specificationMneiQuantity = specificationMneiQuantity;
    }

    public String getSpecificationAmountWithNDS()
    {
        return specificationAmountWithNDS;
    }

    public void setSpecificationAmountWithNDS(String specificationAmountWithNDS)
    {
        this.specificationAmountWithNDS = specificationAmountWithNDS;
    }

    public String getSpecificationAmount()
    {
        return specificationAmount;
    }

    public void setSpecificationAmount(String specificationAmount)
    {
        this.specificationAmount = specificationAmount;
    }

    public String getSpecificationAmountWithMargin()
    {
        return specificationAmountWithMargin;
    }

    public void setSpecificationAmountWithMargin(String specificationAmountWithMargin)
    {
        this.specificationAmountWithMargin = specificationAmountWithMargin;
    }

    public String getSpecificationPriceWithNDS()
    {
        return specificationPriceWithNDS;
    }

    public void setSpecificationPriceWithNDS(String specificationPriceWithNDS)
    {
        this.specificationPriceWithNDS = specificationPriceWithNDS;
    }

    public String getSpecificationPrice()
    {
        return specificationPrice;
    }

    public void setSpecificationPrice(String specificationPrice)
    {
        this.specificationPrice = specificationPrice;
    }

    public String getSpecificationPriceWithMargin()
    {
        return specificationPriceWithMargin;
    }

    public void setSpecificationPriceWithMargin(String specificationPriceWithMargin)
    {
        this.specificationPriceWithMargin = specificationPriceWithMargin;
    }

    public String getSpecificationChangedSeries()
    {
        return specificationChangedSeries;
    }

    public void setSpecificationChangedSeries(String specificationChangedSeries)
    {
        this.specificationChangedSeries = specificationChangedSeries;
    }

    public String getSpecificationChangedCertificate()
    {
        return specificationChangedCertificate;
    }

    public void setSpecificationChangedCertificate(String specificationChangedCertificate)
    {
        this.specificationChangedCertificate = specificationChangedCertificate;
    }

    public String getInvoiceTableExtInvoice()
    {
        return invoiceTableExtInvoice;
    }

    public void setInvoiceTableExtInvoice(String invoiceTableExtInvoice)
    {
        this.invoiceTableExtInvoice = invoiceTableExtInvoice;
    }

    public String getInvoiceNoContractTableExtInvoice()
    {
        return invoiceNoContractTableExtInvoice;
    }

    public void setInvoiceNoContractTableExtInvoice(String invoiceNoContractTableExtInvoice)
    {
        this.invoiceNoContractTableExtInvoice = invoiceNoContractTableExtInvoice;
    }

    public String getInvoiceTableAmountPlanned()
    {
        return invoiceTableAmountPlanned;
    }

    public void setInvoiceTableAmountPlanned(String invoiceTableAmountPlanned)
    {
        this.invoiceTableAmountPlanned = invoiceTableAmountPlanned;
    }

    public String getInvoiceTableChangedExtInvoice()
    {
        return invoiceTableChangedExtInvoice;
    }

    public void setInvoiceTableChangedExtInvoice(String invoiceTableChangedExtInvoice)
    {
        this.invoiceTableChangedExtInvoice = invoiceTableChangedExtInvoice;
    }

    public String getInvoiceNoContractTableChangedExtInvoice()
    {
        return invoiceNoContractTableChangedExtInvoice;
    }

    public void setInvoiceNoContractTableChangedExtInvoice(String invoiceNoContractTableChangedExtInvoice)
    {
        this.invoiceNoContractTableChangedExtInvoice = invoiceNoContractTableChangedExtInvoice;
    }

    public String getSpecificationContractModification()
    {
        return specificationContractModification;
    }

    public void setSpecificationContractModification(String specificationContractModification)
    {
        this.specificationContractModification = specificationContractModification;
    }

    public String getSpecificationTableMeasure()
    {
        return specificationTableMeasure;
    }

    public void setSpecificationTableMeasure(String specificationTableMeasure)
    {
        this.specificationTableMeasure = specificationTableMeasure;
    }

    public String getSpecificationTablePrice()
    {
        return specificationTablePrice;
    }

    public void setSpecificationTablePrice(String specificationTablePrice)
    {
        this.specificationTablePrice = specificationTablePrice;
    }

    public String getSpecificationTableAmount()
    {
        return specificationTableAmount;
    }

    public void setSpecificationTableAmount(String specificationTableAmount)
    {
        this.specificationTableAmount = specificationTableAmount;
    }

    public String getSuccessSaveAlertMessage()
    {
        return successSaveAlertMessage;
    }

    public void setSuccessSaveAlertMessage(String successSaveAlertMessage)
    {
        this.successSaveAlertMessage = successSaveAlertMessage;
    }

    public String getSuccessDeleteAlertMessage()
    {
        return successDeleteAlertMessage;
    }

    public void setSuccessDeleteAlertMessage(String successDeleteAlertMessage)
    {
        this.successDeleteAlertMessage = successDeleteAlertMessage;
    }

    public String getSuccessExecutionAlertMessage()
    {
        return successExecutionAlertMessage;
    }

    public void setSuccessExecutionAlertMessage(String successExecutionAlertMessage)
    {
        this.successExecutionAlertMessage = successExecutionAlertMessage;
    }

    public String getSuccessCancelExecutionAlertMessage()
    {
        return successCancelExecutionAlertMessage;
    }

    public void setSuccessCancelExecutionAlertMessage(String successCancelExecutionAlertMessage)
    {
        this.successCancelExecutionAlertMessage = successCancelExecutionAlertMessage;
    }

    public String getSuccessArrivalInvoiceCreationAlertMessage()
    {
        return successArrivalInvoiceCreationAlertMessage;
    }

    public void setSuccessArrivalInvoiceCreationAlertMessage(String successArrivalInvoiceCreationAlertMessage)
    {
        this.successArrivalInvoiceCreationAlertMessage = successArrivalInvoiceCreationAlertMessage;
    }

    public String getSuccessArrivalInvoiceNoContractCreationAlertMessage()
    {
        return successArrivalInvoiceNoContractCreationAlertMessage;
    }

    public void setSuccessArrivalInvoiceNoContractCreationAlertMessage(String successArrivalInvoiceNoContractCreationAlertMessage)
    {
        this.successArrivalInvoiceNoContractCreationAlertMessage = successArrivalInvoiceNoContractCreationAlertMessage;
    }


    public String getSuccessChangedArrivalInvoiceCreationAlertMessage()
    {
        return successChangedArrivalInvoiceCreationAlertMessage;
    }

    public void setSuccessChangedArrivalInvoiceCreationAlertMessage(String successChangedArrivalInvoiceCreationAlertMessage)
    {
        this.successChangedArrivalInvoiceCreationAlertMessage = successChangedArrivalInvoiceCreationAlertMessage;
    }

    public String getSuccessChangedArrivalInvoiceNoContractCreationAlertMessage()
    {
        return successChangedArrivalInvoiceNoContractCreationAlertMessage;
    }

    public void setSuccessChangedArrivalInvoiceNoContractCreationAlertMessage(String successChangedArrivalInvoiceNoContractCreationAlertMessage)
    {
        this.successChangedArrivalInvoiceNoContractCreationAlertMessage = successChangedArrivalInvoiceNoContractCreationAlertMessage;
    }


    public String getInvoiceExecutionModalHeader()
    {
        return invoiceExecutionModalHeader;
    }

    public void setInvoiceExecutionModalHeader(String invoiceExecutionModalHeader)
    {
        this.invoiceExecutionModalHeader = invoiceExecutionModalHeader;
    }

    public String getInvoiceExecutionNoContractModalHeader()
    {
        return invoiceExecutionNoContractModalHeader;
    }

    public void setInvoiceExecutionNoContractModalHeader(String invoiceExecutionNoContractModalHeader)
    {
        this.invoiceExecutionNoContractModalHeader = invoiceExecutionNoContractModalHeader;
    }

    public String getInvoiceTableStatusExecuted()
    {
        return invoiceTableStatusExecuted;
    }

    public void setInvoiceTableStatusExecuted(String invoiceTableStatusExecuted)
    {
        this.invoiceTableStatusExecuted = invoiceTableStatusExecuted;
    }

    public HoldingProducerData getHoldingProducerData() {
        return holdingProducerData;
    }

    public void setHoldingProducerData(HoldingProducerData holdingProducerData) {
        this.holdingProducerData = holdingProducerData;
    }

    public String getSpecificationEditAmountWithNDS() {
        return specificationEditAmountWithNDS;
    }

    public void setSpecificationEditAmountWithNDS(String specificationEditAmountWithNDS) {
        this.specificationEditAmountWithNDS = specificationEditAmountWithNDS;
    }

    public String getSpecificationEditAmount() {
        return specificationEditAmount;
    }

    public void setSpecificationEditAmount(String specificationEditAmount) {
        this.specificationEditAmount = specificationEditAmount;
    }

    public String getSpecificationEditAmountWithMargin() {
        return specificationEditAmountWithMargin;
    }

    public void setSpecificationEditAmountWithMargin(String specificationEditAmountWithMargin) {
        this.specificationEditAmountWithMargin = specificationEditAmountWithMargin;
    }

    public String getSpecificationEditPriceWithNDS() {
        return specificationEditPriceWithNDS;
    }

    public void setSpecificationEditPriceWithNDS(String specificationEditPriceWithNDS) {
        this.specificationEditPriceWithNDS = specificationEditPriceWithNDS;
    }

    public String getSpecificationEditPrice() {
        return specificationEditPrice;
    }

    public void setSpecificationEditPrice(String specificationEditPrice) {
        this.specificationEditPrice = specificationEditPrice;
    }

    public String getSpecificationEditPriceWithMargin() {
        return specificationEditPriceWithMargin;
    }

    public void setSpecificationEditPriceWithMargin(String specificationEditPriceWithMargin) {
        this.specificationEditPriceWithMargin = specificationEditPriceWithMargin;
    }

    public String getSpecificationTableContractPrice() {
        return specificationTableContractPrice;
    }

    public void setSpecificationTableContractPrice(String specificationTableContractPrice) {
        this.specificationTableContractPrice = specificationTableContractPrice;
    }

    public String getContrSpecRestQuantity() {
        return contrSpecRestQuantity;
    }

    public void setContrSpecRestQuantity(String contrSpecRestQuantity) {
        this.contrSpecRestQuantity = contrSpecRestQuantity;
    }

    public String getContrSpecDeliveredQuantity() {
        return contrSpecDeliveredQuantity;
    }

    public void setContrSpecDeliveredQuantity(String contrSpecDeliveredQuantity) {
        this.contrSpecDeliveredQuantity = contrSpecDeliveredQuantity;
    }

    public String getInvoiceChargeOperation() {
        return invoiceChargeOperation;
    }

    public void setInvoiceChargeOperation(String invoiceChargeOperation) {
        this.invoiceChargeOperation = invoiceChargeOperation;
    }

    public String getInvoiceArrivalOperation() {
        return invoiceArrivalOperation;
    }

    public void setInvoiceArrivalOperation(String invoiceArrivalOperation) {
        this.invoiceArrivalOperation = invoiceArrivalOperation;
    }

    public String getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(String procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public String getInvoiceAmountFactEdited() {
        return invoiceAmountFactEdited;
    }

    public void setInvoiceAmountFactEdited(String invoiceAmountFactEdited) {
        this.invoiceAmountFactEdited = invoiceAmountFactEdited;
    }

    public String getSpecificationEditMneiQuantity() {
        return specificationEditMneiQuantity;
    }

    public void setSpecificationEditMneiQuantity(String specificationEditMneiQuantity) {
        this.specificationEditMneiQuantity = specificationEditMneiQuantity;
    }

    public String getSpecificationEditQuantity() {
        return specificationEditQuantity;
    }

    public void setSpecificationEditQuantity(String specificationEditQuantity) {
        this.specificationEditQuantity = specificationEditQuantity;
    }

    public String getNumberEI()
    {
        return numberEI;
    }

    public void setNumberEI(String numberEI)
    {
        this.numberEI = numberEI;
    }

    public String getNumberEIEdit()
    {
        return numberEIEdit;
    }

    public void setNumberEIEdit(String numberEIEdit)
    {
        this.numberEIEdit = numberEIEdit;
    }
}

