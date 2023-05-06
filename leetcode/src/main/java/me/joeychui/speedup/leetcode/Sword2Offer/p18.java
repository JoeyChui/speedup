package me.joeychui.speedup.leetcode.Sword2Offer;

import me.joeychui.speedup.leetcode.util.ListNode;

public class p18 {

    public ListNode deleteNode(ListNode head, int val) {
       ListNode p = head;
       ListNode pre = null;
        while (p != null) {
            if (p.val == val) {
                if (pre == null) {
                    return p.next;
                }
                pre.next = p.next;
                break;
            }
            pre = p;
            p = p.next;
        }
        return head;
    }


    public static void main(String[] args) {

    }
}
