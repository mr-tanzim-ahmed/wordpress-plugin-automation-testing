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

    @Test(priority = 1)
    public void checkRowPerPagesAndTableHeightFrontendPage() {
        String rowPerPages = "30";
        String expectedHeight = "800px";

        page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .clickEditTable()
                .clickTableCustomization()
                .clickStyling()
                .selectValuesRowsToShowPerPage(rowPerPages)
                .selectTableHeight(expectedHeight)
                .clickSaveChangesButton();

        TestPage testPage = page.goTo(TestPage.class);
        testPage.openNewTabAndVisit(targetPage);

        String actualValue = testPage.checkShowEntries();
        Assert.assertEquals(actualValue, rowPerPages,
                "Rows per page mismatch - Expected: " + rowPerPages + ", but got: " + actualValue);
        String actualHeight = testPage.getTableHeight();
        Assert.assertEquals(actualHeight, expectedHeight,
                "Table height mismatch - Expected: " + expectedHeight + ", but got: " + actualHeight);
    }



}
