package me.joeychui.leetcode.Sword2Offer;

public class p21 {

    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[nums.length];
        int x = 0, y = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                result[x] = nums[i];
                x++;
            } else {
                result[y] = nums[i];
                y--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
