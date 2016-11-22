package test.systemTests.security;

import base.components.security.PermissionTable;
import businessFramework.entities.security.SecData;
import businessFramework.module.security.SecurityManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;


/**
 * Created by bulat.garipov on 01.02.2016.
 */
public class SecTest extends TestBase {
    private SecurityManager manager;
    private SecData data;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        manager = new SecurityManager();
        data = new SecData();
        data.setContext("Autotest Security Department");
        data.setTemplateCode("template_autotest");
        data.setTemplateName("template_autotest");
        data.setTemplateType("серверный");
        data.setRoleType("Региональная роль");
        data.setRoleName("role_autotest");
        data.setPermissionGroup("Прочее");
        data.setGroupName("group_autotest");
        data.setOrganization("Autotest Security Organization");
        data.setDepartment("Autotest Security Department");
        data.setLogin("testsec");
        data.setKeyType("Отдельный доступ в МО");
        data.setKeyName("key_autotest");
    }

    @Test(description = "Открытие страницы Шаблоны")
    public void step1_openSecTemplatePage() {
        manager.openSecurityModule(data);
        manager.openTemplateSpace();
    }

    @Test(description = "Удаление шаблонов", dependsOnMethods = "step1_openSecTemplatePage")
    public void step2_deleteTestData(){
        manager.getTemplatePage().deleteTemplate(data);
    }

    @Test(description = "Создания и поиск шаблона", dependsOnMethods = "step2_deleteTestData")
    public void step3_createTemplate() {
        manager.getTemplatePage().createTemplate(data);
    }

    @Test(description = "Назначение прав доступа на шаблон", dependsOnMethods = "step3_createTemplate")
    public void step4_changeTemplatePermissions(){
        PermissionTable permission = new PermissionTable("sec.secTemplate.domainObjects");
        permission.changeRead(data.getPermissionGroup(), true);
    }

    @Test(description = "Создание роли", dependsOnMethods = "step4_changeTemplatePermissions")
    public void step5_createRole(){
        manager.openRoleSpace();
        manager.getRolePage().createRole(data);
    }

    @Test(description = "Назначение прав доступа для роли", dependsOnMethods = "step5_createRole")
    public void step6_changeRolePermissions(){
        PermissionTable permission = new PermissionTable("sec.secRole.domainObjects");
        permission.changeAdd(data.getPermissionGroup(), true);
        permission.changeEdit(data.getPermissionGroup(), true);
        permission.changeRemove(data.getPermissionGroup(), true);
    }

    @Test(description = "Создание группы", dependsOnMethods = "step6_changeRolePermissions")
    public void step7_createGroup(){
        manager.openGroupSpace();
        manager.getGroupPage().createGroup(data);
        manager.getGroupPage().searchGroup(data);
    }

    @Test(description = "Назначение прав доступа для группы", dependsOnMethods = "step7_createGroup")
    public void step8_changeGroupPermissions(){
        PermissionTable permission = new PermissionTable("sec.secGroup.dep");
        permission.changeDepartmentRead(data.getDepartment(), true);
        permission.changeDepartmentEdit(data.getDepartment(), true);
    }

    @Test(description = "Создание ключа доступа пользователю", dependsOnMethods = "step8_changeGroupPermissions")
    public void step9_createAccessKey(){
        manager.openUserSpace();
        manager.getUserPage().searchUser(data);
        manager.getUserPage().openAccessKey();
        manager.getUserPage().getKeyPage().createKey(data);
    }

    @Test(description = "Проверка доступа в созданном ключе", dependsOnMethods = "step9_createAccessKey")
    public void step10_assertAccessKeyPermissions(){
        PermissionTable permGroup = new PermissionTable("sec.secUser.users.accessSettings.domainObjects");
        permGroup.assertRead(data.getPermissionGroup(), true);
        permGroup.assertAdd(data.getPermissionGroup(), true);
        permGroup.assertEdit(data.getPermissionGroup(), true);
        permGroup.assertRemove(data.getPermissionGroup(), true);

        PermissionTable permDep = new PermissionTable("sec.secUser.users.accessSettings.dep");
        permDep.assertDepartmentRead(data.getDepartment(), true);
        permDep.assertDepartmentEdit(data.getDepartment(), true);
    }

    @Test(description = "Удаление группы", dependsOnMethods = "step10_assertAccessKeyPermissions")
    public void step11_deleteGroup(){
        manager.openGroupSpace();
        manager.getGroupPage().deleteGroup(data);
    }

    @Test(description = "Удаление роли", dependsOnMethods = "step10_assertAccessKeyPermissions")
    public void step12_deleteRole(){
        manager.openRoleSpace();
        manager.getRolePage().deleteRole(data);
    }
}