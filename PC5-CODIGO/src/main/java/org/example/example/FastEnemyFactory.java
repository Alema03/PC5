package org.example.example;

public class FastEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new FastEnemy();
    }
}

