package businessFramework.module.pharmacy.pages.refbooks.holding;

import businessFramework.entities.pharmacy.HoldingProducerData;
import businessFramework.entities.pharmacy.ModifData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.Holding.HoldingModal;
import businessFramework.module.pharmacy.modals.Modification.ModifMaxDosesModal;
import businessFramework.module.pharmacy.modals.Modification.ModifModal;
import businessFramework.module.pharmacy.modals.holdingProducer.HoldingProducerModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ydolgih
 * @since 28.05.2015
 */
public class HoldingListPage extends HoldingListHelper implements Values
{
    public HoldingListPage(ApplicationManager app)
    {
        super(app);
    }

    /* -------------------- Кнопки в контейнере "Номенклатура" ------------------------- */

    /**
     * Нажатие на кнопку "Добавить"
     */
    public void clickCreateHolding()
    {
        Button createHoldingButton = getCreateHoldingButton();
        createHoldingButton.assertIsEnabled();
        createHoldingButton.click();
    }

    /**
     * Нажатие на кнопку "Изменить"
     */
    public void clickEditHolding()
    {
        Button editHoldingButton = getEditHoldingButton();
        editHoldingButton.assertIsEnabled();
        editHoldingButton.click();
    }

    /**
     * Открывает фильтр в контейнере "Номенклатор"
     */
    public void openFilterForHoldingList()
    {
        getHoldingListContainer().showFilter();
    }

    /**
     * Нажатие на кнопку "Найти" в фильтре в контейнере "Номенклатор"
     */
    public void clickFilterFindButtonForHoldingList()
    {
        getHoldingListContainer().getFilter().clickFindButton();
    }

    /**
     * Нажатие на кнопку "Удалить" и потдверждение диалогового окна
     */
    public void clickDeleteHoldingAndAcceptDialog()
    {
        Button deleteHoldingButton = getDeleteHoldingButton();
        deleteHoldingButton.assertIsEnabled();
        deleteHoldingButton.click();
        getDialog().clickYes();
    }

    /**
     * Получение модального окна "Номенклатура"
     */
    public HoldingModal getHoldingModal()
    {
        return new HoldingModal("main");
    }

    /**
     * Проверка что созданная Номенклатура отобразилось в таблице и была выбрана
     * @param code      Код номенклатуры
     * @param name      Наименование
     * @param latinName Латинское наименование
     * @param inn       МНН
     * @param commodityGroup  Товарная группа(группа ТМЦ)
     * @param isVital         ЖВНЛП
     * @param isAccounting    ПКУ
     * @param isGuaranty       ПГГ
     */
    public int checkRecordInHoldingListTable(String code, String name, String latinName, String inn, String commodityGroup, String isVital, String isAccounting, String isGuaranty)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if(code!=null)columnsAndValues.put("Код", code);
        if(name!=null)columnsAndValues.put("Наименование", name);
        if(latinName!=null)columnsAndValues.put("Латинское", latinName);
        if(inn!=null)columnsAndValues.put("МНН", inn);
        if(commodityGroup!=null)columnsAndValues.put("Группа ТМЦ", commodityGroup);
        if(isVital!=null)columnsAndValues.put("ЖВНЛП", isVital);
        if(isAccounting!=null)columnsAndValues.put("ПКУ", isAccounting);
        if(isGuaranty!=null)columnsAndValues.put("ПГГ", isGuaranty);

