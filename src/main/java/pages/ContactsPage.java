package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends PageBase {

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submit")
    WebElement logOutButton;


    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/label[1]")
    WebElement Books;

    //область видимости, что возращается после нажатия (т.к. ничего не заполняем никакие аргументы не нужны)
    public LoginPage logout() {
        click(logOutButton);
        return new LoginPage(driver);
    }
    public WebElement getBooks() { //generate Book Getter
        return Books;
    }

}
