package algorithm;

import java.util.Stack;

public class LargestRectangleArea {
	// ����Ѱ�����
    public int largestRectangleArea(int[] heights) {
    	if(heights.length == 0) {
    		return 0;
    	}
    	int[] maxlist = new int[heights.length];
    	for (int i = 0; i < heights.length; i++) {
			// �������
    		int left = i;
    		while(left > 0) {
    			left--;
    			if(heights[left] >= heights[i]) {
    				continue;
    			}else {
    				left++;
    				break;
    			}
			}
    		// ���ұ���
    		int right = i;
    		while(right < heights.length-1) {
    			right++;
    			if(heights[right] >= heights[i]) {
    				continue;
    			}else {
    				right--;
    				break;
    			}
    		}
    		// ���㵱ǰ���������
    		maxlist[i] = heights[i]*(right - left + 1);
		}
    	// Ѱ�����ֵ
    	int max = 0;
    	for (int i = 0; i < maxlist.length; i++) {
			if(max < maxlist[i]) {
				max = maxlist[i];
			}
		}
    	return max;
    }
    
    // ����ջ���
    public int largestRectangleArea2(int[] height) {
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
    	int[] heights = {1, 5};
    	LargestRectangleArea L = new LargestRectangleArea();
    	int k = L.largestRectangleArea2(heights);
    	System.out.println(k);
    }
    
}
