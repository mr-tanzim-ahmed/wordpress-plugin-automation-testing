package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.TestPage;
import config.EnvManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageForTableEntryInfoAndPaginationValidationTest extends BaseTest{

    public String targetPage = properties.getProperty("homePageURL") + properties.getProperty("testPageSlug");

    // Test Case 7: Entry Info, Pagination, and Layout validation

    @Test(priority = 1)
    public void confirmEntryInfoDisplaysCorrectly() {
        TestPage testPage = page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
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
        Assert.assertTrue(testPage.isShowEntryInfoDisplayed(),
                "Entry info should be displayed correctly");
    }

    @Test(priority = 2)
    public void validatePaginationDisplaysCorrectly() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isPaginationDisplayed(),
                "Pagination should be visible");
    }

    @Test(priority = 3)
    public void checkPaginationFunctionsOk() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isPaginationWorking(),
                "Pagination should be functional");
    }

    @Test(priority = 4)
    public void validateNoTableLayoutIssues() {
        TestPage testPage = page.goTo(TestPage.class);
        Assert.assertTrue(testPage.isTableDisplayedInTestPage(),
                "Table layout should display without issues");
    }

    @Test(priority = 5, description = "Validate layout for Show Entries and Pagination using CSS align-items")
    public void validateNoLayoutIssuesForShowEntriesAndPaginationByCssStyle() {
        TestPage testPage = page.goTo(TestPage.class);

        // Get the align-items CSS property value
        String alignItems = testPage.getCssAttribute(
                By.xpath("//div[@class='bottom_options bottom_options_0']"), "align-items");

        System.out.println("Align Items: " + alignItems);

        Assert.assertEquals(alignItems, "center",
                "Layout should have align-items: center, but got: " + alignItems);
    }

}
