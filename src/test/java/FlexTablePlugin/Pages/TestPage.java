package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestPage extends BasePage{
    public TestPage(WebDriver driver) {
        super(driver);
    }
    public boolean isTableDisplayedInTestPage(){
        return getWebElements(By.xpath("//div[@id='create_tables_wrapper']")).size()>0;
    }

    public boolean isTableTitleDisplayed(String actualTableTitle){
        setLoadingTime(1);
        String title = getElementsText(By.cssSelector("#swptls-table-title")).trim();
        System.out.println("Expected Table Title: "+title);
        if(title.equals(actualTableTitle)){
            return true;
        }
        return false;
    }
    public boolean isTableDescriptionDisplayed(String tableDescription){
        return getWebElements(By.xpath("//p[@id='swptls-table-description']")).size() > 0;
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

    public String getCellValue(int row, int col) {
        String xpathLoc = "//table[@id='create_tables']//tr[" + row + "]/td[" + col + "]";
        return getElementsText(By.xpath(xpathLoc)).trim();
    }

    public boolean validateCell(int row, int col, String expected) {
        String actual = getCellValue(row, col);
        return actual.equalsIgnoreCase(expected.trim());
    }
    public String checkShowEntries() {
        By entriesDropdown = By.cssSelector("select[name='create_tables_length']");
        return selectElement(entriesDropdown).getFirstSelectedOption().getText().trim();
    }

    // Alternative with better error handling
    public String getSelectedEntriesPerPage() {
        try {
            By entriesDropdown = By.cssSelector("select[name='create_tables_length']");
            String selectedValue = selectElement(entriesDropdown)
                    .getFirstSelectedOption()
                    .getText()
                    .trim();
            System.out.println("Selected entries per page: " + selectedValue);
            return selectedValue;
        } catch (Exception e) {
            System.out.println("Failed to get selected entries: " + e.getMessage());
            return "";
        }
    }
    public String checkShowEntriesNumericOnly() {
        By entriesDropdown = By.cssSelector("select[name='create_tables_length']");
        String selectedText = selectElement(entriesDropdown)
                .getFirstSelectedOption()
                .getText()
                .trim();

        // Extract only numeric value
        return selectedText.replaceAll("\\D", ""); // Removes all non-digits
    }
    public String getTableHeight() {
        By selector = By.xpath("//div[@class='dataTables_scrollBody']");
        return getWebElement(selector).getCssValue("height").trim();
    }

    public boolean deletedTableEmptyMessageCheck() {
        return getWebElements(By.xpath("//b[contains(text(),'Table maybe deleted')]")).size()>0;
    }
    public DashboardPage clickAndGoDashboard(){
        setLoadingTime(1);
        clickElement(By.xpath("//body/div[@id='wpwrap']/div[@id='wpcontent']/div[@id='wpadminbar']/div[@id='wp-toolbar']/ul[@id='wp-admin-bar-root-default']/li[@id='wp-admin-bar-wp-logo']/a[1]"));
        return goTo(DashboardPage.class);
    }

}



