package com.company.stack;

import java.util.EmptyStackException;

public class StackWithMin {


    NodeWithMin top = null;


    public void push(Integer data) {
        NodeWithMin newTop = new NodeWithMin(data);
        newTop.next = top;
        if (top != null) {
            newTop.min = (top.min < data) ? top.min : data;
        }
        top = newTop;
        if (top.next == null) {
            top.min = data;
        }


    }

    public Integer pop() {
        Integer data = peek();
        top = top.next;
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Integer getMin() {
        if (this.isEmpty()) throw new EmptyStackException();
        return top.min;
    }

    public void printAll() {
        NodeWithMin n = top;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println("Printed!");
    }
}
