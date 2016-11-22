package test.systemTests.userDefaults;

import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.components.Classifier;
import org.testng.annotations.Test;

/**
 * @author operehod
 * @since 15.09.2015
 */
public class UserDefaultsWithContextTest extends UserDefaultsTestBase {


    @Test(description = "Сохранения значения по умолчанию с контекстным префильтром на компоненте")
    public void testSaveDefaultWithContextPreFilters() {
        //1 находим компонент
        openPage("testUserDefaults");
        Container container = getContainer("single", "c12");
        Classifier field = container.getForm().getClassifier("field1");

        //2 устанавливает значения неудовлетворяющее условию префильтра
        field.clickLink("Установить текущий ключ доступа");
        saveUserDefaults(field);

        //3 обновляем страницу, проверям что значение не установилось
        refreshPage();
        container = getContainer("single", "c12");
        field = container.getForm().getClassifier("field1");
        field.assertValue_equals(null);

        //4 устанавливает "хорошее" значения
        field.clickLink("Установить другой ключ доступа");
        saveUserDefaults(field);

        //5 обновляем страницу, значения должно сохранится
        refreshPage();
        container = getContainer("single", "c12");
        field = container.getForm().getClassifier("field1");
        field.assertValue_contains("Постоянный лейбл");
    }

}
