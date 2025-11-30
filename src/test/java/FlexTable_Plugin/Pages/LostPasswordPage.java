package FlexTable_Plugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LostPasswordPage extends BasePage{
    public LostPasswordPage(WebDriver driver) {
        super(driver);
    }
    public LostPasswordPage enterUserNameOrEmail(String userNameOrEmail){
        clearInputText(By.cssSelector("#user_login"));
        setInput(By.cssSelector("user_login"),userNameOrEmail);
        return this;
    }
    public LostPasswordPage clickGetNewPasswordButton(String pw){
        clearInputText(By.cssSelector("#wp-submit"));
        clickElement(By.cssSelector("#wp-submit"));
        return this;
    }

    public AdminLoginPage clickLogin(){
        clickElement(By.cssSelector(".wp-login-log-in"));
        return goTo(AdminLoginPage.class);
    }
}
