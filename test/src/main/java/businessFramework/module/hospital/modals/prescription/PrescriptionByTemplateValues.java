package businessFramework.module.hospital.modals.prescription;


import businessFramework.module.Values;

public interface PrescriptionByTemplateValues extends Values {
    String NOT_PRESCRIBED = "Не назначено";
    String WAIT_CONFIRMATION = "Ожидает подтверждения";
    String SCHEDULED = "Запланировано";

    String VALIDATION_MESSAGE_ALREADY_PRESCRIBED = "Один или несколько из отмеченных препаратов уже назначены";
    String VALIDATION_MESSAGE_NOT_PRESCRIBED = "Один или несколько из отмеченных препаратов не назначены";

}
