package me.joeychui.speedup.problem;

public class P5最长回文子串 {

    // 题目：给你一个字符串 s，找到 s 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;
        int maxLen = 0, maxLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                for (int left = i, right = i + 1; left >= 0 && right < s.length();) {
                    if (s.charAt(left) == s.charAt(right)) {
                        int len = right - left + 1;
                        if (len > maxLen) {
                            maxLen = len;
                            maxLeft = left;
                        }
                        left--;
                        right++;
                    }
                }
            } else if ((i+2 < s.length() && s.charAt(i) == s.charAt(i+2))) {
                for (int left = i, right = i + 2; left >= 0 && right < s.length();) {
                    if (s.charAt(left) == s.charAt(right)) {
                        int len = right - left + 1;
                        if (len > maxLen) {
                            maxLen = len;
                            maxLeft = left;
                        }
                        left--;
                        right++;
                    }
                }

            }
        }
        return s.substring(maxLeft, maxLeft + maxLen);
    }

    public static void main(String[] args) {
        String res = longestPalindrome("abcdcb");

    }
}
