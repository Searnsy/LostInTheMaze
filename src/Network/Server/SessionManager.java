package Network.Server;

import Model.GameManager;
import Model.Player;
import Model.ViewListener;

public class SessionManager {
    private GameManager waitingGame;

    public SessionManager() {
        waitingGame = new GameManager();
    }

    public synchronized ViewListener addToGame(Player player) {
        GameManager game = waitingGame;
        if(waitingGame.addPlayer(player)) {
            waitingGame = new GameManager();
        }
        return game;
    }
}
