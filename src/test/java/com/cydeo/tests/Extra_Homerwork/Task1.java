package com.cydeo.tests.Extra_Homerwork;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.SmartBearUtils;
import org.testng.annotations.Test;

public class Task1 extends TestBase {
    @Test
    public void Test2(){
    //TC #1: Smartbear software link verification
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
     driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //Calling my utility method to login smartbear
        SmartBearUtils.loginToSmartBear(driver);


    }
}
