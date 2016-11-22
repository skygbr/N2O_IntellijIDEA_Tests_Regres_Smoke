package businessFramework.module.stomatology.modals.stomMedicalCard;

import businessFramework.module.stomatology.modals.stomMedicalCard.StomMedicalCardHelper;

/**
 * Created by RTlabs on 20.07.2016.
 */
public class StomMedicalCardModal extends StomMedicalCardHelper{


    /**
     * удаляет все записи из истории АМК
     */
    public void deleteMedicalCardRowHistory(){
        while (getTable().getCountRowsInTable(true)>0) {
            getTable().chooseRowInTable(0);
            getButtonDeleteMedicalCard().click();
            page.getDialog().clickYes();
        }
    }

    /**
     * нажатие кнопки добавления записи в историю АМК
     */
    public void addMedicalCardRowHistory(){
        getButtonCreateMedicalCard().click();
    }
}
