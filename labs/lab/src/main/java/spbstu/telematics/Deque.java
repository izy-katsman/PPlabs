package spbstu.telematics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int dequeSize;

    class Node {
        Item value;
        Node next;
        Node pre;
    }


    public Deque() {
        head = null;
        tail = null;
        dequeSize = 0;
    }

    public boolean isEmpty() {
        return dequeSize == 0;
    }

    public int size() {
        return dequeSize;
    }

    public void addFirst(Item item) {

        if (item == null) {
            throw new NullPointerException();
        }

        Node oldHead = head;
        head = new Node();
        head.next = oldHead;
        head.pre = null;
        head.value = item;
        if(isEmpty())
            tail = head;
        else
            oldHead.pre = head;
        dequeSize++;
    }

    public void addLast(Item item) {

        if (item == null) {
            throw  new NullPointerException();
        }

        Node oldTail = tail;
        tail = new Node();
        tail.next = null;
        tail.pre = oldTail;
        tail.value = item;
        if(isEmpty())
            head = tail;
        else
            oldTail.next = tail;
        dequeSize++;
    }

    public  Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node oldHead = head;
        head = oldHead.next;
        oldHead.next = null;
        dequeSize--;
        if (isEmpty())
            tail = null;
        else
            head.pre = null;

        return oldHead.value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node oldTail = tail;
        tail = oldTail.pre;
        oldTail.pre = null;
        dequeSize--;
        if (isEmpty())
            head = null;
        else
            tail.next = null;

        return tail.value;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        Node current = head;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {

            if (current == null) {
                throw new NoSuchElementException();
            }
            Node r = current;
            current = current.next;
            return r.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
