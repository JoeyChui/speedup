package me.joeychui.leetcode.Sword2Offer;

import java.util.HashMap;
import java.util.Map;

public class P39 {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                cache.put(nums[i], cache.get(nums[i]) + 1);
            } else {
                cache.put(nums[i], 1);
            }
            if (cache.get(nums[i]) > (nums.length / 2)) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] in = new int[] {1};
        int out = majorityElement(in);

    }
}
