package game.kck.main;

import javax.swing.*;
import java.net.*;
import java.io.*;

public class Player1 {

    public String playerID;
    private int otherPlayer;
    private boolean buttonEnable;

    public ClientSideConnection csc;

    public Player1(){

        //width=w;
        //height=h;
    }
    public void connectToServer(){
        csc= new ClientSideConnection();
    }
    public class ClientSideConnection{
        private Socket socket;
        private  BufferedReader dataIn;
        private PrintWriter dataOut;

        public ClientSideConnection(){
            System.out.println("----Client-----");
            try{
                socket= new Socket("localhost", 51734);
                dataIn= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dataOut= new PrintWriter(socket.getOutputStream(),true);
                dataOut.println("hello server");
                System.out.println(dataIn.readLine());
                playerID= dataIn.readLine();
                System.out.println(playerID);
            }catch (IOException ex){
                System.out.println("IO Exception from CSC");
            }
        }
        public String sendMessage(String msg) {
            dataOut.println(msg);
           String resp = null;
           /*  try {
                resp = dataIn.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            return resp;
        }
        public void stopConnection() {
            try {
                dataIn.close();
                dataOut.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }}
    public static void main(String[] args){
        Player1 p1=new Player1();
        p1.connectToServer();
        //p1.setUpGUI();
        //p1.setUpButton();
        // String response = p1.csc.sendMessage("hello server");
        // System.out.println(response);
        System.out.println(p1.playerID);
        GamePanel game= new GamePanel(p1);
        Main main= new Main(game);
    }

}




