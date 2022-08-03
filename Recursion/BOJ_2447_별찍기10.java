package com.ssafy.recur;

import java.util.Scanner;

public class BOJ_2447_별찍기10 {
	static char[][] star;
	static int range;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		star = new char[n][n];
		for (int i = 0; i < n; i++) {	// 배열에 * 채워넣기
			for (int j = 0; j < n; j++) {
				star[i][j] = '*';
			}
		}
		range = n;
		star(n, 0, 0);	// 해당 부분 * 지우는 함수
		for (char[] c : star) {
			System.out.println(c);
		}
	}
	static void star(int n, int i, int j) {
		if(n == 3) {
			erase(n, i, j);
			return;
		}
		erase(n, i, j);
		int t = j;	// 시작값
		for (int k = 1; k <= 9; k++) {
			if(j >= n + t) {	// j범위도 t를 이용해 평행이동
				i += n/3;
				j = t;	// t로 초기화
			}
			star(n/3, i, j);
			j += n/3;
		}
	}
	static void erase(int n, int i, int j) {
		for (int k = i + n/3; k < n - n/3 + i; k++) {	// 평행이동
			for (int r = j + n/3; r < n - n/3 + j; r++) {
				star[k][r] = ' ';
			}
		}
	}
}
