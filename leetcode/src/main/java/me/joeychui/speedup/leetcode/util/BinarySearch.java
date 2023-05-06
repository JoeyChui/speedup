package me.joeychui.speedup.leetcode.util;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }

    // 二分查找第一个大于target
    public int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    // 二分查找第一个大于等于target
    public int binarySearch3(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    // 二分查找0～n-1中缺失的数字（剑指 Offer 53 - II）
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 二分查找旋转数组最小值（剑指 Offer 11）
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) { // 这里可不可以是left <= right？
            int pivot = (left + right) / 2;
            if (numbers[pivot] < numbers[right]) {
                right = pivot;
            } else if (numbers[pivot] > numbers[right]) {
                left = pivot + 1;
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }


// tip1: 使用boolean作为开关，true && B == B，false && B == false
// tip2: A && B 的相反条件是 A || B 吗？答案：不是。

}
