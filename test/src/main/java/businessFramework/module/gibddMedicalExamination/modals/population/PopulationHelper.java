package businessFramework.module.gibddMedicalExamination.modals.population;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputCheckBox;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

import java.awt.*;

/**
 * Created by bulat.garipov on 10.11.2016.
 */
public class PopulationHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public PopulationHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение модального окна "Численность населения"
     * @return модальное окно "Численность населения"
     */
    public Modal getPopulationModal()
    {
        return page.getModal();
    }


    /**
     * Получение кнопки Сохранить в модальном окне
     * @return Это модальное окно
     */
    public Button getConfirmButton()
    {
        return getPopulationModal().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение кнопки Отмена в модальном окне
     * @return Это модальное окно
     */
    public Button getCancelButton()
    {
        return getPopulationModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * Проверка данных текстового поля Медицинская организация
     */
    public InputText getOrgName()
    {
        return getPopulationModal().getForm().getInputText("org_name");
    }

    /**
     * Заполнение данных поля даты "Год"
     */
    public InputDate getYear()
    {
        return getPopulationModal().getForm().getInputDate("year");
    }


    /* ------------------------ Получение полей на форме Численность населения на начало года ---------------------- */
    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (М)"
     */
    public InputText getM21_36Begin()
    {
        return getPopulationModal().getForm().getInputText("m21_36_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (М)"
     */
    public InputText getM39_60Begin()
    {
        return getPopulationModal().getForm().getInputText("m39_60_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (М)"
     */
    public InputText getM60Begin()
    {
        return getPopulationModal().getForm().getInputText("m60_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (Ж)"
     */
    public InputText getF21_36Begin()
    {
        return getPopulationModal().getForm().getInputText("f21_36_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (Ж)"
     */
    public InputText getF39_60Begin()
    {
        return getPopulationModal().getForm().getInputText("f39_60_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (Ж)"
     */
    public InputText getF60Begin()
    {
        return getPopulationModal().getForm().getInputText("f60_begin");
    }


    /* ------------------ Получение полей на форме Подлежит диспансеризации по плану текущего года ----------------- */
    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (М)"
     */
    public InputText getM21_36Disp()
    {
        return getPopulationModal().getForm().getInputText("m21_36_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (М)"
     */
    public InputText getM39_60Disp()
    {
        return getPopulationModal().getForm().getInputText("m39_60_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (М)"
     */
    public InputText getM60Disp()
    {
        return getPopulationModal().getForm().getInputText("m60_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (Ж)"
     */
    public InputText getF21_36Disp()
    {
        return getPopulationModal().getForm().getInputText("f21_36_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (Ж)"
     */
    public InputText getF39_60Disp()
    {
        return getPopulationModal().getForm().getInputText("f39_60_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (Ж)"
     */
    public InputText getF60Disp()
    {
        return getPopulationModal().getForm().getInputText("f60_disp");
    }


    /* ---------------- Получение полей на форме Подлежит диспансеризации по плану текущего года ------------------- */
    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "0-4 года (Дети)"
     */
    public InputText getCh0_4Disp()
    {
        return getPopulationModal().getForm().getInputText("ch0_4_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "5-9 лет (Дети)"
     */
    public InputText getCh5_9Disp()
    {
        return getPopulationModal().getForm().getInputText("ch5_9_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "10-14 лет (Дети)"
     */
    public InputText getCh10_14Disp()
    {
        return getPopulationModal().getForm().getInputText("ch10_14_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "15-17 лет (Дети)"
     */
    public InputText getCh15_17Disp()
    {
        return getPopulationModal().getForm().getInputText("ch15_17_disp");
    }


}
