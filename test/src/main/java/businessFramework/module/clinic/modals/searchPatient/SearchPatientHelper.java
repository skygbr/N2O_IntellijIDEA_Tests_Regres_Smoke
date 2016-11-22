package businessFramework.module.clinic.modals.searchPatient;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

/**
 * Created by RTlabs on 07.06.2016.
 */
public class SearchPatientHelper implements Values {
    private Page page = Page.getInstance();
    public Container getContainerSearch(){
        return page.getModal().getContainer("main");
    }

    /**
     * Получение компонента выбора пациента
     * @return компонент выбора пациента
     */
    public Classifier getPatient() {
        return getContainerSearch().getForm().getClassifier("individual");
    }
    public Button getCancelButton(){
        return getContainerSearch().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerSearch().getButton(N2O_CONFIRM_BUTTON);
    }

}
