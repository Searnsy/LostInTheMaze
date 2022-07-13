package Model;

public class Player {
    private int team;
    private int[] items;
    private int x;
    private int y;
    private int hp;

    public Player(int team) {
        // team 0 starts at (0,0), team 1 starts at (9,9)
        int x = 9 * team;
        int y = 9 * team;

        items = new int[2];
        items[0] = 0;
        items[1] = 0;

        int hp = 2;
    }

    void useItem(int item, int item_x, int item_y) {
        if(items[0] == item) {
            items[0] = items[1];
            items[1] = 0;
        }
        else if(items[1] == item) {
            items[1] = 0;
        }

        switch(item) {
            case 1: //

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case  9:
                break;
        }
    }
}
