package algorithm;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 4){
            return res;
        }
        if(nums.length == 4){
            if(nums[0]+nums[1]+nums[2]+nums[3] == target){
                res.add(new ArrayList(Arrays.asList(nums[0], nums[1], nums[2], nums[3])));
                return res;
            }else{
                return res;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int l = j+1;
                int r = nums.length-1;
                while(l < r){
                    int temp = nums[i] + nums[j] + nums[l] + nums[r];
                    if(temp > target){
                        r--;
                    }else if(temp < target){
                        l++;
                    }else if(temp == target){
                        List list = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        Collections.sort(list);
                        res.add(list);
                        r--;
                    }
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            for (int j = i+1; j < res.size(); j++) {
                if(res.get(i).get(0).equals(res.get(j).get(0)) && res.get(i).get(1).equals(res.get(j).get(1)) && res.get(i).get(2).equals(res.get(j).get(2))){
                    res.remove(j);
                    j--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FourSum F = new FourSum();
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        int target = 0;
        List L = F.fourSum(nums, target);
        System.out.println(L);
    }
}
