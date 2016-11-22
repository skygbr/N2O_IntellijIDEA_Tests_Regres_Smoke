package businessFramework.module.hospital.pages.prescriptionExecution;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class PrescriptionExecutionFilter extends PrescriptionExecutionHelper
{
    public PrescriptionExecutionFilter(ApplicationManager app)
    {
        super(app);
    }

    public InputDate getPrescriptionDate()
    {
        return getContainerPrescriptionScheduleList().getFilter().getInputDate("dt");
    }

    public Select getPrescriptionStatus()
    {
        return getContainerPrescriptionScheduleList().getFilter().getSelect("status");
    }

    public Classifier getPrescriptionDepartment()
    {
        return getContainerPrescriptionScheduleList().getFilter().getClassifier("department");
    }

    public Classifier getPrescriptionPatient()
    {
        return getContainerPrescriptionScheduleList().getFilter().getClassifier("patient");
    }
}
