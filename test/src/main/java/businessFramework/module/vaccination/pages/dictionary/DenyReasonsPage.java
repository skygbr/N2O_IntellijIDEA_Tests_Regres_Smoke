package businessFramework.module.vaccination.pages.dictionary;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Класс описывает страницу "Причины медицинского отвода"
 */
public class DenyReasonsPage extends DenyReasonsHelper implements Values {

    public DenyReasonsPage(ApplicationManager app) {
        super(app);
    }

    // Получение фильтров
    public DenyReasonsFilter getDenyReasonFilter() {
        return new DenyReasonsFilter(app);
    }

    // Фильтр по полю "Код"
    public void filterByCode(String code) {
        getDenyReasonFilter().getCode().setValue(code);
        getDenyReasonContainer().getFilter().clickFindButton();
    }

    // Проверка работы фильтра по полю "Код"
    public void assertTableData1(String code) {
        getTable().assertColumnValuesIs("Код", code);
    }

    // Фильтр по полю "Причина"
    public void filterByLabel(String label) {
        getDenyReasonFilter().getLabel().setValue(label);
        getDenyReasonContainer().getFilter().clickFindButton();
    }

    // Проверка работы фильтра по полю "Наименование"
    public void assertTableData2(String label) {
        getTable().assertColumnValuesIs("Причина", label);
    }

    // Проверка наличия в таблице добавленных данных
    public int checkTableDenyReasonsValues(String code, String label) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (code != null)
            columnsAndValues.put("Код", code);
        if (label != null)
            columnsAndValues.put("Причина", label);

        return getDenyReasonTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}
