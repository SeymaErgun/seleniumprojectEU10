package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TC #1: Web table practice
        // 1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

    }
    @Test
    public void order_name_verify_test(){

        //Locate the cell that has  Bob's Martin text in it
        WebElement bobMartinCell= driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());
        //2. Verify Bob’s name is listed as expected.
        String expectedBobName= "Bob Martin";
        String actualBobName=bobMartinCell.getText();

        Assert.assertEquals(actualBobName, expectedBobName);


        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        WebElement bobMartinDateCell= driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        System.out.println("bobMartinDateCell.getText() = " + bobMartinDateCell.getText());

        String expectedBobDate= "12/31/2021";
        String actualBobDate= bobMartinDateCell.getText();

        Assert.assertEquals(actualBobDate, expectedBobDate);

    }

    @Test
    public void test2(){
    String costumerOrderData1=WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("costumerOrderData1 = " + costumerOrderData1);
    }

  @Test
  public void test3(){

        WebTableUtils.oderVerify(driver, "Bart Fisher", "01/16/2021");
  }



}
