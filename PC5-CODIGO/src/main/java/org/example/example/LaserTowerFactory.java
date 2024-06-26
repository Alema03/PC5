package org.example.example;

public class LaserTowerFactory implements TowerFactory {
    @Override
    public Tower createTower(int row, int col) {
        return new LaserTower(row, col);
    }
}
