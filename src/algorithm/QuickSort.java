package algorithm;

import java.util.Arrays;

/**
 * @author l
 */
public class QuickSort {
    public void quickSort(int[] nums, int l, int r){
        if(l > r){
            return;
        }
        int left = l;
        int right = r;
        int key = nums[left];
        while(left < right){
            while(key < nums[right] && left < right){
                right--;
            }
            nums[left] = nums[right];
            while(key > nums[left] && left < right){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        quickSort(nums, l, left-1);
        quickSort(nums,right+1, r);
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 4, 2, 1, 7, 8, 9};
        QuickSort Q = new QuickSort();
        Q.quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
