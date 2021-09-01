package algorithm;

import java.util.Stack;

/**
 * @author ZhangXiaodong
 */
public class ReverseStack {
    public Integer getLastElement(Stack<Integer> s){
        Integer pre = s.pop();
        Integer last = null;
        if(s.isEmpty()){
            return pre;
        }else{
            last = getLastElement(s);
            s.push(pre);
        }
        return last;
    }

    public void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }else{
            Integer last = getLastElement(s);
            reverseStack(s);
            s.push(last);
        }

    }

    public static void main(String[] args) {
        ReverseStack R = new ReverseStack();
        Stack<Integer> s= new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("the value of s1 " + s);
        R.reverseStack(s);
        System.out.println("the value of reverseStack is " + s);
    }
}
