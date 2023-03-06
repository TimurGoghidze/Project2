package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends PageBase {
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    @FindBy(css = ".tooltip-inner")
    WebElement toolTip;

    private String toolTipText;



    private String toolTipTextFieldText;
    public ToolTipsPage hoverToolTipButton() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(toolTipButton).perform();
        System.out.println(toolTip.getText());
        toolTipText = toolTip.getText();
        sleep();
        return this;
    }

    @FindBy(id = "toolTipTextField")
    WebElement toolTipTextField;

    public ToolTipsPage hoverToolTipTextField() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(toolTipTextField).perform();
        System.out.println(toolTip.getText());
        toolTipTextFieldText = toolTip.getText();
        sleep();
        return this;
    }

    public String getToolTipText() {
        return toolTipText;
    }
    public String getToolTipTextFieldText() {
        return toolTipTextFieldText;
    }
}
