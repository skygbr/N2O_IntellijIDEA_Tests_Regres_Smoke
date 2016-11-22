package businessFramework.entities.ambulance;

/**
 * Данные для модуля "Скорая помощь"
 */
public class AmbulanceData
{

    public String contextName; // Название контекста


    /* ------------------------------- Заголовки модальных окон ----------------------------- */

    private String addBrigadeViewTemplateModalHeader; // Заголовок модального окна "Создать шаблон вида бригады"
    private String editBrigadeViewTemplateModalHeader;// Заголовок модального окна "Изменить шаблон вида бригады 'ЛИН'"
    private String addEmployeeModalHeader;            // Заголовок модального окна "Добавить сотрудника в шаблон вида бригады 'ЛИН'"
    private String editEmployeeModalHeader;           // Заголовок модального окна "Изменить сотрудника в шаблоне вида бригады 'ЛИН'"
    private String addTransportModalHeader;           // Заголовок модального окна "Добавить ТС в шаблон вида бригады 'ЛИН'"
    private String editTransportModalHeader;          // Заголовок модального окна "Изменить ТС в шаблоне вида бригады 'ЛИН'"
    private String addBrigadeModalHeader;             // Заголовок модального окна "Создать бригаду"
    private String createTransportModalHeader;        // Заголовок модального окна "Добавить карточку ТС"
    private String editTransportCardModalHeader;      // Заголовок модального окна "Изменить карточку ТС 'А111АА'"
    private String addTeamJobModalHeader;             // Создать наряд на бригаду
    private String addJobPersonModalHeader;           // Создать наряд на сорудника в бригаду
    private String addJobPerson2ModalHeader;          // Создать наряд на сорудника в бригаду2
    private String editJobPersonModalHeader;          // Изменить наряд на сорудника в бригаду
    private String editJobPerson2ModalHeader;         // Изменить наряд на сорудника в бригаду2
    private String addJobTSModalHeader;               // Создать наряд на ТС в бригаде
    private String addJobTS2ModalHeader;              // Создать наряд на ТС в бригаде2
    private String fillJobToBrigade1ModalHeader;      // Заполнить наряд на бригаду1
    private String fillJobToBrigade2ModalHeader;      // Заполнить наряд на бригаду2



    /* ------------------------------- Значения для полей в модальном окне "Создать шаблон вида бригады" ----------------------------- */

    private String codeValue;                       // Значение для поля "Код"
    private String code2Value;                      // Значение для поля "Код"
    private String nameValue;                       // Значение для поля "Наименование"
    private String name2Value;                      // Значение для поля "Наименование" для бригады 2
    private String nameEdited;                      // Значение для поля "Наименование" при изменении шаблона вида бригады
    private String brigadeKindValue;                // Значение для поля "Вид бригады"
    private String jobKindValue;                    // Значение для поля "Вид наряда"
    private String brigadeTypeValue;                // Значение для поля "Тип бригады"
    private String profileValue;                    // Значение для поля "Профиль"



    /* ------------------------------- Сообщения об успешном сохранении ----------------------------- */

    private String successBrigadeViewTemplateMessage;    // Сообщение об успешном сохранении шаблона вида бригады
    private String successEmployeeAddingMessage;         // Сообщение об успешном сохранении сотрудника
    private String successEmployeeEditingMessage;        // Сообщение об успешном изменении сотрудника
    private String successTransportAddingMessage;        // Сообщение об успешном добавлении транспорта в шаблон вида бригады
    private String successTransportCreatingMessage;      // Сообщение об успешном создании транспорта
    private String successTransportEditingMessage;       // Сообщение об успешном создании транспорта
    private String successBrigadeCreatingMessage;        // Сообщение об успешном создании бригады
    private String successJobTeamCreatingMessage;        // Сообщение об успешном создании наряда на бригаду
    private String successJobPersonCreatingMessage;      // Сообщение об успешном создании наряда на сотрудника в бригаде


    /* ------------------------------- Значения для полей в модальном окне "Добавить сотрудника в шаблон вида бригады 'ЛИН'" ----------------------------- */

    /** Врач1 */
    private String doctor1Role;                          // Значение для поля "Роль"
    private String doctor1PersonalCategory;              // Значение для поля "Категория персонала"
    private String doctor1PersonalCategoryCombobox;      // Значение для поля "Категория персонала"  ( для выбора в комбобоксе )
    private String doctor1WorkingPlace;                  // Значение для поля "Рабочее место"

    /** Врач2 */
    private String doctor2Role;                          // Значение для поля "Роль"
    private String doctor2PersonalCategory;              // Значение для поля "Категория персонала"
    private String doctor2PersonalCategoryCombobox;      // Значение для поля "Категория персонала"  ( для выбора в комбобоксе )
    private String doctor2WorkingPlace;                  // Значение для поля "Рабочее место"
    private String doctor2Speciality;                    // Значение для поля "Специальность"
    private String doctor2Position;                      // Значение для поля "Должность"

    /** Водитель*/
    private String driverRole;                           // Значение для поля "Роль"
    private String driverPersonalCategory;               // Значение для поля "Категория персонала"
    private String driverWorkingPlace;                   // Значение для поля "Рабочее место"


    /* ------------------- Значения для полей в модальном окне "Добавить ТС в шаблон вида бригады 'ЛИН'" ------------------- */

    private String transportRole;                        // Значение для поля "Роль"
    private String transportWorkingPlace;                // Значение для поля "Рабочее место"
    private String tsType;                               // Значение для поля "Тип ТС"
    private String equipmentKind;                        // Значение для поля "Вид оснащения"
    private String equipmentKindEdited;                  // Значение для поля "Вид оснащения измененное"


    /* ------------------- Значения для полей в модальном окне "Создать бригаду" ------------------- */

    private String subStation;                           // Значение для поля "Подстанция"
    private String radioCode;                            // Значение для поля "Код рации"
    private String radioCode2;                           // Значение для поля "Код рации"2
    private String beginWorkTime;                        // Значение для поля "Начало работы бригады"
    private String endWorkTime;                          // Значение для поля "Окончание работы бригады"
    private String medProfile;                           // Значение для поля "Мед. профиль"
    private String profile;                              // Значение для поля "Профиль"
    private String beginAction;                          // Значение для поля "Начало действия"
    private String endAction;                            // Значение для поля "Окончание действия"
    private String brigadeName;                          // Значение для поля "Бригада"1
    private String brigadeName2;                         // Значение для поля "Бригада"2



