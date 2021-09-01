package algorithm;

import java.util.Arrays;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int index = 0;
        int cycle = n/2;
        for (int i = 0; i < cycle; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                matrix[i][j] = ++index;
            }
            for (int j = i; j < n - 1 - i; j++) {
                matrix[j][n-i-1] = ++index;
            }
            for (int j = i; j < n - 1 - i; j++) {
                matrix[n-i-1][n-1-j] = ++index;
            }
            for (int j = i; j < n - 1 - i; j++) {
                matrix[n-j-1][i] = ++index;
            }
        }

        if ( n % 2 == 1){
            matrix[n/2][n/2] = ++index;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] m = new GenerateMatrix().generateMatrix(8);
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
}
