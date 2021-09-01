package algorithm;

public class SortColors {
	public void sortColors(int[] nums) {
		int head = 0;
		int end = nums.length - 1;
		int i = 0;
		while( i <= end ) {
			if( nums[i] == 0) {
				if( i == head) {
					i++;
					continue;
				}
				nums[i] = nums[head];
				nums[head] = 0;
				head++;
				continue;
			}
			if(nums[i] == 2) {
				nums[i] = nums[end];
				nums[end] = 2;
				end--;
				continue;
			}
			if(nums[i] == 1) {
				i++;
				continue;
			}
		}
    }
	
	public static void main(String[] args) {
		SortColors S = new SortColors();
		int[] nums = {2,0,2,1,1,0};
		S.sortColors(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
