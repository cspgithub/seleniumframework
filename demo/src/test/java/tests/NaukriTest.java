package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.ExcelReaderDataProvider;
import pages.Naukri.DashboadPage;
import pages.Naukri.LoginPage;
import util.Decode;

public class NaukriTest extends BaseTest {

    @Test(dataProvider = "excelData", dataProviderClass = ExcelReaderDataProvider.class)
    public void verifyNaukriUpdate(Map<String, Object> data) throws Exception {

        String username = Decode.decodeCredentials(data.get("username").toString());
        String passsord = Decode.decodeCredentials(data.get("password").toString());
        LoginPage naukriLogin = new LoginPage();
        naukriLogin.loginInNaukri(username, passsord);
        DashboadPage dash = new DashboadPage();
        String actual = dash.updateKeySkills();
        Assert.assertEquals(actual, "Key Skills have been successfully saved.");
        // docker run -p 4444:4444 --name sel selenium/standalone-chrome
        /*
         * automation:
         * image: automation-test:latest
         * container_name: automationtest
         * build: .
         * shm_size: 2gb
         * depends_on:
         * - selenium-hub
         * - chrome
         * environment:
         * - HOST_NAME=selenium-hub
         */

    }

}
