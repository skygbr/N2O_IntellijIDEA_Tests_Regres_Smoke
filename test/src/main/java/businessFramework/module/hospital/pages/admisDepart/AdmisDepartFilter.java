package businessFramework.module.hospital.pages.admisDepart;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class AdmisDepartFilter extends AdmissDepartHelper
{
    public AdmisDepartFilter(ApplicationManager app)
    {
        super(app);
    }

    public InputDate getAdmissionDate()
    {
        return this.getContainerHospitalCases().getFilter().getInputDate("admissionDate");
    }

    public Classifier getPatient()
    {
        return this.getContainerHospitalCases().getFilter().getClassifier("patient");
    }

    public InputText getUid()
    {
        return this.getContainerHospitalCases().getFilter().getInputText("uid");
    }

    public Classifier getFinancialType()
    {
        return this.getContainerHospitalCases().getFilter().getClassifier("financialType");
    }

}
