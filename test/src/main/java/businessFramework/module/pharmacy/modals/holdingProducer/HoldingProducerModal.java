package businessFramework.module.pharmacy.modals.holdingProducer;

import businessFramework.entities.pharmacy.HoldingProducerData;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 19.05.2015
 */
public class HoldingProducerModal
{
    private HoldingProducerHelper holdingProducerHelper;

    public HoldingProducerModal()
    {
        holdingProducerHelper = new HoldingProducerHelper();
    }

    public HoldingProducerModal(String locator)
    {
        holdingProducerHelper = new HoldingProducerHelper(locator);
    }

    public void fillHoldingProducerForm(HoldingProducerData holdingProducerData)
    {
        holdingProducerHelper.getOrganization().setValue(holdingProducerData.getOrganization());
        holdingProducerHelper.getRegCertNumber().setValue(holdingProducerData.getRegCertNumber());
        holdingProducerHelper.getCodeRls().setValue(holdingProducerData.getCodeRls());
        holdingProducerHelper.getRegCertDateStart().setValue(holdingProducerData.getRegCertDateStart());
        holdingProducerHelper.getEanCode().setValue(holdingProducerData.getEanCode());
        holdingProducerHelper.getRegCertDateEnd().setValue(holdingProducerData.getRegCertDateEnd());
        holdingProducerHelper.getLimitPrice().setValue(holdingProducerData.getLimitPrice());
        holdingProducerHelper.getDecisionNumber().setValue(holdingProducerData.getDecisionNumber());
        holdingProducerHelper.getPriceDate().setValue(holdingProducerData.getPriceDate());
        holdingProducerHelper.getCertificateNumber().setValue(holdingProducerData.getCertificateNumber());
    }

    public void checkHoldingProducerFormFields(HoldingProducerData holdingProducerData)
    {
        holdingProducerHelper.getOrganization().assertValue_contains(holdingProducerData.getOrganization());
        holdingProducerHelper.getRegCertNumber().assertValue(holdingProducerData.getRegCertNumber());
        holdingProducerHelper.getCodeRls().assertValue(holdingProducerData.getCodeRls());
        holdingProducerHelper.getRegCertDateStart().assertDateFieldValidation(holdingProducerData.getRegCertDateStart());
        holdingProducerHelper.getEanCode().assertValue(holdingProducerData.getEanCode());
        holdingProducerHelper.getRegCertDateEnd().assertDateFieldValidation(holdingProducerData.getRegCertDateEnd());
        holdingProducerHelper.getLimitPrice().assertValue(holdingProducerData.getLimitPrice());
        holdingProducerHelper.getDecisionNumber().assertValue(holdingProducerData.getDecisionNumber());
        holdingProducerHelper.getPriceDate().assertDateFieldValidation(holdingProducerData.getPriceDate());
        holdingProducerHelper.getCertificateNumber().assertValue(holdingProducerData.getCertificateNumber());
    }

    public void clickSaveHoldingProducer()
    {
        Button button = holdingProducerHelper.getSaveHoldingProducerButton();
        button.assertIsEnabled();
        button.click();
    }
}