package businessFramework.module.pharmacy.pages.requestSpecifications;

import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.RequestSpecification.RequestSpecificationModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class RequestSpecificationsPage extends RequestSpecificationsHelper implements Values
{
    public RequestSpecificationsPage(ApplicationManager app)
    {
        super(app);
    }

 /* -------------------- Кнопки в контейнере Партии ------------------------- */

    /**
     * Нажатие на кнопку "Добавить"
     */
    public void clickAddSpecification()
    {
        Button addSpecification = getAddSpecificationButton();
        addSpecification.assertIsEnabled();
        addSpecification.click();
    }

    /**
     * Проверка заголовка модального окна добавления спецификации требования
     *
     * @param headerName Наименования заголовка модального окна
     */
    public void assertAddSpecificationModalHeader(String headerName)
    {
       assertCountOfModals(1);
        getModal().assertModalHeader_contains(headerName);
    }

     /* -------------------- Кнопки в контейнере "Спецификации" ------------------------- */

    /**
     * Нажатие на кнопку "Изменить"
     */
    public void clickUpdateSpecification()
    {
        Button updateSpecification = getUpdateSpecificationButton();
        updateSpecification.assertIsEnabled();
        updateSpecification.click();
    }

    /**
     * Нажатие на кнопку "Просмотр"
     */
    public void clickViewSpecification()
    {
        Button viewSpecification = getViewSpecificationButton();
        viewSpecification.assertIsEnabled();
        viewSpecification.click();
    }

    /**
     * Проверка заголовка модального окна добавления спецификации требования
     *
     * @param headerName Заголовок модальной страницы
     */
    public void assertUpdateAndViewSpecificationModalHeader(String headerName)
    {
        assertCountOfModals(1);
        getModal().assertModalHeader_contains(headerName);
    }

    /**
     * Нажатие на кнопку "Удалить" и подтверждение предупреждения об удалении
     */
    public void clickDeleteSpecificationAndAcceptDialog()
    {
        Button deleteSpecification = getDeleteSpecificationButton();
        deleteSpecification.assertIsEnabled();
        deleteSpecification.click();
        getDialog().clickYes();
    }

    /* -------------------- Действия в контейнере Партии ------------------------- */

    /**
     * Проверка фильтра в контейнере Партии
     *
     * @param comGroup Товарная группа
     * @param fundSource Финансирование
     */
    public void assertBatchListFilter(String fundSource, String comGroup)
    {
        getFilterCommodityGroup().assertValue(comGroup);
        getFilterFundingSource().assertValue(fundSource);
        getFilterExistsInPharmacyCheckBox().assertThatCheckboxIsChecked(true);
    }

    /**
     * Фильтрация таблицы Партии по "Наименование ЛС и ИМН" и выбор модификации
     *
     * @param modificationName Наименование ЛС и ИМН
     */
    public void filterAndSelectModification(String modificationName)
    {
        getFilterModificationName().setValue(modificationName);
        getFilterForBatchList().clickFindButton();
        getBatchListTable().chooseRowInTable(0);
    }

    /**
     * Проверка сообщения об успешном сохранении "Спецификация сохранена"
     */
    public void assertBatchListSuccessMessage(String message)
    {
        getBatchListTable().getAlerts().assertSuccessAlertMessage(message);
    }

    /* -------------------- Действия в контейнере Спецификации ------------------------- */

    /**
     * Возвращает модальное окно Специфкация
     *
     * @return модальное окно Специфкация
     */
    public RequestSpecificationModal getRequestSpecificationModal()
    {
        return new RequestSpecificationModal(app);
    }

    /**
     * Проверка сообщения об успешном сохранении "Спецификация сохранена"
     */
    public void assertSpecificationListSuccessMessage(String message)
    {
        getSpecificationsListTable().getAlerts().assertSuccessAlertMessage(message);
    }
}