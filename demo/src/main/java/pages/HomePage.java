package pages;

import org.openqa.selenium.By;

public class HomePage extends SeleniumActions{


    private final static By TOP_BAR= By.xpath("//div[@class='app_logo']");


    public  String homepageLoaded(){
        return getText(TOP_BAR);
    }
    
}
