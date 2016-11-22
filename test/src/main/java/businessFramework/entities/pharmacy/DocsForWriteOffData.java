package businessFramework.entities.pharmacy;



public class DocsForWriteOffData
{

    /** Данные для выбора контекста */
    private String departmentForContext;

    /** Данные для указания заголовка модального окна "Документ на списание" */
    private String WriteOffDocModalHeader;

    /** Данные для указания заголовка модального окна "Спецификация документа ... Добавление" */
    private String AddSpecWriteOffDocModalHeader;

    /** Данные для указания значений в полях в модальном окне "Документ на списание" */
    private String docTypeDemo;
    private String docTypeTest;
    private String number;
    private String date;
    private String store;
    private String storeOperation;
    private String financingSource;
    private String productGroup;
    private String comment;
    private String restMneiQuantity;
    private String restQuantity;

    /** Данные для указания заголовка модального окна "Документ на списание" при редактировании */
    private String WriteOffDocModalHeaderAfterEdit;

    /** Данные для редактирования данных в модальном окне "Документ на списание" */
    private String numberAfterEdit;
    private String commentAfterEdit;

    /** Данные для полей на странице спецификаций в фильтре */
    private String nameLS_IMN_spec;
    private String store_spec;
    private String productGroupSpec;
    private String financingTypeSpec;

    /** Данные для полей на странице создания спецификации, в модальном окне спецификации акта документа*/
    private String nameLS_IMN_sM;
    private String creator_sM;
    private String priceWithNDS_sM;
    private String priceUnit_sM;
    private String sumWithNDS_sM;
    private String financingSource_sM;
    private String comment_sM;
    private String count_sM;
    private String countMNEI_sM;
    private String countMNEI_sMAssert;
    private String actualBalance_sM;
    private String actualBalanceMNEI_sM;

    /** Данные для сообщения об успешном добавлении спецификации при создании ее в модальном окне добавления спецификации */
    private String getSuccessSpecAddMessage;

    /** Данные для проверки значений в столбцах в таблице "Спецификации". Не все значения здесь, тк другие берутся из других полей. */
    private String measureUnit_st;
    private String price_st;
    private String price_formatted;
    private String sum_st;

    /** Данные для проверки заголовка модального окна "Спецификация акта списания" ( оно открывается при нажатии кнопки "Изменить" на странице "Спецификации" в контейнере "Спецификации"*/
    private String specificationModalHeader_AfterEdit;
    private String priceWithNDS_SpecEdit;
    private String sumWithNDS_SpecEdit;

    /** Данные для проверки измененных значений в полях "Количество" и "Количество в МНЕИ"  и "Сумма с НДС (руб.)" при проверке после редактирования созданной спецификации */
    private String count_smEdited;
    private String countMNEI_smEdited;
    private String countMNEI_smEditedAssert;
    private String sumWithNDS_smEdited;

    /** Данные для проверки заголовка модального окна "Проводка документа"*/
    private String executeWriteOffDocModalHeader;

    /** Заголовок модального окна "Редактирование документа на списание" */
    private String editDocModalHeader;

    /** Данные для проверки заголовка модального окна "Проводка спецификации"*/
    private String executeWriteOffSpecModalHeader;

    public String getExecuteWriteOffSpecModalHeader() {
        return executeWriteOffSpecModalHeader;
    }

    public void setExecuteWriteOffSpecModalHeader(String executeWriteOffSpecModalHeader) {
        this.executeWriteOffSpecModalHeader = executeWriteOffSpecModalHeader;
    }

    public String getEditDocModalHeader()
    {
        return editDocModalHeader;
    }

    public void setEditDocModalHeader(String editDocModalHeader)
    {
        this.editDocModalHeader = editDocModalHeader;
    }

    public String getDocTypeTest()
    {
        return docTypeTest;
    }

    public void setDocTypeTest(String docTypeTest)
    {
        this.docTypeTest = docTypeTest;
    }

    public String getExecuteWriteOffDocModalHeader()
    {
        return executeWriteOffDocModalHeader;
    }

    public void setExecuteWriteOffDocModalHeader(String executeWriteOffDocModalHeader)
    {
        this.executeWriteOffDocModalHeader = executeWriteOffDocModalHeader;
    }

    public String getSumWithNDS_smEdited()
    {
        return sumWithNDS_smEdited;
    }

