package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SevenStar {
	
	public boolean sevenStar(String[] strs) {
		char[] star = new char[3];  //行标记
		star[0] = 'B';
		star[1] = 'W';
		star[2] = 'T';
		
		int[][] matrix = new int[3][9];  //个数矩阵
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
		
		for(String s : strs) {
			// 第一行
			if(s.charAt(1) == 'B') {
				switch (s.charAt(0)) {
				case '1':
					matrix[0][0]++;
					break;
				case '2':
					matrix[0][1]++;
					break;
				case '3':
					matrix[0][2]++;
					break;
				case '4':
					matrix[0][3]++;
					break;
				case '5':
					matrix[0][4]++;
					break;
				case '6':
					matrix[0][5]++;
					break;
				case '7':
					matrix[0][6]++;
					break;
				case '8':
					matrix[0][7]++;
					break;
				case '9':
					matrix[0][8]++;
					break;
				}
			}
			// 第二行
			if(s.charAt(1) == 'W') {
				switch (s.charAt(0)) {
				case '1':
					matrix[1][0]++;
					break;
				case '2':
					matrix[1][1]++;
					break;
				case '3':
					matrix[1][2]++;
					break;
				case '4':
					matrix[1][3]++;
					break;
				case '5':
					matrix[1][4]++;
					break;
				case '6':
					matrix[1][5]++;
					break;
				case '7':
					matrix[1][6]++;
					break;
				case '8':
					matrix[1][7]++;
					break;
				case '9':
					matrix[1][8]++;
					break;
				}
			}
			// 第三行
			if(s.charAt(1) == 'T') {
				switch (s.charAt(0)) {
				case '1':
					matrix[2][0]++;
					break;
				case '2':
					matrix[2][1]++;
					break;
				case '3':
					matrix[2][2]++;
					break;
				case '4':
					matrix[2][3]++;
					break;
				case '5':
					matrix[2][4]++;
					break;
				case '6':
					matrix[2][5]++;
					break;
				case '7':
					matrix[2][6]++;
					break;
				case '8':
					matrix[2][7]++;
					break;
				case '9':
					matrix[2][8]++;
					break;
				}
			}
		}
		//  列和判断
		for(int j = 0; j < matrix[0].length; j++) {
			int l = 0;  //定义列和
			for(int i = 0; i < matrix.length; i++) {
				l += matrix[i][j];
			}
			if(l > 1) {
				return false;
			}
		}
		// 间距判断
		int count = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < 3; j++) {
				if(matrix[i][j] == 1 && matrix[i][j+3] == 1) {
					count++;
				}
				if(matrix[i][j+3] == 1 && matrix[i][j+6] == 1) {
					count++;
				}
			}
		}
		if(count != 4) {
			return false;
		}
		// 行和判断
		for(int i = 0; i < matrix.length; i++) {
			int sum = 0;
			for(int j = 0; j < matrix[0].length; j++) {
				sum += matrix[i][j];
			}
			if(sum < 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < time; i++) {
			String s = sc.nextLine();
	        String[] S = s.split(" ");
	        SevenStar Se = new SevenStar();
	        boolean b = Se.sevenStar(S);
	        if( b == true) {
	        	System.out.println("YES");
	        }else {
	        	System.out.println("NO");
	        }
		}
	}
	
}
