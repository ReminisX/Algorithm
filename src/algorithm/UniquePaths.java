package algorithm;

public class UniquePaths {
	// �ݹ����
	public int uniquePaths(int m, int n) {
		if( m == 1) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		return this.uniquePaths(m-1, n) + this.uniquePaths(m, n-1);
    }
	// ��̬�滮
	public int uniquePaths2(int m, int n) {
		int[][] matrix = new int[m][n];
		// ��ʼ������
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = 0;
			}
		}
		// ��ʼ�����һ��
		for(int i = 0; i < m; i++) {
			matrix[i][n-1] = 1;
		}
		// ��ʼ�����һ��
		for(int j = 0; j < n; j++) {
			matrix[m-1][j] = 1;
		}
		// �Ե����ϼ���
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >=0; j--) {
				matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
			}
		}
		
		return matrix[0][0];
    }
	// ������⣺C(m+n-2 , m-1)
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
	// ����㷨
	public int C(int n,int m) {
		//����
		long son = 1;
		//��ĸ
		long mother = 1;
		// Ӧ��������Ļ����ʼ򻯼�����
		m = m > (n - m) ? (n - m) : m;
		for(int i = m;i > 0; i--) {
		    //����㻹�ǵ��������ȫ��������ʵ�֣���Ӧ�ûᷢ�� son �������� A(n��m)
			son *= n;
			mother *= i;
			n--;
		}
		return (int)(son / mother);
}
	
	// ������
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
