package Deque;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @org.junit.jupiter.api.Test
    void addFirst() {
        Deque<Integer> t1 = new Deque<Integer>();
        ArrayDeque<Integer> t2 = new ArrayDeque<Integer>();
                t1.addFirst(1);
                t2.addFirst(1);
        assertArrayEquals(t1, t2);
    }

    private void assertArrayEquals(Deque<Integer> t1, ArrayDeque<Integer> t2) {
        if(t1.size() == t2.size()){
            assertEquals(t2.getFirst(), t1.getFirst());
        }
        else{
            System.out.println("Все плохо");
        }
    }

    @org.junit.jupiter.api.Test
    void addLast() {
        Deque<Integer> t1 = new Deque<Integer>();
        ArrayDeque<Integer> t2 = new ArrayDeque<Integer>();
        t1.addLast(2);
        t2.addLast(2);

        if(t1.size() == t2.size()){
            assertEquals(t2.getLast(), t1.getLast());
        }
        else{
            System.out.println("Все плохо");
        }
    }

    @org.junit.jupiter.api.Test
    void removeFirst() {
        Deque<Integer> t1 = new Deque<Integer>();
        ArrayDeque<Integer> t2 = new ArrayDeque<Integer>();
        t1.addLast(2);
        t2.addLast(2);
        t1.addLast(1);
        t2.addLast(1);

        if(t1.size() == t2.size()){
            t1.removeFirst();
            t2.removeFirst();

            if(t1.size() == t2.size()) {
                assertEquals(t2.getFirst(), t1.getFirst());
            }
        }
        else{
            System.out.println("Все плохо");
        }
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        Deque<Integer> t1 = new Deque<Integer>();
        ArrayDeque<Integer> t2 = new ArrayDeque<Integer>();
        t1.addLast(2);
        t2.addLast(2);
        t1.addLast(1);
        t2.addLast(1);

        if(t1.size() == t2.size()){
            t1.removeLast();
            t2.removeLast();

            if(t1.size() == t2.size()) {
                assertEquals(t2.getLast(), t1.getLast());
            }
        }
        else{
            System.out.println("Все плохо");
        }
    }
}