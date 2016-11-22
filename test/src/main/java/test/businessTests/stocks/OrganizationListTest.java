package test.businessTests.stocks;

import businessFramework.entities.stocks.OrganizationData;
import businessFramework.module.stocks.OrganisationsListManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationListTest extends TestBase {


    private OrganisationsListManager organisationsListManager;
    private OrganizationData organizationData;
    private OrganizationData organizationData2;
    private String context;

    @BeforeClass
    public void initialize()
    {
        context="Ключ доступа для автотестов Медицинские организации";
        organisationsListManager = new OrganisationsListManager();
        organizationData =new OrganizationData();
        organizationData.setCode("Тестовый код");
        organizationData.setFullName("Тестовая МО Полное наименование");
        organizationData.setShortName("Тестовая МО Краткое наименование");
        organizationData.setParentOrg("Контрольная");
        organizationData.setRegDate("01.01.2015");

        organizationData2 =new OrganizationData();
        organizationData2.setCode("Тестовый код2");
        organizationData2.setFullName("Тестовая МО Полное наименование2");
        organizationData2.setShortName("Тестовая МО Краткое наименование2");

    }

    @Test (description = "Подготовка тестовых данных: удаление организации, если такая существует")
    public void beforeTest(){
        organisationsListManager.openMainPage();
        organisationsListManager.chooseContext(context);
        organisationsListManager.openOrganisationList();
        organisationsListManager.getOrganizationsListPage().getOrganizationsListContainer();
        organisationsListManager.getOrganizationsListPage().deleteOrganizationByFilter(organizationData);
        organisationsListManager.getOrganizationsListPage().deleteOrganizationByFilter(organizationData2);
    }

    @Test(description = "Открытие страницы Список организаций", dependsOnMethods = "beforeTest")
    public void step1_openOrganisationListModule()
    {
        organisationsListManager.openOrganisationList();
    }

    @Test(description = "Открытие модального окна создания организации", dependsOnMethods = "step1_openOrganisationListModule")
    public void step2_openCreateOrgModal()
    {
        organisationsListManager.getOrganizationsListPage().getCreateOrgButton().click();
    }

    @Test(description = "Заполнение формы создания организации", dependsOnMethods = "step2_openCreateOrgModal")
    public void step3_fillOrgForm()
    {
        organisationsListManager.getOrganizationsListPage().getOrgModal().fillForm(organizationData);
    }

    @Test(description = "Сохранение  организации и проверка что запись добавилась", dependsOnMethods = "step3_fillOrgForm")
    public void step4_saveOrgForm()
    {
        organisationsListManager.getOrganizationsListPage().getOrgModal().clickConfirmButton();
        organisationsListManager.getOrganizationsListPage().findOrganization(organizationData);
        organisationsListManager.getOrganizationsListPage().getTable().assertThatTableContainsOnlyXRows(1);
    }


    @Test(description = "Сохранение идентичной  организации и проверка что сработала валидация", dependsOnMethods = "step4_saveOrgForm")
    public void step5_saveSameOrgForm()
    {
        step2_openCreateOrgModal();
        step3_fillOrgForm();
        organisationsListManager.getOrganizationsListPage().getOrgModal().clickConfirmButton();
        page.getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(true);
        organisationsListManager.getOrganizationsListPage().getModal().closeModal();
    }


    @Test(description = "Изменение данных организации и проверка что запись добавилась", dependsOnMethods = "step5_saveSameOrgForm")
    public void step6_editOrgForm()
    {
        organisationsListManager.getOrganizationsListPage().getUpdateOrgButton().click();
        organisationsListManager.getOrganizationsListPage().getOrgModal().fillForm(organizationData2);
        organisationsListManager.getOrganizationsListPage().getOrgModal().clickConfirmButton();
        organisationsListManager.getOrganizationsListPage().findOrganization(organizationData2);
        organisationsListManager.getOrganizationsListPage().getTable().assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Удаление организации", dependsOnMethods = "step6_editOrgForm")
    public void step7_deleteOrgForm()
    {
        organisationsListManager.getOrganizationsListPage().deleteOrganizationByFilter(organizationData2);
    }

}
