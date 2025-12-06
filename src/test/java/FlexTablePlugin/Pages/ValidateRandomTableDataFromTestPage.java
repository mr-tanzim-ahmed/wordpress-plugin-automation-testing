package FlexTablePlugin.Pages;

import config.EnvManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.*;

import static FlexTablePlugin.TestCases.BaseTest.properties;

public class ValidateRandomTableDataFromTestPage extends BasePage {

    public static Map<String, String> tableCellData = new HashMap<>();

    public ValidateRandomTableDataFromTestPage(WebDriver driver) {
        super(driver);
    }

    public void openNewTabAndVisit(String url) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        setLoadingTime(2);
    }

    public void getDataFromRandomTableCells() throws Exception {
        String googleSheetCsvFile = EnvManager.googleSheetUrlCSVFormat();

        if (googleSheetCsvFile == null || googleSheetCsvFile.isEmpty()) {
            throw new RuntimeException("googleSheetUrlCSVFormat is missing in properties file!");
        }

        URL url = new URL(googleSheetCsvFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        List<String[]> rows = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            rows.add(line.split(",", -1));
        }
        reader.close();

        if (rows.size() < 4) {
            throw new RuntimeException("CSV does NOT contain 4 rows. Found: " + rows.size());
        }

        // Reading from CSV: Row 2 Col 1, Row 2 Col 2, Row 3 Col 1, Row 3 Col 2
        tableCellData.put("r2c1", getCellFromCSV(rows, 2, 1));
        tableCellData.put("r2c2", getCellFromCSV(rows, 2, 2));
        tableCellData.put("r3c1", getCellFromCSV(rows, 3, 1));
        tableCellData.put("r3c2", getCellFromCSV(rows, 3, 2));
    }

    private String getCellFromCSV(List<String[]> rows, int row, int col) {
        try {
            String cellValue = rows.get(row - 1)[col - 1];
            return (cellValue == null) ? "" : cellValue.replace("\u00A0", "").trim();
        } catch (Exception e) {
            return "";
        }
    }

    public String getCellValue(int row, int col) {
        String xpath = "//table[@id='create_tables']//tr[" + row + "]//td[" + col + "]";
        String value = getElementsText(By.xpath(xpath));
        return (value == null) ? "" : value.replace("\u00A0", "").trim();
    }

    public boolean validateCell(int row, int col, String expected) {
        String actual = getCellValue(row, col);
        String exp = (expected == null) ? "" : expected.replace("\u00A0", "").trim();
        return actual.equalsIgnoreCase(exp);
    }
}