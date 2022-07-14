package Model;

public class ItemUse {
    Position position;
    Item item;
    Direction direction;

    public ItemUse(Item item) {
        this.item = item;
    }

    public ItemUse(Position position, Item item) {
        this.position = position;
        this.item = item;
    }

    public ItemUse(Position position, Item item, Direction direction) {
        this.position = position;
        this.item = item;
        this.direction = direction;
    }
}
