package testbase;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigsReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    /**
     * This method will open a browser, setup browser window, and go to URL
     */

    public static void setUp() {

        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.retrieveValue("browser").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser is not available");
        }

        driver.get(ConfigsReader.retrieveValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        PageInitializer.initializePageObjects();
    }


    /**
     * This method will navigate to a website by the given URL
     *
     * @param url
     */


    /**
     * This method will close any open browser
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
