package businessFramework.module.hospital.modals.discharge;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.base.BaseHelperWithWebDriver;
import org.openqa.selenium.By;

/**
 * @author agabdrakhmanova
 * @since 17.09.2015
 */
public class DischargeTabHelper extends BaseHelperWithWebDriver  {

    public DischargeTabHelper(ApplicationManager app) {
        super(app);
    }

    public void clickResultTab()
    {
        executeJavaScript("$('.nav-tabs a[href=\"#tab2\"]').tab('show');");
    }

    public void clickDischargeTab()
    {
        executeJavaScript("$('.nav-tabs a[href=\"#tab1\"]').tab('show');");
    }
}
