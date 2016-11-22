package businessFramework.module.ambulance.modal;

import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает модальное окно "Изменить шаблон вида бригады 'ЛИН'".
 * Это модальное окно открывается со страницы "Бригады: справочники" - "Настройка вида бригады" по кнопке "Изменить" в контейнере "Настройка вида бригады"
 */
public class EditBrigadeViewTemplateModal extends EditBrigadeViewTemplateHelper
{

    public EditBrigadeViewTemplateModal(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Проверка заголовка модального окна на эквивалентность ожидаемому
     *
     * @param header ожидаемый заголовок модального окна
     */
    public void checkModalHeader(String header)
    {
        getEditBrigadeViewTemplateModal().assertModalHeader_equal(header);
    }


    /**
     * Проверка значений в таблице "Состав сотрудников"
     *
     * @param workingPlace      Рабочее место
     * @param role              Роль
     * @param spetiality        Специальность
     * @param personalCategory  Категория персонала
     * @param position          Должность
     *
     * @return номер ряда таблицы
     */
    public int checkEmployeesGroupTableValues(String workingPlace, String role, String personalCategory, String position)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( workingPlace != null)      { columnsAndValues.put(WORKING_PLACE, workingPlace); }
        if ( role != null)              { columnsAndValues.put(ROLE, role); }
        if ( personalCategory != null)  { columnsAndValues.put(PERSONAL_CATEGORY, personalCategory); }
        if ( position != null)          { columnsAndValues.put(POSITION, position); }

        return getEmployeesGroupTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

    }


    /**
     * Проверка значений в таблице "Состав транспорта"
     *
     * @param workingPlace      Рабочее место
     * @param role              Роль
     * @param tsType            Тип ТС
     * @param equipmentKind     Вид оснащения
     *
     * @return номер ряда таблицы
     */
    public int checkTransportGroupTableValues(String workingPlace, String role, String tsType, String equipmentKind)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( workingPlace != null)      { columnsAndValues.put(WORKING_PLACE, workingPlace); }
        if ( role != null)              { columnsAndValues.put(ROLE, role); }
        if ( tsType != null)            { columnsAndValues.put(TS_TYPE, tsType); }
        if ( equipmentKind != null)     { columnsAndValues.put(EQUIPMENT_KIND, equipmentKind); }

        return getTranportGroupTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

    }

    /**
     * Заполнение полей
     *
     * @param name      Значение для поля "Наименование"
     */
    public void fillFields(String name)
    {
        if (name != null) { getNameField().setValue(name); }
    }

    /**
     * Нажатие кнопки "Сохранить"
     */
    public void clickSaveButton()
    {
        getSaveEditedBrigadeViewTemplateButton().click();
    }

}
