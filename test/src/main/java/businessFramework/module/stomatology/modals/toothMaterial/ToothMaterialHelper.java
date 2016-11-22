package businessFramework.module.stomatology.modals.toothMaterial;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by RTlabs on 20.07.2016.
 */
public class ToothMaterialHelper implements Values {
    private Page page = Page.getInstance();

    public Container getContainerToothMaterial(){
        return page.getModal().getContainer("main");
    }
    public Button getCancelButton(){
        return getContainerToothMaterial().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerToothMaterial().getButton(N2O_CONFIRM_BUTTON);
    }
    //Номер зуба
    public Classifier getToothNumber(){
        return getContainerToothMaterial().getForm().getClassifier("tooth");
    }
    //товарная группа
    public Classifier getCommodityGroup(){
        return getContainerToothMaterial().getForm().getClassifier("commodityGroup");
    }
    //Наименование расходного материала
    public Classifier getHoldModif(){
        return getContainerToothMaterial().getForm().getClassifier("holdModif");
    }
    //единицы измерения
    public Classifier getMeasure(){
        return getContainerToothMaterial().getForm().getClassifier("measure");
    }
    //количество
    public InputText getAmount() {
        return getContainerToothMaterial().getForm().getInputText("amount");
    }
}
