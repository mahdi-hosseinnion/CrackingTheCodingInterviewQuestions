package com.company.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class Graph<D> {

    public HashMap<Long, Node<D>> nodes = new HashMap<>();

    public void addNode(Node<D> node) {
        nodes.put(node.getId(), node);
    }

    public Node<D> getNode(Long id) {
        return nodes.get(id);
    }

    public static class Node<DATA> {

        final DATA data;

        //Random id is used to differentiate between different nodes.
        private final long id = UUID.randomUUID().getMostSignificantBits();

        public LinkedList<Node<DATA>> adjacent = new LinkedList<>();

        public Node(DATA data) {
            this.data = data;
        }

        public long getId() {
            return id;
        }


    }
}
