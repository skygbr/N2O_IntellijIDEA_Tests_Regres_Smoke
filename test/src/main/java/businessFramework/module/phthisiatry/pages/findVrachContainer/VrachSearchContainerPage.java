package businessFramework.module.phthisiatry.pages.findVrachContainer;

import businessFramework.module.phthisiatry.modals.VrachSearchModal;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bulat.garipov on 01.11.2016.
 */

/**
 * Класс описывает страницу "Поиск врача"
 */

public class VrachSearchContainerPage extends VrachSearchContainerHelper
{
    public VrachSearchContainerPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие кнопки "Лупа" в компоненте выбора пациента
     */
    public void clickSearchVrach()
    {
        getVrachSearchComponent().findModalButtonClick();
    }

    /**
     * Получение ссылки на модальное окно "Поиск врачей" с этой страницы, т.к. с нее происходит открытие этого модального окна.
     * @return модальное окно "Поиск врачей"
     */
    public VrachSearchModal getAddVrachModal()
    {
        return new VrachSearchModal(app);
    }

    /**
     * Проверяет, что значение в поле "Врач" совпадает с ожидаемым
     * @param fullValue ожидаемое значение поля "Врач"
     */
    public void checkThatVrachNameAppearsInField(String fullValue)
    {
        getVrachSearchComponent().assertValue_equals(fullValue);
    }

    /**
     * Проверяет запись в таблице на соответствие ожидаемой
     */
    public int checkTableValues(String fio, String birthDate)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (fio != null)        { columnsAndValues.put(VRACH_FIO, fio); }
        if (birthDate != null)  { columnsAndValues.put(VRACH_BIRTHDATE, birthDate); }

        return getFoundVrachTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Нажатие кнопки "Найти"
     */
    public void clickFindVrachButton()
    {
        getFindButton().click();
    }

    /**
     * Нажатие кнопки "Назад"
     */
    public void clickBackButton()
    {
        getBackButton().click();
    }

}

