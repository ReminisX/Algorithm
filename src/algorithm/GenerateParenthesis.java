package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	private List<String> result = new ArrayList();
	
	public List<String> generateParenthesis(int n) {
		// �߽�����ж�
		if(n < 1) {
			return result;
		}
		// �ݹ����
		generateP(0, 0, "", n);
		return result;
    }
	
	public void generateP(int left, int right, String S, int n) {
		// ����ȡ���ַ���������
		if(left == right && left == n) {
			result.add(S);
		}
		// ��������С��n������Խ�����������Ų���
		if(left < n) {
			generateP(left+1, right, S+"(", n);
		}
		// �����������������ţ�����Խ�����������Ų���
		if(right < left) {
			generateP(left, right+1, S+")", n);
		}
		
	}
	
	public static void main(String[] args) {
		GenerateParenthesis G = new GenerateParenthesis();
		int n = 2;
		List<String> result = G.generateParenthesis(n);
		System.out.println(result);
	}
}