    /* ------------------- Значения для полей в модальном окне "Добавить карточку ТС" ------------------- */

    private String createTransportNumber;                // Значение для поля "Гос. номер"
    private String createTransportNumber2;               // Значение для поля "Гос. номер"2 - создание
    private String checkTransportNumber;                 // Значение для поля "Гос. номер"
    private String checkTransportNumber2;                // Значение для поля "Гос. номер"2 - проверка
    private String createTransportEquipmentKind;         // Значение для поля "Вид оснащения"
    private String createTransportCategory;              // Значение для поля "Категория" - Изначальное значение поля "Категория"
    private String createTransportCategoryEdited;        // Значение для поля "Категория" - При изменении значения в поле "Категория"



    /* ------------------------ Значения для полей в модальном окне "Создать наряд на бригаду" ---------------------- */

    private String jobStation;                           // Значение для поля "Станция"
    private String jobSubStation;                        // Значение для поля "Подстанция"
    private String jobDate;                              // Значение для поля "Дата"
    private String jobBrigade;                           // Значение для поля "Бригада"


    /* ------------------------ Значения для полей в модальном окне "Создать наряд на сотрудника в бригаде" ---------------------- */

    private String brigadeJob;                           // "Наряд бригады"
    private String hasTeamJob;                           // "Команд в работе"
    private String brigadeJob2;                          // "Наряд бригады"2
    private String resourceKind;                         // "Вид ресурса"
    private String resourceKindTransport;                // "Вид ресурса"
    private String workingPlaceInTemplate;               // "Рабочее место в шаблоне"
    private String workingPlaceInTemplateDriver;         // "Рабочее место в шаблоне"
    private String role;                                 // "Роль"
    private String workingPlace2;                        // "Рабочее место2"
    private String workingPlace2Driver;                  // "Рабочее место2 Водитель"
    private String resource1;                            // "Ресурс"
    private String resource2;                            // "Ресурс"
    private String resource3;                            // "Ресурс"
    private String resource4;                            // "Ресурс" (Колбаскин К. К.)
    private String resource5;                            // "Ресурс" (Водитель В. В.)
    private String jobKind;                              // "Вид наряда"
    private String olderInJob;                           // "Старший в наряде"
    private String beginDateTime;                        // "Дата/время начала наряда плановое"
    private String endDateTime;                          // "Дата/время окончания наряда плановое"


    /* ------------------------ Значения для столбцов в таблице "Журнал нарядов бригад" на странице "Журнал нарядов бригад" ---------------------- */

    private String jobTeamStartFlag;                     //Значок "+" неподписанного наряда


    /* ------------------------ Значения для столбцов в таблице "Сотрудники" на странице "Журнал нарядов бригад" ---------------------- */

    private String resource1Full;                        // "Ресурс" Врач1
    private String resource2Full;                        // "Ресурс" Врач2
    private String resource3Full;                        // "Ресурс" Водитель
    private String resource4Full;                        // "Ресурс" Колбаскин К. К.
    private String resource5Full;                        // "Ресурс" (Водитель В. В.)
    private String workplaceColumnName;                  // Название колонки
    private String workplaceName;                        // Значение рабочего места

    /* ------------------------ Значения для полей в модальном окне "Создать наряд на сотрудника в бригаде" ---------------------- */

    private String refusalDeviation;                      //Зеначение поля "Отказ"

    /* ------------------------ Значения для столбцов в таблице "Сотрудники" в модальном окне "Заполнить наряд на бригаду" - врач 1---------------------- */

    private String workingPlaceEMP_doctor_Fill_1;             // "Рабочее место"
    private String surnameEMP_doctor_Fill_1;                  // "Фамилия"
    private String nameEMP_doctor_Fill_1;                     // "Имя"
    private String patrNameEMP_doctor_Fill_1;                 // "Отчество"
    private String startDateTimeEMP_doctor_Fill_1;            // "Начало"
    private String endDateTimeEMP_doctor_Fill_1;              // "Окончание"
    private String breakEMP_doctor_Fill_1;                    // "Отклонение"
    private String replaceEMP_doctor_Fill_1;                  // "Замена"

    /* ------------------------ Значения для столбцов в таблице "Сотрудники" в модальном окне "Заполнить наряд на бригаду" - водитель 1---------------------- */

    private String workingPlaceEMP_driver_Fill_1;             // "Рабочее место"
    private String surnameEMP_driver_Fill_1;                  // "Фамилия"
    private String nameEMP_driver_Fill_1;                     // "Имя"
    private String patrNameEMP_driver_Fill_1;                 // "Отчество"
    private String startDateTimeEMP_driver_Fill_1;            // "Начало"
    private String endDateTimeEMP_driver_Fill_1;              // "Окончание"
    private String breakEMP_driver_Fill_1;                    // "Отклонение"
    private String replaceEMP_driver_Fill_1;                  // "Замена"


    /* ------------------------ Значения для столбцов в таблице "Транспорт" в модальном окне "Заполнить наряд на бригаду" 1---------------------- */

    private String workingPlaceTSFill_1;                      // "Рабочее место"
    private String resourceTSFill_1;                          // "Ресурс"
    private String startDateTimeTSFill_1;                     // "Начало"
    private String endDateTimeTSFill_1;                       // "Окончание"
    private String breakTSFill_1;                             // "Отклонение"
    private String replaceTSFill_1;                           // "Замена"

    /* ------------------------ Значения для столбцов в таблице "Сотрудники" в модальном окне "Заполнить наряд на бригаду" - врач 2---------------------- */

    private String workingPlaceEMP_doctor_Fill_2;             // "Рабочее место"
    private String surnameEMP_doctor_Fill_2;                  // "Фамилия"
    private String nameEMP_doctor_Fill_2;                     // "Имя"
    private String patrNameEMP_doctor_Fill_2;                 // "Отчество"
    private String startDateTimeEMP_doctor_Fill_2;            // "Начало"
    private String endDateTimeEMP_doctor_Fill_2;              // "Окончание"
    private String breakEMP_doctor_Fill_2;                    // "Отклонение"
    private String replaceEMP_doctor_Fill_2;                  // "Замена"

    /* ------------------------ Значения для столбцов в таблице "Сотрудники" в модальном окне "Заполнить наряд на бригаду" - водитель2 ---------------------- */

