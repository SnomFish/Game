package github.snomfish.ui;

import java.awt.Graphics2D;

public abstract class UIText extends UIElement {
    

    protected String text;


    public UIText(
        int x,
        int y,
        String text
    ) {
        this.x = x;
        this.y = y;
        this.text = text;
    }


    public String getText() {return text;}


    public void setText(String text) {this.text = text;}


    @Override
    public abstract void update();


    @Override
    public abstract void render(Graphics2D g2);
}
