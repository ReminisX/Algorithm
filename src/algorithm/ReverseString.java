package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    public String reverseWords(String s) {
        List<String> l = new ArrayList<>();
        int cutPoint = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c < 65 || (c > 90 && c < 97) || c > 122){
                String sub = s.substring(cutPoint, i+1);
                l.add(sub);
                cutPoint = i+1;
            }
        }

        if(cutPoint != s.length()-1){
            String sub = s.substring(cutPoint, s.length()-1);
            l.add(sub);
        }
        System.out.println(l);
        return " ";
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseWords("abc..def.hgj");
    }

}
