package algorithm;

public class HamingDistance {
	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x^y);
    }
}
