package me.joeychui.leetcode.Sword2OfferSpecial;

public class P70排序数组中只出现一次的数字 {

    public int singleNonDuplicate(int[] nums) {
        if (nums == null) return -1;
        int i = 0, j = nums.length - 1;
        while (i<=j) {
            int pivot = (i + j) / 2;
            if (nums[pivot] != nums[pivot-1] && nums[pivot] != nums[pivot+1]) {
                return pivot;
            } else if (nums[pivot] == nums[pivot-1] && (pivot-i+1)/2 == 0) {
                i = pivot;
            } else if (nums[pivot] == nums[pivot-1] && (pivot-i+1)/2 != 0) {
                j = pivot;
            } else if (nums[pivot] == nums[pivot+1] && (j - pivot + 1) / 2 == 0) {
                j = pivot;
            } else {
                i = pivot;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
