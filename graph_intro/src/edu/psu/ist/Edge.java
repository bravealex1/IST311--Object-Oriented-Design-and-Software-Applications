package edu.psu.ist;

import java.util.ArrayList;

public class Edge {
    // the edge points to this vertex
    Vertex vertex;
    Double distance;

    public Edge (Double weight, Vertex vertex) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return vertex.name +
                ", distance = " + distance;
    }
}
