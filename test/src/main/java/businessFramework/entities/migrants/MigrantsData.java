package businessFramework.entities.migrants;


public class MigrantsData
{


    private String contextName;                     // Наименование контекста
    private String eventName;                       // Название мероприятия

    /** ---------------------- Данные для заполнения и проверки значений в полях на форме в контейнере "Карточка мероприятия" ----------------------------*/

    // Значение поля "Название мероприятия" берется из eventName


    private String eventTypeValue;                  // Значение поля "Вид мероприятия"
    private String organisationValue;               // Значение поля "Организация"
    private String financingTypeValue;              // Значение поля "Вид финансирования"
    private String beginDateValue;                  // Значение поля "Дата начала"
    private String endDateValue;                    // Значение поля "Дата окончания"
    private String standartValue;                   // Значение поля "Стандарт лечения"


    
    /** ---------------------- Данные для изменения и проверки значений в полях на форме в контейнере "Карточка мероприятия" ----------------------------*/


    private String eventNameValueEdited;            // Значение поля "Наименование"
    private String beginDateValueEdited;            // Значение поля "Дата начала"
    private String endDateValueEdited;              // Значение поля "Дата окончания"

    private String successEditingEventAlertMessage;     // Текст сообщения об успешном сохранении данных на форме в контейнере "Карточка мероприятия"
    private String successSavingCommonDataAlertMessage; // Текст сообщения об успешном сохранении данных на странице "Добавить пациента" на форме в контейнере "Общие данные"
    private String successSavingServiceAlertMessage;    // Текст сообщения об успешном сохранении данных на странице "Добавить пациента" на форме в контейнере "Общие данные"


    /** ---------------------- Заголовки модальных окон ----------------------------*/


    private String setModelModalHeader;             // Заголовок модального окна "Назначить модель"
    private String patientModelsListHeader;         // Заголовок модального окна "Список моделей пациента"
    private String attachModelModalHeader;          // Заголовок модального окна "Задать модель"
    private String searchPatientModalHeader;        // Заголовок модального окна "Поиск пациентов"


    /** ---------------------- Данные для заполнения и проверки значений в полях на форме в контейнере "Карточка мероприятия" ----------------------------*/

    private String patientSearchSurname;
    private String patientSearchName;
    private String patientSearchPatrName;
    private String patientSearchBirthDate;
    private String patientSearchDocNumber;

    /** ---------------------- Данные для заполнение полей в модальном окне "Выполнение услуги" ----------------------------*/

    private String serviceExecutionOrganisation;

    /** ---------------------- Данные для заполнение полей в контейнере "Заключение" ----------------------------*/

    private String conclusionSertificateNumber;
    private String conclusionNumber;

    /** ---------------------- Данные для заполнение полей в модальном окне "Закрытие карты" ----------------------------*/

    private String closingCardReason;

    /** ----------------------     Данные для проверки значений в таблице на странице "Комиссия" ----------------------------*/

    private String conclusionStatus;


    public String getSuccessSavingServiceAlertMessage()
    {
        return successSavingServiceAlertMessage;
    }

    public void setSuccessSavingServiceAlertMessage(String successSavingServiceAlertMessage)
    {
        this.successSavingServiceAlertMessage = successSavingServiceAlertMessage;
    }

    public String getSuccessSavingCommonDataAlertMessage()
    {
        return successSavingCommonDataAlertMessage;
    }

    public void setSuccessSavingCommonDataAlertMessage(String successSavingCommonDataAlertMessage)
    {
        this.successSavingCommonDataAlertMessage = successSavingCommonDataAlertMessage;
    }

    public String getPatientSearchSurname()
    {
        return patientSearchSurname;
    }

    public void setPatientSearchSurname(String patientSearchSurname)
    {
        this.patientSearchSurname = patientSearchSurname;
    }

    public String getPatientSearchName()
    {
        return patientSearchName;
    }

    public void setPatientSearchName(String patientSearchName)
    {
        this.patientSearchName = patientSearchName;
    }

    public String getPatientSearchPatrName()
    {
        return patientSearchPatrName;
    }

    public void setPatientSearchPatrName(String patientSearchPatrName)
    {
        this.patientSearchPatrName = patientSearchPatrName;
    }

    public String getPatientSearchBirthDate()
    {
        return patientSearchBirthDate;
    }

    public void setPatientSearchBirthDate(String patientSearchBirthDate)
    {
        this.patientSearchBirthDate = patientSearchBirthDate;
    }

