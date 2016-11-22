package businessFramework.module.stomatology.modals.stomInspection;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 02.08.2016.
 */
public class AddStomInspectionModal extends AddStomInspectionHelper{
    /**
     * добавление новой записи Осмотра
     * */
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
    public void setValue(){
        getToothNumber().setValue("1.1");
        getSurface().setValue("медиальная");
        getDisease().setValue("Кариес");
        getMobility().setValue("Степень I");
    }
    public void changeValue(){
        getToothNumber().setValue("1.2");
         getSurface().setValue("небная");
        getDisease().setValue("Пломба");
        getMobility().setValue("Степень II");
    }
}
