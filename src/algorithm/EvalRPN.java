package algorithm;

import java.util.Stack;

/**
 * @author l
 */
public class EvalRPN {
    public int caculate(int a, int b, char sign){
        switch(sign){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                return 0;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() > 1 || (tokens[i].charAt(0) >= '0' && tokens[i].charAt(0) <= '9')){
                if (tokens[i].charAt(0) == '-'){
                    s.push(-Integer.parseInt(tokens[i].substring(1)));
                }else{
                    s.push(Integer.parseInt(tokens[i]));
                }
            }else{
                int b = s.pop();
                int a = s.pop();
                char sign = tokens[i].charAt(0);
                int res = caculate(a, b, sign);
                s.push(res);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = new EvalRPN().evalRPN(tokens);
        System.out.println(res);
    }
}
