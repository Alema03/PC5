package org.example.example;

public class BasicEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new BasicEnemy();
    }
}

