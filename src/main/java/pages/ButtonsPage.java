package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.security.PublicKey;

public class ButtonsPage extends PageBase {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    @FindBy(xpath = "//p[@id='doubleClickMessage']")
    WebElement doubleClickMessage;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    @FindBy(xpath= "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/button[1]")
    WebElement clickMeBtn;

    @FindBy(xpath = "//p[@id='dynamicClickMessage']")
    WebElement clickMeMsg;

    public ButtonsPage doubleClick() { //метод двойного щелчка
        Actions action = new Actions(driver); // класс которому можно перечислять что желаем делать
        action.doubleClick(doubleClickBtn).perform(); //и в конце что бы запустить всю цепочку нужно написать perform
        return this;
    }

    public String getDoubleClickMsg() { // метод чтобы обнаружить сообщение о двойном нажатии
        return doubleClickMessage.getText();//и вывести текст
    }

    public ButtonsPage rightClick() {
        Actions action = new Actions(driver); // класс которому можно перечислять что желаем делать
        action.contextClick(rightClickBtn).perform(); //CONTEXT = Правый клик мыши и в конце что бы запустить всю цепочку нужно написать perform
        return this;
    }

    public String getRightClickMsg() { // метод чтобы обнаружить сообщение при правом нажатии
        return rightClickMessage.getText();//и вывести текст
    }

    public ButtonsPage clickMeBtn() {
        Actions action = new Actions(driver); // класс которому можно перечислять что желаем делать
        action.click(clickMeBtn).perform();
        sleep();
        return this;
    }

    public String getClickMeMsg() { // метод чтобы обнаружить сообщение при правом нажатии
          return clickMeMsg.getText();//и вывести текст
    }

}
