package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.ExcelReaderDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "excelData", dataProviderClass = ExcelReaderDataProvider.class)
    public void testHomeTitle(Map<String, Object> data) {
        LoginPage login = new LoginPage();

        String actual = login.loginApplication(data.get("username").toString(), data.get("password").toString())
                .homepageLoaded();

        Assert.assertEquals(actual, "Swag Labs");

    }

}
