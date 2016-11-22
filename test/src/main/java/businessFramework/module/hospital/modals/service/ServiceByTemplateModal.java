package businessFramework.module.hospital.modals.service;


import businessFramework.entities.hospital.ServiceRenderedByTemplateData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

/**
 * @author agabdrakhmanova
 * @since 03.07.2015
 */
public class ServiceByTemplateModal implements Values {

    private ServiceByTemplateHelper serviceByTemplateHelper;
    private ServiceByTemplateCustomButtonGroup serviceByTemplateCustomButtonGroup;

    public ServiceByTemplateModal() {
        this.serviceByTemplateHelper = new ServiceByTemplateHelper();
        this.serviceByTemplateCustomButtonGroup = new ServiceByTemplateCustomButtonGroup(ApplicationManager.getInstance());
    }

    public void fillServiceByTemplateForm(ServiceRenderedByTemplateData data) {
        serviceByTemplateHelper.getBeginDateTime().setValue(data.getBdate());
        serviceByTemplateHelper.getTemplate().setValue(data.getTemplate());

        serviceByTemplateHelper.getServiceCheckboxGrid().chooseAllRows(true);
        serviceByTemplateHelper.getServiceCheckboxGrid().assertAllCheckboxIsSelected(true);
    }

    public void unSelectServices(ServiceRenderedByTemplateData data) {
        serviceByTemplateHelper.getServiceCheckboxGrid().chooseAllRows(true);
    }

    public void checkServiceCheckboxGridForCreate(ServiceRenderedByTemplateData data) {
        String[] stringArray = data.getColumnNameList().toArray(new String[]{});
        List<String> row1 = serviceByTemplateHelper.getServiceCheckboxGrid().getRowColumnIntersectionValues(0, stringArray);
        List<String> row2 = serviceByTemplateHelper.getServiceCheckboxGrid().getRowColumnIntersectionValues(1, stringArray);
        List<String> row3 = serviceByTemplateHelper.getServiceCheckboxGrid().getRowColumnIntersectionValues(2, stringArray);

        assertThat("1) serviceName must be " + data.getServiceNameList().get(0) + ", but was " + row1.get(0), row1.get(0), equalTo(data.getServiceNameList().get(0)));
        assertThat("1) status must be 'Назначено', but was " + row1.get(1), row1.get(1), equalTo("Назначено"));
        assertThat("1) planned date/time must be " + data.getBdate() + ", but was ", row1.get(2), equalTo(data.getBdate()));

        assertThat("2) serviceName must be " + data.getServiceNameList().get(1) + ", but was " + row2.get(0), row2.get(0), equalTo(data.getServiceNameList().get(1)));
        assertThat("2) status must be 'Назначено', but was " + row2.get(1), row2.get(1), equalTo("Назначено"));
        assertThat("2) planned date/time must be " + data.getBdate() + ", but was " + row2.get(2), row2.get(2), equalTo(data.getBdate()));

        assertThat("3) serviceName must be " + data.getServiceNameList().get(2) + ", but was " + row3.get(0), row3.get(0), equalTo(data.getServiceNameList().get(2)));
        assertThat("3) status must be 'Назначено', but was " + row3.get(1), row3.get(1), equalTo("Назначено"));
        assertThat("3) planned date/time must be " + data.getBdate() + ", but was " + row3.get(2), row3.get(2), equalTo(data.getBdate()));
    }

    public void checkServiceCheckboxGridForCancel(ServiceRenderedByTemplateData data) {
        String[] stringArray = data.getColumnNameList().toArray(new String[]{});
        List<String> row1 = serviceByTemplateHelper.getServiceCheckboxGrid().getRowColumnIntersectionValues(0, stringArray);
        List<String> row2 = serviceByTemplateHelper.getServiceCheckboxGrid().getRowColumnIntersectionValues(1, stringArray);
        List<String> row3 = serviceByTemplateHelper.getServiceCheckboxGrid().getRowColumnIntersectionValues(2, stringArray);

        assertThat("1) serviceName must be " + data.getServiceNameList().get(0) + ", but was " + row1.get(0), row1.get(0), equalTo(data.getServiceNameList().get(0)));
        assertThat("1) status must be '', but was " + row1.get(1), row1.get(1), equalTo(""));
        assertThat("1) planned date/time must be '', but was ", row1.get(2), equalTo(""));

        assertThat("2) serviceName must be " + data.getServiceNameList().get(1) + ", but was " + row2.get(0), row2.get(0), equalTo(data.getServiceNameList().get(1)));
        assertThat("2) status must be '', but was " + row2.get(1), row2.get(1), equalTo(""));
        assertThat("2) planned date/time must be '', but was " + row2.get(2), row2.get(2), equalTo(""));

        assertThat("3) serviceName must be " + data.getServiceNameList().get(2) + ", but was " + row3.get(0), row3.get(0), equalTo(data.getServiceNameList().get(2)));
        assertThat("3) status must be '', but was " + row3.get(1), row3.get(1), equalTo(""));
        assertThat("3) planned date/time must be '', but was " + row3.get(2), row3.get(2), equalTo(""));
    }

    public void clickAssign() {
        serviceByTemplateCustomButtonGroup.clickAssign();
    }

    public void clickCancel() {
        serviceByTemplateCustomButtonGroup.clickCancel();
    }

}
