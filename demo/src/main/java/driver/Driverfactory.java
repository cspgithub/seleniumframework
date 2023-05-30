package driver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class Driverfactory {

    public static WebDriver getDriver(String browsername, String runmode) throws MalformedURLException {

        WebDriver driver = null;
        if (runmode.equalsIgnoreCase("local")) {
            driver = LocalDriverFactory.getLocalDriver(browsername);

        } else {
            driver = RemoteDriverFactory.getRemoteDriver(browsername);
        }
        return driver;

    }

}
