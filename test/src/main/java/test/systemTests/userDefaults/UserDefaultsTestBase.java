package test.systemTests.userDefaults;

import net.framework.autotesting.meta.components.Classifier;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import test.systemTests.SystemTestBase;


/**
 * @author operehod
 * @since 15.09.2015
 */
public class UserDefaultsTestBase extends SystemTestBase {


    protected static void removeUserDefaults(Classifier field) {
        WebElement webElement;
        By by1 = By.cssSelector("[class*=floppy-saved]");
        By by2 = By.cssSelector("[class*=floppy-remove]");
        try {
            webElement = field.findElement(by1, field.takeContainer());
            if(!webElement.isDisplayed())
                webElement = field.findElement(by2, field.takeContainer());
        } catch (NoSuchElementException e) {
            webElement = field.findElement(by2, field.takeContainer());
        }
        webElement.click();
    }

    protected static void saveUserDefaults(Classifier field) {
        WebElement webElement = field.findElement(By.cssSelector("[class*=floppy-disk]"), field.takeContainer());
        webElement.click();
    }


}
