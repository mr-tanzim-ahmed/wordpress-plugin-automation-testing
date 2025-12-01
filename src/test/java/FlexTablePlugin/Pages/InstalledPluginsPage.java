package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import FlexTablePlugin.Pages.*;

public class InstalledPluginsPage extends BasePage{

    public InstalledPluginsPage(WebDriver driver) {

        super(driver);
    }
    public boolean isItPluginPage(){
        String title = getElementsText(By.xpath("//h1[normalize-space()='Plugins']"));
        if(title.equals("Plugins")){
            return true;
        }
        return false;
    }
    public WpPluginDirectoryPage clickAddPlugin(){
        waitForElementToBeVisible(By.cssSelector(".page-title-action"));
        clickElement(By.cssSelector(".page-title-action"));
        return goTo(WpPluginDirectoryPage.class);
    }

    public void activatePlugin(){
        clickElement(By.xpath("//a[@id='activate-sheets-to-wp-table-live-sync']"));
        setLoadingTime(1);
    }


    public boolean isPluginInstalled(){
        String pluginName = getElementsText(By.xpath("//td[@class='plugin-title column-primary']//strong[contains(text(),'FlexTable')]")).trim();
        if(pluginName.equals("FlexTable")){
            return true;
        }
        return false;
    }
    public boolean isPluginActive(){
        String deactivateText = getElementsText(By.xpath("//a[@id='deactivate-sheets-to-wp-table-live-sync']")).trim();
        if(deactivateText.equals("Deactivate")){
            return true;
        }
        return false;
    }




}
