package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.TestPage;
import config.EnvManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageForValidateUpdateRowAndTableHeightTest extends BaseTest{

    public String targetPage = properties.getProperty("homePageURL") + properties.getProperty("testPageSlug");

    // Test Case 8: Rows per page and table height customization

    @Test(priority = 10)
    public void checkRowPerPagesAndCheckFrontendPage() {
        String rowPerPages = "30";
        page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .clickEditTable()
                .clickTableCustomization()
                .clickStyling()
                .selectValuesRowsToShowPerPage(rowPerPages)
                .clickSaveChangesButton();

        TestPage testPage = page.goTo(TestPage.class);
        testPage.openNewTabAndVisit(targetPage);

        String actualValue = testPage.checkShowEntries();
        Assert.assertEquals(actualValue, rowPerPages,
                "Rows per page mismatch - Expected: " + rowPerPages + ", but got: " + actualValue);
    }

    @Test(priority = 11)
    public void verifyTableHeightViaCss() {
        String expectedHeight = "800px";
        page.goTo(TestPage.class)
                .clickAndGoDashboard()
                .clickFlexTableFromMenu()
                .clickEditTable()
                .clickTableCustomization()
                .clickStyling()
                .selectTableHeight(expectedHeight)
                .clickSaveChangesButton();

        TestPage testPage = page.goTo(TestPage.class);
        testPage.openNewTabAndVisit(targetPage);

        String actualHeight = testPage.getTableHeight();
        Assert.assertEquals(actualHeight, expectedHeight,
                "Table height mismatch - Expected: " + expectedHeight + ", but got: " + actualHeight);
    }

}
