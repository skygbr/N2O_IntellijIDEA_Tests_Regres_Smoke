package businessFramework.module.gibddMedicalExamination.modals.patientsSearch;


import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

public class PatientsSearchModal extends PatientsSearchHelper
{

    public PatientsSearchModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна на соответствие строке "Добавить пациента"
     */
    public void checkModalHeader()
    {
        getSearchPatientsModal().assertModalHeader_equal("Поиск пациентов");
    }

    /**
     * Заполнение полей в модальном окне "Поиск пациентов"
     * @param gibddMedicalExaminationData - данные для полей
     */
    public void fillFields(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        getNameField().setValue(gibddMedicalExaminationData.getPatientsSearchName());
        getSurnameField().setValue(gibddMedicalExaminationData.getPatientsSearchSurname());
        getPatrNameField().setValue(gibddMedicalExaminationData.getPatientsSearchPatrName());
        getBirthDateField().setValue(gibddMedicalExaminationData.getPatientsSearchBirthDate());
        getDocumentNumberField().setValue(gibddMedicalExaminationData.getPatientsSearchDocumentNumber());
    }

    /**
     *  Нажатие кнопки Лупа в модальном окне "Поиск пациентов"
     */
    public void clickFindButton()
    {
        getFindButton().click();
    }

    /**
     *  Проверка, что в таблице после поиска отобразилась нужная нам запись.
     * @param columnsAndValues названия колонок и значения в этих колонках.
     */
    public void checkTableValuesAfterSearch(Map<String, String> columnsAndValues)
    {
        Table table = getPatientsSearchTable();
        int rowNumber = table.getRowNumberBySeveralColumnValues(columnsAndValues, true);
        assertThat(rowNumber, equalTo(0));
    }

    /**
     *  Нажатие кнопки "Выбрать"
     */
    public void clickChooseButton()
    {
        getChooseButton().click();
    }
}
