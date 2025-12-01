package FlexTablePlugin.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Draft {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties")) {
            properties.load(in);
        } catch (IOException e) {
            System.err.println("Unable to load properties: " + e.getMessage());
            return;
        }

        String browser = properties.getProperty("browser", "chrome");
        WebDriver driver = null;
        try {
            if ("firefox".equalsIgnoreCase(browser)) {
                driver = new FirefoxDriver();
            } else {
                driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            driver.get(properties.getProperty("loginPageURL"));

            driver.findElement(By.id("user_login")).sendKeys(properties.getProperty("userName"));
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }


}
