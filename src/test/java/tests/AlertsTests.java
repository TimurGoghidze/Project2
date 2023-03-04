package tests;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AlertsPage;
import tests.TestBase;

public class AlertsTests extends TestBase{
    @BeforeSuite
    public void setUpInternal() {
        super.url ="https://demoqa.com/alerts/";
    }

    @Test
    public void simpleAlertTest(){
        new AlertsPage(driver).clickOnSimpleAlertButton();

    }

    @Test
    public void waitOfAlertTest(){
        new AlertsPage(driver).clickOnTimerAlertButton();}

    @Test
    public void confirmAlertTest(){
        new AlertsPage(driver).clickOnConfirmButton("OK");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Ok"));
    }
    @Test
    public void sentTextAlertTest(){
        new AlertsPage(driver).clickMessageAlertButton("Hello world");
        Assert.assertTrue(new AlertsPage(driver).getConfirmMessageResult().contains("Hello world"));
    }
}
