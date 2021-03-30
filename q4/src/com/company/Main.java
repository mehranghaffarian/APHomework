package com.company;

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

        ll.add(1, head);
        ll.add(2, head);
        ll.addFirst(3, head);
        ll.addFirst(4, head);
        ll.addFirst(5, head);

        ll.print(head);

        ll.findMiddle(head);
    }



}
