package me.joeychui.leetcode.Sword2OfferSpecial;

import java.util.Deque;
import java.util.LinkedList;

public class P37小行星碰撞 {
    // https://leetcode.cn/problems/XagZNi/?favorite=e8X3pBZi

    // know 方法一：多次遍历，直到没有相反的符号

    // know 方法二：栈，遇到相反符号，就出栈一个

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()
                    || stack.peek() * asteroids[i] > 0
                    || stack.peek() < 0 && asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else if (stack.peek() + asteroids[i] > 0) {
                continue;
            } else if (stack.peek() + asteroids[i] == 0) {
                stack.pop();
            } else {
                stack.pop();
                i--;
            }
        }
        int[] res = new int[stack.size()];
        // know 记得考虑出栈顺序，例如栈转换成数组时要反序
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
