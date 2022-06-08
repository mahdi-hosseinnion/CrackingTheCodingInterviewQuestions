package com.company;


import com.company.graph.Graph;
import com.company.util.Queue;

import java.util.HashSet;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    private static <T> boolean hasRouteBetweenNodesWithBFS(Graph.Node<T> source, Graph.Node<T> destination) {
        Queue<Graph.Node<T>> nextToSearch = new Queue<>();
        HashSet<Long> visitedNodes = new HashSet<>();

        nextToSearch.enqueue(source);

        while (!nextToSearch.isEmpty()) {
            Graph.Node<T> item = nextToSearch.dequeue();

            if (item == destination) {
                return true;
            }

            if (visitedNodes.contains(item.getId())) {
                continue;
            }
            visitedNodes.add(item.getId());

            for (Graph.Node<T> child : item.adjacent) {
                nextToSearch.enqueue(child);
            }
        }
        return false;
    }

}
