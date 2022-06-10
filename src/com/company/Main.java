package com.company;


import com.company.graph.Graph;
import com.company.graph.Graph.Node;
import com.company.util.Queue;

import java.util.HashSet;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Graph<String> graph = instantiateProgramingLanguageGraph();

        boolean first = hasRouteBetweenNodesWithBFS(graph.getNode(programmingLanguages.getId()), python);
        if (first) System.out.println("First done");

        boolean second = hasRouteBetweenNodesWithBFS(graph.getNode(programmingLanguages.getId()), assemblyLanguages);
        if (second) System.out.println("Second done");

        boolean third = hasRouteBetweenNodesWithBFS(graph.getNode(programmingLanguages.getId()), new Node<>("Hey"));
        if (!third) System.out.println("Third done");

        boolean forth = hasRouteBetweenNodesWithBFS(highLevelLanguages, java);
        if (forth) System.out.println("Forth done");

        boolean fifth = hasRouteBetweenNodesWithBFS(highLevelLanguages, assemblyLanguages);
        if (!fifth) System.out.println("Fifth done");

        boolean sixth = hasRouteBetweenNodesWithBFS(java, highLevelLanguages);
        if (!sixth) System.out.println("Sixth done");

    }

    public static <T> boolean hasRouteBetweenNodesWithBFS(Node<T> source, Node<T> destination) {
        Queue<Node<T>> nextToSearch = new Queue<>();
        HashSet<Long> visitedNodes = new HashSet<>();

        nextToSearch.enqueue(source);

        while (!nextToSearch.isEmpty()) {
            Node<T> item = nextToSearch.dequeue();

            if (item == destination) {
                return true;
            }

            if (visitedNodes.contains(item.getId())) {
                continue;
            }
            visitedNodes.add(item.getId());

            for (Node<T> child : item.adjacent) {
                nextToSearch.enqueue(child);
            }
        }
        return false;
    }

    //Test data
    static Node<String> programmingLanguages = new Node<>("programming languages");
    static Node<String> machineLanguages = new Node<>("Machine languages");
    static Node<String> assemblyLanguages = new Node<>("Assembly languages");
    static Node<String> highLevelLanguages = new Node<>("High-level languages");

    static Node<String> binary = new Node<>("Binary code");
    static Node<String> machine = new Node<>("Machine code");
    static Node<String> c = new Node<>("C");
    static Node<String> cpp = new Node<>("C++");
    static Node<String> java = new Node<>("Java");
    static Node<String> python = new Node<>("Python");

    private static Graph<String> instantiateProgramingLanguageGraph() {

        machineLanguages.adjacent.add(binary);
        machineLanguages.adjacent.add(machine);
        programmingLanguages.adjacent.add(machineLanguages);

        assemblyLanguages.adjacent.add(c);
        assemblyLanguages.adjacent.add(cpp);
        programmingLanguages.adjacent.add(assemblyLanguages);

        highLevelLanguages.adjacent.add(java);
        highLevelLanguages.adjacent.add(python);
        programmingLanguages.adjacent.add(highLevelLanguages);

        Graph<String> graph = new Graph<>();
        graph.addNode(programmingLanguages);
        return graph;
    }
}
