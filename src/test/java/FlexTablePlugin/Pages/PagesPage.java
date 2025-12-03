package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagesPage extends BasePage{
    public PagesPage(WebDriver driver) {
        super(driver);
    }

    public PagesPage clickAddPageButton(){
        clickElement(By.xpath("//a[@class='page-title-action']"));
        waitForElementToBeVisible(By.cssSelector("button[aria-label='Close']"));
        clickElement(By.cssSelector("button[aria-label='Close']"));
        return this;
    }

    public PagesPage createNewPageAndPublish(String pageTitle){
        clickAddPageButton();
        setLoadingTime(1);
        //Click top left plus(+) button
        clickElement(By.xpath("//button[contains(@class, 'editor-document-tools__inserter-toggle')]"));
        waitForElementToBeVisible(By.xpath("//button[contains(@class, 'editor-document-tools__inserter-toggle')]"));
        setLoadingTime(1);
        //Select Shortcode element
        clickElement(By.xpath("//button[contains(@class, 'editor-block-list-item-shortcode')]"));
        //Add Page Title
        setInput(By.cssSelector("h1[class*='wp-block wp-block-post-title block-editor-block-list__block editor-post-title editor-post-title__input rich-text']"),pageTitle);
        //Enter Shortcode
        setInput(By.cssSelector("textarea[class*='block-editor-plain-text'][class*='blocks-shortcode__textarea']"),copyPasteData.get(0).trim());
        //Click Publish button
        clickElement(By.xpath("//button[contains(@class, 'editor-post-publish-button__button')]"));
        waitForElementToBeVisible(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary is-compact']"));

        //Confirm Publish button
        clickElement(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary is-compact']"));
        setLoadingTime(1);
        return this;
    }

    //Click View Page button
    public TestPage clickViewPageButton(){
        //Top of the right corner, before laptop, tablet icon, save buttons before
        clickElement(By.xpath("//a[@aria-label='View Page']"));
        return goTo(TestPage.class);
    }
    public TestPage visitCreatedTestPage(String pageURL){
        openNewTabAndVisit(pageURL);
        return goTo(TestPage.class);
    }
    public boolean isTableDisplayedInPage(){
        return getWebElements(By.xpath("//div[@id='create_tables_wrapper']")).size()>0;
    }

}
