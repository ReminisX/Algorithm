package algorithm;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        Integer X = x;
        String s = X.toString();
        char[] c = s.toCharArray();
        int index = 0;
        while(index < s.length()/2){
            if(c[index] != c[s.length()-1-index]){
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args){
        IsPalindrome I = new IsPalindrome();
        int x = 12321;
        boolean b = I.isPalindrome(x);
        System.out.println(b);
    }
}
