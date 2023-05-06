package me.joeychui.leetcode.Sword2OfferSpecial;

import me.joey.speedup.leetcode.util.ListNode;

public class P22链表中环的入口节点 {
    // https://leetcode.cn/problems/c32eOV/

    // know 方法一：快慢指针，慢指针步速1，快指针步速2，相遇后快指针从头开始遍历，并且步速改为1，再次相遇后即是环入口
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        // know 启动条件和循环条件一样时候适合用do-while写法，可以先进行一次循环
        } while (slow != fast);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
