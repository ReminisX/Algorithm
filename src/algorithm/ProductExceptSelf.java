package algorithm;

public class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		
		for (int i = 0; i < res.length; i++) {
			int left = 1;
			for (int j = 0; j < i; j++) {
				left *= nums[j];
			}
			int right = 1;
			for (int k = nums.length - 1; k > i; k--) {
				right *= nums[k];
			}
			res[i] = left * right;
		}
		
		return res;
    }
	
	public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        int[] res = new int[nums.length];
        for (int i = 0, product = 1; i < nums.length; i++) {
            res[i] = product;
            product *= nums[i];
        }
        
        for (int i = nums.length - 1, product = 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }
}