    private String workingPlaceEMP_driver_Fill_2;             // "Рабочее место"
    private String surnameEMP_driver_Fill_2;                  // "Фамилия"
    private String nameEMP_driver_Fill_2;                     // "Имя"
    private String patrNameEMP_driver_Fill_2;                 // "Отчество"
    private String startDateTimeEMP_driver_Fill_2;            // "Начало"
    private String endDateTimeEMP_driver_Fill_2;              // "Окончание"
    private String breakEMP_driver_Fill_2;                    // "Отклонение"
    private String replaceEMP_driver_Fill_2;                  // "Замена"


    /* ------------------------ Значения для столбцов в таблице "Транспорт" в модальном окне "Заполнить наряд на бригаду" 2---------------------- */

    private String workingPlaceTSFill_2;                      // "Рабочее место"
    private String resourceTSFill_2;                          // "Ресурс"
    private String startDateTimeTSFill_2;                     // "Начало"
    private String endDateTimeTSFill_2;                       // "Окончание"
    private String breakTSFill_2;                             // "Отклонение"
    private String replaceTSFill_2;                           // "Замена"


    private String colorOfRow;                                 // Значение цвета текста в таблице "Смены"
    private String changeBeginTime;                            // Значение столбца "Время начала смены"
    private String changeEndTime;                              // Значение столбца "Время окончания смены"
    private String colorOfOpenedRow;                          // Значение цвета текста в таблице "Смены" после принудительного начала
    /*------------------------- Значения для фильтра на странице Транспортное средство -------------------------------------------------------------*/

    private String activeTransportFilter;                     // "Действующий"


    public String getDoctor1PersonalCategoryCombobox() {
        return doctor1PersonalCategoryCombobox;
    }

    public void setDoctor1PersonalCategoryCombobox(String doctor1PersonalCategoryCombobox) {
        this.doctor1PersonalCategoryCombobox = doctor1PersonalCategoryCombobox;
    }

    public String getDoctor2PersonalCategoryCombobox() {
        return doctor2PersonalCategoryCombobox;
    }

    public void setDoctor2PersonalCategoryCombobox(String doctor2PersonalCategoryCombobox) {
        this.doctor2PersonalCategoryCombobox = doctor2PersonalCategoryCombobox;
    }

    public String getChangeBeginTime() {
        return changeBeginTime;
    }

    public void setChangeBeginTime(String changeBeginTime) {
        this.changeBeginTime = changeBeginTime;
    }

    public String getChangeEndTime() {
        return changeEndTime;
    }

    public void setChangeEndTime(String changeEndTime) {
        this.changeEndTime = changeEndTime;
    }

    public String getColorOfRow() {
        return colorOfRow;
    }

    public void setColorOfRow(String colorOfRow) {
        this.colorOfRow = colorOfRow;
    }

    public String getWorkingPlaceEMP_doctor_Fill_2() {
        return workingPlaceEMP_doctor_Fill_2;
    }

    public void setWorkingPlaceEMP_doctor_Fill_2(String workingPlaceEMP_doctor_Fill_2) {
        this.workingPlaceEMP_doctor_Fill_2 = workingPlaceEMP_doctor_Fill_2;
    }

    public String getSurnameEMP_doctor_Fill_2() {
        return surnameEMP_doctor_Fill_2;
    }

    public void setSurnameEMP_doctor_Fill_2(String surnameEMP_doctor_Fill_2) {
        this.surnameEMP_doctor_Fill_2 = surnameEMP_doctor_Fill_2;
    }

    public String getNameEMP_doctor_Fill_2() {
        return nameEMP_doctor_Fill_2;
    }

    public void setNameEMP_doctor_Fill_2(String nameEMP_doctor_Fill_2) {
        this.nameEMP_doctor_Fill_2 = nameEMP_doctor_Fill_2;
    }

    public String getPatrNameEMP_doctor_Fill_2() {
        return patrNameEMP_doctor_Fill_2;
    }

    public void setPatrNameEMP_doctor_Fill_2(String patrNameEMP_doctor_Fill_2) {
        this.patrNameEMP_doctor_Fill_2 = patrNameEMP_doctor_Fill_2;
    }

    public String getStartDateTimeEMP_doctor_Fill_2() {
        return startDateTimeEMP_doctor_Fill_2;
    }

    public void setStartDateTimeEMP_doctor_Fill_2(String startDateTimeEMP_doctor_Fill_2) {
        this.startDateTimeEMP_doctor_Fill_2 = startDateTimeEMP_doctor_Fill_2;
    }

    public String getEndDateTimeEMP_doctor_Fill_2() {
        return endDateTimeEMP_doctor_Fill_2;
    }

    public void setEndDateTimeEMP_doctor_Fill_2(String endDateTimeEMP_doctor_Fill_2) {
        this.endDateTimeEMP_doctor_Fill_2 = endDateTimeEMP_doctor_Fill_2;
    }

    public String getBreakEMP_doctor_Fill_2() {
        return breakEMP_doctor_Fill_2;
    }

    public void setBreakEMP_doctor_Fill_2(String breakEMP_doctor_Fill_2) {
        this.breakEMP_doctor_Fill_2 = breakEMP_doctor_Fill_2;
    }

    public String getReplaceEMP_doctor_Fill_2() {
        return replaceEMP_doctor_Fill_2;
    }

    public void setReplaceEMP_doctor_Fill_2(String replaceEMP_doctor_Fill_2) {
        this.replaceEMP_doctor_Fill_2 = replaceEMP_doctor_Fill_2;
    }

    public String getWorkingPlaceEMP_driver_Fill_2() {
        return workingPlaceEMP_driver_Fill_2;
    }

    public void setWorkingPlaceEMP_driver_Fill_2(String workingPlaceEMP_driver_Fill_2) {
        this.workingPlaceEMP_driver_Fill_2 = workingPlaceEMP_driver_Fill_2;
    }

    public String getSurnameEMP_driver_Fill_2() {
        return surnameEMP_driver_Fill_2;
    }

    public void setSurnameEMP_driver_Fill_2(String surnameEMP_driver_Fill_2) {
        this.surnameEMP_driver_Fill_2 = surnameEMP_driver_Fill_2;
    }

    public String getNameEMP_driver_Fill_2() {
        return nameEMP_driver_Fill_2;
    }

    public void setNameEMP_driver_Fill_2(String nameEMP_driver_Fill_2) {
        this.nameEMP_driver_Fill_2 = nameEMP_driver_Fill_2;
    }

