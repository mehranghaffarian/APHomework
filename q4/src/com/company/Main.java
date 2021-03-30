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

        ll.add(15, head);
        ll.add(34, head);
        ll.add(17, head);

        ll.findMiddle(head);

        ll.add(46, head);

        ll.print(head);

        ll.removeIndex(2, head);

        ll.print(head);

        ll.addFirst(4, head);

        ll.print(head);

        ll.findMiddle(head);

        ll.removeIndex(20, head);

        ll.contains(46, head);

        ll.removeIndex(0, head);

        ll.print(head);

        ll.contains(4, head);

        ll.removeMiddle(head);

        ll.print(head);

        String finish = "finish";
    }
}
