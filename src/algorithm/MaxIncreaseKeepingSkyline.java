package algorithm;

import java.util.Arrays;

public class MaxIncreaseKeepingSkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] col = new int[m];
        int[] row = new int[n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                col[i] = Math.max(grid[i][j], col[i]);
                row[j] = Math.max(grid[i][j], row[j]);
            }
        }
        // 计算结果
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(col[i], row[j]) - grid[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        MaxIncreaseKeepingSkyline maxIncreaseKeepingSkyline = new MaxIncreaseKeepingSkyline();
        int res = maxIncreaseKeepingSkyline.maxIncreaseKeepingSkyline(grid);
        System.out.println(res);
    }

}
