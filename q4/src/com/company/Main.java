package com.company;

import java.util.Scanner;

public class Main {
    public void add(int value, Node head){
        Node curr = head;
        Node newNod = new Node(value);

        for(;curr.getNext() != null;curr = curr.getNext());

        curr.setNext(newNod);
    }

    public static void main(String[] args) {
        Node head = new Node(0);

        Methods ll = new Methods();

        Scanner scan = new Scanner(System.in);

        String check = "start";

        while(!check.equalsIgnoreCase("finish")){
            check = scan.next();

            if (check.equalsIgnoreCase("add"))
                ll.add(scan.nextInt(), head);

            else if (check.equalsIgnoreCase("findMiddle"))
                ll.findMiddle(head);

            else if(check.equalsIgnoreCase("print"))
                ll.print(head);

            else if (check.equalsIgnoreCase("removeIndex"))
                ll.removeIndex(scan.nextInt(), head);

            else if(check.equalsIgnoreCase("addFirst"))
                ll.addFirst(scan.nextInt(), head);

            else if(check.equalsIgnoreCase("contains"))
                ll.contains(scan.nextInt(), head);

            else if(check.equalsIgnoreCase("removeMiddle"))
                ll.removeMiddle(head);
        }
    }
}
