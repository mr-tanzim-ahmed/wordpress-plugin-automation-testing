package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageTest extends BaseTest {

    public String targetPage = properties.getProperty("homePageURL")+properties.getProperty("testPageSlug");

    //Test Case 5: Confirm the table renders correctly on the frontend using its shortcode.
    @Test(priority = 1)
    public void verifyFlexTableShortcodeInPagesPage() {
        TestPage pages = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .copyTableShortcode()
                .clickPagesFromMenu()
                .createNewPageAndPublish(properties.getProperty("testPageTitle"))
                .visitCreatedTestPage(targetPage);
        Assert.assertTrue(pages.isTableDisplayedInTestPage(), "FlexTable is displayed in the Page");
    }
    //==============================================================================
    //Test Case 6: Table title appears above the table.
    @Test(priority = 2)
    public void verifyTableTitleShowsTheTestPages() {
        TestPage testPages = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
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
                "Check table Title is displayed in the Test Page");
    }

    //Test Case 6: Table description appears below the table.
    @Test(priority = 3)
    public void verifyTableDescriptionShowsTheTestPages() {
        TestPage testPages = page.goTo(TestPage.class);
        Assert.assertTrue(testPages.isTableDescriptionDisplayed(properties.getProperty("tableDescription")),
                "Check table description is displayed in the Test Page");
    }
    //==============================================================================
    //Test Case 7: Entry Info displays correctly.
    @Test(priority = 4)
    public void confirmEntryInfoDisplaysCorrectly() {
        TestPage testPage = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .clickEditTable()
                .clickTableCustomization()
                .clickShowEntryInfo()
                .clickShowPagination()
                .clickSaveChangesButton()
                .clickPagesFromMenu()
                .visitCreatedTestPage(targetPage);
        driver.get(targetPage);
        Assert.assertTrue(testPage.isShowEntryInfoDisplayed(), "Entry info is displayed correctly");
    }

    //Pagination is visible
    @Test(priority = 5)
    public void validatePaginationDisplaysCorrectly() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isPaginationDisplayed());
    }

    //Pagination is functional.
    @Test(priority = 6)
    public void checkPaginationFunctionsOk() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isPaginationWorking(), "Pagination is functional");
    }

    //No layout issues.
    @Test(priority = 7)
    public void validateNoTableLayoutIssues() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isTableDisplayedInTestPage(), "Check layout displays issues.");
    }

    //Validate Css Style
    @Test(priority = 8)
    public void validateNoLayoutIssuesForShowEntriesAndPaginationByCssStyle() {
        TestPage testPage = page.goTo(TestPage.class);
        String cssStyle = testPage.getCssAttribute(
                By.xpath("//div[@class='bottom_options bottom_options_0']"), "style");
        Assert.assertEquals(cssStyle, "flex-direction: row");
    }
    //==============================================================================
    //Test Case 8:
    @Test(priority = 9)
    public void checkRowPerPagesFrontendPage() {
        FlexTableDashboard dashboard = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .clickEditTable()
                .clickTableCustomization()
                .clickStyling()
                .selectValuesRowsToShowPerPage("30")
                .clickSaveChangesButton();

        TestPage testPage = page.goTo(TestPage.class);
        testPage.openNewTabAndVisit(targetPage);

        Assert.assertEquals(testPage.checkShowEntries(), "30",
                "Rows per page mismatch");
        
    }

    @Test(priority = 10)
    public void verifyTableHeightViaCss() {
        FlexTableDashboard flexTableDashboard = page.goTo(TestPage.class)
                .clickAndGoDashboard()
                .clickFlexTableFromMenu()
                .clickEditTable()
                .clickTableCustomization()
                .clickStyling()
                .selectTableHeight("800px")
                .clickSaveChangesButton();

        TestPage testPage = page.goTo(TestPage.class);
        testPage.openNewTabAndVisit(targetPage);
        String height = testPage.getTableHeight();
        Assert.assertEquals(height, "800px",
                "Validate table height, Height is: "+height);
    }
//==============================================================================
    //Test Case 9: Table does not display.
    @Test(priority = 12)
    public void checkAfterTableDeletedTableNotDisplay() {
        TestPage testPage = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .clickDeleteTable()
                .clickPagesFromMenu()
                .visitCreatedTestPage(targetPage);
        Assert.assertFalse(testPage.isTableDisplayedInTestPage(), "Table should not displayed");
    }

    //Proper error or empty state message appears.
    @Test(priority = 11)
    public void checkAfterDeletedTableShowsProperEmptyMessage() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertEquals(testPage.deletedTableEmptyMessageCheck(),
                "Table maybe deleted or can't be loaded.");
    }
}