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

    public void copyTableShortcode(){
        copyPasteData.add(getElementsText(By.cssSelector("button[class*='copy-shortcode btn-shortcode']")).trim());
    }

}
