package test.businessTests.hospital;

import businessFramework.entities.hospital.referral.HospReferralData;
import businessFramework.entities.hospital.reservation.ReservationData;
import businessFramework.module.Values;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HospPlanning_ReservationTest extends TestBase implements Values
{
    private static String PATIENT = "Стационар Екатерина Петровна";
    private static Integer PATIENT_ID = 7364210;

    private HospitalManager hospitalManager;
    private ReservationData reservation;
    private ReservationData reservation_bedSpace;
    private HospReferralData existingReferralData;
    private HospReferralData newReferralData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        hospitalManager = new HospitalManager();
        reservation = new ReservationData();
        reservation_bedSpace = new ReservationData();
        existingReferralData = new HospReferralData();
        newReferralData = new HospReferralData();

        existingReferralData.setPatient(PATIENT);
        existingReferralData.setPatientId(PATIENT_ID);
        existingReferralData.setRefOrgRole("МО");
        existingReferralData.setRefOrg("Контрольная МО");
        existingReferralData.setRefDep("Терапевтическое отделение");
        existingReferralData.setRecvDep("Отделение экстренной госпитализации");
        existingReferralData.setRefDate("17.11.2015");
        existingReferralData.setRecvRegimen("Стационар круглосуточный");
        existingReferralData.setFinType("ОМС");
        existingReferralData.setOrderNumber("1597538246");
        existingReferralData.setRefDiagnosis("A08.0 Ротавирусный энтерит");
        existingReferralData.setRefDiagnosisComment("существующее направление");

        newReferralData.setPatient(PATIENT);
        newReferralData.setPatientId(PATIENT_ID);
        newReferralData.setRefOrgRole("МО");
        newReferralData.setRefOrg("Стационар для автотестов");
        newReferralData.setRefDep("Приемное");
        newReferralData.setRefDate(getCurrentDate());
        newReferralData.setOrderNumber("1597538247");
        newReferralData.setRefDiagnosis("A08.2 Аденовирусный энтерит");
        newReferralData.setRefDiagnosisComment("новое направление");

        reservation.setPatient(PATIENT);
        reservation.setPatientId(PATIENT_ID);
        reservation.setExistingReferral(existingReferralData);
        reservation.setNewReferral(newReferralData);
        reservation.setPlannedDate(getCurrentDate());
        reservation.setDepartment("Отделение экстренной госпитализации");
        reservation.setRegimen("Стационар круглосуточный");
        reservation.setProfile("Хирургия");
        reservation.setBedProfile("гнойные хирургические для взрослых");
        reservation.setDuration(4);
        reservation.setFinancialType("ОМС");

        reservation_bedSpace = reservation.clone();
        reservation_bedSpace.setProfile("Абдоминальная хирургия");
        reservation_bedSpace.setBedProfile("абдоминальной хирургии");
    }

    @Test(description = "Подготовка тестовых данных: удаление заявок и направлений пациента, если такие существуют")
    public void beforeTest()
    {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(reservation.getDepartment());
        hospitalManager.openReservationListPage();
        hospitalManager.getReservationListPage().removePatientReservations(reservation);
        hospitalManager.openReferralListPage();
        hospitalManager.getReferralListPage().removeReferralIfExist(newReferralData);
    }

    @Test(description = "Создание заявки на основе существующего направления", dependsOnMethods = "beforeTest")
    public void step01_createReservation_onExistingReferral()
    {
        hospitalManager.openReservationListPage();
        hospitalManager.getReservationListPage().create_onExistingReferral(reservation);
        hospitalManager.getReservationListPage().assertForm(reservation, existingReferralData);
        hospitalManager.getReservationListPage().backToGrid();
    }

    @Test(description = "Найти заявку", dependsOnMethods = "step01_createReservation_onExistingReferral")
    public void step02_findReservation()
    {
        hospitalManager.getReservationListPage().findReservation(reservation);
    }


    @Test(description = "Редактирование заявки, использование коечного фонда", dependsOnMethods = "step02_findReservation")
    public void step03_updateReservation_usingBedSpace()
    {
        hospitalManager.getReservationListPage().bedSpaceTest(reservation, reservation_bedSpace, newReferralData);
        reservation = reservation_bedSpace;
    }

    @Test(description = "Редактирование заявки, ручное заполнение направления", dependsOnMethods = "step03_updateReservation_usingBedSpace")
    public void step04_updateReservation_createReferral()
    {
        hospitalManager.getReservationListPage().updateReservation(reservation);
        hospitalManager.getReservationListPage().assertForm(reservation, newReferralData);
        hospitalManager.getReservationListPage().backToGrid();
    }

    @Test(description = "Удаление заявки", dependsOnMethods = "step04_updateReservation_createReferral")
    public void step05_removeReservation()
    {
        hospitalManager.openReservationListPage();
        hospitalManager.getReservationListPage().remove(reservation);
    }
}
