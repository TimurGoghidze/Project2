package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;
import java.util.List;

public class NestedFramesPage extends PageBase {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> frames;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrames(){
        System.out.println("Number of frames: " + frames.size());
        driver.switchTo().frame(frame1);//
        System.out.println("Frame1 text: " + frame1.getText());
        driver.switchTo().frame(0); // по индеку
        System.out.println("Frame2 text: " + body.getText());
        driver.switchTo().parentFrame(); // по родительскому на один уровень вверх
        System.out.println("Parent Frame text: " + body.getText());
        return this;
    }

}
