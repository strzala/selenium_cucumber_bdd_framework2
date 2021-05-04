package utils.webdriverprovider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.Getter;

import static utils.webdriverprovider.browsersCapabilities.ChromeCapabilities.getChromeCapabilities;
import static utils.webdriverprovider.browsersCapabilities.FirefoxCapabilities.getFirefoxOptions;

public class DriverFactory {

    private static WebDriverWait waitDriver;
    protected static DriverFactory executor;

    public final static int PAGE_LOAD_TIMEOUT = 100;
    public final static int SHORT_TIME_FOR_THREAD = 1000;
    public final static int TIMEOUT = 60;
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser){
        System.out.println("Initiaized browser: " + browser);

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver(getChromeCapabilities()));

        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver(getFirefoxOptions()));
        }
        else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else if(browser.equals("safari")){
            tlDriver.set(new SafariDriver());
        }
        else{
            System.out.println("Browser not supported - " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }
    public static WebDriver getDriver(){
        return tlDriver.get();
    }

/*    public static WebDriver getRemoteWebDriver() throws Exception {

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.firefox());

        return driver;

    }*/


}
