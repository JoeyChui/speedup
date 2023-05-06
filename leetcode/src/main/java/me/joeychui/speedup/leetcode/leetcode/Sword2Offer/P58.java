package me.joeychui.leetcode.Sword2Offer;

public class P58 {

    public static String reverseWords(String s) {
        String res = "";
        s = s.trim();
        int i = s.length()-1, j = s.length();
        while (i >= 0) {
            if (s.charAt(i) == ' ' || i == 0) {
                for (int p = i; p < j; p++) {
                    res = res + (res.length() > 0 && res.charAt(res.length()-1) == ' ' && s.charAt(p) == ' ' ? "" : s.charAt(p));
                }
                j = i--;
                res += res.charAt(res.length()-1) == ' ' ? "" : ' ';
            } else {
                i--;
            }
        }
        return res.trim();
    }

    public static void main(String[] args) {
        String out = reverseWords("a good   example");
    }
}
