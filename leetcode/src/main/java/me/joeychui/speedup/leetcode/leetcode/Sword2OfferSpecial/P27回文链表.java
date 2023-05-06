package me.joeychui.leetcode.Sword2OfferSpecial;

import me.joey.speedup.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P27回文链表 {

    // know 方法一：转换成线性表-ArrayList
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        // know 双指针遍历列表
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        return true;
    }

    // know 方法二：栈

    // know 方法二：递归
    private ListNode frontPointer;
    public boolean isPalindromeRecursion(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
