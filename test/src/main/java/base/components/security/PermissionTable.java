package base.components.security;


import net.framework.autotesting.meta.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by bulat.garipov on 01.02.2016.
 */
//Класс для работы с кастомным компонентом "Доступ по разделам"
public class PermissionTable {

    private Page page = Page.getInstance();
    private String id;

    public PermissionTable(String id) {
        this.id = id;
    }

    /**
     * Получение таблицы срезов
     *
     * @return таблица
     */
    private WebElement getTable() {
        return page.findElement(By.cssSelector(String.format("[id='n2o:%s']", id)));
    }

    /**
     * Получение списка групп
     *
     * @return список групп в виде webElement
     */
    private List<WebElement> getElementsGroup() {
        return page.findElements(By.cssSelector("[data-expand-type='elementsGroup']"), getTable());
    }

    /**
     * Получение группы по наименованию
     *
     * @param name наименование группы
     * @return группу
     */
    private WebElement getElementGroup(String name) {
        Optional<WebElement> element = getElementsGroup().stream()
                .filter(el -> el.findElement(By.cssSelector("span")).getText().trim().toLowerCase().equals(name.trim().toLowerCase())).findFirst();
        assertThat(String.format("Group %s doesn't found", name), element.isPresent(), is(true));
        return element.get();
    }

    /**
     * Получение списка элементов в группе
     *
     * @param groupName наименование группы
     * @return список элементов
     */
    private List<WebElement> getElements(String groupName) {
        WebElement group = getElementGroup(groupName);
        Optional<WebElement> open = page.findElements(By.cssSelector(".icon-chevron-right"), group).stream().findFirst();
        if (open.isPresent())
            page.click(open.get());
        String cssSelector = String.format("[data-model-id='%s']~[data-expand-type='element']", group.getAttribute("data-model-id"));
        return page.findElements(By.cssSelector(cssSelector));
    }

    /**
     * Получение элемента по наименованию в конкретной группе
     *
     * @param groupName   наименование группы
     * @param elementName наименование элемента
     * @return элемент
     */
    private WebElement getElement(String groupName, String elementName) {
        Optional<WebElement> element = getElements(groupName).stream()
                .filter(el -> el.getText().trim().toLowerCase().equals(elementName.trim().toLowerCase())).findFirst();
        return element.isPresent() ? element.get() : null;
    }

    /**
     * Список групп прав (просмотр, создание, редактирование, удаление)
     *
     * @return группы прав доступа
     */
    private List<WebElement> getPermissionGroups() {
        return page.findElements(By.cssSelector(".n2o-table-column-icon"), getTable());
    }

    /**
     * Получение конкретной группы доступа
     *
     * @param group наименование группы
     * @return порядковый номер группы доступа
     */
    private int getPermissionIndex(Group group) {
        List<WebElement> permissionGroup = getPermissionGroups();
        for (int i = 0; i < permissionGroup.size(); i++)
            if (permissionGroup.get(i).getAttribute("title").trim().toLowerCase().equals(group.getValue().trim().toLowerCase())) {
                return i;
            }
        Assert.fail(String.format("Doesn't found permission group by name %s", group.getValue()));
        return -1;
    }

    private List<WebElement> getPermissions(WebElement parent) {
        return page.findElements(By.cssSelector("input[type='checkbox']"), parent);
    }

    /**
     * Редактирование права в элементе
     *
     * @param groupName   наименование группы
     * @param elementName наименование элемента
     * @param group       группа доступа
     * @param isChange    включаем/отключаем доступ
     */
    private void changePermission(String groupName, String elementName, Group group, Boolean isChange) {
        int index = getPermissionIndex(group);
        WebElement permission = getPermissions(getElement(groupName, elementName)).get(index);
        if (permission.isSelected() != isChange)
            page.click(permission);
        assertThat("Fail selected checkbox", getPermissions(getElement(groupName, elementName)).get(index).isSelected(), is(isChange));
    }

    /**
     * Редактирование права в группе
     *
     * @param groupName наименование группы
     * @param group     группа доступа
     * @param isChange  включаем/отключаем доступ
     */
    private void changePermission(String groupName, Group group, Boolean isChange) {
        int index = getPermissionIndex(group);
        WebElement permission = getPermissions(getElementGroup(groupName)).get(index);
        if (permission.isSelected() != isChange)
            page.click(permission);
        assertThat("Fail selected checkbox", getPermissions(getElementGroup(groupName)).get(index).isSelected(), is(isChange));
    }

    public void changeRead(String groupName, Boolean isChange) {
        changePermission(groupName, Group.read, isChange);
    }

    public void changeRead(String groupName, String elementName, Boolean isChange) {
        changePermission(groupName, elementName, Group.read, isChange);
    }

    public void changeAdd(String groupName, Boolean isChange) {
        changePermission(groupName, Group.add, isChange);
    }

