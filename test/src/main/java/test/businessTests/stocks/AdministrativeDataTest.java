package test.businessTests.stocks;

import businessFramework.entities.stocks.*;
import businessFramework.module.stocks.StocksManager;
import businessFramework.module.stocks.pages.bankDetails.BankDetailsContainer;
import businessFramework.module.stocks.pages.contacts.ContactsContainer;
import businessFramework.module.stocks.pages.organizationAccount.OrganizationAccountContainer;
import businessFramework.module.stocks.pages.contactPerson.ContactPersonContainer;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aisaev on 14.08.2015.
 */
public class AdministrativeDataTest extends TestBase {
    private StocksManager stocksManager;
    private MainInformationData mainInformationData;
    private MainInformationData mainInformationData2;
    private OrganizationCodesData organizationCodesData;

    private BankDetailsData bankDetailsData;
    private BankDetailsData bankDetailsData2;

    private OrganizationAccountData organizationAccountData;
    private OrganizationAccountData organizationAccountData2;
    private OrganizationAccountData organizationAccountData3;
    private OrganizationAccountData organizationAccountData4;
    private OrganizationAccountData organizationAccountData5;

    private ContactsData contactsData;
    private ContactsData contactsData2;


    private ContactPersonData contactPersonData;
    private ContactPersonData contactPersonData2;

    @BeforeClass
    public void initialize() {
        stocksManager = new StocksManager();

        mainInformationData = new MainInformationData();
        mainInformationData.setCode("11111111");
        mainInformationData.setFullName("МО для автотестов Обеспечения");
        mainInformationData.setShortName("МО для автотестов Обеспечения");
        mainInformationData.setRegDate("01.01.2015");

        mainInformationData2 = new MainInformationData();
        mainInformationData2.setCode("22222222");
        mainInformationData2.setFullName("МО для автотестов Обеспечения2");
        mainInformationData2.setShortName("МО для автотестов Обеспечения2");
        mainInformationData2.setRegDate("02.02.2015");

        organizationCodesData = new OrganizationCodesData();
        organizationCodesData.setOrgCodeType("ИНН");
        organizationCodesData.setOrgCode("111111111111");
        organizationCodesData.setOrgCodeIssueDate("01.01.2001");

        bankDetailsData = new BankDetailsData();
        bankDetailsData.setName("Тестовый расчетный счет1");
        bankDetailsData.setCheckingAccount("11111111111111111111");
        bankDetailsData.setOpenDate("01.01.2015");
        bankDetailsData.setCloseDate("01.01.2016");

        bankDetailsData2 = new BankDetailsData();
        bankDetailsData2.setName("Тестовый расчетный счет2");
        bankDetailsData2.setCheckingAccount("22222222222222222222");
        bankDetailsData2.setOpenDate("02.02.2015");
        bankDetailsData2.setCloseDate("02.02.2016");

        organizationAccountData = new OrganizationAccountData();
        organizationAccountData.setName("Тестовый лицевой счет1");
        organizationAccountData.setOpenDate("02.02.2015");
        organizationAccountData.setCloseDate("01.01.2016");
        organizationAccountData.setOrganizationAccount("11111111111111111111");
        organizationAccountData.setCheckingAccount("22222222222222222222");

        organizationAccountData2 = new OrganizationAccountData();
        organizationAccountData2.setName("Тестовый лицевой счет2");
        organizationAccountData2.setOpenDate("02.02.2015");
        organizationAccountData2.setCloseDate("31.12.2015");
        organizationAccountData2.setOrganizationAccount("22222222222222222222");
        organizationAccountData2.setCheckingAccount("22222222222222222222");

        organizationAccountData3 = new OrganizationAccountData();
        organizationAccountData3.setOpenDate("01.02.2015");
        organizationAccountData3.setCloseDate("03.02.2016");

        organizationAccountData4 = new OrganizationAccountData();
        organizationAccountData4.setOpenDate("02.02.2015");
        organizationAccountData4.setCloseDate("04.02.2016");

        organizationAccountData5 = new OrganizationAccountData();
        organizationAccountData5.setOpenDate("01.02.2015");
        organizationAccountData5.setCloseDate("04.02.2016");

        contactsData =new ContactsData();
        contactsData.setValue("12345678901");
        contactsData.setNote("тестовый контакт");
        contactsData.setContactType("Телефон");
        contactsData.setIsMain(true);


        contactsData2 =new ContactsData();
        contactsData2.setValue("22222222222");
        contactsData2.setNote("тестовый контакт2");
        contactsData2.setContactType("Телефон");
        contactsData2.setIsMain(true);


        contactPersonData= new ContactPersonData();
        contactPersonData.setName("Имя");
        contactPersonData.setPatrName("Отчество");
        contactPersonData.setSurname("Фамилия");
        contactPersonData.setPositionName("Должность");
        contactPersonData.setTelLandline("123456789");
        contactPersonData.setFax("123456789");
        contactPersonData.setGender("муж");
        contactPersonData.setSkype("скайп");
        contactPersonData.setEmail("емэйл");
        contactPersonData.setIcq(12345678);
        contactPersonData.setStartDate("01.01.2015");
        contactPersonData.setType("Главный врач");


        contactPersonData2= new ContactPersonData();
        contactPersonData2.setName("Имя2");
        contactPersonData2.setPatrName("Отчество2");
        contactPersonData2.setSurname("Фамилия2");
        contactPersonData2.setPositionName("Должность2");
        contactPersonData2.setTelLandline("1234567892");
        contactPersonData2.setFax("1234567892");
        contactPersonData2.setGender("жен");
        contactPersonData2.setSkype("скайп2");
        contactPersonData2.setEmail("емэйл2");
        contactPersonData2.setIcq(123456782);
        contactPersonData2.setStartDate("01.01.2016");

    }

