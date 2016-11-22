package businessFramework.module.pharmacy.modals.Holding;

import businessFramework.entities.pharmacy.HoldingData;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 27.05.2015
 */
public class HoldingModal {

    private HoldingModalHelper holdingModalHelper;

    public HoldingModal() {
        holdingModalHelper = new HoldingModalHelper();
    }

    public HoldingModal(String locator) {
        holdingModalHelper = new HoldingModalHelper(locator);
    }

    public void fillHoldingForm(HoldingData holdingData) {
        if (holdingData.getIsVital() != null)
            holdingModalHelper.getIsVital().check(Boolean.parseBoolean(holdingData.getIsVital()));
        if (holdingData.getIsAccounting() != null)
            holdingModalHelper.getIsAccounting().check(Boolean.parseBoolean(holdingData.getIsAccounting()));
        if (holdingData.getIsGuaranty() != null)
            holdingModalHelper.getIsGuaranty().check(Boolean.parseBoolean(holdingData.getIsGuaranty()));
        if (holdingData.getCommonPrototype() != null)
            holdingModalHelper.getCommonPrototype().setValue(holdingData.getCommonPrototype());
        if (holdingData.getCode() != null)
            holdingModalHelper.getCode().setValue(holdingData.getCode());
        if (holdingData.getName() != null)
            holdingModalHelper.getName().setValue(holdingData.getName());
        if (holdingData.getInn() != null)
            holdingModalHelper.getInn().setValue(holdingData.getInn());
        if (holdingData.getLatinName() != null)
            holdingModalHelper.getLatinName().setValue(holdingData.getLatinName());
        if (holdingData.getCommodityGroup() != null)
            holdingModalHelper.getCommodityGroup().setValue(holdingData.getCommodityGroup());
        if (holdingData.getVen() != null)
            holdingModalHelper.getVen().selectOption(holdingData.getVen());
        if (holdingData.getOfficialList() != null)
            holdingModalHelper.getOfficialLists().setValue(holdingData.getOfficialList());
        if (holdingData.getActs() != null)
            holdingModalHelper.getAtcs().setValue(holdingData.getActs());
        if (holdingData.getPharmGroup() != null)
            holdingModalHelper.getPharmGroups().setValue(holdingData.getPharmGroup());
        if (holdingData.getMkbDiagnosis() != null)
            holdingModalHelper.getMkbDiagnosis().setValue(holdingData.getMkbDiagnosis());
        if (holdingData.getPharmAction() != null)
            holdingModalHelper.getPharmActions().setValue(holdingData.getPharmAction());
    }

    public void checkHoldingFormFields(HoldingData holdingData) {
        if (holdingData.getIsVital() != null)
            holdingModalHelper.getIsVital().assertThatCheckboxIsChecked(Boolean.parseBoolean(holdingData.getIsVital()));
        if (holdingData.getIsAccounting() != null)
            holdingModalHelper.getIsAccounting().assertThatCheckboxIsChecked(Boolean.parseBoolean(holdingData.getIsAccounting()));
        if (holdingData.getIsGuaranty() != null)
            holdingModalHelper.getIsGuaranty().assertThatCheckboxIsChecked(Boolean.parseBoolean(holdingData.getIsGuaranty()));
        if (holdingData.getCommonPrototype() != null)
            holdingModalHelper.getCommonPrototype().assertValue_equals(holdingData.getCommonPrototype());
        if (holdingData.getCode() != null)
            holdingModalHelper.getCode().assertValue(holdingData.getCode());
        if (holdingData.getName() != null)
            holdingModalHelper.getName().assertValue(holdingData.getName());
        if (holdingData.getInn() != null)
            holdingModalHelper.getInn().assertValue_equals(holdingData.getInn());
        if (holdingData.getLatinName() != null)
            holdingModalHelper.getLatinName().assertValue(holdingData.getLatinName());
        if (holdingData.getCommodityGroup() != null)
            holdingModalHelper.getCommodityGroup().assertValue_equals(holdingData.getCommodityGroup());
        if (holdingData.getVen() != null)
            holdingModalHelper.getVen().assertValue(holdingData.getVen());
        if (holdingData.getOfficialList() != null)
            holdingModalHelper.getOfficialLists().assertThatMultiValueIs(holdingData.getOfficialList());
        if (holdingData.getActs() != null)
            holdingModalHelper.getAtcs().assertThatMultiValueIs(holdingData.getActs());
        if (holdingData.getPharmGroup() != null)
            holdingModalHelper.getPharmGroups().assertThatMultiValueIs(holdingData.getPharmGroup());
        if (holdingData.getMkbDiagnosis() != null)
            holdingModalHelper.getMkbDiagnosis().assertThatMultiValueIs(holdingData.getMkbDiagnosis());
        if (holdingData.getPharmAction() != null)
            holdingModalHelper.getPharmActions().assertThatMultiValueIs(holdingData.getPharmAction());
    }

    public void clickSaveHolding() {
        Button button = holdingModalHelper.getSaveHoldingButton();
        button.assertIsEnabled();
        button.click();
    }
}