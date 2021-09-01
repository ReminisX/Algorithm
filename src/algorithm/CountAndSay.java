package algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author l
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String s = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int k = 1;
        String sub = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(i, i+1).equals(sub)){
                k++;
            }else{
                sb.append(k);
                sb.append(sub);
                k = 1;
                sub = s.substring(i, i+1);
            }
        }
        sb.append(k);
        sb.append(sub);
        return sb.toString();
    }
}
