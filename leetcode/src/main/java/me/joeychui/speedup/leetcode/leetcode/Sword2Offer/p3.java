package me.joeychui.leetcode.Sword2Offer;

import java.util.HashSet;
import java.util.Set;

public class p3 {

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> cache = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (cache.contains(nums[i])) {
                return nums[i];
            } else {
                cache.add(nums[i]);
            }

        }
        return -1;

    }


    public static void main(String[] args) {

    }
}
