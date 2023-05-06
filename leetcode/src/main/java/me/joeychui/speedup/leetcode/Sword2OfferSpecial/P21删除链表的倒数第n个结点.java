package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import me.joeychui.speedup.leetcode.util.ListNode;

public class P21删除链表的倒数第n个结点 {

    // know 方法一：遍历求长度，时间复杂度：O(n)，但需要两次遍历，空间复杂度：O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode p = head;
        while (p != null) {
            size += 1;
            p = p.next;
        }
        if (size == n) {
            // know 注意判断边界条件
            return head.next;
        }
        p = head;
        for (int i = 0; i < size - n - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
    // know 方法二：快慢指针，时间复杂度：O(n)，只需要一次遍历，空间复杂度：O(1)
    // know 此类链表题目一般都是使用双指针法解决的，例如寻找距离尾部第 k 个节点、寻找环入口、寻找公共尾部入口等。
    // know 快指针比慢指针快k个节点，当快指针到达结尾Null的时候，慢指针就是倒数第K个节
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        // know int k = 0; while (k < n) {k++;} 循环了n次
        // know int k = n; while (k > 0) {k--;} 循环了k次(也是n次)
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode in = new ListNode(1, new ListNode(2));
        ListNode out = removeNthFromEnd(in, 2);
    }
}
