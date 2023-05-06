package me.joeychui.leetcode.Sword2Offer;

public class p61 {

    public boolean isStraight(int[] nums) {
//        一开始题理解有误：0可以作为任何数组，就能在任何地方充当顺子
        quickSort(nums, 0, nums.length - 1);
        int zero = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == nums[i + 1]) {
//                不要忘了判断相等的情况
                return false;
            } else if (nums[i] == nums[i + 1] - 1) {

            } else if (nums[i + 1] - nums[i] - 1 <= zero) {
//                这种情况的条件是<= 不是>=
                zero = zero - nums[i + 1] + nums[i] + 1;
            } else {
                return false;
            }
        }
        return true;
    }

    void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            swap(nums, left, right);
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        return left;
    }

    void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] in = new int[] {9,10,4,0,9};
        p61 p = new p61();
        boolean out = p.isStraight(in);

    }
}
