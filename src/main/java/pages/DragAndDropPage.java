package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;


    public DragAndDropPage actionDragMe(){ //экземпляр класса
        Actions actions=new Actions(getDriver());//метод и передаем ему драйвер
        actions.dragAndDrop(dragMe,dropHere).perform(); //говорим ему ЧТО dragMe и КУДА(dropHere) перетаскиваем
        String text = dropHere.getText(); // далее должен появиться текст(getTExt) мы этот текст извлекаем
        System.out.println(text); //и печатаем в консоли
        return this;
    }

//второй вариан
    public DragAndDropPage actionDragBy() { //экземпляр класса
        Actions actions = new Actions(getDriver()); //метод и драйвер
        int xOffset = dragMe.getLocation().getX(); // текущее положение getLocation() это точка далее координаты по Х
        int yOffset = dragMe.getLocation().getY();
        System.out.println("x=" + xOffset + " y=" + yOffset); // распечатали координаты
        int xoffset1 = dropHere.getLocation().getX(); // коодринаты другого квадрата
        int yoffset1 = dropHere.getLocation().getY();

        xoffset1 = (xoffset1 - xOffset) + 20; //посчитать на сколько нам нужно сдвинуть координаты
        yoffset1 = (yoffset1 - yOffset) + 30;
        System.out.println("x=" + xoffset1  + " y=" + yoffset1);
        sleep();
        actions.dragAndDropBy(dragMe, xoffset1, yoffset1).perform();// этот метод перетаскивает по конкретным координатам

        System.out.println(dropHere.getText());
        return this;
    }

    //третий вариант
    public DragAndDropPage actionDragByIndex(int x, int y){// тут надо знать заранее координаты
        Actions actions = new Actions(getDriver());
        actions.dragAndDropBy(dragMe,x,y).perform();
        sleep();
        return this;

    }
}
