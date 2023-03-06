package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.awt.SystemColor.text;

public class SelectMenuPage extends PageBase {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]") // css-1wa3eu0-placeholder
    WebElement multiSelect;

    @FindBy(xpath = "//html") //пустое любое место на странице
    WebElement space;

    public SelectMenuPage multiSelectDropdown(String text) {
        clickWithJSExecutor(multiSelect, 0, 300); // search
        //особый метод формирование строки %s строка (%d-числовой)указывается вторым аргументом т.е. сами можем отдельно прописать
        WebElement element = getDriver().findElement(By.xpath(String.format("//div[text()='%s']", text)));
        click(element);
        sleep();
        click(space);
        return this;
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldStyleMenu;

    public SelectMenuPage oldStyleMenu(String text) { // метод кот. принимает текст как аргумент
        Select select = new Select(oldStyleMenu); //.ui.Select класс подтягиваем
        select.selectByVisibleText(text); // есть выбор из выпадающ. списка text=параметр из списка
        sleep();
        System.out.println(select.getFirstSelectedOption().getText());// какой метод из списка был выбран
        sleep();
        System.out.println("******");
        List<WebElement> options = select.getOptions();//если мы не знаем что в списке, то данным способом
        for (WebElement element :   //пробираем весь список и нужное выдаём
                options) {
            System.out.println(element.getText());
        }
        System.out.println("******");

        return this;
    }

    @FindBy(css = ".css-xb97g8") //поиск деселекта маленький крестик
    WebElement deselect;

    public SelectMenuPage deselect() {//click deselect
        click(deselect);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    // метод для ручного вбивания в dropbox
    public SelectMenuPage MultiSelectDropDown(String text1, String text2, String text3) {
        inputSelect.sendKeys(text1); //отправляет последовательность символов в это поле
        inputSelect.sendKeys(Keys.ENTER);
        sleep();
        inputSelect.sendKeys(text2);
        inputSelect.sendKeys(Keys.ENTER);
        sleep();
        inputSelect.sendKeys(text3);
        inputSelect.sendKeys(Keys.ENTER);
        sleep();
        click(space);
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public SelectMenuPage standardMultiSelect() {
        Select multi = new Select(cars);
        if (multi.isMultiple()) { //выбор элемента по индексу
            multi.selectByIndex(1);//с второй и третий
            multi.selectByIndex(2);
        }
        sleep();
        List<WebElement> list = multi.getAllSelectedOptions();//получить список кот.были выбраны
        for (WebElement car :
                list) {
            System.out.println(car.getText());
        }
        return this;
    }
}

