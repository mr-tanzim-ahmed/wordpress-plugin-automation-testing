package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WpPluginDirectoryPageTest extends BaseTest{

    @Test(priority = 1)
    public void activePluginShouldBeSuccessfulFromWpDirectoryPages(){
        page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .goTo(DashboardPage.class)
                .clickPluginsInDashboard()
                .clickAddPlugin()
                .searchPlugin()
                .installPluginFromWPDirectoryPage()
                .clickPluginsInLeftMenu()
                .goTo(InstalledPluginsPage.class);
        InstalledPluginsPage pluginPage = Page
                .goTo(InstalledPluginsPage.class)
                        .activatePlugin();

        Assert.assertTrue(pluginPage.isPluginActivatedFromInstalledPluginsPage(),"Plugin activated successfully from WP Plugin Directory Page");
        
    }
}
