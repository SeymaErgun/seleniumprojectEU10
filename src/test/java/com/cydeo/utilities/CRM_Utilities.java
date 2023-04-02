package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    //This method will login with helpdesk1@cybertekschool.com user when it is called
    public static void crm_login(WebDriver driver){
        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@type='text']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");
        //4. Enter valid password
        WebElement inputPassword= driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement LoginButton= driver.findElement(By.xpath("//input[@type='submit']"));
        LoginButton.click();




    }
    public static void crm_login(WebDriver driver, String username, String password){
        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@type='text']"));
        inputUsername.sendKeys(username);
        //4. Enter valid password
        WebElement inputPassword= driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys(password);
        //5. Click to `Log In` button
        WebElement LoginButton= driver.findElement(By.xpath("//input[@type='submit']"));
        LoginButton.click();

    }





}
