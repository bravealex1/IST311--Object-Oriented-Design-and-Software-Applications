package edu.psu.ist;

public class Node {
    Node left;
    Node right;
    Album data;

    public Node (Album data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Album getData() {
        return data;
    }

    public void setData(Album data) {
        this.data = data;
    }
}
