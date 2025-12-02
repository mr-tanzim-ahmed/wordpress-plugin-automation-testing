package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver) {

        super(driver);
    }
    //plugin icon xpath:  //div[@class='wp-menu-image dashicons-before dashicons-admin-plugins']
    public  InstalledPluginsPage clickPluginsInDashboard(){
        clickElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-plugins']"));
        return goTo(InstalledPluginsPage.class);
    }
    public boolean isItDashboardPage(){
        return getWebElements(By.cssSelector("#adminmenuwrap")).size() > 0;
    }
    public boolean isPluginMenuPresent() {
        return getWebElements(By.xpath("//div[normalize-space()='Plugins']")).size() > 0;
    }
    public FlexTableDashboard clickFlexTableFromMenu() {
        clickElement(By.xpath("//div[normalize-space()='FlexTable']"));
        return goTo(FlexTableDashboard.class);
    }
    public PagesPage clickPagesFromMenu() {
        clickElement(By.xpath("//a[@class='wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-page']"));
        return goTo(PagesPage.class);
    }

}
