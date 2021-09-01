package algorithm;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		/*
		 * 1、从后往前切割数组
		 * 2、对切割数组进行倒序判断，是否前一个数大于等于后一个数
		 * 3、若是倒序数组，则将其变成升序，切割符向前移动一位，对新的切割数组进行判断
		 * 4、若不是倒序数组，则寻找后续数组中比切割符位置大的最小的数，剩余的数升序排列
		 * 5、若整个数组都是倒序数组，则对整个数组升序排列
		 * */
		int max = nums[nums.length-1];  //初始化切割数组最大值
		
		for(int i = nums.length-2; i >= 0; i--) { // 循环切割数组
			if(nums[i] >= max) {  //若为逆序
				max = nums[i];
				for(int j = i ; j < nums.length-1; j++) { //逆序转顺序
					nums[j] = nums[j+1];
				}
				nums[nums.length-1] = max;
				continue;
			}else {
				int temp = nums[i];
				for(int j = i+1; j < nums.length; j++) {
					if(temp < nums[j]) {
						nums[i] = nums[j];
						nums[j] = temp;
						break;
					}
				}
				break;
			}
		}
    }
	
	public static void main(String[] args) {
		NextPermutation N = new NextPermutation();
		int[] nums = {1, 3, 2, 4, 5};
		N.nextPermutation(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
