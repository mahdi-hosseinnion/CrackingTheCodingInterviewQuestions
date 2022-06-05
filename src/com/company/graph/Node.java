package com.company.graph;

public class Node<DATA> {

    private Node<DATA>[] children;

    public Node<DATA>[] getChildren() {
        return children;
    }

    public void setChildren(Node<DATA>[] children) {
        this.children = children;
    }
}
