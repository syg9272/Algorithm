package com.ssafy.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static StringBuilder result = new StringBuilder();
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(result);
	}

	private static void quadTree(int x, int y, int size) {
		int n = map[x][y];
		boolean eq = true;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(map[i][j] != n) eq = false;
			}
		}
		if(eq) {
			result.append(n);
			return;
		}
		size /= 2;
		result.append("(");
		quadTree(x, y, size);
		quadTree(x, y + size, size);
		quadTree(x + size, y, size);
		quadTree(x + size, y + size, size);
		result.append(")");
	}
}
