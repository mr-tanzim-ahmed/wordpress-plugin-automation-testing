package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import FlexTablePlugin.Pages.*;

public class FlexTableDashboard extends BasePage{
    public FlexTableDashboard(WebDriver driver) {
        super(driver);
    }
    public boolean isItFlexTableDashboardPage(){
        String title = getElementsText(By.cssSelector(".header-title")).trim();
        if(title.equals("All Tables")){
            return true;
        }
        return false;
    }


}
