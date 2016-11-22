package businessFramework.module.hospital.modals.operPlanning;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Page;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * @author agabdrakhmanova
 * @since 12.11.2015
 */
public class OperationRoomScheduleModal implements Values {
    private Page page = Page.getInstance();

    public void chooseFreeQueue(String queue)
    {
        clickQueue(queue);
        page.getModal().getButton(CONFIRM_BUTTON).click();
    }

    public void saveQueue(String queue)
    {
        clickQueue(queue);
        page.getModal().getButton("saveQueueFromSchedule").click();
        page.getModal().getAlerts().assertSuccessAlertIsPresent();
        page.getModal().closeModal();
    }

    private void clickQueue(String queue)
    {
        List<WebElement> freeElements;
        freeElements = page.getContainer("operationSchedule").getTree().getTreeItemContainValue(queue);
        freeElements.get(0).click();
    }
}
