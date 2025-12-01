package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstalledPluginsPage extends BasePage{

    public InstalledPluginsPage(WebDriver driver) {

        super(driver);
    }
    public boolean isItPluginPage(){
        String title = getElementsText(By.cssSelector(".wp-heading-inline"));
        if(title.equals("Plugins")){
            return true;
        }
        return false;
    }
    public void clickAddPlugin(){
        waitForElementToBeVisible(By.cssSelector(".page-title-action"));
        clickElement(By.cssSelector(".page-title-action"));
    }
    public void searchPlugin(String pluginName){
        waitForElementToBeVisible(By.cssSelector("#search-plugins"));
        setInput(By.cssSelector("#search-plugins"),pluginName);
        setLoadingTime(2);
    }
    public void installPlugin(){
        waitForElementToBeVisible(By.cssSelector(".install-now"));
        clickElement(By.cssSelector(".install-now"));
        //Wait for installation to complete
        waitForElementToBeVisible(By.cssSelector("a[aria-label='Activate FlexTable']"));

    }
    public void activatePlugin(){
        clickElement(By.cssSelector("a[aria-label='Activate FlexTable']"));
        setLoadingTime(1);
    }

    public boolean isPluginInstalled(){
        clickAddPlugin();
        String pluginName = getElementsText(By.cssSelector("td[class='plugin-title column-primary'] strong")).trim();
        if(pluginName.equals("FlexTable")){
            return true;
        }
        return false;
    }
    public boolean isPluginActive(){
        String deactivateText = getElementsText(By.cssSelector("#deactivate-sheets-to-wp-table-live-sync")).trim();
        if(deactivateText.equals("Deactivate")){
            return true;
        }
        return false;
    }
    public void uploadPlugin(String filePath){
        clickAddPlugin();
        waitForElementToBeVisible(By.cssSelector("..upload"));
        clickElement(By.cssSelector(".upload"));

        //filePath="/home/acer/Downloads/depicter.4.0.4.zip";
        waitForElementToBeVisible(By.cssSelector("#pluginzip"));
        setInput(By.cssSelector("#pluginzip"),filePath);

        if(filePath.isEmpty()){
            System.out.println("Plugin file not upload.");
        }
        else {
            clickElement(By.cssSelector("#install-plugin-submit"));
            //Wait for installation to complete
            waitForElementToBeVisible(By.cssSelector("a[aria-label='Activate FlexTable']"));
            setLoadingTime(2);
        }
    }



}
