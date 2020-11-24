package main.java.com.benjaminsimon.monopoly_helper;

import java.util.*;

public class PlayerManager {

    private HashSet<Player> players = new LinkedHashSet<>();

    public PlayerManager(LinkedHashSet<Player> playersIn){
        this.players = playersIn;
    }

    public PlayerManager() {
        this(new LinkedHashSet<>());
    }

    public Player addPlayer(Player player) {
        return players.add(player) ? player : null;
    }

    public Player removePlayer(Player player) {
        return players.remove(player) ? player : null;
    }

    public List<Player> sortPlayersByName() {
        return sortPlayersByName(false);
    }

    public List<Player> sortPlayersByName(boolean reverse) {
        List<Player> result = new LinkedList<>(players);

        Comparator<Player> comparator = Comparator.comparing(Player::getName);

        if(reverse)
            comparator = comparator.reversed();

        result.sort(comparator);

        return result;
    }

    public List<Player> sortPlayersByMoney() {
       return sortPlayersByMoney(false);
    }

    public List<Player> sortPlayersByMoney(boolean reverse) {
        List<Player> result = new LinkedList<>(players);

        Comparator<Player> comparator = Comparator.comparing(Player::getAmmount);
        if(reverse)
            comparator = comparator.reversed();

        result.sort(comparator);

        return result;
    }

    public Player getPlayerByColor(String color) {
        for (Player currentPlayer : players) {
            if (currentPlayer.getDisplayColor().equals(color))
                return currentPlayer;
        }

        return null;
    }

    public Player getPlayerByName(String name) {
        for (Player currentPlayer : players) {
            if (currentPlayer.getName().equals(name))
                return currentPlayer;
        }

        return null;
    }

    public HashSet<Player> getPlayers() {
        return players;
    }
}
