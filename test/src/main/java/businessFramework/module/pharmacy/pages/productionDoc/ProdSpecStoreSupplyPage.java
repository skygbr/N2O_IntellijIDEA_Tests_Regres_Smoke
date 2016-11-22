package businessFramework.module.pharmacy.pages.productionDoc;

import businessFramework.entities.pharmacy.ProdDocData;
import businessFramework.module.pharmacy.modals.ProductionDocument.ProdSpecModal;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ydolgih
 * @since 13.11.2015
 */
public class ProdSpecStoreSupplyPage extends ProdSpecStoreSupplyHelper {

    public ProdSpecStoreSupplyPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение модального окна добавления спецификации в этом классе, тк это модальное окно открывается со страницы "Создание спецификации".
     */
    public ProdSpecModal getProdSpecModal()
    {
        return new ProdSpecModal(app);
    }

    /**
     * Номер ряда созданной записи в таблице "Спецификации"
     */
    public int row;

    /**
     * Нажимает кнопку "Добавить" в контейнере BatchList при создании спецификации
     */
    public void clickAddSpecBatchListBtn()
    {
        getAddSpecBatchListButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Спецификации"
     */
    public void clickUpdateSpecButton()
    {
        getEditSpecButton().click();
    }

    /**
     * Нажимает кнопку "Назад" на странице
     */
    public void clickBackButton()
    {
        getBackButton().click();
    }

    public void checkTableValues(ProdDocData data) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (data.getSpecModif() != null) columnsAndValues.put("Наименование ЛС и ИМН", data.getSpecModif());
        if (data.getSpecSeries() != null) columnsAndValues.put("Серия", data.getSpecSeries());
        if (data.getSpecMneiQuantity() != null) columnsAndValues.put("Количество", data.getSpecMneiQuantity());
        if (data.getSpecFormattedPrice() != null) columnsAndValues.put("Цена", data.getSpecFormattedPrice());
        if (data.getSpecAmountFormatted() != null) columnsAndValues.put("Сумма", data.getSpecAmountFormatted());

        getSpecificationsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    public int checkTableValuesChoiseRow(String specModif, String specSeries, String specMneiQuantity, String specFormattedPrice, String specAmountFormatted) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( specModif != null )           { columnsAndValues.put("Наименование ЛС и ИМН", specModif);}
        if ( specSeries != null )          { columnsAndValues.put("Серия", specSeries);}
        if ( specMneiQuantity != null )    { columnsAndValues.put("Количество", specMneiQuantity);}
        if ( specFormattedPrice != null )  { columnsAndValues.put("Цена", specFormattedPrice);}
        if ( specAmountFormatted != null ) { columnsAndValues.put("Сумма", specAmountFormatted);}

        row = getSpecificationsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Получение фильтров
     */
    public ProdSpecStoreSupplyFilter getProdSpecStoreSupplyFilter() {
        return new ProdSpecStoreSupplyFilter(app);
    }

    /**
     * Фильтр по полю "Наименование ЛС и ИМН"
     */

    public void filterBySpecModif(String specModif) {
        getProdSpecStoreSupplyFilter().getSpecModif().setValue(specModif);
        getBatchListContainer().getFilter().clickFindButton();
    }

    /**
     * Открывает фильтр в контейнере "Приходные накладные"
     */
    public void openFilterBatchListTable()
    {
        getBatchListContainer().showFilter();
    }

}
