package businessFramework.module.stomatology.modals.stomMedicalCard;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 20.07.2016.
 */
public class AddStomMedicalCardHistoryModal extends AddStomMedicalCardHistoryHelper{



    /**
     * добавление новой записи истории АМК (Кнопка "Подтвердить")
     */
    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    /**
     * закртие модального окна добавление записи без добавления записи (Кнопка "отмена")
     */
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    /**
     * выбирает значение из классифаера "Местонахождение"
     */
    public void setValues(){
        getPlaceMedicalCard().setValue("На руках");
    }

}
