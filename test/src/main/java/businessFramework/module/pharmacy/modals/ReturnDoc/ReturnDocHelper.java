package businessFramework.module.pharmacy.modals.ReturnDoc;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


public class ReturnDocHelper extends Page implements Values{

    private Page page = Page.getInstance();

    public ReturnDocHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getReturnDocModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /* ----------------- Поля в модальном окне "Возвратный документ" ----------------- */

    /**
     * @return Текстовое поле "Номер"
     */
    public InputText getReturnDocNumberField()
    {
        return getReturnDocModal().getForm().getInputText("docNumber");
    }

    /**
     * @return поле "Дата"
     */
    public InputDate getReturnDocDateField(){
        return getReturnDocModal().getForm().getInputDate("docDate");
    }

    /**
     * @return поле "Склад"
     */
    public Classifier getReturnDocStore(){
        return getReturnDocModal().getForm().getClassifier("sendStore");
    }

    /**
     * @return классифаер "Складская операция"
     */
    public Classifier getReturnDocStoteOper(){
        return getReturnDocModal().getForm().getClassifier("storeOpr");
    }

    /**
     * @return классифаер "Поставщик"
     */
    public Classifier getContractor(){
        return getReturnDocModal().getForm().getClassifier("provider");
    }

    /**
     * @return классифаер "Финансирование"
     */
    public SelectTree getFunding(){
        return getReturnDocModal().getForm().getSelectTree("fundSource");
    }

    /**
     * @return поле "Причина возврата"
     */
    public InputText getReturnReason(){
        return  getReturnDocModal().getForm().getInputText("reason");
    }

    /**
     * @return поле "Примечание"
     */
    public InputText getAnnotation(){
        return getReturnDocModal().getForm().getInputText("note");
    }

    /**
     * @return кнопку "Подтвердить"
     */
    public Button getConfirmButton(){
        return getReturnDocModal().getButton(N2O_CONFIRM_BUTTON);
    }

}
