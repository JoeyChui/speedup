package me.joeychui.leetcode.Sword2Offer;

import me.joey.speedup.leetcode.util.ListNode;

public class p22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        int serial = size - k + 1;
        for (int i = 1; i < serial; i++) {
            head = head.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        getKthFromEnd(l, 2);

    }
}
