package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task4_5 {
    @BeforeMethod
    public void openPage() {
        Driver.getDriver().get("https://practice.cydeo.com/");

    }

    @Test
    public void scrollDown() {
        WebElement scroll = Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));
        Actions action = new Actions(Driver.getDriver());
        BrowserUtils.sleep(5);
        action.moveToElement(scroll).perform();
        action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();


    }








}