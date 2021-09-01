package algorithm;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int cycle = Math.min(m, n) / 2;
        for (int i = 0; i < cycle; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i; j < m - 1 - i; j++) {
                res.add(matrix[j][n-i-1]);
            }
            for (int j = i; j < n - 1 - i; j++) {
                res.add(matrix[m-i-1][n-1-j]);
            }
            for (int j = i; j < m - 1 - i; j++) {
                res.add(matrix[m-j-1][i]);
            }
        }
        if (Math.min(m, n) % 2 == 1) {
            if (m > n) {
                for (int i = 0; i < m - 2 * cycle; i++) {
                    res.add(matrix[cycle + i][n / 2]);
                }
            }else if (n > m) {
                for (int i = 0; i < n - 2 * cycle; i++) {
                    res.add(matrix[m / 2][cycle + i]);
                }
            }else{
                res.add(matrix[m/2][n/2]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 5}, {8, 4}, {0, -1}};
        List<Integer> res = new SpiralOrder().spiralOrder(matrix);
        System.out.println(res);
    }
}
