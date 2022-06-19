package game.kck.main;

import game.kck.object.Key_1;
import game.kck.object.Key_2;
import game.kck.object.Toxic_mushroom;
import game.kck.object.Zamek;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new Key_1();
        gp.obj[0].worldX = 7 * gp.tileSize;
        gp.obj[0].worldY = 32 * gp.tileSize;

        gp.obj[1] = new Key_2();
        gp.obj[1].worldX = 9 * gp.tileSize;
        gp.obj[1].worldY = 9 * gp.tileSize;

        gp.obj[2] = new Toxic_mushroom();
        gp.obj[2].worldX = 12 * gp.tileSize;
        gp.obj[2].worldY = 45* gp.tileSize;

        gp.obj[3] = new Toxic_mushroom();
        gp.obj[3].worldX = 35 * gp.tileSize;
        gp.obj[3].worldY = 44* gp.tileSize;

        gp.obj[4] = new Toxic_mushroom();
        gp.obj[4].worldX = 17 * gp.tileSize;
        gp.obj[4].worldY = 11 * gp.tileSize;

        gp.obj[5] = new Zamek();
        gp.obj[5].worldX = 50 * gp.tileSize;
        gp.obj[5].worldY = 10 * gp.tileSize;
        gp.obj[5].solidArea.width=640;
        gp.obj[5].solidArea.height=640;
    }

}
