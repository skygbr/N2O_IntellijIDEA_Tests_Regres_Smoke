package businessFramework.entities.gibddMedicalExamination;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GibddMedicalExaminationData
{
    // Данные для выбора контекста
    private String contextName;

    // Данные полей в контейнере "Карточка мероприятия"
    private String checkedEventName;
    private String checkedEventType;
    private String checkedOrganisationName;
    private String checkedFundingType;
    private String checkedBeginDate;
    private String checkedEndDate;
    private String checkedStandart;
    private String checkedMes;

    // Данные для изменения в контейнере "Карточка мероприятия"
    private String changedEventName;
    private String changedBeginDate;
    private String changedEndDate;
    private String changedMes;

    // Данные для полей в модальном окне "Модель пациента"
    private String patientModelName;
    private String patientModelGender;
    private String patientModelGenderMan;
    private String patientModelGenderFemale;
    private String patientModelGenderIndefinite;
    private String patientModelSocial;
    private String licenseCategory;
    private String licenseCategoryA;
    private String licenseCategoryA1;
    private String licenseCategoryB;
    private String licenseCategoryB1;
    private String licenseCategoryBE;
    private String licenseCategoryC;
    private String licenseCategoryC1;
    private String licenseCategoryCE;
    private String licenseCategoryC1E;
    private String licenseCategoryD;
    private String licenseCategoryD1;
    private String licenseCategoryDE;
    private String licenseCategoryD1E;
    private String licenseCategoryM;
    private String licenseCategoryTm;
    private String licenseCategoryTb;

    //Модель пациента
    private String searchPatientModelName;
    private String successSavingPatientModelAlertMessage;
    private String performedInTheYearEventBase;
    private String performedInTheYearEventAdditional;
    private String statusExecuted;

    // Данные для полей в модальном окне Модель пациента
    private String headerPatientModelModal;

    // Значение возраста
    private String ageInModelsWindow;

    // Данные для полей в модальном окне "Поиск пациентов"
    private String patientsSearchSurname;
    private String patientsSearchName;
    private String patientsSearchPatrName;
    private String patientsSearchBirthDate;
    private String patientsSearchDocumentNumber;

    // Данные для полей на форме в модальном окне "Добавить пациента"
    private String addPatientReferenceSeries;
    private String addPatientReferenceNumber;
    private String addPatientCategoryTS;

    // Данные для страницы "Карточка"
    private String fioDriverCard;
    private String genderDriverCard;
    private String birthDateDriverCard;
    private String passportDriverCard;

    // Данные для полей в модальном окне "Оказание услуги"
    private String mainDiagnosisDoService;
    private String diseaseCharacterDoService;

    // Данные для страницы "Врач"
    private String eventNameDoctor;
    private List<String> servicesDoctor;
    private Map<String, String> servicesAndResourcesDoctor;
    private String diseaseDoctor;
    private String mainDiagnosisDoctor;

    // Данные для страницы "Численность населения"
    private String headerPopulationModal;
    private String populationName;
    private String orgName;
    private String year;
    private String m21_36Begin;
    private String m39_60Begin;
    private String m60Begin;
    private String f21_36Begin;
    private String f39_60Begin;
    private String f60Begin;
    private String m21_36Disp;
    private String m39_60Disp;
    private String m60Disp;
    private String f21_36Disp;
    private String f39_60Disp;
    private String f60Disp;
    private String ch0_4Disp;
    private String ch5_9Disp;
    private String ch10_14Disp;
    private String ch15_17Disp;

    public String getMainDiagnosisDoService()
    {
        return mainDiagnosisDoService;
    }

    public void setMainDiagnosisDoService(String mainDiagnosisDoService)
    {
        this.mainDiagnosisDoService = mainDiagnosisDoService;
    }

    public String getDiseaseCharacterDoService()
    {
        return diseaseCharacterDoService;
    }

    public void setDiseaseCharacterDoService(String diseaseCharacterDoService)
    {
        this.diseaseCharacterDoService = diseaseCharacterDoService;
    }

    public String getFioDriverCard()
    {
        return fioDriverCard;
    }

    public void setFioDriverCard(String fioDriverCard)
    {
        this.fioDriverCard = fioDriverCard;
    }

    public String getGenderDriverCard()
    {
        return genderDriverCard;
    }

    public void setGenderDriverCard(String genderDriverCard)
    {
        this.genderDriverCard = genderDriverCard;
    }

    public String getBirthDateDriverCard()
    {
        return birthDateDriverCard;
    }

    public void setBirthDateDriverCard(String birthDateDriverCard)
    {
        this.birthDateDriverCard = birthDateDriverCard;
    }

    public String getPassportDriverCard()
    {
        return passportDriverCard;
    }

    public void setPassportDriverCard(String passportDriverCard)
    {
        this.passportDriverCard = passportDriverCard;
    }

    public String getAddPatientCategoryTS()
    {
        return addPatientCategoryTS;
    }

    public void setAddPatientCategoryTS(String addPatientCategoryTS)
    {
        this.addPatientCategoryTS = addPatientCategoryTS;
    }

    public String getAddPatientReferenceSeries()
    {
        return addPatientReferenceSeries;
    }

    public void setAddPatientReferenceSeries(String addPatientReferenceSeries)
    {
        this.addPatientReferenceSeries = addPatientReferenceSeries;
    }

    public String getAddPatientReferenceNumber()
    {
        return addPatientReferenceNumber;
    }

    public void setAddPatientReferenceNumber(String addPatientReferenceNumber)
    {
        this.addPatientReferenceNumber = addPatientReferenceNumber;
    }

    public String getPatientsSearchSurname()
    {
        return patientsSearchSurname;
    }

    public void setPatientsSearchSurname(String patientsSearchSurname)
    {
        this.patientsSearchSurname = patientsSearchSurname;
    }

    public String getPatientsSearchName()
    {
        return patientsSearchName;
    }

    public void setPatientsSearchName(String patientsSearchName)
    {
        this.patientsSearchName = patientsSearchName;
    }

    public String getPatientsSearchPatrName()
    {
        return patientsSearchPatrName;
    }

    public void setPatientsSearchPatrName(String patientsSearchPatrName)
    {
        this.patientsSearchPatrName = patientsSearchPatrName;
    }

    public String getPatientsSearchBirthDate()
    {
        return patientsSearchBirthDate;
    }

    public void setPatientsSearchBirthDate(String patientsSearchBirthDate)
    {
        this.patientsSearchBirthDate = patientsSearchBirthDate;
    }

    public String getPatientsSearchDocumentNumber()
    {
        return patientsSearchDocumentNumber;
    }

    public void setPatientsSearchDocumentNumber(String patientsSearchDocumentNumber)
    {
        this.patientsSearchDocumentNumber = patientsSearchDocumentNumber;
    }

    public String getAgeInModelsWindow()
    {
        return ageInModelsWindow;
    }

    public void setAgeInModelsWindow(String ageInModelsWindow)
    {
        this.ageInModelsWindow = ageInModelsWindow;
    }

    public String getPatientModelSocial()
    {
        return patientModelSocial;
    }

    public void setPatientModelSocial(String patientModelSocial)
    {
        this.patientModelSocial = patientModelSocial;
    }

    public String getPatientModelName()
    {
        return patientModelName;
    }

    public void setPatientModelName(String patientModelName)
    {
        this.patientModelName = patientModelName;
    }

    public String getSearchPatientModelName() {
        return searchPatientModelName;
    }

    public void setSearchPatientModelName(String searchPatientModelName) {
        this.searchPatientModelName = searchPatientModelName;
    }

    public String getPatientModelGender()
    {
        return patientModelGender;
    }

    public void setPatientModelGender(String patientModelGender)
    {
        this.patientModelGender = patientModelGender;
    }

    public String getPatientModelGenderMan() {
        return patientModelGenderMan;
    }

    public void setPatientModelGenderMan(String patientModelGenderMan) {
        this.patientModelGenderMan = patientModelGenderMan;
    }

    public String getPatientModelGenderFemale() {
        return patientModelGenderFemale;
    }

    public void setPatientModelGenderFemale(String patientModelGenderFemale) {
        this.patientModelGenderFemale = patientModelGenderFemale;
    }

    public String getPatientModelGenderIndefinite() {
        return patientModelGenderIndefinite;
    }

    public void setPatientModelGenderIndefinite(String patientModelGenderIndefinite) {
        this.patientModelGenderIndefinite = patientModelGenderIndefinite;
    }

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public String getLicenseCategoryA() {
        return licenseCategoryA;
    }

    public void setLicenseCategoryA(String licenseCategoryA) {
        this.licenseCategoryA = licenseCategoryA;
    }

    public String getLicenseCategoryA1() {
        return licenseCategoryA1;
    }

    public void setLicenseCategoryA1(String licenseCategoryA1) {
        this.licenseCategoryA1 = licenseCategoryA1;
    }

    public String getLicenseCategoryB() {
        return licenseCategoryB;
    }

    public void setLicenseCategoryB(String licenseCategoryB) {
        this.licenseCategoryB = licenseCategoryB;
    }

    public String getLicenseCategoryB1() {
        return licenseCategoryB1;
    }

    public void setLicenseCategoryB1(String licenseCategoryB1) {
        this.licenseCategoryB1 = licenseCategoryB1;
    }

    public String getLicenseCategoryBE() {
        return licenseCategoryBE;
    }

    public void setLicenseCategoryBE(String licenseCategoryBE) {
        this.licenseCategoryBE = licenseCategoryBE;
    }

    public String getLicenseCategoryC() {
        return licenseCategoryC;
    }

    public void setLicenseCategoryC(String licenseCategoryC) {
        this.licenseCategoryC = licenseCategoryC;
    }

    public String getLicenseCategoryC1() {
        return licenseCategoryC1;
    }

    public void setLicenseCategoryC1(String licenseCategoryC1) {
        this.licenseCategoryC1 = licenseCategoryC1;
    }

    public String getLicenseCategoryCE() {
        return licenseCategoryCE;
    }

    public void setLicenseCategoryCE(String licenseCategoryCE) {
        this.licenseCategoryCE = licenseCategoryCE;
    }

    public String getLicenseCategoryC1E() {
        return licenseCategoryC1E;
    }

    public void setLicenseCategoryC1E(String licenseCategoryC1E) {
        this.licenseCategoryC1E = licenseCategoryC1E;
    }

    public String getLicenseCategoryD() {
        return licenseCategoryD;
    }

    public void setLicenseCategoryD(String licenseCategoryD) {
        this.licenseCategoryD = licenseCategoryD;
    }

    public String getLicenseCategoryD1() {
        return licenseCategoryD1;
    }

    public void setLicenseCategoryD1(String licenseCategoryD1) {
        this.licenseCategoryD1 = licenseCategoryD1;
    }

    public String getLicenseCategoryDE() {
        return licenseCategoryDE;
    }

    public void setLicenseCategoryDE(String licenseCategoryDE) {
        this.licenseCategoryDE = licenseCategoryDE;
    }

    public String getLicenseCategoryD1E() {
        return licenseCategoryD1E;
    }

    public void setLicenseCategoryD1E(String licenseCategoryD1E) {
        this.licenseCategoryD1E = licenseCategoryD1E;
    }

    public String getLicenseCategoryM() {
        return licenseCategoryM;
    }

    public void setLicenseCategoryM(String licenseCategoryM) {
        this.licenseCategoryM = licenseCategoryM;
    }

    public String getLicenseCategoryTm() {
        return licenseCategoryTm;
    }

    public void setLicenseCategoryTm(String licenseCategoryTm) {
        this.licenseCategoryTm = licenseCategoryTm;
    }

    public String getLicenseCategoryTb() {
        return licenseCategoryTb;
    }

    public void setLicenseCategoryTb(String licenseCategoryTb) {
        this.licenseCategoryTb = licenseCategoryTb;
    }

    public String getChangedEventName()
    {
        return this.changedEventName;
    }

    public void setChangedEventName(String changedEventName)
    {
        this.changedEventName = changedEventName;
    }

    public String getChangedBeginDate()
    {
        return this.changedBeginDate;
    }

    public void setChangedBeginDate(String changedBeginDate)
    {
        this.changedBeginDate = changedBeginDate;
    }

    public String getChangedEndDate()
    {
        return this.changedEndDate;
    }

    public void setChangedEndDate(String changedEndDate)
    {
        this.changedEndDate = changedEndDate;
    }

    public String getChangedMes()
    {
        return this.changedMes;
    }

    public void setChangedMes(String changedMes)
    {
        this.changedMes = changedMes;
    }

    public String getCheckedStandart()
    {
        return this.checkedStandart;
    }

    public void setCheckedStandart(String checkedStandart)
    {
        this.checkedStandart = checkedStandart;
    }

    public String getCheckedMes()
    {
        return this.checkedMes;
    }

    public void setCheckedMes(String checkedMes)
    {
        this.checkedMes = checkedMes;
    }

    public String getCheckedEventName()
    {
        return checkedEventName;
    }

    public void setCheckedEventName(String checkedEventName)
    {
        this.checkedEventName = checkedEventName;
    }

    public String getCheckedEventType()
    {
        return checkedEventType;
    }

    public void setCheckedEventType(String checkedEventType)
    {
        this.checkedEventType = checkedEventType;
    }

    public String getCheckedOrganisationName()
    {
        return checkedOrganisationName;
    }

    public void setCheckedOrganisationName(String checkedOrganisationName)
    {
        this.checkedOrganisationName = checkedOrganisationName;
    }

    public String getCheckedFundingType()
    {
        return checkedFundingType;
    }

    public void setCheckedFundingType(String checkedFundingType)
    {
        this.checkedFundingType = checkedFundingType;
    }

    public String getCheckedBeginDate()
    {
        return checkedBeginDate;
    }

    public void setCheckedBeginDate(String checkedBeginDate)
    {
        this.checkedBeginDate = checkedBeginDate;
    }

    public String getCheckedEndDate()
    {
        return checkedEndDate;
    }

    public void setCheckedEndDate(String checkedEndDate)
    {
        this.checkedEndDate = checkedEndDate;
    }

    public String getContextName()
    {
        return this.contextName;
    }

    public void setContextName(String contextName)
    {
        this.contextName = contextName;
    }

    public String getEventNameDoctor() {
        return eventNameDoctor;
    }

    public void setEventNameDoctor(String eventNameDoctor) {
        this.eventNameDoctor = eventNameDoctor;
    }

    public List<String> getServicesDoctor() {
        return servicesDoctor;
    }

    public void setServicesDoctor(List<String> servicesDoctor) {
        this.servicesDoctor = servicesDoctor;
    }

    public Map<String, String> getServicesAndResourcesDoctor() {
        return servicesAndResourcesDoctor;
    }

    public void setServicesAndResourcesDoctor(Map<String, String> servicesAndResourcesDoctor) {
        this.servicesAndResourcesDoctor = servicesAndResourcesDoctor;
    }

    public String getMainDiagnosisDoctor() {
        return mainDiagnosisDoctor;
    }

    public void setMainDiagnosisDoctor(String mainDiagnosisDoctor) {
        this.mainDiagnosisDoctor = mainDiagnosisDoctor;
    }

    public String getDiseaseDoctor() {
        return diseaseDoctor;
    }

    public void setDiseaseDoctor(String diseaseDoctor) {
        this.diseaseDoctor = diseaseDoctor;
    }

    public String getPopulationName() {
        return populationName;
    }

    public void setPopulationName(String populationName) {
        this.populationName = populationName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getM21_36Begin() {
        return m21_36Begin;
    }

    public void setM21_36Begin(String m21_36Begin) {
        this.m21_36Begin = m21_36Begin;
    }

    public String getM39_60Begin() {
        return m39_60Begin;
    }

    public void setM39_60Begin(String m39_60Begin) {
        this.m39_60Begin = m39_60Begin;
    }

    public String getM60Begin() {
        return m60Begin;
    }

    public void setM60Begin(String m60Begin) {
        this.m60Begin = m60Begin;
    }

    public String getF21_36Begin() {
        return f21_36Begin;
    }

    public void setF21_36Begin(String f21_36Begin) {
        this.f21_36Begin = f21_36Begin;
    }

    public String getF39_60Begin() {
        return f39_60Begin;
    }

    public void setF39_60Begin(String f39_60Begin) {
        this.f39_60Begin = f39_60Begin;
    }

    public String getF60Begin() {
        return f60Begin;
    }

    public void setF60Begin(String f60Begin) {
        this.f60Begin = f60Begin;
    }

    public String getM21_36Disp() {
        return m21_36Disp;
    }

    public void setM21_36Disp(String m21_36Disp) {
        this.m21_36Disp = m21_36Disp;
    }

    public String getM39_60Disp() {
        return m39_60Disp;
    }

    public void setM39_60Disp(String m39_60Disp) {
        this.m39_60Disp = m39_60Disp;
    }

    public String getM60Disp() {
        return m60Disp;
    }

    public void setM60Disp(String m60Disp) {
        this.m60Disp = m60Disp;
    }

    public String getF21_36Disp() {
        return f21_36Disp;
    }

    public void setF21_36Disp(String f21_36Disp) {
        this.f21_36Disp = f21_36Disp;
    }

    public String getF39_60Disp() {
        return f39_60Disp;
    }

    public void setF39_60Disp(String f39_60Disp) {
        this.f39_60Disp = f39_60Disp;
    }

    public String getF60Disp() {
        return f60Disp;
    }

    public void setF60Disp(String f60Disp) {
        this.f60Disp = f60Disp;
    }

    public String getCh0_4Disp() {
        return ch0_4Disp;
    }

    public void setCh0_4Disp(String ch0_4Disp) {
        this.ch0_4Disp = ch0_4Disp;
    }

    public String getCh5_9Disp() {
        return ch5_9Disp;
    }

    public void setCh5_9Disp(String ch5_9Disp) {
        this.ch5_9Disp = ch5_9Disp;
    }

    public String getCh10_14Disp() {
        return ch10_14Disp;
    }

    public void setCh10_14Disp(String ch10_14Disp) {
        this.ch10_14Disp = ch10_14Disp;
    }

    public String getCh15_17Disp() {
        return ch15_17Disp;
    }

    public void setCh15_17Disp(String ch15_17Disp) {
        this.ch15_17Disp = ch15_17Disp;
    }

    public String getHeaderPopulationModal() {
        return headerPopulationModal;
    }

    public void setHeaderPopulationModal(String headerPopulationModal) {
        this.headerPopulationModal = headerPopulationModal;
    }

    public String getHeaderPatientModelModal() {
        return headerPatientModelModal;
    }

    public void setHeaderPatientModelModal(String headerPatientModelModal) {
        this.headerPatientModelModal = headerPatientModelModal;
    }

    public String getSuccessSavingPatientModelAlertMessage() {
        return successSavingPatientModelAlertMessage;
    }

    public void setSuccessSavingPatientModelAlertMessage(String successSavingPatientModelAlertMessage) {
        this.successSavingPatientModelAlertMessage = successSavingPatientModelAlertMessage;
    }

    public String getPerformedInTheYearEventBase() {
        return performedInTheYearEventBase;
    }

    public void setPerformedInTheYearEventBase(String performedInTheYearEventBase) {
        this.performedInTheYearEventBase = performedInTheYearEventBase;
    }

    public String getPerformedInTheYearEventAdditional() {
        return performedInTheYearEventAdditional;
    }

    public void setPerformedInTheYearEventAdditional(String performedInTheYearEventAdditional) {
        this.performedInTheYearEventAdditional = performedInTheYearEventAdditional;
    }

    public String getStatusExecuted() {
        return statusExecuted;
    }

    public void setStatusExecuted(String statusExecuted) {
        this.statusExecuted = statusExecuted;
    }
}
