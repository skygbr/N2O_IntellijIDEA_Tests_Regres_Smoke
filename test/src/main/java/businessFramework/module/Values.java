package businessFramework.module;


import org.openqa.selenium.By;

public interface Values
{

    //regions
    String TOP      = "top";
    String BOTTOM   = "bottom";
    String LEFT     = "left";
    String RIGHT    = "right";
    String SINGLE   = "single";
    String MIDDLE   = "middle";

    //buttons
    String REVERT_ACCEPT_BUTTON = "revert_accept";
    String N2O_CONFIRM_BUTTON   = "n2o-confirm";
    String N2O_CANCEL_BUTTON    = "n2o-cancel";
    String CREATE_NEW_CARD      = "createMigrantCard";
    String CONFIRM_BUTTON       = "confirm";
    String CANCEL_APPROVE       = "not_approve";
    String CREATE_BUTTON        = "create";
    String UPDATE_BUTTON        = "update";
    String COPY_BUTTON          = "copy";
    String DELETE_BUTTON        = "delete";
    String ACCEPT_BUTTON        = "accept";
    String CLEAR_SERVICE        = "clearService";
    String SEARCH_BUTTON        = "search";
    String ATTACH_MODEL         = "attachModel";
    String SAVE_BUTTON          = "save";
    String VIEW_BUTTON          = "view";
    String CARD_BUTTON          = "migrantCard";
    String DRIVER_CARD          = "driverCard";
    String ADD_BUTTON           = "add";
    String ADD_DRIVER           = "addDriver";
    String EXECUTE              = "execute";
    String APPROVE              = "approve";
    String SUBMIT               = "submit";
    String CANCEL               = "cancel";
    String BACK                 = "back";
    String ADD_MAX_DOSES        = "addMaxDoses";
    String CONSOLIDATE          ="consolidate";
    String SELECT_PATIENTS      ="selectPatients";

    //links
    String CREATE_LINK          = "Создать";
    String EDIT_LINK            = "Редактировать";
    String ADD_LINK             = "Добавить";

    //table values
    String PATIENT_FIELD        = "Пациент";
    String NAME_COLUMN          = "Наименование";
    String PATIENT_MODEL        = "Модель пациента";
    String PATIENT_FIO          = "ФИО";
    String VRACH_FIO            = "ФИО";
    String PATIENT_FULL_COLUMN  = "Фамилия Имя Отчество";
    String PATIENT_BIRTHDATE    = "Дата рождения";
    String VRACH_BIRTHDATE      = "Дата рождения";
    String PATIENT_STATUS       = "Статус";

    // Заголовки столбцов таблицы в контейнере "Настройка вида бригады"
    String CODE                 = "Код";
    String BRIGADE_KIND         = "Вид бригады";
    String JOB_KIND             = "Вид наряда";
    String PROFILE              = "Профиль";
    String BRIGADE_TYPE         = "Тип бригады";

    // Заголовки столбцов таблицы в контейнере "Сотрудники"
    String WORKING_PLACE        = "Рабочее место";
    String ROLE                 = "Роль";
    String SPECIALITY           = "Специальность";
    String PERSONAL_CATEGORY    = "Категория персонала";
    String POSITION             = "Должность";

    // Заголовки столбцов таблицы в контейнере "Сотрудники"
    String TS_TYPE              = "Тип ТС";
    String EQUIPMENT_KIND       = "Вид оснащения";

    // Значения выпадающего меню
    String MORE_DROPDOWN        = "Еще";
    String EDIT_DROPDOWN        = "Изменить";

    // Заголовки столбцов таблицы в контейнере "Бригада"
    String BRIGADE_NAME         = "Бригада";
    String RADIO_CODE           = "Код рации";

    // Заголовки столбцов таблицы в контейнере "Картотека транспортных средств"
    String TS_NUMBER            = "Гос. рег. знак";
    String TS_CATEGORY          = "Категория ТС";

    // Заголовки столбцов таблицы в контейнере "Журнал нарядов бригад"
    String JOB_SUBSTATION       = "Подстанция";
    String JOB_DATE             = "Смена";

    // Заголовки столбцов таблицы в контейнере "Сотрудники" на странице "Журнал нарядов бригад"
    String RESOURCE_NAME        = "Ресурс";
    String BEGIN_DATE_TIME      = "Начало";
    String END_DATE_TIME        = "Окончание";

    // Значения для столбцов в таблице "Сотрудники" в модальном окне "Заполнить наряд на бригаду"
    String WORKING_PLACE_FILL   = "Рабочее место";
    String SURNAME_FILL         = "Фамилия";
    String NAME_FILL            = "Имя";
    String PATRNAME_FILL        = "Отчество";
    String BEGIN_DATE_TIME_FILL = "Начало";
    String END_DATE_TIME_FILL   = "Окончание";
    String BREAK_FILL           = "Отклонение";
    String REPLACE_FILL         = "Замена";

    // Заголовки столбцов таблицы в контейнере "Смены"
    String CHANGE_STATION       = "Станция";
    String CHANGE_BEGIN_DATE    = "Дата начала смены";
    String CHANGE_BEGIN_TIME    = "Время начала смены";
    String CHANGE_END_DATE      = "Дата окончания смены";
    String CHANGE_END_TIME      = "Время окончания смены";

    String CREATE_MORE          = "n2o-create-more";

    String DAY_VALUE            = "День";

    // messages
    String MESSAGE_SUCCESS      = "Данные сохранены";

    // Значения для столбцов в таблице "Список моделей пациента"
    String NAME_MODEL_PATIENT   = "Наименование";
    String GENDER_MODEL_PATIENT = "Пол";
    String AGE_MODEL_PATIENT    = "Возраст";
}
