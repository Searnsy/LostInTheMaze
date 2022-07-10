package Network.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected to " + address + ":" + port);

            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        } catch(IOException e) {
            System.out.println(e);
        }

        String line = "";
        while(!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