    public void setSumWithNDS_smEdited(String sumWithNDS_smEdited)
    {
        this.sumWithNDS_smEdited = sumWithNDS_smEdited;
    }

    public String getCount_smEdited()
    {
        return count_smEdited;
    }

    public void setCount_smEdited(String count_smEdited)
    {
        this.count_smEdited = count_smEdited;
    }

    public String getCountMNEI_smEdited()
    {
        return countMNEI_smEdited;
    }

    public void setCountMNEI_smEdited(String countMNEI_smEdited)
    {
        this.countMNEI_smEdited = countMNEI_smEdited;
    }

    public String getPriceWithNDS_SpecEdit()
    {
        return priceWithNDS_SpecEdit;
    }

    public void setPriceWithNDS_SpecEdit(String priceWithNDS_SpecEdit)
    {
        this.priceWithNDS_SpecEdit = priceWithNDS_SpecEdit;
    }

    public String getSumWithNDS_SpecEdit()
    {
        return sumWithNDS_SpecEdit;
    }

    public void setSumWithNDS_SpecEdit(String sumWithNDS_SpecEdit)
    {
        this.sumWithNDS_SpecEdit = sumWithNDS_SpecEdit;
    }

    public String getSpecificationModalHeader_AfterEdit()
    {
        return specificationModalHeader_AfterEdit;
    }

    public void setSpecificationModalHeader_AfterEdit(String specificationModalHeader_AfterEdit)
    {
        this.specificationModalHeader_AfterEdit = specificationModalHeader_AfterEdit;
    }

    public String getMeasureUnit_st()
    {
        return measureUnit_st;
    }

    public void setMeasureUnit_st(String measureUnit_st)
    {
        this.measureUnit_st = measureUnit_st;
    }

    public String getPrice_st()
    {
        return price_st;
    }

    public void setPrice_st(String price_st)
    {
        this.price_st = price_st;
    }

    public String getSum_st()
    {
        return sum_st;
    }

    public void setSum_st(String sum_st)
    {
        this.sum_st = sum_st;
    }

    public String getGetSuccessSpecAddMessage()
    {
        return getSuccessSpecAddMessage;
    }

    public void setGetSuccessSpecAddMessage(String getSuccessSpecAddMessage)
    {
        this.getSuccessSpecAddMessage = getSuccessSpecAddMessage;
    }

    public String getAddSpecWriteOffDocModalHeader()
    {
        return AddSpecWriteOffDocModalHeader;
    }

    public void setAddSpecWriteOffDocModalHeader(String addSpecWriteOffDocModalHeader)
    {
        AddSpecWriteOffDocModalHeader = addSpecWriteOffDocModalHeader;
    }

    public String getNameLS_IMN_sM()
    {
        return nameLS_IMN_sM;
    }

    public void setNameLS_IMN_sM(String nameLS_IMN_sM)
    {
        this.nameLS_IMN_sM = nameLS_IMN_sM;
    }

    public String getCreator_sM()
    {
        return creator_sM;
    }

    public void setCreator_sM(String creator_sM)
    {
        this.creator_sM = creator_sM;
    }

    public String getPriceWithNDS_sM()
    {
        return priceWithNDS_sM;
    }

    public void setPriceWithNDS_sM(String priceWithNDS_sM)
    {
        this.priceWithNDS_sM = priceWithNDS_sM;
    }

    public String getPriceUnit_sM()
    {
        return priceUnit_sM;
    }

    public void setPriceUnit_sM(String priceUnit_sM)
    {
        this.priceUnit_sM = priceUnit_sM;
    }

    public String getSumWithNDS_sM()
    {
        return sumWithNDS_sM;
    }

    public void setSumWithNDS_sM(String sumWithNDS_sM)
    {
        this.sumWithNDS_sM = sumWithNDS_sM;
    }

    public String getFinancingSource_sM()
    {
        return financingSource_sM;
    }

    public void setFinancingSource_sM(String financingSource_sM)
    {
        this.financingSource_sM = financingSource_sM;
    }

    public String getComment_sM()
    {
        return comment_sM;
    }

    public void setComment_sM(String comment_sM)
    {
        this.comment_sM = comment_sM;
    }

    public String getCount_sM()
    {
        return count_sM;
    }

    public void setCount_sM(String count_sM)
    {
        this.count_sM = count_sM;
    }

    public String getCountMNEI_sM()
    {
        return countMNEI_sM;
    }

