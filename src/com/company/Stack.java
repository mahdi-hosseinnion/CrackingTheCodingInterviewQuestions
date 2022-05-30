package com.company;

import java.util.EmptyStackException;

public class Stack<DATA> {


    Node<DATA> top = null;


    public void push(DATA data) {
        Node<DATA> newTop = new Node<DATA>(data);
        newTop.next = top;
        top = newTop;

    }

    public DATA pop() {
        DATA data = peek();
        top = top.next;
        return data;
    }

    public DATA peek() {
        if (this.isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printAll() {
        Node<DATA> n = top;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println("Printed!");
    }
}
