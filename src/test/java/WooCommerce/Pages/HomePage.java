package WooCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public ProductDetailPage clickAProductForDetails(){
        clickElement(By.cssSelector("a[class='ast-loop-product__link']"));
        return goTo(ProductDetailPage.class);
    }

}



