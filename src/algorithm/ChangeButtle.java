package algorithm;

import java.util.Scanner;

/* ������һ�������⣺��ĳ�̵�涨����������ˮƿ���Ի�һƿ��ˮ��
 * С��������ʮ������ˮƿ���������Ի�����ƿ��ˮ�ȣ�������5ƿ��
 * �������£�����9����ƿ�ӻ�3ƿ��ˮ���ȵ�3ƿ���ģ������Ժ�4����ƿ�ӣ�
 * ��3���ٻ�һƿ���ȵ���ƿ���ģ���ʱ��ʣ2����ƿ�ӡ�Ȼ�������ϰ��Ƚ����һƿ��ˮ��
 * �ȵ���ƿ���ģ������Ժ���3����ƿ�ӻ�һƿ���Ļ����ϰ塣
 * ���С��������n������ˮƿ�������Ի�����ƿ��ˮ�ȣ�
 * */

public class ChangeButtle {
	public int changeButtle(int n) {
		return n/2;
	}
	
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ChangeButtle m = new ChangeButtle();
        while(s.hasNextLine()) {
        	int n = Integer.parseInt(s.nextLine());
            int num = m.changeButtle(n);
            System.out.println(num);
        }
    }
	
}
