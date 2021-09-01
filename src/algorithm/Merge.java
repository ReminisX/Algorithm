package algorithm;

import java.util.Arrays;

public class Merge {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m-- + n-- -1;
		while(m >= 0 && n >= 0){
			nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}
		while(n >= 0){
			nums1[index--] = nums2[n--];
		}

	}

	public static void main(String[] args) {
		int[] nums1 = {0};
		int[] nums2 = {1};
		new Merge().merge(nums1, 0, nums2, 1);
		System.out.println(Arrays.toString(nums1));
	}
}
