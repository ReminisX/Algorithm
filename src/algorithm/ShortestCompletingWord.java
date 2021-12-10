package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 统计licencePlate字符
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < licensePlate.length(); i++){
            char c = licensePlate.charAt(i);
            if(c >= 65 && c <= 90){
                c += 32;
                map.put(c, map.getOrDefault(c, 0)+1);
            }else if(c >= 97 && c <= 122){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        // 遍历words
        for(int i = 0; i < words.length; i++){
            Map<Character, Integer> m = new HashMap<>();
            boolean flag = true;
            for(int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                if(c >= 65 && c <= 90){
                    c += 32;
                    m.put(c, m.getOrDefault(c, 0)+1);
                }else if(c >= 97 && c <= 122){
                    m.put(c, m.getOrDefault(c, 0)+1);
                }
            }
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                char key = entry.getKey();
                int value = entry.getValue();
                if(value > m.getOrDefault(key, 0)){
                    flag = false;
                    break;
                }
            }
            if(flag && minLength > words[i].length()){
                minLength = words[i].length();
                minIndex = i;
            }
        }
        return words[minIndex];
    }

    public static void main(String[] args) {
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        String licencePlate = "Ah71752";
        String[] words = new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
        String res = shortestCompletingWord.shortestCompletingWord(licencePlate, words);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
    }

}
