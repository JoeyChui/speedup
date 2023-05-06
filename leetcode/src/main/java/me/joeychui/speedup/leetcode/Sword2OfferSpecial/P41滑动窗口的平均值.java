package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import java.util.LinkedList;
import java.util.Queue;

public class P41滑动窗口的平均值 {
    // https://leetcode.cn/problems/qIsx9U/?favorite=e8X3pBZi

    // know 声明对象变量
    Queue<Integer> queue;
    int windowSize;
    // know 这里不存储均值，防止精度丢失
    int sum;

    /** Initialize your data structure here. */
    public P41滑动窗口的平均值(int size) {
        // know 构造函数中初始化对象变量
        queue = new LinkedList<>();
        windowSize = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() >= windowSize) {
            sum -= queue.poll();
        } else {
            queue.offer(val);
        }
        sum += val;
        // 注意返回的是 double
        return ((double) sum) / queue.size();
    }


    public static void main(String[] args) {

    }
}
