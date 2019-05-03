package me.joeychui.speedup;

/**
 * @author: cuilihui
 * @date: 2019-05-03
 */
public class RegularExpressionMatching {

    // if there is no asterisk -- for
    public boolean isMatchFor(String string, String pattern) {
        if (string.length() != pattern.length()) return false;
        char c;
        for (int i = 0; i < string.length(); i++) {
            c = pattern.charAt(i);
            if (!(c == '.' || c == string.charAt(i))) return false;
        }
        return true;
    }

    // if there is no asterisk -- recursion
    public boolean isMatchRecursion(String string, String pattern) {
        if (string.length() != pattern.length()) return false;
        if (string.length() == 0) return true;
        char c;
        if (string.length() == 1) {
            c = pattern.charAt(0);
            return c == '.' || c == string.charAt(0);
        }
        return isMatchRecursion(string.substring(1), pattern.substring(1));
    }

    // the string contains: a-b A-B . *
    // leetcode 题解 巧妙的利用递归
    // When a star is present, we may need to check many different suffixes of the text
    // and see if they match the rest of the pattern.
    public boolean isMatch(String string, String pattern) {
        if (pattern.isEmpty()) return string.isEmpty();
        boolean firstMatch = string.length() >= 1 &&
                (pattern.charAt(0) == '.' || pattern.charAt(0) == string.charAt(0));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(string, pattern.substring(2)) ||
                    firstMatch && isMatch(string.substring(1), pattern);
        } else {
            return firstMatch && isMatch(string.substring(1), pattern.substring(1));
        }
    }

}
