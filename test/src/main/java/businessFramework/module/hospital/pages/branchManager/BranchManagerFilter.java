package businessFramework.module.hospital.pages.branchManager;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class BranchManagerFilter extends BranchManagerHelper
{
    public BranchManagerFilter(ApplicationManager app) {
        super(app);
    }

    public Classifier getPatient()
    {
        return getContainerMdHistory().getFilter().getClassifier("patient");
    }

    public InputCheckBox getShowClosedCases()
    {
        return getContainerMdHistory().getFilter().getInputCheckBox("showClosedCases");
    }
}
