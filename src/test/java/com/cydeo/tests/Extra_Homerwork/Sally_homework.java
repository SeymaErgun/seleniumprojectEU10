package com.cydeo.tests.Extra_Homerwork;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Sally_homework {
    @Test
    public void todoTest(){
        //1.Go to 'https://amazon.com.tr/'
        Driver.getDriver().get("https://amazon.com.tr/");
        //Accept cookies
        BrowserUtils.sleep(2);
        WebElement acceptCookies=Driver.getDriver().findElement(By.xpath("//input[@id='sp-cc-accept']"));
        acceptCookies.click();
        //Search iPhone13
        WebElement searchBox=Driver.getDriver().findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iPhone13 512");
        WebElement searchBtn=Driver.getDriver().findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchBtn.click();
        //Check that the results are listed
        List<WebElement> iPhones=Driver.getDriver().findElements(By.xpath("//img[contains (@class,'s-image')]"));
        System.out.println(iPhones.size());

        WebElement telephone=Driver.getDriver().findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']"));
        telephone.click();


        WebElement iPhone=Driver.getDriver().findElement(By.xpath("//span[.='iPhone 13']"));
        System.out.println(iPhone.getText());
        WebElement iPhoneSize=Driver.getDriver().findElement(By.xpath("//span[.='512 GB']"));
        System.out.println("Size: " + iPhoneSize.getText());
        WebElement color=Driver.getDriver().findElement(By.xpath("//span[.='Yıldız Işığı']"));
        System.out.println("Color: " + color.getText());
        WebElement price=Driver.getDriver().findElement(By.xpath("//div[@id='corePrice_feature_div']"));
        System.out.println("Price: " + price.getText());
        WebElement stock=Driver.getDriver().findElement(By.xpath("//span[.='    Stokta var.   ']"));
        System.out.println("Stock: " + stock.getText());


    }
}
