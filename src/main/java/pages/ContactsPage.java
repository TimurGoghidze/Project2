package pages;

import org.openqa.selenium.By;
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

    //@FindBy(xpath = "//select[@id='langSelect']") // search and change in dropbox
    //WebElement selectLang;

    //область видимости, что возращается после нажатия (т.к. ничего не заполняем никакие аргументы не нужны)
    public LoginPage logout() {
        click(logOutButton);
        return new LoginPage(driver);
    }

    public WebElement getBooks() { //generate Book Getter
        return Books;
    }

//    public WebElement getContacts(String) { // if we used edit configuration -Dlanguage=English например
//        if (lang.equals("English")) {
//            contacts = driver.findElement(By.xpath("//option[contains(text(),'" + lang + "')]"));
//        } else if (lang.equals("Russian")) { //если язык кот мы выбрали равен
//
//        } else if (lang.equals("German")) {
//
//        }else if (lang.equals("Ukraine"))  {
//
//        }else{
//            throw new RuntimeException("Language not supported: "+ lang);
//        }
//        return contaсts;
//    }

//    public ContactsPage selectLanguage(String lang){
//        click(selectLang);
//        WebElement language = driver.findElement(By.xpath("//option[contains(text(),'"+lang+"')]"));
//        click(language);
//        return this;
//    }
    }
