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
        removeLinkedListDups(linkedList);
        removeLinkedListDupsWithoutUsingBuffer(copiedLinkedList);

        printLinkedList(linkedList);
        System.out.print("First list \n");
        printLinkedList(copiedLinkedList);
        System.out.print("Copied list \n");
    }

    public static void removeLinkedListDups(Node root) {
        ArrayList<Integer> buffer = new ArrayList<>();
        Node node = root;
        Node priorNode = null;

        do {
            int item = node.data;
            if (buffer.contains(item)) {
                //remove node from the chain.
                priorNode.next = node.next;
            } else {
                buffer.add(item);
                priorNode = node;
            }
            node = node.next;

        } while (node != null);
    }

    public static void removeLinkedListDupsWithoutUsingBuffer(Node root) {
        Node iNode = root;
        do {
            int iNodeData = iNode.data;
            Node jNode = iNode.next;
            Node priorJNode = iNode;
            while (jNode != null) {
                int jNodeData = jNode.data;
                if (iNodeData == jNodeData) {
                    //remove j node
                    priorJNode.next = jNode.next;
                } else {
                    priorJNode = jNode;
                }
                jNode = jNode.next;
            }
            iNode = iNode.next;
        } while (iNode != null);
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
