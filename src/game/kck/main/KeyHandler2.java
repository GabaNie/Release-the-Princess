package game.kck.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler2 extends KeyHandler {
    public KeyHandler2() {
    }

    @Override
    public void keyTyped(KeyEvent key) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        int code= key.getKeyCode();
        if(code==KeyEvent.VK_UP){
            upPressed=true;
        }
        if(code==KeyEvent.VK_DOWN){
            downPressed=true;
        }
        if(code==KeyEvent.VK_LEFT){
            leftPressed=true;
        }
        if(code==KeyEvent.VK_RIGHT){
            rightPressed=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
        int code= key.getKeyCode();
        if(code==KeyEvent.VK_UP){
            upPressed=false;
        }
        if(code==KeyEvent.VK_DOWN){
            downPressed=false;
        }
        if(code==KeyEvent.VK_LEFT){
            leftPressed=false;
        }
        if(code==KeyEvent.VK_RIGHT){
            rightPressed=false;
        }
    }
}
