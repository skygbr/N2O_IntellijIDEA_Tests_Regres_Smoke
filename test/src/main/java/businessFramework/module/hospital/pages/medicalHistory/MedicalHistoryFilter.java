package businessFramework.module.hospital.pages.medicalHistory;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class MedicalHistoryFilter extends MedicalHistoryHelper
{
    public MedicalHistoryFilter(ApplicationManager app)
    {
        super(app);
    }

    public InputCheckBox getAll()
    {
        return getContainerDiagnosisList().getFilter().getInputCheckBox("all");
    }
}
