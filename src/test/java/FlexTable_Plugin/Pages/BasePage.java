package FlexTable_Plugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement element = null;
        try {
            element = driver.findElement(selector);
        } catch (Exception e) {
            System.out.println("Element not found: " + selector);
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(selector);
        } catch (Exception e) {
            System.out.println("Elements not found: " + selector);
        }
        return elements;
    }

    @Override
    public void clickElement(By selector) {
        waitForElementToBeVisible(selector);
        getWebElement(selector).click();
    }

    @Override
    public void setInput(By selector, String text) {
        waitForElementToBeVisible(selector);
        getWebElement(selector).sendKeys(text);
    }
    @Override
    public void clearInputText(By selector){
        getWebElement(selector).clear();
    }

    @Override
    public void getElementsText(By selector) {
        getWebElement(selector).getText();
    }

    @Override
    public void selectElement(By selector) {

    }

    @Override
    public void waitForElementToBeVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOf(getWebElement(selector)));
    }
}