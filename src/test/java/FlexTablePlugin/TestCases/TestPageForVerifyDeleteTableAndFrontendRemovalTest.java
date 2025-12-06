package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.TestPage;
import config.EnvManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageForVerifyDeleteTableAndFrontendRemovalTest extends BaseTest {
    public String targetPage = properties.getProperty("homePageURL") + properties.getProperty("testPageSlug");

    // Test Case 9: Table deletion and proper empty state message


    @Test(priority = 1, description = "Verify proper empty state message after table deletion")
    public void checkAfterDeletedTableShowsProperEmptyMessage() {
        TestPage testPage = page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .clickDeleteTable()
                .clickPagesFromMenu()
                .visitCreatedTestPage(targetPage);

        Assert.assertTrue(testPage.deletedTableEmptyMessageCheck(),
                "Empty state message should be displayed after table deletion");
    }

    @Test(priority = 2)
    public void checkAfterTableDeletedTableNotDisplay() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertFalse(testPage.isTableDisplayedInTestPage(),
                "Table should not be displayed after deletion");
    }
}
