package businessFramework.module.dispensary.modal.patientsSearch;

import businessFramework.entities.dispensary.DispensaryData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;


import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
     * @param dispensaryData - данные для полей
     */
    public void fillFields(DispensaryData dispensaryData)
    {
        getNameField().setValue(dispensaryData.getPatientsSearchName());
        getSurnameField().setValue(dispensaryData.getPatientsSearchSurname());
        getPatrNameField().setValue(dispensaryData.getPatientsSearchPatrName());
        getBirthDateField().setValue(dispensaryData.getPatientsSearchBirthDate());
        getDocumentNumberField().setValue(dispensaryData.getPatientsSearchDocumentNumber());
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
