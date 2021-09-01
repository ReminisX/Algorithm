package algorithm;

public class MaxArea {
	public int maxArea(int[] height) {
		int[] maxnums = new int[height.length];
		int max, m=0;
		
		for(int i = 0; i < height.length; i++) {
			for(int j = i+1; j < height.length; j++) {
				int k = this.area(height[i], height[j], i, j);
				if(k > m) {
					m = k;
				}
			}
			maxnums[i] = m;
		}
		max = maxnums[0];
		for(int i = 1; i < height.length; i++) {
			if( max < maxnums[i]) {
				max = maxnums[i];
			}
		}
		
		return max;
	}
	
	public int maxArea2(int[] height) {
		int[] maxnums = new int[height.length];
		int max, m=0;
		
		for(int i = 0; i < height.length; i++) {
			for(int j = height.length-1; j > i; j--) {
				int k = this.area(height[i], height[j], i, j);
				if(k > m) {
					m = k;
				}
				if(height[i] < height[j]) {
					break;
				}
			}
			maxnums[i] = m;
		}
		max = maxnums[0];
		for(int i = 1; i < height.length; i++) {
			if( max < maxnums[i]) {
				max = maxnums[i];
			}
		}
		
		return max;
	}
	
	public int area(int a, int b, int a_index, int b_index) {
		if(a > b) {
			return Math.abs(b*(b_index - a_index));
		}else {
			return Math.abs(a*(b_index - a_index));
		}
	}
	
	public int maxArea3(int[] height) {
		int result = 0;
		int left = 0;
		int right = height.length-1;
		
		while(left < right) {
			result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
			if(height[left] < height[right]) {
				left++;
			}else {
				right--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		MaxArea A = new MaxArea();
		int[] height = {1,8,6,2,5,4,8,3,7};
		int max = A.maxArea2(height);
		System.out.println(max);
	}
	
}
