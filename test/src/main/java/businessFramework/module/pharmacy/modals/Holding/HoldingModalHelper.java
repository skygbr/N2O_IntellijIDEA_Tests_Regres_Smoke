package businessFramework.module.pharmacy.modals.Holding;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 27.05.2015
 */
public class HoldingModalHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public HoldingModalHelper()
    {
        this.container="main";
    }

    public HoldingModalHelper(String container)
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
     * @return поле ЖВНЛП
     */
    public InputCheckBox getIsVital()
    {
        return  getModal().getForm().getInputCheckBox("vital");
    }

    /**
     * @return поле ПКУ
     */
    public InputCheckBox getIsAccounting()
    {
        return getModal().getForm().getInputCheckBox("accounting");
    }

    /**
     * @return поле ПГГ
     */
    public InputCheckBox getIsGuaranty()
    {
        return getModal().getForm().getInputCheckBox("guaranty");
    }

    /**
     * @return поле Прототип
     */
    public Classifier getCommonPrototype()
    {
        return  getModal().getForm().getClassifier("commonPrototype");
    }

    /**
     * @return поле Код
     */
    public InputText getCode()
    {
        return  getModal().getForm().getInputText(("code"));
    }

    /**
     * @return поле Наименование
     */
    public InputText getName()
    {
        return getModal().getForm().getInputText("name");
    }

    /**
     * @return поле МНН
     */
    public Classifier getInn()
    {
        return getModal().getForm().getClassifier(("inn"));
    }

    /**
     * @return поле Латинское наименование
     */
    public InputText getLatinName()
    {
        return getModal().getForm().getInputText("latinName");
    }

    /**
     * @return поле Товарная группа
     */
    public Classifier getCommodityGroup()
    {
        return getModal().getForm().getClassifier("comGroup");
    }

    /**
     * @return поле VEN-классификатор
     */
    public Select getVen()
    {
        return getModal().getForm().getSelect(("ven"));
    }

    /**
     * @return поле Формулярный список
     */
    public MultiClassifier getOfficialLists()
    {
        return getModal().getForm().getMultiClassifier("officialLists");
    }

    /**
     * @return поле АТХ
     */
    public MultiClassifier getAtcs() { return getModal().getForm().getMultiClassifier("atcs"); }

    /**
     * @return поле Фарм. группа
     */
    public MultiClassifier getPharmGroups() { return getModal().getForm().getMultiClassifier("pharmGroups"); }

    /**
     * @return поле МКБ
     */
    public MultiClassifier getMkbDiagnosis() { return getModal().getForm().getMultiClassifier("diagnosisList"); }

    /**
     * @return поле Фарм. действие
     */
    public MultiClassifier getPharmActions() { return getModal().getForm().getMultiClassifier("pharmActions"); }

    public Button getSaveHoldingButton(){return  getModal().getButton(N2O_CONFIRM_BUTTON);}

}