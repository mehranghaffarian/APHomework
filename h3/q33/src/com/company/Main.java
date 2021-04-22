package com.company;

import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * class for reversing series of Integers
 * @author mehranghaffarian
 * */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //you can set the size on your own interest
        Stack stack = new Stack(20);

        Node head = new Node(0);
        Methods linkedList = new Methods();

        String numbersStr = scan.nextLine();
        StringTokenizer token = new StringTokenizer(numbersStr, " ");

        while (token.hasMoreTokens())
            linkedList.add(Integer.parseInt(token.nextToken()), head);

        for (int i = 0; i < linkedList.size(head); i++)
            stack.push(linkedList.get(i, head));

        Node newHead = new Node(0);
        int size = stack.getCurrentSize();

        for (int i = 0; i < size; i++)
            linkedList.add(stack.pop(), newHead);

        String answerStr = "";

        Node curr = newHead.getNext();

        while (curr != null) {
            answerStr = answerStr.concat(Integer.toString(curr.getValue()));

            if (curr.getNext() != null)
                answerStr = answerStr.concat(" ");

            curr = curr.getNext();
        }

        System.out.println(answerStr);
    }
}
