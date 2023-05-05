package org.example.impl.list;

import org.example.spec.List;

import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements List<E> {

    static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head; // 리스트의 첫 노드
    private Node<E> tail; // 리스트의 마지막 노드
    private int size; // 요소 개수

    private Node<E> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head;

        while (index-- > 0) {
            x = x.next;
        }

        return x;
    }

    private void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(E value) {
        if (isEmpty()) {
            addFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<>(value);

        Node<E> prevNode = search(index - 1);

        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
    }

    public E remove() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E element = head.data;

        Node<E> nextNode = head.next;

        head.data = null;
        head.next = null;

        head = nextNode;
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return remove();
        }

        Node<E> prevNode = search(index - 1);
        Node<E> removedNode = prevNode.next;
        Node<E> nextNode = removedNode.next;

        E element = removedNode.data;

        removedNode.data = null;
        removedNode.next = null;
        size--;

        prevNode.next = nextNode;

        if (prevNode.next == null) {
            tail = prevNode;
        }

        return element;
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);

        if (index < 0) {
            return false;
        }

        if (index == 0) {
            remove();
            return true;
        }

        remove(index);
        return true;
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> x = search(index);
        x.data = value;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;

        for (Node<E> x = head; x != null; x = x.next) {
            if (x.data.equals(value)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (Node<E> x = head; x != null; ) {
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
}