    private OrganizationAccountContainer getOrgAccountContainer() {
        return stocksManager.getAdministrDataPage().getOrganizationAccountContainer();
    }

    private BankDetailsContainer getBankDetailsContainer() {
        return stocksManager.getAdministrDataPage().getBankDetailsContainer();
    }

    private ContactsContainer getContactsContainer() {
        return stocksManager.getAdministrDataPage().getContactsContainer();
    }

    private ContactPersonContainer getContactPersonContainer() {
        return stocksManager.getAdministrDataPage().getContactPersonContainer();
    }

    @Test(description = "Открытие страницы Административные данные")
    public void step1_openStocksModule() {
        stocksManager.openStocksModule();
    }

    @Test(description = "Выбор контекста", dependsOnMethods = "step1_openStocksModule")
    public void step2_chooseContext() {
        stocksManager.getAdministrDataPage().getHeader().chooseContext(mainInformationData.getShortName());
    }

    @Test(description = "Сравниваем данные", dependsOnMethods = "step2_chooseContext")
    public void step3_checkMainInformation() {
        stocksManager.getAdministrDataPage().getMainInformationContainer().compareMainInformation(mainInformationData);
    }

    @Test(description = "Изменяем данные", dependsOnMethods = "step3_checkMainInformation")
    public void step4_editMainInformation() {
        stocksManager.getAdministrDataPage().getMainInformationContainer().fill(mainInformationData2);
        stocksManager.getAdministrDataPage().getMainInformationContainer().getContainer().clickContainer();
        stocksManager.getAdministrDataPage().getMainInformationContainer().clickConfirmButton();
        stocksManager.openStocksModule();
        stocksManager.getAdministrDataPage().getMainInformationContainer().compareMainInformation(mainInformationData2);
    }

    //Тест Коды организации
    @Test(description = "Подготовка тестовых данных: удаление кода, если такой существуют", dependsOnMethods = "step4_editMainInformation")
    public void step5_delOrgCodes() {

        stocksManager.getAdministrDataPage().getOrgCodeContainer().getContainer().clickContainer();
        stocksManager.getAdministrDataPage().getOrgCodeContainer().deleteOrgCode(organizationCodesData);
    }

    @Test(description = "Открытие вкладки Коды организации", dependsOnMethods = "step5_delOrgCodes")
    public void step6_openOrgCodes() {
        stocksManager.getAdministrDataPage().getOrgCodeContainer().getContainer().clickContainer();
    }

    @Test(description = "Открытие модального окна создания кода организации", dependsOnMethods = "step6_openOrgCodes")
    public void step7_openCreateOrgCodeModal() {
        stocksManager.getAdministrDataPage().getOrgCodeContainer().clickCreateOrgCodeButton();
    }

    @Test(description = "Заполнение формы создания кода организации, проверка валидации формата кода", dependsOnMethods = "step7_openCreateOrgCodeModal")
    public void step8_fillOrgCodeForm() {
        stocksManager.getAdministrDataPage().getOrgCodeContainer().getOrgCodeModal().fillForm(organizationCodesData);
    }

