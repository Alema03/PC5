package org.example;

import org.example.example.BasicEnemy;
import org.example.example.CannonTower;
import org.example.example.Enemy;
import org.example.example.Tower;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TowerTest {

    @Test
    public void testAttack_EnemyInRange() {
        List<Enemy> enemies = Arrays.asList(new BasicEnemy());
        int[] pos= {2,2};
        enemies.get(0).setPosition(pos);
        Tower tower = new CannonTower(2,1);
        tower.setPosition(2, 1);
        tower.attack(enemies);
        // Verificar que el enemigo ha recibido daño esperado
        assertEquals(50, enemies.get(0).getHealth());
    }

    @Test
    public void testAttack_EnemyOutOfRange() {
        List<Enemy> enemies = Arrays.asList(new BasicEnemy());
        int[] pos= {5,5};
        enemies.get(0).setPosition(pos);
        Tower tower = new CannonTower(2,1);
        tower.setPosition(2, 1);
        tower.attack(enemies);
        // Verificar que el enemigo no ha recibido daño
        assertEquals(100, enemies.get(0).getHealth());
    }
}

