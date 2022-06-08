package com.company.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class Graph<D> {

    HashMap<Long, Node<D>> nodes = new HashMap<>();

    void addNode(Node<D> node) {
        nodes.put(node.getId(), node);
    }

    public static class Node<DATA> {

        //Random id is used to differentiate between different nodes.
        private long id = UUID.randomUUID().getMostSignificantBits();

        public LinkedList<Node<DATA>> adjacent = new LinkedList<>();

        public long getId() {
            return id;
        }
    }
}
