package org.example.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Mapa map;
    private Player player;
    private List<Wave> waves;
    private int currentWaveNumber;
    private List<Tower> towers;

    public Game() {
        this.map = new Mapa();
        this.player = new Player();
        this.waves = new ArrayList<>();
        this.currentWaveNumber = 0;
        this.towers = new ArrayList<>();
    }

    // Método para procesar comandos del usuario
    public String processCommand(String command) {
        String[] parts = command.split(" ");

        if (parts.length == 0) {
            return "Comando inválido";
        }

        String action = parts[0].toUpperCase();

        switch (action) {
            case "PLACE_TOWER":
                return placeTower(parts);
            case "START_WAVE":
                return startWave();
            default:
                return "Comando no reconocido";
        }
    }

    // Método para colocar una torre en el mapa
    private String placeTower(String[] parts) {
        if (parts.length < 4) {
            return "Comando PLACE_TOWER incompleto";
        }

        String towerType = parts[1];
        int row = Integer.parseInt(parts[2]);
        int col = Integer.parseInt(parts[3]);

        TowerFactory towerFactory = createTowerFactory(towerType);

        if (towerFactory == null) {
            return "Tipo de torre desconocido";
        }

        if (!map.isCellAvailableForTower(row, col)) {
            return "No se puede colocar una torre en (" + row + ", " + col + ")";
        }

        // Colocar la torre en el mapa
        Tower tower = towerFactory.createTower(row, col);
        towers.add(tower);
        map.setCell(row, col, 'T'); // 'T' para representar la torre en el mapa

        return "Torre " + towerType + " colocada en (" + row + ", " + col + ")";
    }

    // Método para iniciar una nueva oleada de enemigos
    private String startWave() {
        currentWaveNumber++;
        Wave wave = new Wave(currentWaveNumber);
        waves.add(wave);

        // Generar y colocar enemigos en el mapa
        wave.spawnEnemies(map);

        // Simular el progreso de la oleada y actualizar la puntuación
        simulateWaveProgress(wave);

        StringBuilder output = new StringBuilder();
        output.append("Oleada ").append(currentWaveNumber).append(" iniciada\n");
        output.append("Enemigos en camino...\n");

        return output.toString() + "\n" + getGameState();
    }

    // Método para simular el progreso de la oleada y actualizar la puntuación
    private void simulateWaveProgress(Wave wave) {
        for (Enemy enemy : wave.getEnemies()) {
            // Simular el movimiento del enemigo
            enemy.move(map.getPath());
            if (Math.random() > 0.5) { // Simulación simple de derrota de enemigo
                player.updateScoreAndHealth(enemy, true);
            } else {
                player.updateScoreAndHealth(enemy, false);
            }
        }

        for (Tower tower : towers) {
            tower.attack(wave.getEnemies());
        }
    }

    // Método para obtener el estado completo del juego
    private String getGameState() {
        StringBuilder gameState = new StringBuilder();
        gameState.append("Estado del juego:\n");
        gameState.append("Mapa:\n");
        gameState.append(map.toString()).append("\n");
        gameState.append("Puntuación: ").append(player.getScore()).append("\n");
        gameState.append("Vida de la base: ").append(player.getBaseHealth()).append("\n");
        return gameState.toString();
    }

    // Método para crear una fábrica de torres según el tipo especificado
    private TowerFactory createTowerFactory(String towerType) {
        switch (towerType.toUpperCase()) {
            case "CANNON":
                return new CannonTowerFactory();
            case "LASER":
                return new LaserTowerFactory();
            case "SNIPER":
                return new SniperTowerFactory();
            case "ARROW":
                return new ArrowTowerFactory();
            default:
                return null;
        }
    }


    public static void main(String[] args) {
        Game game = new Game();

        // Ejemplos de comandos de entrada
        String[] commands = {
                "PLACE_TOWER Cannon 3 4",
                "PLACE_TOWER Sniper 2 2",
                "START_WAVE"
        };

        for (String command : commands) {
            System.out.println("Entrada: " + command);
            String output = game.processCommand(command);
            System.out.println("Salida:\n" + output);
            System.out.println("-----------------------");
        }
    }
}
