package test;

import java.util.*;

/**
 * @author l
 */
public class Main {

    public int maxLength(String s){
        if(s.length() < 4){
            return 0;
        }
        int R = 0;
        // 统计
        List<List<Integer>> L = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - '0';
            int len = L.size();
            if(L.isEmpty() || L.get(len-1).get(0) != k){
                List<Integer> l = new ArrayList<>();
                l.add(k);
                l.add(1);
                L.add(l);
            }else{
                List<Integer> temp = L.get(len-1);
                temp.set(1, temp.get(1)+1);
                L.set(len-1, temp);
            }
        }
        //计算
        int[] nums = {1, 8, 0, 7};
        int index = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < L.size(); i++) {
            int L_temp = L.get(i).get(0);
            if (L_temp == 1){
                res.add(L.get(i));
            }else if(L_temp == 8){
                for (int j = 0; j < res.size(); j++) {
                    if (res.get(j).get(0) == 1){
                        List<Integer> ttt = new ArrayList<>();
                        ttt.add(8);
                        ttt.add(res.get(j).get(1) + L.get(i).get(1));
                        res.add(ttt);
                        j++;
                    }
                    if (res.get(j).get(0) == 8){
                        res.get(j).set(1, res.get(j).get(1)+L.get(i).get(1));
                        j++;
                    }
                }
            }else if(L_temp == 0){
                for (int j = 0; j < res.size(); j++) {
                    if (res.get(j).get(0) == 8){
                        List<Integer> ttt = new ArrayList<>();
                        ttt.add(0);
                        ttt.add(res.get(j).get(1) + L.get(i).get(1));
                        res.add(ttt);
                        j++;
                    }
                    if (res.get(j).get(0) == 0){
                        res.get(j).set(1, res.get(j).get(1)+L.get(i).get(1));
                        j++;
                    }
                }
            }else if(L_temp == 7){
                for (int j = 0; j < res.size(); j++) {
                    if (res.get(j).get(0) == 0){
                        List<Integer> ttt = new ArrayList<>();
                        ttt.add(7);
                        ttt.add(res.get(j).get(1) + L.get(i).get(1));
                        res.add(ttt);
                        j++;
                    }
                    if (res.get(j).get(0) == 7){
                        res.get(j).set(1, res.get(j).get(1)+L.get(i).get(1));
                        j++;
                    }
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).get(0) == 7){
                R = Math.max(res.get(i).get(1), R);
            }
        }

        return R;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = new Main().maxLength(s);
        System.out.println(res);
    }
}
