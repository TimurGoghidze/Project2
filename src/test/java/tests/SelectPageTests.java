package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.FramePage;
import pages.SelectMenuPage;

public class SelectPageTests extends TestBase {
    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/select-menu");
    }

    @Test
    public void simpleSelectTest() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());//создали экземляр этого класса
        selectMenuPage.oldStyleMenu("Purple");// and his method
    }

    @Test
    public void multiSelectTest() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());// s-экземпляр S с новыми свойствами new
        selectMenuPage.multiSelectDropdown("Black");// call this method
        selectMenuPage.deselect(); //deselect
        sleep();
    }
    @Test
    public void multiSelectTest2() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        selectMenuPage.MultiSelectDropDown("Blue","Black","Red");
        sleep();
    }
    @Test
    public void standardMultiSelect(){
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        selectMenuPage.standardMultiSelect();
        sleep();
    }
}
