package tests.alertsFrameWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NestedFramesPage;
import tests.TestBase;

public class NestedFramesTests extends TestBase {

    @BeforeMethod
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/nestedframes/");
    }

    @Test
    public void testNestedFrames() {
        new NestedFramesPage(getDriver()).handleNestedFrames();


    }
}
