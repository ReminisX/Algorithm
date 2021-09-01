package bankAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author l
 */
public class SystemSource {
    /**
     * m sources
     * n threads
     */
    int m;
    int n;
    int[] avaliable;
    int[][] max;
    int[][] allocate = new int[n][m];
    int[][] need = new int[n][m];

    public SystemSource (){
        m = 5;
        n = 3;
        avaliable = new int[]{1, 2, 3, 4, 5};
        max = new int[][]{{1, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 1}};

    }

    public static void main(String[] args) {

    }

}
