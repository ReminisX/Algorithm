package algorithm;

import java.util.*;

/**
 * @author ZhangXiaodong
 */
public class MinCostConnectPoints {

    public int removePoint(List<List<Integer>> L, List<List<Integer>> R){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < L.size(); i++) {
            for (int j = 0; j < R.size(); j++) {
                int d = Math.abs(L.get(i).get(0) - R.get(j).get(0)) + Math.abs(L.get(i).get(1) - R.get(j).get(1));
                if(d < min){
                    min = d;
                    index = j;
                }
            }
        }
        L.add(R.get(index));
        R.remove(index);
        return min;
    }

    public int minCostConnectPoints(int[][] points) {
        int res = 0;

        List<List<Integer>> R = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            R.add(Arrays.asList(points[i][0], points[i][1]));
        }
        List<List<Integer>> L = new ArrayList<>();
        L.add(R.get(0));
        R.remove(0);

        while(!R.isEmpty()){
            int k = removePoint(L, R);
            res += k;
        }
        return res;
    }

    public static void main(String[] args) {
        MinCostConnectPoints M = new MinCostConnectPoints();
        int[][] points = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int res = M.minCostConnectPoints(points);
        System.out.println(res);
    }

}
