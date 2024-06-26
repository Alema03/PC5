package org.example.example;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private int waveNumber;
    private List<Enemy> enemies;

    public Wave(int waveNumber) {
        this.waveNumber = waveNumber;
        this.enemies = generateEnemies(waveNumber);
    }

    private List<Enemy> generateEnemies(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < waveNumber * 5; i++) {
            enemies.add(new BasicEnemy());
        }
        if (waveNumber % 5 == 0) {
            enemies.add(new BossEnemy());
        }
        return enemies;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Enemy> spawnEnemies(Mapa map) {
        for (Enemy enemy : enemies) {
            enemy.setPosition(map.getEntryPoint());
        }
        return enemies;
    }
}