        return getHoldingListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

    }

    public int getRecordInHoldingListByCode(String code)
    {
        Map<String, String> columnsAndValues = new HashMap<>();
        if(code!=null)columnsAndValues.put("Код", code);
        return getHoldingListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Проверка сообщения об успешном сохранении "Номенклатура сохранена"
     */
    public void assertHoldingListSuccessMessage(String successMessage)
    {
        getHoldingListTable().getAlerts().assertSuccessAlertMessage(successMessage);
    }

    public void fillFilterValues(String codeModif) {
        getFilterHoldingList().getInputText("modifCode").setValue(codeModif);
    }

    public void clearFilterValues() {
        getFilterHoldingList().getInputText("modifCode").clearValue();
    }


    /* -------------------- Кнопки в контейнере "Модификации" ------------------------- */

    /**
     * Нажатие на кнопку "Добавить"
     */
    public void clickCreateModif()
    {
        Button createModifButton = getCreateModifButton();
        createModifButton.assertIsEnabled();
        createModifButton.click();
    }

    /**
     * Нажатие на кнопку "Максимальные дозы"
     */
    public void clickAddMaxDoses()
    {
        Button addMaxDosesButton = getAddMaxDosesButton();
        addMaxDosesButton.assertIsEnabled();
        addMaxDosesButton.click();
    }

    /**
     * Проверка сообщения об успешном сохранении "Модификация сохранена"
     */
    public void assertModifListSuccessMessage(String successMessage)
    {
        getModifListTable().getAlerts().assertSuccessAlertMessage(successMessage);
    }

    /**
     * Получение модального окна "Модификация"
     */
    public ModifModal getModifModal()
    {
        return new ModifModal("main");
    }

    /**
     * Получение модального окна "Модификация"
     */
    public ModifMaxDosesModal getModifMaxDosesModal() {
        return new ModifMaxDosesModal();
    }


    /**
     * Проверка что созданная Модификация отобразилось в таблице и была выбрана
     */

    public int checkRecordInModifListTable(ModifData modifData) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (modifData.getIsCommon() != null) columnsAndValues.put("Общий", modifData.getIsCommon());
        if (modifData.getCode() != null) columnsAndValues.put("Код", modifData.getCode());
        if (modifData.getCodeTfoms() != null) columnsAndValues.put("Код ТФОМС", modifData.getCodeTfoms());
        if (modifData.getName() != null) columnsAndValues.put("Наименование", modifData.getName());
        if (modifData.getMnei() != null) columnsAndValues.put("МНЕИ", modifData.getMnei());

        return getModifListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

    }

    /* -------------------- Кнопки в контейнере "Производители" ------------------------- */

    /**
     * Нажатие на кнопку "Добавить"
     */

    public void clickCreateProducer() {
        Button createProducerButton = getCreateProducerButton();
        createProducerButton.assertIsEnabled();
        createProducerButton.click();
    }

    /**
     * Получение модального окна "Производитель"
     */
    public HoldingProducerModal getProducerModal(){
        return new HoldingProducerModal("main");
    }

    /**
     * Проверка что созданная Модификация отобразилось в таблице и была выбрана
     */

    public int checkRecordInProducerListTable(HoldingProducerData holdingProducerData) {

        Map<String, String> columnsAndValues = new HashMap<>();
        if (holdingProducerData.getOrganization() != null)
            columnsAndValues.put("Производитель", holdingProducerData.getOrganization());
        if (holdingProducerData.getCodeRls() != null) columnsAndValues.put("Код РЛС", holdingProducerData.getCodeRls());
        if (holdingProducerData.getEanCode() != null)
            columnsAndValues.put("Штрих-код (EAN13)", holdingProducerData.getEanCode());
        if (holdingProducerData.getRegCertNumber() != null)
            columnsAndValues.put("Рег. удостоверение", holdingProducerData.getRegCertNumber());
        if (holdingProducerData.getRegCertDateStart() != null)
            columnsAndValues.put("Дата начала", holdingProducerData.getRegCertDateStart());
        if (holdingProducerData.getRegCertDateEnd() != null)
            columnsAndValues.put("Дата окончания", holdingProducerData.getRegCertDateEnd());
        if (holdingProducerData.getLimitPrice() != null)
            columnsAndValues.put("Предельная цена", holdingProducerData.getFormattedLimitPrice());
        if (holdingProducerData.getPriceDate() != null)
            columnsAndValues.put("Дата цены", holdingProducerData.getPriceDate());
        if (holdingProducerData.getDecisionNumber() != null)
            columnsAndValues.put("№ решения", holdingProducerData.getDecisionNumber());

        return getProducerListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}