package businessFramework.module.clinic.modals.medicalCard;

/**
 * Created by RTlabs on 02.06.2016.
 */
public class MedicalCardModal {
    private MedicalCardHelper medicalCardHelper;
    public MedicalCardModal(){
        medicalCardHelper = new MedicalCardHelper();
    }

    /**
     * удаляет все записи из истории АМК
     */
    public void deleteMedicalCardRowHistory(){
        while (medicalCardHelper.getTable().getCountRowsInTable(true)>0) {
            medicalCardHelper.getTable().chooseRowInTable(0);
            medicalCardHelper.getButtonDeleteMedicalCard().click();
            medicalCardHelper.page.getDialog().clickYes();
        }
    }

    /**
     * нажатие кнопки добавления записи в историю АМК
     */
    public void addMedicalCardRowHistory(){
        medicalCardHelper.getButtonCreateMedicalCard().click();
    }

}
