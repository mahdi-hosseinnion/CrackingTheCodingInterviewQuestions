package com.company;

class Node<DATA> {

    public Node<DATA> next = null;

    DATA data;

    public Node(DATA data) {
        this.data = data;
    }

    void append(DATA data) {
        Node<DATA> end = new Node<>(data);
        Node<DATA> n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node<DATA> copy() {
        Node<DATA> result = new Node<>(this.data);
        Node<DATA> node = this.next;
        while (node != null) {
            result.append(node.data);
            node = node.next;
        }
        return result;
    }

    public void printAll(String separator) {
        Node<DATA> currentNode = this;
        while (currentNode != null) {
            DATA item = currentNode.data;
            System.out.print(item + separator);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void printAll() {
        this.printAll(" ");
    }

}