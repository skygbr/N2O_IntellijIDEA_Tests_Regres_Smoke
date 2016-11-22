package businessFramework.module.security;

import businessFramework.entities.security.SecData;
import businessFramework.module.security.group.GroupPage;
import businessFramework.module.security.role.RolePage;
import businessFramework.module.security.template.TemplatePage;
import businessFramework.module.security.user.UserPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

import java.awt.*;
import java.awt.event.KeyEvent;

/*
 /* @author enuzhdina 
 /* @since 16.12.2015
 */
public class SecurityManager {

    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();
    private TemplatePage templatePage;
    private RolePage rolePage;
    private GroupPage groupPage;
    private UserPage userPage;

    public void openSecurityModule(SecData data) {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(data.getContext());
        app.getNavigationHelper().openPageWithModule("sec");
    }

    public void openTemplateSpace() {
        page.getHeader().openPage("sec.secTemplate");
    }

    public void openRoleSpace() {
        page.getHeader().openPage("sec.secRole");
    }

    public void openGroupSpace() {
        page.getHeader().openPage("sec.secGroup");
    }

    public void openUserSpace() {
        page.getHeader().openPage("sec.secUser");
    }

    public void sendKeyCtrlF5() {
        try{
            Robot robotctrl_f5 = new Robot();
            robotctrl_f5.keyPress(KeyEvent.VK_CONTROL);
            robotctrl_f5.keyPress(KeyEvent.VK_F5);
            robotctrl_f5.keyRelease(KeyEvent.VK_CONTROL);
            robotctrl_f5.keyRelease(KeyEvent.VK_F5);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public TemplatePage getTemplatePage() {
        if (templatePage == null)
            templatePage = new TemplatePage();
        return templatePage;
    }

    public RolePage getRolePage() {
        if (rolePage == null)
            rolePage = new RolePage();
        return rolePage;
    }

    public GroupPage getGroupPage() {
        if (groupPage == null)
            groupPage = new GroupPage();
        return groupPage;
    }

    public UserPage getUserPage() {
        if (userPage == null)
            userPage = new UserPage();
        return userPage;
    }
}
