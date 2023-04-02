package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {
    public static String returnOrderDate(WebDriver driver, String customerName){
       String locator= "//td[.='"+ customerName+"']/following-sibling::td[3]";

        WebElement customerDateCell= driver.findElement(By.xpath(locator));

        return customerDateCell.getText();
    }
    /*
    public static String returnOrderDate2(WebDriver driver, String costumerName){


        return driver.findElement(By.xpath("//td[.='"+ costumerName+"']/following-sibling::td[3]")).getText();

    }

     */

    public static void oderVerify(WebDriver driver, String customerName, String expectedOrderDate){
        String locator= "//td[.='"+ customerName+"']/following-sibling::td[3]";

        WebElement customerDateCell= driver.findElement(By.xpath(locator));

        String actualOrderDate= customerDateCell.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }

    public static void getTableGetEmail(WebDriver driver, String tableNum, String firstName){
       String locator="//table[@id='"+tableNum+"']//td[.='"+firstName+"']/following-sibling::td[1]";
       WebElement customerEMail = driver.findElement(By.xpath(locator));
       String actualCustomerEMail= customerEMail.getText();
        System.out.println("actualCustomerEMail = " + actualCustomerEMail);
    }
}
