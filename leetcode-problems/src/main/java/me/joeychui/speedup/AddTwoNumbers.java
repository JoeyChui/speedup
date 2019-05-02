package me.joeychui.speedup;

/**
 * @author: cuilihui
 * @date: 2019-05-01
 *
 * p2. Add Two Numbers
 */
public class AddTwoNumbers {

    // 1 dummyHead
    // 2 加法过程 拆解为:
    //      sum = carry + x + y;
    //      carray = sum / 10;
    //      new ListNode(sum % 10);
    // 3 三元运算符 获取默认值
    // 4 while (l1 != null || l2 != null)
    // 5 边界检查 循环的首次和末次
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0), p = l3;
        while (l1 != null || l2 != null) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            int sum = i + j;
            if (sum >= 10) {
                sum = sum % 10;
                if (l1.next == null) {
                    l1.next = new ListNode(1);
                } else {
                    l1.next.val += 1;
                }
            }
            p.next = new ListNode(sum);
            l1 = l1 == null ? null : l1.next;
            l2 = l1 == null ? null : l2.next;
            p = p.next;
        }
        return l3.next;
    }

    // 题解
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), p = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = carry + x + y;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);

            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        p.next = carry <= 0 ? null : new ListNode(carry);
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
