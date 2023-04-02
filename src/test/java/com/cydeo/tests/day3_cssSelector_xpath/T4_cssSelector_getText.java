package com.cydeo.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_cssSelector_getText {
    public static void main(String[] args) {
        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        //WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));

      String expectedResetPasswordButton = "Reset password";
      String actualResetPasswordButton = resetPasswordButton.getText();

      if(actualResetPasswordButton.equals(expectedResetPasswordButton)){
          System.out.println("Button text verification PASSED!");
      }else{
          System.out.println("Button text verification FAILED!");
      }
    }
}
