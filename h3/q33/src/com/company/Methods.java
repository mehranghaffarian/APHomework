package com.company;
/**
 *
 * */
public class Methods {
    /**
     *
     * */
    public void add(int value, Node head) {
        Node curr = head;

        for (; curr.getNext() != null; curr = curr.getNext()) ;

        curr.setNext(new Node(value));
    }
    /**
     *
     * */
    public void print(Node head){
        Node curr = head.getNext();

        for(;curr != null;curr = curr.getNext())
            System.out.printf("%d ", curr.getValue());

        System.out.println();
    }
    /**
     *
     * */
    public void addFirst(int value, Node head){
        Node curr = head;
        Node newNode = new Node(value);

        newNode.setNext(head.getNext());

        head.setNext(newNode);
    }
    /**
     *
     * */
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
    /**
     *
     * */
    public void removeMiddle(Node head){
        int num = 0;

        for(Node curr = head.getNext();curr != null;curr = curr.getNext(), num++);

        if (num == 0){
            System.out.println("-1");
        }
        else if(num % 2 == 0){
            Node curr = head;

            for (int i = 1; i != num / 2; i++, curr = curr.getNext()) ;

            Node hold = curr.getNext();
            curr.setNext(curr.getNext().getNext());

            hold = null;
        }
        else {
            Node curr = head;

            for (int i = 1; i != (num + 1) / 2; i++, curr = curr.getNext()) ;

            Node hold = curr.getNext();
            curr.setNext(curr.getNext().getNext());

            hold = null;
        }
    }
    /**
     *
     * */
    public void contains(int value, Node head){
        Node curr = head.getNext();

        for(int i = 0;curr != null;curr = curr.getNext(), i++)
            if(curr.getValue() == value) {
                System.out.println(i);
                break;
            }
        if(curr == null)
            System.out.println("-1");
    }
    /**
     *
     * */
    public void removeIndex(int index, Node head){
        Node curr = head.getNext();
        Node target = new Node(0);
        int i;

        for(i = 0;curr != null;curr = curr.getNext(), i++)
            if(i == index) {
                target.setValue(curr.getValue());
                target.setNext(curr.getNext());
            }

        if(index >= 0 && index < i){
            curr = head;

            for(int k = 0;k < index;k++, curr = curr.getNext());

            Node hold = curr.getNext();
            curr.setNext(curr.getNext().getNext());
            hold = null;
        }
    }
    /**
     *
     * */
    public int size(Node head){
        int size = 0;

        for (Node curr = head;curr.getNext() != null; size++, curr = curr.getNext());

        return size;
    }
    /**
     *
     * */
    public int get(int index, Node head){
        if(index >= 0 && head != null && index < size(head)){
            Node curr = head;

            for (int i = -1; i != index && curr.getNext() != null; i++, curr = curr.getNext()) ;

            return curr.getValue();
        }
        return -1;
    }
    /**
     *
     * */
    public void set(int index, int value, Node head){
        if(index < 0 || head == null || index >= size(head))
            return;

        Node curr = head;

        for(int i = -1;i != index && curr.getNext() != null;i++ ,curr = curr.getNext());

        curr.setValue(value);
    }
}
