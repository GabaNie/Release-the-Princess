package game.kck.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Zamek extends SuperObject{

    public Zamek(){
        name = "Zamek";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/zamek.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;

    }
}
