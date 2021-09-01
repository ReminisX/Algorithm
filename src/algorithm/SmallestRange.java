package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestRange {
	
	public int[] smallestRange(List<List<Integer>> nums) {
		int[] R = new int[2];  //当前最优解
		List<Integer> D = new ArrayList<Integer>(nums.size());  //迭代数组
		List<Integer> index = new ArrayList<Integer>(nums.size());  //迭代指针
		int smallest_index;
		
		for(int i = 0; i < nums.size(); i++) {  //初始化迭代数组
			D.add(nums.get(i).get(0));
		}
		R = this.ArrayBest(D);  //初始化最优解数组
		for(int i = 0; i < nums.size(); i++) {  //初始化迭代下标
			index.add(0);
		}
		
		while( this.ArrayFull(nums, index) ) {
			/*  
			 *  寻找最小数下标
			 *  更新index，指定下标的index+1
			 *  更新迭代数组D
			 */
			smallest_index = this.RightIndex(D, index, nums);
			index.set(smallest_index, index.get(smallest_index)+1);
			D.set(smallest_index, nums.get(smallest_index).get(index.get(smallest_index))); 
			R = this.ArrayBest(D);
		}
		return R;
    }
	
	public boolean ArrayFull(List<List<Integer>> nums, List<Integer> index) {
		// 判断index是否均为最后一位
		for(int i = 0; i < index.size(); i++) {
			if(index.get(i) == nums.get(i).size() - 1) {
				continue;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public int[] ArrayBest(List<Integer> D) {
		//  计算当前迭代数组的最优解，并返回当前数组最优解
		int[] Ri = new int[2];
		
		if(D.get(0) < D.get(1)) {
			Ri[0] = D.get(0);
			Ri[1] = D.get(1);
		}else {
			Ri[0] = D.get(1);
			Ri[1] = D.get(0);
		}
		
		for(int i = 2; i < D.size(); i++) {
			if(D.get(i) > Ri[1]) {
				Ri[1] = D.get(i);
			}else if(D.get(i) < Ri[0]) {
				Ri[0] = D.get(i);
			}
		}
		return Ri;
	}
	
	public int ArraySmallest(List<Integer> D) {
		//  寻找数组D中最小的数的下标
		if(D.size() == 1) {
			return D.get(0);
		}
		
		int z = D.get(0);
		int k = 0;
		for(int i = 1; i < D.size(); i++) {
			if(D.get(i) < z) {
				z = D.get(i);
				k = i;
			}
		}
		return k;
	}
	
	public int RightIndex(List<Integer> D, List<Integer> index, List<List<Integer>> nums) {
		//  修正下标，确保下标不是最后一位
		List<Integer> D_cut = new ArrayList<Integer>();
		for(int i = 0; i < index.size(); i++) {
			D_cut.add(index.get(i));
		}
		
		for(int i = 0; i < nums.size(); i++) {
			if(index.get(i) == nums.get(i).size()-1) {
				
			}
		}
		return this.ArraySmallest(D);
	}
	
	public int[] CompareR(int[] R, int[] Ri) {
		//比较R与Ri的值，选择更优值
		if(R[1] - R[0] > Ri[1] - Ri[0]) {
			return Ri;
		}else if(R[1] - R[0] < Ri[1] - Ri[0]){
			return R;
		}else if(R[1] - R[0] == Ri[1] - Ri[0]){
			if(R[0] > Ri[0]) {
				return Ri;
			}else {
				return R;
			}
		}
		
		return R;
	}
	
	public int Sort_ind(List<Integer> val, List<List<Integer>> nums) {
		
		List<Integer> ind = new ArrayList<Integer>();
		for(int i = 0; i < val.size(); i++) {
			ind.add(i);
		}
		for(int i = 0; i < val.size(); i++) {
			for(int j = i+1; j < val.size(); j++) {
				if(val.get(i) < val.get(j)) {
					// 值交换
					int k = val.get(i);
					val.set(i, val.get(j));
					val.set(j, k);
					//  位置交换
					int pos = ind.get(i);
					ind.set(i, ind.get(j));
					ind.set(j, pos);
				}
			}
			if(ind.get(i) == nums.get(i).size()-1) {
				continue;
			}else {
				return ind.get(i);
			}
		}
		
		return 0;
	}
	
	//测试主函数
	public static void main(String[] args) {
		SmallestRange s = new SmallestRange();
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		Integer[][] k = {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
		for(int i = 0; i < k.length; i++ ) {
			nums.add((List<Integer>)Arrays.asList(k[i]));
		}
		// 主程序测试
		int[] R = s.smallestRange(nums);
		System.out.println("the result is:");
		for(int i = 0; i < R.length; i++) {
			System.out.println(R[i]);
		}
		
		//  分函数测试
		List<Integer> D = new ArrayList<Integer>(nums.size());  //迭代数组
		D.add(24);
		D.add(20);
		D.add(22);
		List<Integer> index = new ArrayList<Integer>(nums.size());  //迭代指针
		index.add(3);
		index.add(3);
		index.add(2);
		System.out.println(nums.get(1).size()-1 == index.get(1));
		System.out.println(D);
		System.out.println(s.ArraySmallest(D));
		System.out.println(s.RightIndex(D, index, nums));
		
	}
}
