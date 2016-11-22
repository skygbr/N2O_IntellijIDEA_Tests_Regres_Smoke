package test.businessTests.vaccination;

import businessFramework.module.Values;
import net.framework.autotesting.test.TestBase;
import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.vaccination.IndividPlanManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IndividPlanTest extends TestBase implements Values {
    private IndividPlanManager individPlanManager;
    private IndividPlanData individPlanData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        individPlanManager = new IndividPlanManager();
        individPlanData = new IndividPlanData();

        individPlanData.setPatient("Вакцина Вакцина Вакцина");
        individPlanData.setCalendar("Национальный календарь прививок 2014");
        individPlanData.setClinic("МО Вакцинопрофилактика автотест");
        individPlanData.setResourse("Нуждина Е.А.");
        individPlanData.setVaccine("H-B-ВАКС II");
        individPlanData.setProbe("Туберкулин");
        individPlanData.setPhase("V1");
        individPlanData.setProbePhase("Проба");
        individPlanData.setSeries("Серия автотест");
        individPlanData.setBirthDate("01.01.2000");
        individPlanData.setInfection("Вирусный гепатит В");
        individPlanData.setProbeInfection("Туберкулёз");
        individPlanData.setGroupOfRisk1("Грипп");
        individPlanData.setGroupOfRisk2("Столбняк");
        individPlanData.setVacDepartment("Вакцинопрофилактика");
        individPlanData.setSchema("Грипп");

    }

    @Test(description = "Открытие модуля Вакцинопрофилактика", priority = 1)
    public void step1_openVaccineModule()
    {
        individPlanManager.openIndividPlan();
        page.getHeader().chooseContext(individPlanData.getVacDepartment());
    }

    @Test(description = "Выбор пациента, календаря. Формирование плана", dependsOnMethods = "step1_openVaccineModule", priority = 1)
    public void step2_individPlanForm() {
        individPlanManager.getIndividPlanPage().getPatient().setValue(individPlanData.getPatient());
        individPlanManager.getIndividPlanPage().getCalendar().setValue(individPlanData.getCalendar());
        individPlanManager.getIndividPlanPage().clickFormButton();
    }

    @Test(description = "Проверка, что на форме есть только прививки со статусом Сформировано", dependsOnMethods = "step2_individPlanForm",priority = 1)
    public  void step2_1_assertFormBeforeAssign()
    {
        individPlanManager.getIndividPlanPage().assertFormBeforeAllAssign();
    }

    @Test(description = "Открытие модального Назначить все", dependsOnMethods = "step2_individPlanForm", priority = 2)
    public void step3_openAssignAllInfectionsModal()
    {
        individPlanManager.getIndividPlanPage().clickAssignAllInfectionsButton();
    }

    @Test(description = "Проверка заполнения поля: начало периода = дате рождения", dependsOnMethods = "step3_openAssignAllInfectionsModal", priority = 1)
    public void step3_1_assertPeriodBeginIsFill()
    {
        individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().assertPeriodBeginIsFill(individPlanData.getBirthDate());
    }

    @Test(description = "Заполнение и сохранение формы Назначить все.", dependsOnMethods = "step3_openAssignAllInfectionsModal", priority = 2)
    public void step4_fillAssignAllInfectionsForm()
    {
         individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().fillAssignAllInfectionsForm(individPlanData);
         individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть прививки со статусами Назначено и Просрочено", dependsOnMethods = "step4_fillAssignAllInfectionsForm",priority = 1)
    public  void step4_1_assertFormAfterAssign()
    {
        individPlanManager.getIndividPlanPage().assertFormAfterAllAssign();
    }

    @Test(description = "Открытие модального окна Отменить назначения", dependsOnMethods = "step4_fillAssignAllInfectionsForm", priority = 2)
    public void step5_rollbackModal()
    {
         individPlanManager.getIndividPlanPage().clickRollbackButton();
    }

    @Test(description = "Проверка заполнения поля: начало периода = дате рождения", dependsOnMethods = "step5_rollbackModal", priority = 1)
    public void step5_1_assertPeriodBeginIsFill()
    {
        individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().assertPeriodBeginIsFill(individPlanData.getBirthDate());
    }

    @Test(description = "Заполнение и сохранение формы Отменить все", dependsOnMethods = "step5_rollbackModal", priority = 2)
    public void step6_fillRollbackForm()
    {
        individPlanManager.getIndividPlanPage().getRollbackModal().fillRollbackForm(individPlanData);
        individPlanManager.getIndividPlanPage().getRollbackModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть только прививки со статусом Сформировано", dependsOnMethods = "step6_fillRollbackForm",priority = 1)
    public  void step6_1_assertFormAfterDeleteAllVac()
    {
        individPlanManager.getIndividPlanPage().assertFormBeforeAllAssign();
    }

    @Test(description = "Открытие модального окна Задать схему", dependsOnMethods = "step6_fillRollbackForm", priority = 2)
    public void step7_addSchemeTemplate()
    {
        individPlanManager.getIndividPlanPage().clickAddSchemeTemplateButton();
    }

    @Test(description = "Заполнение формы задания схемы и формирование схемы", dependsOnMethods = "step7_addSchemeTemplate", priority = 1)
    public void step8_fillSchemeTemplate()
    {
        individPlanManager.getIndividPlanPage().getSchemeTemplateModal().fillSchemeTemplateForm(individPlanData);
        individPlanManager.getIndividPlanPage().getSchemeTemplateModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть назначенная по схеме прививка", dependsOnMethods = "step8_fillSchemeTemplate",priority = 1)
    public  void step8_1_assertThatVaccineIsAssignByScheme()
    {
        individPlanManager.getIndividPlanPage().assertThatVaccineIsAssignByScheme();
    }

    @Test(description = "Отмена всех назначенных по схеме прививок", dependsOnMethods = "step8_fillSchemeTemplate", priority = 2)
    public void step9_rollback()
    {
        individPlanManager.getIndividPlanPage().clickRollbackButton();
        individPlanManager.getIndividPlanPage().getRollbackModal().fillRollbackForm(individPlanData);
        individPlanManager.getIndividPlanPage().getRollbackModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть только прививки со статусом Сформировано", dependsOnMethods = "step9_rollback",priority = 1)
    public  void step9_1_assertFormAfterDeleteAllVac()
    {
        individPlanManager.getIndividPlanPage().assertFormBeforeAllAssign();
    }

    @Test(description = "Формирование календаря с группами риска", dependsOnMethods = "step9_1_assertFormAfterDeleteAllVac", priority = 1)
    public void step10_groupOfRiskCalendar()
    {
        individPlanManager.getIndividPlanPage().getGroupOfRisk().setValue(individPlanData.getGroupOfRisk1());
        individPlanManager.getIndividPlanPage().getGroupOfRisk().setValue(individPlanData.getGroupOfRisk2());

        individPlanManager.getIndividPlanPage().clickFormButton();
    }

    @Test(description = "Проверка, что на форме есть только прививки со статусом Сформировано", dependsOnMethods = "step10_groupOfRiskCalendar", priority = 1)
    public  void step10_1_assertForm()
    {
        individPlanManager.getIndividPlanPage().assertFormBeforeAllAssign();
    }

    @Test(description = "Назначение прививок пациенту по календарю с группами риска", dependsOnMethods = "step10_1_assertForm", priority = 1)
    public void step10_2_assignAllGroupOfRisk()
    {
        individPlanManager.getIndividPlanPage().clickAssignAllInfectionsButton();
        individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().fillAssignAllInfectionsForm(individPlanData);
        individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть прививки со статусами Просрочено", dependsOnMethods = "step10_2_assignAllGroupOfRisk",priority = 1)
    public  void step10_3_assertFormAfterAssignGroupOfRisk()
    {
        individPlanManager.getIndividPlanPage().assertFormAfterAllAssignGroupOfRisk();
    }

    @Test(description = "Заполнение и сохранение формы Отменить все", dependsOnMethods = "step10_3_assertFormAfterAssignGroupOfRisk", priority = 2)
    public void step10_4_fillRollbackForm()
    {
        individPlanManager.getIndividPlanPage().clickRollbackButton();
        individPlanManager.getIndividPlanPage().getRollbackModal().fillRollbackForm(individPlanData);
        individPlanManager.getIndividPlanPage().getRollbackModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть только прививки со статусом Сформировано", dependsOnMethods = "step10_4_fillRollbackForm",priority = 1)
    public  void step10_5_assertForm()
    {
        individPlanManager.getIndividPlanPage().assertFormBeforeAllAssign();
    }

    @Test (description = "Формирование календаря без групп риска", dependsOnMethods = "step10_4_fillRollbackForm", priority = 2)
    public void step10_6_formCalendarWithoutGroup()
    {
        individPlanManager.getIndividPlanPage().getGroupOfRisk().removeValueMulti();
        individPlanManager.getIndividPlanPage().getGroupOfRisk().removeValueMulti();
        individPlanManager.getIndividPlanPage().clickFormButton();
    }

    @Test(description = "Открытие модального Создания прививки. Проверка заполненных значений из контекста.", dependsOnMethods = "step10_5_assertForm", priority = 2)
    public void step11_openVaccineForm()
    {
        individPlanManager.getIndividPlanPage().setFocusOnTheFirstSlot();
        individPlanManager.getIndividPlanPage().clickAddInoculationButton();
        individPlanManager.getIndividPlanPage().getVaccineModal().assertVaccineContextData(individPlanData);
    }

    @Test(description = "Заполнение формы добавления прививки (Назначение). Проверка валидации обязательных полей.", dependsOnMethods = "step11_openVaccineForm", priority = 1)
    public void step12_fillNewVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButtonNewForm();
        individPlanManager.getIndividPlanPage().getVaccineModal().assertRequiredFields();
        individPlanManager.getIndividPlanPage().getVaccineModal().fillVaccineModal(individPlanData);
    }

    @Test(description = "Проверка, что заполнена инфекция на основе выбранной вакцины", dependsOnMethods = "step12_fillNewVaccineForm", priority = 1)
    public void step12_1_assertNewVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertInfectionIsFill(individPlanData.getInfection());
    }

    @Test(description = "Сохранение назначенной прививки", dependsOnMethods = "step12_fillNewVaccineForm", priority = 2)
    public void step13_saveVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButtonNewForm();
    }

    @Test(description = "Проверка, что на форме есть прививка со статусом Назначено", dependsOnMethods = "step13_saveVaccineForm",priority = 1)
    public  void step13_1_assertFormThatVaccineIsAssign()
    {
        individPlanManager.getIndividPlanPage().assertThatVaccineIsAssign();
    }

    @Test (description = "Проверка сообщения при добавлении прививки, если такая прививка уже есть", dependsOnMethods = "step13_saveVaccineForm", priority = 2)
    public void step13_2_assertWarningModal()
    {
        individPlanManager.getIndividPlanPage().setFocusOnTheFirstSlot();
        individPlanManager.getIndividPlanPage().clickAddInoculationButton();
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButtonNewForm();
        individPlanManager.getIndividPlanPage().getVaccineModal().fillVaccineModal(individPlanData);
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButtonNewForm();
        individPlanManager.getIndividPlanPage().getDialog().isDialogPresents();
        individPlanManager.getIndividPlanPage().getDialog().clickNo();
        individPlanManager.getIndividPlanPage().getModal().closeModal();
        individPlanManager.getIndividPlanPage().clickFormButton(); //обход скроллинга таблицы до нужной ячейки, т.к. возникают проблемы при работе скролла на разных разрешениях
    }

    @Test(description = "Открытие назначенной прививки на редактирование", dependsOnMethods = "step13_saveVaccineForm", priority = 3)
    public void step14_editVaccineForm()
    {
        individPlanManager.getIndividPlanPage().setFocusAssignVaccineSlot();
        individPlanManager.getIndividPlanPage().clickEditButton();
    }

    @Test(description = "Проверка, что заполнена инфекция на основе выбранной вакцины", dependsOnMethods = "step14_editVaccineForm", priority = 1)
    public void step14_1_assertVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertInfectionIsFill(individPlanData.getInfection());
    }

    @Test(description = "Заполнение формы редактирования прививки (Планирование)",dependsOnMethods = "step14_editVaccineForm", priority = 2)
    public void step15_fillPlanVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().fillPlanVaccineModal(individPlanData);
    }

    @Test(description = "Сохранение запланированной прививки", dependsOnMethods = "step15_fillPlanVaccineForm", priority = 1)
    public void step16_saveVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть прививка со статусом Запланировано", dependsOnMethods = "step16_saveVaccineForm",priority = 1)
    public  void step16_1_assertFormThatVaccineIsPlanning()
    {
        individPlanManager.getIndividPlanPage().assertThatVaccineIsPlanning();
    }

    @Test(description = "Открытие запланированной прививки на редактирование", dependsOnMethods = "step16_saveVaccineForm", priority = 2)
    public void step17_editVaccineForm() {
        individPlanManager.getIndividPlanPage().setFocusPlanVaccineSlot();
        individPlanManager.getIndividPlanPage().clickEditButton();
    }

    @Test(description = "Cоздание отвода, сохранение прививки", dependsOnMethods = "step17_editVaccineForm", priority = 1)
    public void step18_createDeny()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickNewDeny();
        individPlanManager.getIndividPlanPage().getDenyModal().fillDenyModal(individPlanData);
        individPlanManager.getIndividPlanPage().getDenyModal().clickConfirmButton();

        individPlanManager.getIndividPlanPage().getModal().closeModal();
    }

    @Test(description = "Открытие отведенной (временно) прививки на редактирование", dependsOnMethods = "step18_createDeny", priority = 1)
    public void step19_editVaccineForm()
    {
        individPlanManager.getIndividPlanPage().setFocusPlanVaccineSlot();
        individPlanManager.getIndividPlanPage().clickEditButton();
    }

    @Test(description = "Проверка измененной, после отвода, даты прививки", dependsOnMethods = "step19_editVaccineForm", priority = 1)
    public void step19_1_assertVaccineDate()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertVaccineDate();
    }

    @Test(description = "Открытие формы создания серии", dependsOnMethods = "step19_editVaccineForm", priority = 2)
    public void step20_openSeriesForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickSeriesLink();
    }

    @Test(description = "Заполнение и сохранение формы серии", dependsOnMethods = "step20_openSeriesForm", priority = 1)
    public void step21_fillSeriesForm()
    {
        individPlanManager.getIndividPlanPage().getSeriesModal().fillSeriesModal(individPlanData);
        individPlanManager.getIndividPlanPage().getSeriesModal().clickConfirmButton();
    }

    @Test(description = "Заполнение формы редактирования прививки (Выполнение)",dependsOnMethods = "step21_fillSeriesForm", priority = 1)
    public void step22_fillDoneVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().fillDoneVaccineModal(individPlanData);
    }

    @Test(description = "Сохранение выполненной прививки. Проверка валидации даты выполнения.", dependsOnMethods = "step22_fillDoneVaccineForm", priority = 1)
    public void step23_saveVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertDoneDate();
        individPlanManager.getIndividPlanPage().getVaccineModal().fillCorrectDateVaccineModal(individPlanData);
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть прививка со статусом Выполнено", dependsOnMethods = "step23_saveVaccineForm",priority = 1)
    public  void step23_1_assertFormThatVaccineIsDone()
    {
        individPlanManager.getIndividPlanPage().assertThatVaccineIsDone();
    }

    @Test(description = "Удаление прививки", dependsOnMethods = "step23_saveVaccineForm", priority = 2, alwaysRun = true)
    public void step_deleteVaccine()
    {
        individPlanManager.getIndividPlanPage().setFocusDoneVaccineSlot();
        individPlanManager.getIndividPlanPage().clickDeleteButton();
    }

    @Test(description = "Открытие модального Создания пробы. Проверка значений, заполненных из контекста", dependsOnMethods = "step_deleteVaccine", priority = 1)
    public void step24_openProbeForm()
    {
        individPlanManager.getIndividPlanPage().setFocusOnTheFirstSlot();
        individPlanManager.getIndividPlanPage().clickAddProbaButton();
        individPlanManager.getIndividPlanPage().getVaccineModal().assertVaccineContextData(individPlanData);
    }

    @Test(description = "Заполнение формы добавления пробы (Назначение)", dependsOnMethods = "step24_openProbeForm", priority = 1)
    public void step25_fillNewProbeForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButtonNewForm();
        individPlanManager.getIndividPlanPage().getVaccineModal().assertRequiredFields();
        individPlanManager.getIndividPlanPage().getVaccineModal().fillProbeModal(individPlanData);
    }

    @Test(description = "Проверка, что заполнена инфекция на основе выбранной вакцины", dependsOnMethods = "step25_fillNewProbeForm", priority = 1)
    public void step25_1_assertNewProbeForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertInfectionIsFill(individPlanData.getProbeInfection());
    }

    @Test(description = "Сохранение назначенной пробы", dependsOnMethods = "step25_fillNewProbeForm", priority = 2)
    public void step26_saveProbeForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButtonNewForm();
    }

    @Test(description = "Проверка, что на форме есть проба со статусом Назначено", dependsOnMethods = "step26_saveProbeForm", priority = 1)
    public  void step27_assertFormThatProbeIsAssign()
    {
        individPlanManager.getIndividPlanPage().assertThatVaccineIsAssign();
    }

    @Test(description = "Открытие назначенной пробы на редактирование", dependsOnMethods = "step26_saveProbeForm", priority = 2)
    public void step28_editProbeForm()
    {
        individPlanManager.getIndividPlanPage().setFocusAssignVaccineSlot();
        individPlanManager.getIndividPlanPage().clickEditProbeButton();
    }

    @Test(description = "Проверка, что заполнена инфекция на основе выбранной пробы", dependsOnMethods = "step28_editProbeForm", priority = 1)
    public void step29_assertVaccineForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertInfectionIsFill(individPlanData.getProbeInfection());
    }

    @Test(description = "Заполнение формы редактирования пробы (Планирование)",dependsOnMethods = "step28_editProbeForm", priority = 2)
    public void step30_fillPlanProbeForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().fillPlanProbeModal(individPlanData);
    }

    @Test(description = "Сохранение запланированной пробы", dependsOnMethods = "step30_fillPlanProbeForm", priority = 1)
    public void step31_saveProbeForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть проба со статусом Запланировано", dependsOnMethods = "step31_saveProbeForm",priority = 1)
    public  void step32_assertFormProbeThatIsPlanning()
    {
        individPlanManager.getIndividPlanPage().assertThatVaccineIsPlanning();
    }

    @Test(description = "Открытие запланированной пробы на редактирование", dependsOnMethods = "step31_saveProbeForm", priority = 2)
    public void step33_editProbeForm() {
        individPlanManager.getIndividPlanPage().setFocusPlanVaccineSlot();
        individPlanManager.getIndividPlanPage().clickEditProbeButton();
    }

    @Test(description = "Cоздание отвода, сохранение пробы", dependsOnMethods = "step33_editProbeForm", priority = 1)
    public void step34_createProbeDeny()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickNewDeny();
        individPlanManager.getIndividPlanPage().getDenyModal().fillDenyModal(individPlanData);
        individPlanManager.getIndividPlanPage().getDenyModal().clickConfirmButton();

        individPlanManager.getIndividPlanPage().getModal().closeModal();
    }

    @Test(description = "Открытие отведенной (временно) пробы на редактирование", dependsOnMethods = "step34_createProbeDeny", priority = 1)
    public void step35_editProbeForm()
    {
        individPlanManager.getIndividPlanPage().setFocusPlanVaccineSlot();
        individPlanManager.getIndividPlanPage().clickEditProbeButton();
    }

    @Test(description = "Проверка измененной, после отвода, даты пробы", dependsOnMethods = "step35_editProbeForm", priority = 1)
    public void step36_assertProbeDate()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertVaccineDate();
    }

    @Test(description = "Открытие формы создания серии", dependsOnMethods = "step35_editProbeForm", priority = 2)
    public void step37_openSeriesForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().clickSeriesLink();
    }

    @Test(description = "Заполнение и сохранение формы серии", dependsOnMethods = "step37_openSeriesForm", priority = 1)
    public void step38_fillSeriesForm()
    {
        individPlanManager.getIndividPlanPage().getSeriesModal().fillSeriesModal(individPlanData);
        individPlanManager.getIndividPlanPage().getSeriesModal().clickConfirmButton();
    }

    @Test(description = "Заполнение формы редактирования пробы (Выполнение)", dependsOnMethods = "step38_fillSeriesForm", priority = 1)
    public void step39_fillDoneProbeForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().fillDoneVaccineModal(individPlanData);
    }

    @Test(description = "Сохранение выполненной пробы", dependsOnMethods = "step39_fillDoneProbeForm", priority = 1)
    public void step40_saveProbeForm()
    {
        individPlanManager.getIndividPlanPage().getVaccineModal().assertDoneDate();
        individPlanManager.getIndividPlanPage().getVaccineModal().fillCorrectDateVaccineModal(individPlanData);
        individPlanManager.getIndividPlanPage().getVaccineModal().clickConfirmButton();
    }

    @Test(description = "Проверка, что на форме есть проба со статусом Выполнено", dependsOnMethods = "step40_saveProbeForm",priority = 1)
    public  void step41_assertFormThatProbeIsDone()
    {
        individPlanManager.getIndividPlanPage().assertThatVaccineIsDone();
    }

    @Test(description = "Удаление пробы", dependsOnMethods = "step40_saveProbeForm", priority = 2, alwaysRun = true)
    public void step_deleteProbe()
    {
        individPlanManager.getIndividPlanPage().setFocusDoneVaccineSlot();
        individPlanManager.getIndividPlanPage().clickDeleteButton();
    }

    @Test(description = "Проверка, что на форме есть только прививки со статусом Сформировано", dependsOnMethods = "step_deleteProbe", priority = 1)
    public  void step_assertFormAfterDeleteAllVac()
    {
        individPlanManager.getIndividPlanPage().assertFormBeforeAllAssign();
    }
}
