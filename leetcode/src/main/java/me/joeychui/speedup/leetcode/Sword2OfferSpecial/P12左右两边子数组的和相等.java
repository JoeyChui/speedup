package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import java.util.Arrays;

public class P12左右两边子数组的和相等 {
    // https://leetcode.cn/problems/tvdfij/description/

    // know 方法一：求和折半再遍历
    public int pivotIndex(int[] nums) {
        // know Java数组求和：Arrays.stream(nums).sum();
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    // know 方法二：双指针左右累加趋近相同值（error）
    // know int i = 0, j = nums.length - 1; while (i <= j) {i++; j--;} 循环中双指针相等情况只会出现一次，不用担心会执行多遍
    public static int pivotIndexFail(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        int leftSum = 0, rightSum = 0;
        while (i < j) {
            // Java绝对值：Math.abs()
            if (Math.abs(rightSum - leftSum - nums[i]) < Math.abs(rightSum + nums[j] - leftSum)) {
                leftSum += nums[i];
                i++;
            } else {
                rightSum += nums[j];

            }
        }
        if (leftSum == rightSum) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,-1,0,1,0,-1};
        int out = pivotIndexFail(nums);
    }
}
