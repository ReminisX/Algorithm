package algorithm;

import javafx.scene.control.CheckBox;

/**
 * @author ZhangXiaodong
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2){
            return true;
        }
        boolean res = true;
        if(coordinates[0][0] - coordinates[1][0] == 0){
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]){
                    res = false;
                }
            }
        }else {
            System.out.println(coordinates[1][1]);
            System.out.println(coordinates[0][1]);
            System.out.println(coordinates[1][0]);
            System.out.println(coordinates[0][0]);
            double k = (double)(coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);
            double b = coordinates[0][1] - k * coordinates[0][0];
            System.out.println(k);
            System.out.println(b);
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != k * coordinates[i][0] + b) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CheckStraightLine C = new CheckStraightLine();
        int[][] coordinates = new int[][]{{2, 1}, {4, 2}, {6, 3}};
        boolean res = C.checkStraightLine(coordinates);
        System.out.println(res);
    }
}
