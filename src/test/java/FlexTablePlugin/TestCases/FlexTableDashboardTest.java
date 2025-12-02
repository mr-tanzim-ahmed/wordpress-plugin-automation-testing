package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.*;
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
                .doLogin(getUserNameOrEmail(), getPassword())
               .clickFlexTableFromMenu();
       Assert.assertTrue(flexTableDashboard.isItFlexTableDashboardPage(),"Check FlexTable Dashboard page is loaded correctly");
    }

}
