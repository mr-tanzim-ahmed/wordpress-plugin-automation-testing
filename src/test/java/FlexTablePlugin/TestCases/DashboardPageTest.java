package FlexTablePlugin.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import FlexTablePlugin.Pages.*;

public class DashboardPageTest extends BaseTest {

    @Test(priority = 3)
    public void checkDashboardPage(){
        DashboardPage dashboardPage = page.goTo(DashboardPage.class);
        Assert.assertTrue(dashboardPage.isItDashboardPage());
    }
}
