package game.kck.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key_2 extends SuperObject{

    public Key_2(){
        name = "Key2";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}