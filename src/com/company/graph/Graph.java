package com.company.graph;

public class Graph<DATA> {

    private Node<DATA>[] nodes;

    public Node<DATA>[] getNodes() {
        return nodes;
    }

    public void setNodes(Node<DATA>[] nodes) {
        this.nodes = nodes;
    }
}
