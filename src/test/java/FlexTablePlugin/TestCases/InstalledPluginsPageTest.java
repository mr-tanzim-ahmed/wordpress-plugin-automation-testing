package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.AdminLoginPage;

import FlexTablePlugin.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstalledPluginsPageTest extends BaseTest {
    @Test(priority = 1)
    public void checkInstalledPluginsPage() {
        page.goTo(AdminLoginPage.class)
                .doLogin(getUserNameOrEmail(), getPassword());
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
        Assert.assertTrue(installedPluginsPage.isPluginActive());
    }

    //Install FlexTable plugin via upload plugin zip file
    @Test(priority = 3)
    public void validateFlexTablePluginIsActiveViaUpload() {

        // Step 1: Go to Installed Plugins Page
        InstalledPluginsPage installedPlugins = page.goTo(InstalledPluginsPage.class);

        // Step 2: If NOT installed, upload and install
        if (!installedPlugins.isPluginInstalled()) {

            // Click "Add New"
            WpPluginDirectoryPage pluginDirectory = installedPlugins.clickAddPlugin();

            // Upload ZIP file
            pluginDirectory.installPluginViaUpload();

            // After uploading, go back to Installed Plugins
            installedPlugins = page.goTo(InstalledPluginsPage.class);
        }
        // Step 3: Activate if not active
        if (!installedPlugins.isPluginActive()) {
            installedPlugins.activatePlugin();
        }
        // Step 4: Final validation
        Assert.assertTrue(installedPlugins.isPluginActive(), "Plugin should be active after upload.");
    }

}
