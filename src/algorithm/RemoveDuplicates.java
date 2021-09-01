package algorithm;

import java.util.Arrays;

/**
 * @author l
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates R = new RemoveDuplicates();
        int[] nums = new int[]{1,1,1,2,2,3,3,3,3,4,4,4};
        int res = R.removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }
}
