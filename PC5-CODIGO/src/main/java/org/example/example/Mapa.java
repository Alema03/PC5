package org.example.example;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private final char[][] map;
    private final int[] entryPoint;
    private final List<int[]> path; // Añadir el camino

    public Mapa() {
        this.map = new char[][]{
                {' ', ' ', ' ', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {' ', ' ', ' ', 'C', 'B'},
                {' ', ' ', 'C', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };
        this.entryPoint = new int[]{0, 0}; // Definir el punto de entrada
        this.path = generatePath(); // Generar el camino
    }

    // Verifica si una celda específica del mapa está disponible para colocar una torre
    public boolean isCellAvailableForTower(int row, int col) {
        return map[row][col] == ' ';
    }

    // Permite establecer un valor en una celda específica del mapa
    public void setCell(int row, int col, char value) {
        map[row][col] = value;
    }

    // Permite la visualización del mapa en la consola
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char cell : row) {
                sb.append("[").append(cell).append("]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Método para obtener el punto de entrada
    public int[] getEntryPoint() {
        return entryPoint;
    }

    // Método para generar el camino
    private List<int[]> generatePath() {
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{0, 0});
        path.add(new int[]{0, 1});
        path.add(new int[]{0, 2});
        path.add(new int[]{1, 2});
        path.add(new int[]{2, 2});
        path.add(new int[]{2, 3});
        path.add(new int[]{2, 4});
        return path;
    }

    // Método para obtener el camino
    public List<int[]> getPath() {
        return path;
    }
}
