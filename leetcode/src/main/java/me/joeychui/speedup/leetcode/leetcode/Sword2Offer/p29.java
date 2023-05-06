package me.joeychui.leetcode.Sword2Offer;

public class p29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        int h = matrix.length;
        int l = matrix[0].length;
        int[] result = new int[h * l];
        for (int i = 0, x = 0, y = h - 1; i < result.length; i++) {
            while (x < l) {
                result[i] = matrix[x][y];
                x++;
            }
            while (y >= 0) {
                result[i] = matrix[x][y];
                y--;
            }
            while (x < l) {
                result[i] = matrix[x][y];
                x++;
            }

        }
        // todo
        return null;

    }


    public static void main(String[] args) {

    }
}
