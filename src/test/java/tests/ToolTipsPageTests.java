package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ToolTipsPage;

public class ToolTipsPageTests extends TestBase {
    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/tool-tips");
    }

    @Test
    public void tooltipButtonTest() {
        ToolTipsPage toolTipsPage = new ToolTipsPage(getDriver()); //экземпляр класса
        toolTipsPage.hoverToolTipButton(); //метод вызов через переменную
        Assert.assertEquals(toolTipsPage.getToolTipText(), "You hovered over the Button");//проверка через геттер
    }
    @Test
    public void tooltipButtonTest2() {
        ToolTipsPage toolTipsPage = new ToolTipsPage(getDriver()); //экземпляр класса
        toolTipsPage.hoverToolTipTextField(); //метод вызов через переменную
        Assert.assertEquals(toolTipsPage.getToolTipTextFieldText(), "You hovered over the text field");//проверка через геттер
    }
}
