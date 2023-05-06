package me.joeychui.speedup.leetcode.Sword2Offer;

public class P57 {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] in = new int[] {2,7,11,15};
        int[] out = twoSum(in, 9);
    }
}
