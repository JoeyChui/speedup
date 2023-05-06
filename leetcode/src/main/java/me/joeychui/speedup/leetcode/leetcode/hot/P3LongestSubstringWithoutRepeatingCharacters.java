package me.joeychui.leetcode.hot;

import me.joey.speedup.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int result;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

        }

        return -1;

    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode dummy = head;
        int size = 0;
        while (dummy != null) {
            size += 1;
            dummy = dummy.next;
        }
        int[] result = new int[size];
        dummy = head;
        for (int i=size-1; i>=0; i--) {
            result[i] = dummy.val;
            dummy = dummy.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(2)));
        reversePrint(head);

    }


}
