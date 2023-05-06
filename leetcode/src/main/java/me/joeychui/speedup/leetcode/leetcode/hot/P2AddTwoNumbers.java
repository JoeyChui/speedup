package me.joeychui.leetcode.hot;

import me.joey.speedup.leetcode.util.ListNode;

public class P2AddTwoNumbers {

//    解法1 遍历链表, 两个不等长链表（最长遍历 或者 复制长尾）
//    解法2 递归链表

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            l1 = l1 == null ? new ListNode(0, null) : l1;
            l2 = l2 == null ? new ListNode(0, null) : l2;
            dummy.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return result.next;
    }

    public static ListNode addTwoNumberswhile(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode result1 = result;
        int b = 0;
        do {
            l1 = l1 == null ? new ListNode(0, null) : l1;
            l2 = l2 == null ? new ListNode(0, null) : l2;
            if (l1.val + l2.val + b < 10) {
                result.val = l1.val + l2.val + b;
                b = 0;
            } else {
                result.val = l1.val + l2.val + b - 10;
                b = 1;
            }
            result.next = new ListNode();
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        } while(l1 != null || l2 != null);
        result.val = l1.val + l2.val + b;
        result.next = null;
        return result1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = P2AddTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
