package Model;

import Network.Server.ModelWriter;

public class Player implements ModelListener, ViewListener {

    private ModelWriter modelWriter;

    private String name;
    private int team;

    private Position position;
    private int hp;
    private Item[] items;

    public Player(ModelWriter modelWriter) {
        this.modelWriter = modelWriter;
    }

    public Player(String name, int team) {
        this.name = name;
        this.team = team;

        // team 0 starts at (0,0), team 1 starts at (9,9)
        this.position = new Position(0,0);  // TODO starting position

        items = new Item[2];
        items[0] = Item.NONE;
        items[1] = Item.NONE;

        int hp = 2;
    }

    void useItem(Item item, int item_x, int item_y) {
        if(items[0] == item) {
            items[0] = items[1];
            items[1] = Item.NONE;
        }
        else if(items[1] == item) {
            items[1] = Item.NONE;
        }

        switch(item) {
        }
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
