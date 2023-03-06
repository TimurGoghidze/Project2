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

    @FindBy(id = "frame1")
    WebElement frame1;

    private String text;

    public FramePage returnListOfFrames() {
        System.out.println(frames.size());
        getDriver().switchTo().frame(frame1).findElement(By.id("sampleHeading")).getText();
//   System.out.println(frame1.getText());
//        for (WebElement element :
//                frames) {
//            System.out.println(driver.switchTo().frame(element).findElement(By.id("sampleHeading")).getText());
//        }
        return this;
    }
public void switchToFrameByIndex(int index){
        getDriver().switchTo().frame(index);
}

    public void switchToFrameById(WebElement frame){
        getDriver().switchTo().frame(frame); // switch by id
        getDriver().switchTo().defaultContent();
    }

    public String getText() { //getter for text
        return text;
    }
}
