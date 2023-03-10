package tests.alertsFrameWindows;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.FramePage;
import tests.TestBase;

public class FramesTests extends TestBase {

    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/frames");
    }

    @Test
    public void simpleFrameTest() {
        new FramePage(getDriver()).returnListOfFrames();
    }
}
