package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.BookStoreLoginPage;
import pages.BookStorePage;
import pages.ProfilePage;
import pages.UserData;

import static java.awt.SystemColor.text;

public class BookStoreSmokeTest extends TestBase {
    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/login");
    }


    @Test
    public void smokeTest() { //вызываем страницу за страницей
        BookStoreLoginPage loginPage = new BookStoreLoginPage(getDriver()); //логин на страницу Book Store
        ProfilePage profile = loginPage.login(); //залогинились и попали на стрю ProfilePage
        sleep();
        BookStorePage bs = profile.scrollDownAndGoToBookStore(); //далее переходим на стр. bookstore
        sleep();
        bs.searchBook(UserData.BOOK_NAME);//ищем книгу
        sleep();
        bs.selectBook(bs.getBook()); // выбираем книгу
        sleep();
        //bs.addToCollection();// добавляем в коллекцию
        //второй вариант
        //bs.searchBook(UserData.BOOK_NAME).selectBook(bs.getBook()).addToCollection();
        Assert.assertEquals(bs.getBookAddedMsg(), UserData.EXPECTED1);  // появляется сообщение и сравниваем с эталонным
        bs.addToCollection();
        Assert.assertEquals(bs.getBookAddedMsg(), UserData.EXPECTED2); //  проверим другое сообщение
    }
    @AfterMethod
    public void cleanUp(){
        ProfilePage profile = new ProfilePage(getDriver()); // каждый новый запуск будет происходить с чистого листа
        profile.deleteAllBooks();

    }
}
