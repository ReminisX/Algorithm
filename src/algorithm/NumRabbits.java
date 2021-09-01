package algorithm;

import java.util.*;

/**
 * @author l
 */
public class NumRabbits {
    public int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0){
            return 0;
        }

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            m.put(answers[i], m.getOrDefault(answers[i], 0)+1);
        }

        int res = 0;

        Iterator i = m.entrySet().iterator();
        while (i.hasNext()){
            Map.Entry e = (Map.Entry) i.next();
            int key = (int) e.getKey();
            int val = (int) e.getValue();
            res += (val / (key + 1) + (val%(key+1)==0 ? 0 : 1))* (key + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 2};
        int res = new NumRabbits().numRabbits(num);
        System.out.println(res);
    }
}
