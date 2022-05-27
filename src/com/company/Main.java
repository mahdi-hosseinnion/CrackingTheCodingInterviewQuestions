package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Node linkedList = new Node(5);
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(7);
        linkedList.append(7);
        linkedList.append(9);
        linkedList.append(7);
        linkedList.append(3);
        linkedList.append(3);
        linkedList.append(7);
        linkedList.append(3);
        linkedList.append(8);
        linkedList.append(9);
        linkedList.append(1);
        linkedList.append(7);
        linkedList.append(1);
        linkedList.append(1);
        linkedList.append(1);
        Node copiedLinkedList = returnCopyOfLinkedList(linkedList);


        printLinkedList(linkedList);
        System.out.print("First list \n");
        printLinkedList(copiedLinkedList);
        System.out.print("Copied list \n");

        System.out.println("Remove dups...");
        removeDups(linkedList);
        removeDupsWithoutUsingBuffer(copiedLinkedList);

        printLinkedList(linkedList);
        System.out.print("First list \n");
        printLinkedList(copiedLinkedList);
        System.out.print("Copied list \n");
    }

    /**
     * Runs in O(N) space & O(N) time.
     */
    public static void removeDups(Node node) {
        ArrayList<Integer> buffer = new ArrayList<>();
        Node priorNode = null;
        while (node != null) {
            int item = node.data;
            if (buffer.contains(item)) {
                //remove node from the chain.
                priorNode.next = node.next;
            } else {
                buffer.add(item);
                priorNode = node;
            }
            node = node.next;

        }
    }

    /**
     * Runs in O(1) space & O(N*N) time.
     */
    public static void removeDupsWithoutUsingBuffer(Node current) {
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    //remove j node
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static Node returnCopyOfLinkedList(Node source) {
        Node result = new Node(source.data);
        Node node = source.next;
        while (node != null) {
            result.append(node.data);
            node = node.next;
        }
        return result;
    }

    public static void printLinkedList(Node root) {
        Node currentNode = root;
        do {
            int item = currentNode.data;
            System.out.print(item + " ");
            currentNode = currentNode.next;
        } while (currentNode != null);
    }
}
