package utils.webdriverprovider;

import org.openqa.selenium.UnhandledAlertException;

public class SeleniumExecutor extends DriverFactory {

    public SeleniumExecutor(){
        super();
    }

    private static void startExecutor(){
        if (executor == null) {
            executor = new SeleniumExecutor();
        }
    }
    public static DriverFactory getExecutor(){
        startExecutor();
        return executor;
    }
    public static void stop() {
        if (getDriver() != null) {
            getDriver().close();
            getDriver().quit();
        }
        executor = null;
    }
    public static void openPage(String url) {
        try {
            getDriver().navigate().to(url);
        } catch (UnhandledAlertException e) {
            getDriver().switchTo().alert().accept();
            getDriver().navigate().to(url);
        }
    }
    public static String getTitle() {
        return getDriver().getTitle();
    }

    public static String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteCookies() {
        try {
            driver.manage().deleteAllCookies();
            pause(SHORT_TIME_FOR_THREAD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
