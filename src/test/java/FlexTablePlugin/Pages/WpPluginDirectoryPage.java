package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WpPluginDirectoryPage extends BasePage{
    public WpPluginDirectoryPage(WebDriver driver) {
        super(driver);
    }
    public void searchPlugin(String pluginName){
        waitForElementToBeVisible(By.cssSelector("#search-plugins"));
        setInput(By.cssSelector("#search-plugins"),pluginName);
        setLoadingTime(2);
    }
    public void installPluginInWPDirectoryPage(){
        waitForElementToBeVisible(By.cssSelector(".install-now"));
        clickElement(By.cssSelector(".install-now"));
        //Wait for installation to complete
        waitForElementToBeVisible(By.cssSelector("a[aria-label='Activate FlexTable']"));
    }

    public void uploadPlugin(String filePath){
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
