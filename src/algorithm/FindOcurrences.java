package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOcurrences {

    public boolean isSame(String a, String b){
        if (a.length() != b.length()){
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] t = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < t.length-2; i++) {
            if (isSame(t[i], first) && isSame(t[i+1], second)){
                res.add(t[i+2]);
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        FindOcurrences findOcurrences = new FindOcurrences();
        String text = "alice is a good girl she is a good student", first = "a", second = "good";
        String[] res = findOcurrences.findOcurrences(text, first, second);
        System.out.println(Arrays.toString(res));
    }

}
