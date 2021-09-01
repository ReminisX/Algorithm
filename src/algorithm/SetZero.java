package algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * @author l
 */
public class SetZero {
    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> ind = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    ind.add(i);
                    col.add(j);
                }
            }
        }
        for (int x : ind) {
            for (int i = 0; i < matrix[x].length; i++) {
                matrix[x][i] = 0;
            }
        }
        for (int y : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}
