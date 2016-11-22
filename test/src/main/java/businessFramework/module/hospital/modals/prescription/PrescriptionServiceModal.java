package businessFramework.module.hospital.modals.prescription;

import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.entities.hospital.prescription.PrescriptionServiceData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * @author agabdrakhmanova
 * @since 30.11.2015
 */
public class PrescriptionServiceModal extends PrescriptionServiceHelper {

    public PrescriptionServiceModal() {
    }

    public void fillForm(PrescriptionServiceData prescriptionServiceData) {
        getCaseInfo().assertFieldText(prescriptionServiceData.getCaseInfo());
        getService().setValue(prescriptionServiceData.getService());
        getDuration().setValue(prescriptionServiceData.getDuration());
        getSrvDurationUnit().setValue(prescriptionServiceData.getSrvDurationUnit());
        getPeriodicity().setValue(prescriptionServiceData.getPeriodicity());
        getVisitTerm().setValue(prescriptionServiceData.getVisitTerm());

        getPeriodBeginDt().setValue(String.valueOf(prescriptionServiceData.getPeriodBeginDt()));
        getPeriodEndDt().setValue(prescriptionServiceData.getPeriodEndDt());
        getNote().setValue(prescriptionServiceData.getNote());
        getExecution().selectOption(prescriptionServiceData.getExecution());

        getName().assertValue(prescriptionServiceData.getService() + " " + prescriptionServiceData.getDuration() + " " +
                prescriptionServiceData.getSrvDurationUnit());
        getCount().assertFieldText(prescriptionServiceData.getCount());
    }

    public void assertForm(PrescriptionServiceData prescriptionServiceData) {
        getCaseInfo().assertFieldText(prescriptionServiceData.getCaseInfo());
        getName().assertValue(prescriptionServiceData.getName());
        getService().assertValue_equals(prescriptionServiceData.getService());
        getDuration().assertValue_equals(false, prescriptionServiceData.getDuration());
        getSrvDurationUnit().assertValue_equals(prescriptionServiceData.getSrvDurationUnit());
        getPeriodicity().assertValue_equals(prescriptionServiceData.getPeriodicity());
        getVisitTerm().assertValue_equals(prescriptionServiceData.getVisitTerm());

        getPeriodBeginDt().assertValue_equals(String.valueOf(prescriptionServiceData.getPeriodBeginDt()));
        getPeriodEndDt().assertValue_equals(prescriptionServiceData.getPeriodEndDt());
        getNote().assertValue(prescriptionServiceData.getNote());
        getExecution().assertValue(prescriptionServiceData.getExecution());
        getCount().assertFieldText(prescriptionServiceData.getCount());
    }

    public void clickConfirmButton() {
        Button confirm = getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

}
