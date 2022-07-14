package Network.Server;

import Model.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            SessionManager sessionManager = new SessionManager();
            while(true) { // Add a new client
                Socket socket = serverSocket.accept();
                ModelWriter modelWriter = new ModelWriter(socket);
                Player player = new Player(modelWriter);
                player.requestName();
                modelWriter.setViewListener(sessionManager.addToGame(player));
            }
        } catch (IOException e) {
            System.err.println("Couldn't host the server on port " + port);
            System.exit(1);
        }
    }
}