    public String getPatrNameEMP_driver_Fill_2() {
        return patrNameEMP_driver_Fill_2;
    }

    public void setPatrNameEMP_driver_Fill_2(String patrNameEMP_driver_Fill_2) {
        this.patrNameEMP_driver_Fill_2 = patrNameEMP_driver_Fill_2;
    }

    public String getStartDateTimeEMP_driver_Fill_2() {
        return startDateTimeEMP_driver_Fill_2;
    }

    public void setStartDateTimeEMP_driver_Fill_2(String startDateTimeEMP_driver_Fill_2) {
        this.startDateTimeEMP_driver_Fill_2 = startDateTimeEMP_driver_Fill_2;
    }

    public String getEndDateTimeEMP_driver_Fill_2() {
        return endDateTimeEMP_driver_Fill_2;
    }

    public void setEndDateTimeEMP_driver_Fill_2(String endDateTimeEMP_driver_Fill_2) {
        this.endDateTimeEMP_driver_Fill_2 = endDateTimeEMP_driver_Fill_2;
    }

    public String getBreakEMP_driver_Fill_2() {
        return breakEMP_driver_Fill_2;
    }

    public void setBreakEMP_driver_Fill_2(String breakEMP_driver_Fill_2) {
        this.breakEMP_driver_Fill_2 = breakEMP_driver_Fill_2;
    }

    public String getReplaceEMP_driver_Fill_2() {
        return replaceEMP_driver_Fill_2;
    }

    public void setReplaceEMP_driver_Fill_2(String replaceEMP_driver_Fill_2) {
        this.replaceEMP_driver_Fill_2 = replaceEMP_driver_Fill_2;
    }

    public String getWorkingPlaceTSFill_2() {
        return workingPlaceTSFill_2;
    }

    public void setWorkingPlaceTSFill_2(String workingPlaceTSFill_2) {
        this.workingPlaceTSFill_2 = workingPlaceTSFill_2;
    }

    public String getResourceTSFill_2() {
        return resourceTSFill_2;
    }

    public void setResourceTSFill_2(String resourceTSFill_2) {
        this.resourceTSFill_2 = resourceTSFill_2;
    }

    public String getStartDateTimeTSFill_2() {
        return startDateTimeTSFill_2;
    }

    public void setStartDateTimeTSFill_2(String startDateTimeTSFill_2) {
        this.startDateTimeTSFill_2 = startDateTimeTSFill_2;
    }

    public String getEndDateTimeTSFill_2() {
        return endDateTimeTSFill_2;
    }

    public void setEndDateTimeTSFill_2(String endDateTimeTSFill_2) {
        this.endDateTimeTSFill_2 = endDateTimeTSFill_2;
    }

    public String getBreakTSFill_2() {
        return breakTSFill_2;
    }

    public void setBreakTSFill_2(String breakTSFill_2) {
        this.breakTSFill_2 = breakTSFill_2;
    }

    public String getReplaceTSFill_2() {
        return replaceTSFill_2;
    }

    public void setReplaceTSFill_2(String replaceTSFill_2) {
        this.replaceTSFill_2 = replaceTSFill_2;
    }

    public String getWorkingPlaceEMP_driver_Fill_1()
    {
        return workingPlaceEMP_driver_Fill_1;
    }

    public void setWorkingPlaceEMP_driver_Fill_1(String workingPlaceEMP_driver_Fill_1)
    {
        this.workingPlaceEMP_driver_Fill_1 = workingPlaceEMP_driver_Fill_1;
    }

    public String getSurnameEMP_driver_Fill_1()
    {
        return surnameEMP_driver_Fill_1;
    }

    public void setSurnameEMP_driver_Fill_1(String surnameEMP_driver_Fill_1)
    {
        this.surnameEMP_driver_Fill_1 = surnameEMP_driver_Fill_1;
    }

    public String getNameEMP_driver_Fill_1()
    {
        return nameEMP_driver_Fill_1;
    }

    public void setNameEMP_driver_Fill_1(String nameEMP_driver_Fill_1)
    {
        this.nameEMP_driver_Fill_1 = nameEMP_driver_Fill_1;
    }

    public String getPatrNameEMP_driver_Fill_1()
    {
        return patrNameEMP_driver_Fill_1;
    }

    public void setPatrNameEMP_driver_Fill_1(String patrNameEMP_driver_Fill_1)
    {
        this.patrNameEMP_driver_Fill_1 = patrNameEMP_driver_Fill_1;
    }

    public String getStartDateTimeEMP_driver_Fill_1()
    {
        return startDateTimeEMP_driver_Fill_1;
    }

    public void setStartDateTimeEMP_driver_Fill_1(String startDateTimeEMP_driver_Fill_1)
    {
        this.startDateTimeEMP_driver_Fill_1 = startDateTimeEMP_driver_Fill_1;
    }

    public String getEndDateTimeEMP_driver_Fill_1()
    {
        return endDateTimeEMP_driver_Fill_1;
    }

    public void setEndDateTimeEMP_driver_Fill_1(String endDateTimeEMP_driver_Fill_1)
    {
        this.endDateTimeEMP_driver_Fill_1 = endDateTimeEMP_driver_Fill_1;
    }

    public String getBreakEMP_driver_Fill_1()
    {
        return breakEMP_driver_Fill_1;
    }

    public void setBreakEMP_driver_Fill_1(String breakEMP_driver_Fill_1)
    {
        this.breakEMP_driver_Fill_1 = breakEMP_driver_Fill_1;
    }

    public String getReplaceEMP_driver_Fill_1()
    {
        return replaceEMP_driver_Fill_1;
    }

    public void setReplaceEMP_driver_Fill_1(String replaceEMP_driver_Fill_1)
    {
        this.replaceEMP_driver_Fill_1 = replaceEMP_driver_Fill_1;
    }

    public String getWorkingPlaceEMP_doctor_Fill_1()
    {
        return workingPlaceEMP_doctor_Fill_1;
    }

    public void setWorkingPlaceEMP_doctor_Fill_1(String workingPlaceEMP_doctor_Fill_1)
    {
        this.workingPlaceEMP_doctor_Fill_1 = workingPlaceEMP_doctor_Fill_1;
    }

    public String getSurnameEMP_doctor_Fill_1()
    {
        return surnameEMP_doctor_Fill_1;
    }

