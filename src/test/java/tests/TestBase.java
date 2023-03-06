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

    public void setUrl(String url) {
        this.url = url;
    } //setter for url

    @BeforeMethod
    public void init() {
        // Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\2 tel run\\chromedriver\\chromedriver.exe");
        setDriver(new ChromeDriver());// Создаем экземпляр веб-драйвера Chrome
        getDriver().get(url);// Открываем сайт
        getDriver().manage().window().maximize();  // Открываем окно браузера пошире
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait 5sec
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        getDriver().quit();
    }

    public static void sleep() {//method sleep
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public WebDriver getDriver() { //getter
        return driver;
    }

    public void setDriver(WebDriver driver) { //setter
        this.driver = driver;
    }
}



