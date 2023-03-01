package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends PageBase{

    public ContactsPage(WebDriver driver) {super(driver);}

        @FindBy(id = "submit")
        WebElement logOutButton;

    //область видимости, что возращается после нажатия (т.к. ничего не заполняем никакие аргументы не нужны)
    public LoginPage logout(){
        click(logOutButton);
        return new LoginPage(driver);
    }
}