    public void setSurnameEMP_doctor_Fill_1(String surnameEMP_doctor_Fill_1)
    {
        this.surnameEMP_doctor_Fill_1 = surnameEMP_doctor_Fill_1;
    }

    public String getNameEMP_doctor_Fill_1()
    {
        return nameEMP_doctor_Fill_1;
    }

    public void setNameEMP_doctor_Fill_1(String nameEMP_doctor_Fill_1)
    {
        this.nameEMP_doctor_Fill_1 = nameEMP_doctor_Fill_1;
    }

    public String getPatrNameEMP_doctor_Fill_1()
    {
        return patrNameEMP_doctor_Fill_1;
    }

    public String getResourceTSFill_1()
    {
        return resourceTSFill_1;
    }

    public void setResourceTSFill_1(String resourceTSFill_1)
    {
        this.resourceTSFill_1 = resourceTSFill_1;
    }

    public void setPatrNameEMP_doctor_Fill_1(String patrNameEMP_doctor_Fill_1)
    {
        this.patrNameEMP_doctor_Fill_1 = patrNameEMP_doctor_Fill_1;
    }

    public String getStartDateTimeEMP_doctor_Fill_1()
    {
        return startDateTimeEMP_doctor_Fill_1;
    }

    public void setStartDateTimeEMP_doctor_Fill_1(String startDateTimeEMP_doctor_Fill_1)
    {
        this.startDateTimeEMP_doctor_Fill_1 = startDateTimeEMP_doctor_Fill_1;
    }

    public String getEndDateTimeEMP_doctor_Fill_1()
    {
        return endDateTimeEMP_doctor_Fill_1;
    }

    public void setEndDateTimeEMP_doctor_Fill_1(String endDateTimeEMP_doctor_Fill_1)
    {
        this.endDateTimeEMP_doctor_Fill_1 = endDateTimeEMP_doctor_Fill_1;
    }

    public String getBreakEMP_doctor_Fill_1()
    {
        return breakEMP_doctor_Fill_1;
    }

    public void setBreakEMP_doctor_Fill_1(String breakEMP_doctor_Fill_1)
    {
        this.breakEMP_doctor_Fill_1 = breakEMP_doctor_Fill_1;
    }

    public String getReplaceEMP_doctor_Fill_1()
    {
        return replaceEMP_doctor_Fill_1;
    }

    public void setReplaceEMP_doctor_Fill_1(String replaceEMP_doctor_Fill_1)
    {
        this.replaceEMP_doctor_Fill_1 = replaceEMP_doctor_Fill_1;
    }

    public String getWorkingPlaceTSFill_1()
    {
        return workingPlaceTSFill_1;
    }

    public void setWorkingPlaceTSFill_1(String workingPlaceTSFill_1)
    {
        this.workingPlaceTSFill_1 = workingPlaceTSFill_1;
    }

    public String getStartDateTimeTSFill_1()
    {
        return startDateTimeTSFill_1;
    }

    public void setStartDateTimeTSFill_1(String startDateTimeTSFill_1)
    {
        this.startDateTimeTSFill_1 = startDateTimeTSFill_1;
    }

    public String getEndDateTimeTSFill_1()
    {
        return endDateTimeTSFill_1;
    }

    public void setEndDateTimeTSFill_1(String endDateTimeTSFill_1)
    {
        this.endDateTimeTSFill_1 = endDateTimeTSFill_1;
    }

    public String getBreakTSFill_1()
    {
        return breakTSFill_1;
    }

    public void setBreakTSFill_1(String breakTSFill_1)
    {
        this.breakTSFill_1 = breakTSFill_1;
    }

    public String getReplaceTSFill_1()
    {
        return replaceTSFill_1;
    }

    public void setReplaceTSFill_1(String replaceTSFill_1)
    {
        this.replaceTSFill_1 = replaceTSFill_1;
    }

    public String getFillJobToBrigade1ModalHeader()
    {
        return fillJobToBrigade1ModalHeader;
    }

    public void setFillJobToBrigade1ModalHeader(String fillJobToBrigade1ModalHeader)
    {
        this.fillJobToBrigade1ModalHeader = fillJobToBrigade1ModalHeader;
    }

    public String getFillJobToBrigade2ModalHeader()
    {
        return fillJobToBrigade2ModalHeader;
    }

    public void setFillJobToBrigade2ModalHeader(String fillJobToBrigade2ModalHeader)
    {
        this.fillJobToBrigade2ModalHeader = fillJobToBrigade2ModalHeader;
    }

    public String getResource5()
    {
        return resource5;
    }

    public void setResource5(String resource5)
    {
        this.resource5 = resource5;
    }

    public String getResource5Full()
    {
        return resource5Full;
    }

    public void setResource5Full(String resource5Full)
    {
        this.resource5Full = resource5Full;
    }

    public String getResource4Full()
    {
        return resource4Full;
    }

    public void setResource4Full(String resource4Full)
    {
        this.resource4Full = resource4Full;
    }

    public String getResource4()
    {
        return resource4;
    }

    public void setResource4(String resource4)
    {
        this.resource4 = resource4;
    }

    public String getBrigadeJob2()
    {
        return brigadeJob2;
    }

    public void setBrigadeJob2(String brigadeJob2)
    {
        this.brigadeJob2 = brigadeJob2;
    }

    public String getCheckTransportNumber2()
    {
        return checkTransportNumber2;
    }

    public void setCheckTransportNumber2(String checkTransportNumber2)
    {
        this.checkTransportNumber2 = checkTransportNumber2;
    }

    public String getCreateTransportNumber2()
    {
        return createTransportNumber2;
    }

    public void setCreateTransportNumber2(String createTransportNumber2)
    {
        this.createTransportNumber2 = createTransportNumber2;
    }

    public String getAddJobTS2ModalHeader()
    {
        return addJobTS2ModalHeader;
    }

    public void setAddJobTS2ModalHeader(String addJobTS2ModalHeader)
    {
        this.addJobTS2ModalHeader = addJobTS2ModalHeader;
    }

    public String getAddJobPerson2ModalHeader()
    {
        return addJobPerson2ModalHeader;
    }

    public void setAddJobPerson2ModalHeader(String addJobPerson2ModalHeader)
    {
        this.addJobPerson2ModalHeader = addJobPerson2ModalHeader;
    }

    public String getEditJobPerson2ModalHeader()
    {
        return editJobPerson2ModalHeader;
    }

