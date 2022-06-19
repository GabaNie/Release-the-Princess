package game.kck.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler1 extends KeyHandler {

    public KeyHandler1() {
    }

    @Override
    public void keyTyped(KeyEvent key) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        int code= key.getKeyCode();
        if(code==KeyEvent.VK_W){
            upPressed=true;
        }
        if(code==KeyEvent.VK_S){
            downPressed=true;
        }
        if(code==KeyEvent.VK_A){
            leftPressed=true;
        }
        if(code==KeyEvent.VK_D){
            rightPressed=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
        int code= key.getKeyCode();
        if(code==KeyEvent.VK_W){
            upPressed=false;
        }
        if(code==KeyEvent.VK_S){
            downPressed=false;
        }
        if(code==KeyEvent.VK_A){
            leftPressed=false;
        }
        if(code==KeyEvent.VK_D){
            rightPressed=false;
        }
    }
}
