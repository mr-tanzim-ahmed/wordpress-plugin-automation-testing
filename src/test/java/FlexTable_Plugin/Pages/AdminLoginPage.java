package FlexTable_Plugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminLoginPage extends BasePage{

    public AdminLoginPage(WebDriver driver){
        super(driver);
    }
    public AdminLoginPage enterUserNameOrEmail(String userNameOrEmail){
        clearInputText(By.cssSelector("#user_login"));
        setInput(By.cssSelector("user_login"),userNameOrEmail);
        return this;
    }
    public AdminLoginPage enterPassword(String password){
        clearInputText(By.cssSelector("#user_pass"));
        setInput(By.cssSelector("user_pass"),password);
        return this;
    }
    public AdminLoginPage checkRememberMe(){
        clickElement(By.cssSelector("#rememberme"));
        return this;
    }

    public AdminLoginPage clickPasswordVisibility(){
        clickElement(By.cssSelector(".dashicons.dashicons-visibility"));
        return this;
    }

    public DashboardPage clickLoginButton(){
        clickElement(By.cssSelector("#wp-submit"));
        return goTo(DashboardPage.class);
    }
    public LostPasswordPage clickLostPassword(){
        clickElement(By.cssSelector("#wp-submit"));
        return goTo(LostPasswordPage.class);
    }

}
