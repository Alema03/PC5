package org.example;

import org.example.example.BasicEnemy;
import org.example.example.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyTest {

    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        enemy = new BasicEnemy();
    }

    @Test
    public void testTakeDamage() {
        enemy.takeDamage(30);
        assertEquals(70, enemy.getHealth());
    }

    @Test
    public void testTakeDamage_Overkill() {
        enemy.takeDamage(150);
        assertEquals(0, enemy.getHealth());
    }

    @Test
    public void testMove() {
        List<int[]> path = Arrays.asList(new int[]{1, 1}, new int[]{2, 2});
        enemy.move(path);
        assertArrayEquals(new int[]{1, 1}, enemy.getPosition());
    }

    @Test
    public void testMove_EndOfPath() {
        List<int[]> path = Arrays.asList(new int[]{0, 0}, new int[]{1, 1});
        enemy.move(path);
        enemy.move(path);
        assertArrayEquals(new int[]{1, 1}, enemy.getPosition());
    }
}
