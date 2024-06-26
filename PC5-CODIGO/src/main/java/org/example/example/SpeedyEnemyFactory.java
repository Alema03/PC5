package org.example.example;

public class SpeedyEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new SpeedyEnemy();
    }
}
