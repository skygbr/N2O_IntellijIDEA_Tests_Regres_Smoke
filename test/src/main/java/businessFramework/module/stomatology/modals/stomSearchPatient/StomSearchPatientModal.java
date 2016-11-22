package businessFramework.module.stomatology.modals.stomSearchPatient;

import businessFramework.entities.stomatology.StomatologyAppointmentData;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 27.07.2016.
 */
public class StomSearchPatientModal extends StomSearchPatientHelper{
    /**
     * в поисковой строке вводит ФИО
     * @param data возвращает ФИО пациента
     */
    public void searchPatient(StomatologyAppointmentData data) {
        getPatient().setValue(data.getPatientFIO());
    }


    /**
     * Подтверждение выбранного пациента, переход в результаты приема
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
}
