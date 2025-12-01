package FlexTablePlugin.TestCases;

import FlexTablePlugin.Pages.InstalledPluginsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstalledPluginsPageTest extends BaseTest {
    @Test
    public void validateFlexTablePluginIsActive(){
        InstalledPluginsPage pluginPage = page.goTo(InstalledPluginsPage.class);
        Assert.assertTrue(pluginPage.isItPluginPage());

        pluginPage.searchPlugin("FlexTable");

        if(!pluginPage.isPluginInstalled()){
            pluginPage.installPlugin();
        }

        if(!pluginPage.isPluginActive()){
            pluginPage.activatePlugin();
        }
        Assert.assertTrue(pluginPage.isPluginActive());
    }

}
