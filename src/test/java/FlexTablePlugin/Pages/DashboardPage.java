package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver) {

        super(driver);
    }
    //plugin icon xpath:  //div[@class='wp-menu-image dashicons-before dashicons-admin-plugins']
    InstalledPluginsPage clickPluginPage(){
        clickElement(By.xpath("//div[normalize-space()='Plugins']"));
        return goTo(InstalledPluginsPage.class);
    }
    public boolean isItDashboardPage(){
        return getWebElements(By.cssSelector("#adminmenuwrap")).size() > 0;
    }
    public boolean isPluginMenuPresent() {
        return getWebElements(By.xpath("//div[normalize-space()='Plugins']")).size() > 0;
    }

}
