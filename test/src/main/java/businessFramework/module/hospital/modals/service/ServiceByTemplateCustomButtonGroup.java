package businessFramework.module.hospital.modals.service;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.base.BaseHelperWithWebDriver;
import org.openqa.selenium.By;

/**
 * @author agabdrakhmanova
 * @since 03.07.2015
 */
public class ServiceByTemplateCustomButtonGroup extends BaseHelperWithWebDriver {
    public ServiceByTemplateCustomButtonGroup(ApplicationManager app) {
        super(app);
    }

    public void clickAssign()
    {
        click(findElement(By.id("assignServiceTemplate")));
    }

    public void clickCancel()
    {
        click(findElement(By.id("cancel")));
    }
}
