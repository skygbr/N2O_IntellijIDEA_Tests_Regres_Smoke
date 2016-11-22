package businessFramework.module.hospital.pages.medicalHistory;


import businessFramework.module.Values;

public interface MedicalHistoryValues extends Values
{
    //tableValues
    String SERVICES = "Осмотры";
    String SEND_TO_DEPARTMENT = "Движение по отделениям";
    String SEND_TO_BED = "Движение по койкам";

    String VALIDATION_MESSAGE_ON_UPDATE_CLOSED_CASE = "Для внесения изменений в историю болезни необходимо отменить выписку из стационара";
}
