package org.example.example;

public class Player {
    private int score;
    private int baseHealth;

    public Player() {
        this.score = 0;
        this.baseHealth = 100; // Salud inicial de la base
    }

    public int getScore() {
        return score;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public void deductBaseHealth(int damage) {
        this.baseHealth -= damage;
        if (this.baseHealth < 0) {
            this.baseHealth = 0; // La salud de la base no puede ser negativa
        }
    }

    public void updateScoreAndHealth(Enemy enemy, boolean defeated) {
        if (defeated) {
            addScore(enemy.getReward());
        } else {
            deductBaseHealth(enemy.getReward());
        }
    }
}
