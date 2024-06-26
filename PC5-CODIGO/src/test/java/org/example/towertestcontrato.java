package org.example;

import org.example.example.Enemy;
import org.example.example.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TowerTest {

    private Tower tower;

    @BeforeEach
    public void setUp() {
        tower = new Tower(10, 5, 1, 0, 0);
    }

    @Test
    public void testConstructorPreconditions() {
        assertThrows(AssertionError.class, () -> new Tower(-1, 5, 1, 0, 0));
        assertThrows(AssertionError.class, () -> new Tower(10, -1, 1, 0, 0));
        assertThrows(AssertionError.class, () -> new Tower(10, 5, -1, 0, 0));
        assertThrows(AssertionError.class, () -> new Tower(10, 5, 1, -1, 0));
        assertThrows(AssertionError.class, () -> new Tower(10, 5, 1, 0, -1));
    }

    @Test
    public void testSetDamage() {
        tower.setDamage(20);
        assertEquals(20, tower.getDamage());
        assertThrows(AssertionError.class, () -> tower.setDamage(-1));
    }

    @Test
    public void testSetRange() {
        tower.setRange(10);
        assertEquals(10, tower.getRange());
        assertThrows(AssertionError.class, () -> tower.setRange(-1));
    }

    @Test
    public void testSetFireRate() {
        tower.setFireRate(2);
        assertEquals(2, tower.getFireRate());
        assertThrows(AssertionError.class, () -> tower.setFireRate(-1));
    }

    @Test
    public void testSetPosition() {
        tower.setPosition(2, 3);
        assertArrayEquals(new int[]{2, 3}, tower.getPosition());
        assertThrows(AssertionError.class, () -> tower.setPosition(-1, 3));
        assertThrows(AssertionError.class, () -> tower.setPosition(2, -1));
    }

    @Test
    public void testAttack() {
        Enemy enemyInRange = new Enemy(100, 1, 0, 3);
        Enemy enemyOutOfRange = new Enemy(100, 10, 10, 10);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(enemyInRange);
        enemies.add(enemyOutOfRange);

        tower.attack(enemies);
        assertEquals(90, enemyInRange.getHealth());
        assertEquals(100, enemyOutOfRange.getHealth());
    }
}
