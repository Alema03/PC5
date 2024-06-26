package org.example;

import org.example.example.Enemy;
import org.example.example.EnemyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class EnemyTowerFactoryTest {

    @Test
    public void testEnemyFactory() {
        // Crear un mock de EnemyFactory
        EnemyFactory enemyFactory = mock(EnemyFactory.class);

        // Crear un mock de Enemy
        Enemy basicEnemy = mock(Enemy.class);

        // Definir el comportamiento del mock de Enemy
        when(basicEnemy.getSpeed()).thenReturn(1);
        when(basicEnemy.getHealth()).thenReturn(100);
        when(basicEnemy.getReward()).thenReturn(10);

        // Definir el comportamiento del mock de EnemyFactory
        when(enemyFactory.createEnemy()).thenReturn(basicEnemy); // Configurar sin argumentos

        // Crear un enemigo usando el mock de EnemyFactory
        Enemy createdEnemy = enemyFactory.createEnemy(); // Invocar sin argumentos

        // Verificar las características del enemigo creado
        assertEquals(1, createdEnemy.getSpeed());
        assertEquals(100, createdEnemy.getHealth());
        assertEquals(10, createdEnemy.getReward());

        // Verificar que el método createEnemy fue llamado una vez
        verify(enemyFactory, times(1)).createEnemy();
    }
}
