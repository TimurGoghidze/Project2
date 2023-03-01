package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {// super переходит к род классу и вызывает всё что там
        super(driver);
    }

    //поиск через аннотацию упростит нам задачу
    @FindBy(id = "userName") //TimurTest
    WebElement userName; //как только он будет вызван где-то внизу, он тут же будет вызываться

    @FindBy(id = "password") //TimurTest1!
    WebElement password;


    @FindBy(id = "login")
    WebElement loginButton;

    public ContactsPage login(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return new ContactsPage(driver);
    }

    public LoginPage loginNegative(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return this; // т.к. мы никуда не проваливаемся пусть показывает эту же страницу сценарий же негативный
    }




}








