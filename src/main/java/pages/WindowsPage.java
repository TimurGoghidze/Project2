package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class WindowsPage extends PageBase {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    @FindBy(id = "windowButton")
    WebElement windowButton;

    @FindBy(id = "messageWindowButton")
    WebElement messageWindowButton;

    @FindBy(xpath="//body")
    WebElement body;

    public WindowsPage clickTabButton() {//подсасывает из метода пониже
        clickButton(tabButton);
        return this;
    }

    public WindowsPage clickWindowButton() {//подсасывает из метода пониже
        clickButton(windowButton);
        return this;
    }

    public WindowsPage clickNewWindowMessage() {//подсасывает из метода пониже
        clickButton(messageWindowButton);
        return this;
    }

    // этот метод используем не только открытие вкладок но и открытие окон
    public WindowsPage clickButton(WebElement button) {
        click(button);
        sleep();
        String originalWindow = driver.getWindowHandle(); //возвращает список всех открытых вкладок и мы по ним идем
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {// если вкладка кот. не равна родительской вкладке
                driver.switchTo().window(windowHandle); //то переключается на неё
                break; // и выходим из цикла
            }
        }
        //driver.switchTo().window(tabs.get(0));
        return this;
    }

    public WebElement getSampleHeading() {
        return sampleHeading;
    }
    public WebElement getBody() { //getter for Body
        return body;
    }
}