package driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import config.ConfigurationFactory;
import enums.BrowserType;

public final class RemoteDriverFactory {

    private RemoteDriverFactory() {
    }

    public static WebDriver getRemoteDriver(String browsername) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        if (browsername.equalsIgnoreCase(BrowserType.CHROME.getBrowserValue())) {
            dc.setBrowserName(BrowserType.CHROME.getBrowserValue());

        } else {
            dc.setBrowserName(BrowserType.EDGE.getBrowserValue());
        }
        return new RemoteWebDriver(new URL(ConfigurationFactory.getConfig().remoteurl()),dc);

    }
}
