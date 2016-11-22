package businessFramework.module.pharmacy.pages.documentsForCancellation;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class DocsForWriteOffHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public DocsForWriteOffHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получает контейнер "Документы на списание"
     * @return контейнер "Документы на списание"
     */
    public Container getWriteOffDocListContainer()
    {
        return getContainer("writeOffDocList");
    }


    /** -------------------- Действия с фильтром --------------------------- */

    /**
     * Получает фильтр в контейнере "Расходные накладные"
     * @return фильтр в контейнере "Расходные накладные"
     */
    public Filter getFilterWriteOffDocs()
    {
        return getWriteOffDocListContainer().getFilter();
    }

    /**
     * @return Поле "Дата документа" в фильтре
     */
    public InputDate getDocumentDate()
    {
        return getFilterWriteOffDocs().getInputDate("docDate");
    }

    /** ----------------- Кнопки на странице "Документы на списание" -------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getAddDocButton()
    {
        return getWriteOffDocListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditDocButton()
    {
        return getWriteOffDocListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Копировать"
     */
    public Button getCopyDocButton()
    {
        return getWriteOffDocListContainer().getButton(COPY_BUTTON);
    }

    /**
     * @return кнопку "Просмотр"
     */
    public Button getViewDocButton()
    {
        return getWriteOffDocListContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteDocButton()
    {
        return getWriteOffDocListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return кнопку "Провести"
     */
    public Button getExecuteDocButton()
    {
        return getWriteOffDocListContainer().getButton(EXECUTE);
    }

    /**
     * @return кнопку "Вернуть"
     */
    public Button getCancelExecutionWriteOffDocButton()
    {
        return getWriteOffDocListContainer().getButton(CANCEL);
    }

    /** ------------------------------------ Действия с контейнером "Спецификации" --------------------------------------- */

    /**
     * @return получает страницу
     */
    public SpecificationsWriteOffDocPage getSpecificationsWriteOffDocPage()
    {
        return new SpecificationsWriteOffDocPage(app);
    }

    /**
     * @return контейнер "Спецификации"
     */
    public Container getSpecWriteOffDocContainer()
    {
        return getContainer("writeOffSpecList");
    }


    /**
     * @return кнопку "Добавить"
     */
    public Button getAddSpecButton()
    {
        return getSpecWriteOffDocContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Провести"
     */
    public Button getExecuteSpecButton()
    {
        return getSpecWriteOffDocContainer().getButton(EXECUTE);
    }

    /**
     * @return окно с надписью "Предупреждение" после нажатия на кнопку "Удалить" на странице "Документы на списание" в контейнере "Документы на списание"
     */
    public Dialog getConfirmModal()
    {
        return page.getDialog(); // Получает последнее активное модальное окно ( ожидается окно с надписью "Предупреждение" после нажатия на кнопку "Удалить" на странице "Расходные накладные" в контейнере "Расходные накладные")
    }
}
