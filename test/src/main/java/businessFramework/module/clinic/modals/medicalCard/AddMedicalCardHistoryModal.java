package businessFramework.module.clinic.modals.medicalCard;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 02.06.2016.
 */
public class AddMedicalCardHistoryModal {
    private AddMedicalCardHistoryHelper addMedicalCardHistoryHelper;

    public AddMedicalCardHistoryModal(){
        addMedicalCardHistoryHelper = new AddMedicalCardHistoryHelper();
    }
    /**
     * добавление новой записи истории АМК (Кнопка "Подтвердить")
     */
    public void clickConfirm(){
        Button button = addMedicalCardHistoryHelper.getConfirmButton();
        button.click();
    }
    /**
     * закртие модального окна добавление записи без добавления записи (Кнопка "отмена")
     */
    public void clickCancel(){
        Button button = addMedicalCardHistoryHelper.getCancelButton();
        button.click();
    }
    /**
     * выбирает значение из классифаера "Местонахождение"
     */
    public void setValues(){
       addMedicalCardHistoryHelper.getPlaceMedicalCard().setValue("На руках");
    }

}