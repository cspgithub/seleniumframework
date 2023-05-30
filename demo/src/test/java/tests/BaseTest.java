package tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class BaseTest {

    
    @BeforeMethod

    public void initiateDriver() throws MalformedURLException {

        Driver.setup();
    }

    @AfterMethod
    public void tearDown() {
        Driver.tearDown();
    }

}
