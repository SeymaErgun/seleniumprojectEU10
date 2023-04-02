package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_NextBaseCRM_locators {
    public static void main(String[] args) {
//TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
//1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
//3- Enter incorrect username into login box:
        WebElement loginBox= driver.findElement(By.xpath("//input[@class='login-inp']"));
        loginBox.sendKeys("incorrect");
//4- Click to `Reset password` button
        WebElement resetPasswordBtn = driver.findElement(By.xpath("//button[@class='login-btn']"));
        resetPasswordBtn.click();
//5- Verify “error” label is as expected
// Expected: Login or E-mail not found
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='errortext']"));

        String actualErrorLabelText= errorLabel.getText();
        String expectedErrorLabelText="Login or E-mail not found";

        System.out.println("actualErrorLabelText = " + actualErrorLabelText);
        System.out.println("expectedErrorLabelText = " + expectedErrorLabelText);

        if(actualErrorLabelText.equals(expectedErrorLabelText)){
            System.out.println("error label text is PASSED");
        }else{
            System.out.println("error label text is FAILED");
        }







    }
}
