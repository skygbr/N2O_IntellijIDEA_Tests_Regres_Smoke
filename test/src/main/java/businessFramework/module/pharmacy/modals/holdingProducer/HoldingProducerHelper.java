package businessFramework.module.pharmacy.modals.holdingProducer;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 19.05.2015
 */
public class HoldingProducerHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public HoldingProducerHelper()
    {
        this.container="main";
    }

    public HoldingProducerHelper(String container)
    {
        this.container = container;
    }

    public Modal getModal()
    {
        return page.getModal();
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    /**
     * @return поле Организация
     */
    public Classifier getOrganization()
    {
        return  getModal().getForm().getClassifier("org");
    }

    /**
     * @return поле Наименование организации
     */
    public InputText getOrganizationName()
    {
        return  getModal().getForm().getInputText("name");
    }

    /**
     * @return поле Номер рег. удостоверения
     */
    public InputText getRegCertNumber()
    {
        return getModal().getForm().getInputText("regCertNumber");
    }

    /**
     * @return поле Код РЛС
     */
    public InputText getCodeRls()
    {
        return  getModal().getForm().getInputText("codeRls");
    }

    /**
     * @return поле Начало действия
     */
    public InputDate getRegCertDateStart()
    {
        return  getModal().getForm().getInputDate(("regCertDateStart"));
    }

    /**
     * @return поле Штрих-код
     */
    public InputText getEanCode()
    {
        return getModal().getForm().getInputText("ean");
    }

    /**
     * @return поле Окончание действия
     */
    public InputDate getRegCertDateEnd()
    {
        return getModal().getForm().getInputDate(("regCertDateEnd"));
    }

    /**
     * @return поле Пред.цена без НДС
     */
    public InputText getLimitPrice()
    {
        return getModal().getForm().getInputText("limitPrice");
    }

    /**
     * @return поле Номер решения
     */
    public InputText getDecisionNumber()
    {
        return getModal().getForm().getInputText("decisionNum");
    }

    /**
     * @return поле Дата регистрации цены
     */
    public InputDate getPriceDate()
    {
        return getModal().getForm().getInputDate(("priceDate"));
    }

    /**
     * @return поле Сертификат
     */
    public InputText getCertificateNumber()
    {
        return getModal().getForm().getInputText("certNum");
    }

    public Button getSaveHoldingProducerButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}