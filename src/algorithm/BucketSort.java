package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author l
 */
public class BucketSort {
    public void bucketSort(int[] nums){
        // 计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / nums.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for(int i = 0; i < nums.length; i++){
            int num = (nums[i] - min) / (nums.length);
            bucketArr.get(num).add(nums[i]);
        }

        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            for(int j = 0; j < bucketArr.get(i).size(); j++){
                nums[index++] = bucketArr.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        BucketSort bs = new BucketSort();
        int[] nums = new int[]{3, 5, 3, 4, 6, 1, 8, 9};
        bs.bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
