package edu.psu.ist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    public void testIsReachable() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("G");
        graph.addVertex("Z");

        graph.addEdge("A", "B", 1.0);
        graph.addEdge("A", "C", 1.0);
        graph.addEdge("A", "E", 1.0);
        graph.addEdge("C", "E", 1.0);
        graph.addEdge("C", "F", 1.0);
        graph.addEdge("E", "D", 1.0);
        graph.addEdge("E", "A", 1.0);
        graph.addEdge("F", "G", 1.0);
        graph.addEdge("G", "A", 1.0);

        assertTrue(graph.isReachable("A", "G"));
        assertFalse(graph.isReachable("A", "Z"));
    }

    @Test
    public void testAddVertex() {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("Z");

        assertEquals("A", graph.vertices.get(0).toString());
        assertEquals(7, graph.vertices.size());
    }

    @Test
    public void testAddEdge() {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        assertEquals(4, graph.vertices.size());
        graph.addEdge("A", "E", 98.9);
        assertEquals(5, graph.vertices.size());
    }

    @Test
    public void testGetContains() {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        assertEquals(true, graph.containsName("A"));
        assertEquals(false, graph.containsName("R"));
    }

    @Test
    public void testGetIndex() {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        assertEquals(3, graph.getIndexOfVertex("D"));
        assertEquals(-1, graph.getIndexOfVertex("Z"));
    }

    @Test
    public void testToString() {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "D", 12.9);
        System.out.println(graph.toString());
    }

}