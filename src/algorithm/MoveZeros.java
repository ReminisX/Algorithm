package algorithm;

public class MoveZeros {
	public void moveZeros1(int[] nums) {
		if(nums.length == 0 || nums.length == 1) {
			return;
		}
		int end = nums.length - 1;
		int i = 0;
		while (i < end) {
			if(nums[i] == 0) {
				for (int j = i; j < end; j++) {
					nums[j] = nums[j+1];
				}
				nums[end] = 0;
				end--;
			}else {
				i++;
			}
		}
	}
	
	public void moveZeros(int[] nums) {
		if(nums.length == 0 || nums.length == 1) {
			return;
		}
		int index = 0;
		int zero_nums = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}else {
				zero_nums++;
			}
		}
		for (int j = nums.length - zero_nums; j < nums.length; j++) {
			nums[j] = 0;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 0, 0, 3, 5, 8, 0, 9, 10};
		MoveZeros M = new MoveZeros();
		M.moveZeros(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
