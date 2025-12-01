package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;
import FlexTablePlugin.Pages.DashboardPage;
import FlexTablePlugin.Pages.InstalledPluginsPage;
import FlexTablePlugin.Pages.WpPluginDirectoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstalledPluginsPageTest extends BaseTest {
    @Test(priority = 1)
    public void checkInstalledPluginsPage() {
        InstalledPluginsPage pluginPage = page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword())
                .clickPluginsInDashboard();

                //.goTo(InstalledPluginsPage.class);
        Assert.assertTrue(pluginPage.isItPluginPage());
    }


    @Test(priority = 2)
    //Install FlexTable plugin regular way and Validation of plugin is active
    public void validateFlexTablePluginIsActive() {
        InstalledPluginsPage pluginPage = page.goTo(InstalledPluginsPage.class);

        if (!pluginPage.isPluginInstalled()) {
            pluginPage.installPlugin();
        }
        if (!pluginPage.isPluginActive()) {
            pluginPage.activatePlugin();
        }
        Assert.assertTrue(pluginPage.isPluginActive());
    }

    //Install FlexTable plugin via upload plugin zip file
    @Test(priority = 3)
    public void validateFlexTablePluginIsActiveViaUpload() {
        WpPluginDirectoryPage pluginPage = page.goTo(InstalledPluginsPage.class)
                        .clickAddPlugin();


        if (!pluginPage.isPluginInstalled()) {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/"
                    + properties.getProperty("pluginName");

            pluginPage.uploadPlugin(filePath);

        }
        InstalledPluginsPage pluginPage = page.goTo(InstalledPluginsPage.class)
        if (!pluginPage.isPluginActive()) {
            pluginPage.activatePlugin();
        }
    }
}
