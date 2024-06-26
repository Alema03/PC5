package org.example;

import org.example.example.Enemy;
import org.example.example.EnemyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StubEnemyTest {

    @Test
    public void testStubsForEnemyFactory() {
        // Crear un mock de EnemyFactory
        EnemyFactory enemyFactory = mock(EnemyFactory.class);

        // Crear un mock de Enemy
        Enemy stubEnemy = mock(Enemy.class);
        when(stubEnemy.getSpeed()).thenReturn(1);
        when(stubEnemy.getHealth()).thenReturn(100);
        when(stubEnemy.getReward()).thenReturn(10);

        // Definir el comportamiento del mock de EnemyFactory
        when(enemyFactory.createEnemy()).thenReturn(stubEnemy);

        // Crear un enemigo usando el stub de EnemyFactory
        Enemy createdEnemy = enemyFactory.createEnemy();

        // Verificar las características del enemigo creado
        assertEquals(1, createdEnemy.getSpeed());
        assertEquals(100, createdEnemy.getHealth());
        assertEquals(10, createdEnemy.getReward());
    }
}