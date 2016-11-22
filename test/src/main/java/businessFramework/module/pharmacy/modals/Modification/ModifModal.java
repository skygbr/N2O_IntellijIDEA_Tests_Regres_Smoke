package businessFramework.module.pharmacy.modals.Modification;

import businessFramework.entities.pharmacy.ModifData;
import net.framework.autotesting.meta.components.Button;

/**
 * @author ydolgih
 * @since 10.07.2015
 */
public class ModifModal {

    private ModifModalHelper modifModalHelper;

    public ModifModal() {
        modifModalHelper = new ModifModalHelper();
    }

    public ModifModal(String locator) {
        modifModalHelper = new ModifModalHelper(locator);
    }

    public void fillModifForm(ModifData modifData) {
        if (modifData.getCode() != null) modifModalHelper.getCode().setValue(modifData.getCode());
        if (modifData.getCodeTfoms() != null) modifModalHelper.getCodeTfoms().setValue(modifData.getCodeTfoms());
        if (modifData.getCommonPrototype() != null) modifModalHelper.getCommonPrototype().setValue(modifData.getCommonPrototype());
        if (modifData.getForm() != null) modifModalHelper.getForm().setValue(modifData.getForm());
        if (modifData.getName() != null) modifModalHelper.getName().setValue(modifData.getName());
        if (modifData.getLatinName() != null) modifModalHelper.getLatinName().setValue(modifData.getLatinName());
        if (modifData.getMnei() != null) modifModalHelper.getMNEI().setValue(modifData.getMnei());
        if (modifData.getPriceUnitFlag() != null)
            modifModalHelper.getPriceUnitFlag().selectOption(modifData.getPriceUnitFlag());
        if (modifData.getConcentrVal() != null) modifModalHelper.getConcentrVal().setValue(modifData.getConcentrVal());
        if (modifData.getConcentrUnit() != null)
            modifModalHelper.getConcentrUnit().setValue(modifData.getConcentrUnit());
        if (modifData.getActVal() != null)
            modifModalHelper.getActVal().setValue(modifData.getActVal());
        if (modifData.getActUnit() != null)
            modifModalHelper.getActUnit().setValue(modifData.getActUnit());
        if (modifData.getVolumeVal() != null)
            modifModalHelper.getVolumeVal().setValue(modifData.getVolumeVal());
        if (modifData.getVolumeUnit() != null)
            modifModalHelper.getVolumeUnit().setValue(modifData.getVolumeUnit());
        if (modifData.getMassVal() != null)
            modifModalHelper.getMassVal().setValue(modifData.getMassVal());
        if (modifData.getMassUnit() != null)
            modifModalHelper.getMassUnit().setValue(modifData.getMassUnit());
        if (modifData.getDosageVal() != null)
            modifModalHelper.getDosageVal().setValue(modifData.getDosageVal());
        if (modifData.getDosageUnit() != null)
            modifModalHelper.getDosageUnit().setValue(modifData.getDosageUnit());
        if (modifData.getNumberOfDoses() != null)
            modifModalHelper.getNumberOfDoses().setValue(modifData.getNumberOfDoses());
        if (modifData.getWriteOffUnitFlag() != null)
            modifModalHelper.getWriteOffUnitFlag().selectOption(modifData.getWriteOffUnitFlag());
        if (modifData.getStorageCond() != null)
            modifModalHelper.getStorageCond().selectOption(modifData.getStorageCond());
        if (modifData.getIsExtemporal() != null)
            modifModalHelper.getIsExtemporal().check(Boolean.parseBoolean(modifData.getIsExtemporal()));
        if (modifData.getAngroFlag() != null)
            modifModalHelper.getAngroFlag().check(Boolean.parseBoolean(modifData.getAngroFlag()));
        if (modifData.getMedPurposeFlag() != null)
            modifModalHelper.getMedPurposeFlag().check(Boolean.parseBoolean(modifData.getMedPurposeFlag()));
        if (modifData.getDloFlag() != null)
            modifModalHelper.getDloFlag().check(Boolean.parseBoolean(modifData.getDloFlag()));
    }

    public void checkfillModifFormFields(ModifData modifData) {
        if (modifData.getCode() != null)       modifModalHelper.getCode().assertValue(modifData.getCode());
        if (modifData.getCodeTfoms() != null)  modifModalHelper.getCodeTfoms().assertValue(modifData.getCodeTfoms());
        if (modifData.getCommonPrototype() != null)  modifModalHelper.getCommonPrototype().assertValue_equals(modifData.getCommonPrototype());
        if (modifData.getName() != null)       modifModalHelper.getName().assertValue(modifData.getName());
        if (modifData.getLatinName() != null)  modifModalHelper.getLatinName().assertValue(modifData.getLatinName());
        if (modifData.getMnei() != null)       modifModalHelper.getMNEI().assertValue_equals(modifData.getMnei());
        if (modifData.getPriceUnitFlag() != null)  modifModalHelper.getPriceUnitFlag().assertValue(modifData.getPriceUnitFlag());
        if (modifData.getConcentrVal() != null)    modifModalHelper.getConcentrVal().assertValue(modifData.getConcentrVal());
        if (modifData.getConcentrUnit() != null)   modifModalHelper.getConcentrUnit().assertValue_equals(modifData.getConcentrUnit());
        if (modifData.getActVal() != null)         modifModalHelper.getActVal().assertValue(modifData.getActVal());
        if (modifData.getActUnit() != null)        modifModalHelper.getActUnit().assertValue_equals(modifData.getActUnit());
        if (modifData.getVolumeVal() != null)      modifModalHelper.getVolumeVal().setValue(modifData.getVolumeVal());
        if (modifData.getVolumeUnit() != null)     modifModalHelper.getVolumeUnit().assertValue_equals(modifData.getVolumeUnit());
        if (modifData.getMassVal() != null)        modifModalHelper.getMassVal().assertValue(modifData.getMassVal());
        if (modifData.getMassUnit() != null)       modifModalHelper.getMassUnit().assertValue_equals(modifData.getMassUnit());
        if (modifData.getNumberOfDoses() != null)  modifModalHelper.getNumberOfDoses().assertValue(modifData.getNumberOfDoses());
        if (modifData.getWriteOffUnitFlag() != null) modifModalHelper.getWriteOffUnitFlag().assertValue(modifData.getWriteOffUnitFlag());
        if (modifData.getStorageCond() != null)      modifModalHelper.getStorageCond().selectOption(modifData.getStorageCond());
        if (modifData.getIsExtemporal() != null)     modifModalHelper.getIsExtemporal().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getIsExtemporal()));
        if (modifData.getAngroFlag() != null)        modifModalHelper.getAngroFlag().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getAngroFlag()));
        if (modifData.getMedPurposeFlag() != null)   modifModalHelper.getMedPurposeFlag().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getMedPurposeFlag()));
        if (modifData.getDloFlag() != null)          modifModalHelper.getDloFlag().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getDloFlag()));
    }

    public void clickSaveModif() {
        Button button = modifModalHelper.getSaveModifButton();
        button.assertIsEnabled();
        button.click();
    }
}
