package com.cydeo.tests.Extra_Homerwork;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task4_FindElement {
    @Test
    public void checkingNumber() {

//TC #1: Checking the number of links on the page
//1. Open Chrome browser
//2. Go to https://www.openxcell.com
        Driver.getDriver().get("https://www.openxcell.com");

// Count the number of the links on the page and verify
//Expected: 332
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("number of the links = " + links.size());

        int expectedOrder = 355;

        Assert.assertEquals(links.size(), expectedOrder);
    }

    @Test
    public void Test3(){

            //TC #3: Counting the number of links that does not have text
            //1. Open Chrome browser
            //2. Go to https://www.openxcell.com
            //3. Count the number of links that does not have text and verify
            //Expected: 109
            Driver.getDriver().get("https://www.openxcell.com ");
            List<WebElement> links = Driver.getDriver().findElements(By.xpath("//a"));

            int countOrder = 0;
            for (WebElement link : links) {
                if (link.getText().isEmpty()){
                    countOrder++;

                }

            }
        System.out.println(countOrder);

        }
    }


/*
   //TC #2: Printing out the texts of the links on the page
        for (WebElement link : links) {
                System.out.println("link.getText() = " + link.getText());
                }

*/




