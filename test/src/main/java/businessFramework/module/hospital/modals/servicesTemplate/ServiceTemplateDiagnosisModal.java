package businessFramework.module.hospital.modals.servicesTemplate;

import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

/**
 * @author agabdrakhmanova
 * @since 20.01.2016
 */
public class ServiceTemplateDiagnosisModal {
    private Page page = Page.getInstance();
    public Container container;

    public ServiceTemplateDiagnosisModal() {
        container = page.getModal().getContainer("diagnosisList");
    }

    public void addDiagnosisToTemplate(String diagnosis)
    {
        container.getFilter().getInputText("name").setValue(diagnosis);
        container.getFilter().clickFindButton();

        container.getTable().chooseCheckboxInRow(0, "", true);
        container.getTable().chooseCheckboxInRow(1, "", true);
    }

    public void deleteDiagnosisFromTemplate(String diagnosis)
    {
        container.getFilter().getInputText("name").setValue(diagnosis);
        container.getFilter().getInputCheckBox("choice").check("Добавлено", true);

        container.getFilter().clickFindButton();
        container.getTable().assertThatCountOfRowsIs(2);

        container.getTable().chooseCheckboxInRow(1, "", true);
    }
}
