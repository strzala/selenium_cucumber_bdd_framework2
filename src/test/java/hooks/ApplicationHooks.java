package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.helpers.PropertiesHandler;
import utils.webdriverprovider.DriverFactory;

import java.net.URL;
import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private PropertiesHandler propertiesHandler;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        propertiesHandler = new PropertiesHandler();
        propertiesHandler.init();
        prop = propertiesHandler.init();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.close();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
/*        if(scenario.isFailed()){
           String screenShotName = scenario.getName().replaceAll(" ", "_");
           byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(sourcePath, "image/png", screenShotName);
        }*/
    }

}
