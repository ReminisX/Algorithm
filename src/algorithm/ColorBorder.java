package algorithm;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

public class ColorBorder {

    private boolean[][] matrix;

    private int color;

    public void bfs(int[][] grid, int row, int col){
        // 是否为颜色边界
        boolean flag = true;
        // 是否为矩形边界
        boolean border = false;
        // 当前点已遍历
        matrix[row][col] = true;
        // 是否边界、是否遍历过
        if(col+1 < matrix[row].length){
            if(!matrix[row][col + 1]){
                if (grid[row][col+1] == grid[row][col]){
                    bfs(grid, row, col+1);
                }else{
                    flag = false;
                }
            }
        }else{
            border = true;
        }

        if(col-1 >= 0){
            if(!matrix[row][col - 1]) {
                if (grid[row][col - 1] == grid[row][col]) {
                    bfs(grid, row, col - 1);
                } else {
                    flag = false;
                }
            }
        }else{
            border = true;
        }

        if(row+1 < matrix.length){
            if(!matrix[row + 1][col]){
                if (grid[row+1][col] == grid[row][col]){
                    bfs(grid, row+1, col);
                }else{
                    flag = false;
                }
            }
        }else{
            border = true;
        }

        if(row-1 >= 0){
            if(!matrix[row - 1][col]){
                if (grid[row-1][col] == grid[row][col]){
                    bfs(grid, row-1, col);
                }else{
                    flag = false;
                }
            }
        }else{
            border = true;
        }

        if(!flag || border){
            grid[row][col] = color;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.matrix = new boolean[grid.length][grid[0].length];
        this.color = color;
        bfs(grid, row, col);
        return grid;
    }

    public static void main(String[] args) {
        ColorBorder c = new ColorBorder();
        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
        int row = 1;
        int col = 1;
        int color = 2;
        int[][] res = c.colorBorder(grid, row, col, color);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
