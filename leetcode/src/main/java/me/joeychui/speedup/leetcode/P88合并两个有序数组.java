package me.joeychui.speedup.leetcode;

public class P88合并两个有序数组 {

    // know 方法一：正向双指针，时间复杂度：O(2n+2m)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int[] res = new int[n + m];
        int i = 0, j = 0, x = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[x] = nums1[i];
                i++;
                x++;
            } else {
                res[x] = nums2[j];
                j++;
                x++;
            }
        }
        while (i < m) {
            res[x] = nums1[i];
            i++;
            x++;
        }
        while (j < n) {
            res[x] = nums2[j];
            j++;
            x++;
        }
        for (int num = 0; num < res.length; num++) {
            nums1[num] = res[num];
        }
    }

    // know 方法二：逆向双指针，时间复杂度：O(n+m)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int i = m - 1, j = n - 1, x = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[x] = nums1[i];
                i--;
                x--;
            } else {
                nums1[x] = nums2[j];
                j--;
                x--;
            }
        }
        while (j >= 0) {
            nums1[x] = nums2[j];
            j--;
            x--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        merge(nums1, 3, nums2, 3);
    }

}
