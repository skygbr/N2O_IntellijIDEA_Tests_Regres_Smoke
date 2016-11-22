package businessFramework.module.stomatology.pages.refferal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputCheckBox;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by RTlabs on 21.07.2016.
 */
public class StomReferralServiceHelper extends Page implements Values{
        public StomReferralServiceHelper(ApplicationManager app){
            super(app);
        }
        public Container getContainerReferralService(){
            return getRegion("single").getContainer("main");
        }

        public InputDate getReferralDate(){
            return getContainerReferralService().getForm().getInputDate("referralDate");
        }
        public InputCheckBox getIsUrgent(){
            return getContainerReferralService().getForm().getInputCheckBox("isUrgent");
        }
        public Classifier getDiagnosis(){
            return getContainerReferralService().getForm().getClassifier("diagnosis");
        }
        public Classifier getReferralType(){
            return getContainerReferralService().getForm().getClassifier("referralType");
        }
        public Classifier getRecvOrg(){
            return getContainerReferralService().getForm().getClassifier("recvOrg");
        }
        public Classifier getRecvDepartment(){
            return getContainerReferralService().getForm().getClassifier("recvDepartment");
        }
        public Classifier getRecvDoctor(){
            return getContainerReferralService().getForm().getClassifier("recvDoctor");
        }
    public Classifier getReferralService(){
        return getContainerReferralService().getForm().getClassifier("services");
    }
    public InputText getReferralComment(){
        return getContainerReferralService().getForm().getInputText("comment");
    }

        public Classifier getReferralPrototype0(){
            return getContainerReferralService().getForm().getClassifier("referralPrototype.0");
        }
        public Classifier getReferralPrototype1(){
            return getContainerReferralService().getForm().getClassifier("referralPrototype.1");
        }
        public Classifier getReferralPrototype2(){
            return getContainerReferralService().getForm().getClassifier("referralPrototype.2");
        }
        public Classifier getReferralPrototype3(){
            return getContainerReferralService().getForm().getClassifier("referralPrototype.3");
        }
        public Classifier getReferralPrototype4(){
            return getContainerReferralService().getForm().getClassifier("referralPrototype.4");
        }
        public Classifier getReferralAppendix0(){
            return getContainerReferralService().getForm().getClassifier("referralAppendix.0");
        }
        public InputText getAppendixName0(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.0.appendix_name");
        }
        public InputText getAppendixFileName0(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.0.appendix_name");
        }
        public InputText getAppendixComment0(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.0.appendix_name");
        }
        public Classifier getReferralAppendix1(){
            return getContainerReferralService().getForm().getClassifier("referralAppendix.1");
        }
        public InputText getAppendixName1(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.1.appendix_name");
        }
        public InputText getAppendixFileName1(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.1.appendix_name");
        }
        public InputText getAppendixComment1(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.1.appendix_name");
        }
        public Classifier getReferralAppendix2(){
            return getContainerReferralService().getForm().getClassifier("referralAppendix.2");
        }
        public InputText getAppendixName2(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.2.appendix_name");
        }
        public InputText getAppendixFileName2(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.2.appendix_name");
        }
        public InputText getAppendixComment2(){
            return getContainerReferralService().getForm().getInputText("referralAppendix.2.appendix_name");
        }

    }
