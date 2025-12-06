package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.*;
import config.EnvManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WpPluginDirectoryPageTest extends BaseTest{

    @Test(priority = 2)
    public void activePluginShouldBeSuccessfulFromWpDirectoryPages(){
        page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), EnvManager.password())
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
