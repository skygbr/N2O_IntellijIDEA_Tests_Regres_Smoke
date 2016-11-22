package businessFramework.module.gibddMedicalExamination.pages.Settings.Population;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;
import net.framework.autotesting.meta.components.TextArea;

import javax.xml.soap.Text;

/**
 * Created by bulat.garipov on 08.11.2016.
 */
public class PopulationHelper extends Page implements Values
{

    public PopulationHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера Список на странице
     * @return контейнер Список
     */
    public Container getContainerListPopulationName()
    {
        return getRegion(LEFT).getContainer("tree");
    }

    /**
     * Получение контейнера Численность населения на странице
     * @return контейнер Численность населения
     */
    public Container getPopulationContainer()
    {
        return getRegion(RIGHT).getContainer("form");
    }


    /*----------------------- Контейнер Список -----------------------*/
    /**
     * Получение кнопки "Создать"
     * @return кнопка "Создать"
     */
    public Button getCreatePopulationButton()
    {
        return getContainerListPopulationName().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопка "Удалить"
     */
    public Button getDeletePopulationButton()
    {
        return getContainerListPopulationName().getButton(DELETE_BUTTON);
    }

    /**
     * Получение модального окна, подтверждающего удаление записи в контейнере "Модель пациента"
     */
    public Modal getConfirmModalAfterDeleteListPopulationName()
    {
        getModal().assertModalHeader_equal("Предупреждение");
        return getModal();
    }

    /*----------------------- Контейнер Численность населения -----------------------*/
    /**
     * Получение кнопки "Редактировать"
     * @return кнопка "Редактировать"
     */
    public Button getUpdatePopulationButton()
    {
        return getPopulationContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки Сохранить в модальном окне
     * @return Это модальное окно
     */
    public Button getConfirmButton()
    {
        return getPopulationContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение кнопки Отмена в модальном окне
     * @return Это модальное окно
     */
    public Button getCancelButton()
    {
        return getPopulationContainer().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * Проверка данных текстового поля Медицинская организация
     */
    public InputText getOrgName()
    {
        return getPopulationContainer().getForm().getInputText("org_name");
    }

    /**
     * Проверка данных поля даты "Год"
     */
    public InputDate getYear()
    {
        return getPopulationContainer().getForm().getInputDate("year");
    }
    
    
    /* ------------------------ Получение полей на форме Численность населения на начало года ---------------------- */
    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (М)"
     */
    public InputText getM21_36Begin()
    {
        return getPopulationContainer().getForm().getInputText("m21_36_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (М)"
     */
    public InputText getM39_60Begin()
    {
        return getPopulationContainer().getForm().getInputText("m39_60_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (М)"
     */
    public InputText getM60Begin()
    {
        return getPopulationContainer().getForm().getInputText("m60_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (Ж)"
     */
    public InputText getF21_36Begin()
    {
        return getPopulationContainer().getForm().getInputText("f21_36_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (Ж)"
     */
    public InputText getF39_60Begin()
    {
        return getPopulationContainer().getForm().getInputText("f39_60_begin");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (Ж)"
     */
    public InputText getF60Begin()
    {
        return getPopulationContainer().getForm().getInputText("f60_begin");
    }


    /* ------------------ Получение полей на форме Подлежит диспансеризации по плану текущего года ----------------- */
    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (М)"
     */
    public InputText getM21_36Disp()
    {
        return getPopulationContainer().getForm().getInputText("m21_36_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (М)"
     */
    public InputText getM39_60Disp()
    {
        return getPopulationContainer().getForm().getInputText("m39_60_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (М)"
     */
    public InputText getM60Disp()
    {
        return getPopulationContainer().getForm().getInputText("m60_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "21-36 лет (Ж)"
     */
    public InputText getF21_36Disp()
    {
        return getPopulationContainer().getForm().getInputText("f21_36_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "39-60 лет (Ж)"
     */
    public InputText getF39_60Disp()
    {
        return getPopulationContainer().getForm().getInputText("f39_60_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "Старше 60 лет (Ж)"
     */
    public InputText getF60Disp()
    {
        return getPopulationContainer().getForm().getInputText("f60_disp");
    }


    /* ---------------- Получение полей на форме Подлежит диспансеризации по плану текущего года ------------------- */
    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "0-4 года (Дети)"
     */
    public InputText getCh0_4Disp()
    {
        return getPopulationContainer().getForm().getInputText("ch0_4_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "5-9 лет (Дети)"
     */
    public InputText getCh5_9Disp()
    {
        return getPopulationContainer().getForm().getInputText("ch5_9_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "10-14 лет (Дети)"
     */
    public InputText getCh10_14Disp()
    {
        return getPopulationContainer().getForm().getInputText("ch10_14_disp");
    }

    /**
     * Заполнение данных текстового поля
     * @return Текстовое поле "15-17 лет (Дети)"
     */
    public InputText getCh15_17Disp()
    {
        return getPopulationContainer().getForm().getInputText("ch15_17_disp");
    }


}
