package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CuttingRope {

    /**
     * 任何大于1的数都可由2和3相加组成（根据奇偶证明）
     * 因为2*2=1*4，2*3>1*5, 所以将数字拆成2和3，能得到的积最大
     * 因为2*2*2<3*3, 所以3越多积越大 时间复杂度O(n/3)，用幂函数可以达到O(log(n/3)), 因为n不大，所以提升意义不大，我就没用。 空间复杂度常数复杂度O(1)
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        // 边界值判断
        if (n == 1){
            return 1;
        }
        double max = 0;

        int k = n / 3;
        switch(n % 3){
            case 1:
                max = Math.pow(3, k-1)*4;
                break;
            case 2:
                max = Math.pow(3, k)*2;
                break;
            case 0:
                max = Math.pow(3, k);
                break;
        }
        return (int)max;
    }

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        System.out.println(cuttingRope.cuttingRope(10));
    }

}
