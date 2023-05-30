package pages.Naukri;

import org.openqa.selenium.By;

import pages.SeleniumActions;

public class LoginPage extends SeleniumActions {

    private static final By NAUKRI_LOGINBTN = By.xpath("//*[@title='Jobseeker Login']");
    private static final By NAUKRI_USERNAMETXTBOX = By
            .xpath("//*[@placeholder='Enter your active Email ID / Username']");
    private static final By NAUKRI_PASSWORDTEXTBOX = By.xpath("//*[@placeholder='Enter your password']");
    private static final By NAUKRI_SUBMITBTN = By.xpath("//*[@class='btn-primary loginButton']");

    public void loginInNaukri(String username, String passsord) {
        click(NAUKRI_LOGINBTN);
        sendkeys(NAUKRI_USERNAMETXTBOX, username);
        sendkeys(NAUKRI_PASSWORDTEXTBOX, passsord);
        click(NAUKRI_SUBMITBTN);

    }

}
