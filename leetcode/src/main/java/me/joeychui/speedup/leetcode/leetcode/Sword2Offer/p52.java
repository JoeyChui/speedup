package me.joeychui.leetcode.Sword2Offer;

import me.joey.speedup.leetcode.util.ListNode;

public class p52 {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        if (pA == null || pB == null) {
            return null;
        }
        int i = 1;
        while (i < 3) {
            if (pA == null) {
                i++;
                pA = headB;
            } else if (pB == null) {
                pB = headA;
            } else if (pA == pB) {
                return pA;
            }
            else {
                pA = pA.next;
                pB = pB.next;
            }
        }
        return null;

    }


    public static void main(String[] args) {

    }
}
