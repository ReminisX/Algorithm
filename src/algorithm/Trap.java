package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Trap {
	public int trap(int[] height) {
		int square = 0;
		int heightest = -1;
		int heightest_index = -1;
		
		if(height.length <= 1) {
			return 0;
		}

		for(int i = 0; i < height.length; i++) {
			if(height[i] > heightest) {
				heightest = height[i];
				heightest_index = i;
			}
		}

		int tmp = height[0];
		for(int i = 1; i < heightest_index; i++) {
			if(height[i] > tmp) {
				tmp = height[i];
			}else {
				square += tmp - height[i];
			}
		}
		

		tmp = height[height.length-1];
		for(int i = height.length-2; i > heightest_index; i--) {
			if(height[i] > tmp) {
				tmp = height[i];
			}else {
				square += tmp - height[i];
			}
		}
		
		return square;
    }
	
	
	public static void main(String[] args) {
		Trap T = new Trap();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int square = T.trap(height);
		System.out.println(square);
	}
}
