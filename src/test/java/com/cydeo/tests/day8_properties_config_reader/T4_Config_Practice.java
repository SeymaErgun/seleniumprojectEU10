package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {
    /*
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //We are getting the browserType dynamically from our configuration.properties file
        String browserType= ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();

    }
*/
    @Test
    public void google_search_test(){
        //Driver.getDriver()----->driver

        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();
        //3- Write “apple” in search box
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);
        //4- Verify title:
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Google'da Ara";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        //Expected: apple - Google Search


    }

}