package edu.psu.ist;

public class Main {

    public static void main(String[] args) {
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "", "A", "B", "C", "D", "Z"));
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "A", -1, 10, 7, -1, -1));
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "B", -1, 10, 7, -1, -1));
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "C", -1, 10, 7, -1, -1));
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "D", -1, 10, 7, -1, -1));
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "Z", -1, 10, 7, -1, -1));

        // have a string builder

        // I would just go through all the vertices and do the first row
        // A B C D Z \n

        // initialize a has / map / dictionary and the keys are the vertices and the initial value is -1
        // for each vertex
        // add vertex name to string builder
        // A
        // for each edge of that vertex
        // populate the weight of the dictionary
        // get the weight, if there is no weight for a vertex say -1
        // -1 10 7 -1 -1 \n

        LocationGraph withoutCycle = new LocationGraph();
        LocationGraph withCycle = new LocationGraph();

        // Populate withoutCycle with locations
        withoutCycle.addLocation("A");
        withoutCycle.addLocation("B");
        withoutCycle.addLocation("C");
        withoutCycle.addLocation("D");
        withoutCycle.addLocation("E");

        // Populate withCycle with locations
        withCycle.addLocation("A");
        withCycle.addLocation("B");
        withCycle.addLocation("C");
        withCycle.addLocation("D");
        withCycle.addLocation("E");

        // Add edges to withoutCycle
        withoutCycle.addDistance("A", "B", 4.0);
        withoutCycle.addDistance("A", "C", 10.0);
        withoutCycle.addDistance("B", "C", 4.0);
        withoutCycle.addDistance("B", "D", 8.0);
        withoutCycle.addDistance("C", "E", 10.0);
        withoutCycle.addDistance("C", "D", 10.0);
        withoutCycle.addDistance("E", "D", 4.0);

        // Add edges to withCycle
        withCycle.addDistance("A", "B", 6.0);
        withCycle.addDistance("B", "C", 4.0);
        withCycle.addDistance("B", "D", 8.0);
        withCycle.addDistance("D", "C", 10.0);
        withCycle.addDistance("C", "E", 10.0);
        withCycle.addDistance("E", "D", 4.0);

        // Find distance breadthFirst()
        withoutCycle.findDistanceBreadthFirst("A", "E");
        withoutCycle.findDistanceBreadthFirst("B", "E");
        withoutCycle.findDistanceBreadthFirst("D", "A");

        withCycle.findDistanceBreadthFirst("A", "E");
        withCycle.findDistanceBreadthFirst("B", "E");
        withCycle.findDistanceBreadthFirst("D", "A");

        // Find distance depthFirst()
        withoutCycle.findDistanceDepthFirst("A", "E");
        withoutCycle.findDistanceDepthFirst("B", "E");
        withoutCycle.findDistanceDepthFirst("D", "A");

        withCycle.findDistanceDepthFirst("A", "E");
        withCycle.findDistanceDepthFirst("B", "E");
        withCycle.findDistanceDepthFirst("D", "A");

        // Detect cycle
        withoutCycle.detectCycle();
        withCycle.detectCycle();

        // String representation of each graph
        System.out.println(withoutCycle);
        System.out.println(withCycle);

        // Extra Credit: findMinimumPath()
        withoutCycle.findMinimumPath("A", "E");
        withoutCycle.findMinimumPath("B", "E");
        withoutCycle.findMinimumPath("D", "A");

        withCycle.findMinimumPath("A", "E");
        withCycle.findMinimumPath("B", "E");
        withCycle.findMinimumPath("D", "A");
    }
}
