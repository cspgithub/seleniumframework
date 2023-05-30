package pages;

import org.openqa.selenium.By;

public class ExperimentPage extends SeleniumActions {

    private final static By FOOTER_ABOUTUS = By
            .xpath("//*[@class='navFooterColHead' and text()='Get to Know Us']/..//ul//descendant::li[1]/a");
    private final static By MIDDLE_SEEALLOFFERS = By
            .xpath("//*[text()[normalize-space() = 'Today’s Deals']]/..//a[text()='See all deals']");

    public void scrollToFooter(String typeOfAction) {

        actionOnElement(FOOTER_ABOUTUS, typeOfAction);
        jsclick(FOOTER_ABOUTUS);
       

    }
    public String scrollToMiddle(String typeOfAction) {

        actionOnElement(MIDDLE_SEEALLOFFERS, typeOfAction);
        jsclick(MIDDLE_SEEALLOFFERS);
        return getTitle();
       

    }


}
