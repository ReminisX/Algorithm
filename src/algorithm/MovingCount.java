package algorithm;

public class MovingCount {

    private int res;

    private boolean[][] has;

    /**
     * 判断能否到达
     * @param x 横坐标
     * @param y 纵坐标
     * @param k 判定值
     * @return 是否可到达
     */
    public boolean can(int x, int y, int k){
        int r = 0;
        while(x / 10 != 0){
            int temp = x - (x / 10)*10;
            r += temp;
            x /= 10;
        }
        while(y / 10 != 0){
            int temp = y - (y / 10)*10;
            r += temp;
            y /= 10;
        }
        r = r + x + y;
        return r <= k;
    }

    public void diff(boolean[][] matrix, int x, int y){
        if(matrix[x][y] && !has[x][y]){
            res++;
            has[x][y] = true;
            if (x-1 >= 0 && !has[x-1][y]){
                diff(matrix, x-1, y);
            }
            if (x+1 < matrix.length && !has[x+1][y]){
                diff(matrix, x+1, y);
            }
            if (y-1 >= 0 && !has[x][y-1]){
                diff(matrix, x, y-1);
            }
            if ((y+1 < matrix[x].length && !has[x][y+1])){
                diff(matrix, x, y+1);
            }
        }
    }

    public int movingCount(int m, int n, int k) {
        // 设定可行走矩阵
        has = new boolean[m][n];
        boolean[][] matrix = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = can(i, j, k);
            }
        }
        diff(matrix, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(3, 1, 0));
    }
}
