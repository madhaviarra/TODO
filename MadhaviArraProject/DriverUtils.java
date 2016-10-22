/**
 * Created by Madhavi Arra on 10/19/16.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverUtils {


    public static String browser = System.getProperty("browserName", "chrome");
    public static String hubUrl = System.getProperty("hubUrl");
    protected WebDriver driver;


    public static WebDriver getBrowser(String browserName) throws MalformedURLException {


            return createLocalBrowser(browserName);

    }


    public static WebDriver getBrowserOnEnv() throws MalformedURLException {

        return getBrowser(DriverUtils.browser);

    }

    // to create local driver

    public static  WebDriver createLocalBrowser(String browserName) {

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/madhaviarra/Documents/chromedriver");
            driver = new ChromeDriver();
        }

        return driver;
    }



}