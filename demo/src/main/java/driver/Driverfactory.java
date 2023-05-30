package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

    public static WebDriver getDriver(String browsername) {

        WebDriver driver;
        if (browsername.equalsIgnoreCase(BrowserType.CHROME.getBrowserValue())) {
            WebDriverManager.chromedriver().setup();

           /*  System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/src/test/java/resources/driver/chromedriver.exe");  */

            driver = new ChromeDriver();

        } else {
            driver = new EdgeDriver();
        }

        return driver;

    }

}
