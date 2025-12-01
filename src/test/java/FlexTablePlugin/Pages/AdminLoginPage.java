package FlexTablePlugin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import FlexTablePlugin.Pages.BasePage;

public class AdminLoginPage extends BasePage{

    public AdminLoginPage(WebDriver driver){
        super(driver);
    }
    public AdminLoginPage enterUserNameOrEmail(String userNameOrEmail){
        clearInputText(By.id("user_login"));
        setInput(By.id("user_login"),userNameOrEmail);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    public AdminLoginPage enterPassword(String password){
        setInput(By.cssSelector("#user_pass"),password);

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
// @log
    public DashboardPage clickLoginButton(){
        clickElement(By.cssSelector("#wp-submit"));
        return goTo(DashboardPage.class);
    }
    public LostPasswordPage clickLostPassword(){
        clickElement(By.cssSelector("#wp-submit"));
        return goTo(LostPasswordPage.class);
    }

}
