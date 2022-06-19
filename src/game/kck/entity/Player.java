package game.kck.entity;

import game.kck.main.GamePanel;
import game.kck.main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyHandler;
    public int howManyKeys = 0;

    public final int screenX;
    public final int screenY;

    public int touchingCastle = 0;

    public  Player(GamePanel gamePanel, KeyHandler keyHandler){
        this.gp = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        solidArea = new Rectangle();
        solidArea.x=50;
        solidArea.y=100;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width=60;
        solidArea.height=60;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 8;
        worldY = gp.tileSize * 40;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImage()
    {
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/8.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/9.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/2.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/7.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/6.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/4.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/5.png"));
           steady = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/3.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyHandler.upPressed==true)
        {
            direction = "up";
        }
        else if(keyHandler.downPressed==true)
        {
            direction = "down";
        }
        else if(keyHandler.rightPressed==true)
        {
            direction = "right";
        }
        else if(keyHandler.leftPressed==true)
        {
            direction = "left";
        }
        else
        {
            direction = "steady";
        }

        //checking collison
        collisionOn=false;
        gp.collisionCheck.checkTile(this);

        //collision of objects
        int objIndex = gp.collisionCheck.checkObject(this,true);
        pickUpObject(objIndex);

        //collision, can move
        if(collisionOn == false)
        {
            switch (direction){
                case "up":
                    worldY-=speed;
                    break;
                case "down":
                    worldY+=speed;
                    break;
                case "left":
                    worldX-=speed;
                    break;
                case "right":
                    worldX+=speed;
                    break;

            }
        }

        spriteCounter++;
        if(spriteCounter>16){
            if(spriteNum==1)
            {
                spriteNum=2;
            }
            else if(spriteNum==2)
            {
                spriteNum=1;
            }
            spriteCounter=0;
        }

    }

    public void pickUpObject (int i){
        if(i!=999){

            String objName = gp.obj[i].name;

            switch(objName){
                case "Key1":
                    howManyKeys++;
                    gp.obj[i] = null;
                    touchingCastle=0;
                    break;
                case "Key2":
                    howManyKeys++;
                    gp.obj[i] = null;
                    touchingCastle=0;
                    break;
                case "Zamek":
                    if(howManyKeys==2){
                        System.out.println("Wygrałeś");
                    }
                    else {
                        touchingCastle=1;
                    }
            }
            System.out.println(howManyKeys);
        }

    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch(direction){
            case "up":
                if(spriteNum==1) {
                    image = up1;
                }
                if(spriteNum==2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum==1) {
                    image = down1;
                }
                if(spriteNum==2){
                    image = down2;
                }
                break;
            case "right":
                if(spriteNum==1) {
                    image = right1;
                }
                if(spriteNum==2){
                    image = right2;
                }
                break;
            case "left":
                if(spriteNum==1) {
                    image = left1;
                }
                if(spriteNum==2){
                    image = left2;
                }
                break;
            case "steady":
                image = steady;
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize,null);
    }
}
