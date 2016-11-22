package businessFramework.module.clinic.modals.searchPatient;

import businessFramework.entities.clinic.ClinicAppointmentData;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by bulat.garipov on 07.06.2016.
 */
public class SearchPatientModal extends SearchPatientHelper {
    /**
     * в поисковой строке вводит ФИО
     * @param data возвращает ФИО пациента
     */
    public void searchPatient(ClinicAppointmentData data) {
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
