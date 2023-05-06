package me.joeychui.speedup.leetcode.Sword2Offer;


import java.util.HashMap;
import java.util.Map;

public class P35 {

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> cache = new HashMap<>();
        Node dummy = new Node(-1);
        Node p = dummy;
        while (head != null) {
            p.next = new Node(head.val);
            cache.put(head, p.next);
            head = head.next;
            p = p.next;
        }
        p = dummy.next;
        while (head != null) {
            if (head.random != null) {
                p.random = cache.get(head.random);
            }
            head = head.next;
            p = p.next;
        }
        return dummy.next;
    }

    // 递归解法
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (cachedNode.containsKey(head)) {
            return cachedNode.get(head);
        } else {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
//          上面的cache是为了下面两行语句共用，无论哪个语句创建了新节点，另一个语句也可以用
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
            return headNew;
        }
    }

//    HashMap解法
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>();
        Node p = head;

        // 复制原链表和复制链表中的节点
        while (p != null) {
            nodeMap.put(p, new Node(p.val));
            p = p.next;
        }

        // 处理 next 和 random 指针
        p = head;
        while (p != null) {
            nodeMap.get(p).next = nodeMap.get(p.next);
            nodeMap.get(p).random = nodeMap.get(p.random);
            p = p.next;
        }

        return nodeMap.get(head);
    }


//    后继复制链表再分拆
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
    // 复制每个节点，并插入到原节点之后
    Node p = head;
        while (p != null) {
        Node node = new Node(p.val);
        node.next = p.next;
        p.next = node;
        p = node.next;
    }

    // 处理 random 指针
    p = head;
        while (p != null) {
        if (p.random != null) {
            p.next.random = p.random.next;
        }
        p = p.next.next;
    }

    // 分离两个链表
    p = head;
    Node newHead = head.next;
        while (p != null) {
        Node temp = p.next;
        p.next = temp.next;
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        p = p.next;
    }

        return newHead;
}





    public static void main(String[] args) {


    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

}
