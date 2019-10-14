package de.hawh.ld.interfaces;

import java.util.Iterator;

public interface IDoubleLinkedList<E> {

    void add(E e);
    E deleteFirst();
    E deleteLast();
    E deleteAt(int i);
    void removeFirstOccurrence(E e);
    void removeAllOccurrences(E e);
    void addAt(int i, E e);
    boolean includes(E e);
    E readAt(int i);
    int size();
    boolean isEmpty();
    String toString();
    Iterator<E> iterator();
}
