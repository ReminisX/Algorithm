package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VisiblePoint {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        //起始点坐标
        int x = location.get(0);
        int y = location.get(1);
        // 角度值转换
        Double anglePi = angle * Math.PI / 180;
        // 观测角度合集
        List<Double> l = new ArrayList<>();
        // 结果
        int base = 0;
        // 循环计算斜率
        for (int i = 0; i < points.size(); i++) {
            int xx = points.get(i).get(0);
            int yy = points.get(i).get(1);
            if(xx == x && yy == y){
                ++base;
            }else{
                Double r = Math.atan2(yy-y, xx-x);
                l.add(r);
            }
        }
        Collections.sort(l);
        int size = l.size();
        for (int i = 0; i < size; i++) {
            l.add(l.get(i) + 2*Math.PI);
        }
        int left;
        int right = 0;
        int res = 0;
        for(left = 0; left < l.size(); left++){
            Double now = l.get(left) + anglePi;
            while (right < l.size() && l.get(right) <= now){
                ++right;
            }
            res = Math.max(res, right-left);
        }
        // 计算
        return res+base;
    }

    public static void main(String[] args) {
        VisiblePoint visiblePoint = new VisiblePoint();
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(0, 0));
        points.add(Arrays.asList(0, 2));
//        points.add(Arrays.asList(3, 3));
//        points.add(Arrays.asList(4, 4));
//        points.add(Arrays.asList(1, 2));
//        points.add(Arrays.asList(2, 1));
        List<Integer> location = new ArrayList<>(Arrays.asList(1, 1));
        int angle = 90;
        System.out.println(visiblePoint.visiblePoints(points, angle, location));
    }

}
