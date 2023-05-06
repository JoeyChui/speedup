package me.joeychui.speedup.leetcode.Sword2Offer;

import me.joeychui.speedup.leetcode.util.Sort.QuickSort;

import java.util.Arrays;

public class p40 {

    public static int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
        QuickSort.quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }


    public static void main(String[] args) {
        getLeastNumbers(new int[]{3,2,1,4,7,2,6,4}, 3);

    }
}
