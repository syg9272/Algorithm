package com.ssafy.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2630_색종이만들기 {
	static int[][] map;
	static int[] cnt = new int[2];	// 0 : white, 1 : blue
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		binarySearch(0, 0, N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}

	private static void binarySearch(int x, int y, int n) {
		int half = n/2;
		boolean equal = true;
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if(map[i][j] != map[x][y]) {
					equal = false;
					break;
				}
			}
		}
		if(equal) {
			cnt[map[x][y]]++;
			return;
		}
		
		binarySearch(x, y, half);
		binarySearch(x, y + half, half);
		binarySearch(x + half, y, half);
		binarySearch(x + half, y + half, half);
	}
}
