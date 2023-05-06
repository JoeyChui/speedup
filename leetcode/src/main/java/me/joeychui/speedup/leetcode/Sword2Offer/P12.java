package me.joeychui.speedup.leetcode.Sword2Offer;

public class P12 {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 记得新建visited数组
                    int[][] visited = new int[n][m];
                    if (check(board, i, j, visited, word, 0)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    static boolean check(char[][] board, int i, int j, int[][] visited, String word, int k) {
//        visited[i][j] == 1 条件要放到前面
        if (visited[i][j] == 1 || board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = 1;
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] direction : directions) {
            int nexti = i + direction[0], nextj = j + direction[1];
            // 记得判断下标是否越界
            if (nexti < 0 || nexti >= board.length || nextj < 0 || nextj >= board[0].length) {
                continue;
            }
            if (check(board, nexti, nextj, visited, word, k+1)) {
                return true;
            }
        }
        visited[i][j] = 0;
        return false;
    }


    public static void main(String[] args) {
        char[][] in1 = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String in2 = "ABCB";
        boolean out = exist(in1, in2);

        in1 = new char[][] {{'A'}};
        in2 = "A";
        out = exist(in1, in2);

    }
}
