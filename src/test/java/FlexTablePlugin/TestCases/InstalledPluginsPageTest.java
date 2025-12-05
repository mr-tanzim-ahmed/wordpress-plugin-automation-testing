package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;

import FlexTablePlugin.Pages.*;
import config.EnvManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstalledPluginsPageTest extends BaseTest {
    @Test(priority = 1)
    public void checkInstalledPluginsPage() {
        DashboardPage installedPluginsPage = page.goTo(AdminLoginPage.class)
                .doLogin(EnvManager.userName(), getPassword());

        InstalledPluginsPage pluginPage = page.goTo(DashboardPage.class)
                .clickPluginsInDashboard();

        Assert.assertTrue(pluginPage.isItPluginPage());
    }

    //Install FlexTable plugin regular way

    @Test(priority = 2)
    //Validation of plugin is active
    public void validateFlexTablePluginIsActive() {
        InstalledPluginsPage installedPluginsPage = page.goTo(InstalledPluginsPage.class);

        if (!installedPluginsPage.isPluginInstalled()) {
            installedPluginsPage.activatePlugin();
        }
        if (!installedPluginsPage.isPluginActive()) {
            installedPluginsPage.activatePlugin();
        }
        Assert.assertTrue(installedPluginsPage.isPluginActive(),"Check is plugin is active");
    }

    //Install FlexTable plugin via upload plugin zip file
    @Test(priority = 3)
    public void validateFlexTablePluginIsActiveViaUpload() {

        InstalledPluginsPage installedPlugins = page.goTo(InstalledPluginsPage.class);

        if (!installedPlugins.isPluginInstalled()) {

            WpPluginDirectoryPage pluginDirectory = installedPlugins.clickAddPlugin();
            pluginDirectory.installPluginViaUpload();

            installedPlugins = page.goTo(InstalledPluginsPage.class);
        }
        // Step 3: Activate if not active
        if (!installedPlugins.isPluginActive()) {
            installedPlugins.activatePlugin();
        }
        Assert.assertTrue(installedPlugins.isPluginActive(), "Plugin should be active after upload.");
    }

}
