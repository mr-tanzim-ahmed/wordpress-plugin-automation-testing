package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static FlexTablePlugin.TestCases.BaseTest.properties;

public class WpPluginDirectoryPage extends BasePage{
    public WpPluginDirectoryPage(WebDriver driver) {
        super(driver);
    }

    public void searchPlugin(String pluginName){
        waitForElementToBeVisible(By.cssSelector("#search-plugins"));
        setInput(By.cssSelector("#search-plugins"),pluginName);
        setLoadingTime(2);
    }

    public WpPluginDirectoryPage installPluginFromWPDirectoryPage(){
        waitForElementToBeVisible(By.cssSelector(".install-now"));
        clickElement(By.cssSelector(".install-now"));
        //Wait for installation to complete
        waitForElementToBeVisible(By.cssSelector("a[aria-label='Activate FlexTable']"));
        return this;
    }
    public  String pluginFileName = properties.getProperty("pluginName");

    public WpPluginDirectoryPage uploadPluginsFile(String pluginName) {


        File pluginFile = new File(System.getProperty("user.dir") + "/src/test/resources/" + pluginFileName);
        String absolutePath = pluginFile.getAbsolutePath();
        waitForElementToBeVisible(By.cssSelector("#pluginzip"));
        getWebElement(By.cssSelector("#pluginzip")).sendKeys(absolutePath);
        setLoadingTime(2);
        return this;
    }
    public WpPluginDirectoryPage installPluginViaUpload(){
        uploadPluginsFile(pluginFileName);
        clickElement(By.cssSelector("#install-plugin-submit"));
        //Wait for installation to complete
        setLoadingTime(2); //installing time
        return this;
    }


}