    @Test(description = "Сохранение кода организации и проверка, что запись добавилась", dependsOnMethods = "step8_fillOrgCodeForm")
    public void step9_saveOrgCodeForm() {
        stocksManager.getAdministrDataPage().getOrgCodeContainer().getOrgCodeModal().clickConfirmButton();
        Map<String, String> map = new HashMap<>();
        map.put("Значение", organizationCodesData.getOrgCode());
        map.put("Тип кода", organizationCodesData.getOrgCodeType());
        stocksManager.getAdministrDataPage().getOrgCodeContainer().getTable().chooseRowBySeveralColumnValues(map);
    }

    @Test(description = "Сохранение идентичного кода организации и проверка, что сработала валидация", dependsOnMethods = "step9_saveOrgCodeForm")
    public void step10_saveSameOrgCodeForm() {
        step7_openCreateOrgCodeModal();
        step8_fillOrgCodeForm();
        stocksManager.getAdministrDataPage().getOrgCodeContainer().getOrgCodeModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        stocksManager.getAdministrDataPage().getModal().closeModal();
    }

    @Test(description = "Удаление кода организации", dependsOnMethods = "step10_saveSameOrgCodeForm")
    public void step11_deleteOrgCodeForm() {
        stocksManager.getAdministrDataPage().getOrgCodeContainer().deleteOrgCode(organizationCodesData);
    }


    //Тест Банковские реквизиты и Лицевые счета
    @Test(description = "Подготовка тестовых данных: удаление расчетного счета если такой существуют", dependsOnMethods = "step11_deleteOrgCodeForm")
    public void step12_delBankDetails() {
        getOrgAccountContainer().getContainerOrganizationAccount().clickContainer();
        getOrgAccountContainer().deleteOrganizationAccountIfExist(organizationAccountData);
        getOrgAccountContainer().getContainerOrganizationAccount().clickContainer();
        getOrgAccountContainer().deleteOrganizationAccountIfExist(organizationAccountData2);

        getBankDetailsContainer().getContainerBankDetails().clickContainer();
        getBankDetailsContainer().deleteBankDetailIfExist(bankDetailsData);
        getBankDetailsContainer().getContainerBankDetails().clickContainer();
        getBankDetailsContainer().deleteBankDetailIfExist(bankDetailsData2);
    }

    @Test(description = "Открытие вкладки Банковские реквизиты", dependsOnMethods = "step12_delBankDetails")
    public void step13_openBankDetail() {
        getBankDetailsContainer().getContainerBankDetails().clickContainer();
    }

    @Test(description = "Открытие модального окна создания банковского реквизиты", dependsOnMethods = "step13_openBankDetail")
    public void step14_openCreateBankDetailModal() {
        getBankDetailsContainer().clickCreateBankDetailsButton();
    }

    @Test(description = "Заполнение формы создания расчетного счета", dependsOnMethods = "step14_openCreateBankDetailModal")
    public void step15_fillBankDetailForm() {
        getBankDetailsContainer().getBankDetailsModal().clickBank();
        getBankDetailsContainer().getBankRefbookModal().chooseFirstRowInTable();
        getBankDetailsContainer().getBankRefbookModal().clickChooseButton();
        getBankDetailsContainer().getBankDetailsModal().fillForm(bankDetailsData);
    }

    @Test(description = "Сохранение расчетного счета и проверка что запись добавилась", dependsOnMethods = "step15_fillBankDetailForm")
    public void step16_saveBankDetailForm() {
        getBankDetailsContainer().getBankDetailsModal().clickConfirmButton();
        getBankDetailsContainer().findBankDetail(bankDetailsData);
    }

    @Test(description = "Сохранение идентичного расчетного счета и проверка, что сработала валидация", dependsOnMethods = "step16_saveBankDetailForm")
    public void step17_saveSameBankDetailForm() {
        step14_openCreateBankDetailModal();
        step15_fillBankDetailForm();
        getBankDetailsContainer().getBankDetailsModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        stocksManager.getAdministrDataPage().getModal().closeModal();
    }

    @Test(description = "Изменение расчетного счета", dependsOnMethods = "step17_saveSameBankDetailForm")
    public void step18_editBankDetailForm() {
        getBankDetailsContainer().clickUpdateBankDetailButton();
        getBankDetailsContainer().getBankDetailsModal().fillForm(bankDetailsData2);
        getBankDetailsContainer().getBankDetailsModal().clickConfirmButton();
        getBankDetailsContainer().findBankDetail(bankDetailsData2);
    }

