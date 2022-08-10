package com.ssafy.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};	// 우 -> 하 -> 좌 -> 상
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {	
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		int x1;
		int y1;
		int x2;
		int y2;
		
		for (int i = 0; i < R; i++) {
			x1 = 0;
			y1 = 0;
			x2 = N - 1;
			y2 = M - 1;
			while(true) {
				if(x1 >= x2 | y1 >= y2) break;
				rotation(x1, y1, x2, y2);
				x1++;
				y1++;
				x2--;
				y2--;
			}
		}
		for (int j = 0; j < N; j++) {			
			for (int i : map[j]) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void rotation(int x1, int y1, int x2, int y2) {
		int r = x1;
		int c = y1;
		int temp = map[x1][y1];
		for (int i = 0; i < 4; i++) {
			r += dx[i];
			c += dy[i];
			while(r >= x1 && r <= x2 && c >= y1 && c <= y2) {				
				map[r - dx[i]][c - dy[i]] = map[r][c];
				r += dx[i];
				c += dy[i];
			}
			r -= dx[i];
			c -= dy[i];
			if(i != 3) map[r][c] = map[r + dx[i + 1]][c + dy[i + 1]];
		}
		map[x1 + 1][y1] = temp;
	}
}
