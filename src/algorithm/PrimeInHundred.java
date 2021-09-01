package algorithm;

import javax.sound.sampled.EnumControl;
import java.util.*;

/**
 * @author l
 */
public class PrimeInHundred {
    public List<Integer> getPrime(int num){
        List<Integer> res = new ArrayList<>();
        res.add(2);
        for (int i = 3; i < num; i++) {
            int m = (int)Math.sqrt(i);
            for (int j = 2; j < m; j++) {
                if(i % j == 0){
                    break;
                }
                if(i %j != 0 && j == m-1){
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 100;
        PrimeInHundred P = new PrimeInHundred();
        System.out.println(P.getPrime(num));
    }
}
