package algorithm;

/**
 * @author ZhangXiaodong
 * 给你一个由一些多米诺骨牌组成的列表dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b]和dominoes[j] = [c, d]等价的前提是a==c且b==d，或是a==d 且b==c。
 *
 * 在0 <= i < j < dominoes.length的前提下，找出满足dominoes[i] 和dominoes[j]等价的骨牌对 (i, j) 的数量。
 */
public class NumEquivDominoPairs {
    public boolean isEquals(int[][] dominoes, int i, int j){
        if(dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]){
            return true;
        }
        if(dominoes[i][1] == dominoes[j][0] && dominoes[i][1] == dominoes[j][0]){
            return true;
        }
        return false;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i+1; j < dominoes.length; j++) {
                if(isEquals(dominoes, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

}
