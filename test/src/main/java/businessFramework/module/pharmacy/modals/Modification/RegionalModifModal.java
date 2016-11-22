package businessFramework.module.pharmacy.modals.Modification;

import businessFramework.entities.pharmacy.ModifData;

/**
 * Created by ydolgih on 08.12.2015.
 */
public class RegionalModifModal extends ModifModal {

    private RegionalModifModalHelper regionalModifModalHelper;

    public RegionalModifModal(String locator) {
        regionalModifModalHelper = new RegionalModifModalHelper(locator);
    }

    public void fillModifForm(ModifData modifData) {
        super.fillModifForm(modifData);
        if (modifData.getMaxDailyDoseVal() != null)
            regionalModifModalHelper.getMaxDailyDoseVal().setValue(modifData.getMaxDailyDoseVal());
        if (modifData.getMaxSingleDoseVal() != null)
            regionalModifModalHelper.getMaxSingleDoseVal().setValue(modifData.getMaxSingleDoseVal());
        if (modifData.getCodeOkdp() != null)
            regionalModifModalHelper.getCodeOkdpVal().setValue(modifData.getCodeOkdp());
    }

    public void checkfillModifFormFields(ModifData modifData) {
        super.checkfillModifFormFields(modifData);
        if (modifData.getMaxSingleDoseVal() != null)
            regionalModifModalHelper.getMaxSingleDoseVal().assertValue(modifData.getMaxSingleDoseVal());
        if (modifData.getMaxDailyDoseVal() != null)
            regionalModifModalHelper.getVolumeVal().assertValue(modifData.getVolumeVal());
        if (modifData.getCodeOkdp() != null)
            regionalModifModalHelper.getCodeOkdpVal().assertValue(modifData.getCodeOkdp());
    }
}
