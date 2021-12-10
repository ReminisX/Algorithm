package algorithm;

public class SuperPow {

    public int eulerFomuler(int n){
        int ans = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                ans = ans / i * (i - 1);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        //表明  i * i <= n的数已经不满足了
        if (n > 1) {
            ans = ans / n * (n - 1);
        }
        return ans;
    }

    public int fastPow(int x, int n, int c){
        if (n == 0){
            return 1;
        }
        int t = 1;
        while(n != 0){
            if ((n & 1) == 1){
                t = (t*x)%c;
            }
            n >>= 1;
            x = (x%c) * (x%c);
        }
        return t;
    }

    public int superPow(int a, int[] b) {
        if(b.length == 0){
            return 1;
        }
        int c = 1337;
        int phi = 1140;
        // 计算指数的模
        int exp = 0;
        for(int i = 0; i < b.length; i++){
            exp = (10 * exp + b[i]) % phi;
        }
        // 计算a的次幂
        return fastPow(a, exp, c);
    }

    public static void main(String[] args) {
        SuperPow superPow = new SuperPow();
        System.out.println(superPow.superPow(2147483647, new int[]{2,0,0}));
    }

}
