package businessFramework.module.pharmacy.modals.Modification;

import businessFramework.entities.pharmacy.ModifData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by ydolgih on 15.12.2015.
 */
public class ModifForOrgModal extends ModifForOrgModalHelper {

    public  ModifForOrgModal(ApplicationManager app) {
        super(app);
    }

    public void clickFindFromPrototype() {
        getRegionalModif().findModalButtonClick();
    }

    public void clickAddHolding() {
        getHolding().getButton("AddHolding").click();
    }

    public void clickFillFromPrototype() {
        getRegionalModif().clickLink("✓");
    }

    public SearchRegionalModifModal getSearchRegionalModifModal() {
        return new SearchRegionalModifModal(app);
    }

    // Получение модального окна "Поиск модификации в региональном справочнике”
    public SearchRegionalModifModal searchRegionalModifModal() {
        return new SearchRegionalModifModal(app);
    }

    public void fillModifFromForOrgFields(ModifData modifData) {
        if (modifData.getCode() != null)
            getCode().setValue(modifData.getCode());
        if (modifData.getCodeTfoms() != null)
            getCodeTfoms().setValue(modifData.getCodeTfoms());
        if (modifData.getCommonPrototype() != null)
            getRegionalModif().setValue(modifData.getCommonPrototype());
        if (modifData.getForm() != null)
            getFormType().setValue(modifData.getForm());
        if (modifData.getName() != null)
            getName().setValue(modifData.getName());
        if (modifData.getLatinName() != null)
            getLatinName().setValue(modifData.getLatinName());
        if (modifData.getMnei() != null)
            getMNEI().setValue(modifData.getMnei());
        if (modifData.getPriceUnitFlag() != null)
            getPriceUnitFlag().selectOption(modifData.getPriceUnitFlag());
        if (modifData.getConcentrVal() != null)
            getConcentrVal().setValue(modifData.getConcentrVal());
        if (modifData.getConcentrUnit() != null)
            getConcentrUnit().setValue(modifData.getConcentrUnit());
        if (modifData.getActVal() != null)
            getActVal().setValue(modifData.getActVal());
        if (modifData.getActUnit() != null)
            getActUnit().setValue(modifData.getActUnit());
        if (modifData.getVolumeVal() != null)
            getVolumeVal().setValue(modifData.getVolumeVal());
        if (modifData.getVolumeUnit() != null)
            getVolumeUnit().setValue(modifData.getVolumeUnit());
        if (modifData.getMassVal() != null)
            getMassVal().setValue(modifData.getMassVal());
        if (modifData.getMassUnit() != null)
            getMassUnit().setValue(modifData.getMassUnit());
        if (modifData.getDosageVal() != null)
            getDosageVal().setValue(modifData.getDosageVal());
        if (modifData.getDosageUnit() != null)
            getDosageUnit().setValue(modifData.getDosageUnit());
        if (modifData.getNumberOfDoses() != null)
            getNumberOfDoses().setValue(modifData.getNumberOfDoses());
        if (modifData.getWriteOffUnitFlag() != null)
            getWriteOffUnitFlag().selectOption(modifData.getWriteOffUnitFlag());
        if (modifData.getStorageCond() != null)
            getStorageCond().selectOption(modifData.getStorageCond());
        if (modifData.getIsExtemporal() != null)
            getIsExtemporal().check(Boolean.parseBoolean(modifData.getIsExtemporal()));
        if (modifData.getAngroFlag() != null)
            getAngroFlag().check(Boolean.parseBoolean(modifData.getAngroFlag()));
        if (modifData.getMedPurposeFlag() != null)
            getMedPurposeFlag().check(Boolean.parseBoolean(modifData.getMedPurposeFlag()));
        if (modifData.getDloFlag() != null)
            getDloFlag().check(Boolean.parseBoolean(modifData.getDloFlag()));
    }

    public void checkModifFromForOrgFields(ModifData modifData)
    {
        if(modifData.getCommonPrototype()!=null) getRegionalModif().assertValue_equals(modifData.getCommonPrototype());
        if (modifData.getCode() != null)       getCode().assertValue(modifData.getCode());
        if (modifData.getCodeTfoms() != null)  getCodeTfoms().assertValue(modifData.getCodeTfoms());
        if (modifData.getName() != null)       getName().assertValue(modifData.getName());
        if (modifData.getLatinName() != null)  getLatinName().assertValue(modifData.getLatinName());
        if (modifData.getMnei() != null)       getMNEI().assertValue_equals(modifData.getMnei());
        if (modifData.getPriceUnitFlag() != null) getPriceUnitFlag().assertValue(modifData.getPriceUnitFlag());
        if (modifData.getConcentrVal() != null)   getConcentrVal().assertValue(modifData.getConcentrVal());
        if (modifData.getConcentrUnit() != null)  getConcentrUnit().assertValue_equals(modifData.getConcentrUnit());
        if (modifData.getActVal() != null)        getActVal().assertValue(modifData.getActVal());
        if (modifData.getActUnit() != null)       getActUnit().assertValue_equals(modifData.getActUnit());
        if (modifData.getVolumeVal() != null)     getVolumeVal().setValue(modifData.getVolumeVal());
        if (modifData.getVolumeUnit() != null)    getVolumeUnit().assertValue_equals(modifData.getVolumeUnit());
        if (modifData.getMassVal() != null)       getMassVal().assertValue(modifData.getMassVal());
        if (modifData.getMassUnit() != null)      getMassUnit().assertValue_equals(modifData.getMassUnit());
        if (modifData.getNumberOfDoses() != null) getNumberOfDoses().assertValue(modifData.getNumberOfDoses());
        if (modifData.getWriteOffUnitFlag() != null) getWriteOffUnitFlag().assertValue(modifData.getWriteOffUnitFlag());
        if (modifData.getStorageCond() != null)      getStorageCond().selectOption(modifData.getStorageCond());
        if (modifData.getIsExtemporal() != null)     getIsExtemporal().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getIsExtemporal()));
        if (modifData.getAngroFlag() != null)        getAngroFlag().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getAngroFlag()));
        if (modifData.getMedPurposeFlag() != null)   getMedPurposeFlag().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getMedPurposeFlag()));
        if (modifData.getDloFlag() != null)         getDloFlag().assertThatCheckboxIsChecked(Boolean.parseBoolean(modifData.getDloFlag()));
    }

    public void clickSaveButton() {
        Button button = getSaveButton();
        button.assertIsEnabled();
        button.click();
    }
}

