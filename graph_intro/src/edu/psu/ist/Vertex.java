package edu.psu.ist;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    String name;
    ArrayList<Edge> edges;
    int data;
    boolean visited;
    List<Vertex> neighbours;

    void Vertex(int data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbours(Vertex neighbourNode) {
        this.neighbours.add(neighbourNode);
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }

    public Vertex (String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }


    @Override
    public String toString() { return name; }
}
