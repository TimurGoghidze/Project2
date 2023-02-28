package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);}// super переходит к род классу и вызывает всё что там
/*
    @FindBy(id="userName") //TimurTest
    WebElement userName;


    @FindBy(id="password") //TimurTest1!
    WebElement password;

    @FindBy(id="login")
    WebElement loginButton;

    public ProfilePage login(String uName, String pass){
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return new ProfilePage(driver);
    }


    public LoginPage loginNegative(String uName, String pass){
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return this;
    }
    */
}
