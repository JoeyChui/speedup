package me.joeychui.leetcode.Sword2OfferSpecial;

import java.util.LinkedList;
import java.util.Queue;

public class P42最近请求次数 {
    // https://leetcode.cn/problems/H8086Q/?favorite=e8X3pBZi

    // 方法：适合使用队列，队尾进，队首出

    Queue<Integer> queue;

    public P42最近请求次数() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty()) {
            if (queue.peek() < t - 3000) {
                queue.poll();
            } else {
                break;
            }
        }
        return queue.size();

    }

    // 另一种遍历条件的写法：使用queue.peek()
    public int ping2(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();

    }

    public static void main(String[] args) {

    }
}
