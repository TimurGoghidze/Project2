package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends PageBase {


    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    WebElement simpleAlertButton;//назовем

    public AlertsPage clickOnSimpleAlertButton() {
        click(simpleAlertButton);
        Alert alert = getDriver().switchTo().alert(); // переключить фокус с кнопки на всплывшееся сверху в браузере
        alert.accept(); // проверка и подтвержение
        //alert.dismiss(); // проверка всплывшегося окна и нажатие cancel
        return this;//нахожусь здесь значит возвращение этой же страницы
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;//назовем timerAlertButton

    public AlertsPage clickOnTimerAlertButton() {
        click(timerAlertButton);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(7)); // вариант ждать
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
            getDriver().switchTo().alert().dismiss();//click Cancel
        } else if (text.equals("OK")) {
            getDriver().switchTo().alert().accept(); // click OK
        }
        return this;//нахожусь здесь значит возвращение этой же страницы
    }

    @FindBy(id = "confirmResult") // поиск всплывающего сообщения после нажатия кнопки
    WebElement confirmResult;//

    public String getConfirmResult() {
        return confirmResult.getText();
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage clickMessageAlertButton(String msg) {//при нажатии появляется алерт с полем для введения текста
        click(promtButton);
        if (msg != null) {
            getDriver().switchTo().alert().sendKeys(msg); // for field msg
        }
        System.out.println(getDriver().switchTo().alert().getText());
            getDriver().switchTo().alert().accept();
        sleep();
        return this;
    }
    @FindBy(id = "promptResult") // поиск всплывающего сообщения после нажатия кнопки
    WebElement promptResult;//

    public String getConfirmMessageResult() {
        return promptResult.getText();
    }
}


