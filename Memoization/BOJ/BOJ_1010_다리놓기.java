// 조합의 점화식과 메모이제이션 활용
package com.ssafy.day0810;

import java.util.Scanner;

public class BOJ_1010_다리놓기 {
	static int cnt;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			arr = new int[M + 1][N + 1];
			cnt = 0;
			
			System.out.println(comb(M, N));
		}
		
	}
	private static int comb(int m, int n) {
		if(m == n || n == 0) {
			return 1;
		}
		if(arr[m][n] != 0) return arr[m][n];
		arr[m-1][n-1] = comb(m - 1, n - 1);
		arr[m-1][n] = comb(m - 1, n);
		arr[m][n] = arr[m - 1][n - 1] + arr[m - 1][n];
		return arr[m][n];
	}
}
