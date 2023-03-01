package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.LoginPage;

public class LoginPageTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        LoginPage myLoginPage =  new LoginPage(driver);//входим на страницу
        ContactsPage contactsPage = myLoginPage.login("TimurTest", "TimurTest1!"); //логинимся и задаём параметры входа
        sleep();
        Assert.assertEquals(contactsPage.getBooks().getText(),"Books :"); //так ли это,проверка


    }
}
