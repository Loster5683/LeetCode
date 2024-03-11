package base;

import java.util.*;

class MaxQueue {

    LinkedList<Integer> linkedList;
    Queue<Integer> v ;

    public MaxQueue() {
        v = new ArrayDeque<>();
        linkedList = new LinkedList<>();
    }

    public int max_value() {
        if (linkedList.size() == 0) {
            return -1;
        }
        return linkedList.peekLast();
    }

    public void push_back(int value) {
        v.offer(value);
        while (!linkedList.isEmpty() && linkedList.peekFirst() <= value) {
            linkedList.pollFirst();
        }
        linkedList.push(value);
    }

    public int pop_front() {
        if (v.size() == 0) {
            return -1;
        }
        int value = v.poll();
        if (value == linkedList.peekLast()) {
            linkedList.pollLast();
        }
        return value;
    }
}