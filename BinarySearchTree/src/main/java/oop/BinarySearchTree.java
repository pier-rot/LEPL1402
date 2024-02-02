package oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Question:
 * <p>
 * You are asked to retrieve the elements of the binary search tree
 * in decreasing order (see the TODO below)
 * <p>
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 * <p>
 * <p>
 * A Binary Search Tree is a Data Structure that represents
 * a set (no duplicates thus) of integers stored such that
 * for a given node, keys in the left subtree are all smaller that the key in the node
 * keys in the right right subtree are larger than the key in the node
 * <p>
 * Your algorithm should have a time complexity of Theta(n)
 * where n is the number of elements in the set.
 * <p>
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 */
public class BinarySearchTree {

    private Node root;             // root of BST

    private class Node {

        private int key;           // sorted by key
        private Node left, right;  // left and right subtrees

        public Node(int key) {
            this.key = key;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getKey() {
            return key;
        }

    }

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree() {

    }

    public void insert(int key) {
        root = put(root, key);
    }

    private Node put(Node x, int key) {
        if (x == null) return new Node(key);
        if (key < x.key) x.left = put(x.left, key);
        else if (key > x.key) x.right = put(x.right, key);
        return x;
    }

    /**
     * Return the list that contains the elements in decreasing order
     * The complexity should be Theta(n) where n is the number of elements in the set.
     *
     * @return
     */
    public List<Integer> decreasing() {
        // TODO
        List<Integer> decreasingList = new LinkedList<>();
        Node tempNode = root;
        Node tempNodeLeft = tempNode.left;
        Node tempNodeRight = tempNode.right;

//        while(tempNodeLeft != null || tempNodeRight != null) {
//
//        }

        return decreasingList;
    }


}