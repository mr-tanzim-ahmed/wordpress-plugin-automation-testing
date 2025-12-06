package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.TestPage;
import config.EnvManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageForTableTitleAndDescriptionValidationTest extends BaseTest{
    public String targetPage = properties.getProperty("homePageURL") + properties.getProperty("testPageSlug");

    // Test Case 6: Table title and description display correctly
    @Test(priority = 3)
    public void verifyTableTitleShowsTheTestPages() {
        TestPage testPages = page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .clickEditTable()
                .clickTableCustomization()
                .clickShowTableTitle()
                .clickShowTableDescriptionAndSelectBelow()
                .clickSaveChangesButton()
                .clickPagesFromMenu()
                .visitCreatedTestPage(targetPage);

        Assert.assertTrue(testPages.isTableTitleDisplayed(properties.getProperty("tableTitle")),
                "Table title should be displayed in the Frontend Page");
    }

    @Test(priority = 4)
    public void verifyTableDescriptionShowsTheTestPages() {
        TestPage testPages = page.goTo(TestPage.class);
        Assert.assertTrue(testPages.isTableDescriptionDisplayed(properties.getProperty("tableDescription")),
                "Table description should be displayed below the table in the Frontend Page");
    }

}
