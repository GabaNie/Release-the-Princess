package game.kck.tile;

import game.kck.entity.Entity;
import game.kck.main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager extends Entity {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNumber[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[80];
        mapTileNumber = new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage(){
        try {
            tile[10]=new Tile();
            tile[10].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/road_up.png"));

            tile[11]=new Tile();
            tile[11].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/road_right.png"));


            tile[12]=new Tile();
            tile[12].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/corner_left_down.png"));

            tile[13]=new Tile();
            tile[13].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/corner_left_up.png"));

            tile[14]=new Tile();
            tile[14].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/corner_right_down.png"));

            tile[15]=new Tile();
            tile[15].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/corner_right_up.png"));

            tile[16]=new Tile();
            tile[16].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/shore_down.png"));

            tile[17]=new Tile();
            tile[17].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/shore_left.png"));

            tile[18]=new Tile();
            tile[18].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/shore_right.png"));

            tile[19]=new Tile();
            tile[19].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/shore_up.png"));

            tile[20]=new Tile();
            tile[20].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_left_down.png"));

            tile[21]=new Tile();
            tile[21].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_left_up.png"));

            tile[22]=new Tile();
            tile[22].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_right_down.png"));

            tile[23]=new Tile();
            tile[23].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_right_up.png"));

            tile[24]=new Tile();
            tile[24].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_right_1.png"));
            tile[24].collision = true;

            tile[27]=new Tile();
            tile[27].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_up_1.png"));
            tile[27].collision = true;


            tile[30]=new Tile();
            tile[30].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));

            tile[31]=new Tile();
            tile[31].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/bridge.png"));

            tile[32]=new Tile();
            tile[32].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tree1.png"));
            tile[32].collision = true;

            tile[33]=new Tile();
            tile[33].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tree2.png"));
            tile[33].collision = true;


            tile[34]=new Tile();
            tile[34].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/rock1.png"));
            tile[34].collision = true;

            tile[35]=new Tile();
            tile[35].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/rock2.png"));
            tile[35].collision = true;

            tile[36]=new Tile();
            tile[36].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sbu.png"));

            tile[37]=new Tile();
            tile[37].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sbd.png"));

            tile[40]=new Tile();
            tile[40].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/krzak.png"));
            tile[40].collision = true;

            tile[41]=new Tile();
            tile[41].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_1.png"));

            tile[42]=new Tile();
            tile[42].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_2.png"));

            tile[43]=new Tile();
            tile[43].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_3.png"));

            tile[44]=new Tile();
            tile[44].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_corner_4.png"));

            tile[45]=new Tile();
            tile[45].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sign.png"));
            tile[45].collision = true;

            tile[46]=new Tile();
            tile[46].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/end_road_1.png"));

            tile[47]=new Tile();
            tile[47].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/end_road_2.png"));





        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream("maps/mapa.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while(col<gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNumber[col][row]=num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e){

        }
    }

    public void  draw(Graphics2D g2)
    {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol< gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNumber[worldCol][worldRow];

            //CAMERA
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize>gp.player.worldX - gp.player.screenX && worldX - gp.tileSize< gp.player.worldX+screenX && worldY + gp.tileSize> gp.player.worldY - gp.player.screenY && worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol) {
                worldCol=0;
                worldRow++;
            }


        }

    }

}
