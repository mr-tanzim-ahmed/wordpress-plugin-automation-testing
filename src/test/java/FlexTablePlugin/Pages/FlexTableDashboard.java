package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlexTableDashboard extends BasePage{
    public FlexTableDashboard(WebDriver driver) {
        super(driver);
    }
    public boolean isItFlexTableDashboardPage(){
        String title = getElementsText(By.cssSelector(".header-title")).trim();
        if(title.equals("All Tables")){
            return true;
        }
        return false;
    }
    public boolean isFlexTableDashboardUiDisplayed(){
        return getWebElements(By.xpath("//div[@class='swptls-container ']")).size()>0;
    }

    public CreateNewTablePage clickCreateNewTableButton(){
        waitForElementToBeClickable(By.cssSelector("button[class*='btn btn-lg']"));
        clickElement(By.cssSelector("button[class*='btn btn-lg']"));
        return goTo(CreateNewTablePage.class);
    }
    public boolean checkNewTableEntryInDashboard(){
        return getWebElements(By.xpath("//div[@class='table_info-action_box_wrapper']")).size()>0;
    }
    public String checkTableNameInDashboard(){
        String getTableName = getElementsText(By.cssSelector("a[class='table-edit'] h4[class='swptls-title h4']")).trim();
        return getTableName;
    }
    public FlexTableDashboard copyTableShortcode() {
        // Get the last 1 or 2 digits from the button's href safely
        String id = getTableId();

        // Build the shortcode using StringBuffer
        StringBuffer shortcode = new StringBuffer();
        shortcode.append("[gswpts_table id=\"")
                .append(id)
                .append("\"]");
        System.out.println("Shortcode: " + shortcode.toString());
        copyPasteData.add(shortcode.toString());

        return this;
    }

    public String getTableId() {
        String text = getElementsText(By.xpath("//p[@class='swptls-title p']"));
        System.out.println("Table Text: " + text);

        // Remove all non-digit characters
        String digitsOnly = text.replaceAll("\\D", "");

        if (digitsOnly.isEmpty()) {
            return ""; // No digits found
        }

        // Take last 2 digits if possible, else last 1 digit
        return digitsOnly.length() >= 2 ? digitsOnly.substring(digitsOnly.length() - 2)
                : digitsOnly;
    }


    public FlexTableDashboard clickEditTable(){
        clickElement(By.xpath("//div[@class='tooltip-wrapper']//a[@class='table-edit']"));
        return this;
    }
    public FlexTableDashboard clickTableCustomization(){
        clickNextButton();
        clickNextButton();
        setLoadingTime(1);
        return this;
    }
    public FlexTableDashboard clickNextButton(){
        clickElement(By.cssSelector(".table-action__next"));
        return this;
    }
    public FlexTableDashboard clickSaveChangesButton(){
        clickElement(By.cssSelector(".table-action__save"));
        setLoadingTime(1);
        return this;
    }
    //Go to Table Customization → Layout
    // Enable 'Show Table Title'
    public FlexTableDashboard clickShowTableTitle(){
        clickElement(By.xpath("//input[@id='show-title']"));
        return this;
    }
    //Go to Table Customization → Layout
    //Enable 'Show Table Description Below the Table'
    public FlexTableDashboard clickShowTableDescriptionAndSelectBelow() {
        clickElement(By.cssSelector("#show-description"));

        selectElementFromVisibleText(By.xpath("//select[@name='description_position']"), "below");

        return this;
    }
    //Go to Table Customization → Layout
    // Go to Layout → Table Bottom Elements.
    //Enable Show Entry Info
    public FlexTableDashboard clickShowEntryInfo(){
        clickElement(By.cssSelector("#hide-entry-info"));
        return this;
    }
    //Show Pagination
    public FlexTableDashboard clickShowPagination(){
        clickElement(By.cssSelector("#hide-pagination"));
        return this;
    }

    public FlexTableDashboard clickStyling(){
        clickElement(By.xpath("//div[@class='table-customization-tab-nav']//button[contains(text(),'Styling')]"));
        setLoadingTime(2);
        return this;
    }
    public FlexTableDashboard selectValuesRowsToShowPerPage(String value){
        selectElementFromVisibleText(By.cssSelector("#rows-per-page"), value);
        return this;
    }

    public FlexTableDashboard selectTableHeight(String heightValue){
        selectElementFromVisibleText(By.cssSelector("#table_height"),heightValue);
        return this;
    }

    public PagesPage clickPagesFromMenu(){
        clickElement(By.xpath("//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-page']"));
        return goTo(PagesPage.class);
    }

    public FlexTableDashboard clickDeleteTable(){
        clickElement(By.xpath("//button[@class='table-delete']"));
        clickElement(By.xpath("//button[normalize-space()='Delete']"));//popup delete
        setLoadingTime(1);
        return this;
    }

}
