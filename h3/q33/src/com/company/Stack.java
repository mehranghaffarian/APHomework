package com.company;

import java.util.EmptyStackException;

public class Stack {
    private int maxSize;
    private int currentSize;
    private Node head;
    private Methods linkedList;

    public Stack(int maxSize) {
        head = new Node(0);
        this.maxSize = maxSize;
        currentSize = 0;
        linkedList = new Methods();
    }

    public Stack() {
        head = new Node(0);
        maxSize = 10;
        currentSize = 0;
        linkedList = new Methods();
    }

    public int push(int value) {
        if (currentSize < maxSize) {
            linkedList.add(value, head);
            currentSize++;
            return lastNode().getValue();
        } else
            throw new StackOverflowError("Stack is full?!");
    }

    public int pop() {
        if (currentSize == 0)
            throw new EmptyStackException();
        else {
            int last = lastNode().getValue();
            linkedList.removeIndex(currentSize - 1, head);
            return last;
        }
    }

    public int peek() {
        return lastNode().getValue();
    }

    public boolean isEmpty() {
        if (currentSize == 0)
            return true;

        return false;
    }

    public boolean isFull() {
        if (currentSize == maxSize)
            return true;

        return false;
    }

    private int lastNumber() {
        return lastNode().getValue();
    }

    private Node lastNode() {
        Node curr = head;

        for (; curr.getNext() != null; curr = curr.getNext()) ;

        return curr;
    }
}
