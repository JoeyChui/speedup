package me.joeychui.leetcode;

public class P4 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        if (matrix.length == 0) return false;
        int n = matrix[0].length, m = matrix.length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
