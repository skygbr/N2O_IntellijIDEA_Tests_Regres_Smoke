package test.smoke;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ErrorsSearchers
{

    Page page;
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * Конструктор. Устанавливает значение необходимых переменных.
     *
     */
    public ErrorsSearchers()
    {
        this.app    = ApplicationManager.getInstance();
        this.page   = Page.getInstance();
    }

     /**
     * Проверяет есть ли сообщение об ошибке в модальном окне.
     *
     * @return true если есть сообщение об ошибке,  false - в другом случае.
     */
    public String isErrorPresentsInModalWindow()
    {
        String xpath = String.format("" +
                "//*[contains(@class, 'n2o-modal-container')]" +
                "//div[contains(@class, 'alert-error')]" +
                "/../..[not(contains(@style, 'display: none'))]");

        List<WebElement> errorMessages = app.getWebDriver().findElements(By.xpath(xpath));

        if (errorMessages.size() > 0)
        {
            return errorMessages.get(0).getText(); // выводить сообщение так же
        }
        return "";
    }

    /**
     * Проверяет есть ли сообщение об ошибке на странице.
     *
     * @param container В каком контейнере искать сообщение об ошибке
     * @return true если есть сообщение об ошибке,  false - в другом случае.
     */
    public String isErrorPresentsByContainerElement(WebElement container)
    {
        String xpath = ".//div[contains(@class, 'alert-error')]/../..[not(contains(@style, 'display: none'))]";

        List<WebElement> errorMessages = container.findElements(By.xpath(xpath));

        if (errorMessages.size() > 0)
        {
            return errorMessages.get(0).getText();
        }
        return "";
    }

    /**
     * Проверка, что сообщение об ошибке присутствует в контейнере
     *
     * @param containerId контейнер, в котором ищется сообщение
     * @return true если сообщение присутствует, false иначе.
     */
    public String isErrorPresentsByContainerId(String containerId)
    {
        String xpath = String.format(
                "//div[contains(@class, 'n2o-container') and contains(@class, 'n2o-visible') and contains(@id, '%s')]" +
                "//div[contains(@class, 'alert-error')]" +
                "/../..[not(contains(@style, 'display: none'))]",
                containerId);

        List<WebElement> errorMessages = app.getWebDriver().findElements(By.xpath(xpath));

        if (errorMessages.size() > 0)
        {
            return errorMessages.get(0).getText();
        }
        return "";
    }
}
