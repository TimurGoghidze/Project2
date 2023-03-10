package pages;

//Здесь будем добавлять повторяющийся участки кода
// хранение общих методов и полей актуальных на той странице

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase { // делаем абстрактый класс но будет лежать в основе


    private WebDriver driver;
    static Logger logger = LoggerFactory.getLogger(PageBase.class);//for logs

    public PageBase(WebDriver driver) { // вместо того чтобы писать вручную можем кликнуть создать конструктор
        this.setDriver(driver);
        PageFactory.initElements(driver, this);// в конструктор добавляем эту строку для регистраци посредство this и позволит
        // потом делать осущ поиска через @FindBy
    }

    public void click(WebElement element) { // метод клик отвечает за кликанье по экрану м.б кнопки
        element.click();
    }

    public void type(WebElement element, String text) { // отвечает за заполнение полей и состоит из элемента и то чем мы будем заполнять
        if (text != null) { //защита от дурака проверяет если текст не пустой
            click(element); // клик
            element.clear(); // чистим если было что-то написано
            element.sendKeys(text); // и вводим текст
        }
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        click(element);
    }

    public void typeWithJSExecutor(WebElement element, String text, int x, int y) {
        if (text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver() { // имплементация getDriver
        return driver;
    }

    public void setDriver(WebDriver driver) { // имплементация setDriver
        this.driver = driver;
    }
}
