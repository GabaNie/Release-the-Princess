package game.kck.main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket ss;
    private int numPlayers;
    private ServerSideConnection player1;
    private ServerSideConnection player2;

    public Server(){
        System.out.println("----Game Server-----");
        try{
            ss= new ServerSocket(51734);
            numPlayers=0;
        }catch (IOException ex){
            System.out.println("IOExeception from Server");
        }
    }

    public void acceptConnections(){
        try{
            System.out.println("Waiting for connections...");
            while (numPlayers<2){
                Socket s=ss.accept();
                numPlayers++;
                System.out.println("Player #"+ numPlayers);
                ServerSideConnection ssc= new ServerSideConnection(s,numPlayers);
                if(numPlayers==1){
                    player1=ssc;
                }else {
                    player2=ssc;
                }
                Thread t= new Thread(ssc);
                t.start();
            }
            System.out.println("we now have 2 players.");
        }catch (IOException ex){
            System.out.println("IOException");
        }
    }

    private class ServerSideConnection implements Runnable{

        private Socket socket;
        private BufferedReader dataIn;
        private PrintWriter dataOut;
        public int playerID;

        public ServerSideConnection(Socket s, int id){
            socket=s;
            playerID=id;
            try{
                dataIn= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dataOut= new PrintWriter(socket.getOutputStream(),true);
                System.out.println(dataIn.readLine());
                dataOut.println("hallo client");
                System.out.println(playerID);
                dataOut.println(playerID);

            }catch (IOException ex){
                System.out.println("IOException from constructor");
            }

        }
        public void run(){
            System.out.println("run");
            try{
                dataOut.write("hallo");
                dataOut.flush();

                while (true){
                    if(playerID==1){
                        String s=dataIn.readLine();
                        System.out.println(s);
                        //int player1ButtonNum=dataIn.readInt();
                        //System.out.println("P1 clicked #"+player1ButtonNum);
                        //player2.sendButtonNum(player1ButtonNum);
                        //player2.sendButtonNum(s);
                    }else {
                        String s=dataIn.readLine();
                        System.out.println(s);
                       // int player2ButtonNum=dataIn.readInt();
                        //System.out.println("P2 clicked #"+player2ButtonNum);
                        //player1.sendButtonNum(player2ButtonNum);
                       // player1.sendButtonNum(s);
                    }
                }
                //player1.closeConnection();
                //player2.closeConnection();
            }catch (IOException ex){
                System.out.println("IOException from run()");
            }
        }
        public void sendButtonNum(String s){
            dataOut.write(s);
            dataOut.flush();
        }
        public void closeConnection(){
            try{
                socket.close();
                System.out.println("----Connenction closed-----");
            }catch (IOException ex){
                System.out.println("IOException connection close");
            }
        }
    }

    public static void main(String[]args){
        Server gs= new Server();
        gs.acceptConnections();
    }



}





