package com.company.stack;

class NodeWithMin {

    public NodeWithMin next = null;

    Integer data;

    Integer min;

    public NodeWithMin(Integer data) {
        this.data = data;
    }

    void append(Integer data) {
        NodeWithMin end = new NodeWithMin(data);
        NodeWithMin n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public NodeWithMin copy() {
        NodeWithMin result = new NodeWithMin(this.data);
        NodeWithMin node = this.next;
        while (node != null) {
            result.append(node.data);
            node = node.next;
        }
        return result;
    }

    public void printAll(String separator) {
        NodeWithMin currentNode = this;
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
