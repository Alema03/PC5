package org.example.example;

import java.util.List;

public class Tower {
    private int damage; // cantidad de daño
    private int range; // número de celdas de alcance
    private int fireRate; // turnos entre disparos
    private int[] position; // posición de la torre

    // Constructor
    public Tower(int damage, int range, int fireRate, int row, int col) {
        assert damage >= 0 : "Damage must be non-negative";
        assert range >= 0 : "Range must be non-negative";
        assert fireRate >= 0 : "Fire rate must be non-negative";
        assert row >= 0 : "Row position must be non-negative";
        assert col >= 0 : "Column position must be non-negative";

        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.position = new int[]{row, col};

        assert this.damage == damage;
        assert this.range == range;
        assert this.fireRate == fireRate;
        assert this.position[0] == row && this.position[1] == col;
    }

    // Getters y setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        assert damage >= 0 : "Damage must be non-negative";
        this.damage = damage;
        assert this.damage == damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        assert range >= 0 : "Range must be non-negative";
        this.range = range;
        assert this.range == range;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        assert fireRate >= 0 : "Fire rate must be non-negative";
        this.fireRate = fireRate;
        assert this.fireRate == fireRate;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        assert x >= 0 : "X position must be non-negative";
        assert y >= 0 : "Y position must be non-negative";
        this.position[0] = x;
        this.position[1] = y;
        assert this.position[0] == x && this.position[1] == y;
    }

    // Método para atacar a los enemigos dentro de su alcance
    public void attack(List<Enemy> enemies) {
        assert enemies != null : "Enemies list must not be null";
        for (Enemy enemy : enemies) {
            if (isInRange(enemy)) {
                enemy.takeDamage(damage);
                break; // Ataca al primer enemigo en alcance
            }
        }
    }

    // Verifica si un enemigo está dentro del alcance de la torre
    private boolean isInRange(Enemy enemy) {
        assert enemy != null : "Enemy must not be null";
        assert enemy.getPosition() != null : "Enemy position must not be null";
        int[] enemyPos = enemy.getPosition();
        int dx = enemyPos[0] - position[0];
        int dy = enemyPos[1] - position[1];
        return dx * dx + dy * dy <= range * range;
    }
}
