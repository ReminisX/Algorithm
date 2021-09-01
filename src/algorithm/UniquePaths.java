package algorithm;

public class UniquePaths {
	// 递归求解
	public int uniquePaths(int m, int n) {
		if( m == 1) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		return this.uniquePaths(m-1, n) + this.uniquePaths(m, n-1);
    }
	// 动态规划
	public int uniquePaths2(int m, int n) {
		int[][] matrix = new int[m][n];
		// 初始化矩阵
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = 0;
			}
		}
		// 初始化最后一列
		for(int i = 0; i < m; i++) {
			matrix[i][n-1] = 1;
		}
		// 初始化最后一行
		for(int j = 0; j < n; j++) {
			matrix[m-1][j] = 1;
		}
		// 自底向上计算
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >=0; j--) {
				matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
			}
		}
		
		return matrix[0][0];
    }
	// 方程求解：C(m+n-2 , m-1)
	public int uniquePaths3(int m, int n) {
		long son = 1;
		long mother = 1;
		int up = m-1;
		int down = m+n-2;
		up = Math.min(up, (down - up));
		for(int i = up; i > 0; i--) {
			son *= down;
			mother *= i;
			down--;
		}
		return (int)(son/mother);
	}
	// 组合算法
	public int C(int n,int m) {
		//分子
		long son = 1;
		//分母
		long mother = 1;
		// 应用组合数的互补率简化计算量
		m = m > (n - m) ? (n - m) : m;
		for(int i = m;i > 0; i--) {
		    //如果你还记得上面的求全排列数的实现，你应该会发现 son 就是在求 A(n，m)
			son *= n;
			mother *= i;
			n--;
		}
		return (int)(son / mother);
}
	
	// 主程序
	public static void main(String[] args) {
		int m = 10;
		int n = 10;
		UniquePaths U = new UniquePaths();
		int k = U.uniquePaths3(m, n);
		int c = U.C(m+n-2, m-1);
		System.out.println(c);
		System.out.println(k);
	}
	
}
