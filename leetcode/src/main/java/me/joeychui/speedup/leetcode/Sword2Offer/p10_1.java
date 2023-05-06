package me.joeychui.speedup.leetcode.Sword2Offer;

import java.util.HashMap;
import java.util.Map;

public class p10_1 {
    static Map<Integer, Integer> cache = new HashMap<>();

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n) % 1000000007;
        } else {
            int res = fib(n - 1) + fib(n - 2);
            cache.put(n, res);
            return res % 1000000007;
        }
    }

    public static void main(String[] args) {
        fib(405);
        System.out.println(1);

    }
}
