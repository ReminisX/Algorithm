package algorithm;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix == null) {
    		return 0;
    	}
    	if(matrix.length == 0) {
    		return 0;
    	}
    	int max = 0;
    	int[] height = new int[matrix[0].length-1];
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[j] += matrix[i][j];
			}
			int k = this.largestRectangleArea(height);
			if(max < k) {
				max = k;
			}
		}
    	return max;
    	
    }
    
    public int largestRectangleArea(int[] height) {
    	Stack stack = new Stack<Integer>();
    	Stack index = new Stack<Integer>();
    	int[] heights = new int[height.length+1];
    	int[] nums = new int[heights.length];
    	for (int i = 0; i < height.length; i++) {
			heights[i] = height[i];
		}
    	heights[heights.length-1] = 0;
    	int max = 0;
    	for (int i = 0; i < heights.length; i++) {
			if(stack.isEmpty() || heights[i] >= (int)stack.peek()) {
				stack.push(heights[i]);
				index.push(i);
			}else {
				int h = (int) stack.pop();
				int ind = (int) index.pop();
				nums[ind] = h * ( i - ind);
				i--;
			}
		}
    	for (int i = 0; i < nums.length; i++) {
			if(max < nums[i]) {
				max = nums[i];
			}
		}
    	return max;
    }
    
    public static void main(String[] args) {
    	
    }
}
