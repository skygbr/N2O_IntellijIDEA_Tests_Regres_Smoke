package businessFramework.entities.dispensary;

public class DispensaryData
{
    // Данные для выбора контекста
    private String contextName;

    // Данные полей в контейнере "Карточка мероприятия"
    private String checkedEventName;
    private String checkedEventYear;
    private String checkedEventType;
    private String checkedOrganisationName;
    private String checkedFundingType;
    private String checkedBeginDate;
    private String checkedEndDate;
    private String checkedStandart;

    // Данные для изменения в контейнере "Карточка мероприятия"
    private String changedEventName;
    private String changedBeginDate;
    private String changedEndDate;

    // Данные для полей в модальном окне "Поиск пациентов"
    private String patientsSearchSurname;
    private String patientsSearchName;
    private String patientsSearchPatrName;
    private String patientsSearchBirthDate;
    private String patientsSearchDocumentNumber;

    // Данные для страницы "Карточка"
    private String fioDriverCard;
    private String genderDriverCard;
    private String birthDateDriverCard;

    //Данные для модального окна "Изменить назначения"
    private String appointmentName;


    public String getContextName() {
        return contextName;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    public String getCheckedEventName() {
        return checkedEventName;
    }

    public void setCheckedEventName(String checkedEventName) {
        this.checkedEventName = checkedEventName;
    }

    public String getCheckedEventType() {
        return checkedEventType;
    }

    public void setCheckedEventType(String checkedEventType) {
        this.checkedEventType = checkedEventType;
    }

    public String getCheckedOrganisationName() {
        return checkedOrganisationName;
    }

    public void setCheckedOrganisationName(String checkedOrganisationName) {
        this.checkedOrganisationName = checkedOrganisationName;
    }

    public String getCheckedFundingType() {
        return checkedFundingType;
    }

    public void setCheckedFundingType(String checkedFundingType) {
        this.checkedFundingType = checkedFundingType;
    }

    public String getCheckedBeginDate() {
        return checkedBeginDate;
    }

    public void setCheckedBeginDate(String checkedBeginDate) {
        this.checkedBeginDate = checkedBeginDate;
    }

    public String getCheckedEndDate() {
        return checkedEndDate;
    }

    public void setCheckedEndDate(String checkedEndDate) {
        this.checkedEndDate = checkedEndDate;
    }

    public String getCheckedStandart() {
        return checkedStandart;
    }

    public void setCheckedStandart(String checkedStandart) {
        this.checkedStandart = checkedStandart;
    }

    public String getChangedEventName() {
        return changedEventName;
    }

    public void setChangedEventName(String changedEventName) {
        this.changedEventName = changedEventName;
    }

    public String getChangedBeginDate() {
        return changedBeginDate;
    }

    public void setChangedBeginDate(String changedBeginDate) {
        this.changedBeginDate = changedBeginDate;
    }

    public String getChangedEndDate() {
        return changedEndDate;
    }

    public void setChangedEndDate(String changedEndDate) {
        this.changedEndDate = changedEndDate;
    }

    public String getPatientsSearchSurname() {
        return patientsSearchSurname;
    }

    public void setPatientsSearchSurname(String patientsSearchSurname) {
        this.patientsSearchSurname = patientsSearchSurname;
    }

    public String getPatientsSearchName() {
        return patientsSearchName;
    }

    public void setPatientsSearchName(String patientsSearchName) {
        this.patientsSearchName = patientsSearchName;
    }

    public String getPatientsSearchPatrName() {
        return patientsSearchPatrName;
    }

    public void setPatientsSearchPatrName(String patientsSearchPatrName) {
        this.patientsSearchPatrName = patientsSearchPatrName;
    }

    public String getPatientsSearchBirthDate() {
        return patientsSearchBirthDate;
    }

    public void setPatientsSearchBirthDate(String patientsSearchBirthDate) {
        this.patientsSearchBirthDate = patientsSearchBirthDate;
    }

    public String getPatientsSearchDocumentNumber() {
        return patientsSearchDocumentNumber;
    }

    public void setPatientsSearchDocumentNumber(String patientsSearchDocumentNumber) {
        this.patientsSearchDocumentNumber = patientsSearchDocumentNumber;
    }

    public String getFioDriverCard() {
        return fioDriverCard;
    }

    public void setFioDriverCard(String fioDriverCard) {
        this.fioDriverCard = fioDriverCard;
    }

    public String getGenderDriverCard() {
        return genderDriverCard;
    }

    public void setGenderDriverCard(String genderDriverCard) {
        this.genderDriverCard = genderDriverCard;
    }

    public String getBirthDateDriverCard() {
        return birthDateDriverCard;
    }

    public void setBirthDateDriverCard(String birthDateDriverCard) {
        this.birthDateDriverCard = birthDateDriverCard;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public String getCheckedEventYear() {
        return checkedEventYear;
    }

    public void setCheckedEventYear(String checkedEventYear) {
        this.checkedEventYear = checkedEventYear;
    }
}
