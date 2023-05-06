package me.joeychui.leetcode.Sword2OfferSpecial;

public class P29排序的循环链表 {
    // https://leetcode.cn/problems/4ueAj6/description/

    // know 方法一：遍历循环链表，时间复杂度：O(n), 空间复杂度：O(1)
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        if (head.next == head) {
            Node node = new Node(insertVal);
            head.next = node;
            node.next = head;
            return head;
        }
        Node p = head, pNext = head.next;
        // know 循环链表遍历条件（适合用do-while）
        while (pNext != head) {
            // 对应 3 4 5
            if ((p.val <= insertVal && pNext.val >= insertVal)
                    // 对应 5 6 3
                    || (p.val > pNext.val && insertVal >= p.val)
                    // 对应 5 2 3
                    || (p.val > pNext.val && insertVal <= pNext.val)) {
                Node node = new Node(insertVal);
                p.next = node;
                node.next = pNext;
                return head;
            }
            p = p.next;
            pNext = pNext.next;
        }
        Node node = new Node(insertVal);
        p.next = node;
        node.next = pNext;
        return head;
    }


    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
