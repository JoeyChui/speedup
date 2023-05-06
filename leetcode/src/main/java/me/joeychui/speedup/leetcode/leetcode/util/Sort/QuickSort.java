package me.joeychui.leetcode.util.Sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums, int left, int right) {
        // know 写循环的时候要保证循环条件会变成False
        // know 这里是递归的if退出条件
        if (left >= right) return;
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    static int partition(int[] arr, int left, int right) {
        // 1 选取左侧第一个数为pivot
        int pivot = arr[left];
        while (left < right) {
            // know 注意这里是 >=
            // 2 从右侧找到第一个小于pivot的
            while (left < right && arr[right] >= pivot) right--;
            // 3 放到当前pivotIndex处(left)
            arr[left] = arr[right];
            // 4 从左侧找到第一个大于pivot的
            while (left < right && arr[left] <= pivot) left++;
            // 5 放到当前pivotIndex处(right)
            arr[right] = arr[left];
        }
        // 左右指针重合，当前为轴
        arr[left] = pivot;
        // 返回pivotIndex
        return left;
    }

    private static int partition2(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static int partition3(int[] arr, int left, int right) {
        // 完整荷兰国旗解法
        int pivot = arr[left];
        int less = left;
        int greater = right;
        int i = left + 1;
        while (i <= greater) {
            if (arr[i] < pivot) {
                swap(arr, i, less);
                i++;
                less++;
            } else if (arr[i] > pivot) {
                swap(arr, i, greater);
                greater--;
            } else {
                i++;
            }
        }
        return less;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i >= j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {4, 8, 1, 2, 7, 2, 8, 4, 4};
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