    public void setEditJobPerson2ModalHeader(String editJobPerson2ModalHeader)
    {
        this.editJobPerson2ModalHeader = editJobPerson2ModalHeader;
    }

    public String getBrigadeName()
    {
        return brigadeName;
    }

    public void setBrigadeName(String brigadeName)
    {
        this.brigadeName = brigadeName;
    }
    public String getBrigadeName2()
    {
        return brigadeName2;
    }

    public void setBrigadeName2(String brigadeName2)
    {
        this.brigadeName2 = brigadeName2;
    }

    public String getCode2Value()
    {
        return code2Value;
    }

    public void setCode2Value(String code2Value)
    {
        this.code2Value = code2Value;
    }

    public String getRadioCode2()
    {
        return radioCode2;
    }

    public void setRadioCode2(String radioCode2)
    {
        this.radioCode2 = radioCode2;
    }

    public String getName2Value()
    {
        return name2Value;
    }

    public void setName2Value(String name2Value)
    {
        this.name2Value = name2Value;
    }

    public String getResourceKindTransport()
    {
        return resourceKindTransport;
    }

    public void setResourceKindTransport(String resourceKindTransport)
    {
        this.resourceKindTransport = resourceKindTransport;
    }

    public String getResource1Full()
    {
        return resource1Full;
    }

    public void setResource1Full(String resource1Full)
    {
        this.resource1Full = resource1Full;
    }

    public String getResource2Full()
    {
        return resource2Full;
    }

    public void setResource2Full(String resource2Full)
    {
        this.resource2Full = resource2Full;
    }

    public String getResource3Full()
    {
        return resource3Full;
    }

    public void setResource3Full(String resource3Full)
    {
        this.resource3Full = resource3Full;
    }

    public String getAddJobTSModalHeader()
    {
        return addJobTSModalHeader;
    }

    public void setAddJobTSModalHeader(String addJobTSModalHeader)
    {
        this.addJobTSModalHeader = addJobTSModalHeader;
    }

    public String getWorkingPlace2Driver()
    {
        return workingPlace2Driver;
    }

    public void setWorkingPlace2Driver(String workingPlace2Driver)
    {
        this.workingPlace2Driver = workingPlace2Driver;
    }

    public String getWorkingPlaceInTemplateDriver()
    {
        return workingPlaceInTemplateDriver;
    }

    public void setWorkingPlaceInTemplateDriver(String workingPlaceInTemplateDriver)
    {
        this.workingPlaceInTemplateDriver = workingPlaceInTemplateDriver;
    }

    public String getResource2()
    {
        return resource2;
    }

    public void setResource2(String resource2)
    {
        this.resource2 = resource2;
    }

    public String getResource3()
    {
        return resource3;
    }

    public void setResource3(String resource3)
    {
        this.resource3 = resource3;
    }

    public String getSuccessJobPersonCreatingMessage()
    {
        return successJobPersonCreatingMessage;
    }

    public void setSuccessJobPersonCreatingMessage(String successJobPersonCreatingMessage)
    {
        this.successJobPersonCreatingMessage = successJobPersonCreatingMessage;
    }

    public String getBrigadeJob()
    {
        return brigadeJob;
    }

    public void setBrigadeJob(String brigadeJob)
    {
        this.brigadeJob = brigadeJob;
    }

    public String getHasTeamJob()
    {
        return hasTeamJob;
    }

    public void setHasTeamJob(String hasTeamJob)
    {
        this.hasTeamJob = hasTeamJob;
    }

    public String getResourceKind()
    {
        return resourceKind;
    }

    public void setResourceKind(String resourceKind)
    {
        this.resourceKind = resourceKind;
    }

    public String getWorkingPlaceInTemplate()
    {
        return workingPlaceInTemplate;
    }

