package Model;

import java.util.Random;

public enum Item {
    KNIFE,
    GRENADE,
    LASER,
    TRACKER_BOTS,
    X_RAY,
    TRIP_WIRE,
    PORTABLE_WALL,
    JETPACK,
    MEDKIT,
    NONE;

    public static Item randomItem(Random random) {
        int rand = random.nextInt(10);
        switch (rand) {
            case 0:
                return KNIFE;
            case 1:
                return GRENADE;
            case 2:
                return LASER;
            case 3:
                return TRACKER_BOTS;
            case 4:
                return X_RAY;
            case 5:
                return TRIP_WIRE;
            case 6:
                return PORTABLE_WALL;
            case 7:
                return JETPACK;
            case 8:
                return MEDKIT;
            default:
                return NONE;
        }
    }
}
