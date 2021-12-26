package algorithm;

import java.util.Stack;

public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int pre = Integer.MAX_VALUE;
        for(int i = postorder.length-1; i >= 0; i--){
            if(postorder[i] > pre){
                return false;
            }
            while(!stack.isEmpty() && postorder[i] < stack.peek()){
                pre = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

}
