package top.lconcise.practice.stack_demo;

/**
 * 基于链表实现的栈.
 *
 * @author: liusj
 * @date: 2021/12/30
 */
public class StackBasedOnLinkedList {

    private Node top = null;

    public void push(int data) {
        Node newNode = new Node(data, null);

        if (top == null) {
            this.top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            return -1;
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}


