package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Homework3 {
    public static void main(String[] args) {
        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.get("https://google.com");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();

        //3- Click to Gmail from top right.
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();
        //4- Verify title contains:
        //  Expected: Gmail
        String expectedTitle="Gmail";
        String actualTitle=driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("title text verification PASSED");
        }else{
            System.out.println("title text verification FAILED");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();
        //6- Verify title equals:
        //  Expected: Google
        String expectedResult="Google";
        String actualResult=driver.getTitle();

        if (actualResult.equals(expectedResult)){
            System.out.println("Test verification PASSED");
        }else{
            System.out.println("Test verification FAILED");
        }

    }
}
