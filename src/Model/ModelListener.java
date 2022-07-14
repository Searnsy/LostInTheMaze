package Model;

import java.util.Map;

public interface ModelListener {

    /**
     * Update the game status: waiting, start, victory
     *
     * @param status the status of the game
     */
    public void statusChange(GameStatus status);

    /**
     * Sends the values of all dice rolled for movement.
     *
     * @param rollMap A map from player name to movement rolls.
     */
    public void announceMovementRolls(Map<String, Integer> rollMap);

    /**
     * Update the positions of all players on your team
     *
     * @param positionMap a map from player name to position
     */
    public void updateTeamLocation(Map<String, Position> positionMap);

    /**
     * Announce the actions taken by all players of the currently acting team.
     *
     * @param actionMap a map from player name to action taken
     */
    public void announcePlayerActions(Map<String, ItemUse> actionMap);

    /**
     * Updates the hp of all players in the game
     *
     * @param hpMap a map from player name to HPs
     */
    public void updatePlayerHealth(Map<String, Integer> hpMap);

    public void announcePlayerItems(Map<String, Item> playerItems);



}
