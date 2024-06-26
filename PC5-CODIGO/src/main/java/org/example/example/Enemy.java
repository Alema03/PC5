package org.example.example;

import java.util.List;


public class Enemy {
    protected int speed;
    protected int health;
    protected int reward;
    protected int[] position; // Añadir posición

    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
        this.position = new int[]{0, 0}; // Inicialmente en el inicio del camino
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public int getReward() {
        return reward;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    // Método para mover al enemigo basado en su velocidad
    public void move(List<int[]> path) {
        int currentPosIndex = path.indexOf(position);
        if (currentPosIndex + speed < path.size()) {
            position = path.get(currentPosIndex + speed);
        } else {
            position = path.get(path.size() - 1); // Alcanza el final del camino
        }
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int getPositionX() {
        if (position != null && position.length > 0) {
            return position[0];
        } else {
            return 0;
        }
    }

    public int getPositionY() {
        if (position != null && position.length > 1) {
            return position[1];
        } else {
            return 0;
        }
    }
}
