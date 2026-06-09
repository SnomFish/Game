package game.src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    
    private Boolean upPressed     = false;
    private Boolean leftPressed   = false;
    private Boolean rightPressed  = false;
    private Boolean downPressed   = false;
    

    // GETTER
    public Boolean upPressed() {return upPressed;}
    public Boolean downPressed() {return downPressed;}
    public Boolean leftPressed() {return leftPressed;}
    public Boolean rightPressed() {return rightPressed;}

    
    @Override
    public void keyTyped(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch(code) {
            case (KeyEvent.VK_UP) -> upPressed = true;
            case (KeyEvent.VK_DOWN) -> downPressed = true;
            case (KeyEvent.VK_LEFT) -> leftPressed = true;
            case (KeyEvent.VK_RIGHT) -> rightPressed = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case (KeyEvent.VK_UP) -> upPressed = false;
            case (KeyEvent.VK_DOWN) -> downPressed = false;
            case (KeyEvent.VK_LEFT) -> leftPressed = false;
            case (KeyEvent.VK_RIGHT) -> rightPressed = false;
        }
    } 
}
