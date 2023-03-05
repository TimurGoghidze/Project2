package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends PageBase {
    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> frames;

    @FindBy(id = "frame2")
    WebElement frame1;

    private String text;

    public FramePage returnListOfFrames(){
        //System.out.println(frames.size());
        text = driver.switchTo().frame(frame1).findElement(By.id("sampleHeading")).getText();//by id


        return this;
    }

    public String getText() { //getter for text
        return text;
    }
}
