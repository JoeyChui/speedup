package me.joeychui.leetcode.Sword2Offer;

import java.util.HashMap;
import java.util.Map;

public class P50 {

    public static char firstUniqChar(String s) {
        if (s == null) return ' ';
        Map<Character, Integer> cache = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (cache.containsKey(s.charAt(i))) {
                cache.put(s.charAt(i), cache.get(s.charAt(i)) + 1);
            } else {
                cache.put(s.charAt(i), 1);
            }

        }
        for (int i = 0; i < s.length(); i++) {
            if (cache.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String in = "loveleetcode";
        char out = firstUniqChar(in);

    }
}
