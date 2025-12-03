package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPage extends BasePage{
    public TestPage(WebDriver driver) {
        super(driver);
    }
    public boolean isTableDisplayedInTestPage(){

        return getWebElements(By.xpath("//div[@id='create_tables_wrapper']")).size()>0;
    }

}
