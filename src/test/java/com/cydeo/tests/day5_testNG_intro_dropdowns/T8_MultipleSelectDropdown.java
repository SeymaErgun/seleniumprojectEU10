package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleSelectDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void SelectValueFromMultipleSelectDropdown() {
        List<WebElement> allMultipleDropdowns = driver.findElements(By.tagName("select"));
        System.out.println("allMultipleDropdowns.size() = " + allMultipleDropdowns.size());

        Select select;
        for (WebElement dropdown : allMultipleDropdowns) {
            select = new Select(dropdown);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                //3. Select all the options from multiple select dropdown.
                option.click();
                //4. Print out all selected values.
                System.out.println(option.getText() + " option.isSelected()= " + option.isSelected());
            }

        }

        //5. Deselect all values.
        for (WebElement dropdown : allMultipleDropdowns) {
            select = new Select(dropdown);
            if (select.isMultiple()) {
                select.deselectAll();
            } else {
                select.selectByIndex(0);
            }

        }

    }

}
