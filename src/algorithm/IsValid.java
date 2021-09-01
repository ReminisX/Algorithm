package algorithm;

import java.util.Stack;

/**
 * @author ZhangXiaodong
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(') {
                stack.push(')');
            } else if(c=='[') {
                stack.push(']');
            } else if(c=='{') {
                stack.push('}');
            } else if(stack.isEmpty()||c!=stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid I = new IsValid();
        String s = "[";
        boolean b = I.isValid(s);
        System.out.println(b);
    }
}
