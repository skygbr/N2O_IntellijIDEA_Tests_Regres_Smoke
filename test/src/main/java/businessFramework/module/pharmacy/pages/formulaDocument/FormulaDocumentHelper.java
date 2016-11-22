package businessFramework.module.pharmacy.pages.formulaDocument;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * @author ydolgih
 * @since 31.10.2015
 */
public class FormulaDocumentHelper extends Page implements Values {


    public FormulaDocumentHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getFormulaDocListContainer()
    {
        return getContainer("formulaDocList");
    }

    public Container getFormulaSpecListContainer()
    {
        return getContainer("formulaSpecList");
    }

     /* -----------------------------  Компоненты в контейнере "Прописи" ----------------------------- */

    public Table getFormulaDocListTable()
    {
        return getFormulaDocListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить" в контейнере "Прописи"
     */
    public Button getAddFormulaDocButton()
    {
        return getFormulaDocListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить" в контейнере "Прописи"
     */
    public Button getUpdateFormulaDocButton()
    {
        return getFormulaDocListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Удалить" в контейнере "Прописи"
     */
    public Button getDeleteFormulaDocButton()
    {
        return getFormulaDocListContainer().getButton(DELETE_BUTTON);
    }


     /* -----------------------------  Компоненты в контейнере "Спецификации" ----------------------------- */

    public Table getFormulaSpecListTable()
    {
        return getFormulaSpecListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить"  в контейнере "Спецификации"
     */
    public Button getAddFormulaSpecButton()
    {
        return getFormulaSpecListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить" в контейнере "Спецификации"
     */
    public Button getUpdateFormulaSpecButton()
    {
        return getFormulaSpecListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Удалить" в контейнере "Спецификации"
     */
    public Button getDeleteFormulaSpecButton()
    {
        return getFormulaSpecListContainer().getButton(DELETE_BUTTON);
    }
}