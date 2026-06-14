package github.snomfish.ui;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class UIContainer {
    

    private List<UIElement> container = new ArrayList<>();


    public UIContainer() {
        UIText fpsTracker = new UIFpsTracker();
        container.add(fpsTracker);
    }


    public List<UIElement> getContainer() {return container;}
    public void setContainer(List<UIElement> container) {this.container = container;}
    public boolean has(UIElement element) {return container.contains(element);}
    public void add(UIElement element) {container.add(element);}


    public void update() {
        for (UIElement element : container) {
            element.update();
        }
    }


    public void render(Graphics2D g2) {
        for (UIElement element : container) { // completely ignores the concept of layers lmao
            element.render(g2);
        }
    }
}
