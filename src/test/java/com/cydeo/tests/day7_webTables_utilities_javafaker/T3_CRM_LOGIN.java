package com.cydeo.tests.day7_webTables_utilities_javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_CRM_LOGIN extends TestBase {

    @Test
    public void crm_login_test(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");
        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@type='text']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");
        //4. Enter valid password
        WebElement inputPassword= driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement LoginButton= driver.findElement(By.xpath("//input[@type='submit']"));
        LoginButton.click();
        //6. Verify title is as expected:
        //Expected: My tasks
        BrowserUtils.verifyTitle(driver, "My tasks");
    }

    @Test
    public void crm_login_test_2(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        //6. Verify title is as expected:
        //Expected: My tasks
        BrowserUtils.verifyTitle(driver, "My tasks");
    }
    @Test
    public void crm_login_test_3(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser");

        //6. Verify title is as expected:
        //Expected: (1) Portal
        BrowserUtils.verifyTitle(driver, "Portal");
    }
}
