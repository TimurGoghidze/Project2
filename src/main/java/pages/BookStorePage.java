package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='searchBox']")
    WebElement searchbox;

    @FindBy(xpath = "//a[contains(text(),'Git Pocket Guide')]")
    WebElement book;
    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    WebElement addToCollectionButton;


    private String bookAddedMsg;

    public BookStorePage searchBook(String bookName) {
        type(searchbox, bookName);
        return this;
    }

    public BookStorePage selectBook(WebElement book) {
        click(book);
        return this;
    }

    public WebElement getBook() {
        return book;
    }

    public BookStorePage addToCollection() {
        clickWithJSExecutor(addToCollectionButton, 0,100);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9)); // вариант ждать
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());// подожди пока алерт не появиться
        //Alert alert = driver.switchTo().alert();
        bookAddedMsg = alert.getText();
        alert.accept();
        return this;

    }

    public String getBookAddedMsg() { //getter от bookAddedMsg
        return bookAddedMsg;
    }

}
