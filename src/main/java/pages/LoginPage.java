package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {// super переходит к род классу и вызывает всё что там
        super(driver);
    }

    //поиск через аннотацию упростит нам задачу
    @FindBy(id="userName") //TimurTest
    WebElement userName; //как только он будет вызван где-то внизу, он тут же будет вызываться

    @FindBy(id="password") //TimurTest1!
    WebElement password;

    @FindBy(id="login")
    WebElement loginButton;

}
/*


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

