package FlexTablePlugin.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagesPage extends BasePage{
    public PagesPage(WebDriver driver) {
        super(driver);
    }
    public PagesPage clickAddPageButton(){
        clickElement(By.xpath("//a[@class='page-title-action']"));
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return this;
    }
    public PagesPage createNewPage(){
        clickAddPageButton();
        //Click top left plus(+) button
        clickElement(By.cssSelector("button[class*='components-button components-toolbar-button editor-document-tools__inserter-toggle is-primary is-compact has-icon']"));
        waitForElementToBeVisible(By.cssSelector("button[class*='components-button components-toolbar-button editor-document-tools__inserter-toggle is-primary is-compact has-icon']"));
        //Search Shortcode element
        setInput(By.xpath("//input[@id='components-search-control-0']']"),"Shortcode");

        //Select Shortcode element
        clickElement(By.cssSelector("[class*='block-editor-block-types-list__list-item']"));
        //Add Page Title
        setInput(By.cssSelector("h1[class*='wp-block wp-block-post-title block-editor-block-list__block editor-post-title editor-post-title__input rich-text']"),"Test Page");

        //Enter Shortcode data
        setInput(By.cssSelector("textarea[class*='block-editor-plain-text'][class*='blocks-shortcode__textarea']"),copyPasteData.get(0).trim());
        //Click Publish button
        clickElement(By.cssSelector("button[class*='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary is-compact']"));
        waitForElementToBeVisible(By.cssSelector("button[class*='components-button editor-post-publish-button editor-post-publish-button__button is-primary is-compact']"));

        //Confirm Publish button
        clickElement(By.cssSelector("button[class*='components-button editor-post-publish-button editor-post-publish-button__button is-primary is-compact']"));
        setLoadingTime(1);
        return this;
    }
    public PagesPage clickViewPageButton(){
        //Top of the right corner, before laptop, tablet icon, save buttons before
        clickElement(By.xpath("//a[@aria-label='View Page']"));
        return this;
    }
    public boolean isTableDisplayedInPage(){
        return getWebElements(By.xpath("//div[@id='create_tables_wrapper']")).size()>0;
    }

}
