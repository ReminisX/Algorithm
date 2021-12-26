package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int now = 1;
        List<List<Integer>> res = new ArrayList<>();

        while(right < target){
            if(now < target){
                right++;
                now += right;
            }else if(now > target){
                now -= left;
                left++;
            }else{
                List<Integer> l = new ArrayList<>();
                for(int i = left; i < right+1; i++){
                    l.add(i);
                }
                res.add(l);
                now -= left;
                left++;
            }
        }
        int[][] r = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] temp = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                temp[j] = res.get(i).get(j);
            }
            r[i] = temp;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FindContinuousSequence().findContinuousSequence(9)));
    }

}
