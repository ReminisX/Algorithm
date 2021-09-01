package algorithm;

public class SearchRange {
	public int[] searchRange(int[] nums, int target) {
		if(nums.length < 1) {
			return new int[]{-1, -1};
		}
		int R = -1;
		
		int left = 0;
		int right = nums.length;
		
		while(left <= right) {
			int mid = (right - left)/2;
			
			if(target == nums[mid]) {
				R = mid;
				break;
			}
			
			if(target > nums[mid]) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		if(R == -1) {
			return new int[]{-1, -1};
		}
		
		int R_left = R;
		int R_right = R;
		while( nums[R_left] == target ) {
			R_left--;
			if(R_left == -1) {
				break;
			}
		}
		while( nums[R_right] == target ) {
			R_right++;
			if(R_right == nums.length) {
				break;
			}
		}
		int[] range = {R_left+1, R_right-1};
		return range;
	}
	
	public static void main(String[] args) {
		SearchRange s = new SearchRange();
		int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 6, 7, 7};
		int target = 4;
		int[] range = s.searchRange(nums, target);
		for(int i : range) {
			System.out.println(i);
		}
	}
	
}
