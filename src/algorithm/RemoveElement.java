package algorithm;

import java.sql.ResultSet;
import java.util.Arrays;

/**
 * @author l
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int index = 0;
        while(index < n){
            if(nums[index] == val){
                for (int i = 0; i < n-index-1; i++) {
                    nums[index+i] = nums[index+i+1];
                }
                n--;
                index--;
            }
            index++;
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement R = new RemoveElement();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int k = R.removeElement(nums, 2);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
