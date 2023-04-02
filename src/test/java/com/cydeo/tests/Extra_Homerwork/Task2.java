package com.cydeo.tests.Extra_Homerwork;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {
    @Test
    public void SmartBearOrder () throws InterruptedException {
         //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3. Enter username: “Tester”
        WebElement username= Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        //5. Click on Login button
        WebElement loginBtn=Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginBtn.click();
        //6. Click on Order
        WebElement orderBtn=Driver.getDriver().findElement(By.xpath("//a[.='Order']"));
        orderBtn.click();
        //7. Select familyAlbum from product, set quantity to 2
        WebElement familyAlbumBtn=Driver.getDriver().findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']"));
        Select select=new Select(familyAlbumBtn);
        select.selectByIndex(1);
        WebElement quantity= Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("2");
        //8. Click to “Calculate” button
        WebElement calculateBtn=Driver.getDriver().findElement(By.xpath("//input[@value='Calculate']"));
        calculateBtn.click();
        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
         Faker faker=new Faker();
         WebElement costumerName= Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
         costumerName.sendKeys(faker.name().fullName());
         WebElement streetName= Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
         streetName.sendKeys(faker.address().streetName());
         WebElement cityName= Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
         cityName.sendKeys(faker.address().cityName());
         WebElement stateName=Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
         stateName.sendKeys(faker.address().state());
         WebElement zipCode= Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
         zipCode.sendKeys(faker.numerify("#####"));
        //10. Click on “visa” radio button
         WebElement radioBtn= Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
         radioBtn.click();
        //11. Generate card number using JavaFaker
        Thread.sleep(2);
         WebElement creditCard=Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        creditCard.sendKeys(faker.finance().creditCard().replaceAll("-",""));
         WebElement expireDate= Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
         expireDate.sendKeys("12/22");
        //12. Click on “Process”
        WebElement processBtn= Driver.getDriver().findElement(By.xpath("//a[@class='btn_light']"));
        processBtn.click();

        //13. Verify success message “New order has been successfully added.”
        WebElement successfulOrder=Driver.getDriver().findElement(By.xpath("//input[@type='reset']/following-sibling::strong[1]"));
        String actual=successfulOrder.getText();
        Assert.assertEquals(actual, "New order has been successfully added.");
     }

    }

