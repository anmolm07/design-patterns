package design.practice.chess.player;

import java.util.ArrayList;
import java.util.List;

public class PlayersList {
    private static final List<Player> players = new ArrayList<>();

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static List<Player> getPlayers() {
        return players;
    }


}
