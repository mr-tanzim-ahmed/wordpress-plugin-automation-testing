package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidateRandomTableDataFromTestPage extends TestPage{

    public ValidateRandomTableDataFromTestPage(WebDriver driver) {
        super(driver);
    }
    private By tableRows = By.xpath("//table[@id='create_tables']//tr");

    public String getCellValue(int row, int col) {
        String xpath = "//table[@id='create_tables']//tr[" + row + "]/td[" + col + "]";
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }

    public boolean validateCell(int row, int col, String expected) {
        String actual = getCellValue(row, col);
        return actual.equalsIgnoreCase(expected.trim());
    }

}
