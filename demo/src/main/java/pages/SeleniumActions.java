package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigurationFactory;
import driver.DriverManager;
import enums.ActionType;

public class SeleniumActions {

    protected SeleniumActions() {

    }

    private static WebDriverWait wait;

    protected static WebElement getElement(By by) {
        WebElement element = null;
        wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(ConfigurationFactory.getConfig().timeout()));

        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            System.out.println("Element not diaplyed in UI,not present: " + e.getMessage());
        }
        return element;
    }

    protected static void sendkeys(By by, String inputString) {
        getElement(by).clear();
        getElement(by).sendKeys(inputString);
    }

    protected static void click(By by) {
        getElement(by).click();
    }

    protected static void jsclick(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript("arguments[0].click();", getElement(by));

    }

    protected static String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected static String getText(By by) {
        return getElement(by).getText();
    }

    protected static void highlightElement(By by, int duration) throws InterruptedException {
        String original_style = getElement(by).getAttribute("style");
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                getElement(by),
                "style",
                "border: 2px solid red; border-style: dashed;");

        if (duration > 0) {
            Thread.sleep(duration * 1000);
            js.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    getElement(by),
                    "style",
                    original_style);
        }
    }

    protected static void actionOnElement(By by, String typeOfAction) {

        Actions action = new Actions(DriverManager.getDriver());

        if (ActionType.SCROLLTOELEMENT.getActionType().contains(typeOfAction)) {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            try {
                // action.scrollToElement(getElement(by)).perform();
                js.executeScript("arguments[0].scrollIntoView(true);", getElement(by));

            } catch (TimeoutException e) {

                System.out.println("javacript code doestnt worked");

            } catch (Exception e) {
                System.out.println("scroll done but element is not presnt in DOM: " + e.getMessage());
            }

        }
        if (ActionType.MOVETOELEMENT.getActionType().contains(typeOfAction)) {
            action.moveToElement(getElement(by)).perform();

        }

    }

   

}
