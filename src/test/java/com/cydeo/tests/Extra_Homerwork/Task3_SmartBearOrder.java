package com.cydeo.tests.Extra_Homerwork;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3_SmartBearOrder {

    @Test
    public void verify(){

    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    //3.Username
        WebElement name= Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        name.sendKeys("Tester");
        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement logIn=Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logIn.click();
        Driver.getDriver().findElement(By.xpath("//a[.='View all orders']")).click();

        WebElement orderVerify=Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedResult= "01/05/2010";
        String actualResult=orderVerify.getText();

        Assert.assertEquals(actualResult, expectedResult);
 }
}