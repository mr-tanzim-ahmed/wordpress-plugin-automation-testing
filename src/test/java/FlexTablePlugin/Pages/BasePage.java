package FlexTablePlugin.Pages;

import com.aventstack.extentreports.Status;
import FlexTablePlugin.Report.*;
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
            addInfo("Selenium WebDriver going to find a WebElement with " + selector + " selector");
            element = driver.findElement(selector);
            addInfo("Selenium WebDriver found a WebElement with " + selector + " selector");
        } catch (Exception e) {
            addFailInfo("Selenium WebDriver is not found a WebElement with "+selector+" selector");
            System.out.println("Element not found: " + selector);
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> elements = null;
        try {
            addInfo("Selenium WebDriver going to find a WebElements with " + selector + " selector");
            elements = driver.findElements(selector);
            addInfo("Selenium WebDriver found a WebElements with " + selector + " selector");
        } catch (Exception e) {
            addFailInfo("Selenium WebDriver is not found  WebElements with "+selector+" selector");
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
        getWebElement(selector).clear();
        waitForElementToBeVisible(selector);
        getWebElement(selector).sendKeys(text);
    }
    @Override
    public void clearInputText(By selector){
        getWebElement(selector).clear();
    }

    @Override
    public String getElementsText(By selector) {
        String text = getWebElement(selector).getText();
        return text;
    }

    @Override
    public void selectElement(By selector) {

    }
    @Override
    public String getCurrentPageURL(){

        return driver.getCurrentUrl();
    }
    public void setLoadingTime(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void waitForElementToBeVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOf(getWebElement(selector)));
    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }
    public void addFailInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.FAIL, message);
        }

    }
}