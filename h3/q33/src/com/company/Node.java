package com.company;
/**
 *This class simulates the nodes for the linkedList of Integers
 * @author mehran ghaffarian
 * */
public class Node {
    private int value;
    private Node next;
    /**
     * creates the node element with the given value
     * @param value is the value ::))))
     * */
    public Node(int value){
        this.value = value;
        next = null;
    }
    /**
     * @return the value of this node
     * */
    public int getValue(){return value;}
    /**
     * @param value is set for this node value
     * */
    public void setValue(int value){this.value = value;}
    /**
     * @return the next node of this node
     * */
    public Node getNext(){return next;}
    /**
     * @param newNext is set as the next node for the current node
     * */
    public void setNext(Node newNext){next = newNext;}
}
