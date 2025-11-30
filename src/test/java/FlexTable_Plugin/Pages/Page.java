package FlexTable_Plugin.Pages;

import FlexTable_Plugin.Util.FlexTable_Plugin_Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public class Page {
    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FlexTable_Plugin_Util.WAIT_Time));

    }

    public abstract WebElement getWebElement(By selector);

    public abstract List<WebElement> getWebElements(By selector);

    public abstract void clickElement(By selector);

    public abstract void setInput(By selector, String text);

    public abstract void getElementsText(By selector);

    public abstract void selectElement(By selector);

    public abstract void clearInputText(By selector);

    public abstract void waitForElementToBeVisible(By selector);
    //Returns an obj of any class that is extended by BasePage
    public <T extends BasePage>T goTo(Class<T> pageClass){
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
