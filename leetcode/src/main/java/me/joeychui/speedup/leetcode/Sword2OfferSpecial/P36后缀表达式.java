package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import java.util.Deque;
import java.util.LinkedList;

public class P36后缀表达式 {
    // https://leetcode.cn/problems/8Zf90G/?favorite=e8X3pBZi

    public static int evalRPN(String[] tokens) {
        if (tokens == null) {
            return -1;
        }
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            // know 记得字符串比较用equals()
            // know 这里也可以用switch
            if (s.equals("-")) {
                // know 这里的顺序是先y后x，栈和队列要考虑先后顺序
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
            } else if (s.equals("+")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
            } else if (s.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                int res = x / y;
                stack.push(res);
            } else if (s.equals("*")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] in = new String[] {"4","13","5","/","+"};
        int out = evalRPN(in);

    }
}
