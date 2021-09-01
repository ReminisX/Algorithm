package algorithm;

import java.util.*;

/**
 * @author ZhangXiaodong
 */
public class PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        int r = 0;
        for (int i = 0; i < A.length; i++) {
            r = (r*2 + A[i]) % 10;
            res.add(r%5==0);
        }
        return res;
    }

    public static void main(String[] args) {
        PrefixesDivBy5 P = new PrefixesDivBy5();
        int[] A = {1, 0, 1};
        List L = P.prefixesDivBy5(A);
        System.out.println(L);
    }
}
