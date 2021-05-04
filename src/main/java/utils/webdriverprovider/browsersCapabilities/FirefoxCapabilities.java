package utils.webdriverprovider.browsersCapabilities;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.helpers.PropertiesHandler;

public class FirefoxCapabilities {

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if(PropertiesHandler.getProperty("headless").equals("true"))
            firefoxOptions.addArguments("-headless", "-safe-mode");

        firefoxOptions.setProfile(firefoxProfile);

        return firefoxOptions;
    }
}
