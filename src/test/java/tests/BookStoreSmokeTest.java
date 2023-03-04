package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStoreLoginPage;
import pages.BookStorePage;
import pages.ProfilePage;

import static java.awt.SystemColor.text;

public class BookStoreSmokeTest extends TestBase {

    @Test
    public void smokeTest() { //вызываем страницу за страницей
        BookStoreLoginPage loginPage = new BookStoreLoginPage(driver); //логин
        ProfilePage profile = loginPage.login(); //тут profilepage
        BookStorePage bs = profile.goToBookStore(); // bookstore
        //  bs. реализация методо

       // String text = bs.getAlertText();
        Assert.assertEquals(text, "Book already present in the your collection!");

    }
}
