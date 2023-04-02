package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Homework1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div[2]/button")).click();
        WebElement googleSearchbox = driver.findElement(By.name("search_query"));
        googleSearchbox.sendKeys("wooden spoon" + Keys.ENTER );

        String expectedTitle = "Wooden spoon - Etsy DE";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

    }
}
