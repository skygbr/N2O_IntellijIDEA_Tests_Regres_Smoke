package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

import java.util.List;

public class RefuseWorkModal extends RefuseWorkHelper implements Values {

    public RefuseWorkModal(ApplicationManager app) {
        super(app);
    }

    /**
     *
     * @param deviation Значение поля "Отклонение"
     * @param replacementsList список значений которые должны содержаться во всплывающем списке поля "Замена"
     */
    public void fillRefusalFields(String deviation, List<String> replacementsList)
    {
        getDeviationField().setValue(deviation);
        getReplacementField().assertThatValuesPresentsInCombobox(replacementsList);
        getReplacementField().setValue(1);
        getConfirmButton().click();
    }
}