package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.BasePage;
import FlexTablePlugin.Pages.Page;
import FlexTablePlugin.Util.FlexTablePluginUtil;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    Page page;
    protected final Properties properties;

    public BaseTest() {
        properties = new Properties();
        //user.dir -->> project home directory
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void browserSetup() {
        String browserName = properties.getProperty("browser");
        switch (browserName.toLowerCase()) {

            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser! " + browserName);
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("baseURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FlexTablePluginUtil.WAIT_TIME));

        page = new BasePage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public String getUserNameOrEmail() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}