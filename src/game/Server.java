package game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Server {
    private int numClient = 0;
    private static final ArrayList<Socket> sockets = new ArrayList<>();
    private final int secretNumber;

    private boolean gameIsOn;

    Server(){
        this.secretNumber = new Random().nextInt() * 100;
        this.gameIsOn = true;
    }


    public void run() {
        try {
            ServerSocket s_server = new ServerSocket(123);
            while (this.gameIsOn) {
                Socket s = s_server.accept();
                ++numClient;
                sockets.add(s);
                new Repartiteur(s, numClient).run();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
