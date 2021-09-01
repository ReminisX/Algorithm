package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	private List<String> result = new ArrayList();
	
	public List<String> generateParenthesis(int n) {
		// 边界情况判断
		if(n < 1) {
			return result;
		}
		// 递归求解
		generateP(0, 0, "", n);
		return result;
    }
	
	public void generateP(int left, int right, String S, int n) {
		// 定义取出字符串的条件
		if(left == right && left == n) {
			result.add(S);
		}
		// 若左括号小于n，则可以进行添加左括号操作
		if(left < n) {
			generateP(left+1, right, S+"(", n);
		}
		// 若右括号少于左括号，则可以进行添加右括号操作
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
