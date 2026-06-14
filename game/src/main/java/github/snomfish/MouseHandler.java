package github.snomfish;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import github.snomfish.camera.Camera;

public class MouseHandler extends MouseAdapter {
    

    private final Camera camera;

    private int mouseX;
    private int mouseY;
    private boolean leftPressed;
    private boolean middlePressed;
    private boolean rightPressed;


    // CONSTRUCTOR
    public MouseHandler(
        Camera camera
    ) {
        this.camera = camera;
    }


    // TOSTRING
    @Override
    public String toString() {
        return 
            "(" + mouseX + ", " + mouseY + "), " +
            "left: " + (leftPressed ? "true" : "false") + ", " +
            "middle: " + (middlePressed ? "true" : "false") + ", " +
            "right: " + (rightPressed ? "true" : "false");
    }


    // GETTERS
    public int getMouseX() {return mouseX;}
    public int getMouseY() {return mouseY;}
    public boolean leftPressed() {return leftPressed;}
    public boolean middlePressed() {return middlePressed;}
    public boolean rightPressed() {return rightPressed;}


    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int buttonPressed = e.getButton();

        switch (buttonPressed) {
            case MouseEvent.BUTTON1 -> leftPressed = true;
            case MouseEvent.BUTTON2 -> middlePressed = true;
            case MouseEvent.BUTTON3 -> rightPressed = true;
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        int buttonPressed = e.getButton();

        switch (buttonPressed) {
            case MouseEvent.BUTTON1 -> leftPressed = false;
            case MouseEvent.BUTTON2 -> middlePressed = false;
            case MouseEvent.BUTTON3 -> rightPressed = false;
        }
    }
}

