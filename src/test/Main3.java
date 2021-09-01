package test;

import java.util.Scanner;

/**
 * @author l
 */
public class Main3 {

    public boolean isSame(int x){
        int odd = 0;
        int even = 0;
        int sign = 0;
        while(x / 10 != 0){
            int temp = x - x/10*10;
            x = x / 10;
            if (sign == 0){
                even += temp;
                sign = 1;
            }else{
                odd += temp;
                sign = 0;
            }
        }
        if (sign == 0){
            even += x;
        }else{
            odd += x;
        }
        if (odd == even){
            return true;
        }else{
            return false;
        }
    }

    public int count(int L, int R){
        int res = 0;
        for (int i = L; i <= R; i++) {
            if (isSame(i)){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int L = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);
        int res = new Main3().count(L, R);
        System.out.println(res);
    }

}
