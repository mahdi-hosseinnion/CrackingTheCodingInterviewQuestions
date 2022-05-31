package com.company;

class IntegerNode {

    public IntegerNode next = null;

    Integer data;

    Integer min;

    public IntegerNode(Integer data) {
        this.data = data;
    }

    void append(Integer data) {
        IntegerNode end = new IntegerNode(data);
        IntegerNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public IntegerNode copy() {
        IntegerNode result = new IntegerNode(this.data);
        IntegerNode node = this.next;
        while (node != null) {
            result.append(node.data);
            node = node.next;
        }
        return result;
    }

    public void printAll(String separator) {
        IntegerNode currentNode = this;
        while (currentNode != null) {
            Integer item = currentNode.data;
            System.out.print(item + separator);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void printAll() {
        this.printAll(" ");
    }

}
