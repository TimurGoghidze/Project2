package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.LoginPage;
@Ignore
public class LoginPageTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        logger.info("Starting login test");
        LoginPage myLoginPage =  new LoginPage(getDriver());//входим на страницу
        ContactsPage contactsPage = myLoginPage.login("TimurTest", "TimurTest1!"); //логинимся и задаём параметры входа
        sleep();
        Assert.assertEquals(contactsPage.getBooks().getText(),"Books :"); //так ли это,проверка

        logger.info("Finished login test");

    }
}
