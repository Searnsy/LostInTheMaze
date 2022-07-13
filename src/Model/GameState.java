package Model;

import java.util.ArrayList;
import java.util.Random;

public class GameState {
    private Board board;
    private ArrayList<Player> red_team;
    private ArrayList<Player> blue_team;
    private boolean is_red_turn;
    private Random random;

    public GameState() {
        board = new Board("board.txt");
        red_team = new ArrayList<>();
        blue_team = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
        is_red_turn = random.nextBoolean();
    }

    public void addPlayer(Player p) {
        if(is_red_turn) {
            red_team.add(p);
        }
        else {
            blue_team.add(p);
        }
        is_red_turn = !is_red_turn;
    }

    public void playGame() {
        boolean game_over = false;
        while(!game_over) {
            ArrayList<Player> cur_team;
            if(is_red_turn) {
                cur_team = red_team;
            }
            else {
                cur_team = blue_team;
            }
            ArrayList<Integer> moves = rollForMoves(cur_team);
            waitForMoves(cur_team);
            waitForActions(cur_team);
            applyActions(cur_team);
            rollForItems(cur_team);

            game_over = checkGameEnd();
            is_red_turn = !is_red_turn;
        }
    }

    private ArrayList<Integer> rollForMoves(ArrayList<Player> players){return new ArrayList<>();}
    private void waitForMoves(ArrayList<Player> players){}
    private void waitForActions(ArrayList<Player> players){}
    private void applyActions(ArrayList<Player> players){}
    private void rollForItems(ArrayList<Player> players){}
    private boolean checkGameEnd(){return true;}


}
