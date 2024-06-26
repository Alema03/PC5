package org.example.example;

public class SniperTowerFactory implements TowerFactory {
    @Override
    public Tower createTower(int row, int col) {
        return new SniperTower(row, col);
    }
}
