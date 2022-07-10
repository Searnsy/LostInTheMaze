package Network.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            SessionManager manager = new SessionManager();
            while(true) { // Add a new client
                Socket socket = serverSocket.accept();
                ModelWriter modelWriter = new ModelWriter(socket);
                modelWriter.setViewListener(manager.addToGame(modelWriter));
            }
        } catch (IOException e) {
            System.err.println("Couldn't host the server on port " + port);
            System.exit(1);
        }
    }
}
