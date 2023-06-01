package pages.Naukri;

import org.openqa.selenium.By;

import pages.SeleniumActions;

public class DashboadPage extends SeleniumActions {

    private static final By VIEWPROFILE_LINK = By.xpath("//*[@class='view-profile-wrapper']/a");

    private static final By KEYSKILLS_EDIT = By.xpath("// *[@class='keySkills']//span[text()='editOneTheme']");

    //private static final By RESUMEHEADLINE_EDIT = By.xpath(" // *[@class='resumeHeadline']//span[text()='editOneTheme']");

   

    private static final By UPDATEKEYSKILLS_BTN = By.xpath("//*[@name='keySkillsForm']//button[@id='saveKeySkills']");

    private static String messageText = "Key Skills have been successfully saved";
    private static final By MESSAGE_BY = By.xpath("//*[contains(text(), '" + messageText + "')]");

    public String updateKeySkills() throws InterruptedException {
        jsclick(VIEWPROFILE_LINK);  
        jsclick(KEYSKILLS_EDIT);
        jsclick(UPDATEKEYSKILLS_BTN);
       // actionOnElement(RESUMEHEADLINE_EDIT, "scroll");
        highlightElement(MESSAGE_BY, 3);
        return getText(MESSAGE_BY);
    }

}
// *[@class='keySkills']//span[text()='editOneTheme']