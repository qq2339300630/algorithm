package cjj.algorithm.deque641;

import java.util.ArrayDeque;
import java.util.Deque;

class MyCircularDeque {

    Deque<Integer> deque = new ArrayDeque<>();
    private int size = 0;

    public MyCircularDeque(int k) {
        size = k;
    }

    public boolean insertFront(int value) {
        if (deque.size() < size) {

        } else {
            return false;
        }
        deque.offerFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if (deque.size() < size) {

        } else {
            return false;
        }
        deque.offerLast(value);
        return true;
    }

    public boolean deleteFront() {
        if (!deque.isEmpty()) {
            deque.pollFirst();
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteLast() {
        if (!deque.isEmpty()) {
            deque.pollLast();
            return true;
        } else {
            return false;
        }
    }

    public int getFront() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public int getRear() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.size() == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
