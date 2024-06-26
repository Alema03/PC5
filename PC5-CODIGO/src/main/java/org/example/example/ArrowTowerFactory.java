package org.example.example;

public class ArrowTowerFactory implements TowerFactory {
    @Override
    public Tower createTower(int row, int col) {
        return new ArrowTower(row, col);
    }
}
