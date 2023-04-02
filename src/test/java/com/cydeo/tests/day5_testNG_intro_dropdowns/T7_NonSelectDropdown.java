package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_NonSelectDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
       driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void nonSelectDropdownTest(){
     WebElement nonSelectDropdown= driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
     nonSelectDropdown.click();

        //4. Select Facebook from dropdown
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";

        // Test fails, because actual title is "Facebook – log in or sign up"
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    }


