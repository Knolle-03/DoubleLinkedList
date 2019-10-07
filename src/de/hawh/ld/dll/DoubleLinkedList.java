package de.hawh.ld.dll;

import java.util.Iterator;
import java.util.NoSuchElementException;

import de.hawh.ld.interfaces.IDoubleLinkedList;
import edu.princeton.cs.algs4.*;


public class DoubleLinkedList<E> implements IDoubleLinkedList<E>, Iterable<E> {

    private int size;
    private Node first;
    private Node last;

    public DoubleLinkedList(){
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
    }

    private class Node {
        private E data;
        private Node prev;
        private Node next;
    }

    public void add(E e) {
        Node end = last.prev;
        Node node = new Node();
        node.data = e;
        node.next = last;
        node.prev = end;
        last.prev = node;
        end.next = node;
        size++;
    }

    @Override
    public E deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Node oldFirst = first.next;
        first.next = oldFirst.next;
        first.next.prev = first;
        size--;

        return oldFirst.data;
    }

    @Override
    public E deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Node oldLast = last.prev;
        last.prev = oldLast.prev;
        last.prev.next = last;
        size--;

        return oldLast.data;
    }

    @Override
    public E deleteAt(int i){
        if (isEmpty()) throw new IndexOutOfBoundsException();
        DLLIterator it = new DLLIterator();
        it.traverseNodes(i);
        it.removeNode();

        return it.current.data;
    }

    @Override
    public void removeFirstOccurrence(E e) {
        DLLIterator it = new DLLIterator();
        while (it.hasNext()) {
            if (it.current.data != e) {
                it.next();
            } else {
                it.removeNode();
                break;
            }
        }


//        if (isEmpty()) throw new IndexOutOfBoundsException();
//        DLLIterator it  = new DLLIterator();
//        it.traverseNodes(i);
//        E deletedNodeData = it.current.data;
//        it.current.data = null;
//
//        return deletedNodeData;
    }

    @Override
    public void addAt(int i,E e) {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        Node newNode = new Node();
        newNode.data = e;
        DLLIterator it = new DLLIterator();
        it.traverseNodes(i);
        Node oldPrev = it.current.prev;
        oldPrev.next = newNode;
        newNode.prev = oldPrev;
        newNode.next = it.current;
        it.current.prev = newNode;
        size++;
    }

    @Override
    public boolean includes(E e) {
        DLLIterator it = new DLLIterator();

        return it.traverseNodes(e);
    }

    @Override
    public E readAt(int i) {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        DLLIterator it = new DLLIterator();
        it.traverseNodes(i);
        return it.current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubleLinkedList<E> that = (DoubleLinkedList<E>) o;
        if (size != that.size) return false;

        Iterator<E> thisIt = this.iterator();
        Iterator<E> thatIt = that.iterator();
        boolean truthVal = true;

        for (int i = 0; i < size; i++) {
            if (!thisIt.next().equals(thatIt.next())) {
                truthVal = false;
                break;
            }
        }
        return truthVal;
    }

    @Override
    public int hashCode() {
        DLLIterator it = new DLLIterator();
        int hash = 7;
        for (int i = 0; i < size; i++) {
            hash *= 31 + (it.current.data == null ? 0 : it.next().hashCode());
        }
        return hash;
    }

    @Override
    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<E> {

        private Node current = first.next;
        private int index = 0;

        public boolean hasNext() {
            return index < size;
        }


        public E next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            E e = current.data;
            current = current.next;
            index++;
            return e;
        }


        public void traverseNodes(int i){
            while (i > index){
                next();
            }
        }

        public boolean traverseNodes(E e) {
            while (hasNext())
            if (current.data != e) {
                next();
            } else return true;
            return false;
        }

        public void removeNode(){
            Node oldNext = current.next;
            Node oldPrev = current.prev;
            oldNext.prev = oldPrev;
            oldPrev.next = oldNext;
            size--;
        }

    }


    public String toString() {
        Iterator<E> it = iterator();
        StringBuilder dataString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                dataString.append(it.next());
            } else {
                dataString.append(it.next()).append(", ");
            }
        }
        return "DLL data: " + dataString.toString();
    }
}


