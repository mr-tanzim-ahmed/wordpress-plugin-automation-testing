package FlexTable_Plugin.TestCases;

import FlexTable_Plugin.Pages.BasePage;
import FlexTable_Plugin.Pages.Page;
import FlexTable_Plugin.Util.FlexTable_Plugin_Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    Page page;
    private final Properties properties;

    public BaseTest() throws FileNotFoundException {
        this.properties = new Properties();
        //Taking input from config.properties
        String propertiesFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
        try{
            FileInputStream inputStream = new FileInputStream(propertiesFilePath);
            properties.load(inputStream);
        }
        catch (Exception e){
            System.out.println("File not found: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
    @BeforeClass
    public void browserSetup(){
        String browserName = properties.getProperty("browser").toLowerCase();
        if(browserName=="firefox"){
            driver = new FirefoxDriver();
        } else if(browserName=="chrome") {
            driver= new ChromeDriver();
        } else{
            try {
                throw new IllegalAccessException("Browser Not Supported! "+browserName);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("loginPageURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FlexTable_Plugin_Util.WAIT_TIME));
        page = new BasePage(driver);
    }

    public static void main(String[] args) {
        System.out.println("hi");
    }

}
