package com.company;

import java.util.EmptyStackException;
/**
 * This class simulates the stack for Integers
 * @author mehran ghaffarian
 * */
public class Stack {
    private int currentSize;
    private int[] nums;

    /**
     * creates the stack with the given size
     * @param maxSize of the stack
     * */
    public Stack(int maxSize) {
        currentSize = 0;
        nums = new int[maxSize];
    }
    /**
     * creates the stack with the size of 10 by default
     * */
    public Stack() {
        currentSize = 0;
        nums = new int[10];
    }
    /**
     * adds the given value to the end of the stack
     * @param value is added
     * @return value if it was successful otherwise returns exception
     * */
    public int push(int value) {
        if (currentSize < nums.length) {
            nums[currentSize] = value;
            currentSize++;
            return value;
        } else
            throw new StackOverflowError("Stack is full?!");
    }
    /**
     * @return the last value if it exists and removes it otherwise returns exception
     * */
    public int pop() {
        if (currentSize == 0)
            throw new EmptyStackException();
        else {
            int last = nums[currentSize - 1];
            currentSize--;
            nums[currentSize] = 0;
            return last;
        }
    }
    /**
     * @return only the last value with no removing
     * */
    public int peek() {return nums[currentSize - 1];}
    /**
     * @return true if the stack currentSize is equal to the stack size otherwise returns false
     * */
    public boolean isEmpty() {
        if (currentSize == 0)
            return true;

        return false;
    }
    /**
     * @return true if the stack is empty otherwise returns false
     * */
    public boolean isFull() {
        if (currentSize == nums.length)
            return true;

        return false;
    }
    /**
     * @return the number of the elements
     * */
    public int getCurrentSize() {
        return currentSize;
    }
}
