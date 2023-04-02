package com.cydeo.tests.Extra_Homerwork;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculator {
    @Test
    public void GasMileageCalculatorTest(){
        Driver.getDriver().get("https://www.calculator.net");

        WebElement searchBox=Driver.getDriver().findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage");
        WebElement link=Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        link.click();
    //    WebElement a=Driver.getDriver().findElement(By.xpath("//head/title[text()='Gas Mileage Calculator']")); ???? neden olmuyor xpath ile yapınca
    //    System.out.println("a.getText() = " + a.getText()); ???



        System.out.println("Driver.getDriver().findElement(By.xpath(\"//h1\")).isDisplayed() = " + Driver.getDriver().findElement(By.xpath("//h1")).isDisplayed());

        //6. Locate, clear and type “7925” into “Current odometer” field

       WebElement clearBtn=Driver.getDriver().findElement(By.xpath("(//img[@class='clearbtn'])[2]"));
       clearBtn.click();
       WebElement type7925=Driver.getDriver().findElement(By.id("mucodreading"));
       type7925.sendKeys("7925");
       WebElement type7550=Driver.getDriver().findElement(By.id("mupodreading"));
       type7550.sendKeys("7550");
       WebElement type16=Driver.getDriver().findElement(By.id("mugasputin"));
       type16.sendKeys("16");
       WebElement type355=Driver.getDriver().findElement(By.id("mugasprice"));
       type355.sendKeys("3.55");
       WebElement calculateBtn=Driver.getDriver().findElement(By.xpath("(//input[@style='margin-top:10px;'])[2]"));
       calculateBtn.click();
       WebElement mpgValue=Driver.getDriver().findElement(By.xpath("//b[text()='23.44 km/L  or 4.27  L/100 km ']"));
        Assert.assertEquals(mpgValue.getText(), "23.44 km/L or 4.27 L/100 km");

    }
}
