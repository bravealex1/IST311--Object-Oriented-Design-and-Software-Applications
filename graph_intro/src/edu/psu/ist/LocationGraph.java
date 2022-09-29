package edu.psu.ist;

import java.util.ArrayList;

import java.util.*;

public class LocationGraph {
    ArrayList<Vertex> vertices;
    private LinkedList<Integer> adj[]; //Adjacency Lists
    private ArrayList<Vertex> queue;
    static ArrayList<Vertex> nodes = new ArrayList<Vertex>();
    //private ST<String, SET<String>> st;


    public LocationGraph() {
        this.vertices = new ArrayList<>();
        //st = new ST<String, SET<String>>();
    }

    public boolean addLocation(String location) {
        // check if the vertex exists
        for (Vertex v: vertices) {
            if (v.name.equals(location)) {
                return false;
            }
        }

        Vertex toAdd = new Vertex(location);

        // add it to the graph
        this.vertices.add(toAdd);

        return true;
    }

    public boolean addDistance(String locationA, String locationB, Double distance) {
        // addDistance(String locationA, String locationB, Double distance): this should add an edge between the two locations,
        // if one of the locations doesn't exist, then add the location, return false if the edge already exists and true if it was successful

        if (this.containsName(locationA) && !this.containsName(locationB)) {
            this.addLocation(locationB);
        }

        if (!this.containsName(locationA) && this.containsName(locationB)) {
            this.addLocation(locationA);
        }

        for (Edge edge: this.getVertex(locationA).edges) {
            if (edge.vertex.name.equals(locationB)) {
                return false;
            }
        }

        // add the edge to both the vertices if the edge does not exist
        this.getVertex(locationA).edges.add(new Edge(distance, this.getVertex(locationB)));
        this.getVertex(locationB).edges.add(new Edge(distance, this.getVertex(locationA)));
        return true;
    }


    protected boolean containsName(String name) {
        return this.getVertex(name).equals(name);
    }

    public void BreadthFirstSearchExampleNeighbourList()
    {
        queue = new ArrayList<Vertex>();
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

    public double findDistanceBreadthFirst(String locationA, String locationB) {
       double distance = 0;
       return findDistanceBreadthFirst1(locationA, locationB, distance);
    }

    public double findDistanceBreadthFirst1 (String locationA, String locationB, double distance) {
        // store what you need to do next
        Vertex nextToVisit;
        // store how you got to what you need to do next
        ArrayList<Vertex> ho;
        // how much did it cost
        Double currentWeight;


        // instantiate queue
        Queue<Vertex> queue = new LinkedList<>();
        // instantiate visited list
        ArrayList<Vertex> visited = new ArrayList<>();
        int indexA = this.getIndexOfVertex(locationA);
        Vertex currentA = vertices.get(indexA);

        int indexB = this.getIndexOfVertex(locationB);
        Vertex currentB = vertices.get(indexB);


        for (Edge edge: currentA.edges) {
            if (!visited.contains(edge.vertex)) {
                queue.add(edge.vertex);
                visited.add(edge.vertex);
                distance = distance + edge.distance;
            }
        }
        return distance;
    }

    public void dfs(Vertex v)
    {
        System.out.print(v.data + " ");
        List<Vertex> neighbours = v.getNeighbours();
        v.visited = true;
        for (int i = 0; i < neighbours.size(); i++) {
            Vertex n = neighbours.get(i);
            if(n != null && !n.visited)
            {
                dfs(n);
            }
        }
    }

    public double findDistanceDepthFirst(String locationA, String locationB) {
        double distance = 0;
        return findDistanceBreadthFirst1(locationA, locationB, distance);
    }

    public double findDistanceDepthFirst1(String locationA, String locationB, double distance) {
        Stack<Vertex> stack= new Stack <Vertex>();
        stack.add(new Vertex(locationA));
        while (!stack.isEmpty())
        {
            Vertex element = stack.pop();
            if(!element.visited)
            {
                System.out.print(element.data + " ");
                element.visited = true;
            }

            List<Vertex> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Vertex n = neighbours.get(i);
                if( n!= null && !n.visited)
                {
                    stack.add(n);
                }
            }
        }
        return stack.capacity();
    }

    protected Vertex getVertex(String name) {
        for (Vertex toTest : this.vertices) {
            if (toTest.name.compareTo(name) == 0) {
                return toTest;
            }
        }
        return null;
    }

    public boolean detectCycle() {
        boolean result = false;

        //visited array
        ArrayList<Boolean> visited = new ArrayList<>();
        //boolean[] visited = new boolean[vertices];
        //do DFS, from each vertex
        for (int i = 0; i < vertices.size(); i++) {
            if (visited.get(i) == false) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return result;
    }

    public Boolean isCyclicUtil(int v, ArrayList<Boolean> visited, int parent) {
        // Mark the current node as visited
        visited.get(v);
        Integer i;

        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it =
                adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited.get(i)) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }

            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
//        for (String v : st) {
//            s.append(v + ": ");
//            for (String w : st) {
//                s.append(w + " ");
//            }
//            s.append('\n');
//        }
//        return s.toString();

        // A utility function to print the adjacency list
        // representation of graph
        GraphMatrix gm = new GraphMatrix(9);
        gm.printGraph();

//        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "", "A", "B", "C", "D", "Z"));
//        System.out.println(String.format("%s\t%d\t%d\t%d\t%d\t%d\n", "A", -1, 10, 7, -1, -1));
//        System.out.println(String.format("%s\t%d\t%d\t%d\t%d\t%d\n", "B", -1, 10, 7, -1, -1));
//        System.out.println(String.format("%s\t%d\t%d\t%d\t%d\t%d\n", "C", -1, 10, 7, -1, -1));
//        System.out.println(String.format("%s\t%d\t%d\t%d\t%d\t%d\n", "D", -1, 10, 7, -1, -1));
//        System.out.println(String.format("%s\t%d\t%d\t%d\t%d\t%d\n", "Z", -1, 10, 7, -1, -1));
        return adj.toString();
    }

    public String findMinimumPath(String locationA, String locationB) {
        return "A";
    }

    // use vertices and edges
}
