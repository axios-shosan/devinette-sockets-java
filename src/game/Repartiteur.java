package game;

import java.io.*;
import java.net.Socket;

public class Repartiteur extends Thread {
    private Socket socket;
    private int numClient;
    Repartiteur(Socket socket, int numClient){
        super();
        this.socket = socket;
        this.numClient = numClient;
        this.run();
    }

    public void run() {
     try {
         InputStream inputStream = socket.getInputStream();
         InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
         BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
         OutputStream outputStream = socket.getOutputStream();
         PrintWriter printWriter = new PrintWriter(outputStream);

         printWriter.println("Bienvenu: vous etre le client num " +  numClient);
         System.out.println("Connexion du client " + numClient);
         System.out.println("@IP= " + socket.getRemoteSocketAddress());
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
    }
}
