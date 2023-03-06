package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Main Item 2')]")
    WebElement mainItem;

    @FindBy(xpath = "//a[contains(text(),'SUB SUB LIST »')]")
    WebElement subMenu1;

    @FindBy(xpath = "//a[contains(text(),'Sub Sub Item 2')]")
    WebElement subMenu2;


    private String mainItemText, subMenu1Text, subMenu2Text;

    public MenuPage hoverOverMenu() { // наведите курсор на меню
        Actions actions = new Actions(getDriver());

        actions.moveToElement(mainItem).perform();//наведение курсора и находит с помощью Xpath
        System.out.println(mainItem.getText());// выводит на консоль
        mainItemText = mainItem.getText();//м.б. выполнена проверка на соответствие ожидаемого результата фактическому.
        sleep();
        actions.moveToElement(subMenu1).perform();
        System.out.println(subMenu1.getText());
        subMenu1Text = subMenu1.getText();
        sleep();
        actions.moveToElement(subMenu2).perform();
        System.out.println(subMenu2.getText());
        subMenu2Text = subMenu2.getText();
        sleep();
        return this;
    }

    public String getMainItemText() { //getter возвращают значение переменной
        return mainItemText;
    }

    public String getSubMenu1Text() {
        return subMenu1Text;
    }

    public String getSubMenu2Text() {
        return subMenu2Text;
    }

}
