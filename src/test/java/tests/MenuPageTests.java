package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.PageBase;

public class MenuPageTests extends TestBase {
    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/menu");
    }

    @Test
    public void menuTest() {
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.hoverOverMenu(); //наводим курсоры
        Assert.assertEquals(menuPage.getMainItemText(), "Main Item 2");
        Assert.assertEquals(menuPage.getSubMenu1Text(), "SUB SUB LIST »");
        Assert.assertEquals(menuPage.getSubMenu2Text(), "Sub Sub Item 2");
    }

}
