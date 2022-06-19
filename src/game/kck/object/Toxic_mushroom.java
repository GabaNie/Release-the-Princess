package game.kck.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Toxic_mushroom extends SuperObject{

    public Toxic_mushroom(){
        name = "Toxic_mushroom";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/poison.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}