    public String getPatientSearchDocNumber()
    {
        return patientSearchDocNumber;
    }

    public void setPatientSearchDocNumber(String patientSearchDocNumber)
    {
        this.patientSearchDocNumber = patientSearchDocNumber;
    }

    public String getSearchPatientModalHeader()
    {
        return searchPatientModalHeader;
    }

    public void setSearchPatientModalHeader(String searchPatientModalHeader)
    {
        this.searchPatientModalHeader = searchPatientModalHeader;
    }

    public String getAttachModelModalHeader()
    {
        return attachModelModalHeader;
    }

    public void setAttachModelModalHeader(String attachModelModalHeader)
    {
        this.attachModelModalHeader = attachModelModalHeader;
    }

    public String getPatientModelsListHeader()
    {
        return patientModelsListHeader;
    }

    public void setPatientModelsListHeader(String patientModelsListHeader)
    {
        this.patientModelsListHeader = patientModelsListHeader;
    }

    public String getSetModelModalHeader()
    {
        return setModelModalHeader;
    }

    public void setSetModelModalHeader(String setModelModalHeader)
    {
        this.setModelModalHeader = setModelModalHeader;
    }

    public String getContextName()
    {
        return contextName;
    }

    public void setContextName(String contextName)
    {
        this.contextName = contextName;
    }

    public String getSuccessEditingEventAlertMessage()
    {
        return successEditingEventAlertMessage;
    }

    public void setSuccessEditingEventAlertMessage(String successEditingEventAlertMessage)
    {
        this.successEditingEventAlertMessage = successEditingEventAlertMessage;
    }

    public String getEventNameValueEdited()
    {
        return eventNameValueEdited;
    }

    public void setEventNameValueEdited(String eventNameValueEdited)
    {
        this.eventNameValueEdited = eventNameValueEdited;
    }

    public String getBeginDateValueEdited()
    {
        return beginDateValueEdited;
    }

    public void setBeginDateValueEdited(String beginDateValueEdited)
    {
        this.beginDateValueEdited = beginDateValueEdited;
    }

    public String getEndDateValueEdited()
    {
        return endDateValueEdited;
    }

    public void setEndDateValueEdited(String endDateValueEdited)
    {
        this.endDateValueEdited = endDateValueEdited;
    }

    public String getEventTypeValue()
    {
        return eventTypeValue;
    }

    public void setEventTypeValue(String eventTypeValue)
    {
        this.eventTypeValue = eventTypeValue;
    }

    public String getOrganisationValue()
    {
        return organisationValue;
    }

    public void setOrganisationValue(String organisationValue)
    {
        this.organisationValue = organisationValue;
    }

    public String getFinancingTypeValue()
    {
        return financingTypeValue;
    }

    public void setFinancingTypeValue(String financingTypeValue)
    {
        this.financingTypeValue = financingTypeValue;
    }

    public String getBeginDateValue()
    {
        return beginDateValue;
    }

    public void setBeginDateValue(String beginDateValue)
    {
        this.beginDateValue = beginDateValue;
    }

    public String getEndDateValue()
    {
        return endDateValue;
    }

    public void setEndDateValue(String endDateValue)
    {
        this.endDateValue = endDateValue;
    }

    public String getStandartValue()
    {
        return standartValue;
    }

    public void setStandartValue(String standartValue)
    {
        this.standartValue = standartValue;
    }

    public String getEventName()
    {
        return eventName;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public String getServiceExecutionOrganisation() {
        return serviceExecutionOrganisation;
    }

    public void setServiceExecutionOrganisation(String serviceExecutionOrganisation) {
        this.serviceExecutionOrganisation = serviceExecutionOrganisation;
    }

    public String getConclusionSertificateNumber() {
        return conclusionSertificateNumber;
    }

    public void setConclusionSertificateNumber(String conclusionSertificateNumber) {
        this.conclusionSertificateNumber = conclusionSertificateNumber;
    }

    public String getClosingCardReason() {
        return closingCardReason;
    }

    public void setClosingCardReason(String closingCardReason) {
        this.closingCardReason = closingCardReason;
    }

    public String getConclusionStatus() {
        return conclusionStatus;
    }

    public void setConclusionStatus(String conclusionStatus) {
        this.conclusionStatus = conclusionStatus;
    }

    public String getConclusionNumber() {
        return conclusionNumber;
    }

    public void setConclusionNumber(String conclusionNumber) {
        this.conclusionNumber = conclusionNumber;
    }
}
