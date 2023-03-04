package tests.alertsFrameWindows;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AlertsPage;
import tests.TestBase;

public class AlertsTests extends TestBase{
    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/alerts/");
    }

    @Test
    public void simpleAlertTest(){
        new AlertsPage(getDriver()).clickOnSimpleAlertButton();

    }

    @Test
    public void waitOfAlertTest(){
        new AlertsPage(getDriver()).clickOnTimerAlertButton();}

    @Test
    public void confirmAlertTest(){
        new AlertsPage(getDriver()).clickOnConfirmButton("OK");
        Assert.assertTrue(new AlertsPage(getDriver()).getConfirmResult().contains("Ok"));
    }
    @Test
    public void sentTextAlertTest(){
        new AlertsPage(getDriver()).clickMessageAlertButton("Hello world");
        Assert.assertTrue(new AlertsPage(getDriver()).getConfirmMessageResult().contains("Hello world"));
    }
}
