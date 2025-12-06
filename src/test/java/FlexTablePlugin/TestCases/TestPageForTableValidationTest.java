package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.*;
import config.EnvManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static FlexTablePlugin.Pages.ValidateRandomTableDataFromTestPage.tableCellData;

public class TestPageForTableValidationTest extends BaseTest {

    public String targetPage = properties.getProperty("homePageURL") + properties.getProperty("testPageSlug");


    // Test Case 5: Confirm the table renders correctly on the frontend using its shortcode

    @Test(priority = 1, description = "Verify FlexTable shortcode displays correctly on frontend page")
    public void verifyFlexTableShortcodeFromFrontendPage() {
        TestPage pages = page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
                .goTo(DashboardPage.class)
                .clickFlexTableFromMenu()
                .copyTableShortcode()
                .clickPagesFromMenu()
                .createNewPageAndPublish(properties.getProperty("testPageTitle"))
                .visitCreatedTestPage(targetPage);

        Assert.assertTrue(pages.isTableDisplayedInTestPage(),
                "FlexTable should be displayed in the Frontend Page");
    }

    @Test(priority = 2, description = "Validate Google Sheet data matches Test Page table data")
    public void matchGoogleSheetDataToTestPageTable() throws Exception {
        ValidateRandomTableDataFromTestPage validationPage = new ValidateRandomTableDataFromTestPage(driver);

        // Load CSV data from Google Sheet
        validationPage.getDataFromRandomTableCells();

        String r2c1 = tableCellData.get("r2c1");
        String r2c2 = tableCellData.get("r2c2");
        String r3c1 = tableCellData.get("r3c1");
        String r3c2 = tableCellData.get("r3c2");

        System.out.println("=== CSV Table Cell Data ===");
        System.out.println("Row 2, Col 1 → " + r2c1);
        System.out.println("Row 2, Col 2 → " + r2c2);
        System.out.println("Row 3, Col 1 → " + r3c1);
        System.out.println("Row 3, Col 2 → " + r3c2);
        System.out.println("===========================");

        // Navigate to test page
        page.goTo(ValidateRandomTableDataFromTestPage.class)
                .openNewTabAndVisit(targetPage);

        // Read values from Test Page (Page row index starts from 1)
        String pageR2C1 = validationPage.getCellValue(1, 1);
        String pageR2C2 = validationPage.getCellValue(1, 2);
        String pageR3C1 = validationPage.getCellValue(2, 1);
        String pageR3C2 = validationPage.getCellValue(2, 2);

        System.out.println("=== Page Table Cell Data ===");
        System.out.println("Row 2, Col 1 → " + pageR2C1);
        System.out.println("Row 2, Col 2 → " + pageR2C2);
        System.out.println("Row 3, Col 1 → " + pageR3C1);
        System.out.println("Row 3, Col 2 → " + pageR3C2);
        System.out.println("============================");

        // Validate table cells
        Assert.assertEquals(pageR2C1, r2c1,
                "Mismatch at Row 2 Column 1 → Sheet: " + r2c1 + " | Page: " + pageR2C1);

        Assert.assertEquals(pageR2C2, r2c2,
                "Mismatch at Row 2 Column 2 → Sheet: " + r2c2 + " | Page: " + pageR2C2);

        Assert.assertEquals(pageR3C1, r3c1,
                "Mismatch at Row 3 Column 1 → Sheet: " + r3c1 + " | Page: " + pageR3C1);

        Assert.assertEquals(pageR3C2, r3c2,
                "Mismatch at Row 3 Column 2 → Sheet: " + r3c2 + " | Page: " + pageR3C2);


    }
}