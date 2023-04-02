package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_Web_Table_Homework {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TC #1: Web table practice
        // 1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/tables");
    }

    @Test
    public void test4() {
        WebTableUtils.getTableGetEmail(driver, "table1", "Frank");
    }
}