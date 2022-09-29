package edu.psu.ist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex addVertex(String name) {
        Vertex toAdd = new Vertex(name);
        this.vertices.add(toAdd);

        return toAdd;
    }

    public void addEdge(String startName, String endName, Double weight) {
        Vertex start;
        Vertex end;

        int index = this.getIndexOfVertex(startName);
        if (index >= 0) {
            start = this.vertices.get(index);
        } else {
            start = this.addVertex(startName);
        }

        index = this.getIndexOfVertex(endName);
        if (index >= 0) {
            end = this.vertices.get(index);
        } else {
            end = this.addVertex(endName);
        }

        start.edges.add(new Edge(weight, end));
        //end.edges.add(new Edge(weight, start));
    }

    public boolean isReachable(String startName, String endName) {

        // visited list
        ArrayList<Vertex> visited = new ArrayList<>();
        // get the queue
        Queue<Vertex> queue = new LinkedList<>();

        // get the index of the startName
        int index = this.getIndexOfVertex(startName);
        // add it to the queue
        queue.add(this.vertices.get(index));
        // add it to the visited
        visited.add(this.vertices.get(index));

        // while loop for queue is not empty
        while (!queue.isEmpty()) {
            // dequeue from the queue
            Vertex current = queue.remove();

            // check if we have found the end name
            if (current.name.equals(endName)) {
                return true;
            }

            // enqueue the children if not visited
            for (Edge edge : current.edges) {
                if (!visited.contains(edge.vertex)) {
                    queue.add(edge.vertex);
                    visited.add(edge.vertex);
                }
            }
        }

        // return false if we never find it (outside of the loop)
        return false;
    }

    protected boolean containsName(String name) {
        return this.getIndexOfVertex(name) >= 0;
    }

    protected int getIndexOfVertex(String name) {
        int index = 0;
        for (Vertex toTest : this.vertices) {
            if (toTest.name.compareTo(name) == 0) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public String toString() {
        StringBuilder a = new StringBuilder();
        a.append("List of vertices: ");

        for (Vertex v : vertices) {
            a.append(v.toString());
            a.append(",");
        }

        a.append("\n\n");

        for (Vertex v : vertices) {
            a.append("List of Vertex " + v + ": ");
            for (Edge e : v.edges) {
                a.append("[");
                a.append(v + ", ");
                a.append(e);
                a.append("] ");
            }
            a.append("\n");
        }
        return a.toString();
    }
}
