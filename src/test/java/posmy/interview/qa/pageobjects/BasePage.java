package posmy.interview.qa.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private WebDriver driver;
    protected String pageTitle;
    protected static WebDriverWait shortWait;
    protected static WebDriverWait mediumWait;
    protected static WebDriverWait longWait;
    protected static WebDriverWait superLongWait;
    private static java.util.logging.Logger log = java.util.logging.Logger.getLogger(BasePage.class.getName());

    public WebDriver getDriver() {
        return this.driver;
    }

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        this.setupWait(10, 30, 60, 300);
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public void quit() {
        this.driver.quit();
    }

    public byte[] takeScreenshot() {
        byte[] screenshot = null;

        try {
            screenshot = (byte[])((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException var3) {
            System.err.println(var3.getMessage());
        } catch (ClassCastException var4) {
            var4.printStackTrace();
        }

        return screenshot;
    }

    public void navigate(String url) {
        this.driver.get(url);
    }

    public abstract boolean isAt();

    public void clearSession() {
        this.driver.manage().deleteAllCookies();
        this.navigate(driver.getCurrentUrl());
        this.driver.manage().deleteAllCookies();
    }

    private void setupWait(int _shortWait, int _mediumWait, int _longWait, int _superLongWait) {
        shortWait = new WebDriverWait(this.driver, (long)_shortWait);
        mediumWait = new WebDriverWait(this.driver, (long)_mediumWait);
        longWait = new WebDriverWait(this.driver, (long)_longWait);
        superLongWait = new WebDriverWait(this.driver, (long)_superLongWait);
    }

    public void zaleniumLog(String message) {
        Cookie cookie = new Cookie("zaleniumMessage", message);
        this.driver.manage().addCookie(cookie);
    }
}
