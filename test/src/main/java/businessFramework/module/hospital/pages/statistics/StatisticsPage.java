package businessFramework.module.hospital.pages.statistics;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.pages.statisticCard.StatisticCardPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class StatisticsPage extends StatisticsHelper
{
    public StatisticsPage(ApplicationManager app)
    {
        super(app);
    }

    public StatisticCardPage getStatisticCardPage()
    {
        return new StatisticCardPage(app);
    }

    public StatisticsFilter getFilter()
    {
        return new StatisticsFilter(app);
    }

    public void clickCreateStatisticCardButton()
    {
        Button button = getCreateButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickUpdateStatisticCardButton()
    {
        Button button = getEditButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickDeleteStatisticCardButton()
    {
        Button button = getDeleteButton();
        button.assertIsEnabled();
        button.click();
        getModal().getButton(CONFIRM_BUTTON).click();
    }

    public void clickGetBillButton()
    {
        Button button = getBillButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Счет");
    }

    public void createHospitalCard(HospitalData hospitalData)
    {
        this.clickCreateStatisticCardButton();
        getStatisticCardPage().fillForm(hospitalData);
        getStatisticCardPage().clickSaveHospitalButton();
    }

    public void editHospitalCard(HospitalData hospitalData)
    {
        this.clickUpdateStatisticCardButton();
        getStatisticCardPage().fillForm(hospitalData);
        getStatisticCardPage().clickSaveHospitalButton();
    }

    /**
     * Удаление случаев госпитализации
     *
     * @param hospitalData
     */
    public void deleteHospitalCase(HospitalData hospitalData)
    {
        getFilter().getAdmissionDate().setPeriod("", "");
        getFilter().getPatient().setValue(hospitalData.getPatient());
        getFilter().getChooseCases().selectOption(0);
        this.getContainerStatisticalMapList().getFilter().clickFindButton();

        Table table = this.getContainerStatisticalMapList().getTable();

        while (table.getCountRowsInTable(true) > 0)
        {
            int size = table.getCountRowsInTable(true);
            table.chooseRowInTable(0);
            this.clickDeleteStatisticCardButton();
            table = this.getContainerStatisticalMapList().getTable();
            assertThat("Rows doesn't delete from table", size,
                    not(table.getCountRowsInTable(true)));
        }
        this.getContainerHospitalRecords().assertThatContainerIsAvailable(false);
        this.getContainerServices().assertThatContainerIsAvailable(false);
    }

    public void assertBill()
    {
        this.clickGetBillButton();
        getBill().setValue(0);
        String mainWindow = app.getWebDriverHelper().getDriver().getWindowHandle();
        getConfirmBillButton().click();
        app.getBaseHelperWithWebDriver().switchToWindow(app.getBaseHelperWithWebDriver().getNewWindow());
        String currentUrl = getCurrentUrl();
        app.getWebDriver().close();
        app.getBaseHelperWithWebDriver().switchToWindow(mainWindow);
        assertThat("Bill page doesn't opened",
                currentUrl.matches(app.getProperty("baseUrl").replaceAll("/frontend.*", "") + "/billing/bills/\\d+/spec.*"));
    }

    public void filterHospitalCase(HospitalData hospitalData)
    {
        getFilter().getChooseCases().selectOption(hospitalData.getCaseType());
        getFilter().getPatient().setValue(hospitalData.getPatient());
        getContainerStatisticalMapList().getFilter().clickFindButton();
    }
}
