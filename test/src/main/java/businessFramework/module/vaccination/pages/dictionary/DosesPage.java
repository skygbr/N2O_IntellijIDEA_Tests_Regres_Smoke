package businessFramework.module.vaccination.pages.dictionary;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Класс описывает страницу "Дозировки"
 */
public class DosesPage extends DosesHelper implements Values {

    public static String DOSE_TABLE_DOSE_COLUMN = "Доза";
    public static String DOSE_TABLE_DOSE_TYPE_COLUMN = "Единица измерения";
    public static String DOSE_TABLE_DOSE_CODE_COLUMN = "Код";
    public static String DOSE_TYPE_TABLE_CODE_COLUMN = "Код";
    public static String DOSE_TYPE_TABLE_DOSE_TYPE_COLUMN = "Единица измерения";

    public DosesPage(ApplicationManager app) {
        super(app);
    }

    // Получение фильтров
    public DosesFilter getDoseFilter() {
        return new DosesFilter(app);
    }

    // Фильтр по полю "Доза" контейнера "Дозировки"
    public void filterDoseByCount(String count) {
        getDoseFilter().getCount().setValue(count);
        getDoseContainer().getFilter().clickFindButton();
    }

    // Проверка работы фильтра по полю "Доза" контейнера "Дозировки"
    public void assertDoseTableData(String column, String value) {
        getDoseContainer().getTable().assertColumnValuesIs(column, value);
    }

    public void assertDoseTypeTableData(String column, String value) {
        getDoseTypeContainer().getTable().assertColumnValuesIs(column, value);
    }

    // Фильтр по полю "Единица измерения" контейнера "Дозировки"
    public void filterDoseByDoseType(String doseType) {
        getDoseFilter().getDoseType().setValue(doseType);
        getDoseContainer().getFilter().clickFindButton();
    }

    // Фильтр по полю "Код" контейнера "Дозировки"
    public void filterDoseByCode(String code) {
        getDoseFilter().getDoseCode().setValue(code);
        getDoseContainer().getFilter().clickFindButton();
    }

    // Фильтр по полю "Код" контейнера "Единица измерения"
    public void filterDoseTypeByCode(String doseTypeCode) {
        getDoseFilter().getDoseTypeCode().setValue(doseTypeCode);
        getDoseTypeContainer().getFilter().clickFindButton();
    }

    // Фильтр по полю "Единица измерения" контейнера "Единица измерения"
    public void filterDoseTypeByLabel(String doseTypeLabel) {
        getDoseFilter().getDoseTypeLabel().setValue(doseTypeLabel);
        getDoseTypeContainer().getFilter().clickFindButton();
    }

    // Проверка работы фильтра по полю "Единица измерения" контейнера "Единицы измерения"
    public void assertTableData5() {
        getDoseTypeContainer().getTable().assertColumnValuesIs("Единица измерения", "обновленная тестовая единица измерения");
    }

    // Проверка наличия в таблице добавленных данных контейнера "Дозировки"
    public int checkTableDosesValues(String count, String doseType, String code, String eCode) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (count != null)
            columnsAndValues.put("Доза", count);
        if (doseType != null)
            columnsAndValues.put("Единица измерения", doseType);
        if (code != null)
            columnsAndValues.put("Код", code);
        if (eCode != null)
            columnsAndValues.put("Дополнительный код", eCode);

        return getDoseTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    // Проверка наличия в таблице добавленных данных контейнера "Единицы измерения"
    public int checkTableDoseTypesValues(String doseTypeCode, String doseTypeLabel) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (doseTypeCode != null)
            columnsAndValues.put("Код", doseTypeCode);
        if (doseTypeLabel != null)
            columnsAndValues.put("Единица измерения", doseTypeLabel);

        return getDoseTypeTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}
