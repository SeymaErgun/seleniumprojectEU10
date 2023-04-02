package com.cydeo.tests.day6_alerts_iframes_window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_T2_T3_Alert_Practices {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //TC #1: Information alert practice
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void alert_Test1(){
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();
        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert=driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
         WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

         //Failure message will only be displayed if assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");

        String expectedText = "You successfully clicked an alert";
        String actualText= resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result test is not as expected");
    }

    @Test
    public void alertPracticeT2(){
        //3. Click to “Click for JS Confirm” button
        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickForJsConfirm.click();
        //4. Click to OK button from the alert
        Alert alert= driver.switchTo().alert();
        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText= driver.findElement(By.id("result"));

        String expectedText="You clicked: Ok";
        String actualResultText=resultText.getText();

        Assert.assertEquals(actualResultText, expectedText);


    }

    @Test
    public void alertPracticeT3(){
        //Click to “Click for JS Prompt” button
        WebElement clickForJsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickForJsPrompt.click();

        Alert alert= driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        WebElement resultText= driver.findElement(By.xpath("//p[@style='color:green']"));

        String expected="You entered: hello";
        String actual=resultText.getText();

        Assert.assertEquals(actual, expected);





    }

}
