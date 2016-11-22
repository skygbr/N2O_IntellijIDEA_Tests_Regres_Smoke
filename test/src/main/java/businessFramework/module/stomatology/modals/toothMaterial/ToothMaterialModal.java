package businessFramework.module.stomatology.modals.toothMaterial;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;


/**
 * Created by RTlabs on 20.07.2016.
 */
public class ToothMaterialModal extends ToothMaterialHelper implements Values{
    ApplicationManager app = new ApplicationManager();
    Page page = new Page(app);

    // кнопка "Подтвердить"
    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    //кнопка "Отменить"
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValue(){
        getToothNumber().setValue("1.1");
        getHoldModif().setValue(0);
        getAmount().setValue("1");
    }
    public void copyValue(){
        getToothNumber().setValue("1.2");
        getHoldModif().setValue(0);
        getAmount().setValue("1");
        getMeasure().setValue(0);
        clickConfirm();

    }
    public void updateValue(){
        getToothNumber().setValue("1.2");
        getHoldModif().setValue(1);
        getAmount().setValue("3");
        getMeasure().setValue(0);
        clickConfirm();

    }
}
