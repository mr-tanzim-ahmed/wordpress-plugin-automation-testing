package FlexTablePlugin.TestCases;

import org.testng.Assert;
import FlexTablePlugin.TestCases.*;
import org.testng.annotations.Test;
import FlexTablePlugin.Pages.*;

public class DashboardPageTest extends BaseTest {

    @Test(priority = 1)
    public void checkDashboardPage(){

        page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword());
        DashboardPage dashboardPage = page
                .goTo(DashboardPage.class);
        Assert.assertTrue(dashboardPage.isItDashboardPage());
    }
}
