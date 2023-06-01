package pages;

import org.openqa.selenium.By;

public class LoginPage extends SeleniumActions {

    private final static By TEXT_USERNAME = By.xpath("//input[@id='user-name']");
    private final static By TEXT_PASSWORD = By.xpath("//input[@id='password']");
    private final static By BTN_SUBMIT = By
            .xpath("//input[@class='submit-button btn_action']");

    public HomePage loginApplication(String username, String password) {
       
        sendkeys(TEXT_USERNAME, username);
        sendkeys(TEXT_PASSWORD, password);
        jsclick(BTN_SUBMIT);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return new HomePage();
       
    }

}
