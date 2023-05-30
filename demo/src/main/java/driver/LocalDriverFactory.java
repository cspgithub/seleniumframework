package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class LocalDriverFactory {

    private LocalDriverFactory(){}

    public static WebDriver getLocalDriver(String browsername) {

        WebDriver driver = null;
        if (browsername.equalsIgnoreCase(BrowserType.CHROME.getBrowserValue())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else {
            driver = new EdgeDriver();
        }
        return driver;

    }

}
