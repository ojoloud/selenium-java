package extend;

import extend.pages.DragAndDrop;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends BaseTest {
public static final String url = "https://jqueryui.com/droppable/";
    @Test
    public void dragAndDropTest() {
        DragAndDrop.PageBuilder.newInstance().go(url);
        DragAndDrop.dragAndDrop(DragAndDrop.dragElement, DragAndDrop.dragInTo);
    }
    @Test
    public void returnToMainPageTest() {
        DragAndDrop.PageBuilder.newInstance().returnContextBack();

    }
}
