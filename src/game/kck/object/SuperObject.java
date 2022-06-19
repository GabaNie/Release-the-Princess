package game.kck.object;

import game.kck.main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,160,160);
    public int solidAreaDefaultX =0;
    public int solidAreaDefaultY =0;


    public void draw(Graphics2D g2, GamePanel gp,int i){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        if(i!=5) {
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
        }
        if(i==5)
        {
            if (worldX + 640 > gp.player.worldX - gp.player.screenX && worldX - 640 < gp.player.worldX + screenX && worldY + 640 > gp.player.worldY - gp.player.screenY && worldY - 640 < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(image, screenX+60, screenY, 640, 640, null);
            }
        }
    }
}
