package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTests extends TestBase {
    @BeforeSuite
    public void setUpInternal() {
        super.setUrl("https://demoqa.com/droppable");
    }

    @Test
    public void dragAndDropTest(){
        DragAndDropPage dd = new DragAndDropPage(getDriver());
        dd.actionDragMe();
    }
    @Test
    public void dragAndDropByTest(){//второго способа по координатам
        DragAndDropPage dd = new DragAndDropPage(getDriver());
        dd.actionDragBy();
    }


    @Test
    public void dragAndDropByTest2(){//третий способ по известным координатам   x=598 y=422
        DragAndDropPage dd = new DragAndDropPage(getDriver());
        dd.actionDragByIndex(296,22);

    }
}
