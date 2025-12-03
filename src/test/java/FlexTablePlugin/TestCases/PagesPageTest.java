package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PagesPageTest extends BaseTest{
    String targetPage = (properties.getProperty("homePageURL")+properties.getProperty("pageTitle").replace(" ","-")).toLowerCase().trim();
    @Test(priority = 1)
    public void verifyFlexTableShortcodeInPagesPage() {
        TestPage pages = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .copyTableShortcode()
                .clickPagesFromMenu()
                .createNewPageAndPublish(properties.getProperty("pageTitle"))
                .visitCreatedTestPage(targetPage);
        Assert.assertTrue(pages.isTableDisplayedInTestPage(),"FlexTable is displayed in the Page");
    }
}
