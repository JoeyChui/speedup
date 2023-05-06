package me.joeychui.speedup.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author cuilihui
 * @date 2019-05-01
 *
 * p20. Valid Parentheses
 */
public class ValidParentheses {

    // solution 1: Too slow, because of too many string operations. Like subString()
    // and + operation with new StringBuilder(), contains().
    // 1 利用 stack 的特点来处理括号层次关系
    // 2 按照题目要求，"" 返回 true
    public boolean validParentheses(String s) {
        if (s == null) return false;
        String stack = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack = stack + c;
            } else {
                if ("".equals(stack)) return false;
                int leftPos = stack.length() - 1;
                if (!isPair(stack.charAt(leftPos), c)) return false;
                stack = stack.substring(0, leftPos);
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    // solution 2: Slower than solution 1, because using recursion and + operation.
    public boolean validParentheses2(String s) {
        if (s == null) return false;
        if ("".equals(s)) return true;
        for (int i = 0; i < s.length(); i++) {
            if (isRight(s.charAt(i))) {
                if (i == 0) return false;
                if (isPair(s.charAt(i-1), s.charAt(i)))
                    return validParentheses2(s.substring(0, i - 1).concat(s.substring(i + 1)));
                else return false;
            }
        }
        return false;
    }

    // solution 3: Very brief, but takes 10 times longer than other solutions.
    // 巧妙的是：一定存在一对相邻闭合括号，以此作为入口，推陈出新
    public boolean validParentheses3(String s) {
        if (s == null) return false;
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");
        }
        return "".equals(s);
    }

    // 入参顺序先左括号后右括号
    private boolean isPair(char left, char right) {
        if (left == '(' && right == ')') return true;
        else if (left == '[' && right == ']') return true;
        else if (left == '{' && right == '}') return true;
        return false;
    }

    // 字符操作 快于 字符串操作，即：== 快于 contains
    private boolean isRight(char c) {
        if (c == ')' || c == ']' || c == '}')
            return true;
        return false;
    }

    private boolean isLeft(char c) {
        if (c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    //todo
    public boolean validParentheses4(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

}