    public void setWorkingPlaceInTemplate(String workingPlaceInTemplate)
    {
        this.workingPlaceInTemplate = workingPlaceInTemplate;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getWorkingPlace2()
    {
        return workingPlace2;
    }

    public void setWorkingPlace2(String workingPlace2)
    {
        this.workingPlace2 = workingPlace2;
    }

    public String getResource1()
    {
        return resource1;
    }

    public void setResource1(String resource1)
    {
        this.resource1 = resource1;
    }

    public String getJobKind()
    {
        return jobKind;
    }

    public void setJobKind(String jobKind)
    {
        this.jobKind = jobKind;
    }

    public String getOlderInJob()
    {
        return olderInJob;
    }

    public void setOlderInJob(String olderInJob)
    {
        this.olderInJob = olderInJob;
    }

    public String getBeginDateTime()
    {
        return beginDateTime;
    }

    public void setBeginDateTime(String beginDateTime)
    {
        this.beginDateTime = beginDateTime;
    }

    public String getEndDateTime()
    {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime)
    {
        this.endDateTime = endDateTime;
    }

    public String getSuccessJobTeamCreatingMessage()
    {
        return successJobTeamCreatingMessage;
    }

    public void setSuccessJobTeamCreatingMessage(String successJobTeamCreatingMessage)
    {
        this.successJobTeamCreatingMessage = successJobTeamCreatingMessage;
    }

    public String getJobSubStation()
    {
        return jobSubStation;
    }

    public void setJobSubStation(String jobSubStation)
    {
        this.jobSubStation = jobSubStation;
    }

    public String getJobDate()
    {
        return jobDate;
    }

    public void setJobDate(String jobDate)
    {
        this.jobDate = jobDate;
    }

    public String getJobBrigade()
    {
        return jobBrigade;
    }

    public void setJobBrigade(String jobBrigade)
    {
        this.jobBrigade = jobBrigade;
    }

    public String getJobStation()
    {
        return jobStation;
    }

    public void setJobStation(String jobStation)
    {
        this.jobStation = jobStation;
    }

    public String getAddTeamJobModalHeader()
    {
        return addTeamJobModalHeader;
    }

    public void setAddTeamJobModalHeader(String addTeamJobModalHeader)
    {
        this.addTeamJobModalHeader = addTeamJobModalHeader;
    }

    public String getSuccessTransportEditingMessage()
    {
        return successTransportEditingMessage;
    }

    public void setSuccessTransportEditingMessage(String successTransportEditingMessage)
    {
        this.successTransportEditingMessage = successTransportEditingMessage;
    }

    public String getEditTransportCardModalHeader()
    {
        return editTransportCardModalHeader;
    }

    public void setEditTransportCardModalHeader(String editTransportCardModalHeader)
    {
        this.editTransportCardModalHeader = editTransportCardModalHeader;
    }

    public String getCheckTransportNumber()
    {
        return checkTransportNumber;
    }

    public void setCheckTransportNumber(String checkTransportNumber)
    {
        this.checkTransportNumber = checkTransportNumber;
    }

    public String getSuccessBrigadeCreatingMessage()
    {
        return successBrigadeCreatingMessage;
    }

    public void setSuccessBrigadeCreatingMessage(String successBrigadeCreatingMessage)
    {
        this.successBrigadeCreatingMessage = successBrigadeCreatingMessage;
    }

    public String getSuccessTransportCreatingMessage()
    {
        return successTransportCreatingMessage;
    }

    public void setSuccessTransportCreatingMessage(String successTransportCreatingMessage)
    {
        this.successTransportCreatingMessage = successTransportCreatingMessage;
    }

    public String getCreateTransportCategoryEdited()
    {
        return createTransportCategoryEdited;
    }

    public void setCreateTransportCategoryEdited(String createTransportCategoryEdited)
    {
        this.createTransportCategoryEdited = createTransportCategoryEdited;
    }

    public String getCreateTransportNumber()
    {
        return createTransportNumber;
    }

    public void setCreateTransportNumber(String createTransportNumber)
    {
        this.createTransportNumber = createTransportNumber;
    }

    public String getCreateTransportEquipmentKind()
    {
        return createTransportEquipmentKind;
    }

    public void setCreateTransportEquipmentKind(String createTransportEquipmentKind)
    {
        this.createTransportEquipmentKind = createTransportEquipmentKind;
    }

    public String getCreateTransportCategory()
    {
        return createTransportCategory;
    }

    public void setCreateTransportCategory(String createTransportCategory)
    {
        this.createTransportCategory = createTransportCategory;
    }

    public String getCreateTransportModalHeader()
    {
        return createTransportModalHeader;
    }

    public void setCreateTransportModalHeader(String createTransportModalHeader)
    {
        this.createTransportModalHeader = createTransportModalHeader;
    }

    public String getSubStation()
    {
        return subStation;
    }

    public void setSubStation(String subStation)
    {
        this.subStation = subStation;
    }

    public String getRadioCode()
    {
        return radioCode;
    }

    public void setRadioCode(String radioCode)
    {
        this.radioCode = radioCode;
    }

    public String getBeginWorkTime()
    {
        return beginWorkTime;
    }

    public void setBeginWorkTime(String beginWorkTime)
    {
        this.beginWorkTime = beginWorkTime;
    }

    public String getEndWorkTime()
    {
        return endWorkTime;
    }

    public void setEndWorkTime(String endWorkTime)
    {
        this.endWorkTime = endWorkTime;
    }

    public String getMedProfile()
    {
        return medProfile;
    }

    public void setMedProfile(String medProfile)
    {
        this.medProfile = medProfile;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public String getBeginAction()
    {
        return beginAction;
    }

    public void setBeginAction(String beginAction)
    {
        this.beginAction = beginAction;
    }

    public String getEndAction()
    {
        return endAction;
    }

    public void setEndAction(String endAction)
    {
        this.endAction = endAction;
    }

    public String getAddBrigadeModalHeader()
    {
        return addBrigadeModalHeader;
    }

    public void setAddBrigadeModalHeader(String addBrigadeModalHeader)
    {
        this.addBrigadeModalHeader = addBrigadeModalHeader;
    }

    public String getNameEdited()
    {
        return nameEdited;
    }

    public void setNameEdited(String nameEdited)
    {
        this.nameEdited = nameEdited;
    }

    public String getEditBrigadeViewTemplateModalHeader()
    {
        return editBrigadeViewTemplateModalHeader;
    }

    public void setEditBrigadeViewTemplateModalHeader(String editBrigadeViewTemplateModalHeader)
    {
        this.editBrigadeViewTemplateModalHeader = editBrigadeViewTemplateModalHeader;
    }

    public String getEquipmentKindEdited()
    {
        return equipmentKindEdited;
    }

    public void setEquipmentKindEdited(String equipmentKindEdited)
    {
        this.equipmentKindEdited = equipmentKindEdited;
    }

    public String getEditTransportModalHeader()
    {
        return editTransportModalHeader;
    }

    public void setEditTransportModalHeader(String editTransportModalHeader)
    {
        this.editTransportModalHeader = editTransportModalHeader;
    }

    public String getSuccessTransportAddingMessage()
    {
        return successTransportAddingMessage;
    }

    public void setSuccessTransportAddingMessage(String successTransportAddingMessage)
    {
        this.successTransportAddingMessage = successTransportAddingMessage;
    }

    public String getTransportRole()
    {
        return transportRole;
    }

    public void setTransportRole(String transportRole)
    {
        this.transportRole = transportRole;
    }

    public String getTransportWorkingPlace()
    {
        return transportWorkingPlace;
    }

    public void setTransportWorkingPlace(String transportWorkingPlace)
    {
        this.transportWorkingPlace = transportWorkingPlace;
    }

    public String getTsType()
    {
        return tsType;
    }

    public void setTsType(String tsType)
    {
        this.tsType = tsType;
    }

    public String getEquipmentKind()
    {
        return equipmentKind;
    }

    public void setEquipmentKind(String equipmentKind)
    {
        this.equipmentKind = equipmentKind;
    }

    public String getAddTransportModalHeader()
    {
        return addTransportModalHeader;
    }

    public void setAddTransportModalHeader(String addTransportModalHeader)
    {
        this.addTransportModalHeader = addTransportModalHeader;
    }

    public String getSuccessEmployeeEditingMessage()
    {
        return successEmployeeEditingMessage;
    }

    public void setSuccessEmployeeEditingMessage(String successEmployeeEditingMessage)
    {
        this.successEmployeeEditingMessage = successEmployeeEditingMessage;
    }

    public String getDoctor2Position()
    {
        return doctor2Position;
    }

    public void setDoctor2Position(String doctor2Position)
    {
        this.doctor2Position = doctor2Position;
    }

    public String getEditEmployeeModalHeader()
    {
        return editEmployeeModalHeader;
    }

    public void setEditEmployeeModalHeader(String editEmployeeModalHeader)
    {
        this.editEmployeeModalHeader = editEmployeeModalHeader;
    }

    public String getDoctor2Speciality()
    {
        return doctor2Speciality;
    }

    public void setDoctor2Speciality(String doctor2Speciality)
    {
        this.doctor2Speciality = doctor2Speciality;
    }

    public String getDoctor1Role()
    {
        return doctor1Role;
    }

    public void setDoctor1Role(String doctor1Role)
    {
        this.doctor1Role = doctor1Role;
    }

    public String getDoctor1PersonalCategory()
    {
        return doctor1PersonalCategory;
    }

    public void setDoctor1PersonalCategory(String doctor1PersonalCategory)
    {
        this.doctor1PersonalCategory = doctor1PersonalCategory;
    }

    public String getDoctor1WorkingPlace()
    {
        return doctor1WorkingPlace;
    }

    public void setDoctor1WorkingPlace(String doctor1WorkingPlace)
    {
        this.doctor1WorkingPlace = doctor1WorkingPlace;
    }

    public String getDoctor2Role()
    {
        return doctor2Role;
    }

    public void setDoctor2Role(String doctor2Role)
    {
        this.doctor2Role = doctor2Role;
    }

    public String getDoctor2PersonalCategory()
    {
        return doctor2PersonalCategory;
    }

    public void setDoctor2PersonalCategory(String doctor2PersonalCategory)
    {
        this.doctor2PersonalCategory = doctor2PersonalCategory;
    }

    public String getDoctor2WorkingPlace()
    {
        return doctor2WorkingPlace;
    }

    public void setDoctor2WorkingPlace(String doctor2WorkingPlace)
    {
        this.doctor2WorkingPlace = doctor2WorkingPlace;
    }

    public String getDriverRole()
    {
        return driverRole;
    }

    public void setDriverRole(String driverRole)
    {
        this.driverRole = driverRole;
    }

    public String getDriverPersonalCategory()
    {
        return driverPersonalCategory;
    }

    public void setDriverPersonalCategory(String driverPersonalCategory)
    {
        this.driverPersonalCategory = driverPersonalCategory;
    }

    public String getDriverWorkingPlace()
    {
        return driverWorkingPlace;
    }

    public void setDriverWorkingPlace(String driverWorkingPlace)
    {
        this.driverWorkingPlace = driverWorkingPlace;
    }

    public String getSuccessEmployeeAddingMessage()
    {
        return successEmployeeAddingMessage;
    }

    public void setSuccessEmployeeAddingMessage(String successEmployeeAddingMessage)
    {
        this.successEmployeeAddingMessage = successEmployeeAddingMessage;
    }

    public String getAddEmployeeModalHeader()
    {
        return addEmployeeModalHeader;
    }

    public void setAddEmployeeModalHeader(String addEmployeeModalHeader)
    {
        this.addEmployeeModalHeader = addEmployeeModalHeader;
    }

    public String getSuccessBrigadeViewTemplateMessage()
    {
        return successBrigadeViewTemplateMessage;
    }

    public void setSuccessBrigadeViewTemplateMessage(String successBrigadeViewTemplateMessage)
    {
        this.successBrigadeViewTemplateMessage = successBrigadeViewTemplateMessage;
    }

    public String getCodeValue()
    {
        return codeValue;
    }

    public void setCodeValue(String codeValue)
    {
        this.codeValue = codeValue;
    }

    public String getNameValue()
    {
        return nameValue;
    }

    public void setNameValue(String nameValue)
    {
        this.nameValue = nameValue;
    }

    public String getBrigadeKindValue()
    {
        return brigadeKindValue;
    }

    public void setBrigadeKindValue(String brigadeKindValue)
    {
        this.brigadeKindValue = brigadeKindValue;
    }

    public String getJobKindValue()
    {
        return jobKindValue;
    }

    public void setJobKindValue(String jobKindValue)
    {
        this.jobKindValue = jobKindValue;
    }

    public String getBrigadeTypeValue()
    {
        return brigadeTypeValue;
    }

    public void setBrigadeTypeValue(String brigadeTypeValue)
    {
        this.brigadeTypeValue = brigadeTypeValue;
    }

    public String getProfileValue()
    {
        return profileValue;
    }

    public void setProfileValue(String profileValue)
    {
        this.profileValue = profileValue;
    }

    public String getAddBrigadeViewTemplateModalHeader()
    {
        return addBrigadeViewTemplateModalHeader;
    }

    public void setAddBrigadeViewTemplateModalHeader(String addBrigadeViewTemplateModalHeader)
    {
        this.addBrigadeViewTemplateModalHeader = addBrigadeViewTemplateModalHeader;
    }

    public String getContextName()
    {
        return contextName;
    }

    public void setContextName(String contextName)
    {
        this.contextName = contextName;
    }

    public String getAddJobPersonModalHeader()
    {
        return addJobPersonModalHeader;
    }

    public void setAddJobPersonModalHeader(String addJobPersonModalHeader)
    {
        this.addJobPersonModalHeader = addJobPersonModalHeader;
    }

    public String getEditJobPersonModalHeader()
    {
        return editJobPersonModalHeader;
    }

    public void setEditJobPersonModalHeader(String editJobPersonModalHeader)
    {
        this.editJobPersonModalHeader = editJobPersonModalHeader;
    }

    public String getActiveTransportFilter() {
        return activeTransportFilter;
    }

    public void setActiveTransportFilter(String activeTransportFilter) {
        this.activeTransportFilter = activeTransportFilter;
    }

    public String getColorOfOpenedRow() {
        return colorOfOpenedRow;
    }

    public void setColorOfOpenedRow(String colorOfOpenedRow) {
        this.colorOfOpenedRow = colorOfOpenedRow;
    }

    public String getJobTeamStartFlag() {
        return jobTeamStartFlag;
    }

    public void setJobTeamStartFlag(String jobTeamStartFlag) {
        this.jobTeamStartFlag = jobTeamStartFlag;
    }

    public String getWorkplaceColumnName() {
        return workplaceColumnName;
    }

    public void setWorkplaceColumnName(String workplaceColumnName) {
        this.workplaceColumnName = workplaceColumnName;
    }

    public String getWorkplaceName() {
        return workplaceName;
    }

    public void setWorkplaceName(String workplaceName) {
        this.workplaceName = workplaceName;
    }

    public String getRefusalDeviation() {
        return refusalDeviation;
    }

    public void setRefusalDeviation(String refusalDeviation) {
        this.refusalDeviation = refusalDeviation;
    }
}
