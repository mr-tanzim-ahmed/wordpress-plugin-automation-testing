package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import FlexTablePlugin.Pages.*;
import java.io.File;
import static FlexTablePlugin.TestCases.BaseTest.properties;

public class WpPluginDirectoryPage extends BasePage{
    public WpPluginDirectoryPage(WebDriver driver) {
        super(driver);
    }
    public  String pluginFileName = properties.getProperty("pluginName");



    public WpPluginDirectoryPage searchPlugin(){
        waitForElementToBeVisible(By.xpath("//input[@id='search-plugins']"));
        setInput(By.xpath("//input[@id='search-plugins']"),"FlexTable");
        waitForElementToBeVisible(By.xpath("//a[@aria-label='Install FlexTable – Live WP table sync with Google Sheets 3.19.1 now']"));
        return this;
    }

    public WpPluginDirectoryPage installPluginFromWPDirectoryPage(){
        waitForElementToBeVisible(By.cssSelector(".install-now"));
        clickElement(By.cssSelector(".install-now"));
        //Wait for installation to complete
        waitForElementToBeVisible(By.cssSelector("a[aria-label='Activate FlexTable']"));
        return this;
    }

/*
    public WpPluginDirectoryPage activatePluginFromWPDirectoryPage(){
        waitForElementToBeVisible(By.xpath("//a[normalize-space()='Activate Plugin']"));
        clickElement(By.xpath("//a[normalize-space()='Activate Plugin']"));
        setLoadingTime(1);
        return this;
    }
*/
    public InstalledPluginsPage clickPluginsInLeftMenu(){
        clickElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-plugins']"));
        return goTo(InstalledPluginsPage.class);
    }
    //
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
