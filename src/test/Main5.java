package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main5 {

    public int k;

    public Main5(){
        k = 0;
    }

    public Main5(int k){
        this();
    }

    public void swap(String a, String b){
        String temp = a;
        a = b;
        b = temp;
    }

    public void swap(int[] nums){
        int k = nums[0];
        nums[0] = nums[1];
        nums[1] = k;
    }

    public void swap(int[] nums, int[] num){
        int[] temp = nums;
        nums = num;
        num = temp;
    }

    public static void main(String[] args) {

        String a = "a";
        String b = "b";
        Main5 m = new Main5();
        int[] nums = {0, 1};
        int[] num = {1, 2};
        m.swap(nums, num);
        System.out.println(Arrays.toString(nums));



    }
}
