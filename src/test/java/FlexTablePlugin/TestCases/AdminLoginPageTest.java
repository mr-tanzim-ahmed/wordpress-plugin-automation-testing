package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.*;
import org.testng.Assert;
import FlexTablePlugin.Pages.BasePage;
import org.testng.annotations.Test;

public class AdminLoginPageTest extends BaseTest {

    //Check Login page URL
    @Test(priority = 1)
    public void checkLoginPageUrl(){
        AdminLoginPage login = page.goTo(AdminLoginPage.class);
        String loginPageUrl = login.getCurrentPageURL();
        Assert.assertEquals(loginPageUrl,properties.getProperty("baseURL"));
    }
    //Test Case 1: Verify WordPress Login Functionality
    @Test
    public void loginShouldSucceed(){
        DashboardPage dashboardPage = page.goTo(AdminLoginPage.class)
                .enterUserNameOrEmail(getUserNameOrEmail())
                .enterPassword(properties.getProperty(getPassword()))
                .clickPasswordVisibility()
                .checkRememberMe()
                .clickLoginButton();
    }


}
