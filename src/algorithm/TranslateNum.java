package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TranslateNum {

    public int translateNum(int num) {
        if(num < 10){
            return 1;
        }
        // 数字转化为数组
        List<Integer> l = new ArrayList<>();
        while(num != 0){
            int next = num / 10;
            int remain = num - 10*next;
            l.add(remain);
            num = next;
        }
        // 判断是否能够解析
        boolean[] can = new boolean[l.size()-1];
        for(int i = l.size()-1; i > 0; i--){
            int k = l.get(i)*10 + l.get(i-1);
            can[i-1] = k <= 25 && k >= 10;
        }
        // r(n) = r(n-1) + r(n-2)
        int[] res = new int[l.size()];
        res[0] = 1;
        res[1] = can[0] ? 2 : 1;
        for(int i = 2; i < res.length; i++){
            res[i] = res[i-1] + (can[i-1] ? res[i-2] : 0);
        }
        return res[res.length-1];
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        int num = 506;
        int res = translateNum.translateNum(num);
        System.out.println(res);
    }

}
