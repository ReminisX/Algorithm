package algorithm;

import java.util.*;

public class ScheduleCourse {

    public int scheduleCourse(int[][] courses) {
        // 排序
        Arrays.sort(courses, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        // 设定结果集
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> o2 - o1);
        int total = 0;
        for(int[] cnt : courses){
            int dur = cnt[0] , last = cnt[1];
            if(total + dur <= last){
                total += dur;
                heap.offer(dur);
            } else if(!heap.isEmpty() && heap.peek() > dur){
                total -= heap.poll() - dur;
                heap.offer(dur);
            }
        }
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] courses = new int[][]{{4, 6}, {5, 5}, {2, 6}};
        ScheduleCourse scheduleCourse = new ScheduleCourse();
        scheduleCourse.scheduleCourse(courses);
    }

}
