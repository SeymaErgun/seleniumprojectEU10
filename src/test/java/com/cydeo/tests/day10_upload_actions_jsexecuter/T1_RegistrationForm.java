package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_RegistrationForm {
    @Test
    public void registration_form_test(){
        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form

        //create JavaFaker object
        Faker faker= new Faker();

        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        //3. Enter first name
        WebElement inputFirstName= Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());
        //4. Enter last name
        WebElement inputLastName= Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());


        //5. Enter username
        // inputUserName.sendKeys(faker.name().username().replaceAll(".", ""));
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        String user= faker.bothify("helpdesk###");
        inputUserName.sendKeys(user);

        //6. Enter email address
        WebElement inputEmail= Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@gmail.com");
        //7. Enter password
        WebElement inputPassword= Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.numerify("########"));
        System.out.println("inputPassword = " + inputPassword);
        //8. Enter phone number
        WebElement inputPhone= Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));
        //9. Select a gender from radio buttons
        WebElement inputGender= Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();
        //10. Enter date of birth
        WebElement inputBirthday= Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
       // faker.number().numberBetween(2004, 1929);
        inputBirthday.sendKeys("03/08/2000");
        //11. Select Department/Office
        Select departmentDropdown= new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));
        //12. Select Job Title
        Select jobTitleDropdown= new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));
        //13. Select programming language from checkboxes
       WebElement inputProgrammingLanguage=Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
       inputProgrammingLanguage.click();
        //14. Click to sign up button
        WebElement signInBtn=Driver.getDriver().findElement(By.id("wooden_spoon"));
        signInBtn.click();

        WebElement message= Driver.getDriver().findElement(By.xpath("//h4[@class='alert-heading']//following-sibling::p[1]"));
        System.out.println("message.isDisplayed() = " + message.isDisplayed());
        }
    }

