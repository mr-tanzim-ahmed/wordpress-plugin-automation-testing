package FlexTablePlugin.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import FlexTablePlugin.Pages.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ValidateRandomTableDataFromTestPageTest extends TestPageTest {

    @Test
    public void matchGoogleSheetDataToTestPageTable() throws Exception {

        DashboardPage login = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword());
                driver.get(targetPage);

        // GOOGLE SHEET CSV URL
        String googleSheetCsvFile =
                "https://docs.google.com/spreadsheets/d/11qRH9xUuglOTIZa7JnWTVBYuGMT32ZhFuJ5_xypApGM/export?format=csv";

        // READ CSV FILE
        URL url = new URL(googleSheetCsvFile);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        List<String[]> rows = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            rows.add(line.split(",")); // CSV parsing
        }
        reader.close();

        String r1c1 = rows.get(1 - 1)[1 - 1];   // row 1, col 1
        String r2c2 = rows.get(2 - 1)[2 - 1];   // row 2, col 2
        String r3c3 = rows.get(3 - 1)[3 - 1];   // row 3, col 3
        String r4c2 = rows.get(4 - 1)[2 - 1];   // row 4, col 2
        /*
        System.out.println("CSV Values:");
        System.out.println("Row1 Col1: " + r1c1);
        System.out.println("Row2 Col2: " + r2c2);
        System.out.println("Row3 Col3: " + r3c3);
        System.out.println("Row4 Col2: " + r4c2);
        */

        driver.get(targetPage); // <-- replace

        TestPage page = new TestPage(driver);

        Assert.assertTrue(page.validateCell(1, 1, r1c1),
                "Match Row 1 Column 1");

        Assert.assertTrue(page.validateCell(2, 2, r2c2),
                "Match Row 2 Column 2");

        Assert.assertTrue(page.validateCell(3, 3, r3c3),
                "Match Row 3 Column 3");

        Assert.assertTrue(page.validateCell(4, 2, r4c2),
                "Match Row 4 Column 2");
    }
}
