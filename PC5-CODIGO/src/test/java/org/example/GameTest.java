package org.example;

import org.example.example.Enemy;
import org.example.example.Tower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameTest {

    @Test
    public void testEnemyTowerInteraction() {
        // Creamos los mocks
        Enemy mockEnemy = mock(Enemy.class);
        Tower mockTower = mock(Tower.class);

        // Definimos el comportamiento esperado
        when(mockEnemy.getHealth()).thenReturn(200);
        when(mockTower.getDamage()).thenReturn(75);

        // Verificamos la interacción entre objetos
        int enemyHealth = mockEnemy.getHealth();
        int towerDamage = mockTower.getDamage();

        assertEquals(200, enemyHealth);
        assertEquals(75, towerDamage);

        // Verificamos que se llamaron los métodos esperados
        verify(mockEnemy, times(1)).getHealth();
        verify(mockTower, times(1)).getDamage();
    }
}
