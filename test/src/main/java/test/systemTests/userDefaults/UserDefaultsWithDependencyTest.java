package test.systemTests.userDefaults;

import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.MultiClassifier;
import org.testng.annotations.Test;

/**
 * @author operehod
 * @since 15.09.2015
 */
public class UserDefaultsWithDependencyTest extends UserDefaultsTestBase {


    @Test(description = "Сохраням значения всех полей")
    public void prepareTest() {
        openPage("testUserDefaults");
        Container container = getContainer("single", "c11");
        saveUserDefaultForClassifier(container, "field1");
        saveUserDefaultForClassifier(container, "field2");
        saveUserDefaultForMultiClassifier(container, "field3");
        saveUserDefaultForClassifier(container, "field4");
        saveUserDefaultForClassifier(container, "field5");
        saveUserDefaultForMultiClassifier(container, "field6");
        saveUserDefaultForMultiClassifier(container, "field7");
    }

    @Test(description = "Проверяем что все значения по умолчанию сохранились", dependsOnMethods = "prepareTest")
    public void assertAllValuesSaved() {
        refreshPage();
        Container container = getContainer("single", "c11");
        assert !container.getForm().getClassifier("field1").getValue().isEmpty();
        assert !container.getForm().getClassifier("field2").getValue().isEmpty();
        assert !container.getForm().getMultiClassifier("field3").getMultiValues().isEmpty();
        assert !container.getForm().getClassifier("field4").getValue().isEmpty();
        assert !container.getForm().getClassifier("field5").getValue().isEmpty();
        assert !container.getForm().getMultiClassifier("field6").getMultiValues().isEmpty();
        assert !container.getForm().getMultiClassifier("field7").getMultiValues().isEmpty();
    }


    @Test(description = "Удаляем Парент 3. Проверяем что все зависимы от него значения сбросились", dependsOnMethods = "assertAllValuesSaved")
    public void assertAfterParent3Remove() {
        // удаляем
        Container container = getContainer("single", "c11");
        removeUserDefaultsForMultiClassifier(container, "field3");

        // проверяем
        refreshPage();
        container = getContainer("single", "c11");
        assert !container.getForm().getClassifier("field1").getValue().isEmpty();
        assert !container.getForm().getClassifier("field2").getValue().isEmpty();
        assert container.getForm().getMultiClassifier("field3").getMultiValues().isEmpty();
        assert !container.getForm().getClassifier("field4").getValue().isEmpty();
        assert !container.getForm().getClassifier("field5").getValue().isEmpty();
        assert container.getForm().getMultiClassifier("field6").getMultiValues().isEmpty();
        assert container.getForm().getMultiClassifier("field7").getMultiValues().isEmpty();
    }

    @Test(description = "Удаляем Парент 2. Проверяем что все зависимы от него значения сбросились", dependsOnMethods = "assertAfterParent3Remove")
    public void assertAfterParent2Remove() {
        // удаляем
        Container container = getContainer("single", "c11");
        removeUserDefaultsForClassifier(container, "field2");

        // проверяем
        refreshPage();
        container = getContainer("single", "c11");
        assert !container.getForm().getClassifier("field1").getValue().isEmpty();
        assert container.getForm().getClassifier("field2").getValue().isEmpty();
        assert container.getForm().getMultiClassifier("field3").getMultiValues().isEmpty();
        assert !container.getForm().getClassifier("field4").getValue().isEmpty();
        assert container.getForm().getClassifier("field5").getValue().isEmpty();
        assert container.getForm().getMultiClassifier("field6").getMultiValues().isEmpty();
        assert container.getForm().getMultiClassifier("field7").getMultiValues().isEmpty();
    }


    @Test(description = "Удаляем Парент 1. Проверяем что все зависимы от него значения сбросились", dependsOnMethods = "assertAfterParent2Remove")
    public void assertAfterParent1Remove() {
        // удаляем
        Container container = getContainer("single", "c11");
        removeUserDefaultsForClassifier(container, "field1");

        // проверяем
        refreshPage();
        container = getContainer("single", "c11");
        assert container.getForm().getClassifier("field1").getValue().isEmpty();
        assert container.getForm().getClassifier("field2").getValue().isEmpty();
        assert container.getForm().getMultiClassifier("field3").getMultiValues().isEmpty();
        assert container.getForm().getClassifier("field4").getValue().isEmpty();
        assert container.getForm().getClassifier("field5").getValue().isEmpty();
        assert container.getForm().getMultiClassifier("field6").getMultiValues().isEmpty();
        assert container.getForm().getMultiClassifier("field7").getMultiValues().isEmpty();
    }

    protected static void removeUserDefaultsForMultiClassifier(Container container, String fieldId) {
        MultiClassifier field = container.getForm().getMultiClassifier(fieldId);
        if (!field.getMultiValues().isEmpty()) {
            //todo разобраться в конце концов как вызвать дискетку на любой компоненте
            field.openCombobox();
            removeUserDefaults(field);
        }
    }

    protected static void removeUserDefaultsForClassifier(Container container, String fieldId) {
        Classifier field = container.getForm().getClassifier(fieldId);
        if (!field.getValue().isEmpty()) {
            //todo разобраться в конце концов как вызвать дискетку на любой компоненте
            field.setValue(0);
            removeUserDefaults(field);
        }
    }


    protected static void saveUserDefaultForClassifier(Container container, String fieldId) {
        Classifier field = container.getForm().getClassifier(fieldId);
        if (field.getValue().isEmpty()) {
            field.setValue(0);
            saveUserDefaults(field);
        }
    }


    protected static void saveUserDefaultForMultiClassifier(Container container, String fieldId) {
        MultiClassifier field = container.getForm().getMultiClassifier(fieldId);
        if (field.getMultiValues().isEmpty()) {
            field.setValue(0);
            saveUserDefaults(field);
        }
    }

}
