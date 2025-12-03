package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPage extends BasePage{
    public TestPage(WebDriver driver) {
        super(driver);
    }
    public boolean isTableDisplayedInTestPage(){

        return getWebElements(By.xpath("//div[@id='create_tables_wrapper']")).size()>0;
    }

    public boolean isTableTitleDisplayed(String tableTitle){
        String title = getElementsText(By.xpath("//h3[@id='swptls-table-title']")).trim();
        if(title.equals(tableTitle)){
            return true;
        }
        return false;
    }
    public boolean isTableDescriptionDisplayed(String tableDescription){
        return getWebElements(By.xpath("//p[@id='swptls-table-description']")).size() > 0;
    }
    public String getCellValue(int row, int col) {
        String xpath = "//table[@id='create_tables']//tr[" + row + "]/td[" + col + "]";
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }

    public boolean validateCell(int row, int col, String expected) {
        return getCellValue(row, col).equalsIgnoreCase(expected.trim());
    }

    public boolean isShowEntryInfoDisplayed(){
        setLoadingTime(1);
        return getWebElements(By.cssSelector("#create_tables_info")).size()>0;
    }

    public boolean isPaginationDisplayed(){
        return getWebElements(By.xpath("//div[@id='create_tables_paginate']")).size()>0;
    }
    public boolean isPaginationWorking(){
        clickElement(By.xpath("//a[@id='create_tables_next']"));
        String currentPage = getElementsText(By.cssSelector(".paginate_button.item.active")).trim();
        if(currentPage.equals("2")){
            return true;
        }
        return false;
    }
    public String deletedTableEmptyMessageCheck(){
        return getElementsText(By.xpath("//b[contains(text(),'Table maybe deleted or can’t be loaded.')]")).trim();
    }

}



