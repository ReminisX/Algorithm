package algorithm;

/**
 * @author l
 */
public class Clumsy {
    public int clumsy(int N) {
        int res = 0;
        int cycle = N / 4;
        int end = N % 4;
        for(int i = 0; i < cycle; i++){
            if(i == 0){
                res += N*(N-1)/(N-2) + (N-3);
                System.out.println(res);
                N = N - 4;
            }else{
                res += -N*(N-1)/(N-2) + (N-3);
                N = N - 4;
                System.out.println(res);
            }
        }

        if(end == 3){
            res += cycle == 0 ? 7 : -5;
        }else if(end == 2){
            res += cycle == 0 ? 2: -2;
        }else if(end == 1){
            res += cycle == 0 ? 1 : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Clumsy().clumsy(12);
        System.out.println(res);
    }
}
