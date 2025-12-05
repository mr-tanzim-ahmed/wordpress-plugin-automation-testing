package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.*;
import config.EnvManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlexTableDashboardTest extends BaseTest{
    /* Test Case 3: Navigate to FlexTable Dashboard
Objective: Confirm that the FlexTable Dashboard loads correctly.
Steps:
1. From WP Admin, navigate to FlexTable → Dashboard.
2. Wait for the page to fully load.
Expected Result:
- FlexTable Dashboard UI is displayed without errors.
*/

   @Test(priority = 1)
    public void validateFlexTableDashboardLoadCorrectly(){
       FlexTableDashboard flexTableDashboard = page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
               .clickFlexTableFromMenu();
       Assert.assertTrue(flexTableDashboard.isItFlexTableDashboardPage(),"Check FlexTable Dashboard page is loaded correctly");
    }
    @Test(priority = 2)  //FlexTable Dashboard UI is displayed without errors.
    public void validateFlexTableDashboardUiDisplayed(){
        FlexTableDashboard flexTableDashboard = page.goTo(FlexTableDashboard.class);

        Assert.assertTrue(flexTableDashboard.isFlexTableDashboardUiDisplayed(),"Check FlexTable Dashboard UI is displayed");
    }

}
