package test.businessTests.pharmacy;


import businessFramework.entities.pharmacy.DocsForWriteOffData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.DocsForWriteOffManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DocumentsForCancellationTest extends TestBase implements Values
{

    private DocsForWriteOffData dfwo_Data;
    private DocsForWriteOffManager dfwo_Manager;
    public int createdDocumentRow;
    public int editedDocumentRow;
    public int createdSpecRow;
    public boolean isSpecificationPage;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        dfwo_Manager = new DocsForWriteOffManager();
        dfwo_Data = new DocsForWriteOffData();


        /** Данные для выбора контекста */
        dfwo_Data.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для указания заголовка модального окна "Документ на списание" */
        dfwo_Data.setWriteOffDocModalHeader("Документ на списание");

        dfwo_Data.setDocTypeDemo("Акт сп.");        // значение на demo
        dfwo_Data.setDocTypeTest("Акт списания");   // значение на test
        dfwo_Data.setNumber(randomInt(5));
        dfwo_Data.setDate(page.getCurrentDate());
        dfwo_Data.setStore("Тестовый_склад_аптека");
        dfwo_Data.setStoreOperation("Списание из аптеки");
        dfwo_Data.setFinancingSource("test_funding_source");
        dfwo_Data.setProductGroup("Тестовая тов. группа");
        dfwo_Data.setComment(randomChar(50));

        /** Данные для указания заголовка модального окна "Документ на списание" при редактировании*/
        dfwo_Data.setWriteOffDocModalHeaderAfterEdit(String.format("Документ на списание №%s от %s", dfwo_Data.getNumber(), dfwo_Data.getDate()));

        /** Данные для редактирования данных в модальном окне "Документ на списание"*/
        dfwo_Data.setNumberAfterEdit(randomInt(4));
        dfwo_Data.setCommentAfterEdit(randomChar(51));

        /** Данные для полей на странице спецификаций в фильтре */
        dfwo_Data.setNameLS_IMN_spec("Тестовая модификация");
        dfwo_Data.setStore_spec("Тестовый_склад_аптека");
        dfwo_Data.setProductGroupSpec("Тестовая тов. группа");
        dfwo_Data.setFinancingTypeSpec("test_funding_source");

        /** Данные для полей на странице создания спецификации, в модальном окне спецификации акта документа*/
        dfwo_Data.setNameLS_IMN_sM("Тестовая модификация");
        dfwo_Data.setFinancingSource_sM("test_funding_source");
        dfwo_Data.setCount_sM("40");
        dfwo_Data.setCountMNEI_sM("40");
        dfwo_Data.setCountMNEI_sMAssert("40");
        dfwo_Data.setRestMneiQuantity("60");
        dfwo_Data.setRestQuantity("60");

        dfwo_Data.setCount_smEdited("50");
        dfwo_Data.setCountMNEI_smEdited("50");
        dfwo_Data.setCountMNEI_smEditedAssert("50");
        dfwo_Data.setSumWithNDS_smEdited("500");

        /** Данные для указания заголовка модального окна "Спецификация документа ... Добавление" */
        dfwo_Data.setAddSpecWriteOffDocModalHeader(String.format("Спецификация акта списания №%s от %s", dfwo_Data.getNumberAfterEdit(), dfwo_Data.getDate()));

        /** Данные для сообщения об успешном добавлении спецификации при создании ее в модальном окне добавления спецификации */
        dfwo_Data.setGetSuccessSpecAddMessage("Спецификация добавлена");

        /** Данные для проверки значений в столбцах в таблице "Спецификации". Не все значения здесь, тк другие берутся из других полей. */
        dfwo_Data.setPrice_st("10");
        dfwo_Data.setPrice_formatted("10.000");
        dfwo_Data.setSum_st("400.000");
        dfwo_Data.setMeasureUnit_st("at_mnei");

        /** Данные для проверки заголовка модального окна "Спецификация акта списания" ( оно открывается при нажатии кнопки "Изменить" на странице "Спецификации" в контейнере "Спецификации"*/
        dfwo_Data.setSpecificationModalHeader_AfterEdit("Спецификация акта списания");


        /** Данные для проверки значений в модальном окне "Спецификация акта списания" при открытии на редактирование (тех полей, где значение еще не проставлено было до этого) */
        dfwo_Data.setPriceUnit_sM("Втор. уп.");
        dfwo_Data.setPriceWithNDS_SpecEdit("10");
        dfwo_Data.setSumWithNDS_SpecEdit("500.00");

        dfwo_Data.setExecuteWriteOffDocModalHeader(String.format("Проводка документа: %s", dfwo_Data.getNumberAfterEdit()));
        dfwo_Data.setEditDocModalHeader(String.format("Документ на списание №%s от %s", dfwo_Data.getNumberAfterEdit(), dfwo_Data.getDate()));

        /**Данные для проверки в модальном окне Проводка спецификации*/
        dfwo_Data.setExecuteWriteOffSpecModalHeader(String.format("Проводка спецификации"));
    }

    @Test (description = "Открытие модуля 'Документы на списание'")
    public void step1_openWriteOffDocPage()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(dfwo_Data.getDepartmentForContext());
        dfwo_Manager.openDocsForWriteOff();
    }

    @Test (description = "Открытие фильтра и проверка дат в фильтре", dependsOnMethods = "step1_openWriteOffDocPage")
    public void step2_checkDateFieldsInFilter()
    {
        dfwo_Manager.getDocsForWriteOffPage().openFilterForWriteOffDocs();
        dfwo_Manager.getDocsForWriteOffPage().checkDatesValues();
    }

    @Test (description = "Создание документа на списание", dependsOnMethods = "step2_checkDateFieldsInFilter")
    public void step3_createWriteOffDocument()
    {
        dfwo_Manager.getDocsForWriteOffPage().clickAddDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().assertCountOfModals(1);
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkModalHeader(dfwo_Data.getWriteOffDocModalHeader());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().fillFields(null, dfwo_Data.getNumber(), null, dfwo_Data.getStore(), dfwo_Data.getStoreOperation(), dfwo_Data.getProductGroup(), dfwo_Data.getComment(), dfwo_Data.getFinancingSource());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkFieldsValues(dfwo_Data.getDocTypeDemo(), dfwo_Data.getDocTypeTest(), null, dfwo_Data.getDate(), null, null, null, null, null);
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().clickApplyDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertIsPresent();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertMessage(String.format("Документ на списание № %s сохранён", dfwo_Data.getNumber()));

        createdDocumentRow = dfwo_Manager.getDocsForWriteOffPage().checkTableValues(dfwo_Data.getNumber(), dfwo_Data.getDate(), dfwo_Data.getStore(), dfwo_Data.getStoreOperation(), dfwo_Data.getProductGroup());
    }

    @Test (description = "Редактирование документа на списание", dependsOnMethods = "step3_createWriteOffDocument")
    public void step4_editWriteOffDocument()
    {
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().chooseRowInTable(createdDocumentRow);
        dfwo_Manager.getDocsForWriteOffPage().clickEditDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().assertCountOfModals(1);
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkModalHeader(dfwo_Data.getWriteOffDocModalHeaderAfterEdit());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkFieldsValues(dfwo_Data.getDocTypeDemo(), dfwo_Data.getDocTypeTest(), dfwo_Data.getNumber(), dfwo_Data.getDate(), dfwo_Data.getStore(), dfwo_Data.getStoreOperation(), dfwo_Data.getFinancingSource(), dfwo_Data.getProductGroup(), dfwo_Data.getComment());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().fillFields(null, dfwo_Data.getNumberAfterEdit(), null, null, null, null, dfwo_Data.getCommentAfterEdit(), dfwo_Data.getFinancingSource());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().clickApplyDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertIsPresent();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertMessage(String.format("Документ на списание № %s сохранён", dfwo_Data.getNumberAfterEdit()));

        editedDocumentRow = dfwo_Manager.getDocsForWriteOffPage().checkTableValues(dfwo_Data.getNumberAfterEdit(), dfwo_Data.getDate(), dfwo_Data.getStore(), dfwo_Data.getStoreOperation(), dfwo_Data.getProductGroup());
    }

    @Test (description = "Просмотр документа на списание", dependsOnMethods = "step4_editWriteOffDocument")
    public void step5_viewWriteOffDocument()
    {
        dfwo_Manager.getDocsForWriteOffPage().clickEditDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().assertCountOfModals(1);
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkModalHeader(dfwo_Data.getEditDocModalHeader());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkFieldsValues(dfwo_Data.getDocTypeDemo(), dfwo_Data.getDocTypeTest(), dfwo_Data.getNumberAfterEdit(), dfwo_Data.getDate(), dfwo_Data.getStore(), dfwo_Data.getStoreOperation(), dfwo_Data.getFinancingSource(), dfwo_Data.getProductGroup(), dfwo_Data.getCommentAfterEdit());

        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().closeWriteOffDocModal();
    }

    @Test (description = "Создание спецификации", dependsOnMethods = "step5_viewWriteOffDocument")
    public void step6_specificationCreate()
    {
        dfwo_Manager.getDocsForWriteOffPage().clickAddSpecButton();
        isSpecificationPage = true;
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().checkFieldsValues(null, dfwo_Data.getStore_spec(), dfwo_Data.getProductGroupSpec(), dfwo_Data.getFinancingTypeSpec());
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().setFieldsValues(dfwo_Data.getNameLS_IMN_spec(), null, null, null);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().clickFindButton();


        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getBatchListTable().chooseRowInTable(0);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().clickAddButton();
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().assertCountOfModals(1);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkModalHeader(dfwo_Data.getAddSpecWriteOffDocModalHeader());
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkFieldsValues(dfwo_Data.getNameLS_IMN_sM(), dfwo_Data.getCreator_sM(), dfwo_Data.getFinancingSource_sM(), null, null, null, dfwo_Data.getPriceUnit_sM(), null, "0", "0");
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().fillFields(dfwo_Data.getCount_sM(), dfwo_Data.getRestQuantity());
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkFieldsValues(null, null, null, dfwo_Data.getCountMNEI_sM(), dfwo_Data.getCount_sM(), null, null, null, dfwo_Data.getRestQuantity(),dfwo_Data.getRestMneiQuantity());
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().fillFields(null, dfwo_Data.getRestQuantity());
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkFieldsValues(null, null, null, dfwo_Data.getCountMNEI_sM(), dfwo_Data.getCount_sM(), null, null, null, dfwo_Data.getRestQuantity(),dfwo_Data.getRestMneiQuantity());

        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().clickSaveSpecModalButton();


        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getBatchListTable().getAlerts().assertSuccessAlertIsPresent();
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getBatchListTable().getAlerts().assertSuccessAlertMessage(dfwo_Data.getGetSuccessSpecAddMessage());

        createdSpecRow = dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().checkTableValues(dfwo_Data.getNameLS_IMN_sM(), dfwo_Data.getCreator_sM(), dfwo_Data.getCount_sM(), dfwo_Data.getPrice_formatted(), dfwo_Data.getSum_st(), dfwo_Data.getFinancingSource_sM(), dfwo_Data.getMeasureUnit_st());
    }

    @Test (description = "Редактирование спецификации", dependsOnMethods = "step6_specificationCreate")
    public void step7_editSpecification()
    {
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getWriteOffSpecListTable().chooseRowInTable(createdSpecRow);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().clickEditSpecButton();

        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().assertCountOfModals(1);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkModalHeader(dfwo_Data.getSpecificationModalHeader_AfterEdit());
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkFieldsValues(dfwo_Data.getNameLS_IMN_sM(), dfwo_Data.getCreator_sM(), dfwo_Data.getFinancingSource_sM(), dfwo_Data.getCountMNEI_sMAssert(), null, dfwo_Data.getPriceWithNDS_SpecEdit(), dfwo_Data.getPriceUnit_sM(), dfwo_Data.getSumWithNDS_sM(), null, null);

        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().fillFields(dfwo_Data.getCount_smEdited(), null);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkFieldsValues(null, null, null, dfwo_Data.getCountMNEI_smEdited(), null, null, null, null,null, null);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().clickSaveSpecModalButton();


        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getWriteOffSpecListTable().getAlerts().assertSuccessAlertIsPresent();
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getWriteOffSpecListTable().getAlerts().assertSuccessAlertMessage(dfwo_Data.getGetSuccessSpecAddMessage());

        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getWriteOffSpecListTable().chooseRowInTable(createdSpecRow);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().clickEditSpecButton();
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().assertCountOfModals(1);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkModalHeader(dfwo_Data.getSpecificationModalHeader_AfterEdit());
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().checkFieldsValues(dfwo_Data.getNameLS_IMN_sM(), dfwo_Data.getCreator_sM(), dfwo_Data.getFinancingSource_sM(), dfwo_Data.getCountMNEI_smEditedAssert(), dfwo_Data.getCount_smEdited(), dfwo_Data.getPriceWithNDS_sM(), dfwo_Data.getPriceUnit_sM(), dfwo_Data.getSumWithNDS_smEdited(), null, null);
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().getSpecWriteOffDocModal().closeModal();
        dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().clickBackButton();
        isSpecificationPage = false;

    }

    @Test (description = "Проводка спецификации", dependsOnMethods = "step7_editSpecification")
    public void step8_executeSpecification()
    {
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffSpecListTable().chooseRowInTable(createdSpecRow);
        dfwo_Manager.getDocsForWriteOffPage().clickExecuteSpecButton();
        dfwo_Manager.getDocsForWriteOffPage().getExecuteWriteOffSpecModal().checkModalHeader(dfwo_Data.getExecuteWriteOffSpecModalHeader());
        dfwo_Manager.getDocsForWriteOffPage().getExecuteWriteOffSpecModal().clickApplyButton();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffSpecListTable().getAlerts().assertSuccessAlertIsPresent();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffSpecListTable().getAlerts().assertSuccessAlertMessage("Операция проводки завершена");
    }

    @Test (description = "Проведение документа на списание", dependsOnMethods = "step8_executeSpecification")
    public void step9_executingWriteOffDocument()
    {
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().chooseRowInTable(editedDocumentRow);
        dfwo_Manager.getDocsForWriteOffPage().clickExecuteDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getExecuteWriteOffDocModal().checkModalHeader(dfwo_Data.getExecuteWriteOffDocModalHeader());
        dfwo_Manager.getDocsForWriteOffPage().getExecuteWriteOffDocModal().clickApplyButton();


        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertIsPresent();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertMessage("Документ проведён");
    }

    @Test (description = "Копирование документа на списание", dependsOnMethods = "step9_executingWriteOffDocument")
    public void step10_copyWriteOffDocument()
    {
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().chooseRowInTable(editedDocumentRow);
        dfwo_Manager.getDocsForWriteOffPage().clickCopyDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().assertCountOfModals(1);
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkModalHeader(dfwo_Data.getWriteOffDocModalHeader());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().getDate_f().setValue(dfwo_Data.getDate());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().getStore_f().setValue(dfwo_Data.getStore());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().getStoreOperation_f().setValue(dfwo_Data.getStoreOperation());
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().getNumber_f().setValue("autotest_request_doc_copy");
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().checkFieldsValues(dfwo_Data.getDocTypeDemo(), dfwo_Data.getDocTypeTest(), null, dfwo_Data.getDate(), null, null, null, null, null);
        dfwo_Manager.getDocsForWriteOffPage().getDocumentsForWriteOffModal().clickApplyDocButton();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertIsPresent();
        dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getAlerts().assertSuccessAlertMessage(String.format("Копирование завершено. Документ на списание № %s сохранён", "autotest_request_doc_copy"));

        createdDocumentRow = dfwo_Manager.getDocsForWriteOffPage().checkTableValues("autotest_request_doc_copy", dfwo_Data.getDate(), dfwo_Data.getStore(), dfwo_Data.getStoreOperation(), "");
    }

    @Test (description = "Удаление созданных данных", dependsOnMethods = "step10_copyWriteOffDocument", alwaysRun = true)
    public void step11_removeAllCreatedRecords()
    {
        if (isSpecificationPage)
        {
            dfwo_Manager.getDocsForWriteOffPage().getSpecificationsWriteOffDocPage().clickBackButton();
        }
        {
            if (dfwo_Manager.getDocsForWriteOffPage().getCountOfModals() > 0) {
                dfwo_Manager.getDocsForWriteOffPage().getModal().closeModal();
            }

            while (dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().getCountRowsInTable(true) > 0 && !dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().assertNoRecordsReturnResult()) {
                dfwo_Manager.getDocsForWriteOffPage().getWriteOffDocsTable().chooseRowInTable(0);

                if (!dfwo_Manager.getDocsForWriteOffPage().getWriteOffSpecListTable().getColumnValues("Проведен").contains("✔")) {
                    dfwo_Manager.getDocsForWriteOffPage().clickDeleteDocButton();
                    dfwo_Manager.getDocsForWriteOffPage().getConfirmModal().clickYes();
                    page.getAlerts().assertErrorAlertAndStacktraceArePresent(false);
                } else {
                    dfwo_Manager.getDocsForWriteOffPage().clickCancelExecuteDocButton();
                    dfwo_Manager.getDocsForWriteOffPage().getConfirmModal().clickYes();
                    dfwo_Manager.getDocsForWriteOffPage().clickDeleteDocButton();
                    dfwo_Manager.getDocsForWriteOffPage().getConfirmModal().clickYes();
                    page.getAlerts().assertErrorAlertAndStacktraceArePresent(false);
                }
            }
        }
    }

}
