package com.company;

import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Node linkedList = new Node(5);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(7);
        linkedList.append(3);
        linkedList.append(1);
        //TODO create github repo for this

    }

    static class Node {

        Node next = null;

        int data;

        public Node(int data) {
            this.data = data;
        }

        void append(int data) {
            Node end = new Node(data);
            Node n = this;

            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }
}
