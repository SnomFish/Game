package github.snomfish.ui;

import java.awt.Font;
import java.awt.Graphics2D;

import github.snomfish.GamePanel;

public class UIFpsTracker extends UIText {
        

    private static final String FLAVOUR_TEXT = "fps: ";


    public UIFpsTracker () {
        super(50, 50, FLAVOUR_TEXT + GamePanel.trueFPS);
    }


    @Override
    public void update() {
        text = FLAVOUR_TEXT + GamePanel.trueFPS;
    }


    @Override
    public void render(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString(text, x, y);
    }
}
