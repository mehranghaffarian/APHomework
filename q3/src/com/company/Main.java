package com.company;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ted", "Mosby", 123456);
        p1.express();
        p1.express("Happy");
        p1.print();
    }
    static class Person {
        private String FirstName;
        private String last_name;
        private int id;

        public Person(String FirstName, String last_name, int id){
            this.FirstName = FirstName;
            this.last_name = last_name;
            this.id = id;
        }

        public void express(){
            System.out.println("I feel neutral");
        }

        public int express(String state){
            System.out.println("I feel " + state + " today");
            return 0;
        }
        public void print(){
            System.out.println("person{" + "first name='" + FirstName + '\'' + ", last name='" + last_name + '\'' + ", id=" + id + '}');
        }
    }
}