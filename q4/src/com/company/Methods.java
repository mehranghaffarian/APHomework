package com.company;

public class Methods {
    public void add(int value, Node head) {
        Node curr = head;

        for (; curr.getNext() != null; curr = curr.getNext()) ;

        curr.setNext(new Node(value));
    }

    public void print(Node head){
        Node curr = head.getNext();

        for(;curr != null;curr = curr.getNext())
            System.out.printf("%d ", curr.getValue());

        System.out.println();
    }

    public void addFirst(int value, Node head){
        Node curr = head;
        Node newNode = new Node(value);

        newNode.setNext(head.getNext());

        head.setNext(newNode);
    }

    public void findMiddle(Node head){
        int num = 0;

        for(Node curr = head.getNext();curr != null;curr = curr.getNext(), num++);

        if (num == 0){
            System.out.println("-1");
        }
        else if(num % 2 == 0){
            Node curr = head.getNext();

            for (int i = 1; i != num / 2; i++, curr = curr.getNext()) ;

            System.out.println(curr.getValue());
        }
        else {
            Node curr = head.getNext();

            for (int i = 1; i != (num + 1) / 2; i++, curr = curr.getNext()) ;

            System.out.println(curr.getValue());
        }
    }
}
