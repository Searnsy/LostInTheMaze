package Network.Server;

public class SessionManager {
    private GameManager waitingGame;

    public SessionManager() {
        waitingGame = new GameManager();
        waitingGame.initGame();
    }

    public synchronized ViewListener addToGame(ModelListener modelListener) {
        GameManager game = waitingGame;
        if(waitingGame.addModelListener(modelListener)) {
            waitingGame = new GameManager();
        }
        return game;
    }

    private class GameManager implements ViewListener {
        public void initGame() {

        }
        public boolean addModelListener(ModelListener modelListener) {
            return false;
        }
    }
}
