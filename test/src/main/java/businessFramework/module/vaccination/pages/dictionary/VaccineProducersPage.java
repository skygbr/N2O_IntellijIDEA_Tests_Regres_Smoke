package businessFramework.module.vaccination.pages.dictionary;

import businessFramework.entities.vaccination.VaccineProducerDictionaryData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Класс описывает страницу "Производители вакцин"
 */
public class VaccineProducersPage extends VaccineProducersHelper implements Values {

    public VaccineProducersPage(ApplicationManager app) {
        super(app);
    }

    // Получение фильтров
    public VaccineProducersFilter getVaccinePoducerFilter() {
        return new VaccineProducersFilter(app);
    }

    // Фильтр по полю "Страна"
    public void filterByCountry(String country) {
        getVaccinePoducerFilter().getCountry().setValue(country);
        getVacineProducerContainer().getFilter().clickFindButton();
    }

    // Проверка работы фильтра по полю "Страна"
    public void assertTableData1(String country) {
        getTable().assertColumnValuesIs("Страна", country);
    }

    // Фильтр по поллю "Наименование"
    public void filterByLabel(String label) {
        getVaccinePoducerFilter().getLabel().setValue(label);
        getVacineProducerContainer().getFilter().clickFindButton();
    }

    // Проверка работы фильтра по полю "Наименование"
    public void assertTableData2(String label) {
        getTable().assertColumnValuesIs("Наименование", label);
    }

    // Фильтр по полю "Полное наименование"
    public void filterByFullName(String fullName) {
        getVaccinePoducerFilter().getFullName().setValue(fullName);
        getVacineProducerContainer().getFilter().clickFindButton();
    }

    // Проверка работы фильтра по полю "Полное наименование"
    public void assertTableData3(String fullName) {
        getTable().assertColumnValuesIs("Полное наименование", fullName);
    }

    // Проверка наличия в таблице добавленных данных
    public int checkTableVaccineProducersValues(String country, String label, String fullName) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (country != null)
            columnsAndValues.put("Страна", country);
        if (label != null)
            columnsAndValues.put("Наименование", label);
        if (fullName != null)
            columnsAndValues.put("Полное наименование", fullName);

        return getVaccineProducerTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}
