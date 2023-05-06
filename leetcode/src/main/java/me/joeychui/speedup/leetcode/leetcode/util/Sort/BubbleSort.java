package me.joeychui.leetcode.util.Sort;

import java.util.Arrays;

public class BubbleSort {

    // know 冒泡排序：比较 nums[j] > nums[j+1]
    //      第一趟 i=0, j取值为0到n-2 (< n-1), 已排序好的数组为0个
    //      第二趟 i=1, j取值为0到n-3 (= n-1-i), 已排序好的数组为1个
    static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    // know 冒泡排序变种：比较 nums[i] > nums[j]
    static int[] bubbleSort2(int[] nums) {
        // know 每一趟 i固定为i, j从i+1到n-1; 一趟中最小的数字放到了nums[i];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] in = new int[] {40,30,1,6,5,6,2,8,9,1,3,4,2,15,2,6,7};
        int[] out = bubbleSort(in);
        System.out.println(Arrays.toString(out));
    }
}
