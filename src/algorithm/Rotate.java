package algorithm;

public class Rotate {
	public void rotate(int[][] matrix) {
		
		for(int i = 0; i < matrix.length/2 + 1; i++) {
			for(int j = i; j < matrix.length - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length-1-j][i];
				matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j];
				matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i];
				matrix[j][matrix.length-1-i] = temp;
			}
		}
    }
	
	public static void main(String[] args) {
		Rotate R = new Rotate();
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		R.rotate(matrix);
		for(int[] m : matrix) {
			for(int i : m) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
