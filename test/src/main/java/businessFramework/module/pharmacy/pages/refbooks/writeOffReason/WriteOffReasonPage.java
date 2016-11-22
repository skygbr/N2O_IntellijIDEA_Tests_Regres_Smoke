package businessFramework.module.pharmacy.pages.refbooks.writeOffReason;

import businessFramework.module.pharmacy.modals.refbook.writeOffReason.WriteOffReasonModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ydolgih
 * @since 23.09.2015
 */
public class WriteOffReasonPage extends WriteOffReasonHelper {

    public WriteOffReasonPage(ApplicationManager app) {
        super(app);
    }

    public WriteOffReasonModal getWriteOffReasonFormModal() {
        return new WriteOffReasonModal(app);
    }

    public void clickCreateButton() {
        sleep(5); //todo решение т.к. контейнер не успевает прогрузится
        getCreateWriteOffReasonButton().click();
    }

    public void clickEditButton() {
        getEditWriteOffReasonButton().click();
    }

    public void clickDeleteButton() {
        getDeleteWriteOffReasonButton().click();
    }

    public Table getWriteOffReasonListTable() {
        return getWriteOffReasonListContainer().getTable();
    }

    public int checkWriteOffReasonTableValues(String shortName) {
        Map<String, String> columnsAndValues = new HashMap<>();
        if (shortName != null) {
            columnsAndValues.put("Наименование причины списания", shortName);
        }
        return getWriteOffReasonListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

}