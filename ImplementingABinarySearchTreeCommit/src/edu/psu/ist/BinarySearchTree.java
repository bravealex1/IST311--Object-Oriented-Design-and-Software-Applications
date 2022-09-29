package edu.psu.ist;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Album data) {
        // check the root here
        this.root = insertNode(this.root, data);
    }

    private Node insertNode(Node current, Album data) {

        // if the current is null, just return the node
        if (current == null) {
            return new Node(data);
        }

        // compare the data to the current node
        if (data.compareTo(current.data) < 0) {
            // before recurse you have to check if left is null
//            if (current == null) {
//                return new Node(data);
//            }
//            if (root.left != null) {
            current.left = this.insertNode(current.left, data);
//            }
        } else if (data.compareTo(current.data) > 0) {
            // before recurse you have to check if right is null
//            if (current == null) {
//                return new Node(data);
//            }
//            if (root.right != null) {
            current.right = this.insertNode(current.right, data);
//            }
        }

        // if it is a duplicate we do nothing, if we did something
        // here we return the modified node
        return current;
    }

//    public String inOrderTraversal() {
//        return this.inOrderTraversalNode(this.root);
//    }

    public String inOrderTraversalNode(Node current) {
        StringBuilder stringBuilder = new StringBuilder();
        if (current != null) {
            // go left first because this is in order
            stringBuilder.append(this.inOrderTraversalNode(current.left));

            // append the current node
            stringBuilder.append(current.data);
            stringBuilder.append(" ");

            // go right
            stringBuilder.append(this.inOrderTraversalNode(current.right));
        } else {
            stringBuilder.append("");
        }

        return stringBuilder.toString();
    }

    public Node delete(Album data) {
        return deleteNode(this.root, data);
    }

    public Node deleteNode(Node current, Album data) {

        // if it is the root
        if (current == root) {
            return new Node(data);
        }

        // remember to recurse!
        if (current.data.compareTo(data) < 0) {
            current.left = deleteNode(current.left, data);
        } else if (current.data.compareTo(data) > 0) {
            current.right = deleteNode(current.right, data);
        } else {

//        if(data.compareTo(root.getData()) < 0) {
//            root.setLeft(deleteNode(root.getLeft(), data));
//        } else if(data.compareTo(root.getData()) > 0) {
//            root.setRight(deleteNode(root.getRight(), data));
//        }

            // if it isn't in there
//        while (current.data != data) {
//            return null;
//        }

            // no child
            if (current.left == null && current.right == null) {
                // just delete it
                return null;
            }

            // one child
            if (current.left.data == null && current.right.data != null) {
                // shift up the child
                return current.right;
            }

            if (current.right == null && current.left != null) {
                // shift up the child
                return current.left;
            }

            // two children
            if (current.left.data != null && current.right.data != null) {
                // (find the smallest value in the biggest subtree... go right then left all the way
                Album minValue = minValue(root.getRight());
                root.setData(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
            }
        }
        return new Node(data);
    }

    private Album minValue(Node node) {
        Album minV = node.data;
        while (node.getLeft() != null) {
            minV = root.left.data;
            root = root.left;
            return minValue(node.getLeft());
        }
        return minV;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        if (root == null) {
            return "";
        }
        stringbuilder.append((root.left));
        stringbuilder.append((root.right));
        return stringbuilder.append(root.data.toString()).toString();
    }

    public BinarySearchTree rebalance() {
        // create a new tree
        BinarySearchTree tree = new BinarySearchTree();

        if (root == null) {
            return null;
        }

        // get the arrayList of the current tree using in order
        ArrayList<Album> a = getSortedList(this.root);

        // insert recursively
        insertMidPoint(a, 0, a.size() - 1);

        // return the tree
        return tree;
    }

    public void insertMidPoint(ArrayList<Album> list, int start, int end) {
        int midPoint = 0;
        if (start > end) {
            return;
        }

        // check if start == end
        else if (start == end) {
            insert(list.get(start));
        }

        // find the midpoint
        else if (start != end) {
            if ((start + end) % 2 == 0) {
                midPoint = (start + end) / 2;
            } else {
                midPoint = (start + end + 1) / 2;
            }

            // insert the midpoint
            insert(list.get(midPoint));

            // call with the left side (update the end index)
            insertMidPoint(list, start, midPoint - 1);

            // call the with the right side (update the start index)
            insertMidPoint(list, midPoint + 1, end);
        }
    }

    protected ArrayList<Album> getSortedList(Node current) {

        // create a new arrayList
        ArrayList<Album> a = new ArrayList<>();

        // remember to check if current is null
        if (current != null) {

            // append all of the things from the left of the tree
            // recursive!
            a.addAll(getSortedList(current.left));

            // add the current one
            a.add(current.data);

            // add all of the things of from the right of the tree
            // recursive!
            a.addAll(getSortedList(current.right));

        }
        // return the arrayList
        return a;
    }

    public boolean contains(Node current, Album data) {
        if (current == null) {
            return false;
        }

        while (current != null) {
            if (data.compareTo(current.data) < 0) {
                current = current.left;
            } else if (data.compareTo(current.data) > 0) {
                current = current.right;
            } else {
                return true;
            }
            break;
        }
        return false;
    }

    public ArrayList partition(Node temp, Album a) {
//        while (temp != null) {
//                if (temp.data.numOfSongs < root.data.numOfSongs) {
//                    System.out.println("Doesn't exist");
//                } else {
//                    b.add(temp.data.numOfSongs);
//                }
//            break;
//        }
        ArrayList<Album> list = new ArrayList<>();

        if (temp != null) {
            // go left first because it is in order
            ArrayList<Album> left = partition(temp.left, a);
            for (int i = 0; i < left.size(); i++) {
                if (left.get(i).compareTo(a) >= 0) {
                    list.add(left.get(i));
                }
            }

            // add the current node
            if (temp.data.compareTo(a) >= 0) {
                list.add(temp.data);
            }

            ArrayList<Album> right = partition(temp.right, a);
            // go right
            for (int i = 0; i < right.size(); i++) {
                if (right.get(i).compareTo(a) >= 0) {
                    list.add(right.get(i));
                }
            }
        }
        return list;
    }
}