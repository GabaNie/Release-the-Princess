package game.kck.main;

import game.kck.entity.Player;
import game.kck.object.SuperObject;
import game.kck.tile.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{

    //Screen settings
    final int originalTileSize = 160;
    final int scaleOfTile = 1;

    public final int tileSize= originalTileSize * scaleOfTile; //320x320 game.kck.tile.Tile v1
    public final int maxScreenCol = 10;
    public final int maxScreenRow = 6;
    public final int screenWidth = tileSize * maxScreenCol; //1920
    public final int screenHeight = tileSize * maxScreenRow; //960
    final int FPS = 60;

    //WORLD SETTINGS
    public final int maxWorldCol = 61;
    public final int maxWorldRow = 55;

    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler;
    Thread gameThread;
    public CollisionCheck collisionCheck = new CollisionCheck(this);
    public AssetSetter assetSetter= new AssetSetter(this);
    public UserInterface ui = new UserInterface(this);
    public Player player;
    public SuperObject obj[] = new SuperObject[10];
    public Player1 player_css;

    public GamePanel(Player1 player_css){
        System.out.println(screenWidth);
        System.out.println(screenHeight);
        this.player_css=player_css;
        keyHandler=new KeyHandler1();
        player= new Player(this,keyHandler);
        /*
        if(player_css.playerID.equals("1")){
            System.out.println("player 1");
            keyHandler=new KeyHandler1();
            player= new Player(this,keyHandler);
        }
        else {
            keyHandler=new KeyHandler2();
            player= new Player(this,keyHandler);
        }*/
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //rendering performance
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setUpGame(){
        assetSetter.setObject();
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime()+drawInterval;
        while(gameThread != null)
        {
            long currentTime = System.nanoTime();
            //update
            update();

            //draw
            repaint();
            try{
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;

            if(remainingTime < 0){
                remainingTime = 0;
            }

                Thread.sleep((long) remainingTime);

                nextDrawTime+=drawInterval;
            }catch(InterruptedException e) {
            e.printStackTrace();;
            }
        }

    }

    public void update()
    {
        player.update();
        String s=String.valueOf(player.worldX)+" "+ String.valueOf(player.worldY);
        System.out.println(s);
        player_css.csc.sendMessage(s);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // super ->JPanel
        Graphics2D g2 = (Graphics2D)g;
        tileManager.draw(g2);
        for(int i=0;i<obj.length;i++){
            if(obj[i]!=null){
                obj[i].draw(g2,this,i);
            }
        }
        player.draw(g2);
        ui.draw(g2);
        g2.dispose();
    }

    public BufferedImage toShowKey1() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage toShowKey2() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
