package algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author ZhangXiaodong
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                int k = nums[i] + nums[l] + nums[r];
                if(Math.abs(k - target) < Math.abs(res - target)){
                    res = k;
                }
                if(k > target){
                    r--;
                }else if(k < target){
                    l++;
                }else{
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest T = new ThreeSumClosest();
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        int res = T.threeSumClosest(nums, target);
        System.out.println(res);
    }
}
