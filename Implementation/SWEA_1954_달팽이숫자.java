package com.ssafy.recur;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			int r = 0;
			int c = 0;

			int num = 1;
			int idx = 0;
			
			while (num <= N*N) {
				if(idx == 4) idx %= 4;
				if(r >= 0 && r < N && c >= 0 && c < N && arr[r][c] == 0) {
					arr[r][c] = num;
					num++;
					r += dx[idx];
					c += dy[idx];
				}else {
					r -= dx[idx];
					c -= dy[idx];
					idx++;
					if(idx == 4) idx %= 4;
					r += dx[idx];
					c += dy[idx];
				}
			}
			//출력
			System.out.println("#" + test_case );
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
