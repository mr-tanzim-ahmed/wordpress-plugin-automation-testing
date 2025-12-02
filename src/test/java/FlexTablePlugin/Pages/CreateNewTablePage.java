package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewTablePage extends BasePage{
    public CreateNewTablePage(WebDriver driver) {
        super(driver);
    }
    public boolean isItCreateNewTablePage(){
       return getWebElements(By.cssSelector("#sheet-url")).size()>0;
    }
    public CreateNewTablePage inputGoogleSheetUrl(String sheetUrl){
        clearInputText(By.cssSelector("#sheet-url"));
        setInput(By.cssSelector("#sheet-url"),sheetUrl);
        return this;
    }
    public CreateNewTablePage clickCreateTableFromUrlButton(){
        clickElement(By.xpath("//button[normalize-space()='Create table from URL']"));
        return this;
    }
    //1. Data Source
    public CreateNewTablePage inputTableTitle(String tableTitle){
        setInput(By.xpath("//input[@id='table-name']"),tableTitle);
        return this;
    }
    public CreateNewTablePage inputTableDescription(String tableDescription){
        setInput(By.xpath("//textarea[@id='table-description']"),tableDescription);
        return this;
    }
    public CreateNewTablePage clickSaveChangesButton(){
        clickElement(By.cssSelector(".table-action__save"));
        return this;
    }
    public CreateNewTablePage clickNextButton(){
        clickElement(By.cssSelector("button[class='table-action__next'] span[class='text']"));
        return this;
    }
    //Fetch Table successfully
    public boolean isTableCreatedSuccessfully(){
        return getWebElements(By.cssSelector("#create_tables_wrapper")).size()>0;
    }
    //Return Dashboard (select left sides FlexTable menu)
    public FlexTableDashboard clickFlexTableDashboardButton(){
        clickElement(By.xpath("//div[normalize-space()='FlexTable']"));
        return goTo(FlexTableDashboard.class);
    }
}
