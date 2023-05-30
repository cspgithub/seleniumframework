package driver;



import java.time.Duration;

import org.openqa.selenium.WebDriver;

import config.ConfigurationFactory;

public class Driver {

    public static WebDriver driver;

    private Driver() {
    }

    public static void setup() {
        if (DriverManager.getDriver() == null) {
            String browser = ConfigurationFactory.getConfig().browser();
           
            driver = Driverfactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(ConfigurationFactory.getConfig().timeout()));
            DriverManager.getDriver().get(ConfigurationFactory.getConfig().url());
        }

    }/*  */

    public static void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.flushDriver();
            DriverManager.setDriver(null);
        }

    }

}
