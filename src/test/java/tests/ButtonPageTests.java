package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ButtonsPage;
import pages.PageBase;
import pages.WindowsPage;

public class ButtonPageTests extends TestBase {
    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/buttons/");
    }

    @Test
    public void doubleClickTest() {
        ButtonsPage buttonsPage = new ButtonsPage(getDriver());
        buttonsPage.doubleClick();
        sleep();
        String text = buttonsPage.getDoubleClickMsg();
        //String text= new ButtonsPage(getDriver()).doubleClick().getDoubleClickMsg(); // инициализация класса = извлекли method & текст
        Assert.assertEquals(text, "You have done a double click");
    }

    @Test
    public void rightClickTest() {
        ButtonsPage buttonsPage = new ButtonsPage(getDriver());
        buttonsPage.rightClick(); //
        sleep();
        String text = buttonsPage.getRightClickMsg(); //вытаскиваем
        Assert.assertEquals(text, "You have done a right click"); //проверка по эталоному тексту

    }
    @Test
    public void testClickMe() {
        ButtonsPage buttonsPage = new ButtonsPage(getDriver());
        buttonsPage.clickMeBtn();
        sleep();
        String text = buttonsPage.getClickMeMsg();
        Assert.assertEquals(text,"You have done a dynamic click");

    }
}
