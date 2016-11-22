package businessFramework.module.pharmacy;

import businessFramework.module.pharmacy.pages.arrivalInvoice.ArrivalInvoicePage;
import businessFramework.module.pharmacy.pages.contracts.ContractsPage;
import businessFramework.module.pharmacy.pages.formulaDocument.FormulaDocumentPage;
import businessFramework.module.pharmacy.pages.productionDoc.ProductionDocListPage;
import businessFramework.module.pharmacy.pages.refbooks.holding.HoldingListPage;
import businessFramework.module.pharmacy.pages.refbooks.holding.forOrg.HoldingForOrgListPage;
import businessFramework.module.pharmacy.pages.refbooks.holding.regional.RegionalHoldingListPage;
import businessFramework.module.pharmacy.pages.refbooks.procurementMethod.ProcurementMethodListPage;
import businessFramework.module.pharmacy.pages.refbooks.storeList.StoreListPage;
import businessFramework.module.pharmacy.pages.refbooks.writeOffReason.WriteOffReasonPage;
import businessFramework.module.pharmacy.pages.requestSpecifications.RequestSpecificationsPage;
import businessFramework.module.pharmacy.pages.requests.RequestsPage;
import businessFramework.module.pharmacy.pages.returnDoc.ReturnDocsPage;
import businessFramework.module.pharmacy.pages.transferAct.TransferActPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;


public class PharmacyManager
{
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * @return Получение страницы "Расходные накладные"
     */
    public TransferActPage getTransferActPage()
    {
        return new TransferActPage(app);
    }
    /**
     * @return получение страницы "Возвратные документы"
     */
    public ReturnDocsPage getReturnDocsPage(){return new ReturnDocsPage(app);}

    /**
     * @return Получение страницы "Контракты"
     */
    public ContractsPage getContractsPage()
    {
        return new ContractsPage(app);
    }

    /**
     * @return Получение страницы "Спецификации"
     */
    public RequestSpecificationsPage getSpecificationsPage()
    {
        return new RequestSpecificationsPage(app);
    }

    /**
     * @return Получение страницы "Требования"
     */
    public RequestsPage getRequestsPage()
    {
        return new RequestsPage(app);
    }

    /**
     * @return Получение страницы "Приходные накладные"
     */
    public ArrivalInvoicePage getArrivalInvoicePage()
    {
        return new ArrivalInvoicePage(app);
    }

    /**
     * Открытие модуля "Аптека"
     */
    public void openPharmacyModule()
    {
        app.getNavigationHelper().openPageWithModule("modules.inventory");
    }

    /**
     * Открытие страницы "Расходные накладные"
     */
    public void openTransferAct() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.transferActList");
    }

    /**
     * Открытие страницы "Возвратные документы"
     */
    public void openReturnDocs() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.returnDocumentList");
    }

    /**
     * Открытие страницы "Контракты"
     */
    public void openContracts()
    {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.finContractList");
    }

    /**
     * Открытие страницы "Требования"
     */
    public void openRequests()
    {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.requestDocList");
    }

    /**
     * Открытие страницы "Приходные накладные"
     */
    public void openArrivalInvoices()
    {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.arrivalInvoiceList");
    }

    /**Справочники*/

    /**
     * @return Получение страницы "Номенклатор"
     */
    public HoldingListPage getHoldingListPage()
    {
        return new HoldingListPage(app);
    }

    /**
     * @return Получение страницы "Региональный номенклатор"
     */
    public RegionalHoldingListPage getRegionalHoldingListPage()
    {
        return new RegionalHoldingListPage(app);
    }


    /**
     * @return Получение страницы "Номенклатор МО"
     */
    public HoldingForOrgListPage getHoldingForOrgListPage()
    {
        return new HoldingForOrgListPage(app);
    }

    /**
     * Открытие страницы "Справочники-Номенклатор"
     */
    public void openHoldingRefbook() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Справочники", "inventory.holdingList");
    }

    /**
     * Открытие страницы "Справочники-Региональный номенклатор"
     */
    public void openRegionalHoldingRefbook() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Справочники", "inventory.regionalHoldingList");
    }

    /**
     * Открытие страницы "Справочники-Номенклатор МО"
     */
    public void openHoldingForOrgRefbook() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Справочники", "inventory.holdingForOrgList");
    }


    /**
     * @return Получение страницы "Склады"
     */
    public StoreListPage getStoreListPage() {
        return new StoreListPage(app);
    }

    /**
     * Открытие страницы "Справочники-Склады"
     */
    public void openStoreRefbook() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Справочники", "inventory.storeList");
    }

    /**
     * Открытие страницы "Прописи"
     */
    public void openFormulaDocuments()
    {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Производство", "inventory.formulaDocumentList");
    }

    /**
     * @return Получение страницы "Прописи"
     */
    public FormulaDocumentPage getFormulaDocumentPage()
    {
        return new FormulaDocumentPage(app);
    }

    /**
     * Открытие страницы "Документы на изготовление"
     */
    public void openProductionDocuments()
    {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Производство", "inventory.productionDocList");
    }

    /**
     * @return Получение страницы "Документы на изготовление"
     */
    public ProductionDocListPage getProductionDocumentPage()
    {
        return new ProductionDocListPage(app);
    }

    /**
     * @return Получение страницы "Причины списания"
     */
    public WriteOffReasonPage getWriteOffReasonListPage() {
        return new WriteOffReasonPage(app);
    }

    /**
     * Открытие страницы "Справочники - причины списания"
     */
    public void openWriteOffReasonListPage()
    {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Справочники", "inventory.writeOffReasonList");
    }

    /**
     * Открытие страницы "Справочники-Способы закупки"
     */
    public void openProcurementMethodRefbook() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Справочники", "inventory.procurementMethodList");
    }

    /**
     * Страницы "Справочники-Способы закупки"
     */
    public ProcurementMethodListPage getProcurementMethodRefbookPage() {
        return new ProcurementMethodListPage(app);
    }
}