package com.company;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack stack = new Stack();

        Node head = new Node(0);
        Methods linkedList = new Methods();

        String numbersStr = scan.nextLine();
        StringTokenizer token = new StringTokenizer(numbersStr, " ");

        while(token.hasMoreTokens())
            linkedList.add(Integer.parseInt(token.nextToken()), head);

        for(int i = 0;i < linkedList.size(head);i++)
            stack.push(linkedList.get(i, head));


    }
}
