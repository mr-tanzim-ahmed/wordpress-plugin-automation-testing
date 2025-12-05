package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.*;
import config.EnvManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewTablePageTest extends BaseTest {

    //Test Case 4: Create a New Table Using Google Sheet Input
    @Test(priority = 1)
    public void validateCreateNewTable(){

        CreateNewTablePage createNewTablePage = page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
                .clickFlexTableFromMenu()
                .clickCreateNewTableButton()
                .inputGoogleSheetUrl(EnvManager.googleSheetURL())
                .clickCreateTableFromUrlButton()
                .inputTableTitle(properties.getProperty("tableTitle"))
                .inputTableDescription(properties.getProperty("tableDescription"))
                .clickSaveChangesButton()
                .clickNextButton();
        Assert.assertTrue(createNewTablePage.isTableCreatedSuccessfully(),"Check table is displayed successfully");

        // Return to Dashboard
        page.goTo(FlexTableDashboard.class);
    }

    @Test(priority = 2)     //A new table entry appears in the FlexTable Dashboard list.
    public void validateNewTableEntryInDashboard(){
        FlexTableDashboard flexTableDashboard = page.goTo(CreateNewTablePage.class)
                .clickFlexTableDashboardButton();

        Assert.assertTrue(flexTableDashboard.isItFlexTableDashboardPage(),"Check is it FlexTable Dashboard Page");
        Assert.assertTrue(flexTableDashboard.isFlexTableDashboardUiDisplayed(),"Check FlexTable Dashboard UI is displayed");

        Assert.assertTrue(flexTableDashboard.checkNewTableEntryInDashboard(),"Check new table entry is displayed in dashboard");
    }
    @Test(priority = 3) //Table name is displayed correctly.
    public void validateTableNameDisplayedCorrectly() {
        FlexTableDashboard flexTableDashboard = page.goTo(FlexTableDashboard.class);

        Assert.assertEquals(flexTableDashboard.checkTableNameInDashboard(),properties.getProperty("tableTitle"));
    }
}
