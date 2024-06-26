package org.example.example;

import java.util.HashMap;
import java.util.Map;

public class ScoreDatabaseFake {
    private Map<String, Integer> scores = new HashMap<>();

    public void addScore(String player, int score) {
        scores.put(player, score);
    }

    public int getScore(String player) {
        return scores.getOrDefault(player, 0);
    }

    public void saveScore(String player, int score) {
        scores.put(player, score);
    }

    public void resetScore(String player) {
        scores.put(player, 0);
    }
}
