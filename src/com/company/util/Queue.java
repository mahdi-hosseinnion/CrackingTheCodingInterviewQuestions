package com.company.util;

import java.util.LinkedList;

/**
 * Queue implemented using java.util.LinkedList.
 *
 * @param <T>, The queue's data type.
 */
//TODO (implement java.util.Queue interface).
public class Queue<T> extends LinkedList<T> {

    public boolean enqueue(T data) {
        return this.add(data);
    }

    public T dequeue() {
        return this.poll();
    }
}
