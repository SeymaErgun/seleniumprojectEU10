package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {
    public static void loginToSmartBear(WebDriver driver){



        //3. Enter username: “Tester”
        WebElement username= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement password=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        //5. Click to Login button
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginBtn.click();
        //6. Print out count of all the links on landing page
        //7. Print out each link text on this page
    }

}
