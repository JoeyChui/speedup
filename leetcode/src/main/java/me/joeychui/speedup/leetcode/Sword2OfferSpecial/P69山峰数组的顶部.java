package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

public class P69山峰数组的顶部 {
    // https://leetcode.cn/classic/problems/B1IidL/description/

    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null) return -1;
        int i = 0, j = arr.length - 1;
        while (i<=j) {
            int pivot = (i + j) / 2;
            if (arr[pivot] > arr[pivot-1] && arr[pivot] > arr[pivot+1]) {
                return pivot;
            } else if (arr[pivot] < arr[pivot-1] && arr[pivot] > arr[pivot+1]) {
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
