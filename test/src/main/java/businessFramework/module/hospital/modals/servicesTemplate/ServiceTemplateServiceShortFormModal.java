package businessFramework.module.hospital.modals.servicesTemplate;

import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

/**
 * @author agabdrakhmanova
 * @since 19.01.2016
 */
public class ServiceTemplateServiceShortFormModal {
    private Page page = Page.getInstance();
    public Container container;

    public ServiceTemplateServiceShortFormModal() {
        container = page.getModal().getContainer("serviceList");
    }

    public void addServiceToTemplate(String service)
    {
        container.getFilter().getInputText("serviceNameCode").setValue(service);
        container.getFilter().clickFindButton();
        container.getTable().assertThatCountOfRowsIs(3);

        container.getTable().chooseCheckboxInRow(0, "", true);
        container.getTable().chooseCheckboxInRow(1, "", true);

    }

    public void deleteServiceFromTemplate(String service)
    {
        container.getFilter().getInputText("serviceNameCode").setValue(service);
        container.getFilter().getInputCheckBox("choice").check("Добавлено", true);

        container.getFilter().clickFindButton();
        container.getTable().assertThatCountOfRowsIs(2);

        container.getTable().chooseCheckboxInRow(1, "", true);
    }
}
