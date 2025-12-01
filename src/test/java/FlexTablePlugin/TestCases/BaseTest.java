package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.BasePage;
import FlexTablePlugin.Pages.Page;
import FlexTablePlugin.Util.FlexTablePluginUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;



    public class BaseTest {
        public WebDriver driver;
        Page page;
        public static Properties properties;

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
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser! " + browserName);
            }
            driver.manage().window().maximize();
            driver.get(properties.getProperty("baseURL"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( FlexTablePluginUtil.WAIT_TIME));
            //By using BasePage , we can access "BasePage" and parent "Page" elements
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

        public WebDriver getWebDriver() {
            return driver;
        }
    }