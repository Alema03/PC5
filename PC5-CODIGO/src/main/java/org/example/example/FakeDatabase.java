package org.example.example;

import java.util.HashMap;
import java.util.Map;

public class FakeDatabase {
    private Map<String, Integer> scores = new HashMap<>();

    public void saveScore(String playerName, int score) {
        scores.put(playerName, score);
    }

    public int getScore(String playerName) {
        return scores.getOrDefault(playerName, 0);
    }
}