    public void setCountMNEI_sM(String countMNEI_sM)
    {
        this.countMNEI_sM = countMNEI_sM;
    }

    public String getActualBalance_sM()
    {
        return actualBalance_sM;
    }

    public void setActualBalance_sM(String actualBalance_sM)
    {
        this.actualBalance_sM = actualBalance_sM;
    }

    public String getActualBalanceMNEI_sM()
    {
        return actualBalanceMNEI_sM;
    }

    public void setActualBalanceMNEI_sM(String actualBalanceMNEI_sM)
    {
        this.actualBalanceMNEI_sM = actualBalanceMNEI_sM;
    }

    public String getNameLS_IMN_spec()
    {
        return nameLS_IMN_spec;
    }

    public void setNameLS_IMN_spec(String nameLS_IMN_spec)
    {
        this.nameLS_IMN_spec = nameLS_IMN_spec;
    }

    public String getStore_spec()
    {
        return store_spec;
    }

    public void setStore_spec(String store_spec)
    {
        this.store_spec = store_spec;
    }

    public String getProductGroupSpec()
    {
        return productGroupSpec;
    }

    public void setProductGroupSpec(String productGroupSpec)
    {
        this.productGroupSpec = productGroupSpec;
    }

    public String getFinancingTypeSpec()
    {
        return financingTypeSpec;
    }

    public void setFinancingTypeSpec(String financingTypeSpec)
    {
        this.financingTypeSpec = financingTypeSpec;
    }


    public String getNumberAfterEdit()
    {
        return numberAfterEdit;
    }

    public void setNumberAfterEdit(String numberAfterEdit)
    {
        this.numberAfterEdit = numberAfterEdit;
    }

    public String getCommentAfterEdit()
    {
        return commentAfterEdit;
    }

    public void setCommentAfterEdit(String commentAfterEdit)
    {
        this.commentAfterEdit = commentAfterEdit;
    }

    public String getWriteOffDocModalHeaderAfterEdit()
    {
        return WriteOffDocModalHeaderAfterEdit;
    }

    public void setWriteOffDocModalHeaderAfterEdit(String writeOffDocModalHeaderAfterEdit)
    {
        WriteOffDocModalHeaderAfterEdit = writeOffDocModalHeaderAfterEdit;
    }

    public String getDocTypeDemo()
    {
        return docTypeDemo;
    }

    public void setDocTypeDemo(String docTypeDemo)
    {
        this.docTypeDemo = docTypeDemo;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getStore()
    {
        return store;
    }

    public void setStore(String store)
    {
        this.store = store;
    }

    public String getStoreOperation()
    {
        return storeOperation;
    }

    public void setStoreOperation(String storeOperation)
    {
        this.storeOperation = storeOperation;
    }

    public String getFinancingSource()
    {
        return financingSource;
    }

    public void setFinancingSource(String financingSource)
    {
        this.financingSource = financingSource;
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

    public String getWriteOffDocModalHeader()
    {
        return WriteOffDocModalHeader;
    }

    public void setWriteOffDocModalHeader(String writeOffDocModalHeader)
    {
        WriteOffDocModalHeader = writeOffDocModalHeader;
    }

    public String getDepartmentForContext()
    {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext)
    {
        this.departmentForContext = departmentForContext;
    }

    public String getRestMneiQuantity() {
        return restMneiQuantity;
    }

    public void setRestMneiQuantity(String restMneiQuantity) {
        this.restMneiQuantity = restMneiQuantity;
    }

    public String getRestQuantity() {
        return restQuantity;
    }

    public void setRestQuantity(String restQuantity) {
        this.restQuantity = restQuantity;
    }

    public String getPrice_formatted() {
        return price_formatted;
    }

    public void setPrice_formatted(String price_formatted) {
        this.price_formatted = price_formatted;
    }

    public String getCountMNEI_sMAssert() {
        return countMNEI_sMAssert;
    }

    public void setCountMNEI_sMAssert(String countMNEI_sMAssert) {
        this.countMNEI_sMAssert = countMNEI_sMAssert;
    }

    public String getCountMNEI_smEditedAssert() {
        return countMNEI_smEditedAssert;
    }

    public void setCountMNEI_smEditedAssert(String countMNEI_smEditedAssert) {
        this.countMNEI_smEditedAssert = countMNEI_smEditedAssert;
    }
}
