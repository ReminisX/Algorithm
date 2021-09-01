package test;
import java.util.*;
/**
 * @author l
 */
public class Main2 {

    public int bestWs(int[] times, int[] ws){
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < times.length; i++) {
            if (times[i] > maxTime){
                maxTime = times[i];
            }
        }

        int[] choose = new int[ws.length];
        for (int i = 0; i < maxTime; i++) {
            int maxIndex = -1;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < ws.length; j++) {
                if (ws[j] > max && choose[j] != 1 && times[j] > i){
                    max = ws[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != -1){
                choose[maxIndex] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < choose.length; i++) {
            if (choose[i] == 1){
                res += ws[i];
            }else{
                res -= ws[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String l1 = in.nextLine();
        int T = Integer.parseInt(l1);
        for (int i = 0; i < T; i++) {
            String l2 = in.nextLine();
            String l3 = in.nextLine();
            String l4 = in.nextLine();

            int n = Integer.parseInt(l2);
            String[] s3 = l3.split(" ");
            int[] times = new int[n];
            for (int j = 0; j < n; j++) {
                times[j] = Integer.parseInt(s3[j]);
            }
            int[] ws = new int[n];
            String[] s4 = l4.split(" ");
            for (int j = 0; j < n; j++) {
                ws[j] = Integer.parseInt(s4[j]);
            }

            int res = new Main2().bestWs(times, ws);
            System.out.println(res);

        }

    }

}
