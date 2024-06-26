package org.example.example;

import java.util.ArrayList;
import java.util.List;

public class TowerDefenseGame {
    private Mapa map;
    private List<Tower> towers;
    private List<Enemy> enemies;
    private Wave currentWave;


    public TowerDefenseGame(Mapa map) {
        this.map = map;
        this.towers = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public String placeTower(Tower tower, int row, int col) {
        if (map.isCellAvailableForTower(row, col)) {
            map.setCell(row, col, 'T'); // 'T' para representar la torre en el mapa
            towers.add(tower);
            return "Torre colocada en (" + row + ", " + col + ")";
        } else {
            return "Posición inválida para la torre en (" + row + ", " + col + ")";
        }
    }

    public void setWave(Wave mockWave) {
        this.currentWave = mockWave;
    }

    public void startWave() {
        List<Enemy> spawnedEnemies = currentWave.spawnEnemies(map);
        enemies.addAll(spawnedEnemies);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
