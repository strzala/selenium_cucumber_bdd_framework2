package utils.webdriverprovider.browsersCapabilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.helpers.PropertiesHandler;

import java.util.HashMap;

public class ChromeCapabilities {

    public static DesiredCapabilities getChromeCapabilities() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        if(PropertiesHandler.getProperty("headless").equals("true"))
            options.setHeadless(true);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }
}
