package FlexTablePlugin.TestCases;
import FlexTablePlugin.TestCases.*;
import FlexTablePlugin.Pages.*;
import org.testng.annotations.Test;

import static FlexTablePlugin.Pages.BasePage.copyPasteData;

public class Draft extends BaseTest{
    public static void main(String[] args) {

    }
    @Test
    public void loginShouldSucceed(){
        copyPasteData.add(getUserNameOrEmail());
        AdminLoginPage dashboardPage = page.goTo(AdminLoginPage.class)
                .enterUserNameOrEmail(copyPasteData.get(0))
        .enterPassword(copyPasteData.get(0));
        copyPasteData.clear();
        System.out.println(copyPasteData);

    }
}
