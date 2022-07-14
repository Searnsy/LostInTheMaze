package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameState {
    private Board board;
    private ArrayList<Player> red_team;
    private ArrayList<Player> blue_team;
    private ArrayList<Player> all_players;
    private boolean is_red_turn;
    private Random random;

    private HashMap<String, Position> player_position_updates;
    private HashMap<String, ItemUse> player_action_updates;

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
        all_players.add(p);
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

            // Roll Dice + Apply Movements
            HashMap<String, Integer> rollMoveMap = rollForMoves(cur_team);
            for(Player player : all_players) {
                player.announceMovementRolls(rollMoveMap);
            }

            waitForMoves(cur_team);
            for(Player player : cur_team) {
                player.updateTeamLocation(player_position_updates);
            }
            player_position_updates.clear();

            waitForActions(cur_team);
            for(Player player : all_players) {
                player.announcePlayerActions(player_action_updates);
            }

            HashMap<String, Integer> player_hps = applyActions(all_players);
            for(Player player : all_players) {
                player.updatePlayerHealth(player_hps);
            }
            player_action_updates.clear();

            HashMap<String, Item> rollItemMap = rollForItems(cur_team);
            for(Player player : all_players) {
                player.announcePlayerItems(rollItemMap);
            }

            game_over = checkGameEnd();
            is_red_turn = !is_red_turn;
        }
    }

    private HashMap<String, Integer> rollForMoves(ArrayList<Player> cur_team) {
        HashMap<String, Integer> rollMap = new HashMap<>();
        for(Player player : cur_team) {
            int roll = random.nextInt(5);
            rollMap.put(player.getName(), roll);
        }
        return rollMap;
    }

    private synchronized void waitForMoves(ArrayList<Player> cur_team) {
        try {
            while(player_position_updates.size() < cur_team.size()) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public synchronized boolean checkPositionUpdate(Player player, Position position) {
        // TODO validate path is possible
        player.setPosition(position);
        player_position_updates.put(player.getName(), position);
        notify();
        return true;
    }

    private void waitForActions(ArrayList<Player> cur_team) {
        try {
            while(player_action_updates.size() < cur_team.size()) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public synchronized boolean checkItemUse(Player player, ItemUse itemUse) {
        player_action_updates.put(player.getName(), itemUse);
        notify();
        return true;
    }

    private HashMap<String, Integer>  applyActions(ArrayList<Player> players) {
        for (String player_name : player_action_updates.keySet()) {
            // TODO apply action
            // apply action
        }
        HashMap<String, Integer> player_hps = new HashMap<>();
        for (Player player : all_players) {
            player_hps.put(player.getName(), player.getHP());
        }
        return player_hps;
    }

    private HashMap<String, Item> rollForItems(ArrayList<Player> cur_team) {
        HashMap<String, Item> rollMap = new HashMap<>();
        for(Player player : cur_team) {
            rollMap.put(player.getName(), Item.randomItem(random));
        }
        return rollMap;
    }

    private boolean checkGameEnd(){return true;}


}
