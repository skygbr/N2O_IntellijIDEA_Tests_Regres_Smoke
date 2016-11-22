package businessFramework.entities.pharmacy;


import java.util.List;

public class PharmacyApplicationsData
{

    /** Данные для выбора контекста */
    private String departmentForContext;

    /** Данные для проверка значений в поле "Статус документа" в фильтре */
    private String docStatus;

    /** Данные для проверки заголовка модального окна "Добавление заявки" */
    private String createAppModalHeader;

    /** Данные для проверки заголовка модального окна редактирования заявки */
    private String editAppModalHeader;

    /** Данные для проверки заголовка модального окна просмотра заявки */
    private String viewAppModalHeader;

    /** Данные для проверки заголовка модального окна добавления спецификации */
    private String addSpecModalHeader;

    /** Данные для проверки заголовка модального окна редактирования спецификации */
    private String editSpecModalHeader;

    /** Данные для проверки текста в подтверждающем модальном окне подтверждения утверждения заявки */
    private String messageExecutingApplicationDialog;

    /** Данные для заполнения и проверки значений в полях в модальном окне "Создание заявки" */
    private String docType;
    private String year;
    private String appType;
    private String prefixNumber;
    private String date;
    private String financing;
    private String department;
    private String store;
    private String productGroup;
    private String comment;

    /** Данные для сообщения об успешном сохранении заявки (после добавления)*/
    private String successMessageAfterAddingApp;

    /** Данные для изменения данных в модальном окне редактирования заявки */
    private String prefixNumberEdited;
    private String commentEdited;
    private String productGroupEdited;

    /** Данные для сообщения об успешном сохранении заявки (после редактирования)*/
    private String successMessageAfterEditingApp;

    /** Данные для заполнения полей в модальном окне добавления спецификации */
    private String nameLS_IMNSpec;
    private String creatorSpec;
    private String countSpec;
    private String priceWithNDSSpec;
    private String sumWithNDSSpec;
    private String sumWithNDSSpecAssert;
    private String commentSpec;

    /** Данные для проверки значений в таблице в контейнере "Спецификации" после добавления спецификации */
    private String countSt;
    private String unitSt;
    private String priceSt;
    private String sumSt;

    /** Данные для проверки и заполнения значений в модальном окне при редактировании спецификации */
    private String countSpecEdited;
    private String priceWithNDS_SpecEdited;
    private String sumWithNDS_specEdited;
    private String sumWithNDS_specEditedAssert;

    /** Данные для проверки текста сообщения об успешном утверждении заявки */
    private String successExecutingMessage;

    /** Данные для проверки заголовков и значений в столбцах таблицы "Заявки" ("статус" и "утвержден") */
    private String statusTD;
    private String executedTDValue;


    /** Данные для процедуры консолидации */
    private String sumApplicationType;
    private String sumApplicationNumber;
    private String consolidateNumberOne;
    private String consolidateNumberTwo;
    private List<String> departmentList;
    private String consolidationSuccessMessage;
    public String getStatusTD()
    {
        return statusTD;
    }

    public void setStatusTD(String statusTD)
    {
        this.statusTD = statusTD;
    }

    public String getExecutedTDValue()
    {
        return executedTDValue;
    }

    public void setExecutedTDValue(String executedTDValue)
    {
        this.executedTDValue = executedTDValue;
    }

    public String getSuccessExecutingMessage()
    {
        return successExecutingMessage;
    }

    public void setSuccessExecutingMessage(String successExecutingMessage)
    {
        this.successExecutingMessage = successExecutingMessage;
    }

    public String getMessageExecutingApplicationDialog()
    {
        return messageExecutingApplicationDialog;
    }

    public void setMessageExecutingApplicationDialog(String messageExecutingApplicationDialog)
    {
        this.messageExecutingApplicationDialog = messageExecutingApplicationDialog;
    }

