package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ExperimentPage;

public class ExperimentTest extends BaseTest {

    @Test
    public void testScroll() {
        ExperimentPage expObj = new ExperimentPage();
        expObj.scrollToFooter("scroll");

    }

    @Test
    public void testScrolltoMiddle() {
        ExperimentPage expObj = new ExperimentPage();

        String actual = "Amazon.in - Today's Deals";
        Assert.assertEquals(actual, expObj.scrollToMiddle("scroll"));

    }
}
