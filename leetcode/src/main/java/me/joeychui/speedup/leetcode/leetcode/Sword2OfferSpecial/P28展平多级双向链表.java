package me.joeychui.leetcode.Sword2OfferSpecial;

import java.util.Deque;
import java.util.LinkedList;

public class P28展平多级双向链表 {

    // know 方法一：深度优先遍历，栈-Deque-LikedList
    public static Node flatten(Node head) {
        if (head == null) return null;
        Deque<Node> stack = new LinkedList<>();
        // know 新建链表的写法：声明dummy和p，迭代p.next，返回dummy.next
        Node dummy = new Node(-1), p = dummy;
        stack.push(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            while (node != null) {
                p.next = node;
                p.next.prev = p;
                // know 以后这里先写p.next(新链表)，再写node.child(原链表)
                p = p.next;
                if (node.child == null) {
                    node = node.next;
                } else {
                    stack.push(node.next);
                    stack.push(node.child);
                    node.child = null;
                    break;
                }
            }
        }
        // know 记得双向链表时处理dummy.next.prev，单向链表就不用
        dummy.next.prev = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node i = new Node(1); // todo 为啥要静态？
        Node in = new Node(1, null, new Node(2), new Node(3));
        Node out = flatten(in);

    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

}