    public String getCountSpecEdited()
    {
        return countSpecEdited;
    }

    public void setCountSpecEdited(String countSpecEdited)
    {
        this.countSpecEdited = countSpecEdited;
    }

    public String getPriceWithNDS_SpecEdited()
    {
        return priceWithNDS_SpecEdited;
    }

    public void setPriceWithNDS_SpecEdited(String priceWithNDS_SpecEdited)
    {
        this.priceWithNDS_SpecEdited = priceWithNDS_SpecEdited;
    }

    public String getSumWithNDS_specEdited()
    {
        return sumWithNDS_specEdited;
    }

    public void setSumWithNDS_specEdited(String sumWithNDS_specEdited)
    {
        this.sumWithNDS_specEdited = sumWithNDS_specEdited;
    }

    public String getEditSpecModalHeader()
    {
        return editSpecModalHeader;
    }

    public void setEditSpecModalHeader(String editSpecModalHeader)
    {
        this.editSpecModalHeader = editSpecModalHeader;
    }

    public String getUnitSt()
    {
        return unitSt;
    }

    public void setUnitSt(String unitSt)
    {
        this.unitSt = unitSt;
    }

    public String getPriceSt()
    {
        return priceSt;
    }

    public void setPriceSt(String priceSt)
    {
        this.priceSt = priceSt;
    }

    public String getSumSt()
    {
        return sumSt;
    }

    public void setSumSt(String sumSt)
    {
        this.sumSt = sumSt;
    }

    public String getProductGroupEdited()
    {
        return productGroupEdited;
    }

    public void setProductGroupEdited(String productGroupEdited)
    {
        this.productGroupEdited = productGroupEdited;
    }

    public String getAddSpecModalHeader()
    {
        return addSpecModalHeader;
    }

    public void setAddSpecModalHeader(String addSpecModalHeader)
    {
        this.addSpecModalHeader = addSpecModalHeader;
    }

    public String getNameLS_IMNSpec()
    {
        return nameLS_IMNSpec;
    }

    public void setNameLS_IMNSpec(String nameLS_IMNSpec)
    {
        this.nameLS_IMNSpec = nameLS_IMNSpec;
    }

    public String getCreatorSpec()
    {
        return creatorSpec;
    }

    public void setCreatorSpec(String creatorSpec)
    {
        this.creatorSpec = creatorSpec;
    }

    public String getCountSpec()
    {
        return countSpec;
    }

    public void setCountSpec(String countSpec)
    {
        this.countSpec = countSpec;
    }

    public String getPriceWithNDSSpec()
    {
        return priceWithNDSSpec;
    }

    public void setPriceWithNDSSpec(String priceWithNDSSpec)
    {
        this.priceWithNDSSpec = priceWithNDSSpec;
    }

    public String getSumWithNDSSpec()
    {
        return sumWithNDSSpec;
    }

    public void setSumWithNDSSpec(String sumWithNDSSpec)
    {
        this.sumWithNDSSpec = sumWithNDSSpec;
    }

    public String getCommentSpec()
    {
        return commentSpec;
    }

    public void setCommentSpec(String commentSpec)
    {
        this.commentSpec = commentSpec;
    }

    public String getViewAppModalHeader()
    {
        return viewAppModalHeader;
    }

    public void setViewAppModalHeader(String viewAppModalHeader)
    {
        this.viewAppModalHeader = viewAppModalHeader;
    }

    public String getSuccessMessageAfterEditingApp()
    {
        return successMessageAfterEditingApp;
    }

    public void setSuccessMessageAfterEditingApp(String successMessageAfterEditingApp)
    {
        this.successMessageAfterEditingApp = successMessageAfterEditingApp;
    }

    public String getPrefixNumberEdited()
    {
        return prefixNumberEdited;
    }

    public void setPrefixNumberEdited(String prefixNumberEdited)
    {
        this.prefixNumberEdited = prefixNumberEdited;
    }

