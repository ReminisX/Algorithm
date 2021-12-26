package algorithm;

public class MyPow {

    public double myPow(double x, int n) {
        if(n == 0 || x == 1){
            return 1;
        }
        boolean flag = false;
        if( n < 0){
            n = -n;
            flag = true;
        }
        double res = 1.0;
        while(n != 0){
            if((n & 1) == 1){
                res *= x;
            }
            n /= 2;
            x *= x;
        }
        return flag ? 1/ res : res;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double x = 2.0;
        int n = 10;
        System.out.println(myPow.myPow(x, n));

        int a = -2147483648;
        System.out.println("a is " + a);
        int b = Math.abs(a);
        System.out.println("b is " + b);
        int c = -a;
        System.out.println("c is " + c);
    }

}
