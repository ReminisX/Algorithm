package algorithm;

import java.util.*;

public class CanJump {
	public boolean canJump(int[] nums) {
		
		if( nums.length <= 1) {
			return true;
		}
		
		boolean b = this.Jump(0, nums);
		
		return b;
    }
	
	public boolean Jump(int index, int[] nums) {
		boolean b = false;
		boolean[] bool = new boolean[nums[index]];
		if(index == nums.length-1) {
			return true;
		}
		
		for(int i = 1; i <= nums[index]; i++) {
			if(index+i < nums.length) {
				bool[i-1] = this.Jump(index+i, nums);
			}
		}
		
		for( boolean bo : bool) {
			if(bo == true) {
				b = true;
			}
		}
		return b;
	}
	
	public boolean canJump2(int[] nums) {
		int end = nums.length - 1;
		for(int i = nums.length-2; i>=0; i--) {
			if(i + nums[i] >= end) {
				end = i;
			}
		}
		if(end == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		CanJump C = new CanJump();
		int[] nums = {2, 3, 1, 1, 4};
		boolean b = C.canJump2(nums);
		System.out.println(b);

		List<Number> numss = new ArrayList<>();
		List<Integer> r = new ArrayList<>();
		r.add(1);
		numss.addAll(r);
	}
}
