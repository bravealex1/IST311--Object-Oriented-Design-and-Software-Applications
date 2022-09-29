package edu.psu.ist;

public class Node {
    Node previous;
    Album data;
    Node next;

    public Node (Album data) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
}
}
