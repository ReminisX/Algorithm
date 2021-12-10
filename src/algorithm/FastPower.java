package algorithm;

public class FastPower {

    public long fastPower(int x, int n) {
        if (n == 0){
            return 1;
        }
        long t = 1L;
        while(n != 0){
            if ((n & 1) == 1){
                t *= x;
            }
            n >>= 1;
            x *= x;
        }
        return t;
    }

    public long power(int x, int n){
        if (n == 0){
            return 1;
        }
        long c = power(x, n/2);
        if (n % 2 == 1){
            return c * c * x;
        }else{
            return c * c;
        }
    }

    public static void main(String[] args) {
        FastPower fastPower = new FastPower();
        int x = 3;
        int n = 10;
        Long a = System.currentTimeMillis();
        System.out.println(fastPower.fastPower(x, n));
        Long b = System.currentTimeMillis();
        System.out.println(Math.pow(x, n));
        Long c = System.currentTimeMillis();
        long fastPowerTime = b - a;
        System.out.println("快速幂算法运行时间:" + fastPowerTime);
        long mathPowerTime = c - b;
        System.out.println("算法库幂运算时间:" + mathPowerTime);
        System.out.println(fastPower.power(x, n));
    }

}
