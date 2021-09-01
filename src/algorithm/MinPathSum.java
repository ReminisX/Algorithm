package algorithm;

public class MinPathSum {
	public int minPathSum(int[][] grid) {
		int[][] matrix = new int[grid.length][grid[0].length];
		// ��ʼ�����½���
		matrix[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
		// ��ʼ����������
		for(int i = grid.length-2; i >= 0; i--) {
			matrix[i][grid[0].length-1] = grid[i][grid[0].length-1] + matrix[i+1][grid[0].length-1];
		}
		// ��ʼ����������
		for(int j = grid[0].length-2; j >= 0; j--) {
			matrix[grid.length-1][j] = grid[grid.length-1][j] + matrix[grid.length-1][j+1];
		}
		// �������������Сֵ
		for(int i = grid.length-2; i>=0; i--) {
			for(int j = grid[0].length-2; j>=0; j--) {
				matrix[i][j] = grid[i][j] + Math.min(matrix[i][j+1], matrix[i+1][j]);
			}
		}
		return matrix[0][0];
    }
}
