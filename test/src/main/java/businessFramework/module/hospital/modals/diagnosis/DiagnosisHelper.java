package businessFramework.module.hospital.modals.diagnosis;


import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class DiagnosisHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public DiagnosisHelper()
    {
        this.container = "diagnosisForm";
    }

    public DiagnosisHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public Classifier getStage()
    {
        return getContainer().getForm().getClassifier("stage");
    }

    public Diagnosis getDiagnosis(){
        return new Diagnosis(app, getContainer().getForm().getFormElement(), "diagnosis");
    }

    public Classifier getDiagnosisList()
    {
        return getContainer().getForm().getClassifier("diagnosis");
    }

    public Button getSaveDiagnosisButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getUpdateDiagnosisButton()
    {
        return getContainer().getButton(SAVE_BUTTON);
    }

    public InputCheckBox getInputCheckBox()
    {
        return getContainer().getForm().getInputCheckBox("main");
    }

    public Classifier getFeature1()
    {
        return getContainer().getForm().getClassifier("attr[0]");
    }

    public Classifier getFeature2()
    {
        return getContainer().getForm().getClassifier("attr[1]");
    }

    public TextArea getNote() {
        return getContainer().getForm().getTextArea("note");
    }

    public DiagnosisFeatureModal getFeatureModal(){
        return new DiagnosisFeatureModal();
    }
}
