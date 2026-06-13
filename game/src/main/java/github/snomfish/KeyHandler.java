package github.snomfish;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    
    private boolean upPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean downPressed;
    private boolean plusPressed;
    private boolean minusPressed;
    

    // GETTER
    public boolean upPressed() {return upPressed;}
    public boolean downPressed() {return downPressed;}
    public boolean leftPressed() {return leftPressed;}
    public boolean rightPressed() {return rightPressed;}
    public boolean plusPressed() {return plusPressed;}
    public boolean minusPressed() {return minusPressed;}

    
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
            case (KeyEvent.VK_EQUALS) -> plusPressed = true;
            case (KeyEvent.VK_MINUS) -> minusPressed = true;
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
            case (KeyEvent.VK_EQUALS) -> plusPressed = false;
            case (KeyEvent.VK_MINUS) -> minusPressed = false;
        }
    } 
}

