package org.example.example;

import java.util.ArrayList;
import java.util.List;

class Path {
    private final List<int[]> path;

    public Path() {
        this.path = new ArrayList<>();
        // Añadir las coordenadas del camino
        path.add(new int[]{0, 1});
        path.add(new int[]{1, 1});
        path.add(new int[]{2, 1});
        path.add(new int[]{2, 2});
        path.add(new int[]{2, 3});
        path.add(new int[]{3, 3});
        path.add(new int[]{4, 3});
    }

    public List<int[]> getPath() {
        return path;
    }
}

