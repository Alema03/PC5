package org.example.example;

public class CannonTowerFactory implements TowerFactory {
    @Override
    public Tower createTower(int row, int col) {
        return new CannonTower(row, col);
    }
}
