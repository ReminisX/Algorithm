package algorithm;

import java.util.Stack;

public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2) {
            return 0;
        }

        int res = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		LongestValidParentheses L = new LongestValidParentheses();
		String s = "(((((((()";
		int k = L.longestValidParentheses(s);
		System.out.println(k);
	}
	
}
