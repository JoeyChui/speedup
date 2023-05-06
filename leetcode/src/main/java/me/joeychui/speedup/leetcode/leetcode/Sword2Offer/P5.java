package me.joeychui.leetcode.Sword2Offer;

public class P5 {

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res += "%20";
            } else {
                res += s.charAt(i);
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
