package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase { //make abstract class

    private WebDriver driver; // при этом перестает быть доступным по прямым полям
    private String url;

    static Logger logger = LoggerFactory.getLogger(TestBase.class);//for logs
public WebDriver getDriver(){ // теперь будет вызываться метод getter
    return driver;
}

public void setUrl(String url){this.url =url;} //setter for url

    @BeforeMethod
    public void init() {
        // Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\2 tel run\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();// Создаем экземпляр веб-драйвера Chrome
        driver.get(url);// Открываем сайт
        driver.manage().window().maximize();  // Открываем окно браузера пошире
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait 5sec
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
    public static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



