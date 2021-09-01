package algorithm;

/**
 * @author l
 */
public class Search {
	public int search(int[] nums, int target) {
		int result = -1;
		int left = 0;
		int right = nums.length-1;
		
		if (nums == null || nums.length < 1 || (target < nums[0] && target > nums[nums.length - 1])) {
			return -1;
		}
		
		while(left <= right) {
			int index = (right + left)/2;
			if(nums[index] == target) {
				result = index;
			}
			// ×ó±ßÓĞĞò£¬ÓÒ±ßÎŞĞò
			if(nums[index] > nums[left]) {
				// ÈôtargetÔÚÓĞĞò±ß
				if(target >= nums[left] && target <= nums[index]) {
					right = index - 1;
				}else {  //·ñÔòÔÚÎŞĞò±ß
					left = index + 1;
				}
			}else {  // ×ó±ßÎŞĞò£¬ÓÒ±ßÓĞĞò
				// ÈôtargetÔÚÓĞĞò±ß
				if(target >= nums[index] && target <= nums[right]) {
					left = index + 1;
				}else {  //·ñÔòÔÚÎŞĞò±ß
					right = index - 1;
				}
			}
		}
		return result;
	}

	public boolean searchs(int[] nums, int target, int left, int right){
		if (right < left){
			return false;
		}
		int mid = (left + right) / 2;
		if(nums[mid] == target || nums[left] == target || nums[right] == target){
			return true;
		}

		if(target > nums[mid]){
			return nums[mid] >= nums[right] ? searchs(nums, target, mid+1, right) : binarySearch(nums, target, mid+1, right);
		}else{
			return nums[mid] <= nums[left] ? searchs(nums, target, left, mid-1) : binarySearch(nums, target, left, mid-1);
		}
	}

	public boolean binarySearch(int[] nums, int target, int left, int right){
		int mid = (left + right) / 2;
		if (nums[mid] == target){
			return true;
		}
		if (right < left){
			return false;
		}
		return target > nums[mid] ? binarySearch(nums, target, mid+1, right) : binarySearch(nums, target, left, mid-1);
	}
	
	public static void main(String[] args) {
		Search S = new Search();
		int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		int target = 2;
		boolean result = S.searchs(nums, target, 0, nums.length-1);
		System.out.println(result);
	}
}