    public void changeAdd(String groupName, String elementName, Boolean isChange) {
        changePermission(groupName, elementName, Group.add, isChange);
    }

    public void changeEdit(String groupName, Boolean isChange) {
        changePermission(groupName, Group.edit, isChange);
    }

    public void changeEdit(String groupName, String elementName, Boolean isChange) {
        changePermission(groupName, elementName, Group.edit, isChange);
    }

    public void changeRemove(String groupName, Boolean isChange) {
        changePermission(groupName, Group.remove, isChange);
    }

    public void changeRemove(String groupName, String elementName, Boolean isChange) {
        changePermission(groupName, elementName, Group.remove, isChange);
    }

    /**
     * Получение права в группе внутри элемента
     *
     * @param groupName      наименование группы
     * @param elementName    наименование элемента
     * @param permissionName наименование права
     * @return право
     */
    private WebElement getPermission(String groupName, String elementName, String permissionName) {
        WebElement element = getElement(groupName, elementName);
        Optional<WebElement> result = page.findElements(By.cssSelector(".icon-chevron-right"), element).stream().findFirst();
        if (result.isPresent())
            page.click(result.get());
        String cssSelector = String.format("[data-model-id='%s']+tr div.row-fluid label", element.getAttribute("data-model-id"));
        Optional<WebElement> permissions = page.findElements(By.cssSelector(cssSelector)).stream()
                .filter(el -> el.getText().trim().toLowerCase().equals(permissionName.trim().toLowerCase()))
                .findFirst();
        assertThat(String.format("Permission %s doesn't found on group %s on element %s", permissionName, groupName, elementName),
                permissions.isPresent(), is(true));
        return permissions.get().findElement(By.cssSelector("input[type='checkbox']"));
    }

    public void changePermission(String groupName, String elementName, String permissionName, Boolean isChange) {
        WebElement permission = getPermission(groupName, elementName, permissionName);
        if (permission.isSelected() != isChange)
            page.click(permission);
        assertThat("Fail selected checkbox", getPermission(groupName, elementName, permissionName).isSelected(), is(isChange));
    }

    private WebElement getDepartmentPermission(String permissionName) {
        Optional<WebElement> result = page.findElements(By.cssSelector(".table-condensed tbody tr"), getTable()).stream()
                .filter(r -> r.findElement(By.cssSelector("span")).getText().trim().toLowerCase().equals(permissionName.trim().toLowerCase()))
                .findFirst();
        assertThat(String.format("Permission %s doesn't found", permissionName), result.isPresent(), is(true));
        return result.get();
    }

    private void changeDepartmentPermission(String permissionName, Group group, Boolean isChange){
        int index = getPermissionIndex(group);
        WebElement permission = getPermissions(getDepartmentPermission(permissionName)).get(index);
        if (permission.isSelected() != isChange)
            page.click(permission);
        assertThat("Fail selected checkbox", getPermissions(getDepartmentPermission(permissionName)).get(index).isSelected(), is(isChange));
    }

    public void changeDepartmentRead(String permissionName, Boolean isChange){
        changeDepartmentPermission(permissionName, Group.read, isChange);
    }

    public void changeDepartmentEdit(String permissionName, Boolean isChange){
        changeDepartmentPermission(permissionName, Group.update, isChange);
    }

    private void assertPermission(String groupName, Group group, Boolean isChange){
        int index = getPermissionIndex(group);
        WebElement permission = getPermissions(getElementGroup(groupName)).get(index);
        assertThat("Fail selected checkbox", permission.isSelected(), is(isChange));
    }

    public void assertRead(String groupName, Boolean isChange){
        assertPermission(groupName, Group.read, isChange);
    }

    public void assertEdit(String groupName, Boolean isChange){
        assertPermission(groupName, Group.edit, isChange);
    }

    public void assertAdd(String groupName, Boolean isChange){
        assertPermission(groupName, Group.add, isChange);
    }

    public void assertRemove(String groupName, Boolean isChange){
        assertPermission(groupName, Group.remove, isChange);
    }

    private void assertDepartmentPermission(String permissionName, Group group, Boolean isChange){
        int index = getPermissionIndex(group);
        WebElement permission = getPermissions(getDepartmentPermission(permissionName)).get(index);
        assertThat("Fail selected checkbox", permission.isSelected(), is(isChange));
    }

    public void assertDepartmentRead(String departmentName, Boolean isChange){
        assertDepartmentPermission(departmentName, Group.read, isChange);
    }

    public void assertDepartmentEdit(String departmentName, Boolean isChange){
        assertDepartmentPermission(departmentName, Group.update, isChange);
    }

    private enum Group {
        read("Просмотр"), add("Создание"), edit("Изменение"), remove("Удаление"), update("Редактирование");

        private String value;

        private Group(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
