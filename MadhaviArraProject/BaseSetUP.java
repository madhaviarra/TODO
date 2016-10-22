// Created by Madhavi Arra
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;//firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Collectors;

public class BaseSetUP {


    protected WebDriver driver;
    protected final static String url = "http://localhost/index.php";



    @BeforeClass
    public void prepareBrowser() throws MalformedURLException {

        driver = DriverUtils.getBrowserOnEnv();
    }

    @BeforeMethod
    public void goToApp() {

        driver.get(url);
        WebElement heading = driver.findElement(By.tagName("b"));
        Assert.assertEquals("NSS-TODO List v 1.1", heading.getText());
    }


    @AfterClass
    public void browserClose() {

        //close the browser
        driver.quit();
    }


}