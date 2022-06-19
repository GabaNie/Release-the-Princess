package game.kck.main;

import java.awt.*;

public class UserInterface {

    GamePanel gp;
    Font arial_40;
    int showCom=0;

    public UserInterface(GamePanel gp){
        this.gp=gp;
        arial_40 = new Font("Arial",Font.ROMAN_BASELINE,40);
    }

    public void draw(Graphics2D g2){
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawString("Znalezione Klucze:  "+ gp.player.howManyKeys,50 ,50);
        if(gp.player.howManyKeys==1)
        {
            g2.drawImage(gp.toShowKey1(), 50, 50, 80, 80,null);
        }
        if(gp.player.howManyKeys==2)
        {
            g2.drawImage(gp.toShowKey1(), 50, 50, 80, 80, null);
            g2.drawImage(gp.toShowKey2(), 150, 50, 80, 80, null);
            g2.drawString("Maszeruj do zamku!  ", 650, 200);
        }

        if(gp.player.howManyKeys<2){
            if(gp.player.touchingCastle==1) {
                g2.drawString("Znajdź resztę kluczy!  ", 650, 200);
            }
        }

    }
}
