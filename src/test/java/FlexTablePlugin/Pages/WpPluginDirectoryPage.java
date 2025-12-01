package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static FlexTablePlugin.TestCases.BaseTest.properties;

public class WpPluginDirectoryPage extends BasePage{
    public WpPluginDirectoryPage(WebDriver driver) {
        super(driver);
    }
    public  String pluginFileName = properties.getProperty("pluginName");

    public  WpPluginDirectoryPage searchPluginInWPDirectoryPage(){
        getWebElement(By.xpath("//input[@id='search-plugins']")).sendKeys("FlexTable");
        waitForElementToBeVisible(By.xpath("//a[contains(text(),'FlexTable – Live WP table sync with Google Sheets')]"));
        return this;
    }
    public WpPluginDirectoryPage installPluginInWPDirectoryPage(){
        searchPluginInWPDirectoryPage();
        waitForElementToBeVisible(By.xpath("//a[@aria-label='Install FlexTable – Live WP table sync with Google Sheets 3.19.1 now']"));
        clickElement(By.xpath("//a[@aria-label='Install FlexTable – Live WP table sync with Google Sheets 3.19.1 now']")); //install now button
        setLoadingTime(2);
        return this;
    }
    public InstalledPluginsPage activatePluginFromWPDirectoryPage(){
        waitForElementToBeVisible(By.xpath("//a[normalize-space()='Activate Plugin']"));
        clickElement(By.xpath("//a[normalize-space()='Activate Plugin']"));
        setLoadingTime(1);
        return goTo(InstalledPluginsPage.class);
    }
    public void searchPlugin(){
        waitForElementToBeVisible(By.cssSelector("#search-plugins"));
        setInput(By.cssSelector("#search-plugins"),pluginFileName);
        setLoadingTime(2);
    }

    public WpPluginDirectoryPage installPluginFromWPDirectoryPage(){
        waitForElementToBeVisible(By.cssSelector(".install-now"));
        clickElement(By.cssSelector(".install-now"));
        //Wait for installation to complete
        waitForElementToBeVisible(By.cssSelector("a[aria-label='Activate FlexTable']"));
        return this;
    }


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
