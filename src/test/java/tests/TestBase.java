package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase { //make abstract class
    WebDriver driver;

    @BeforeMethod
    public void init() {
        // Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\2 tel run\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();// Создаем экземпляр веб-драйвера Chrome
        driver.get("https://demoqa.com/login");// Открываем сайт
        driver.manage().window().maximize();  // Открываем окно браузера пошире
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait 5sec
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}



