package businessFramework.module.pharmacy.modals.PharmacyApplications;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ApplicationModalHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public ApplicationModalHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getApplicationModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /** ---------------- Поля на форме в модальном окне "Добавление заявки" ---------------- */

    /**
     * @return поле "Тип документа"
     */
    public Classifier getDocTypeField()
    {
        return getApplicationModal().getForm().getClassifier("docType");
    }

    /**
     * @return поле "Префикс-номер"
     */
    public InputText getPrefixNumberField()
    {
        return getApplicationModal().getForm().getInputText("docNumber");
    }

    /**
     * @return поле "Финансирование"
     */
    public SelectTree getFinancingField()
    {
        return getApplicationModal().getForm().getSelectTree("fundSource");
    }

    /**
     * @return поле "Товарная группа"
     */
    public Classifier getProductGroupField()
    {
        return getApplicationModal().getForm().getClassifier("comGroup");
    }

    /**
     * @return поле "Примечание"
     */
    public TextArea getCommentField()
    {
        return getApplicationModal().getForm().getTextArea("note");
    }

    /**
     * @return поле "Год"
     */
    public InputText getYearField()
    {
        return getApplicationModal().getForm().getInputText("year");
    }

    /**
     * @return поле "Тип заявки"
     */
    public Classifier getApplicationTypeField()
    {
        return getApplicationModal().getForm().getClassifier("appType");
    }

    /**
     * @return поле "Дата"
     */
    public InputDate getDateField()
    {
        return getApplicationModal().getForm().getInputDate("docDate");
    }

    /**
     * @return поле "Подразделения"
     */
    public MultiClassifier getDepartmentListField()
    {
        return getApplicationModal().getForm().getMultiClassifier("organizationFile.departments");
    }

    /**
     * @return поле "Подразделение"
     */
    public Classifier getDepartmentField()
    {
        return getApplicationModal().getForm().getClassifier("department");
    }

    /**
     * @return поле "Склад"
     */
    public Classifier getStoreField()
    {
        return getApplicationModal().getForm().getClassifier("store", false);
    }

    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveAppButton()
    {
        return getApplicationModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
