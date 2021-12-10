package algorithm;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score){
        int len = score.length;
        Map<Integer, Integer> map = new LinkedHashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(i+1, score[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());
        String [] res = new String[len];
        System.out.println(list);
        for (int i = 0; i < len; i++) {
            int k = list.get(i).getKey()-1;
            if (i == 0){
                res[k] = "Gold Medal";
            }else if (i == 1){
                res[k] = "Silver Medal";
            }else if (i == 2){
                res[k] = "Bronze Medal";
            }else{
                res[k] = String.valueOf(i+1);
            }
        }
        return res;
    }

    public String[] findRelativeRanks2(int[] score){
        int len = score.length;
        int max = -1;
        // 寻找最大值
        for(int i = 0; i < len; i++){
            if(score[i] > max){
                max = score[i];
            }
        }
        // 生成最大值的数组
        int[] index = new int[max+1];
        // 根据大小在index中记录位置及其下标数据
        for(int i = 0; i < len; i++){
            index[score[i]] = i+1;
        }
        System.out.println(Arrays.toString(index));
        String[] res = new String[len];
        int ind = 0;
        for(int i = max; i >= 0; i--){
            if(index[i] > 0){
                if (ind == 0) {
                    res[index[i]-1] = "Gold Medal";
                }else if (ind == 1){
                    res[index[i]-1] = "Silver Medal";
                }else if (ind == 2){
                    res[index[i]-1] = "Bronze Medal";
                }else{
                    res[index[i]-1] = String.valueOf(ind+1);
                }
                ind++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1, 0};
        String [] res = new FindRelativeRanks().findRelativeRanks2(score);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
