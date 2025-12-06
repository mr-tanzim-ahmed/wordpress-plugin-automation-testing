package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagesPage extends BasePage {

    public PagesPage(WebDriver driver) {
        super(driver);
    }

    public PagesPage clickAddPageButton() {
        clickElement(By.xpath("//a[@class='page-title-action']"));
        waitForElementToBeVisible(By.cssSelector("button[aria-label='Close']"));
        clickElement(By.cssSelector("button[aria-label='Close']"));
        return this;
    }

    public PagesPage createNewPageAndPublish(String pageTitle) {
        clickAddPageButton();
        setLoadingTime(1);

        // Click top left plus (+) button to open inserter
        clickElement(By.xpath("//button[contains(@class, 'editor-document-tools__inserter-toggle')]"));
        waitForElementToBeVisible(By.xpath("//button[contains(@class, 'editor-document-tools__inserter-toggle')]"));
        setLoadingTime(1);

        // Select Shortcode block
        clickElement(By.xpath("//button[contains(@class, 'editor-block-list-item-shortcode')]"));

        // Add page title
        setInput(By.cssSelector("h1[class*='editor-post-title__input']"), pageTitle);

        // Enter shortcode from copied data
        setInput(By.cssSelector("textarea[class*='blocks-shortcode__textarea']"),
                copyPasteData.get(0).trim());

        // Click Publish button
        clickElement(By.xpath("//button[contains(@class, 'editor-post-publish-button__button')]"));
        waitForElementToBeVisible(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary is-compact']"));

        // Confirm publish
        clickElement(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary is-compact']"));
        setLoadingTime(1);

        return this;
    }

    public TestPage clickViewPageButton() {
        clickElement(By.xpath("//a[@aria-label='View Page']"));
        return goTo(TestPage.class);
    }

    public TestPage visitCreatedTestPage(String pageURL) {
        openNewTabAndVisit(pageURL);
        return goTo(TestPage.class);
    }

    public boolean isTableDisplayedInPage() {
        return getWebElements(By.xpath("//div[@id='create_tables_wrapper']")).size() > 0;
    }
}