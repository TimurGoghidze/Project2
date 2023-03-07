package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submit;

    @FindBy(id = "name")
    WebElement name;


    public TextBoxPage fillInTheForm() {
//        Это вариант если хотим в тесте потом прописывать самостоятельно данные
// public TextBoxPage fillInTheForm(String fName, String eMail, String cAddress, String pAddress)
//        type(userName, fName);
//        type(userEmail, eMail);
//        type(currentAddress, cAddress);
//        type(permanentAddress, pAddress);
//        click(submit);
//        return new TextBoxPage(getDriver());
        // Второй вариант
//        public TextBoxPage fillInTheForm() {
//        type(userName, "Alex Ivanov");
//        type(userEmail, "ivanov@mail.com");
//        typeWithJSExecutor(currentAddress, "Puskin, 23", 0,200);
//        Actions actions = new Actions(getDriver());
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();// ctrl+a
//        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();// ctrl+c
//        actions.sendKeys(Keys.TAB).perform();//tab
//        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform(); //ctrl+v
//        return this;
        //Третий вариант

        type(userName, UserData.USER_NAME);
        sleep();
        type(userEmail, UserData.EMAIL);
        sleep();
        typeWithJSExecutor(currentAddress, "Puskin str.,45 ", 0, 200);
        sleep();
        Actions actions = new Actions(getDriver());
        sleep();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();// ctrl+a
        sleep();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();// ctrl+c
        sleep();
        actions.sendKeys(Keys.TAB).perform();//tab
        sleep();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform(); //ctrl+v
        sleep();

        clickWithJSExecutor(submit, 0,200);

        String nameText = name.getText();
//        String addr=currentAddress.getAttribute("value");
//        System.out.println(addr);
//
//        addr=permanentAddress.getAttribute("value");
//        System.out.println(addr);
        return this;
    }

}
