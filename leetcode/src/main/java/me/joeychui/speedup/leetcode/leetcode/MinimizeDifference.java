package me.joeychui.leetcode;

public class MinimizeDifference {

        public static void main(String[] args) {
            int n = 3;
            int result = minimizeDifference(n);
        }

        public static int minimizeDifference(int n) {
            // 构造原始数组
            int[] originalArr = new int[n];
            for (int i = 0; i < n; i++) {
                originalArr[i] = i + 1;
            }

            // 构造新数组，第一个数和原数组最后一个数交换位置
            int[] newArr = new int[n];
            newArr[0] = originalArr[n - 1];
            for (int j = 1; j < n - 1; j += 2) {
                newArr[j] = originalArr[j];
                newArr[j + 1] = originalArr[j - 1];
            }
            if (n % 2 == 0) {
                newArr[n - 1] = originalArr[n - 2];
            }
            newArr[n - 1] = originalArr[0];

            // 计算差的总和
            int diffSum = 0;
            for (int k = 0; k < n; k++) {
                diffSum += Math.abs(newArr[k] - originalArr[k]);
            }

            return diffSum;
        }

}
