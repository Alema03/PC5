package org.example;

import org.example.example.Enemy;
import org.example.example.Tower;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class EnemyTowerInteractionTest {

    @Test
    public void testEnemyInteractionWithTower() {
        // Crear mocks de las clases Enemy y Tower
        Enemy mockEnemy = mock(Enemy.class);
        Tower mockTower = mock(Tower.class);

        // Definir comportamiento de los mocks
        when(mockEnemy.getHealth()).thenReturn(100);
        when(mockTower.getDamage()).thenReturn(50);

        // Crear una lista de enemigos
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mockEnemy);

        // Simular interacción: la torre ataca a los enemigos
        mockTower.attack(enemies);

        // Verificar que la torre atacó a los enemigos
        verify(mockTower).attack(enemies);
    }
}
