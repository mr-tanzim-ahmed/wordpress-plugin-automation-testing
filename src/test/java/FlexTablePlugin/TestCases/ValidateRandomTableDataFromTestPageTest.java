package FlexTablePlugin.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import FlexTablePlugin.Pages.*;

import static FlexTablePlugin.Pages.ValidateRandomTableDataFromTestPage.tableCellData;


public class ValidateRandomTableDataFromTestPageTest extends BaseTest {
    public String targetPage = properties.getProperty("homePageURL")+properties.getProperty("testPageSlug");

    @Test
    public void matchGoogleSheetDataToTestPageTable() throws Exception {
        ValidateRandomTableDataFromTestPage validationPage = new ValidateRandomTableDataFromTestPage(driver);

        // Load CSV data
        validationPage.getDataFromRandomTableCells();

        String r2c1 = tableCellData.get("r2c1");
        String r2c2 = tableCellData.get("r2c2");
        String r3c1 = tableCellData.get("r3c1");
        String r3c2 = tableCellData.get("r3c2");
        /*
        System.out.println("===== CSV Table Cell Data =====");
        System.out.println("Row 2, Col 1 → " + r2c1);
        System.out.println("Row 2, Col 2 → " + r2c2);
        System.out.println("Row 3, Col 1 → " + r3c1);
        System.out.println("Row 3, Col 2 → " + r3c2);
        System.out.println("================================");
        */
        // Login and navigate
        page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .goTo(DashboardPage.class)
                .goTo(ValidateRandomTableDataFromTestPage.class)
                .openNewTabAndVisit(targetPage); //return Test page load in new tab


        // Read values From Test Page (Page row = csv_row -1)
        String pageR2C1 = validationPage.getCellValue(1, 1);
        String pageR2C2 = validationPage.getCellValue(1, 2);
        String pageR3C1 = validationPage.getCellValue(2, 1);
        String pageR3C2 = validationPage.getCellValue(2, 2);
/*
        System.out.println("===== Debug Table Cell Data From Page =====");
        System.out.println("Row 2, Col 1 → " + pageR2C1);
        System.out.println("Row 2, Col 2 → " + pageR2C2);
        System.out.println("Row 3, Col 1 → " + pageR3C1);
        System.out.println("Row 3, Col 2 → " + pageR3C2);
        System.out.println("============================================");
*/
        // Validate table cells
        Assert.assertEquals(pageR2C1, r2c1,
                "Match at Row 2 Column 1 → Sheet: " + r2c1 + " Page: " + pageR2C1);

        Assert.assertEquals(pageR2C2, r2c2,
                "Match at Row 2 Column 2 → Sheet: " + r2c2 + " Page: " + pageR2C2);

        Assert.assertEquals(pageR3C1, r3c1,
                "Match at Row 3 Column 1 → Sheet: " + r3c1 + " Page: " + pageR3C1);

        Assert.assertEquals(pageR3C2, r3c2,
                "Match at Row 3 Column 2 → Sheet: " + r3c2 + " Page: " + pageR3C2);
    }
}