package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/* 
 * ��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ�
 * �����ü����������N��1��1000֮������������N��1000����
 * ���������ظ������֣�ֻ����һ������������ͬ����ȥ������ͬ������Ӧ�Ų�ͬ��ѧ����ѧ�š�
 * Ȼ���ٰ���Щ����С�������򣬰����źõ�˳��ȥ��ͬѧ�����顣
 * ����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ���(ͬһ��������������ܻ��ж������ݣ�ϣ���������ȷ����)��
 * */

public class BulidNums {
	public List<Integer> bulidNums(int[] nums){
		HashSet set = new HashSet<>();
		List<Integer> L = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		L.addAll(set);
		Collections.sort(L);
		return L;
	}
	
	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		BulidNums B = new BulidNums();
		while(S.hasNextLine()) {
			int n = Integer.parseInt(S.nextLine());
			int[] nums = new int[n];
			List<Integer> L = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				int k = Integer.parseInt(S.nextLine());
				nums[i] = k;
			}
			L = B.bulidNums(nums);
			for(int j = 0; j < L.size(); j++) {
				System.out.println(L.get(j));
			}
		}
	}
}
