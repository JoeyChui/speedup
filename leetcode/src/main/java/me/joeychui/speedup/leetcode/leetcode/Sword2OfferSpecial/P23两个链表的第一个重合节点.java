package me.joeychui.leetcode.Sword2OfferSpecial;

import me.joey.speedup.leetcode.util.ListNode;

public class P23两个链表的第一个重合节点 {
    // https://leetcode.cn/problems/3u1WK4/description/

    // know 方法一：HashSet

    // know 方法二：双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        // know 循环2次的写法 for (int times = 2; times > 0;) {}
        for (int times = 2; times > 0;) {
            if (p1 == null) {
                p1 = headB;
                // know 注意循环变量减一
                times--;
            }
            if (p2 == null) {
                p2 = headA;
            }
            if (p1 == p2) {
                return p1;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }

    // know 方法二的更优写法：不用判断循环两次，因为第二次一定相等，例如会同时到达尾部Null
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {

    }
}
