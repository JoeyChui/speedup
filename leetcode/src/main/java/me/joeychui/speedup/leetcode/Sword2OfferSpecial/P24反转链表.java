package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import me.joeychui.speedup.leetcode.util.ListNode;

public class P24反转链表 {
    // https://leetcode.cn/problems/UHnkqh/description/?favorite=e8X3pBZi

    // know 方法一：滚动指针
    public ListNode reverseList(ListNode head) {
        // know 滚动指针需要判断 head.next == null
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, pNext = head.next;
        // know 反转链表记得清楚第一个节点的next，避免循环链表
        p.next = null;
        while (pNext != null) {
            ListNode temp = pNext.next;
            pNext.next = p;
            p = pNext;
            pNext = temp;
        }
        return p;
    }


    public static void main(String[] args) {


    }
}
