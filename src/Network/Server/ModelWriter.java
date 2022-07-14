package Network.Server;

import Model.ModelListener;

import java.net.Socket;

public class ModelWriter implements ModelListener {
    private Socket socket;
    private ViewListener viewListener;

    public ModelWriter(Socket socket) {
        this.socket = socket;
    }

    void setViewListener(ViewListener viewListener) {
        this.viewListener = viewListener;
    }
}
