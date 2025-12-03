package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        clickElement(By.cssSelector(".btn.btn-lg"));
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
        // Get the last 2 digits from the button's href safely
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

    public String getTableId(){
        String text = getElementsText(By.xpath("//p[@class='swptls-title p']"));
        System.out.println("Table ID: " + text);
        String id = "";
        if (text.length() >= 2) {
            id = text.substring(text.length() - 2);
            return id;
        }
        return id;
    }


    public FlexTableDashboard clickDeleteTable(){
        clickElement(By.xpath("//button[@class='table-delete']"));
        return this;
    }

    public PagesPage clickPagesFromMenu(){
        clickElement(By.xpath("//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-page']"));
        return goTo(PagesPage.class);
    }

}
