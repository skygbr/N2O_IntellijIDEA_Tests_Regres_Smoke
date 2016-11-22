package businessFramework.module.pharmacy.modals.ProcurementMethod;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by ydolgih on 12.01.2016.
 */
public class ProcurementMethodModal extends Page implements Values {

    private Page page = Page.getInstance();

    public ProcurementMethodModal(ApplicationManager app) {
        super(app);
    }

    public Modal getProcurementMethodModal() {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получает контейнер в модальном окне добавления способа закупки
     *
     * @return контейнер в модальном окне добавления способа закупки
     */
    public Container getMainContainer() {
        return getContainer("main");
    }

    /**
     * @return поле "Наименование"
     */
    public InputText getName() {
        return getMainContainer().getForm().getInputText("name");
    }

    /**
     * @return поле "Код"
     */
    public InputText getCode() {
        return getMainContainer().getForm().getInputText("code");
    }

    public Button getSaveButton() {
        return getProcurementMethodModal().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Нажимает кнопку "Подтвердить"
     */
    public void clickSaveButton() {
        getSaveButton().click();
    }

    /**
     * Заполнение полей формы
     */
    public void fillFields(String code, String name) {
        if (code != null) getCode().setValue(code);
        if (name != null) getName().setValue(name);
    }

    /**
     * Проверка Ззначений полей формы
     */
    public void checkFields(String code, String name) {
        if (code != null) getCode().assertValue(code);
        if (name != null) getName().assertValue(name);
    }
}