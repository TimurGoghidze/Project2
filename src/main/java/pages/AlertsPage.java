package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.awt.SystemColor.text;

public class AlertsPage extends PageBase {


    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    WebElement simpleAlertButton;//назовем

    public AlertsPage clickOnSimpleAlertButton() {
        click(simpleAlertButton);
        Alert alert = driver.switchTo().alert(); // переключить фокус с кнопки на всплывшееся сверху в браузере
        alert.accept(); // проверка и подтвержение
        //alert.dismiss(); // проверка всплывшегося окна и нажатие cancel
        return this;//нахожусь здесь значит возвращение этой же страницы
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;//назовем timerAlertButton

    public AlertsPage clickOnTimerAlertButton() {
        click(timerAlertButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7)); // вариант ждать
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());// подожди пока алерт не появиться
        String alertMsg = myAlert.getText();
        System.out.println("alert=" + alertMsg);
        myAlert.accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;//назовем

    public AlertsPage clickOnConfirmButton(String text) {
        click(confirmButton);
        if (text == null) {
            return this;
        }
        if (text.equals("Отмена")) {
            driver.switchTo().alert().dismiss();//click Cancel
        } else if (text.equals("OK")) {
            driver.switchTo().alert().accept(); // click OK
        }
        return this;//нахожусь здесь значит возвращение этой же страницы
    }

    @FindBy(id = "confirmResult") // поиск всплывающего сообщения после нажатия кнопки
    WebElement confirmResult;//

    public String getConfirmResult() {
        return getConfirmResult();
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage clickOnMessageAlertButton(String msg) {//при нажатии появляется алерт с полем для введения текста
        click(confirmButton);
        if (msg != null) {
            driver.switchTo().alert().sendKeys(msg); // for field msg
        }
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        return this;
    }
    @FindBy(id = "promptResult") // поиск всплывающего сообщения после нажатия кнопки
    WebElement promtResult;//

    public String getConfirmMessageResult() {
        return promtResult.getText();
    }
}


