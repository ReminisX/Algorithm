package algorithm;

public class MinPathSum {
	public int minPathSum(int[][] grid) {
		int[][] matrix = new int[grid.length][grid[0].length];
		// 初始化右下角数
		matrix[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
		// 初始化最右列数
		for(int i = grid.length-2; i >= 0; i--) {
			matrix[i][grid[0].length-1] = grid[i][grid[0].length-1] + matrix[i+1][grid[0].length-1];
		}
		// 初始化最下行数
		for(int j = grid[0].length-2; j >= 0; j--) {
			matrix[grid.length-1][j] = grid[grid.length-1][j] + matrix[grid.length-1][j+1];
		}
		// 遍历矩阵计算最小值
		for(int i = grid.length-2; i>=0; i--) {
			for(int j = grid[0].length-2; j>=0; j--) {
				matrix[i][j] = grid[i][j] + Math.min(matrix[i][j+1], matrix[i+1][j]);
			}
		}
		return matrix[0][0];
    }
}
