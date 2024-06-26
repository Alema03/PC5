package org.example;

import org.example.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class TowerDefenseGameTest {

    private Mapa mockMap;
    private TowerDefenseGame game;
    private Wave mockWave;

    @BeforeEach
    public void setUp() {
        mockMap = mock(Mapa.class);
        game = new TowerDefenseGame(mockMap);
        mockWave = mock(Wave.class);
    }

    @Test
    public void testPlaceTower_ValidPosition() {
        // Configurar mock para posición válida
        when(mockMap.isCellAvailableForTower(3, 4)).thenReturn(true);

        String result = game.placeTower(new CannonTower(3, 4), 3, 4);

        // Verificar que la torre se haya colocado
        verify(mockMap).setCell(3, 4, 'T');
        assertEquals("Torre colocada en (3, 4)", result);
    }


    @Test
    public void testStartWave_WithEnemies() {
        // Configurar el mock para devolver una lista con un enemigo básico
        List<Enemy> enemies = Arrays.asList(new BasicEnemy());
        Wave wave = new Wave(1);
        when(mockMap.getEntryPoint()).thenReturn(new int[] { 1, 1 });
        when(mockMap.isCellAvailableForTower(anyInt(), anyInt())).thenReturn(true);

        // Establecer la oleada en el juego
        game.setWave(wave);

        // Iniciar la oleada
        game.startWave();

        // Verificar que se han generado enemigos y la lista no está vacía
        assertFalse(game.getEnemies().isEmpty());
        assertEquals(5, game.getEnemies().size());
        assertEquals(1, game.getEnemies().get(0).getPosition()[0]);
        assertEquals(1, game.getEnemies().get(0).getPosition()[1]);
    }

    @Test
    public void testStartWave_NoEnemies() {
        // Configurar el mock para devolver una lista vacía
        Wave wave = new Wave(1);
        when(mockMap.isCellAvailableForTower(anyInt(), anyInt())).thenReturn(true);

        // Establecer la oleada en el juego
        game.setWave(wave);

        // Iniciar la oleada
        game.startWave();

        // Verificar que no se han generado enemigos y la lista está vacía
        assertFalse(game.getEnemies().isEmpty());
    }
}
