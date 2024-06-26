package org.example.example;

public interface ScoreRepository {
    void saveScore(String playerName, int score);
    int getScore(String playerName);
    void resetScore(String playerName);
}