    public String getCommentEdited()
    {
        return commentEdited;
    }

    public void setCommentEdited(String commentEdited)
    {
        this.commentEdited = commentEdited;
    }

    public String getEditAppModalHeader()
    {
        return editAppModalHeader;
    }

    public void setEditAppModalHeader(String editAppModalHeader)
    {
        this.editAppModalHeader = editAppModalHeader;
    }

    public String getSuccessMessageAfterAddingApp()
    {
        return successMessageAfterAddingApp;
    }

    public void setSuccessMessageAfterAddingApp(String successMessageAfterAddingApp)
    {
        this.successMessageAfterAddingApp = successMessageAfterAddingApp;
    }

    public String getDocType()
    {
        return docType;
    }

    public void setDocType(String docType)
    {
        this.docType = docType;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getAppType()
    {
        return appType;
    }

    public void setAppType(String appType)
    {
        this.appType = appType;
    }

    public String getPrefixNumber()
    {
        return prefixNumber;
    }

    public void setPrefixNumber(String prefixNumber)
    {
        this.prefixNumber = prefixNumber;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getFinancing()
    {
        return financing;
    }

    public void setFinancing(String financing)
    {
        this.financing = financing;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getStore()
    {
        return store;
    }

    public void setStore(String store)
    {
        this.store = store;
    }

    public String getProductGroup()
    {
        return productGroup;
    }

    public void setProductGroup(String productGroup)
    {
        this.productGroup = productGroup;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getCreateAppModalHeader()
    {
        return createAppModalHeader;
    }

    public void setCreateAppModalHeader(String createAppModalHeader)
    {
        this.createAppModalHeader = createAppModalHeader;
    }

    public String getDocStatus()
    {
        return docStatus;
    }

    public void setDocStatus(String docStatus)
    {
        this.docStatus = docStatus;
    }

    public String getDepartmentForContext()
    {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext)
    {
        this.departmentForContext = departmentForContext;
    }

    public String getConsolidateNumberOne() {
        return consolidateNumberOne;
    }

    public void setConsolidateNumberOne(String consolidateNumberOne) {
        this.consolidateNumberOne = consolidateNumberOne;
    }

    public String getConsolidateNumberTwo() {
        return consolidateNumberTwo;
    }

    public void setConsolidateNumberTwo(String consolidateNumberTwo) {
        this.consolidateNumberTwo = consolidateNumberTwo;
    }

    public String getSumApplicationType() {
        return sumApplicationType;
    }

    public void setSumApplicationType(String sumApplicationType) {
        this.sumApplicationType = sumApplicationType;
    }

    public String getSumApplicationNumber() {
        return sumApplicationNumber;
    }

    public void setSumApplicationNumber(String sumApplicationNumber) {
        this.sumApplicationNumber = sumApplicationNumber;
    }

    public List<String> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<String> departmentList) {
        this.departmentList = departmentList;
    }

    public String getConsolidationSuccessMessage() {
        return consolidationSuccessMessage;
    }

    public void setConsolidationSuccessMessage(String consolidationSuccessMessage) {
        this.consolidationSuccessMessage = consolidationSuccessMessage;
    }

    public String getCountSt() {
        return countSt;
    }

    public void setCountSt(String countSt) {
        this.countSt = countSt;
    }

    public String getSumWithNDSSpecAssert() {
        return sumWithNDSSpecAssert;
    }

    public void setSumWithNDSSpecAssert(String sumWithNDSSpecAssert) {
        this.sumWithNDSSpecAssert = sumWithNDSSpecAssert;
    }

    public String getSumWithNDS_specEditedAssert() {
        return sumWithNDS_specEditedAssert;
    }

    public void setSumWithNDS_specEditedAssert(String sumWithNDS_specEditedAssert) {
        this.sumWithNDS_specEditedAssert = sumWithNDS_specEditedAssert;
    }
}
