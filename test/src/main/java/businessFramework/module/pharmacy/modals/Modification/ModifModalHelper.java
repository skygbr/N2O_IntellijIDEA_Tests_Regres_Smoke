package businessFramework.module.pharmacy.modals.Modification;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 10.07.2015
 */
public class ModifModalHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public ModifModalHelper() {
        this.container = "main";
    }

    public ModifModalHelper(String container) {
        this.container = container;
    }

    public Modal getModal() {
        return page.getModal();
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    /**Поля формы Модификация*/

    /**
     * @return поле Код
     */
    public InputText getCode() {
        return getModal().getForm().getInputText("code");
    }

    /**
     * @return поле Код ТФОМС
     */
    public InputText getCodeTfoms() {
        return getModal().getForm().getInputText("codeTfoms");
    }

    /**
     * @return поле Прототип
     */
    public Classifier getCommonPrototype() {
        return getModal().getForm().getClassifier("commonPrototype");
    }

    /**
     * @return поле Лекарственная форма
     */
    public Classifier getForm() {
        return getModal().getForm().getClassifier("form");
    }

    /**
     * @return поле Наименование
     */
    public InputText getName() {
        return getModal().getForm().getInputText("name");
    }

    /**
     * @return поле Латинское наименование
     */
    public InputText getLatinName() {
        return getModal().getForm().getInputText("latinName");
    }

    /**
     * @return поле МНЕИ
     */
    public Classifier getMNEI() {
        return getModal().getForm().getClassifier("mnei");
    }

    /**
     * @return поле Ценовая единица измерения
     */
    public Select getPriceUnitFlag() {
        return getModal().getForm().getSelect("priceUnitFlag");
    }

    /**
     * @return поле Концентрация
     */
    public InputText getConcentrVal() {
        return getModal().getForm().getInputText("concentrVal");
    }

    /**
     * @return поле Ед.изм. концентрации
     */
    public Classifier getConcentrUnit() {
        return getModal().getForm().getClassifier("concentrUnit");
    }

    /**
     * @return поле Активность
     */
    public InputText getActVal() {
        return getModal().getForm().getInputText("actVal");
    }

    /**
     * @return поле Ед.изм. активности
     */
    public Classifier getActUnit() {
        return getModal().getForm().getClassifier("actUnit");
    }

    /**
     * @return поле Дозировка
     */
    public InputText getDosageVal() {
        return getModal().getForm().getInputText("dosageVal");
    }

    /**
     * @return поле Ед.изм. дозировки
     */
    public Classifier getDosageUnit() {
        return getModal().getForm().getClassifier("dosageUnit");
    }

    /**
     * @return поле Масса
     */
    public InputText getMassVal() {
        return getModal().getForm().getInputText("massVal");
    }

    /**
     * @return поле Ед.изм. массы
     */
    public Classifier getMassUnit() {
        return getModal().getForm().getClassifier("massUnit");
    }

    /**
     * @return поле Объем
     */
    public InputText getVolumeVal() {
        return getModal().getForm().getInputText("volumeVal");
    }

    /**
     * @return поле Ед.изм. массы
     */
    public Classifier getVolumeUnit() {
        return getModal().getForm().getClassifier("volumeUnit");
    }

    /**
     * @return поле Количество Доз
     */
    public InputText getNumberOfDoses() {
        return getModal().getForm().getInputText("numberOfDoses");
    }

    /**
     * @return поле Единица измерения списания
     */
    public Select getWriteOffUnitFlag() {
        return getModal().getForm().getSelect("writeOffUnitFlag");
    }

    /**
     * @return поле Особые условия хранения
     */
    public Select getStorageCond() {
        return getModal().getForm().getSelect("storageCond");
    }

    /**
     * @return поле Экстемпоральный
     */
    public InputCheckBox getIsExtemporal() {
        return getModal().getForm().getInputCheckBox("isExtemporal");
    }

    /**
     * @return поле АНГРО
     */
    public InputCheckBox getAngroFlag() {
        return getModal().getForm().getInputCheckBox("angroFlag");
    }

    /**
     * @return поле Лек. назначения
     */
    public InputCheckBox getMedPurposeFlag() {
        return getModal().getForm().getInputCheckBox("medPurposeFlag");
    }

    /**
     * @return поле Признак ДЛО
     */
    public InputCheckBox getDloFlag() {
        return getModal().getForm().getInputCheckBox("dloFlag");
    }

    /**Кнопки*/

    /**
     * @return кнопка Сохранить
     */
    public Button getSaveModifButton() {
        return getModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
