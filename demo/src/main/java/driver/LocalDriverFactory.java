package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class LocalDriverFactory {

    private LocalDriverFactory() {
    }

    public static WebDriver getLocalDriver(String browsername) {

        WebDriver driver = null;
        if (browsername.equalsIgnoreCase(BrowserType.CHROME.getBrowserValue())) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // Set page zoom level
           // options.addArguments("--zoom-factor=0.5");
            options.addArguments("--force-device-scale-factor=0.6");
            options.addArguments("--headless=new"); // Adjust the zoom level as needed
            driver = new ChromeDriver(options);

        } else {
            driver = new EdgeDriver();
        }
        return driver;

    }

}