    @Test(description = "Открытие вкладки Лицевые счета", dependsOnMethods = "step18_editBankDetailForm")
    public void step19_openOrganizationAccount() {
        step1_openStocksModule();
        getOrgAccountContainer().getContainerOrganizationAccount().clickContainer();
    }

    @Test(description = "Открытие модального окна создания Лицевого счета", dependsOnMethods = "step19_openOrganizationAccount")
    public void step20_openCreateOrganizationAccountModal() {
        getOrgAccountContainer().clickCreateOrganizationAccountButton();
    }

    @Test(description = "Заполнение формы создания Лицевого счета", dependsOnMethods = "step20_openCreateOrganizationAccountModal")
    public void step21_fillOrganizationAccountForm() {
        stocksManager.getAdministrDataPage();
        getOrgAccountContainer().getOrganizationAccountModal().fillForm(organizationAccountData);
    }

    @Test(description = "Сохранение Лицевого счета и проверка, что запись добавилась", dependsOnMethods = "step21_fillOrganizationAccountForm")
    public void step22_saveOrganizationAccountForm() {
        getOrgAccountContainer().getOrganizationAccountModal().clickConfirmButton();
        getOrgAccountContainer().findOrganizationAccount(organizationAccountData);
    }

    @Test(description = "Сохранение идентичного Лицевого счета и проверка, что сработала валидация", dependsOnMethods = "step22_saveOrganizationAccountForm")
    public void step23_saveSameOrganizationAccountForm() {
        step20_openCreateOrganizationAccountModal();
        step21_fillOrganizationAccountForm();
        getOrgAccountContainer().getOrganizationAccountModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        stocksManager.getAdministrDataPage().getModal().closeModal();
    }

    @Test(description = "Изменение даты открытия и закрытия Лицевого счета для  проверка валидаций", dependsOnMethods = "step23_saveSameOrganizationAccountForm")
    public void step24_checkPeriodsValidation() {
        getOrgAccountContainer().getContainerOrganizationAccount().clickContainer();
        getOrgAccountContainer().clickUpdateOrganizationAccountButton();
        getOrgAccountContainer().getOrganizationAccountModal().fillForm(organizationAccountData3);
        getOrgAccountContainer().getOrganizationAccountModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        getOrgAccountContainer().getOrganizationAccountModal().fillForm(organizationAccountData4);
        getOrgAccountContainer().getOrganizationAccountModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        getOrgAccountContainer().getOrganizationAccountModal().fillForm(organizationAccountData5);
        getOrgAccountContainer().getOrganizationAccountModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        stocksManager.getAdministrDataPage().getModal().closeModal();
    }

    @Test(description = "Изменение Лицевого счета и проверка что запись добавилась", dependsOnMethods = "step24_checkPeriodsValidation")
    public void step25_editOrganizationAccountForm() {
        getOrgAccountContainer().clickUpdateOrganizationAccountButton();
        getOrgAccountContainer().getOrganizationAccountModal().fillForm(organizationAccountData2);
        getOrgAccountContainer().getOrganizationAccountModal().clickConfirmButton();
        getOrgAccountContainer().findOrganizationAccount(organizationAccountData2);
    }

    @Test(description = "Удаление Лицевого счета", dependsOnMethods = "step25_editOrganizationAccountForm")
    public void step26_deleteOrganizationAccountForm() {
        getOrgAccountContainer().deleteOrganizationAccountIfExist(organizationAccountData2);
    }


    @Test(description = "Удаление расчетного счета", dependsOnMethods = "step26_deleteOrganizationAccountForm")
    public void step27_deleteBankDetailForm() {
        getBankDetailsContainer().getContainerBankDetails().clickContainer();
        getBankDetailsContainer().deleteBankDetailIfExist(bankDetailsData2);
    }


    //Контакты
    @Test(description = "Открытие вкладки Контакты", dependsOnMethods = "step27_deleteBankDetailForm")
    public void step28_openContacts() {
        step1_openStocksModule();
        getContactsContainer().getContainerContacts().clickContainer();
    }

    @Test(description = "Подготовка тестовых данных: удаление контакта, если такой существуют", dependsOnMethods = "step28_openContacts")
    public void step29_delOrgContacts() {
        getContactsContainer().getContainerContacts().clickContainer();
        getContactsContainer().deleteContactsIfExist(contactsData);
        getContactsContainer().deleteContactsIfExist(contactsData2);
    }

