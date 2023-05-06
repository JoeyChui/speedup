package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import me.joeychui.speedup.leetcode.util.ListNode;

public class P876链表的中间结点 {

    // know 方法一：统计长度，遍历一半，或直接转为数组

    // know 方法二：快慢指针（若链表有奇数个节点，则中间的节点看作是前半部分）
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        // know 注意快慢指针的循环判断条件
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {

    }
}
