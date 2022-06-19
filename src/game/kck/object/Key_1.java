package game.kck.object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Key_1 extends SuperObject{

    public Key_1(){
        name = "Key1";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key1.png"));
            }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;

    }

}
