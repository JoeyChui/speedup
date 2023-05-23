package me.joeychui.speedup;

import me.joeychui.speedup.leetcode.util.ListNode;

public class 奇升偶降链表排序 {
    static ListNode sortParityLinkedList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        // 拆分链表
        // 创建新链表哑节点
        ListNode dummyA = new ListNode(-1), dummyB = new ListNode(-1);
        // 创建链表遍历指针
        ListNode p = head, pa = dummyA, pb = dummyB;
        while (p != null) {
            pa.next = p;
            pa = pa.next;
            p = p.next;
            // 断开
            pa.next = null;
            if (p != null) {
                pb.next = p;
                pb = pb.next;
                p = p.next;
                pb.next = null;
            }
        }
        // 反序链表
        ListNode prev = null;
        p = dummyB.next;
        while (p != null) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }
        dummyB.next = prev;
        // 合并链表
        pa = dummyA.next;
        pb = dummyB.next;
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
               ListNode temp = pa.next;
               pa.next = pb;
               pa = temp;
            } else {
                ListNode temp = pb.next;
                pb.next = pa;
                pb = temp;
            }
        }
        return dummyA.next.val < dummyB.next.val ? dummyA.next : dummyB.next;
    }

    public static void main(String[] args) {
        // 1 6 3 4 5 2
        ListNode head = new ListNode(1, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(2))))));
        ListNode result = sortParityLinkedList(head);
        ListNode.traverse(result);

        // 0,9999,8,9954,17,9942,28,9934,34,9933,37,9915,49,9911,49,9908,81,9904,83,9904,94,9895,97,9875,114,9862,115,9853,124,9848,126,9847,127,9833,152,9829,154,9819,164,9811,183,9810,186,9807,187,9802,192,9797,197,9786,216,9764,253,9759,269,9756,270,9754,279,9747,294,9744,296,9708,297,9689,308,9685,323,9683,336,9683,337,9672,339,9668,346,9664,353,9663,353,9649,356,9643,360,9613,368,9593,379,9591,381,9587,399,9569,428,9567,460,9563,461,9562,495,9559,504,9529,504,9529,512,9517,516,9507,519,9499,523,9484,524,9479,528,9451,537,9441,540,9438,543,9435,563,9426,569,9416,569,9415,573,9412,595,9409,596,9401,596,9391,596,9390,602,9355,606,9336,614,9334,629,9314,639,9301,657,9299,669,9299,690,9294,699,9291,709,9250,710,9228,732,9224,743,9211,774,9207,775,9204,795,9204,846,9188,857,9181,865,9170,871,9170,873,9154,888,9150,902,9126,907,9125,910,9122,925,9117,930,9114,938,9107,952,9097,960,9090,967,9086,973,9080,991,9053,997,9021,1009,9017,1032,9010,1039,9006,1041,8986,1052,8980,1062,8978,1063,8977,1075,897
        String inStr = "0,9999,8,9954,17,9942,28,9934,34,9933,37,9915,49,9911,49,9908,81,9904,83,9904,94,9895,97,9875,114,9862,115,9853,124,9848,126,9847,127,9833,152,9829,154,9819,164,9811,183,9810,186,9807,187,9802,192,9797,197,9786,216,9764,253,9759,269,9756,270,9754,279,9747,294,9744,296,9708,297,9689,308,9685,323,9683,336,9683,337,9672,339,9668,346,9664,353,9663,353,9649,356,9643,360,9613,368,9593,379,9591,381,9587,399,9569,428,9567,460,9563,461,9562,495,9559,504,9529,504,9529,512,9517,516,9507,519,9499,523,9484,524,9479,528,9451,537,9441,540,9438,543,9435,563,9426,569,9416,569,9415,573,9412,595,9409,596,9401,596,9391,596,9390,602,9355,606,9336,614,9334,629,9314,639,9301,657,9299,669,9299,690,9294,699,9291,709,9250,710,9228,732,9224,743,9211,774,9207,775,9204,795,9204,846,9188,857,9181,865,9170,871,9170,873,9154,888,9150,902,9126,907,9125,910,9122,925,9117,930,9114,938,9107,952,9097,960,9090,967,9086,973,9080,991,9053,997,9021,1009,9017,1032,9010,1039,9006,1041,8986,1052,8980,1062,8978,1063,8977,1075,897";
        String[] inArr = inStr.split(",");
        ListNode dummy = new ListNode(-1);
    }
}
