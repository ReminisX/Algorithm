package algorithm;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		/*
		 * 1���Ӻ���ǰ�и�����
		 * 2�����и�������е����жϣ��Ƿ�ǰһ�������ڵ��ں�һ����
		 * 3�����ǵ������飬�����������и����ǰ�ƶ�һλ�����µ��и���������ж�
		 * 4�������ǵ������飬��Ѱ�Һ��������б��и��λ�ô����С������ʣ�������������
		 * 5�����������鶼�ǵ������飬�������������������
		 * */
		int max = nums[nums.length-1];  //��ʼ���и��������ֵ
		
		for(int i = nums.length-2; i >= 0; i--) { // ѭ���и�����
			if(nums[i] >= max) {  //��Ϊ����
				max = nums[i];
				for(int j = i ; j < nums.length-1; j++) { //����ת˳��
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