    @Test(description = "Открытие модального окна создания контакта", dependsOnMethods = "step29_delOrgContacts")
    public void step30_openCreateContactsModal() {
        getContactsContainer().clickCreateContactsButton();
    }

    @Test(description = "Заполнение формы создания контакта", dependsOnMethods = "step30_openCreateContactsModal")
    public void step31_fillContactForm() {
        stocksManager.getAdministrDataPage();
        getContactsContainer().getContactsModal().fillForm(contactsData);
    }

    @Test(description = "Сохранение контакта и проверка, что запись добавилась", dependsOnMethods = "step31_fillContactForm")
    public void step32_saveContactForm() {
        getContactsContainer().getContactsModal().clickConfirmButton();
        getContactsContainer().findContacts(contactsData);
    }

    @Test(description = "Сохранение идентичного расчетного счета и проверка, что сработала валидация", dependsOnMethods = "step32_saveContactForm")
    public void step33_saveSameContactForm() {
        step30_openCreateContactsModal();
        step31_fillContactForm();
        getContactsContainer().getContactsModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        stocksManager.getAdministrDataPage().getModal().closeModal();
    }

    @Test(description = "Изменение контакта и проверка что запись добавилась", dependsOnMethods = "step33_saveSameContactForm")
    public void step34_editContactForm() {
        getContactsContainer().clickUpdateContactsButton();
        getContactsContainer().getContactsModal().fillForm(contactsData2);
        getContactsContainer().getContactsModal().clickConfirmButton();
        getContactsContainer().findContacts(contactsData2);
    }

    @Test(description = "Удаление контакта", dependsOnMethods = "step34_editContactForm")
    public void step35_deleteContactForm() {
        getContactsContainer().deleteContactsIfExist(contactsData2);
    }




    //Персоналии
    @Test(description = "Открытие вкладки Персоналии", dependsOnMethods = "step35_deleteContactForm")
    public void step28_openContactPerson() {
        stocksManager.openStocksModule();
        getContactPersonContainer().getContainerContactPerson().clickContainer();
    }

    @Test(description = "Подготовка тестовых данных: удаление Должностного лица, если такой существуют", dependsOnMethods = "step28_openContactPerson")
    public void step29_delContactPerson() {
        getContactPersonContainer().getContainerContactPerson().clickContainer();
        getContactPersonContainer().deleteContactPersonIfExist(contactPersonData);
        getContactPersonContainer().deleteContactPersonIfExist(contactPersonData2);
    }

    @Test(description = "Открытие модального окна создания Должностного лица", dependsOnMethods = "step29_delContactPerson")
    public void step30_openCreateContactPersonModal() {
        getContactPersonContainer().clickCreateContactPersonButton();
    }

    @Test(description = "Заполнение формы создания Должностного лица", dependsOnMethods = "step30_openCreateContactPersonModal")
    public void step31_fillContactPersonForm() {

        getContactPersonContainer().getContactPersonModal().fillForm(contactPersonData);
    }

    @Test(description = "Сохранение Должностного лица и проверка, что запись добавилась", dependsOnMethods = "step31_fillContactPersonForm")
    public void step32_saveContactPersonForm() {
        getContactPersonContainer().getContactPersonModal().clickConfirmButton();
        getContactPersonContainer().findContactPerson(contactPersonData);
    }

    @Test(description = "Сохранение идентичного Должностного лица и проверка, что сработала валидация", dependsOnMethods = "step32_saveContactPersonForm")
    public void step33_saveSameContactPersonForm() {
        step30_openCreateContactPersonModal();
        step31_fillContactPersonForm();
        getContactPersonContainer().getContactPersonModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        stocksManager.getAdministrDataPage().getModal().closeModal();
    }

    @Test(description = "Изменение Должностного лица и проверка что запись добавилась", dependsOnMethods = "step33_saveSameContactPersonForm")
    public void step34_editContactPersonForm() {
        getContactPersonContainer().clickUpdateContactPersonButton();
        getContactPersonContainer().getContactPersonModal().fillForm(contactPersonData2);
        getContactPersonContainer().getContactPersonModal().clickConfirmButton();
        getContactPersonContainer().findContactPerson(contactPersonData2);
    }

    @Test(description = "Удаление Должностного лица", dependsOnMethods = "step34_editContactPersonForm")
    public void step35_deleteContactPersonForm() {
        getContactPersonContainer().deleteContactPersonIfExist(contactPersonData2);
    }




}
