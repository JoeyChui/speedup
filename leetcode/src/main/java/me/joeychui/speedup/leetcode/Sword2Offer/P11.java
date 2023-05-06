package me.joeychui.speedup.leetcode.Sword2Offer;

public class P11 {

    public static int minArray(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int pivot = (left + right) / 2;
            if (numbers[pivot] < numbers[right]) {
                right = pivot;
            } else if (numbers[pivot] == numbers[right]) {
//                忽略掉一个大的，不能忽略掉小的
                right -= 1;
            } else {
                left = ++pivot;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] in = new int[] {3,3,1,3};
        int out = minArray(in);
    }
}
