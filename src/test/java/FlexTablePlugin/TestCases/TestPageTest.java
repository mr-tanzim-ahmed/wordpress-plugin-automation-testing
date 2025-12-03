package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageTest extends BaseTest{
    //Confirm the table renders correctly on the frontend using its shortcode.
    public  String targetPage = (properties.getProperty("homePageURL")+properties.getProperty("testPageTitle").replace(" ","-")).toLowerCase().trim();
    //Test Case 5:
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
        Assert.assertTrue(pages.isTableDisplayedInTestPage(),"FlexTable is displayed in the Page");
    }

    //Test Case 6:
    //Table title appears above the table.
    @Test (priority = 2)
    public void verifyTableTitleShowsTheTestPages(){
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
                Assert.assertTrue(testPages.isTableTitleDisplayed(properties.getProperty("tableTitle")),"Check table Title is displayed in the Test Page");
    }
    //Test Case 6:
    // Table description appears below the table.
    @Test (priority = 3)
    public void verifyTableDescriptionShowsTheTestPages(){
        TestPage testPages = page.goTo(TestPage.class);
        Assert.assertTrue(testPages.isTableDescriptionDisplayed(properties.getProperty("tableDescription")),"Check table description is displayed in the Test Page");
    }

    //Test Case 7:
    //Entry Info displays correctly.
    @Test(priority = 4)
    public void confirmEntryInfoDisplaysCorrectly(){
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
        Assert.assertTrue(testPage.isShowEntryInfoDisplayed(),"Entry info is displayed correctly");
    }
    //Pagination is visible
    @Test(priority = 5)
    public void validatePaginationDisplaysCorrectly(){
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isPaginationDisplayed());
    }
    //Pagination is functional.
    @Test(priority = 6)
    public void checkPaginationFunctionsOk(){
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isPaginationWorking(),"Pagination is functional");
    }
    //Pagination is functional.
    // No layout issues .
    @Test(priority = 6)
    public void validateNoTableLayoutIssues(){
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isTableDisplayedInTestPage(),"Check layout displays issues.");
    }

}
